package mains;

import java.util.Comparator;

import lista.Lista;
import lista.Nodo;
import tpe.comparador.ComparadorInteger;
import tpe.comparador.ComparadorInverso;



public class Main1 {

	public static void main(String[] args) {
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
		Nodo n5 = new Nodo(b);
		Nodo n6 = new Nodo(b);
		
		Comparator comp = new ComparadorInteger();
		
		Lista listaVinculadaInteger = new Lista(comp);

		listaVinculadaInteger.addNodo(n0);
		listaVinculadaInteger.addNodo(n1);
		listaVinculadaInteger.addNodo(n2);
		listaVinculadaInteger.addNodo(n3);
		listaVinculadaInteger.addNodo(n4);
		listaVinculadaInteger.addNodo(n5);
		listaVinculadaInteger.addNodo(n6);
		
		
		listaVinculadaInteger.deleteAllOccurrences(21);
		
		for (Object n : listaVinculadaInteger)
			System.out.println(n);
		
		System.out.println("--------------------------");

		Comparator compI = new ComparadorInverso(comp);
		listaVinculadaInteger.reOrdenarPor(compI);
		
		for (Object n : listaVinculadaInteger)
			System.out.println(n);
	}
}
