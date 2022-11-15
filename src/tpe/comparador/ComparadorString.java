package tpe.comparador;

import java.util.Comparator;

import tpe.Alumno;

public class ComparadorString implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		if(s1.compareTo(s2) >= 1)
			return 1;
		else if(s1.compareTo(s2) <= -1)
			return -1;
		else
			return 0;
	}
}
