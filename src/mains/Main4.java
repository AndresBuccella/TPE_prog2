package mains;

import java.util.Comparator;

import lista.*;
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
		
		Lista listaVinculadaInteger = new Lista(n0, comp);
		
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

		Lista listaVinculadaString = new Lista(ns0, compS);

		listaVinculadaString.addNodo(ns1);
		listaVinculadaString.addNodo(ns2);
		listaVinculadaString.addNodo(ns3);

		for (Object s : listaVinculadaString)
			System.out.println(s);

	}
}
