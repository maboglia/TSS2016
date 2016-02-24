<%-- 
    Document   : esempio4.1
    Created on : 13-mag-2013, 19.24.42
    Author     : mauro
--%>

<%@ page language="java" session="false" %>
<%@ page import="java.util.*, java.text.*" %> 
<%!
// dichiarazione costanti per il formato data
private static final int DATA_LONG=0;
private static final int DATA_SHORT=1;
private static final int ORA_LONG=2;
public String formatoData(Date data, int formato)
{
 DateFormat dFormat=null;
 switch (formato){
 case 0:
  dFormat=new SimpleDateFormat("EEEE d MMMM yyyy");
  break;
 case 1: 
  dFormat=
new SimpleDateFormat("d/MM/yyyy");
  break;

case 2:
  dFormat=new SimpleDateFormat("HH:mm:ss");
  break; 
 }
 
return dFormat.format(data); 
}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<h1 align='center'>Esempio di dichiarazione</h1><br/>
<p></p> 
<p><b>Data normale : </b></p>

<p> 
Date data=new Date();
out.write(formatoData(data,DATA_SHORT)); 
</p><% 
Date data=new Date();
out.write(formatoData(data,DATA_SHORT)); 
%>
<br/>
<p><b>Data estesa : </b></p>
<p> 
Date data1=new Date();
out.write(formatoData(data1,DATA_LONG)); 
</p><% 
Date data1=new Date();
out.write(formatoData(data1,DATA_LONG)); 
%>
<br/>
<p><b>Ora estesa : </b></p>
<p> 
Date data2=
new Date();
out.write(formatoData(data2,ORA_LONG)); 
</p>
<% 
Date data2=
new Date();
out.write(formatoData(data2,ORA_LONG)); 
%>


    </body>
</html>