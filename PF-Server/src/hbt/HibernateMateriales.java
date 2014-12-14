package hbt;

import java.util.ArrayList;
import java.util.List;

import entity.MateriaPrima;

public class HibernateMateriales {

	private static HibernateMateriales hu = null;
	
	public static HibernateMateriales getInstance(){
		if(hu==null)hu = new HibernateMateriales();
		return hu;
	}
	
	
	public List<MateriaPrima> getMateriales(){
		List<MateriaPrima> materiales = new ArrayList<MateriaPrima>();
		for (Object mat : HibernateDAO.getInstance().getLista("MateriaPrima")) {
			materiales.add((MateriaPrima)mat);
		}
		return materiales;
	}

	
	
}
