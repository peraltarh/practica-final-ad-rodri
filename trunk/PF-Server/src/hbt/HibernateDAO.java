package hbt;

import java.util.List;

import org.hibernate.Session;


public class HibernateDAO {
	private static HibernateDAO instance = null;
	
	public static HibernateDAO getInstance(){
		if(instance==null)instance=new HibernateDAO();
		return instance;
	}
	
	public Object save(Object obj){
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.beginTransaction();
		ses.save(obj);
		ses.getTransaction().commit();
		ses.flush();
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getLista(String className) {
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.beginTransaction();
		String querry = "from " + className;
		List<Object> listObj = ses.createQuery(querry).list();
		return listObj;
	}
	
	
	public Object getObjectWithDesc(String className, String description) {
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.beginTransaction();
		String querry = "from " + className + " s where s.descripcion=\'" + description + "\'";
		Object obj = ses.createQuery(querry).uniqueResult();
		return obj;
	}
	
	

}
