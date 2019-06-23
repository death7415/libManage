package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginDataServicePovider;


@WebServlet("/Form1")
public class Form1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hSession=request.getSession();
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		String status=LoginDataServicePovider.checkUser(uname, pass);
		if(status.equals("pass")) {
			hSession.setAttribute("username", uname);
			response.sendRedirect("view/welcome.jsp");	
		}else {
			if(status.equals("fail")) {
				out.println("<html>"
						+ "<body>"
						+ "<b>Invalid UserName and Password <a href='index.html'> Login Page</a> or <a href='view/forgot.html'> Forgot Password</a> </b>"
						+ "</body>"
						+ "</html>");
			}else {
				out.println("<html>"
						+ "<body>"
						+ "<b>Connection Problem Or User do not Existed <a href='index.html'> Login Page</a> or <a href='view/forgot.html'> Forgot Password</a> </b>"
						+ "</body>"
						+ "</html>");
			}
		}
		
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
