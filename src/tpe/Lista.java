package tpe;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import tpe.comparador.ComparaPorEdad;

public class Lista implements Iterable<Object>{

	private Nodo raiz;
	private Nodo puntero;
	private String auxToString; //discutible
	
	public Lista(Nodo primerNodo) {
		this.raiz = primerNodo;
		this.auxToString = "";
	}
	
	//setters

	public void setRaiz(Nodo n) {
		this.raiz = n;
		this.puntero = n;
	}
	public void setPuntero(Nodo n) {
		this.puntero = n;
	}
	
	//getters
	
	public Nodo getRaiz() {
		return this.raiz;
	}
	
	public Nodo getPuntero() {
		return this.puntero;
	}
	
	//iterator
	
	public Nodo getSigNodoLista() {
		return this.puntero.getSigNodo();
	}
	public boolean hasNext() {
		return getSigNodoLista() != null;
	}
	public void next() {
		this.setPuntero(getSigNodoLista());
	}
	

	public void addNodo(Nodo otro, Comparator<Nodo> comp) { //asumimos que el nodo que agregamos no apunta a nada. 
		if(this.puntero!=null) {							//Tenemos que tener en cuenta si apunta a algo?
			if(comp.compare(raiz, otro) == 1) {
				otro.setSigNodo(raiz);
				this.setRaiz(otro);
			}else 
				if(!hasNext()) {
					puntero.setSigNodo(otro);
					this.setPuntero(raiz);	
				}
				else
					if(comp.compare(this.puntero.getSigNodo(), otro) == 1) {
						otro.setSigNodo(getSigNodoLista());
						this.puntero.setSigNodo(otro);
						this.setPuntero(raiz);
					}
					else {
						this.next();
						this.addNodo(otro, comp);//recursion			
					}
		}else
			this.setRaiz(otro);
	}
	
	public void deleteSig() {
		Nodo aux = this.puntero.getSigNodo();
		this.puntero.setSigNodo(this.puntero.getSigNodo().getSigNodo());
		aux.setSigNodo(null);
	}
	
	public void deleteAllOccurrences(Nodo otro, Comparator<Nodo>comp) {
/*
 * Funciona de pelos
 * */
 		if(this.puntero!=null) {			
			if (comp.compare(this.puntero, otro) == 0) {//si es el primero, se elimina y apunta al segundo y se vuelve a
				this.raiz = this.raiz.getSigNodo();		//llamar la funcion
				this.puntero.setSigNodo(null);
				this.puntero = this.raiz;
				this.deleteAllOccurrences(otro, comp); //funciona
			}else 
				if(this.puntero.getSigNodo()!=null) {
					if (comp.compare(this.puntero.getSigNodo(), otro) == 0) {// si no es donde estas parado y es el
						this.deleteSig();									// siguiente, lo borra y se vuelve a llamar
						//System.out.println(this.puntero.getSigNodo());
						this.deleteAllOccurrences(otro, comp);
					}else if(((comp.compare(this.puntero, this.puntero.getSigNodo()) >= 0) &&
							(comp.compare(this.puntero.getSigNodo(), otro) == 1))
							//si esta ordenado de mayor a menor (siendo menor o igual el siguiente) 
							//y el siguiente es mayor al buscado, sigue. Si se pone == no recorre si son iguales
							||
							((comp.compare(this.puntero, this.puntero.getSigNodo()) <= 0) &&
							(comp.compare(this.puntero.getSigNodo(), otro) == -1)))  {
							//si esta ordenado de menor a mayor (siendo mayor o igual el siguiente) 
							//y el siguiente es menor al buscado, sigue. Si se pone == no recorre si son iguales
								this.next();
								this.deleteAllOccurrences(otro, comp);
					}
				}
			this.setPuntero(this.raiz);
		}

	}
	
	public void deleteByPos(int pos) {
		if (this.puntero!=null && pos>=0) {
			if (pos == 0){
				this.raiz = this.raiz.getSigNodo();
				this.puntero.setSigNodo(null);
				this.puntero = this.raiz;
			}
			else if (this.puntero.getSigNodo() != null) {
				if (pos == 1)
					this.deleteSig();
			}
			if (pos > 1) {
				this.puntero = this.puntero.getSigNodo();
				pos--;
				deleteByPos(pos);
			}
		}
	}
	
	
	
	public String toString() {//no se como hacer para no usar un auxiliar
		if(this.puntero!=null) {
			while(this.hasNext()) {
				auxToString+=this.puntero.toString() + " ";
				this.next();
			}
			auxToString+=this.puntero.toString();
			String resultado = auxToString;
			auxToString = "";
			this.setPuntero(this.raiz);
			return resultado;			
		}else
			return "Lista vacia"; //ver otra forma de informar esto
	}
	/*
	public void addLista(Lista otraRaiz) {
		
	}
	*/	
/*	
	public void deleteLista() {
		this.aux.getSigNodo();
		this.aux = null;
		this.raiz = null; //esta feo porque se hace muchas veces pero no se me ocurre otra
	}
*/	
	
	
	
	
	
	//zona de pruebas >:D
	

	public Iterator<Object> iterator() {
		return new IteradorNodos();
	}
	
	private class IteradorNodos implements Iterator<Object>{
		private Nodo actual;
        public IteradorNodos(){
        	this.actual = raiz;
        }

        @Override
        public boolean hasNext() {
            return this.actual!=null;
        }

        @Override
        public Object next() {
        	Object aux=this.actual.getId();
        	this.actual = this.actual.getSigNodo();
        	return aux;
        }

    }
	
	
	public static void main(String[] args) {
		Comparator comp = new ComparaPorEdad();
		Nodo n0 = new Nodo(0);
		Nodo n01 = new Nodo(0);
		Nodo n02 = new Nodo(0);
		Nodo n03 = new Nodo(0);
		Nodo n11 = new Nodo(1);
		Nodo n12 = new Nodo(1);
		Nodo n13 = new Nodo(1);
		Nodo n21 = new Nodo(2);
		Nodo n22 = new Nodo(2);
		Nodo n23 = new Nodo(2);
		Nodo n31 = new Nodo(3);
		Nodo n32 = new Nodo(3);
		Nodo n33 = new Nodo(3);
		Nodo n41 = new Nodo(4);
		Nodo n42 = new Nodo(4);
		Nodo n43 = new Nodo(4);
		Lista raiz = new Lista(n0);
/*		raiz.addNodo(n01, comp);
		raiz.addNodo(n02, comp);
		raiz.addNodo(n03, comp);
*/		raiz.addNodo(n12, comp);
		raiz.addNodo(n13, comp);
		raiz.addNodo(n0, comp);
		raiz.addNodo(n21, comp);
		raiz.addNodo(n22, comp);
		raiz.addNodo(n23, comp);
		raiz.addNodo(n31, comp);
		raiz.addNodo(n32, comp);
		raiz.addNodo(n33, comp);
		raiz.addNodo(n41, comp);
		raiz.addNodo(n42, comp);
		raiz.addNodo(n43, comp);
		for(Object nodo : raiz) {
			System.out.println(nodo);
		}
		System.out.println("----");
		System.out.println(raiz);
		
		raiz.deleteAllOccurrences(n0, comp);
		System.out.println("Delete all ocurrences "+n0);
		for(Object nodo : raiz) {
			System.out.println(nodo);
		}
		
		System.out.println("Borrar en posicion 11");
		raiz.deleteByPos(11);
		
		for(Object nodo : raiz) {
			System.out.println(nodo);
		}
//		raiz.addNodo(n3, comp);
//		raiz.addNodo(n11, comp);
//		System.out.println(raiz);
//		System.out.println(raiz);
//		raiz.deleteAllOccurrences(n41, comp);
//		System.out.println(raiz);
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
