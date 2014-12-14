package system;

import hbt.HibernateDAO;
import hbt.HibernateMateriales;
import hbt.HibernateUnidades;

import java.util.ArrayList;

import entity.MateriaPrima;
import entity.SemiElaborado;
import entity.Unidad;

public class System {
	
	private static System sys = null;
	
	public static System getInstance(){
		if(sys==null)sys = new System();
		return sys;
	}
	
	private System(){
	}

	public ArrayList<String> getMateriasPrimas() {
		ArrayList<String> list = new ArrayList<String>();
		for (MateriaPrima mat : (ArrayList<MateriaPrima>)HibernateMateriales.getInstance().getMateriales()) {
			list.add(mat.getDescripcion());
		}
		return list;
	}

	public ArrayList<String> getUnidades() {
		ArrayList<String> list = new ArrayList<String>();
		for (Unidad un : (ArrayList<Unidad>)HibernateUnidades.getInstance().getUnidades()) {
			list.add(un.getDescripcion());
		}
		
		return list;
	}

	public String AltaPedidoSemi(String desc, String mat, String un, String cost) {
		SemiElaborado newP = new SemiElaborado();
		newP.setDescripcion(desc);
		ArrayList<MateriaPrima> materiales = new ArrayList<MateriaPrima>();
		MateriaPrima matTemp = (MateriaPrima)HibernateDAO.getInstance().getObjectWithDesc("MateriaPrima", mat);
		materiales.add(matTemp);
		newP.setMateriales(materiales);
		Unidad unTemp = (Unidad)HibernateDAO.getInstance().getObjectWithDesc("Unidad", un);
		newP.setUnidad(unTemp);
		newP.setNumero(0);
		
		
		newP.setCostoProduccion(Float.valueOf(cost));
		HibernateDAO.getInstance().save(newP);
		
		return "Semi elaboado fue dado de alta con ID= " + newP.getNumero().toString();
		
	}
	

}
