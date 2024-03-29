package com.emp.crud.Controller;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.SQLException; 
import javax.servlet.*; 
import javax.servlet.annotation.*; 
import javax.servlet.http.*;

import com.emp.crud.DAO.EmployeeDAO;
import com.emp.crud.DTO.Employee; 
  
@WebServlet(name = "updateUser", value = "/updateUser") 
public class UpdateUser extends HttpServlet { 
   
    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
        throws ServletException, IOException 
    { 
        PrintWriter out = response.getWriter(); 
        

        String userId = request.getParameter("id"); 
        
       
        int id = Integer.parseInt(userId); 
        Employee user = null;
		try {
			user = EmployeeDAO.getUserById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		out.println("<h2>Edit User Account</h2>"); 
		out.print( 
		    "<form action='patchUser' method='post'>"); 
		out.print("<table>"); 
		out.print( 
		    "<tr><td></td><td><input type='hidden' name='id' value='"
		    + user.getId() + "'/></td></tr>"); 
		out.print( 
		    "<tr><td>Name:</td><td><input type='text' name='name' value='"
		    + user.getName() + "'/></td></tr>"); 
		out.print( 
		    "<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>"); 
		out.print("</table>"); 
		out.print("</form>"); 
	
		out.close(); 
    } 
  
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
        throws ServletException, IOException 
    { 
    } 
}