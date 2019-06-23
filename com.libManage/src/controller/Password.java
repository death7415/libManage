package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PasswordRecoveryServiceProvider;


@WebServlet(asyncSupported = true, urlPatterns = { "/Password" })
public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession();
		PrintWriter out=response.getWriter();
		String type=(String)httpSession.getAttribute("type");	
		String data=(String)httpSession.getAttribute("data");
		String fm_name=request.getParameter("fm_name");
		String uid=request.getParameter("uid");
	
				
		
		ArrayList<String>aList=PasswordRecoveryServiceProvider.getPassword(type,data, fm_name, uid);
		httpSession.setAttribute("array", aList);
		response.sendRedirect("view/showPassword.jsp");
		//System.out.println(aList);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
