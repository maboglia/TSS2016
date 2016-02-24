<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Calendar miaData = Calendar.getInstance();
			out.print("Oggi &grave; il giorno " + miaData.get(miaData.DATE));
			out.print(" del mese " +( 1 + miaData.get(miaData.MONTH)  ));
			out.print(" dell'anno " + miaData.get(miaData.YEAR));
	
	%>


</body>
</html>