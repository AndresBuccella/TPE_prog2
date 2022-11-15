package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;

public class ComparadorInverso implements Comparator<Object>{

	private Comparator<Object> comp;
	
	public ComparadorInverso(Comparator<Object> comp) {
		this.comp = comp;
	}

	@Override
	public int compare(Object o1, Object o2) {
		Alumno a1 = (Alumno) o1;
		Alumno a2 = (Alumno) o2;
		return (this.comp.compare(a1, a2)) * -1;
	}

}
