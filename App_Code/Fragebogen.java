package com.example.fragebogen_test;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Fragebogen {
	@ElementList(name = "Fragebogen", inline = true)
	private List<Frage> fragen;

	public List<Frage> getFragen() {
		return fragen;
	}

	public void add(Frage f) {
		this.fragen.add(f);
	}

	public int anzFragen() {
		return fragen.size();
	}

	public Fragebogen(
			@ElementList(name = "Fragebogen", inline = true) List<Frage> fragen) {
		super();
		this.fragen = fragen;
	}

	public Fragebogen() {
		super();
	}

}
