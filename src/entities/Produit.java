package entities;

public class Produit {
	private int id;
	private String designation;
	private double prixAchat;
	private double tva;
	private Categorie categorie;
        private Rayon rayon;
	private static int comp;

	
	
	public Produit(int id, String designation, double prixAchat, Categorie categorie,double tva ,Rayon rayon) {
		this.id = id;
		this.designation = designation;
		this.prixAchat = prixAchat;
		this.tva = tva;
		this.categorie = categorie;
                this.rayon=rayon;
	}

public Produit(String designation, double prixAchat,Categorie categorie,double tva,Rayon rayon) {
		this.id = ++comp;
		this.designation = designation;
		this.prixAchat = prixAchat;
		this.categorie=categorie;
		this.tva=tva;
                this.rayon=rayon;
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

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
        

	@Override
	public String toString() {
		return "Produit : " + designation;
	}

}
