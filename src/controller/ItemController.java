package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modle.HibernateToDoListDAO;
import modle.ToDoListHibernateExceptions;
import modle.User;
@ WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	PrintWriter out;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Contractor
	 */
	public ItemController(){
		super();
	}
	
	

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		response.setContentType("text/html");  
		out = response.getWriter();
		String name = request.getParameter("login");
	    String password = request.getParameter("password");
	    System.out.println(name);
	    System.out.println(password);
	     HibernateToDoListDAO htd = HibernateToDoListDAO.getInstance();
	     HttpSession session1 =request.getSession(true);
	     User user = new User(name,password);
	     session1.setAttribute("CurrUser", name);
	     session1.setAttribute("passcode", password);
		 Cookie ck = new Cookie("auth", name);
		 ck.setMaxAge(600);
	     System.out.println(session1.getAttribute("CurrUser"));
	     
    try {
		if(htd.ValidUser(name,password)){  
			response.addCookie(ck);
			RequestDispatcher rd=request.getRequestDispatcher("wellcome.jsp");  
		    rd.forward(request,response);  
		}  
		else{  
		    out.print("Sorry username or password error");  
		    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		    rd.include(request,response);  
		}
	} catch (ToDoListHibernateExceptions e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
          
    out.close();}
}
