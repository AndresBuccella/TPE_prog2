package mains;

import java.util.Comparator;
import lista.*;
import tpe.*;
import tpe.comparador.*;

public class Main2 {

	public static void main(String[] args) {
		Alumno a = new Alumno("Andres", "Buccella", 1, 20);
		Alumno b = new Alumno("Guillermo", "Scipioni", 2, 20);
		Alumno j = new Alumno("Guillermo", "Scipioni", 20, 20);
		Alumno c = new Alumno("Ivan", "Perez", 3, 20);
		Alumno d = new Alumno("Facundo", "Corvalan", 4, 20);
		Alumno e = new Alumno("Ramon", "Pereyra", 5, 20);
		Alumno f = new Alumno("Cristiano", "Ronaldo", 6, 20);
		Alumno g = new Alumno("Ramon", "Perez", 7, 20);
		Alumno h = new Alumno("Andres", "Gomez", 8, 20);
		
		Comparator<Alumno> compNombre = new ComparaPorNombre();
		Comparator<Alumno> compNombreI = new ComparadorInverso(compNombre);
		Comparator<Alumno> compApellido = new ComparaPorApellido();
		Comparator<Alumno> compApellidoI = new ComparadorInverso(compApellido);
		Comparator<Alumno> compDni = new ComparaPorDni();
		Comparator<Alumno> compDniI = new ComparadorInverso(compDni);
		Comparator<Alumno> compuesto = new ComparadorCompuesto(compApellido, compNombre);
		Comparator<Alumno> compuestoFinal = new ComparadorCompuesto(compuesto, compDni);
		Lista<Alumno> raiz = new Lista<Alumno>(compNombre);
		raiz.add(a);
		raiz.add(b);
		raiz.add(c);
		raiz.add(d);
		raiz.add(e);
		raiz.add(f);
		raiz.add(g);
		raiz.add(h);
		raiz.add(j);
		System.out.println("Nombre");
		for(Object n : raiz) {
			System.out.println(n);
		}
		raiz.setComparador(compuestoFinal);
		System.out.println("------------------------------------------------");
		System.out.println("compuestoFinal");
		System.out.println("------------------------------------------------");
		for(Object n : raiz) {
			System.out.println(n);
		}
		System.out.println("------------------------------------------------");
		System.out.println("deleteAllOccurrences");
		System.out.println("------------------------------------------------");
		raiz.deleteAllOccurrences(a);
		for(Object n : raiz) {
			System.out.println(n);
		}
	}
}
