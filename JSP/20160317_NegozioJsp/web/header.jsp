<%@page import= "java.text.*, java.util.Date" %>
        <h1>testatina del mio negozio online con jsp</h1>
        
        <%! DateFormat formatoData= new SimpleDateFormat("dd/MM/yyyy"); %>

        <% out.println(formatoData.format(new Date())); %>
        
        