package tpe.comparador;

import java.util.Comparator;
import tpe.ElementoAbs;

public class ComparaPorNombre<T> implements Comparator<ElementoAbs<T>>{

	@Override
	public int compare(ElementoAbs<T> a1,ElementoAbs<T> a2) {
		return new ComparadorString().compare(a1.getNombre(), a2.getNombre());
	}

}
