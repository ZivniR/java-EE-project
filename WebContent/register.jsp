<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<title>Sign Up Form</title>
<link rel="stylesheet" type="text/css" href="JavaEEcss.css" >
<style type="text/css">
<link rel="stylesheet" href="JavaEEcss.css">
</style>

</head>
<body>  
 <a href="./index.jsp">
   	<button>Back</button>
	</a>
<div align="center">
 <h2> Registration</h2>
  <form action="TaskManager" method="post">
    <div>
      <h4>Account</h4>
        <input type="text" placeholder="Full Name" name="name"/>
        <input type="text" placeholder="ID" name="id"/>
      
        <input type="text" placeholder="Password" name="password"/>
    </div>
    <div >
        <h4>Date of Birth</h4>
            <input type="text" placeholder="DD"/>
            <input type="text" placeholder="MM"/>
            <input type="text" placeholder="YYYY" name="age"/>
    </div>
    <div>
      <h4>Terms and Conditions</h4>
      <div>
        <input type="checkbox" id="terms"/>
        <label for="terms">I accept the terms and conditions for signing up to this service, and hereby confirm I have read the privacy policy.</label>
        <p class="submit"><input type="submit" name="commit" value="register"></p>
      </div>
    </div>
  </form>
</div>

</body>

</html>