package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modle.HibernateToDoListDAO;
import modle.ToDoListHibernateExceptions;
import modle.User;
@ WebServlet("/TaskManager")
public class TaskManager extends HttpServlet {
	PrintWriter out;
	/*
	 * Contractor
	 */
	public TaskManager() {
		super();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet (HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		response.setContentType("text/html");  
		out = response.getWriter();
		String name = request.getParameter("name");
		System.out.println(name);
		String _id = request.getParameter("id");
		System.out.println(_id);
		String password = request.getParameter("password");
		System.out.println(password);
		String _age = request.getParameter("age");
		System.out.println(_age);
		int age = Integer.parseInt(_age);
	    age=2018-age;
	    int id = Integer.parseInt(_id);
	    User user = new User(id,name,age,password);
	     HibernateToDoListDAO htd = HibernateToDoListDAO.getInstance();
	     try {
			htd.AddUser(user);
		} catch (ToDoListHibernateExceptions e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    try {
		if(htd.ValidUser(name,password)){  
		    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		    rd.forward(request,response);  
		}  
		else{  
		    out.print("Somthing went worng please try again");  
		    RequestDispatcher rd=request.getRequestDispatcher("register.jsp");  
		    rd.include(request,response);  
		}
	} catch (ToDoListHibernateExceptions e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	}
	}

	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		response.setContentType("text/html");  
		out = response.getWriter();
		String name = request.getParameter("name");
		String _id = request.getParameter("id");
	    String password = request.getParameter("password");
	    String _age = request.getParameter("age");
	    int age = Integer.parseInt(_age);
	    age=2018-age;
	    int id = Integer.parseInt(_id);
	    User user = new User(id,name,age,password);
	     HibernateToDoListDAO htd = HibernateToDoListDAO.getInstance();
	     try {
			htd.AddUser(user);
		} catch (ToDoListHibernateExceptions e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    try {
		if(htd.ValidUser(name,password)){  
		    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		    rd.forward(request,response);  
		}  
		else{  
		    out.print("Somthing went worng please try again");  
		    RequestDispatcher rd=request.getRequestDispatcher("register.jsp");  
		    rd.include(request,response);  
		}
	} catch (ToDoListHibernateExceptions e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
          
    out.close();}


}
