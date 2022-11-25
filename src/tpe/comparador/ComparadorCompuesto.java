package tpe.comparador;

import java.util.Comparator;

public class ComparadorCompuesto<T> implements Comparator<T>{

	private Comparator<T> comp1;
	private Comparator<T> comp2;
	
	public ComparadorCompuesto(Comparator<T> comp1, Comparator<T> comp2) {
		this.comp1 = comp1;
		this.comp2 = comp2;
	}

	@Override
	public int compare(T a1, T a2) {
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
