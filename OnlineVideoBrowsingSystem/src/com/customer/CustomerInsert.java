package com.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomerInsert")
public class CustomerInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		String fname = request.getParameter("Fname");
		String lname = request.getParameter("Lname");
		String date = request.getParameter("DOB");
		String Gender = request.getParameter("gender");
		String Email = request.getParameter("mail");
		String uname = request.getParameter("Uname");
		String pwd = request.getParameter("pwd");
		String pkg = request.getParameter("Package");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.insert(fname, lname, date, Gender, Email, uname, pwd, pkg);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("LoginAsUser.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("CreateAccount.jsp");
			dis2.forward(request, response);
		}
	}

}
