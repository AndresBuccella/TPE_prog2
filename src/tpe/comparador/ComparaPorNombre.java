package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;
import tpe.ElementoAbs;

public class ComparaPorNombre implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		Alumno a1 = (Alumno) o1;
		Alumno a2 = (Alumno) o2;
		return new ComparadorString().compare(a1.getNombre(), a2.getNombre());
	}
}
