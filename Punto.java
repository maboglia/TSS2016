package it.bogliaccino.tss2016;

public class Punto {

	//utilizzo incapsulamento perciò le varibili sono private
	private  int x, y;
	
	
	//metodo costruttore ha il compito di dare all'oggetto uno stato iniziale: costruire l'oggetto
	public Punto(){
		x = 0;
		y = 0;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	//overload del metodo costruttore
	public Punto(int mioX, int mioY){
		x = mioX;
		y = mioY;
	}
		
	public int getX(){
		return x;
	} 
}
