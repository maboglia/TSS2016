<%@page import="myShop.*" %>


<% 

    int numeroRighe=0;
    
    try{
    numeroRighe = Integer.parseInt(request.getParameter("righe"));
    }
    catch(NullPointerException e){
        numeroRighe=0;
    }
    catch(NumberFormatException e){
        numeroRighe=0;
    }
    
    
    Carrello carrello= null;
    
    if(session.getValue("myShop.carrello")==null)
        carrello = new Carrello();
    else
        carrello = (Carrello) session.getValue("myShop.carrello");
    
    try {
 //       for(int i=0;i<numeroRighe;i++){
            String idProdotto=request.getParameter("id");
//            String idProdotto=request.getParameter("id"+(new Integer(i).toString()));
        
            int qtProdotto=0;
            
            try{
//                qtProdotto = Integer.parseInt(request.getParameter("qt"+(new Integer(i).toString())));
                qtProdotto = Integer.parseInt(request.getParameter("qt"));
            }
            catch(NullPointerException e){
               numeroRighe=0;
            }
            catch(NumberFormatException e){
               numeroRighe=0;
            }       
            carrello.ModificaQuantita(Integer.parseInt(idProdotto), qtProdotto);
//        }
        
    }
    catch(Exception e) {
            response.sendRedirect("error.jsp");
    }
    
    response.sendRedirect("inserisci.jsp?stampa=1");
    
    
%>