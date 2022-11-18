package lista;

import java.util.Comparator;
import java.util.Iterator;

import tpe.*;
import tpe.comparador.*;

public class Lista implements Iterable<Object> {

	private Nodo raiz;
	private Nodo puntero;
	private String auxToString;
	private Comparator<Object> comp;
	
	public Lista(Comparator<Object>comp) {
		this.auxToString = "";
		this.comp = comp;
	}

	// setters

	public void setOrigen(Nodo n) {
		if (n != null) {
			this.setRaiz(n);
			this.setPuntero(n);
		}
	}

	public void setRaiz(Nodo n) {
		this.raiz = n;
	}

	public void setPuntero(Nodo n) {
		this.puntero = n;
	}
	public void setComparador(Comparator<Object> comp) {
		this.comp = comp;
	}

	// getters

	public Nodo getRaiz() {
		return this.raiz;
	}

	public Nodo getPuntero() {
		return this.puntero;
	}

	// recorrido interno

	public Nodo getSigNodoLista() {
		return this.puntero.getSigNodo();
	}

	public boolean hasNext() {
		return getSigNodoLista() != null;
	}

	public void next() {
		this.setPuntero(getSigNodoLista());
	}
	
	public int cantNodos() {
		int contador = 0;
		Iterator<Object> it = iterator();
		for(Object n : this) {
			contador++;
		}
		return contador;		
	}
	
	public void addNodo(Nodo otro) {
		if (otro != null && otro.getContenido() != null) {
			if (this.puntero != null) {
				if (comp.compare(raiz.getContenido(), otro.getContenido()) >= 1) {
					otro.setSigNodo(raiz);
					this.setOrigen(otro);
				} else 
					if (!hasNext()) {
						puntero.setSigNodo(otro);
						this.setPuntero(raiz);
				} else 
					if (comp.compare(this.puntero.getSigNodo().getContenido(), otro.getContenido()) >= 1) {
						otro.setSigNodo(getSigNodoLista());
						this.puntero.setSigNodo(otro);
						this.setPuntero(raiz);
				} else {
					this.next();
					this.addNodo(otro);
				}
			} else
				this.setOrigen(otro);
		}
	}

	public void deleteSig() {
		Nodo aux = this.puntero.getSigNodo();
		this.puntero.setSigNodo(this.puntero.getSigNodo().getSigNodo());
		this.deleteNodo(aux);
	}

	public void deleteNodo(Nodo aEliminar) {
		aEliminar.setContenido(null);
		aEliminar.setSigNodo(null);
	}

	public void deleteAllOccurrences(Object otro) {
		if (otro == null) {
			System.out.println("soy null");
		}else {
			if (this.puntero != null) {
				if (this.puntero.getContenido().equals(otro)) {// si es el primero, se elimina y
																// apunta al segundo y se vuelve a llamar
					this.raiz = this.raiz.getSigNodo();
					this.deleteNodo(this.puntero);
					this.puntero = this.raiz;
					this.deleteAllOccurrences(otro);
				} else if (this.puntero.getSigNodo() != null) {
					if (this.puntero.getSigNodo().getContenido().equals(otro)) {// si no es donde
											// estas parado y es el siguiente, lo borra y se vuelve a llamar
						this.deleteSig(); 
						this.deleteAllOccurrences(otro);
					} else{
						this.next();
						this.deleteAllOccurrences(otro);
					}
				}
				this.setPuntero(this.raiz);
			}
		}

	}

	public void deleteByPos(int pos) {
		if (this.puntero != null && pos >= 0) {
			if (pos == 0) {
				this.raiz = this.raiz.getSigNodo();
				this.puntero.setSigNodo(null);
				this.puntero = this.raiz;
			} else if (this.puntero.getSigNodo() != null) {
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
	
	public int obtenerPos(Object o1) {
		int contador = 0;
		Iterator<Object> it = iterator();
		while (it.hasNext()) {
			if (o1.equals(it.next()))
				return contador;
			else
				contador++;
		}
		return -1;
	}

	public void reOrdenarPor(Comparator<Object> comp) {
		this.setComparador(comp);
		if(this.puntero!=null) {
			if(this.puntero.getSigNodo()!=null) {
				Nodo nAux = this.puntero.getSigNodo();
				Nodo AuxDeAux;
				this.puntero.setSigNodo(null);
				while(nAux != null) {
					AuxDeAux = nAux;
					nAux = nAux.getSigNodo();
					AuxDeAux.setSigNodo(null);
					this.addNodo(AuxDeAux);
				}
			}
		}
	}

	public String toString() {
		if (this.puntero != null) {
			while (this.hasNext()) {
				auxToString += this.puntero.toString() + " ";
				this.next();
			}
			auxToString += this.puntero.toString();
			String resultado = auxToString;
			auxToString = "";
			this.setPuntero(this.raiz);
			return resultado;
		} else
			return null;
	}
	
	public Iterator<Object> iterator() {
		return new IteradorNodos();
	}

	private class IteradorNodos implements Iterator<Object> {
		private Nodo actual;

		public IteradorNodos() {
			this.actual = raiz;
		}

		@Override
		public boolean hasNext() {
			return this.actual != null;
		}

		@Override
		public Object next() {
			Object aux = this.actual.getContenido();
			this.actual = this.actual.getSigNodo();
			return aux;
		}

	}

	public void probando() {
		Nodo nAux;
		for (nAux = this.raiz; nAux!= null; nAux = nAux.getSigNodo()) {
			System.out.println(nAux);
		}
	}
}
