<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<title>welcome</title>
<link rel="stylesheet" type="text/css" href="JavaEEcss.css" >
<style type="text/css">
<link rel="stylesheet" href="JavaEEcss.css">
</style>

</head>
<body>
     
    <%@ page import="java.util.List" %>
    <%@ page import="modle.HibernateToDoListDAO" %>
    <%@ page import="modle.Item" %>
    <%@ page import="modle.User" %>
    <% HibernateToDoListDAO htd = HibernateToDoListDAO.getInstance();
    String user = (String) session.getAttribute("CurrUser");
    String password = (String) session.getAttribute("passcode");
    int id=htd.Userid(user, password);
    List<Item> list = htd.AllItems(id);
    Cookie []cks = request.getCookies();
    if (cks != null) {
			for (int i = 0; i < cks.length; i++) {
				String name = cks[i].getName();
				String value = cks[i].getValue();%>
				
				<div >
				<%if (name.equals("auth")) {
					out.println("hello " + value );
				}
				}}
				else{
					out.println("unrecognize user!");
				}%>
    			</div>
    			
    <div align="center">
        <table border="1" cellpadding="5" class="blueTable">
            <caption><h2>List of items</h2></caption>
            <tr>
                <th>Serial</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
                    <% for(Item item: list){
                    	out.println("<tr>\n"+"<td>"+item.getSerial()+"</td>"+"<td>"+item.getItemName()+"</td>"+"<td>"+item.getDescription()+"</td>"+"\n</tr>");}%>
        </table>
    <form action="ItemManager" method="post" name="add">
    <h4> Add mission:</h4>
    <INPUT TYPE="HIDDEN" NAME="FormName" VALUE="add">
    <input type="text" placeholder="Serial" name="serial"/>
    <input type="text" placeholder="Name" name="name"/>
    <input type="text" placeholder="Description" name="description"/>
    <p class="submit"><input type="submit" name="commit" value="add"></p>
    </form>

    <form action="ItemManager" method="post" name="delete">
    <h4> DELETE mission:</h4>
    <INPUT TYPE="HIDDEN" NAME="FormName" VALUE="delete">
    <input type="text" placeholder="Serial" name="serial"/>
    <p class="submit"><input type="submit" name="commit" value="delete"></p>
    </form>

    <form action="ItemManager" method="post" name="update">
    <h4> Update mission:</h4>
    <INPUT TYPE="HIDDEN" NAME="FormName" VALUE="update">
    <input type="text" placeholder="Serial" name="serial"/>
    <input type="text" placeholder="Name" name="name"/>
    <input type="text" placeholder="Description" name="description"/>
    <p class="submit"><input type="submit" name="commit" value="update"></p>
    </form>    
    <a href="./index.jsp">
   	<button>Log Out</button>
	</a>
    </div>
</body>
</html>