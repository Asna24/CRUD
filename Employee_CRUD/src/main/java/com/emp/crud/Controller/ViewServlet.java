package com.emp.crud.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.crud.DAO.EmployeeDAO;
import com.emp.crud.DTO.Employee;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add new Employee</a>");
		out.println("<h1>Employee List</h1>");
		try {
			List<Employee> l1=EmployeeDAO.getEmployees();
		
		out.print("<table border='1' width='100%'>");
		out.print("<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit></th><th>Delete</th></tr>");
		for(Employee c:l1) 
		{
		out.print("<tr><td>"+c.getId()+"</td><td>"+c.getName()+"</td><td>"+c.getPwd()+"</td><td>"+c.getEmail()+"</td><td>"+c.getCtry()+"</td><td><a href='EditSevlet'>Edit</a></td><td><a href='DeleteServlet'>Delete</a></td></tr>");
		
		}
		
		out.print("</table>");
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
