
<%@ page import="java.util.Date" import="java.util.Locale" import="java.text.NumberFormat" %>

<%@include file="sql.jsp" %>

<table class="table">
    
            <tr>
                
                <th>Prodotto</th>
                <th>Descrizione</th>
                <th>Prezzo</th>
                <th>Qty &amp; Buy</th>
            
            </tr>
    
    
      <%
          
        try {
          Connection c = DriverManager.getConnection(stringaConnessione, utente, pw);
          Statement s = c.createStatement();
          ResultSet r = s.executeQuery("SELECT * FROM prodotti");
          
                      while(r.next()) {
      %>

            <tr>
                
                <td><%= r.getString(2)%></td>
                <td><%= r.getString(3)%></td>
                <td><%= r.getFloat(4)%></td>
                <td>
                    <form method="post" action="inserisci.jsp">
                        <input type="hidden" name="pid" value="<%= r.getInt(1)%>" />
                        <input type="number" name="qt" value="1" />
                        <input type="submit" name="ordina" value="buy"/>
                    </form>
                </td>
            </tr>
  
      
      <% 
                    }
                      %>


</table>
                      
                      <%
            r.close(); s.close(); c.close();
          } catch (SQLException e) {
              response.sendRedirect("errore.jsp");
          }
        %>