package entities;

public class Produit {
	private int id;
	private String designation;
	private double prixAchat;
	private double tva;
	private Categorie categorie;
	private static int comp;

	public Produit(String designation, double prixAchat,Categorie categorie,double tva) {
		this.id = ++comp;
		this.designation = designation;
		this.prixAchat = prixAchat;
		this.categorie=categorie;
		this.tva=tva;
	}

	
	public Produit(int id, String designation, double prixAchat, Categorie categorie,double tva ) {
		this.id = id;
		this.designation = designation;
		this.prixAchat = prixAchat;
		this.tva = tva;
		this.categorie = categorie;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public double getTva() {
		return tva;
	}

	public void setTva(int tva) {
		this.tva = tva;
	}
	

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	@Override
	public String toString() {
		return "Produit : " + designation;
	}

}
