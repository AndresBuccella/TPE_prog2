package lista;

import java.util.Comparator;
import java.util.Iterator;

import tpe.*;
import tpe.comparador.*;

public class Lista implements Iterable<Object> { // objeto o nodo?

	private Nodo raiz;
	private Nodo puntero;
	private String auxToString; // discutible
	private Comparator<Object> comp;
	
	public Lista(Nodo primerNodo, Comparator<Object>comp) {
		this.setOrigen(primerNodo);
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

	public void addNodo(Nodo otro) {
		if (otro != null && otro.getContenido() != null) { // esta bien que 50000 veces pregunte lo mismo siendo que no
			if (this.puntero != null) {					  // cambia?
				if (comp.compare(raiz.getContenido(), otro.getContenido()) == 1) {
					otro.setSigNodo(raiz);
					this.setOrigen(otro);
				} else 
					if (!hasNext()) {
						puntero.setSigNodo(otro);
						this.setPuntero(raiz);
				} else 
					if (comp.compare(this.puntero.getSigNodo().getContenido(), otro.getContenido()) == 1) {
						otro.setSigNodo(getSigNodoLista());
						this.puntero.setSigNodo(otro);
						this.setPuntero(raiz);
				} else {
					this.next();
					this.addNodo(otro);// recursion
				}
			} else
				this.setOrigen(otro);
		}else
			System.out.println("Algo de otro en addNodo es null"); //constante en codigooo!!!
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

	public void deleteAllOccurrences(Nodo otro, Comparator<Object> comp) { // esta bien que dependa de un comparator? y
																			// si otro es null?
		// tiene sentido que se le mande un objeto? SI porque puede querer eliminar por
		// dni
		// pero hay que crear un objeto cada vez que quiera eliminar
		// se tiene que crear otro objeto identico al que se quiere eliminar
		// o que posea las caracteristicas minimas
		if (otro == null) {

			System.out.println("soy null");
		} else if (otro.getContenido() == null) {

			System.out.println("mi contenido es null");
		}
		if (this.puntero != null) {
			if (comp.compare(this.puntero.getContenido(), otro.getContenido()) == 0) {// si es el primero, se elimina y
																						// apunta al segundo y se vuelve
																						// a
				this.raiz = this.raiz.getSigNodo();
				this.deleteNodo(this.puntero);
				this.puntero = this.raiz;
				this.deleteAllOccurrences(otro, comp);
			} else if (this.puntero.getSigNodo() != null) {
				if (comp.compare(this.puntero.getSigNodo().getContenido(), otro.getContenido()) == 0) {// si no es donde
																										// estas parado
																										// y es el
					this.deleteSig(); // siguiente, lo borra y se vuelve a llamar
					// System.out.println(this.puntero.getSigNodo());
					this.deleteAllOccurrences(otro, comp);
				} else if (((comp.compare(this.puntero.getContenido(), this.puntero.getSigNodo().getContenido()) >= 0)
						&& (comp.compare(this.puntero.getSigNodo().getContenido(), otro.getContenido()) == 1))
						// si esta ordenado de mayor a menor (siendo menor o igual el siguiente)
						// y el siguiente es mayor al buscado, sigue. Si se pone == no recorre si son
						// iguales
						|| ((comp.compare(this.puntero.getContenido(), this.puntero.getSigNodo().getContenido()) <= 0)
								&& (comp.compare(this.puntero.getSigNodo().getContenido(),
										otro.getContenido()) == -1))) {
					// si esta ordenado de menor a mayor (siendo mayor o igual el siguiente)
					// y el siguiente es menor al buscado, sigue. Si se pone == no recorre si son
					// iguales
					this.next();
					this.deleteAllOccurrences(otro, comp);
				}
			}
			this.setPuntero(this.raiz);
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

	public void reOrdenarPor(Comparator<Object> comp) {
//		if(this.puntero!=null) { No tiene sentido preguntar porque se supone que se carga cuando se instancia el objeto
//		}Mentira, tiene sentido, porque si eliminas todos los nodos y los queres reordenar da error
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

	public String toString() {// no se como hacer para no usar un auxiliar
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
			return "Lista vacia"; // ver otra forma de informar esto
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
			Object aux = this.actual.getContenido(); // EH ACA!
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
