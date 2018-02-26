package fr.eni.clinique.bo;

import java.util.GregorianCalendar;

public class Agenda {
	int CodeVeto;
	GregorianCalendar DateRdv;
	int CodeAnimal;
		
	public Agenda(int codeVeto, GregorianCalendar dateRdv, int codeAnimal) {
		super();
		CodeVeto = codeVeto;
		DateRdv = dateRdv;
		CodeAnimal = codeAnimal;
	}
	
	public int getCodeVeto() {
		return CodeVeto;
	}
	public void setCodeVeto(int codeVeto) {
		CodeVeto = codeVeto;
	}
	public GregorianCalendar getDateRdv() {
		return DateRdv;
	}
	public void setDateRdv(GregorianCalendar dateRdv) {
		DateRdv = dateRdv;
	}
	public int getCodeAnimal() {
		return CodeAnimal;
	}
	public void setCodeAnimal(int codeAnimal) {
		CodeAnimal = codeAnimal;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agenda [CodeVeto=").append(CodeVeto).append(", DateRdv=").append(DateRdv)
				.append(", CodeAnimal=").append(CodeAnimal).append("]");
		return builder.toString();
	}
	
	
}
