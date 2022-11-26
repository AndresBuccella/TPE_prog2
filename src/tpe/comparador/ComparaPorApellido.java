package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;

public class ComparaPorApellido<T> implements Comparator<Alumno<T>>{

	@Override
	public int compare(Alumno<T> a1, Alumno<T> a2) {
		return new ComparadorString().compare(a1.getApellido(), a2.getApellido());
	}

}
