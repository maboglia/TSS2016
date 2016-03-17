<%@page contentType="text/html" import="java.util.Date, java.util.Locale, java.text.NumberFormat, myShop.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bare - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
    body {
        padding-top: 70px;
        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
    }
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Negozio JSP</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <%@include file="nav.jsp" %>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">
        <%@include file="sql.jsp" %>
        
        <%
            
            String stampaFlag=request.getParameter("stampa");
            
            if(stampaFlag==null)
                stampaFlag="2";
            
            
            Carrello carrello=null;
            
            if(session.getValue("myShop.carrello")==null){
                carrello=new Carrello();
                session.putValue("myShop.carrello", carrello);
            }
            else
                carrello = (Carrello) session.getValue("myShop.carrello");
            
            
            int qtProdotto = 0;
            
            //arrivi dalla pagina prodotti
            if(!(stampaFlag.equals("1"))){
            
            String idProdotto=request.getParameter("pid");
            
            try{
                qtProdotto = Integer.parseInt(request.getParameter("qt"));
            }
            catch(NullPointerException e){
                qtProdotto=0;
            }
            catch(NumberFormatException e){
                qtProdotto=0;
            }
            
            if(qtProdotto > 0){
            
                try {
          Connection c = DriverManager.getConnection(stringaConnessione, utente, pw);
          Statement s = c.createStatement();
          ResultSet r = s.executeQuery("SELECT Prodotto, Descrizione, Prezzo FROM prodotti WHERE ID = " + idProdotto);
          
          if(r.next()){
              Prodotto p = new Prodotto(Integer.parseInt(idProdotto),r.getString(1),r.getString(2),r.getFloat(3));
              
              if(carrello.TrovaIndiceProdotto(Integer.parseInt(idProdotto))==-1)
                  carrello.AggiungiProdotto(p, qtProdotto);
              else 
                  carrello.ModificaQuantita(Integer.parseInt(idProdotto), qtProdotto);

              
          }
            r.close();
            s.close();
            c.close();
          
                }catch(SQLException e){
                    response.sendRedirect("errore.jsp");
                }   
                
                
            
            }
            
            }  
            //fine stampaFlag != 1
            
        boolean carrelloVuoto = carrello.Vuoto();
        
        %>
        
        
        <%
        
        
        if(qtProdotto <= 0  && !stampaFlag.equals("1")){
        
                out.println("<h3>Devi inserire un numero intero positivo</h3>");
            
        }
        else {
            if(carrelloVuoto){
                    out.println("<h3>il tuo carrello è vuoto!!</h3>");
            }
            else{
        %>
        
        
        
                 
        
        <table class="table">

        <% 
        
            NumberFormat fmt = NumberFormat.getInstance(Locale.ITALIAN);
            fmt.setMinimumFractionDigits(2);
            fmt.setMaximumFractionDigits(2);
            fmt.setParseIntegerOnly(false);
            
            
            int i = 0;
            
            for(;i<carrello.NumeroProdotti();i++){
            
            ProdottoSelezionato ps = carrello.TrovaProdotto(i);
                    
        %>                         
            <tr>
                
                <td><%= ps.nome %></td>
                <td><%= ps.descrizione %></td>
                <td><%= fmt.format(ps.prezzo) %></td>
                <td>
                    <form method="post" action="aggiorna.jsp">
                        <input type="hidden" name="id" value="<%= ps.id %>" />
                        <input type="hidden" name="righe" value="<%= i %>" />
                        <input type="number" name="qt" value="<%= ps.quantitaSelezionata %>" />
                        <input type="submit" name="ordina" value="buy"/>
                    </form>
                
                </td>
                <td><%= fmt.format(ps.prezzo * ps.quantitaSelezionata) %></td>
                <td><a href="elimina.jsp?id=<%= ps.id %>">Elimina</a></td>
                
            </tr>
        

        <% 
            
            
            }
        
        
        %>
        
        </table>
        <div class="row">
            
            <h3>Svuota il carrello</h3>
            <form method="post" action="svuota.jsp">

                <input type="submit" name="svuota" value="svuota" />

            </form>
        </div>
        
        <%
        
            }
        }
        %>
        
        <footer class="row" id="footer">
            <%@include file="footer.jsp" %>

        </footer>
    </div>
    <!-- /.container -->

    <!-- jQuery Version 1.11.1 -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>


