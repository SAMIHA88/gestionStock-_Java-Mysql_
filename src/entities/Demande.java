package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demande {
	private int code;
	private Date date;
	private Fournisseur fournisseur;
	//-----------
	private List<LigneDemande> ligneDemandes;

	public Demande(int code, Date date, Fournisseur fournisseur) {
		super();
		this.code = code;
		this.date = date;
		this.fournisseur = fournisseur;
		this.ligneDemandes = new ArrayList<LigneDemande>();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}



	public List<LigneDemande> getLigneDemandes() {
		return ligneDemandes;
	}

	public void setLigneDemandes(List<LigneDemande> ligneDemandes) {
		this.ligneDemandes = ligneDemandes;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		return "Demande : " + code + " / " + sdf.format(date);
	}


}
