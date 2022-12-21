/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author samih
 */
public class LigneCommande {
    private Commande commande ;
    private Produit produit;
    private int quantite;
    private double prixVente;

    public LigneCommande(Commande commande, Produit produit, int quantite, double prixVente) {
        this.commande = commande;
        this.produit = produit;
        this.quantite = quantite;
        this.prixVente = prixVente;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
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

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.commande);
        hash = 89 * hash + Objects.hashCode(this.produit);
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
        final LigneCommande other = (LigneCommande) obj;
        if (!Objects.equals(this.commande, other.commande)) {
            return false;
        }
        if (!Objects.equals(this.produit, other.produit)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LigneCommande{" + "commande=" + commande + ", produit=" + produit + ", quantite=" + quantite + ", prixVente=" + prixVente + '}';
    }
    
    
    
}
