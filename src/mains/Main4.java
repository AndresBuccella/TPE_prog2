package mains;

import java.util.Comparator;

import lista.*;
import tpe.*;
import tpe.comparador.*;

public class Main4 {

	public static void main(String[] args) {

		// A
		Integer a = 10;
		Integer b = 21;
		Integer c = 1;
		Integer d = 5;
		Integer e = 11;

		Nodo n0 = new Nodo(a);
		Nodo n1 = new Nodo(b);
		Nodo n2 = new Nodo(c);
		Nodo n3 = new Nodo(d);
		Nodo n4 = new Nodo(e);
		
		Comparator comp = new ComparadorInteger();
		
		Lista listaVinculadaInteger = new Lista(comp);

		listaVinculadaInteger.addNodo(n0);
		listaVinculadaInteger.addNodo(n1);
		listaVinculadaInteger.addNodo(n2);
		listaVinculadaInteger.addNodo(n3);
		listaVinculadaInteger.addNodo(n4);
		
		// B
		System.out.println("-------------------------------");
		System.out.println("Punto B");
		System.out.println("-------------------------------");
		
		for (Object n : listaVinculadaInteger)
			System.out.println(n);

		// C
		System.out.println("-------------------------------");
		System.out.println("Punto C");
		System.out.println("---------------0----------------");
		
		listaVinculadaInteger.deleteByPos(0);
		for (Object n : listaVinculadaInteger)
			System.out.println(n);
		System.out.println("-------------5------------------");
		listaVinculadaInteger.deleteAllOccurrences(d);
		for (Object n : listaVinculadaInteger)
			System.out.println(n);
		System.out.println("------------11-------------------");
		listaVinculadaInteger.deleteAllOccurrences(e);
		for (Object n : listaVinculadaInteger)
			System.out.println(n);

		// D
		System.out.println("-------------------------------");
		System.out.println("Punto D");
		System.out.println("-------------------------------");

		String sa = "Es";
		String sb = "Facil";
		String sc = "Parcial";
		String sd = "Prog2";

		Nodo ns0 = new Nodo(sa);
		Nodo ns1 = new Nodo(sb);
		Nodo ns2 = new Nodo(sc);
		Nodo ns3 = new Nodo(sd);

		Comparator compS = new ComparadorString();

		Lista listaVinculadaString = new Lista(compS);

		listaVinculadaString.addNodo(ns0);
		listaVinculadaString.addNodo(ns1);
		listaVinculadaString.addNodo(ns2);
		listaVinculadaString.addNodo(ns3);


		System.out.println("-------------------------------");
		System.out.println("Punto E");
		System.out.println("-------------------------------");
		for (Object s : listaVinculadaString)
			System.out.println(s);

		System.out.println("-------------------------------");
		System.out.println("Punto F");
		System.out.println("-------------------------------");
		
		String saa= new String(sc);
		System.out.println(listaVinculadaString.obtenerPos(saa));
		
		System.out.println("-------------------------------");
		System.out.println("Punto G");
		System.out.println("-------------------------------");

		String sab= "Recuperatorio";
		System.out.println(listaVinculadaString.obtenerPos(sab));
		
		//E
		System.out.println("-------------------------------");
		System.out.println("Punto H");
		System.out.println("-------------------------------");
		
		Comparator compInverso = new ComparadorInverso(compS);
		listaVinculadaString.reOrdenarPor(compInverso);
		
		for (Object s : listaVinculadaString)
			System.out.println(s);

		System.out.println("-------------------------------");
		System.out.println("Punto I");
		System.out.println("-------------------------------");
		
		Comparator compCantidad = new ComparadorInverso(new ComparadorPorCantidad());
		
		Grupo universidad = new Grupo("unicen", compCantidad);
		
		Grupo facultad1 = new Grupo("exactas", compCantidad);
		Grupo facultad2 = new Grupo("humanas", compCantidad);
		
		Grupo carrera = new Grupo("Historia", compCantidad);
		
		Alumno fede = new Alumno("Federico", "Lopez", 35999888);
		fede.addInteres("redes");
		fede.addInteres("php");
		fede.addInteres("java");
		fede.addInteres("Python");

		Alumno juana = new Alumno("Juana", "Garcia", 27123455);
		juana.addInteres("programacion");
		juana.addInteres("php");
		juana.addInteres("java");

		facultad1.addElemento(fede);
		facultad1.addElemento(juana);

		Alumno flora = new Alumno("Flora", "Rivas", 34555111);
		flora.addInteres("historia");
		flora.addInteres("antigua");

		Alumno martin = new Alumno("Martin", "Gomez", 34111222);
		martin.addInteres("romanos");
		martin.addInteres("egipcios");
		martin.addInteres("griegos");

		Alumno roman = new Alumno("Roman", "Bazan", 32555111);
		roman.addInteres("argentina");

		carrera.addElemento(flora);
		carrera.addElemento(martin);
		carrera.addElemento(roman);
		
		Alumno mora = new Alumno("Mora", "Diaz", 37124425);
		mora.addInteres("psicologia");
		mora.addInteres("Freud");

		facultad2.addElemento(carrera);
		facultad2.addElemento(mora);
		
		Alumno john = new Alumno("John", "Doe", 12000000);
		john.addInteres("intercambio");
		
		

		universidad.addElemento(facultad1);
		universidad.addElemento(facultad2);
		universidad.addElemento(john);
		
		System.out.println(universidad);
		
		
	}
}
