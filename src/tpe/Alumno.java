package tpe;

import java.util.ArrayList;

public class Alumno extends Persona{ //alumno o persona?

	private String nombre;
	private String apellido;
	private int dni;
	private ArrayList<String> intereses;
	
	public Alumno(String nombre, String apellido, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.intereses = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public String toString() {
		return "Nombre: " + this.nombre + ", " +
				"Apellido: " + this.apellido + ", " +
				"DNI: " + this.dni;
	}
}
