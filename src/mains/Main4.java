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
		
		Comparator<Integer> comp = new ComparadorInteger();
		
		Lista<Integer> listaVinculadaInteger = new Lista<Integer>(comp);

		listaVinculadaInteger.add(a);
		listaVinculadaInteger.add(b);
		listaVinculadaInteger.add(c);
		listaVinculadaInteger.add(d);
		listaVinculadaInteger.add(e);
		
		// B
		System.out.println("-------------------------------");
		System.out.println("Punto B");
		System.out.println("-------------------------------");
		
		for (Integer n : listaVinculadaInteger)
			System.out.println(n);

		// C
		System.out.println("-------------------------------");
		System.out.println("Punto C");
		System.out.println("---------------0----------------");
		
		listaVinculadaInteger.deleteByPos(0);
		for (Integer n : listaVinculadaInteger)
			System.out.println(n);
		System.out.println("-------------5------------------");
		listaVinculadaInteger.deleteAllOccurrences(d);
		for (Integer n : listaVinculadaInteger)
			System.out.println(n);
		System.out.println("------------11-------------------");
		listaVinculadaInteger.deleteAllOccurrences(e);
		for (Integer n : listaVinculadaInteger)
			System.out.println(n);

		// D
		System.out.println("-------------------------------");
		System.out.println("Punto D");
		System.out.println("-------------------------------");

		String sb = "Facil";
		String sa = "Es";
		String sc = "Parcial";
		String sd = "Prog2";

		Comparator<String> compS = new ComparadorString();

		Lista<String> listaVinculadaString = new Lista<String>(compS);

		listaVinculadaString.add(sb);
		listaVinculadaString.add(sa);
		listaVinculadaString.add(sc);
		listaVinculadaString.add(sd);

		//E
		System.out.println("-------------------------------");
		System.out.println("Punto E");
		System.out.println("-------------------------------");
		for (Object s : listaVinculadaString)
			System.out.println(s);

		//F
		System.out.println("-------------------------------");
		System.out.println("Punto F");
		System.out.println("-------------------------------");
		
		String saa= new String(sc);
		System.out.println(listaVinculadaString.obtenerPos(saa));
		
		//G
		System.out.println("-------------------------------");
		System.out.println("Punto G");
		System.out.println("-------------------------------");

		String sab= "Recuperatorio";
		System.out.println(listaVinculadaString.obtenerPos(sab));
		
		//H
		System.out.println("-------------------------------");
		System.out.println("Punto H");
		System.out.println("-------------------------------");
		
		Comparator<String> compInverso = new ComparadorInverso(compS);
		listaVinculadaString.setComparador(compInverso);
		
		for (String s : listaVinculadaString)
			System.out.println(s);

		System.out.println("-------------------------------");
		System.out.println("Punto I");
		System.out.println("-------------------------------");
		
		Comparator<ElementoAbs> compCantidad = new ComparadorInverso<ElementoAbs>(new ComparadorPorCantidad());
		Comparator<ElementoAbs> compNombre = new ComparaPorNombre();
		Comparator<ElementoAbs> compApellido = new ComparaPorApellido();
		Comparator<ElementoAbs> compDni = new ComparaPorDni();
		Comparator<ElementoAbs> compuesto = new ComparadorCompuesto(compApellido, compNombre);
		Comparator<ElementoAbs> compuestoFinal = new ComparadorCompuesto(compuesto, compDni);
		
		Grupo universidad = new Grupo("unicen", compCantidad);
		
		Grupo facultad1 = new Grupo("exactas", compCantidad);
		Grupo facultad2 = new Grupo("humanas", compCantidad);
		
		Grupo carrera = new Grupo("Historia", compCantidad);
		
		Alumno fede = new Alumno("Federico", "Lopez", 35999888, 20);
		fede.addInteres("redes");
		fede.addInteres("php");
		fede.addInteres("java");
		fede.addInteres("Python");

		Alumno juana = new Alumno("Juana", "Garcia", 27123455, 20);
		juana.addInteres("programacion");
		juana.addInteres("php");
		juana.addInteres("java");

		facultad1.addElemento(fede);
		facultad1.addElemento(juana);

		Alumno flora = new Alumno("Flora", "Rivas", 34555111, 20);
		flora.addInteres("historia");
		flora.addInteres("antigua");

		Alumno martin = new Alumno("Martin", "Gomez", 34111222, 20);
		martin.addInteres("romanos");
		martin.addInteres("egipcios");
		martin.addInteres("griegos");

		Alumno roman = new Alumno("Roman", "Bazan", 32555111, 20);
		roman.addInteres("argentina");

		carrera.addElemento(flora);
		carrera.addElemento(martin);
		carrera.addElemento(roman);
		
		Alumno mora = new Alumno("Mora", "Diaz", 37124425, 20);
		mora.addInteres("psicologia");
		mora.addInteres("Freud");

		facultad2.addElemento(carrera);
		facultad2.addElemento(mora);
		
		Alumno john = new Alumno("John", "Doe", 12000000, 20);
		john.addInteres("intercambio");
		
		

		universidad.addElemento(facultad1);
		universidad.addElemento(facultad2);
		universidad.addElemento(john);

		System.out.println(universidad);
		
		System.out.println("-------------------------------");
		System.out.println("Punto I segundo composite");
		System.out.println("-------------------------------");
		
		Grupo olimpiadas = new Grupo("Olimpiadas Matematicas", compCantidad);
		
		Grupo grupo1 = new Grupo("Matea2", compCantidad);		
		Grupo grupo2 = new Grupo("LosFibo", compCantidad);

		Alumno juan = new Alumno("Juan", "Juarez", 32222444, 20);
		juan.addInteres("sucesiones");
		juan.addInteres("algebra");

		Alumno julio = new Alumno("Julio", "Cesar", 33222111, 20);
		julio.addInteres("sucesiones");
		julio.addInteres("algebra");

		grupo1.addElemento(juan);
		grupo1.addElemento(julio);
		
		Alumno bernandino = new Alumno("Bernandino", "Rivas", 30987654, 20);
		bernandino.addInteres("matematicas");
		
		Alumno jose = new Alumno("Jose", "Paso", 33322112, 20);
		jose.addInteres("problemas");	
		
		Alumno isaac = new Alumno("Isaac", "Newton", 12343565, 20);
		isaac.addInteres("sucesiones");

		grupo2.addElemento(bernandino);
		grupo2.addElemento(jose);
		grupo2.addElemento(isaac);

		olimpiadas.addElemento(grupo1);
		olimpiadas.addElemento(grupo2);

		System.out.println(olimpiadas);
		
		System.out.println("-------------------------------");
		System.out.println("Punto I lista de composites");
		System.out.println("-------------------------------");
		
		Lista<ElementoAbs> listaVinculada = new Lista<ElementoAbs>(compCantidad);
		
		listaVinculada.add(universidad);
		listaVinculada.add(olimpiadas);
		
		System.out.println(listaVinculada);
		
	}
}
