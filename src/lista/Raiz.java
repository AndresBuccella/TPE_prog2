package lista;

public abstract class Raiz {

	//experimental
	//medio que no tiene mucho sentido, no?
	
	private Nodo raiz;
	
	public Raiz(Nodo raiz){
		this.setRaiz(raiz);
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public abstract void addNodo(Nodo nNuevo);
	
	public abstract void deleteNodo(Nodo nAEliminar);
}
