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

	public void add(T contenido) { //noanda

		
		Nodo<T> nNuevo = new Nodo<T>(contenido);
		if (this.raiz == null) {
			this.raiz = nNuevo;
		}else {
			Nodo<T> puntero = raiz;
			while(puntero.getSigNodo()!=null && (comp.compare(puntero.getSigNodo().getContenido(), contenido) < 1)) {
				puntero = puntero.getSigNodo();
				System.out.println("1");
			}
			if(puntero.getSigNodo()==null) {
				puntero.setSigNodo(nNuevo);
				System.out.println("2");
			}else {
				nNuevo.setSigNodo(puntero.getSigNodo());
				puntero = nNuevo;
				System.out.println("3");
			}
		}
			
	/*	boolean nodoAgregado = false;  FUNCIONA PERO TIENE BOOLEAN
	 * if (this.raiz != null) {
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
			raiz = nNuevo;*/

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
	}

	public void deleteAllOccurrences(T contenido) {
		if(this.raiz!=null) {
			Nodo<T> puntero = this.raiz;
			while(puntero!=null) {
				if(puntero.getContenido().equals(contenido)) {
					puntero = puntero.getSigNodo();
					this.deleteNodo(this.raiz);
					this.raiz = puntero;
				}else {
					while(puntero.getSigNodo()!=null) {
						if (!puntero.getSigNodo().getContenido().equals(contenido)) {
							puntero = puntero.getSigNodo();							
						}else
							this.deleteSig(puntero);
					}
				}
				puntero = puntero.getSigNodo();
			}
		}
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
	}

	public String toString() {// V
		Nodo<T> puntero = this.raiz;
		String aux = "";
		while(puntero!=null) {
			aux += puntero.toString() + "\n";
			puntero = puntero.getSigNodo();
		}
		return aux;
	 }

	public Iterator<T> iterator() { // V
		return new IteratorNodos<T>(this.raiz);
	}
}