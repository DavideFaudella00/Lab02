package it.polito.tdp.model;

import java.util.*;

public class Model {
	private Map<String, Parola> parole = new TreeMap<String, Parola>();

	public void aggiungiAlDizionario(String aliena, String traduz) {
		if (!parole.containsKey(aliena)) {
			Parola p = new Parola(aliena);
			p.aggiungiParola(traduz);
			parole.put(aliena, p);
			return;
		}
		parole.get(aliena).aggiungiParola(traduz);

	}

	public String traduci(String s) {
		if (s.contains("?")) {
			String input = s.replace("?", ".");
			String ss = "";
			for (Parola r : parole.values()) {
				if (r.getParola().matches(input)) {
					for (String m : r.getTraduzioni()) {
						ss += m + "\n";
					}
				}
			}
			return ss;
		}

		if (parole.containsKey(s) == false) {
			return "Parola ancora non inserita nel dizionario";
		}

		String ss = "";
		for (String r : parole.get(s).getTraduzioni()) {
			ss += r + "\n";
		}
		return ss;
	}
}
