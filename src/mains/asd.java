package mains;

import java.util.Comparator;

import lista.Lista;
import tpe.Alumno;
import tpe.ElementoAbs;
import tpe.Grupo;
import tpe.comparador.ComparaPorNombre;

public class asd {

	public static void main(String[] args) {
		Comparator<ElementoAbs> comp = new ComparaPorNombre();
		Lista<Grupo> l1 = new Lista(comp);
		Grupo g1 = new Grupo("asd1", comp);
		Grupo g2 = new Grupo("asd2", comp);
		l1.add(g1);
		l1.add(g2);
		g1.equals(g2);

		Alumno a1 = new Alumno("facundo", "Corvalan", 0, 0);
		g1.addElemento(a1);
		
		
		g2.addElemento(a1);
		
		g1.addElemento(g2);
		
		System.out.println(g1);
	}

}
