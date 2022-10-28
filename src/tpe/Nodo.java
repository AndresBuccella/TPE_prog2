package tpe;

public class Nodo implements Comparable<Nodo>{
	
	private Nodo sigNodo;
	private int id;
	
	public Nodo(int id) {
		this.id = id;
	}
	
	public void addNodo(Nodo otro) {
		
		if(this.compareTo(otro) == 1) 
			otro.setSigNodo(this);
		else if(this.compareTo(otro) == 0)
			otro.setSigNodo(this);
		else 
			//this es menor al que se quiere insertar, entonces =>
			if (this.sigNodo == null) //primero se pregunta si el siguiente esta vacio para no romper
							//al preguntar si el siguiente es mayor a otro
				this.setSigNodo(otro);
			else if (this.sigNodo.compareTo(otro) == 1) {
				otro.setSigNodo(this.getSigNodo());
				this.setSigNodo(otro);
		}else
			irAlSiguiente(otro);
	}
	
	public void irAlSiguiente(Nodo otro) {
		this.sigNodo.addNodo(otro);
	}
	
	public void setSigNodo(Nodo sig) {
		this.sigNodo = sig;
	}
	
	public Nodo getSigNodo() {
		return this.sigNodo;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		//salio de la galera JAJAJA
		if (this.sigNodo != null)
			return this.id + " " + this.sigNodo;
		return this.id + "";
	}
	
	@Override
	public int compareTo(Nodo o) {
		if(this.getId() < o.getId())
			return -1;
		else if(this.getId() > o.getId())
			return 1;
		else
			return 0;
	}
	
	public static void main(String[] args) {
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);
		Nodo n5 = new Nodo(5);
		Nodo n6 = new Nodo(6);
		Nodo n7 = new Nodo(7);
		Nodo n8 = new Nodo(8);
		Nodo n9 = new Nodo(9);
		//n1.addNodo(n1);
		n1.addNodo(n2);
		n1.addNodo(n5);
		n1.addNodo(n4);
		n1.addNodo(n7);

		System.out.println(n1);
		System.out.println(n2); //se puede imprimir el anterior?
	}


}
