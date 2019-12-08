package com.groupproject.servlets;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/UpdateUserInfo2")
public class UpdateUserInfo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation1= request.getParameter("submit");
        String operation2= request.getParameter("delete");
        if(operation1!=null){
            try {

                URL url = new URL("http://localhost:8089/api/customerRecords/" +request.getParameter("username"));
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");


                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP Error code : "
                            + conn.getResponseCode());
                }

                String output = "";

                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    output += sc.nextLine();
                }
                request.setAttribute("resp", output.trim());
                request.setAttribute("flag", "update");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                System.out.println("Secdonf " + output);

                conn.disconnect();

            } catch (Exception e) {
                System.out.println("Exception in NetClientGet:- " + e);
            }

        }else if(operation2!=null){
            try {

                URL url = new URL("http://localhost:8089/api/deleteCustomer/" +request.getParameter("username"));
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("DELETE");
                conn.setRequestProperty("Accept", "application/json");


                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP Error code : "
                            + conn.getResponseCode());
                }

                String output = "";

                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    output += sc.nextLine();
                }
                request.setAttribute("resp", output.trim());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                System.out.println("Secdonf " + output);

                conn.disconnect();

            } catch (Exception e) {
                System.out.println("Exception in NetClientGet:- " + e);
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
