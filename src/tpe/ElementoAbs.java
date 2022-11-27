package tpe;

public abstract class ElementoAbs {

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
	
	public boolean equals(Object o) {
		try {
			ElementoAbs e = (ElementoAbs) o;
			if(this.getNombre().equals(e.getNombre()))
				return true;
			else
				return false;
			
		}catch(Exception e) {
			return false;
		}
	}
}
