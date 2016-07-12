package main;

import dao.Prodotti;

public class Main {

	
	public static void main(String[] args) {
		
		Prodotti p = new Prodotti();
		
		for (Prodotti test : p.elencoProdotti()) {
			System.out.println(test.getProdotto());
		}
		
		
	}
	
	
	
}
