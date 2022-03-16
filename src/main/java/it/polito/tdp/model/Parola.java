package it.polito.tdp.model;

import java.util.*;

public class Parola {
	private String parola;
	private Set<String> traduzioni = new HashSet<String>();

	public Parola(String parola) {
		super();
		this.parola = parola;
	}

	public void aggiungiParola(String s) {
		traduzioni.add(s);
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public Set<String> getTraduzioni() {
		return traduzioni;
	}

	public void setTraduzioni(Set<String> traduzioni) {
		this.traduzioni = traduzioni;
	}

}
