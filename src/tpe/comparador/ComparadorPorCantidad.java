package tpe.comparador;

import java.util.Comparator;

import tpe.ElementoAbs;

public class ComparadorPorCantidad implements Comparator<Object>{

	public int compare(Object o1, Object o2){
		try {
		ElementoAbs e1 = (ElementoAbs) o1;
		ElementoAbs e2 = (ElementoAbs) o2;
		if(e1.getCantidad() > e2.getCantidad())
			return 1;
		else
			if(e1.getCantidad() < e2.getCantidad())
				return -1;
		return 0;
		}catch(Exception e) {
			System.out.println("No puedo porque: " + e);
			return 0;
		}
	}
}
