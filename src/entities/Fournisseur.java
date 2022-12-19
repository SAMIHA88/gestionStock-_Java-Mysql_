package entities;

public class Fournisseur {
	private int id;
	private String nom;
	private String telephone;
	private String email;
	private static int comp;

	public Fournisseur(String nom, String telephone, String email) {
		this.id = ++comp;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
	}
	

	public Fournisseur(int id, String nom, String telephone, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
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
        final Fournisseur other = (Fournisseur) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Fournisseur : " + this.nom;
	}

}
