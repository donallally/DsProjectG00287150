<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Interrim</title>
</head>
<body>
<form action="PollServlet" method = "get">
<input type="hidden" name="request-type" value="Poll">
<label>Job Number: ${ jobNumber } </label><br>
<label>Refresh: ${ timer }</label>
</form>
</body>
</html>