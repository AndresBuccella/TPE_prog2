package lista;

import java.util.Comparator;
import java.util.Iterator;


public class Lista<T> implements Iterable<T> {

	private Nodo<T> raiz;
	private Comparator<T> comp;
	private int cantNodos;

	public Lista(Comparator<T> comp) {
		this.comp = comp;
		this.cantNodos = 0;
	}

	public void setRaiz(Nodo<T> n) {
		this.raiz = n;
	}

	public Nodo<T> getRaiz() {
		return this.raiz;
	}

	public void setComparador(Comparator<T> comp) {
		this.comp = comp;
		this.cantNodos = 0; // se reinicia la cuenta para reordenar
		this.reOrdenar();
	}

	public int getCantNodos() {
		return this.cantNodos;
	}

	public void add(T contenido) { // funciona pero no se me ocurrio sc sin el boolean que corte

		boolean nodoAgregado = false;
		Nodo<T> nNuevo = new Nodo<T>(contenido);
		if (this.raiz != null) {
			Nodo<T> puntero = raiz;
			if (comp.compare(puntero.getContenido(), contenido) >= 1) {// primero
				nNuevo.setSigNodo(raiz);
				this.setRaiz(nNuevo);
			} else {
				while ((puntero.getSigNodo() != null) && (!nodoAgregado)) {// medio
					if (comp.compare(puntero.getSigNodo().getContenido(), contenido) >= 1) {
						nNuevo.setSigNodo(puntero.getSigNodo());
						puntero.setSigNodo(nNuevo);
						nodoAgregado = true;
					}
					puntero = puntero.getSigNodo();
				}
				if (!nodoAgregado)// ultimo
					puntero.setSigNodo(nNuevo);
			}
		} else
			raiz = nNuevo;

		this.cantNodos++;
	}

	public void deleteSig(Nodo<T> puntero) {
		Nodo<T> aux = puntero.getSigNodo();
		puntero.setSigNodo(puntero.getSigNodo().getSigNodo());
		this.deleteNodo(aux);
	}

	public void deleteNodo(Nodo<T> aEliminar) {
		aEliminar.setContenido(null);
		aEliminar.setSigNodo(null);
		this.cantNodos--;
	}

	public void deleteAllOccurrences(T contenido) {//FALTAAAAAAAAAAAAAAAAAA
		if(this.raiz!=null) {
			Nodo<T> puntero = this.raiz;
			while(puntero!=null) {
				if(comp.compare(puntero.getContenido(), contenido) == 0) {
					puntero = puntero.getSigNodo();
					this.deleteNodo(this.raiz);
					this.raiz = puntero;
				}
				
			puntero = puntero.getSigNodo();
			}
/*			if((siguiente==null) && (comp.compare(actual.getContenido(), contenido) == 0))
			if(comp.compare(actual.getContenido(), contenido) == 0){
				this.deleteNodo(this.raiz);
				this.raiz = siguiente;
				actual = siguiente;
				siguiente = siguiente.getSigNodo();
			}
			while((comp.compare(puntero.getSigNodo().getContenido(), contenido) != 0)&&
					puntero.getSigNodo()!=null) {
				
			}*/		
		}
		
		
		
		
		
		
		
/*		if (this.raiz != null) {
			Nodo puntero = raiz;
			while ((puntero.getSigNodo() != null)&&(comp.compare(puntero.getContenido(), otro.getContenido()) >= 1)) {
				puntero = puntero.getSigNodo();
			}
			if (pos == 0) {
				if (puntero.getSigNodo() == null) {
					raiz = null;
					this.cantNodos = 0;
				} else {
					puntero = puntero.getSigNodo();
					this.deleteNodo(this.raiz);
					this.raiz = puntero;
				}
			} else {
				if (pos == 1)
					this.deleteSig(puntero);
			}

		}
		
		
		if (otro == null) {
			System.out.println("soy null");
		} else {
			if (this.puntero != null) {
				if (this.puntero.getContenido().equals(otro)) {// si es elprimero, se elimina y // apunta al segundo y
																// se vuelve a llamar this.raiz =
					this.raiz.getSigNodo();
					this.deleteNodo(this.puntero);
					this.puntero = this.raiz;
					this.deleteAllOccurrences(otro);
				} else if (this.puntero.getSigNodo() != null) {
					if (this.puntero.getSigNodo().getContenido().equals(otro)) {// si no es donde //estas parado y es el
																				// siguiente, lo borra y se vuelve a
																				// llamar
						this.deleteSig();
						this.deleteAllOccurrences(otro);
					} else {
						this.next();
						this.deleteAllOccurrences(otro);
					}
				}
				this.setPuntero(this.raiz);
			}
		}*/

	}

	public void deleteByPos(int pos) { //V
		if ((this.raiz != null) && (pos < cantNodos)) {
			Nodo<T> puntero = raiz;
			while ((puntero.getSigNodo() != null) && (pos > 1)) {
				puntero = puntero.getSigNodo();
				pos--;
			}
			if (pos == 0) {
				if (puntero.getSigNodo() == null) {
					raiz = null;
					this.cantNodos = 0;
				} else {
					puntero = puntero.getSigNodo();
					this.deleteNodo(this.raiz);
					this.raiz = puntero;
				}
			} else {
				if (pos == 1)
					this.deleteSig(puntero);
			}

		}
	}

	public int obtenerPos(T o1) { // ????????????????????????? para que era???
		int contador = 0;
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			if (o1.equals(it.next()))
				return contador;
			else
				contador++;
		}
		return -1;
	}

	private void reOrdenar() { // V

		
		if (this.raiz != null) {
			if (this.raiz.getSigNodo() != null) {
				Nodo<T> puntero = this.raiz;
				this.raiz = null;
				Nodo<T> nodoAux;
				while (puntero != null) {
					nodoAux = puntero;
					puntero = puntero.getSigNodo();
					nodoAux.setSigNodo(null);
					this.add(nodoAux.getContenido());
				}
			}

		}
		
		
/* Asi lo planteo Mati, pero no sirve para nuestro codigo
 * 
 * 		if (this.raiz != null) {
			Nodo<T> puntero = this.raiz;
			this.raiz = null;
			while (puntero != null) {
				this.addNodo(puntero);
				puntero = puntero.getSigNodo();
			}
		}*/
		
/*		if (this.raiz != null) {
			if (this.raiz.getSigNodo() != null) {
				Nodo<T> puntero = this.raiz.getSigNodo();
				this.raiz.setSigNodo(null);
				this.cantNodos++;
				Nodo<T> nodoAux;
				while (puntero != null) {
					nodoAux = puntero;
					puntero = puntero.getSigNodo();
					nodoAux.setSigNodo(null);
					this.addNodo(nodoAux);
				}
			}

		}*/
	}

//	public String toString() {// es necesario??

	/*
	 * if (this.puntero != null) { while (this.hasNext()) { auxToString +=
	 * this.puntero.toString() + " "; this.next(); } auxToString +=
	 * this.puntero.toString(); String resultado = auxToString; auxToString = "";
	 * this.setPuntero(this.raiz); return resultado; } else return null;
	 */
	// }

	public Iterator<T> iterator() { // mandar Nodo raiz
		return new IteratorNodos<T>(this.raiz);
	}
}
