package hbt;

import java.util.ArrayList;
import java.util.List;

import entity.Unidad;

public class HibernateUnidades {
	
	private static HibernateUnidades hu = null;
	
	public static HibernateUnidades getInstance(){
		if(hu==null)hu = new HibernateUnidades();
		return hu;
	}
	
	
	public List<Unidad> getUnidades(){
		List<Unidad> unidades = new ArrayList<Unidad>();
		for (Object unidad : HibernateDAO.getInstance().getLista("Unidad")) {
			unidades.add((Unidad)unidad);
		}
		return unidades;
	}

}
