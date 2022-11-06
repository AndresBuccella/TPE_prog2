package tpe;

import java.util.Comparator;

import tpe.comparador.ComparaPorEdad;

public class Lista {

	private Nodo raiz;
	private Nodo puntero;
	
	public Lista(Nodo primerNodo) {
		this.raiz = primerNodo;
	}
	
	
	public void addNodo(Nodo otro, Comparator<Nodo> comp) {
		if(comp.compare(raiz, otro) == 1) {
			otro.setSigNodo(raiz);
			this.setRaiz(otro);
			this.setPuntero(raiz);
		}else 
			if(this.puntero.getSigNodo()==null) {
				puntero.setSigNodo(otro);		
				//System.out.println(puntero.getSigNodo());	
				this.setPuntero(raiz);	
			}
			else
				if(comp.compare(this.puntero.getSigNodo(), otro) == 1) {
					this.addNext(otro);
					this.setPuntero(raiz);
				}
				else {
					this.next();
					this.addNodo(otro, comp);			
				}
	}
	
	
	public void addNext(Nodo otro) {
		otro.setSigNodo(this.puntero.getSigNodo());
		System.out.println(this.puntero.getSigNodo());
		this.puntero.setSigNodo(otro);
		System.out.println(puntero);
	}
	
	public String toString() {//no se como hacer para mostrar la lista sin que el nodo se encargue
		if(this.hasNext()) {
			this.next().toString;
			return this.puntero.toString();
		}
		return this.puntero.toString();
	}

	public void setRaiz(Nodo n) {
		this.raiz = n;
	}
	public void setPuntero(Nodo n) {
		this.puntero = n;
	}
	public boolean hasNext() {
		return this.getSigNodoLista() != null;
	}
	public Nodo getSigNodoLista() {
		return this.puntero.getSigNodo();
	}
	public void next() {
		this.setPuntero(this.puntero.getSigNodo());
	}
	/*
	public void addLista(Lista otraRaiz) {
		
	}
	*/	
/*	public void deleteSig() {
		if(this.sigNodo.getSigNodo()!=null) {
			Nodo aux = this.sigNodo;
			this.sigNodo = this.sigNodo.getSigNodo();
			aux.setSigNodo(null);
		}else
			this.sigNodo = null;
	}
	public void deleteLista() {
		this.aux.getSigNodo();
		this.aux = null;
		this.raiz = null; //esta feo porque se hace muchas veces pero no se me ocurre otra
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
*/	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Comparator comp = new ComparaPorEdad();
		Nodo n0 = new Nodo(0);
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
/*		Nodo n4 = new Nodo(4);
		Nodo n10 = new Nodo(4);
		Nodo n5 = new Nodo(5);
		Nodo n6 = new Nodo(6);
		Nodo n7 = new Nodo(7);
		Nodo n8 = new Nodo(8);
		Nodo n9 = new Nodo(9);
*/		Nodo n11 = new Nodo(1);
		Lista raiz = new Lista(n1);
		raiz.addNodo(n0, comp);
		raiz.addNodo(n2, comp);
//		raiz.addNodo(n3, comp);
//		raiz.addNodo(n11, comp);
		System.out.println(raiz);
//		System.out.println(n0);
//		System.out.println(n1);
//		System.out.println(n2);
		//System.out.println(n0);
		
		// n1.addNodo(n1);
/*		raiz.addNodo(n9, comp);
		raiz.addNodo(n4, comp);
		raiz.addNodo(n3, comp);
		raiz.addNodo(n6, comp);
		raiz.addNodo(n5, comp);
		raiz.addNodo(n7, comp);
		raiz.addNodo(n8, comp);
		raiz.addNodo(n2, comp);
		raiz.addNodo(n10, comp);
		raiz.addNodo(n11, comp);
*/		
		// System.out.println(n7.obtenerPos(9));
		// System.out.println(n2.obtenerPos(3));
		//raiz.deleteNodo(10);
		

		//System.out.println(raiz);
		//raiz.deleteAllOccurrences(n1, comp);
		//System.out.println(raiz);
		// System.out.println(n7);
		// System.out.println(n2); //se puede imprimir el anterior? como agregar menor
		// al primero
	}
}
