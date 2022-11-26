package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;

public class ComparaPorDni<T>  implements Comparator<Alumno>{

	@Override
	public int compare(Alumno a1, Alumno a2) {
		if(a1.getDni() > a2.getDni())
			return 1;
		else if(a1.getDni() < a2.getDni())
			return -1;
		else
			return 0;
	}

}
