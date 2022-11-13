package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;

public class ComparaPorDni  implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		Alumno a1 = (Alumno) o1;
		Alumno a2 = (Alumno) o2;
		if(a1.getDni() > a2.getDni())
			return 1;
		else if(a1.getDni() < a2.getDni())
			return -1;
		else
			return 0;
	}

}
