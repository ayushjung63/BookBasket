package BookBasket.utils;

import org.hibernate.cfg.Configuration;

/*Singelton PRincieple*/
public class SessionFactory {
	
	private static org.hibernate.SessionFactory instance;
	
	public static org.hibernate.SessionFactory getInstance() {
		if(instance==null) {
			instance=new Configuration().configure().buildSessionFactory();
		}
		return instance;
	}
	
}
