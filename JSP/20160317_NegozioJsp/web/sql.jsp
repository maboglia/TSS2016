<%@page import="java.sql.*" %>

<%
    String stringaConnessione="jdbc:mysql://localhost/TSS2016";
    String utente = "root";
    String pw = "";
    
    
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
    }
    catch (ClassNotFoundException e)
    {
        response.sendRedirect("errore.jsp");
    } 

%>