
package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

       response.setContentType("text/html;charset=UTF-8");

       PrintWriter out = response.getWriter();

       out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>CI/CD Test Demo</title>");
       out.println("</head>");
       out.println("<body>");
       out.println("<h1>CI/CD Demo - Version 2 - Tests Passed</h1>");
       out.println("<p>This version should deploy only when tests pass.</p>");
       out.println("</body>");
       out.println("</html>");
   }
}
