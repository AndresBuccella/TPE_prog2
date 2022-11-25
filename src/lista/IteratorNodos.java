package lista;

import java.util.Iterator;

public class IteratorNodos<T> implements Iterator<T> {
	private Nodo<T> actual;

	public IteratorNodos(Nodo<T> raiz) {
			this.actual = raiz;
		}

	@Override
	public boolean hasNext() {
		return this.actual != null;
	}

	@Override
	public T next() {
		T aux = this.actual.getContenido();
		this.actual = this.actual.getSigNodo();
		return aux;
	}


}
