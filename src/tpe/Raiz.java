package tpe;

public abstract class Raiz {

	//experimental
	
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
