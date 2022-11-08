package tpe;

import java.util.Comparator;
import java.util.Iterator;

import tpe.comparador.*;

public class Nodo implements Iterable<Nodo>{ // debiera de ser comparator

	private Nodo sigNodo;
	private int id;
	private static int contador;

	public Nodo(int id) {
		this.id = id;
		contador = 0;
	}

	public void addNodo(Nodo otro, Comparator<Nodo> comp) {//no se agregan antes

		if(comp.compare(this, otro) == 1) {
			otro.sigNodo = this;
		}
		else
			if(this.sigNodo == null)
				this.sigNodo = otro;
			else
				if((comp.compare(this, otro) == 0) ||
						(comp.compare(this.sigNodo, otro) == 1)) {
					otro.sigNodo = this.sigNodo;
					this.sigNodo = otro;
				}else 
					this.sigNodo.addNodo(otro, comp);
	}

	public void irAlSiguiente(Nodo otro, Comparator<Nodo> comp) {
		this.sigNodo.addNodo(otro, comp);
	}

	public void deleteNodo(int pos) {
		
		if (pos == 0)
			deleteSig();
		else if (this.sigNodo != null) {
			if (this.sigNodo.getSigNodo() != null) { // si el utlimo no es null
				if (pos == 1) {
					Nodo sig = this.sigNodo;
					this.sigNodo = this.sigNodo.getSigNodo();
					sig.sigNodo = null;
				}
			}else if (pos == 1)
				this.deleteSig();
		}
		if (pos > 1) {
			pos--;
			this.sigNodo.deleteNodo(pos);
		}
	}

	public void deleteSig() {
		this.sigNodo = null;
	}
	
	public void deleteAllOccurrences(Nodo otro, Comparator<Nodo>comp) {//no borra los ultimos, fijarse los if
		
		for(Nodo n : this) {
			if(comp.compare(n, otro) == 0) {
				iterator().remove();
			}
		}
/*		if(this.sigNodo!=null) {
			while((this.sigNodo!=null)&&(comp.compare(this.sigNodo,otro)==0)) {
				Nodo auxNodo = this.sigNodo;
				this.sigNodo= this.sigNodo.getSigNodo();
				auxNodo.setSigNodo(null);
			}
			this.sigNodo.deleteAllOccurrences(otro, comp);
		}*/
	}

	public int obtenerPos(int id) {
		if ((this.id != id) && (this.sigNodo != null)) {
			contador++;
			this.sigNodo.obtenerPos(id); // no se puede pasar la suma por parámetro
		} else if ((this.id == id))
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
		return this.id + "";
		// salio de la galera JAJAJA
/*		if (this.sigNodo != null)
			return this.id + " " + this.getSigNodo();
		return this.id + "";
*/	}
	
	public Iterator<Nodo> iterator() {
		return new IteradorNodos(this);
	}
	
	private class IteradorNodos implements Iterator<Nodo>{
		private Nodo aux;
		private Nodo anterior;
        public IteradorNodos(Nodo primero){
        	this.aux = primero;
        	this.anterior = primero;
        }

        @Override
        public boolean hasNext() {
            return this.aux.getSigNodo()!=null;
        }

        @Override
        public Nodo next() {
        	if(aux == anterior) {
        		Nodo a = this.aux.getSigNodo();
        		this.aux = this.aux.getSigNodo();
        		return a;
        	}else {
        		Nodo a = this.aux.getSigNodo();
        		this.aux = this.aux.getSigNodo();
        		this.anterior = this.anterior.getSigNodo();
        		return a;
        	}
        }

        @Override
		public void remove() {
			if (this.aux != null) { // la lista no esta vacia
				if (!hasNext()) { // el siguiente es null
					if (anterior == aux) {// si se cumple todo es una lista de un solo elemento
						this.anterior = null;
						this.aux = null;
					} else {
						this.anterior.setSigNodo(null);
					}
				} else {
					this.anterior.setSigNodo(this.aux.getSigNodo());
					this.aux.setSigNodo(null);
				}

				this.anterior.setSigNodo(this.aux.getSigNodo());
				this.aux.setSigNodo(null);
			}
 /*    		Nodo aux = this.aux.getSigNodo();
    		this.aux.setSigNodo(this.aux.getSigNodo().getSigNodo());
    		aux.setSigNodo(null);
*/      }
    }
	

	public static void main(String[] args) {
		Nodo raiz = new Nodo(1);
		Comparator comp = new ComparaPorEdad();
		Nodo n2 = new Nodo(2);
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
		int i = 0;
		for(Nodo n : raiz) {
			System.out.println("Pos: " + i++ + " Valor: " + n);
		}
		raiz.deleteAllOccurrences(n4, comp);
		for(Nodo n : raiz) {
			System.out.println("Pos: " + i++ + " Valor: " + n);
		}
/*		// System.out.println(n7.obtenerPos(9));
		// System.out.println(n2.obtenerPos(3));
		raiz.deleteNodo(10);
		raiz.deleteAllOccurrences(n9, comp);

		System.out.println(raiz);
		// System.out.println(n7);
		// System.out.println(n2); //se puede imprimir el anterior? como agregar menor
		// al primero
*/	}

}
