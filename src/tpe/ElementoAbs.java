package tpe;

public abstract class ElementoAbs<T> {

	private String nombre;
	
	public ElementoAbs(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract int getCantidad();
	
	public boolean equals(ElementoAbs<T> o) { //no deberia ser object??
		try {
			ElementoAbs<T> e = (ElementoAbs<T>) o;
			if(this.getNombre().equals(e.getNombre()))
				return true;
			else
				return false;
			
		}catch(Exception e) {
			return false;
		}
	}
}
