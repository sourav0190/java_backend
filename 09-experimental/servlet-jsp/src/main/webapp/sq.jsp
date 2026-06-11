<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Square Result</title>
    <style>
        body {
            background-color: pink;
            font-family: Arial;
            text-align: center;
            margin-top: 100px;
        }
    </style>
</head>
<body>

<%
String pagename = request.getParameter("page");
if(pagename.equals("java")){
	response.sendRedirect("java.jsp");
}
else if(pagename.equals("javascript")){
	response.sendRedirect("javascript");
}



%>

</body>
</html>
