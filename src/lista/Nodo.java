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

	public void setContenido(Object a) { //se podria fusionar con deleteContenido?
		if(this.contenido == null)
			this.contenido = a;
		else
			if (a == null)
				this.contenido = a;
			else
				System.out.println("Ya estaba vacio, como el corazon de ella"); //CONSTANTE EN CODIGOOOOO
	}
	
	public Object getContenido() {
		return this.contenido;
	}

	
	public String toString() {
		return this.contenido.toString();
	}

}
