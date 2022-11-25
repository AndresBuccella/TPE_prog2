package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;

public class ComparaPorApellido implements Comparator<Alumno>{

	@Override
	public int compare(Alumno a1, Alumno a2) {
		return new ComparadorString().compare(a1.getApellido(), a2.getApellido());
	}

}
