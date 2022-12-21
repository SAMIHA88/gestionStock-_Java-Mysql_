package entities;

import java.util.Objects;
public class Produit {

	private int id;
        private String designation;
	private Categorie categorie;
	private double prixAchat;
        private double tva;
	public int quantite;
	private static int comp;
	private Rayon rayon;

	public Produit(String designation,Categorie categorie, double prixAchat,double tva,int quantite, Rayon rayon) {
		this.id = ++comp;
                this.designation=designation;
		this.categorie = categorie;
		this.prixAchat = prixAchat;
                this.tva=tva;
		this.quantite = 0;
		this.rayon = rayon;
	}
	

	public Produit(int id,String designation, Categorie categorie, double prixAchat,double tva, int quantite, Rayon rayon) {
		super();
		this.id = id;
                this.designation=designation;
		this.categorie = categorie;
		this.prixAchat = prixAchat;
                this.tva=tva;
		this.quantite = quantite;
		this.rayon = rayon;
	}


	public Produit(int id,String designation, Categorie categorie, double prixAchat, Rayon rayon) {
		super();
		this.id = id;
                this.designation=designation;
		this.categorie = categorie;
		this.prixAchat = prixAchat;
                this.tva=tva;
		this.quantite = 0;
		this.rayon = rayon;
	}

    public Produit(String designation, Categorie categorie, double prixAchat, double tva, int id, Rayon rayon, int quantite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}
        
        public void setDesignation(String designation)
        {
            this.designation=designation;
        }
        public String getDesignation()
        {
            return this.designation;
        }
        
        public double getTva()
        {
            return this.tva;
        }

	@Override
	public String toString() {
		return  this.designation;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.categorie);
        hash = 37 * hash + Objects.hashCode(this.rayon);
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
        final Produit other = (Produit) obj;
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.rayon, other.rayon)) {
            return false;
        }
        return true;
    }

   
}
