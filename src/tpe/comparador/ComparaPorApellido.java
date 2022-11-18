package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;

public class ComparaPorApellido implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		Alumno a1 = (Alumno) o1;
		Alumno a2 = (Alumno) o2;
		return new ComparadorString().compare(a1.getApellido(), a2.getApellido());
	}

}
