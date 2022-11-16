package tpe;

import java.util.ArrayList;

public class Alumno extends ElementoAbs{ //alumno o persona?

	private String apellido;
	private int dni;
	private ArrayList<String> intereses;
	
	public Alumno(String nombre, String apellido, int dni) {
		super(nombre);
		this.apellido = apellido;
		this.dni = dni;
		this.intereses = new ArrayList<>();
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public void addInteres(String interes) {
		if(!this.intereses.contains(interes)) {
			this.intereses.add(interes);
		}
	}
	
	public int getCantidad() {
		return 1;
	}
	
	public String toString() {
		return "[" + "Nombre: " + this.getNombre() + ", " +
				"Apellido: " + this.apellido + ", " +
				"DNI: " + this.dni + 
				this.intereses + "]";
	}
	
	public boolean equals(Object o) {
		try {
			Alumno a = (Alumno) o;
			if(this.getNombre().equals(a.getNombre()) &&
					this.getApellido().equals(a.getApellido()) &&
					this.getDni() == a.getDni())
				return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
