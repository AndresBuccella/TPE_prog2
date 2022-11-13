package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;

public class ComparadorCompuesto implements Comparator<Object>{

	private Comparator<Object> comp1;
	private Comparator<Object> comp2;
	
	public ComparadorCompuesto(Comparator<Object> comp1, Comparator<Object> comp2) {
		this.comp1 = comp1;
		this.comp2 = comp2;
	}

	@Override
	public int compare(Object o1, Object o2) {
		Alumno a1 = (Alumno) o1;
		Alumno a2 = (Alumno) o2;
		int aux = comp1.compare(a1, a2);
		int aux2 = comp2.compare(a1, a2);
		if(aux == 0) {
			if(aux2 == 0) 
				return aux;							
			else
				return aux2;
		}
		else
			return aux;
	}
}
