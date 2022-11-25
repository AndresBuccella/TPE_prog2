package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;
import tpe.ElementoAbs;

public class ComparaPorNombre implements Comparator<Alumno>{

	@Override
	public int compare(Alumno a1, Alumno a2) {
		return new ComparadorString().compare(a1.getNombre(), a2.getNombre());
	}
}
