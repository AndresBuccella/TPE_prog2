package tpe;

import java.util.Comparator;

import lista.*;

public class Grupo extends ElementoAbs{
	
	private Lista<ElementoAbs> listaElementos;
	
	public Grupo(String nombre, Comparator<ElementoAbs> comp) {
		super(nombre);
		this.listaElementos = new Lista<ElementoAbs>(comp);
	}

	public int getCantidad() {
		int aux = 0;
		for(ElementoAbs n : listaElementos) {
			aux += n.getCantidad();
		}
		return aux;
	}
	
	public void addElemento(ElementoAbs e) {
		if(this.listaElementos.obtenerPos(e) == -1) {
			this.listaElementos.add(e);
		}
	}
	
	public String toString() {
		return this.getNombre() + ": " + "[" + this.listaElementos.toString() + "]" + "\n";
	}
/*	
	public boolean equals(Object o) { //?????????????????????????????????????????????
		
		return false;
	}
*/	
}
