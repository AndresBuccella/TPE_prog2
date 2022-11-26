package tpe.comparador;

import java.util.Comparator;

import tpe.ElementoAbs;

public class ComparadorPorCantidad<T> implements Comparator<ElementoAbs<T>> {

	public int compare(ElementoAbs<T> e1, ElementoAbs<T> e2) {
		if (e1.getCantidad() > e2.getCantidad())
			return 1;
		else if (e1.getCantidad() < e2.getCantidad())
			return -1;
		return 0;
	}
}
