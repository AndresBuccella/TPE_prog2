package tpe;

import java.util.Comparator;

import lista.*;

public class Grupo<T> extends ElementoAbs<T>{
	
	private Lista<ElementoAbs<T>> listaElementos;
	
	public Grupo(String nombre, Comparator<ElementoAbs<T>> comp) {
		super(nombre);
		this.listaElementos = new Lista<ElementoAbs<T>>(comp);
	}

	public int getCantidad() {
		int aux = 0;
		for(ElementoAbs<T> n : listaElementos) {
			aux += n.getCantidad();
		}
		return aux;
	}
	
	public void addElemento(ElementoAbs<T> e) {
		if(this.listaElementos.obtenerPos(e) == -1) {
			this.listaElementos.add(e);
		}
	}
	
	public String toString() {
		return this.getNombre() + ": " + "[" + this.listaElementos.toString() + "]" + "\n";
	}	
	
}
