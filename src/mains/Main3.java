package mains;

import java.util.Comparator;

import tpe.*;
import tpe.comparador.ComparadorPorCantidad;

public class Main3 {

	public static void main(String[] args) {

		Comparator<ElementoAbs> compCantidad = new ComparadorPorCantidad();
		
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

	}

}
