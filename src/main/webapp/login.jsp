<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
<h1>LOGIN</h1>
<form action="LoginServlet" method="post">
        <table>
        <tr> 
        	<td>name</td> 
        	<td><input type=text  name=TXTName ></td>
        </tr>
        <tr> 
        	<td>password</td> 
        	<td><input type=password  name=password ></td>
        </tr>
         <tr> 
        	<td><input type=submit  value=login ></td> 
        	<td><input type=reset ></td>
        </tr>
        </table>
    </form>
</body>
</html>