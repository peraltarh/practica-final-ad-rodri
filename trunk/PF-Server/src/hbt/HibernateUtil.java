package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entity.*;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Unidad.class);
			config.addAnnotatedClass(MateriaPrima.class);
			config.addAnnotatedClass(Producto.class);
			config.addAnnotatedClass(Elaborado.class);
			config.addAnnotatedClass(SemiElaborado.class);
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Error en la inicialización de la sesion." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
