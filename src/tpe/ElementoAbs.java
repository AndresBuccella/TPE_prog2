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
}
