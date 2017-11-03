<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<h1>Hello world in JSP</h1>
<h2><a href="index.jsp">home</a></h2>
<br/>    <! -- This is the JSP file-->

<%@ page language="java"%>
<%@ page import="java.util.*" %>
<%@ include file="header.txt" %>
<p> The date and time: <% out.println(new Date()); %></p> 
    <%= new java.util.Date() %>
    <%
    String stVar = "Hello World";
      out.println (stVar);
      
      boolean checkBoolean=false;
      if(checkBoolean==true)
      {
      out.print("La condizione è vera");
      }
      else
      {
      out.print("La condizione è falsa");
      //stamperà la condizione è falsa
      }
    %>
</body>
</html>