package com.emp.crud.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.crud.DAO.EmployeeDAO;

import java.io.IOException; 
import java.sql.SQLException; 
import javax.servlet.*; 
import javax.servlet.annotation.*; 
import javax.servlet.http.*; 
  
@WebServlet(name = "deleteUser", value = "/deleteUser") 
public class DeleteUser extends HttpServlet { 
    protected void
    processRequest(HttpServletRequest request, 
                   HttpServletResponse response) 
        throws ServletException, IOException 
    { 
        response.setContentType("text/html;charset=UTF-8"); 
    } 
    
   
    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
        throws ServletException, IOException 
    { 
        processRequest(request, response); 
        
        
        String userId = request.getParameter("id"); 

        int id = Integer.parseInt(userId); 
        try { 
          
           EmployeeDAO .deleteUser(id); 
        } 
        catch (SQLException e) { 
            e.printStackTrace(); 
        } 

        response.sendRedirect("ViewServlet?page=1"); 
    } 
  
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
        throws ServletException, IOException 
    { 
    } 
}