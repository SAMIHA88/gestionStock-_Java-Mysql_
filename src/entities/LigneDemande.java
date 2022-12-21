package entities;

import java.util.Objects;

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
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.demande);
        hash = 67 * hash + Objects.hashCode(this.produit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LigneDemande other = (LigneDemande) obj;
        if (!Objects.equals(this.demande, other.demande)) {
            return false;
        }
        if (!Objects.equals(this.produit, other.produit)) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return produit.getDesignation() + " Q : " + quantite + " Prix : " + prixAchat;
	}

}
