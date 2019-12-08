<%--
  Created by Alim Momin
  Date: 2019-11-20
  Time: 3:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="../css/custom.css" rel="stylesheet" type="text/css">
  <title>Project</title>
</head>
<body>
  <fieldset class="mainFieldset">
    <legend align="center">Account Registration Form</legend>

  <table style="with: 50%">
    <tr>
      <td>Username</td>
      <td><input <% if(request.getAttribute("dbUsername")!=null){ %>
              disabled
              <% }%> id="main_username" type="text" name="username" placeholder="Enter UserName" value="${requestScope.dbUsername}" required/></td>
    </tr>
    <tr>
      <td>Password</td>
      <td>
          <input name="password" id="main_password" type="password" value="${requestScope.password}" />
      </td>

    </tr>
<tr>
  <td>Confirm Password</td>
  <td>
      <input type="password" name="confirm_password" id="confirm_password" value="${requestScope.password}"/>
      <span id='message'></span>
  </td>
</tr>
     <tr>
      <td>First Name</td>
      <td><input <% if(request.getAttribute("firstName")!=null){ %>
              disabled
              <% }%> id="main_firstName" type="text" name="firstName1" placeholder="Enter First Name" value="${requestScope.firstName}" required/></td>
    </tr>
    <tr>
      <td>Last Name</td>
      <td><input <% if(request.getAttribute("lastName")!=null){ %>
              disabled
              <% }%> id="main_lastName" type="text" name="lastName" placeholder="Enter Last Name"value="${requestScope.lastName}" required/></td>
    </tr>
    <tr>
      <td>Phone Number</td>
      <td><input id="main_phone" type="number" name="phone" placeholder="Enter Phone Number" value="${requestScope.phone}"/></td>
    </tr>
    <tr>
      <td>Address</td>
      <td><input id="main_address" type="text" name="address" placeholder="Enter Address" value="${requestScope.address}"required/></td>
    </tr>

    <tr>
      <td>City</td>
      <td><input id="main_city" type="text" name="city" placeholder="Enter City" value="${requestScope.city}"required/></td>
    </tr>

    <tr>
      <td>Job Title</td>
      <td><input id="main_jobTitle" type="text" name="jobTitle" placeholder="Job Title" value="${requestScope.jobTitle}"/></td>
    </tr>

    <tr>
      <td>Company</td>
      <td><input id="main_company" type="text" name="company" placeholder="Company"
      value="${requestScope.company}"/></td>
    </tr>

    <tr>
        <td>Gender</td>
      <td>
        <select name="gender">
          <option value="">--Select--</option>
          <option value="male">Male</option>
          <option value="female">Female</option>
        </select>
      </td>

    </tr>

  </table>
      <p hidden="hidden">  <textarea id="jsonResponse" rows="100" cols="100" ><%=request.getAttribute("resp")%></textarea></p>
      <center><button id="myBtn" class="enableOnInput">Confirm</button>
  <br>
      <a href="/updateUserInfo.jsp">Update/ Delete Account</a>
    <p>

      <% if(request.getAttribute("message")!=null){ %>
      <%= request.getAttribute("message")%>
     <% }%>
<p style="color: red">
      <% if(request.getAttribute("error")!=null){ %>
      <%= request.getAttribute("error")%>
      <% }%>
    </p>

    </p>
  </center>
</fieldset>


<div id="myModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content modalFieldset">
        <span class="close">&times;</span>
        <h2>Confirmation Page</h2>
        <form action="registration" method="post">

                <table style="with: 50%">
                    <input hidden type="text" name="flag" value="${requestScope.flag}" />
                    <tr>
                        <td>Username</td>
                        <td><input
                                id="modal_username" type="text" name="username" placeholder="Enter UserName" required

                                <% if(request.getAttribute("dbUsername")!=null){ %>
                                readonly="readonly"
                                <% }%>/></td>
                    </tr>
                    <tr hidden="hidden">
                        <td>Password</td>
                        <td>
                            <input id="modal_password" name="password" type="text" />
                        </td>

                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><input
                                <% if(request.getAttribute("firstName")!=null){ %>
                                readonly="readonly"
                                <% }%>
                                id="modal_firstName" type="text" name="firstName" placeholder="Enter First Name" required/></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input
                                <% if(request.getAttribute("lastName")!=null){ %>
                                readonly="readonly"
                                <% }%>
                                id="modal_lastName" type="text" name="lastName" placeholder="Enter Last Name" required/></td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><input id="modal_phone"  type="number" name="phone" placeholder="Enter Phone Number" /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input id="modal_address"  type="text" name="address" placeholder="Enter Address" required/></td>
                    </tr>

                    <tr>
                        <td>City</td>
                        <td><input id="modal_city"  type="text" name="city" placeholder="Enter City" required/></td>
                    </tr>

                    <tr>
                        <td>Job Title</td>
                        <td><input id="modal_jobTitle"  type="text" name="jobTitle" placeholder="Job Title" /></td>
                    </tr>

                    <tr>
                        <td>Company</td>
                        <td><input id="modal_company"  type="text" name="company" placeholder="Company"/></td>
                    </tr>

                    <tr>
                        <td>Gender</td>
                        <td>
                            <select name="gender">
                                <option value="">--Select--</option>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </select>
                        </td>

                    </tr>

                </table>

            <center> <input type="submit" name="submit" value="Submit"/></center>
           </form>
    </div>

</div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="../Js/custom.js"></script>
</body>

</html>
