package com.lti.employee.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	EmployeeDao eo=new EmployeeDao();
	Employee e = new Employee();
	int empno;
    empno = Integer.parseInt(request.getParameter("empno"));
	
	
	try {
	
		e = eo.fechEmployee(empno);
		
		HttpSession session=request.getSession();
		session.setAttribute("Employee", e);
		response.sendRedirect("employee.jsp");
	
	
	}
	catch(EmpException e1)
	{
		throw new EmpException("Problem encounterd with EmployeeServlet with DAO",e1);
	}
}


}