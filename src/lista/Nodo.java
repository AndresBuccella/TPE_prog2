package lista;

public class Nodo<T> {

	private Nodo<T> sigNodo;
	private T contenido;

	public Nodo(T contenido) {
		this.contenido = contenido;
	}
	public void setSigNodo(Nodo<T> sig) {
		this.sigNodo = sig;
	}

	public Nodo<T> getSigNodo() {
		return this.sigNodo;
	}

	public void setContenido(T a) {
		if(this.contenido == null)
			this.contenido = a;
		else
			if (a == null)
				this.contenido = a;
	}
	
	public T getContenido() {
		return this.contenido;
	}

	
	public String toString() {
		return this.contenido.toString();
	}

}
