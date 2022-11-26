package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;

public class ComparaPorDni<T>  implements Comparator<Alumno<T>>{

	@Override
	public int compare(Alumno<T> a1, Alumno<T> a2) {
		if(a1.getDni() > a2.getDni())
			return 1;
		else if(a1.getDni() < a2.getDni())
			return -1;
		else
			return 0;
	}

}
