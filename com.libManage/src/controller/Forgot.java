package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		String type="";
		String button=request.getParameter("btn");
		
		if (button.equals("Check by Username")) {
		String data=	request.getParameter("uname");
		type="u_name";
		
		httpSession.setAttribute("type", type);
		httpSession.setAttribute("data", data);
		response.sendRedirect("view/password.jsp");
		}
		
		else {
		String data=	request.getParameter("email");
		type="email";
		
		httpSession.setAttribute("type", type);
		httpSession.setAttribute("data", data);
		response.sendRedirect("view/password.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
