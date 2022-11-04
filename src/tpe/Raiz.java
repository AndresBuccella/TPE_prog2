package tpe;

import java.util.Comparator;

import tpe.comparador.ComparaPorEdad;

public class Raiz extends Nodo {
	
	private Nodo raiz;
	
	public Raiz(int idPrimerNodo) {
		super(idPrimerNodo);
		this.raiz = this;
	}
	
	@Override
	public void addNodo(Nodo otro, Comparator<Nodo> comp) {
		if(comp.compare(this.raiz, otro) == 1) { //con esto eliminaria la comprobacion de menor en nodo
			otro.setSigNodo(this);
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
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Raiz raiz = new Raiz(5);
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
		
		// System.out.println(n7);
		// System.out.println(n2); //se puede imprimir el anterior? como agregar menor
		// al primero
	}
}
