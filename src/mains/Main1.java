package mains;

import java.util.Comparator;

import lista.*;
import tpe.comparador.*;



public class Main1 {

	public static void main(String[] args) {
		Integer a = 10;
		Integer b = 21;
		Integer c = 1;
		Integer d = 5;
		Integer e = 11;
		
		Comparator<Integer> comp = new ComparadorInteger();
		
		Lista<Integer> listaVinculadaInteger = new Lista<Integer>(comp);

		listaVinculadaInteger.add(a);
		listaVinculadaInteger.add(b);
		listaVinculadaInteger.add(c);
		listaVinculadaInteger.add(d);
		listaVinculadaInteger.add(e);
		listaVinculadaInteger.add(b);
		listaVinculadaInteger.add(b);


		//listaVinculadaInteger.deleteAllOccurrences(21);
		
		for (Integer n : listaVinculadaInteger)
			System.out.println(n);
		
		System.out.println("--------------------------");

		Comparator compI = new ComparadorInverso(comp);
		listaVinculadaInteger.setComparador(compI);
		
		for (Object n : listaVinculadaInteger)
			System.out.println(n);
		System.out.println("--------------------------");
		System.out.println("Cantidad de nodos en la lista: "+listaVinculadaInteger.getCantNodos());
		System.out.println("--------------------------");
		
		listaVinculadaInteger.deleteByPos(5);
		for (Object n : listaVinculadaInteger)
			System.out.println(n);
		System.out.println("--------------------------");
		System.out.println("Cantidad de nodos en la lista: "+listaVinculadaInteger.getCantNodos());
	}
}
