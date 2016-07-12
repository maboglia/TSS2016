package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connessione.Connessione;

public class Prodotti extends BaseDAO{

	
	private int idProdotto;
	private String prodotto = null;
	private int idFornitore;
	
	public Prodotti(){}
	public int getIdProdotto() {
		return idProdotto;
	}


	public String getProdotto() {
		return prodotto;
	}


	public int getIdFornitore() {
		return idFornitore;
	}



	

	public Prodotti(String prodotto){
	
		this.prodotto = prodotto;
	}

	public ArrayList<Prodotti> elencoProdotti(){
		
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM prodotti";
		ArrayList<Prodotti> lista = new ArrayList<>();
		
		try{
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				lista.add(new Prodotti(rs.getString(3)));
			}
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}
		
		return lista;
		
		
	}
	

	
}
