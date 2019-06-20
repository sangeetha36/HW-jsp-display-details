package com.lti.employee.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDao {
	
	public Employee fechEmployee(int empno) throws EmpException {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null; 
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
   
			String sql = "select * from emp where empno=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, empno);
			
			rs=stmt.executeQuery();
			rs.next();
			
				Employee e=new Employee();
				e.setEmpno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getString(3));
				e.setMgr(rs.getInt(4));
				e.setHiredate(rs.getString(5));
				e.setSal(rs.getDouble(6));
				e.setComm(rs.getDouble(7));
				e.setDeptno(rs.getInt(8));
				return e;
				}
		
		catch(ClassNotFoundException e) {
			throw (new EmpException("Class Not Found"));
		}
		catch(SQLException e) {
			throw (new EmpException("SQL Exception"));
		}
		finally {
			try {
				conn.close();
				}
			catch(Exception e)
			{
				throw (new EmpException("Exception while closing "));
			}
			
		}
	
		
	
}

}
