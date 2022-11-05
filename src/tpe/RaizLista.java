package tpe;

import java.util.Comparator;

import tpe.comparador.ComparaPorEdad;

public class RaizLista {
	
	private Nodo raiz;
	
	public RaizLista(Nodo primerNodo) {
		this.raiz = primerNodo;
	}
	
	
	public void addNodo(Nodo otro, Comparator<Nodo> comp) {
		if(comp.compare(this.raiz, otro) == 1) { //con esto eliminaria la comprobacion de menor en nodo
			otro.setSigNodo(this.raiz);
			//this.raiz.setSigNodo(otro); por que hace un overflow?
			System.out.println(otro);
		}else
			super.addNodo(otro, comp);
	}
	/*
	public void addLista(Lista otraRaiz) {
		
	}
	*/
	public void deleteLista() {
		this.raiz.getSigNodo();
		this.setSigNodo(null);
	}
	
	public void deleteAllOccurrences(Nodo otro, Comparator<Nodo>comp) {
		if(comp.compare(raiz, otro) == 0) {
			if(raiz.getSigNodo()!=null) {
				Nodo auxNodo = raiz.getSigNodo();
				this.raiz.setSigNodo(null);
				this.raiz = auxNodo;			
				System.out.println(raiz);	
			}else
				this.raiz = null;
		}else if(this.raiz.getSigNodo()!=null) {
			super.deleteAllOccurrences(otro, comp);
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Comparator comp = new ComparaPorEdad();
		Nodo n2 = new Nodo(2);
		Nodo n1 = new Nodo(1);
		RaizLista raiz = new RaizLista(n1);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);
		Nodo n10 = new Nodo(4);
		Nodo n5 = new Nodo(5);
		Nodo n6 = new Nodo(6);
		Nodo n7 = new Nodo(7);
		Nodo n8 = new Nodo(8);
		Nodo n9 = new Nodo(9);
		Nodo n11 = new Nodo(4);
		
		// n1.addNodo(n1);
		raiz.addNodo(n9, comp);
		raiz.addNodo(n4, comp);
		raiz.addNodo(n3, comp);
		raiz.addNodo(n6, comp);
		raiz.addNodo(n5, comp);
		raiz.addNodo(n7, comp);
		raiz.addNodo(n8, comp);
		raiz.addNodo(n2, comp);
		raiz.addNodo(n10, comp);
		raiz.addNodo(n11, comp);
		
		// System.out.println(n7.obtenerPos(9));
		// System.out.println(n2.obtenerPos(3));
		//raiz.deleteNodo(10);
		

		//System.out.println(raiz);
		raiz.deleteAllOccurrences(n1, comp);
		//System.out.println(raiz);
		// System.out.println(n7);
		// System.out.println(n2); //se puede imprimir el anterior? como agregar menor
		// al primero
	}
}
