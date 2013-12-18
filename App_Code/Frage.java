package com.example.fragebogen_test;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Frage")
public class Frage {
	@Element(name = "Frage")
	private String frage;
	@Element(name = "Antwort")
	private String antwort;
	@Element(name = "Vorschlag")
	private String hint;

	public Frage(String frage, String hint) {
		super();
		this.frage = frage;
		this.antwort = null;
		this.hint = hint;
	}

	public String getFrage() {
		return frage;
	}

	public String getHint() {
		return hint;
	}

	public String setAntwort(String antwort) {
		return this.antwort = antwort;
	}

	public boolean ausgefuellt() {
		return (antwort != null);
	}
}
