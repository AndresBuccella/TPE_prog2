package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;

public class ComparadorInverso implements Comparator<Alumno>{

	private Comparator<Alumno> comp;
	
	public ComparadorInverso(Comparator<Alumno> comp) {
		this.comp = comp;
	}

	@Override
	public int compare(Alumno o1, Alumno o2) {
		return -(this.comp.compare(o1, o2));
	}

}
