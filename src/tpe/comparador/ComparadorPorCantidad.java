package tpe.comparador;

import java.util.Comparator;

import tpe.ElementoAbs;

public class ComparadorPorCantidad implements Comparator<ElementoAbs> {

	public int compare(ElementoAbs e1, ElementoAbs e2) {
		if (e1.getCantidad() > e2.getCantidad())
			return 1;
		else if (e1.getCantidad() < e2.getCantidad())
			return -1;
		return 0;
	}
}
