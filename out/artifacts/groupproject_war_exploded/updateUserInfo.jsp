<%--
  Created by IntelliJ IDEA.
  User: gbada
  Date: 2019-11-20
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Java Assignment</title>
    <link href="../css/custom.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="UpdateUserInfo2" method="post" novalidate>
<fieldset class="mainFieldset">
    <legend align="center">Update Account Information</legend>

    <table style="with: 50%">
        <tr>
            <td>Username</td>
            <td><input id="main_username" type="text" name="username" placeholder="Enter UserName" required/></td>
        </tr>

    </table>
    <p></p>
    <center><input type="submit" name="submit" value="Submit"/>
        <input type="submit" name="delete" value="Delete"/> <a href="/">Back</a>
        <br>


        <p style="color: red">
            <% if(request.getAttribute("error")!=null){ %>
            <%= request.getAttribute("error")%>
            <% }%>
        </p>


    </center>

</fieldset>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../Js/custom.js"></script>
</body>
</html>
