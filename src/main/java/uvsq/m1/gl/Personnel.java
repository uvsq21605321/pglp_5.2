package uvsq.m1.gl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Personnel extends Team{

	@Override
	public void print() {
		System.out.println(this.fonction+ "  " + this.nom +  "  " + this.prenom);
	}
	
	private final String nom;
	private final String prenom;
	private final String fonction;
	private final java.time.LocalDate dateNaissance;
	private final ArrayList<String> numeroTel;
	

	
	public static class Builder{

		private final String nom;
		private final String prenom;
		private final String fonction;
		private  java.time.LocalDate dateNaissance = java.time.LocalDate.now();
		private ArrayList<String>  numeroTel;
		
		
		public Builder(String nom, String prenom, String fonction) {
			this.nom = nom;
			this.prenom = prenom;
			this.fonction = fonction;
			
		}
                    
		public Builder updatePhoneList(ArrayList<String> phone) {
			
			this.numeroTel = phone;
			
			return this;
		}
		
		public Builder updateDateNaissance(java.time.LocalDate t) {
			
			this.dateNaissance = t;
			
			return this;
		}
                    
		public Personnel build() {
			return new Personnel(this);
		}
		
	}
	

	
	private Personnel(Builder builder) {
		this.fonction = builder.fonction;
		this.nom = builder.nom;
		this.prenom = builder.prenom;
		this.dateNaissance = builder.dateNaissance;
		this.numeroTel = builder.numeroTel;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public ArrayList<String> getNumeroTel() {
		return numeroTel;
	}

	public LocalDate getDateNaiss() {
		return dateNaissance;
	}
	public ArrayList<String> getTel(){
		
		return (ArrayList<String>) Collections.unmodifiableList(this.numeroTel);
		
	}


}
