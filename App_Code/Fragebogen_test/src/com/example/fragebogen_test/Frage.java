package com.example.fragebogen_test;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Fragen")
public class Frage {
	@Attribute(name = "Index")
	private int index;

	@Element(name = "Frage")
	private String frage;

	@Element(required = false, name = "Antwort")
	private String antwort;

	@Element(name = "Vorschlag")
	private String hint;

	public Frage(@Attribute(name = "Index") int index,
			@Element(name = "Frage") String frage,
			@Element(name = "Vorschlag") String hint) {
		super();
		this.index = index;
		this.frage = frage;
		this.hint = hint;
	}

	public int getIndex() {
		return index;
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

	public String getAntwort() {
		return this.antwort;
	}

	public boolean ausgefuellt() {
		return (antwort != null);
	}

}
