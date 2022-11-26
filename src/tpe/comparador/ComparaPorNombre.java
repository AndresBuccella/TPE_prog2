package tpe.comparador;

import java.util.Comparator;
import tpe.ElementoAbs;

public class ComparaPorNombre<T> implements Comparator<ElementoAbs>{

	@Override
	public int compare(ElementoAbs a1,ElementoAbs a2) {
		return a1.getNombre().compareTo(a2.getNombre());
	}

}
