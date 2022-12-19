package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demande {
	private int code;
	private Date date;
        private  static int cmp;
	private Fournisseur fournisseur;
	
	public Demande(int code, Date date, Fournisseur fournisseur) {
		super();
		this.code = code;
		this.date = date;
		this.fournisseur = fournisseur;
		
	}
        public Demande(Date date, Fournisseur fournisseur) {
		
		this.code = ++cmp;
		this.date = date;
		this.fournisseur = fournisseur;
		
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




	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		return "Demande : " + code + " / " + sdf.format(date);
	}


}
