package lista;

import java.util.Comparator;
import java.util.Iterator;

import tpe.*;
import tpe.comparador.*;

public class Lista implements Iterable<Object>{ //objeto o nodo?

	private Nodo raiz;
	private Nodo puntero;
	private String auxToString; //discutible
	
	public Lista(Nodo primerNodo) {
		this.setOrigen(primerNodo);
		this.auxToString = "";
	}
	
	//setters

	public void setOrigen(Nodo n) {
		if(n!=null) {
			this.setRaiz(n);
			this.setPuntero(n);			
		}
	}
	public void setRaiz(Nodo n) {
		this.raiz = n;
	}
	
	public void setPuntero(Nodo n) {
		this.puntero = n;
	}
	
	//getters
	
	public Nodo getRaiz() {
		return this.raiz;
	}
	
	public Nodo getPuntero() {
		return this.puntero;
	}
	
	//recorrido interno
	
	public Nodo getSigNodoLista() {
		return this.puntero.getSigNodo();
	}
	public boolean hasNext() {
		return getSigNodoLista() != null;
	}
	public void next() {
		this.setPuntero(getSigNodoLista());
	}
	

	public void addNodo(Nodo otro, Comparator<Object> comp) { 
		if(otro!=null && otro.getContenido()!=null) { //esta bien que 50000 veces pregunte lo mismo siendo que no cambia?
			if(this.puntero!=null) {
				if(comp.compare(raiz.getContenido(), otro.getContenido()) == 1) {
					otro.setSigNodo(raiz);
					this.setOrigen(otro);
				}else 
					if(!hasNext()) {
						puntero.setSigNodo(otro);
						this.setPuntero(raiz);	
					}
					else
						if(comp.compare(this.puntero.getSigNodo().getContenido(), otro.getContenido()) == 1) {
							otro.setSigNodo(getSigNodoLista());
							this.puntero.setSigNodo(otro);
							this.setPuntero(raiz);
						}
						else {
							this.next();
							this.addNodo(otro, comp);//recursion			
						}
			}else
				this.setOrigen(otro);
		}
	}

	public void deleteSig() {
		Nodo aux = this.puntero.getSigNodo();
		this.puntero.setSigNodo(this.puntero.getSigNodo().getSigNodo());
		this.deleteNodo(aux);
	}
	public void deleteNodo(Nodo aEliminar) {
		aEliminar.setContenido(null);
		aEliminar.setSigNodo(null);
	}
	
	public void deleteAllOccurrences(Nodo otro, Comparator<Object>comp) { //esta bien que dependa de un comparator? y si otro es null?
		//tiene sentido que se le mande un objeto? SI porque puede querer eliminar por dni
		//pero hay que crear un objeto cada vez que quiera eliminar
		//se tiene que crear otro objeto identico al que se quiere eliminar
		//o que posea las caracteristicas minimas
		if(otro == null) {

			System.out.println("soy null");
		}else if (otro.getContenido() == null){

			System.out.println("mi contenido es null");
		}
 		if(this.puntero!=null) {	
			if (comp.compare(this.puntero.getContenido(), otro.getContenido()) == 0) {//si es el primero, se elimina y apunta al segundo y se vuelve a
				this.raiz = this.raiz.getSigNodo();
				this.deleteNodo(this.puntero);
				this.puntero = this.raiz;
				this.deleteAllOccurrences(otro, comp);
			}else
				if(this.puntero.getSigNodo()!=null) {
					if (comp.compare(this.puntero.getSigNodo().getContenido(), otro.getContenido()) == 0) {// si no es donde estas parado y es el
						this.deleteSig();									// siguiente, lo borra y se vuelve a llamar
						//System.out.println(this.puntero.getSigNodo());
						this.deleteAllOccurrences(otro, comp);
					}else if(((comp.compare(this.puntero.getContenido(), this.puntero.getSigNodo().getContenido()) >= 0) &&
							(comp.compare(this.puntero.getSigNodo().getContenido(), otro.getContenido()) == 1))
							//si esta ordenado de mayor a menor (siendo menor o igual el siguiente) 
							//y el siguiente es mayor al buscado, sigue. Si se pone == no recorre si son iguales
							||
							((comp.compare(this.puntero.getContenido(), this.puntero.getSigNodo().getContenido()) <= 0) &&
							(comp.compare(this.puntero.getSigNodo().getContenido(), otro.getContenido()) == -1)))  {
							//si esta ordenado de menor a mayor (siendo mayor o igual el siguiente) 
							//y el siguiente es menor al buscado, sigue. Si se pone == no recorre si son iguales
								this.next();
								this.deleteAllOccurrences(otro, comp);
					}
				}
			this.setPuntero(this.raiz);
		}

	}
	
	public void deleteByPos(int pos) {
		if (this.puntero!=null && pos>=0) {
			if (pos == 0){
				this.raiz = this.raiz.getSigNodo();
				this.puntero.setSigNodo(null);
				this.puntero = this.raiz;
			}
			else if (this.puntero.getSigNodo() != null) {
				if (pos == 1)
					this.deleteSig();
			}
			if (pos > 1) {
				this.puntero = this.puntero.getSigNodo();
				pos--;
				deleteByPos(pos);
			}
		}
	}
	
	public void reOrdenarPor(Comparator<Alumno> comp){
		
	}
	
	
	public String toString() {//no se como hacer para no usar un auxiliar
		if(this.puntero!=null) {
			while(this.hasNext()) {
				auxToString+=this.puntero.toString() + " ";
				this.next();
			}
			auxToString+=this.puntero.toString();
			String resultado = auxToString;
			auxToString = "";
			this.setPuntero(this.raiz);
			return resultado;			
		}else
			return "Lista vacia"; //ver otra forma de informar esto
	}
	
	public Iterator<Object> iterator() {
		return new IteradorNodos();
	}
	
	private class IteradorNodos implements Iterator<Object>{
		private Nodo actual;
        public IteradorNodos(){
        	this.actual = raiz;
        }

        @Override
        public boolean hasNext() {
            return this.actual!=null;
        }

        @Override
        public Object next() {
        	Object aux=this.actual.getContenido();    //EH ACA!
        	this.actual = this.actual.getSigNodo();
        	return aux;
        }

    }
	
	public void probando(Lista l) {
		for (Object n : l) {
			System.out.println(n);
		}
	}
	
	public static void main(String[] args) {
		Alumno a = new Alumno("Andres", "Buccella", 123132123);
		Alumno b = new Alumno("Andres", "Buccella", 123132123);
		Alumno f = new Alumno("Facundo", "Corvalan", 123221123);
		Nodo n0 = new Nodo(a);
		Nodo n01 = new Nodo(f);
		Nodo n02 = new Nodo(b);
		Nodo n43 = new Nodo(4);
		Lista raiz = new Lista(n0);
		Comparator comp = new ComparaPorNombre();
		raiz.addNodo(n01, comp);
/*		raiz.addNodo(n02, comp);
		raiz.addNodo(n03, comp);
*//*		for(Object nodo : raiz) {
			System.out.println(nodo);
		}
		System.out.println("----");
		System.out.println(raiz);
		
*/		raiz.deleteAllOccurrences(n02, comp);
		System.out.println(raiz);
/*		System.out.println("Delete all ocurrences "+n0);
		for(Object nodo : raiz) {
			System.out.println(nodo);
		}
		
		System.out.println("Borrar en posicion 11");
		raiz.deleteByPos(11);
		
		for(Object nodo : raiz) {
			System.out.println(nodo);
		}
//		raiz.addNodo(n3, comp);
//		raiz.addNodo(n11, comp);
//		System.out.println(raiz);
//		System.out.println(raiz);
//		raiz.deleteAllOccurrences(n41, comp);
//		System.out.println(raiz);
//		System.out.println(n0);
//		System.out.println(n1);
//		System.out.println(n2);
		//System.out.println(n0);
		
		// n1.addNodo(n1);
/*		raiz.addNodo(n9, comp);
		raiz.addNodo(n4, comp);
		raiz.addNodo(n3, comp);
		raiz.addNodo(n6, comp);
		raiz.addNodo(n5, comp);
		raiz.addNodo(n7, comp);
		raiz.addNodo(n8, comp);
		raiz.addNodo(n2, comp);
		raiz.addNodo(n10, comp);
		raiz.addNodo(n11, comp);
*/		
		// System.out.println(n7.obtenerPos(9));
		// System.out.println(n2.obtenerPos(3));
		//raiz.deleteNodo(10);
		

		//System.out.println(raiz);
		//raiz.deleteAllOccurrences(n1, comp);
		//System.out.println(raiz);
		// System.out.println(n7);
		// System.out.println(n2); //se puede imprimir el anterior? como agregar menor
		// al primero
	}

}
