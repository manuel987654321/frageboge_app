package com.example.fragebogen_test;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;



@Root(name="Fragebogen")
public class Fragebogen {
	@ElementList(name = "Fragebogen", inline = true)
	private List<Frage> fragen;

	public  Fragebogen() {
		super();
		this.fragen = new ArrayList<Frage>();
	}
	
	public List<Frage> getFragen() {
		return fragen;
	}
	
	public void createFrage(String frage, String vorschlag){
		this.add(new Frage(this.fragen.size()+
				1,frage, vorschlag));
	}

	public void add(Frage f) {
		this.fragen.add(f);
	}

	public int anzFragen() {
		return fragen.size();
	}
	
	public Frage get(int index){
		return this.fragen.get(index);
	}
}
