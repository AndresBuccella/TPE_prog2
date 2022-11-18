package lista;

public class Nodo {

	private Nodo sigNodo;
	private Object contenido;

	public Nodo(Object contenido) {
		this.contenido = contenido;
	}
	public void setSigNodo(Nodo sig) {
		this.sigNodo = sig;
	}

	public Nodo getSigNodo() {
		return this.sigNodo;
	}

	public void setContenido(Object a) {
		if(this.contenido == null)
			this.contenido = a;
		else
			if (a == null)
				this.contenido = a;
	}
	
	public Object getContenido() {
		return this.contenido;
	}

	
	public String toString() {
		return this.contenido.toString();
	}

}
