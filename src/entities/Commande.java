package entities;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Commande {

	private int code;
	private Date date;
	private Client client;
        private static int cmp; 
	
	public Commande(int code, Date date, Client client) {
		this.code = code;
		this.date = date;
		this.client = client;
		
	}
        public Commande( Date date, Client client) {
		super();
		this.code = ++cmp;
		this.date = date;
		this.client = client;
		
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.code;
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
        final Commande other = (Commande) obj;
        if (this.code != other.code) {
            return false;
        }
        return true;
    }



	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		return "Commande : " + code + " / " + sdf.format(date);
	}

}
