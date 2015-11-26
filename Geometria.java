package it.bogliaccino.tss2016;

public class Geometria {
	
	public static void main(String[] args) {
	
	Punto mioPunto = new Punto();
	
	System.out.println("Punto 1");
	System.out.print(mioPunto.getX() + ", " + mioPunto.getY());
	
	System.out.println();
	mioPunto.setX(7);
	mioPunto.setY(9);
	
	System.out.println("Nuova posizione Punto 1");
	System.out.print(mioPunto.getX() + ", " + mioPunto.getY());
	
	
	System.out.println();
	System.out.println("-------------");
	Punto mioPunto2 = new Punto(4,5);
	
	System.out.println("Punto 2");
	System.out.print(mioPunto2.getX() + ", " + mioPunto2.getY());
		
}
	
}
