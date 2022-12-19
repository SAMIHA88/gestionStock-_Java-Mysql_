package entities;

import java.util.ArrayList;
import java.util.List;

public class Rayon {

	private int id;
	private String code;
	private static int cmp;
	
	
	
	public Rayon(String code) {
		this.id=++cmp;
		this.code = code;
		
		
	}

	public Rayon(int id, String code) {
		this.id = id;
		this.code = code;
	}



	



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	@Override
	public String toString() {
		return "Rayon " + id  ;
	}
	

	

}
