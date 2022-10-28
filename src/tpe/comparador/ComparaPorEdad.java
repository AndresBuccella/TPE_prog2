package tpe.comparador;
import java.util.Comparator;

import tpe.Nodo;

public class ComparaPorEdad implements Comparator<Nodo>{
	

	
	@Override
	public int compare(Nodo o1, Nodo o2) {
		if (o1.getId() > o2.getId())
			return 1;
		else if (o1.getId() < o2.getId())
			return -1;
		return 0;
	}

	
}
