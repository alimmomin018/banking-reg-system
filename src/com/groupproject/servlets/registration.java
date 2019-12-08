package com.groupproject.servlets;

import com.groupproject.util.DbConnection;
import com.groupproject.util.GenerateAccountNumber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.Scanner;

@WebServlet("/registration")
public class registration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("flag");
        System.out.println("Flag is "+operation);
        if(operation.length()<1){
            final String PUT_PARAMS = "{\n" + "\"customerId\":" + "\"" + request.getParameter("username") + "\""  + ",\r\n" +
                    "\"firstName\":" + "\"" +  request.getParameter("firstName") + "\"" +  ",\r\n" +
                    "\"lastName\":" + "\"" +  request.getParameter("lastName") + "\"" +  ",\r\n" +
                    "\"address\":" + "\"" +  request.getParameter("address") +"\"" +  ",\r\n" +
                    "\"city\":" + "\"" +  request.getParameter("city") +"\"" +  ",\r\n" +
                    "\"company\":" + "\"" +  request.getParameter("company") +"\"" +  ",\r\n" +
                    "\"jobTitle\":" + "\"" +  request.getParameter("jobTitle") +"\"" +  ",\r\n" +
                    "\"phoneNumber\":" + "\"" + request.getParameter("phone") +"\"" +  ",\r\n" +
                    "\"password\":" + "\"" + request.getParameter("password") +"\"" +  ",\r\n" +
                    "\"gender\":" + "\"" + request.getParameter("gender")+ "\"" + "}";
            System.out.println(PUT_PARAMS);
            URL obj = new URL("http://localhost:8089/api/addNewCustomers");
            HttpURLConnection putConnection = (HttpURLConnection) obj.openConnection();
            putConnection.setRequestMethod("POST");
            putConnection.setRequestProperty("Content-Type", "application/json");
            putConnection.setDoOutput(true);
            OutputStream os = putConnection.getOutputStream();
            os.write(PUT_PARAMS.getBytes());
            os.flush();
            os.close();
            int responseCode = putConnection.getResponseCode();
            System.out.println("PUT Response Code :  " + responseCode);
            System.out.println("PUT Response Message : " + putConnection.getResponseMessage());
            request.setAttribute("message", "Hey "+request.getParameter("username")+" Your Record Has been added successfully");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        else if(operation.length()>0){
            final String POST_PARAMS = "{\n" + "\"customerId\":" + "\"" + request.getParameter("username") + "\""  + ",\r\n" +
                    "\"firstName\":" + "\"" +  request.getParameter("firstName") + "\"" +  ",\r\n" +
                    "\"lastName\":" + "\"" +  request.getParameter("lastName") + "\"" +  ",\r\n" +
                    "\"address\":" + "\"" +  request.getParameter("address") +"\"" +  ",\r\n" +
                    "\"city\":" + "\"" +  request.getParameter("city") +"\"" +  ",\r\n" +
                    "\"company\":" + "\"" +  request.getParameter("company") +"\"" +  ",\r\n" +
                    "\"jobTitle\":" + "\"" +  request.getParameter("jobTitle") +"\"" +  ",\r\n" +
                    "\"phoneNumber\":" + "\"" + request.getParameter("phone") +"\"" +  ",\r\n" +
                    "\"password\":" + "\"" + request.getParameter("password") +"\"" +  ",\r\n" +
                    "\"gender\":" + "\"" + request.getParameter("gender")+ "\"" + "}";
            System.out.println(POST_PARAMS);
            URL obj = new URL("http://localhost:8089/api/updateCustomer");
            HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("PUT");
            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setDoOutput(true);
            OutputStream os = postConnection.getOutputStream();
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();
            System.out.println("Here at the end");
            int responseCode = postConnection.getResponseCode();
            System.out.println("POST Response Code :  " + responseCode);
            System.out.println("POST Response Message : " + postConnection.getResponseMessage());
            if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        postConnection.getInputStream()));
                String inputLine;
                StringBuffer resp = new StringBuffer();

                while ((inputLine = in .readLine()) != null) {
                    resp.append(inputLine);
                } in .close();
                // print result
                request.setAttribute("message", "Hey "+request.getParameter("username")+" Your Record Has been updated successfully");
                request.getRequestDispatcher("index.jsp").forward(request, response);

            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
