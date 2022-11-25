package tpe.comparador;

import java.util.Comparator;

public class ComparadorInverso<T> implements Comparator<T>{

	private Comparator<T> comp;
	
	public ComparadorInverso(Comparator<T> comp) {
		this.comp = comp;
	}

	@Override
	public int compare(T o1, T o2) {
		return (this.comp.compare(o1, o2)) * -1;
	}

}
