package me.yasser.atelier4.components;

import me.yasser.atelier4.entity.Student;
import me.yasser.atelier4.manager.EntityManagerHelper;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class StudentBeanEJB implements StudentEJB {
	@PersistenceContext(unitName = "default")
	private static EntityManager em;

	@Override
	public String registerStudent(Student std) {
		em = EntityManagerHelper.getEntityManager();
		System.out.println("! Inserting Data !\n==================================================");
		try{
			em.getTransaction().begin();
			em.persist(std);
			em.getTransaction().commit();
			System.out.println("! Opperation Successful !\n==================================================");
		} catch (Exception e)
		{
//            em.getTransaction().rollback();
			System.out.println("Opperation Unsuccessful");
			System.out.println("Here are some errors that might help\n"+e);
		}
		finally {
			em.close();
		}
		return "success";
	}

	@Override
	public Student getStudent(int id) {
		return em.find(Student.class, id);
	}
}
