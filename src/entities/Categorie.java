package entities;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	private int id;
	private static int cmp;
	private String libelle;
	private List<Produit> produits; 
        
	public Categorie(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
                this.produits=new ArrayList<Produit>();
	}

	public Categorie(String libelle) {
		this.id=++cmp;
		this.libelle = libelle;
                    this.produits=new ArrayList<Produit>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie " + libelle ;
	}
	
	
	
	
}
