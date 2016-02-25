package it.bogliaccino.tss2016;

public class Rettangolo {

	private int base, altezza;

	public Rettangolo(int base, int altezza) {
		this.base = base;
		this.altezza = altezza;
	}
	
	public int calcolaArea(){
		
		return base * altezza;
		
	}
	
	public int calcolaPerimetro(){
		
		return (base + altezza) * 2;
		
	}
	
	
}
