package entities;

import java.util.ArrayList;
import java.util.List;

public class Rayon {

	private int id;
	private String code;
	private static int cmp;
	//------------
	private List<Produit>produits;
	
	
	
	public Rayon(String code,List<Produit>produits) {
		this.id=++cmp;
		this.code = code;
		this.produits=new ArrayList<Produit>();
		
	}

	public Rayon(int id, String code, List<Produit> produits) {
		this.id = id;
		this.code = code;
		this.produits = produits;
	}



	public List<Produit> getProduits() {
		return produits;
	}



	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	@Override
	public String toString() {
		return "Rayon " + id + ", code=" + code ;
	}
	

	

}
