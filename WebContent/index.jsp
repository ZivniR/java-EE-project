<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<title> Ziv Nir </title>
<link rel="stylesheet" type="text/css" href="JavaEEcss.css" >
<style type="text/css">
<link rel="stylesheet" href="JavaEEcss.css">
</style>

</head>
<body>
<%String name= (String)session.getAttribute("login");
session.setAttribute("name", name); 
 String password= (String)session.getAttribute("password");
session.setAttribute("password", password);%>   
    <div class="container">
  <div class="login">
    <h1>Login</h1>
    <form action="ItemController" method="post">
      <p><input type="text" name="login" value="" placeholder="Username or Email"></p>
      <p><input type="password" name="password" value="" placeholder="Password"></p>
      <p class="remember_me">
        <label>
         <label>
          <input type="checkbox" name="remember_me" id="remember_me">
          Remember me on this computer
        </label>
        </label>
      </p>
      <p class="submit"><input type="submit" name="commit" value="Login"></p>
</form>
</div>
 
  <div class="login-help">
    <p>Not registered? <a href="./register.jsp">Click here to register!</a>.</p>
  </div>
</div>
</body>
</html>

