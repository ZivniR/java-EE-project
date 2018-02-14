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
import modle.Item;
import modle.ToDoListHibernateExceptions;
import modle.User;
@ WebServlet("/ItemManager")
public class ItemManager extends HttpServlet{
	PrintWriter out;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Contractor
	 */
	public ItemManager() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		response.setContentType("text/html");  
		out = response.getWriter(); 
		HttpSession session2 =request.getSession(true); 
		String step = request.getParameter("FormName");
		System.out.println(step);
		HibernateToDoListDAO htd = HibernateToDoListDAO.getInstance(); 
		switch (step) {
		case "add":
			{
			String name = (String) session2.getAttribute("CurrUser");
			String password = (String) session2.getAttribute("passcode");
			System.out.println("pass="+ password +"user:"+ name);
			String _serial = request.getParameter("serial");
			int serial = Integer.parseInt(_serial);
			String itemname = request.getParameter("name");
			String description = request.getParameter("description");
			try {
				User user = htd.ThisUser(name, password);
				Item item = new Item(serial,itemname,description,user);
				htd.AddItem(item);
			} catch (ToDoListHibernateExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    RequestDispatcher rd=request.getRequestDispatcher("wellcome.jsp");  
		    rd.forward(request,response);  
		    break;
			
			}
		case "delete":
			{
			String _serial = request.getParameter("serial");
			int serial = Integer.parseInt(_serial);
			try {
				htd.DeleteItem(serial);
			} catch (ToDoListHibernateExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    RequestDispatcher rd=request.getRequestDispatcher("wellcome.jsp");  
		    rd.forward(request,response);  
		    break;
			}
			
		case "update":
			{
				String name = (String) session2.getAttribute("CurrUser");
				String password = (String) session2.getAttribute("passcode");
				System.out.println("pass="+ password +"user:"+ name);
				String _serial = request.getParameter("serial");
				int serial = Integer.parseInt(_serial);
				String itemname = request.getParameter("name");
				String description = request.getParameter("description");
				try {
					User user = htd.ThisUser(name, password);
					Item item = new Item(serial,itemname,description,user);
					htd.UpdateItem(item);
				} catch (ToDoListHibernateExceptions e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    RequestDispatcher rd=request.getRequestDispatcher("wellcome.jsp");  
			    rd.forward(request,response);  
			    break;			
			}
		
		}
	}


}
