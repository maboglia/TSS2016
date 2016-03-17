/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myShop;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author mauro
 */
public class Ordine {
    
    public int numero;
    public Date data;
    public String nome, cognome, indirizzo, pagamento, consegna;
    public double speseSpedizione;
    
    Vector righe;

    public Ordine(int numero, Date data, String nome, String cognome, String indirizzo, String pagamento, String consegna, double speseSpedizione) {
        this.numero = numero;
        this.data = data;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.pagamento = pagamento;
        this.consegna = consegna;
        this.speseSpedizione = speseSpedizione;
        this.righe = new Vector();
    }
    
    public void AggiungiRiga(Prodotto p, int qt){
        ProdottoSelezionato ps = new ProdottoSelezionato(p.id,p.nome, p.descrizione, p.prezzo, qt);
        righe.add(ps);
    }
    
    public ProdottoSelezionato TrovaRiga(int i){
    
        return (ProdottoSelezionato) righe.elementAt(i);
    }
    
    public int NumeroRIghe(){
        return righe.size();
    }
    
    
}
