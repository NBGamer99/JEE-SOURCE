package me.yasser.atelier4.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
	private static final EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("default");
	}
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
