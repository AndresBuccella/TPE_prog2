package tpe;
import java.util.Comparator;

import tpe.comparador.*;
public class Nodo{ //debiera de ser comparator

	private Nodo sigNodo;
	private int id;
	private static int contador;
	
	public Nodo(int id) {
		this.id = id;
		contador = 0;
	}
	
	public void addNodo(Nodo otro, Comparator<Nodo> comp) {
		
		if((comp.compare(this, otro) == 1)) //si es mayor o igual
			otro.setSigNodo(this);
		else if(comp.compare(this, otro) == 0) //si es igual
			otro.setSigNodo(this);
		else {
			//this es menor al que se quiere insertar, entonces =>
			if (this.sigNodo == null) //primero se pregunta si el siguiente esta vacio para no romper
							//al preguntar si el siguiente es mayor a otro
				this.setSigNodo(otro);
			else if (comp.compare(this.sigNodo, otro) == 1) {
				otro.setSigNodo(this.getSigNodo());
				this.setSigNodo(otro);
		}else
			irAlSiguiente(otro, comp);
		}
	}
	
	public void irAlSiguiente(Nodo otro, Comparator<Nodo> comp) {
		this.sigNodo.addNodo(otro, comp);
	}
	
	public void deleteNodo(int pos) {
		if(pos == 0) {
		//si pos == 0 entonces es el primero
			this.deleteSig();
		}
		if((this.sigNodo != null) && (pos > 1)) {
			//si el siguiente no es null y el buscado no es el nodo siguiente, va al siguiente
			this.sigNodo.deleteNodo(pos--);
		}else if(this.sigNodo != null) {
			if((this.sigNodo.getSigNodo() != null) && (pos == 1)) {
				Nodo sig = this.sigNodo; //aca estamos en 8
				this.sigNodo = this.sigNodo.getSigNodo(); //7 apunta a 9
				sig.deleteSig();
			}
		}
			
		
			
	}
	
	public void deleteSig() {
		this.sigNodo = null;
	}
	
	public int obtenerPos(int id) {
		if ((this.id != id) && (this.sigNodo != null)) {
			contador++;
			this.sigNodo.obtenerPos(id); //no se puede pasar la suma por parámetro
		}else if ((this.id == id))
			return contador;
			
		return contador;
	}
	
	
	public void setSigNodo(Nodo sig) {
		this.sigNodo = sig;
	}
	
	public Nodo getSigNodo() {
		return this.sigNodo;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		//salio de la galera JAJAJA
		if (this.sigNodo != null)
			return this.id + " " + this.sigNodo;
		return this.id + "";
	}
	
	
	public static void main(String[] args) {
		Nodo raiz = new Nodo(1);
		Comparator comp = new ComparaPorEdad();
		Nodo n2 = new Nodo(2);
		Nodo n1 = new Nodo(1);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);
		Nodo n10 = new Nodo(4);
		Nodo n5 = new Nodo(5);
		Nodo n6 = new Nodo(6);
		Nodo n7 = new Nodo(7);
		Nodo n8 = new Nodo(8);
		Nodo n9 = new Nodo(9);
		//n1.addNodo(n1);
		n6.addNodo(n7, comp);
		n6.addNodo(n8, comp);
		n6.addNodo(n9, comp);
		n2.addNodo(n3, comp);
		n2.addNodo(n4, comp);
		System.out.println(n7.obtenerPos(9));
		System.out.println(n2.obtenerPos(3));
		n6.deleteNodo(1);
		

		System.out.println(n6);
		System.out.println(n7);
		//System.out.println(n2); //se puede imprimir el anterior? como agregar menor al primero
	}


}
