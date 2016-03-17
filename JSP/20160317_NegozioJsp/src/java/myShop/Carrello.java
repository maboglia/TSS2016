package myShop;

import java.util.Vector;

public class Carrello {
    
    Vector prodotti;
    
    public Carrello(){
        prodotti=new Vector();
    }
    public void AggiungiProdotto(Prodotto p, int qt){
    
            ProdottoSelezionato ps = new ProdottoSelezionato(p.id, p.nome, p.descrizione, p.prezzo, qt);
            prodotti.add(ps);
    
    }
    public void EliminaProdotto(int id){
        for(int i = 0; i<prodotti.size();i++){
            if(((ProdottoSelezionato) prodotti.elementAt(i)).id == id){
                prodotti.remove(i);
                break;
            }
        }
    }
    public void ModificaQuantita(int id, int qt){
        for(int i = 0; i<prodotti.size();i++){
            if(((ProdottoSelezionato) prodotti.elementAt(i)).id == id){
                if(qt==0)
                    prodotti.remove(i);
                else
                    ((ProdottoSelezionato) prodotti.elementAt(i)).quantitaSelezionata=qt;
                break;
            }
        }
    }
    public void Svuota(){
        prodotti.clear();
    }
    public boolean Vuoto(){
        return prodotti.size()==0;
    }
    public int NumeroProdotti(){
        return prodotti.size();
    }
    public int TrovaIndiceProdotto(int id){
        for(int i = 0; i<prodotti.size();i++){
            if(((ProdottoSelezionato) prodotti.elementAt(i)).id == id){
                return i;
            }
        }
        return -1;
    }    
    public ProdottoSelezionato TrovaProdotto(int i){
        return  (ProdottoSelezionato) prodotti.elementAt(i);
    }
}
