package controller;

import java.io.IOException;
import java.util.Random;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegisterFormServiceProvider;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterFormServiceProvider registerFormServiceProvider=new RegisterFormServiceProvider();
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String phoneNumber=request.getParameter("pnum");
		String fm_name=request.getParameter("f-mname");
		
		String check_Copydata=RegisterFormServiceProvider.checkData(email, phoneNumber);
		
		if(check_Copydata.equals("email")) {
			
			response.sendRedirect("view/emailcheck.html");
		}else {
			if(check_Copydata.equals("phone")) {
							
			
				response.sendRedirect("view/phonecheck.html");
			
			
			}else {
				String unique_id="";
				Random ran=new Random();
				long random=(long)ran.nextInt()*(787+99);
				if(random <0) {random=(long)-1 * random;}
				unique_id=String.valueOf(random);
				System.out.println(random);
				registerFormServiceProvider.insertRegisterData(uname, email, password, phoneNumber, fm_name,unique_id);
				request.setAttribute("uid", unique_id);
				request.getRequestDispatcher("view/register-info.jsp").forward(request, response);
				
				
			}
		}
		
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
