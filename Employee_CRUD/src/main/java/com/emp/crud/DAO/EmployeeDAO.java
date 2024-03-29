package com.emp.crud.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.emp.crud.DTO.Employee;

public class EmployeeDAO {
	public static Connection getConnection() throws Exception   {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/emp_crud";
		Connection con=DriverManager.getConnection(url, "root","admin");
	return con;
	}
	
  public static int saveEmployee(Employee emp)
{
	int status=0;
	Connection con;
	try {
		con = EmployeeDAO.getConnection();
		PreparedStatement stmt=con.prepareStatement("insert into emp_table(name,password,email,country)values(?,?,?,?)");
		stmt.setString(1,emp.getName());
		stmt.setString(2,emp.getPwd());
		stmt.setString(3,emp.getEmail());
		stmt.setString(4,emp.getCtry());
		status=stmt.executeUpdate();
		con.close();
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	

return status;

}
  
  public static List<Employee> getEmployees() throws Exception {
	
	  ArrayList<Employee> l1=new ArrayList<Employee>();
	  Connection con = EmployeeDAO.getConnection();
	 PreparedStatement stmt=con.prepareStatement("select * from emp_table");
	 ResultSet rs=stmt.executeQuery();
	 while(rs.next()) {
		 Employee e1=new Employee();
		 e1.setId(rs.getInt(1));
		 e1.setName(rs.getString(2));
		 e1.setPwd(rs.getString(3));
		 e1.setEmail(rs.getString(4));
		 e1.setCtry(rs.getString(5));
		 l1.add(e1);
	 }
	 return l1;
  }

  public static int deleteUser(int id) throws SQLException 
  { 
      int result = 0; 
      
      Connection con;
      try {
  		con = EmployeeDAO.getConnection();
   
      PreparedStatement preparedStatement 
          = con.prepareStatement( 
              "delete from USER where id =?"); 
      
      preparedStatement.setInt(1, id); 
      
   
      result = preparedStatement.executeUpdate(); 
   
      con.close(); 
      } catch (Exception e) {
    		
  		e.printStackTrace();
  	}
      return result; 
  } 

  public static int updateUser(Employee user) 
	        throws SQLException 
	    { 
	        int result = 0; 
	        
	        Connection con;
	        try {
	    		con = EmployeeDAO.getConnection();
	        PreparedStatement preparedStatement 
	            = con.prepareStatement( 
	                "update user set username=?,password=? where id=?"); 
	        
	        preparedStatement.setString(1, user.getName()); 
	        preparedStatement.setString(2, user.getPwd()); 
	        
	        result = preparedStatement.executeUpdate(); 
	        
	 
	        con.close(); 
	        } catch (Exception e) {
	    		
	      		e.printStackTrace();
	      	}
	        return result; 
	    }
  public static Employee getUserById(int id) 
	        throws Exception 
	    { 
	      
	       Employee user = new Employee(); 
	        
	        Connection connect = EmployeeDAO.getConnection(); 
	        
	        PreparedStatement preparedStatement 
	            = connect.prepareStatement( 
	                "select * from Employee where id=?"); 
	        
	       
	        preparedStatement.setInt(1, id); 
	        
	        
	        ResultSet resultSet 
	            = preparedStatement.executeQuery(); 
	        
	        if (resultSet.next()) { 
	             
	            user.setId(resultSet.getInt(1)); 
	            user.setName(resultSet.getString(2)); 
	            user.setPwd(resultSet.getString(3)); 
	        } 
	     
	        connect.close(); 
	        return user; 
	    }
 
}
