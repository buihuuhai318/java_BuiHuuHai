package com.example.team1.controller.payment;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

@WebServlet(name = "MoMoServlet", value = "/MoMoServlet")
public class MoMoServlet extends HttpServlet {

    private static final String MERCHANT_CODE = "MOMO9ACF20220912";
    private static final String ACCESS_KEY = "RzpdNBArbRO75z7C";
    private static final String SECRET_KEY = "xdnhmqcKf65mZ18IPZMUJTbuM5QhgCyO";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
