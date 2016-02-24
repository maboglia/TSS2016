<%-- 
    Document   : esempio4.1
    Created on : 13-mag-2013, 19.24.42
    Author     : mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<h1 align='center'>Esempio di scriptlet</h1><br/>
<p>La pagina genera un numero intero casuale da 1 a 90</p> 
<h2>
<%
int numero=(int)Math.floor(Math.random() * 90)+1;
out.write(" Numeri generati: " + numero);
int numero2=(int)Math.floor(Math.random() * 90)+1;
out.write(" - " + numero2);
int numero3=(int)Math.floor(Math.random() * 90)+1;
out.write(" -  " + numero3);
int numero4=(int)Math.floor(Math.random() * 90)+1;
out.write(" -  " + numero4);
int numero5=(int)Math.floor(Math.random() * 90)+1;
out.write(" -  " + numero5);
%>
</h2>
<p>La pagina genera un numero intero casuale da 1 a 90, se provate ad aggiornare la pagina noterete
che ogni volta verrà generato un nuovo numero. Questo succede perché ogni volta che viene
aggiornata la pagina, il JSP container richiamerà ogni volta il metodo _jspService() della servlet,
dato che l'istruzione  </p>
<h3>int numero=(int)Math.floor(Math.random() * 90)+1;</h3>  
<p>viene inserita in tale metodo (perché è uno scriptlet), verrà eseguita ad ogni aggiornamento. </p> 

    </body>
</html>