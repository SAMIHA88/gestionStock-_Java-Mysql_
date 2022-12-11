package entities;

public class LigneDemande {
	private Demande demande;
	private Produit produit;
	private int quantite;
	private double prixAchat;

	public LigneDemande(Demande demande, Produit produit, int quantite, double prixAchat) {
		super();
		this.demande = demande;
		this.produit = produit;
		this.quantite = quantite;
		this.prixAchat = prixAchat;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixVente(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	@Override
	public String toString() {
		return produit.getDesignation() + " Q : " + quantite + " Prix : " + prixAchat;
	}

}
