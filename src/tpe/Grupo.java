package tpe;

import java.util.Comparator;

import lista.*;

public class Grupo extends ElementoAbs{
	
	private Lista listaElementos;
	
	public Grupo(String nombre, Comparator<Object> comp) {
		super(nombre);
		this.listaElementos = new Lista(comp);
	}

	public int getCantidad() {
		int aux = 0;
		for(Object n : listaElementos) {
			ElementoAbs nn = (ElementoAbs) n;
			aux += nn.getCantidad();
		}
		return aux;
	}
	
	public void addElemento(ElementoAbs e) {
		if(this.listaElementos.obtenerPos(e) == -1) {
			Nodo aAgregar = new Nodo(e);
			this.listaElementos.addNodo(aAgregar);
		}
	}
	
	public String toString() {
		return this.getNombre() + ": " + "[" + this.listaElementos.toString() + "]" + "\n";
	}	
	
}
