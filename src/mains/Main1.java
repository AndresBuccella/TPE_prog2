package mains;

import java.util.Comparator;

import lista.*;
import tpe.*;
import tpe.comparador.*;

public class Main1 {

	public static void main(String[] args) {

		
		Alumno a = new Alumno("Andres", "Buccella", 1);
		Alumno b = new Alumno("Andres", "Buccella", 2);
		Alumno c = new Alumno("Andres", "Buccella", 3);
		Alumno d = new Alumno("Facundo", "Corvalan", 4);
		Alumno e = new Alumno("Andres", "Buccella", 5);
		Alumno f = new Alumno("Cristiano", "Ronaldo", 6);
		Alumno g = new Alumno("Ramon", "Perez", 7);
		Alumno h = new Alumno("Andres", "Gomez", 8);
		Nodo n0 = new Nodo(a);
		Nodo n01 = new Nodo(b);
		Nodo n02 = new Nodo(c);
		Nodo n03 = new Nodo(d);
		Nodo n04 = new Nodo(e);
		Nodo n05 = new Nodo(f);
		Nodo n06 = new Nodo(g);
		Nodo n07 = new Nodo(h);
		
		Comparator compNombre = new ComparaPorNombre();
		Comparator compNombreI = new ComparadorInverso(compNombre);
		Comparator compApellido = new ComparaPorApellido();
		Comparator compApellidoI = new ComparadorInverso(compApellido); //no anda .-.
		Comparator compDni = new ComparaPorDni();
		Comparator compDniI = new ComparadorInverso(compDni);
		Comparator compuesto = new ComparadorCompuesto(compApellido, compNombre);
		Comparator compuestoFinal = new ComparadorCompuesto(compuesto, compDni);
		Lista raiz = new Lista(n07,compApellidoI);
		raiz.addNodo(n01);
		raiz.addNodo(n02);
		raiz.addNodo(n03);
		raiz.addNodo(n04);
		raiz.addNodo(n05);
		raiz.addNodo(n06);
		raiz.addNodo(n0);
		System.out.println("Nombre");
		for(Object n : raiz) {
			System.out.println(n);
		}
		raiz.reOrdenarPor(compuestoFinal);
		System.out.println("compuestoFinal");
		for(Object n : raiz) {
			System.out.println(n);
		}
	}
}
