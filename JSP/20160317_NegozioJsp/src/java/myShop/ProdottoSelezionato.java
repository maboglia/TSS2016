/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myShop;

/**
 *
 * @author mauro
 */
public class ProdottoSelezionato extends Prodotto {
    
    public int quantitaSelezionata;

    public ProdottoSelezionato(int id, String nome, String descrizione, double prezzo, int qS) {
        super(id, nome, descrizione, prezzo);
        this.quantitaSelezionata = qS;
    }
    
}
