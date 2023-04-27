package com.ynabouzi.atelier2.controllers;

import com.ynabouzi.atelier2.manager.EntityManagerHelper;
import com.ynabouzi.atelier2.models.Registration;
import com.ynabouzi.atelier2.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

public class StudentDAO implements mainDAO<Student>{

	@PersistenceContext(unitName = "default")
	private static EntityManager em;

	@Override
	public void CreateAll(List<Student> Objs) {
		em = EntityManagerHelper.getEntityManager();
		System.out.println("! Inserting Data !\n==================================================");
		try{
			em.getTransaction().begin();
			for (Student std : Objs)
			{
				em.persist(std);
			}
			em.getTransaction().commit();
			System.out.println("! Opperation Successful !\n==================================================");
		} catch (Exception e)
		{
			em.getTransaction().rollback();
			System.out.println("Opperation Unsuccessful");
			System.out.println("Here are some errors that might help\n"+e);
		}
		finally {
			em.close();
		}
	}

	@Override
	public void ShowAll() {
			em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Student> Students = em.createNamedQuery("AllStudents", Student.class);
			System.out.println("! Showing All students !\n==================================================");
			for(Student std : Students.getResultList())
			{
				System.out.println(std.toString());
			}
			System.out.println("! Opperation Successful !\n==================================================");

		}catch (Exception e)
		{
			em.getTransaction().rollback();
			System.out.println("Opperation Unsuccessful");
			System.out.println("Here are some errors that might help\n"+e);
		} finally {
			em.close();
		}
	}

	@Override
	public void ShowByID(long id) {
			em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			Student std = em.find(Student.class, id);
			if (std == null){
				System.out.println("No student found by the id => "+id);
			}
			else {
				System.out.println(std);
			}
			System.out.println("! Opperation Successful !");
		}catch (Exception e)
		{
			em.getTransaction().rollback();
			System.out.println("Opperation Unsuccessful");
			System.out.println("Here are some errors that might help\n"+e);
		} finally {
			em.close();
		}
	}

	@Override
	public void DeleteByID(long id) {
			em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			Student std = em.find(Student.class, id);
			if (std == null){
				System.out.println("No student found by the id => "+id);
			}
			else {
				em.remove(std);
				System.out.println("The Student by the id "+id+" has been removed successfully !\n==================================================");
				em.getTransaction().commit();
			}
			System.out.println("! Opperation Successful !\n==================================================");
		}catch (Exception e)
		{
			em.getTransaction().rollback();
			System.out.println("Opperation Unsuccessful");
			System.out.println("Here are some errors that might help\n"+e);
		} finally {
			em.close();
		}
	}

	@Override
	public void UpdateByID(long id, Student toChangeTo) {
			em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			Student std = em.find(Student.class, id);
			if (std == null){
				System.out.println("No student found by the id => "+id);
			}
			else {
				String tmp = std.toString();
				String FirstName = toChangeTo.getFirstName() != null ? toChangeTo.getFirstName() : std.getFirstName();
				String LastName = toChangeTo.getLastName() != null ? toChangeTo.getLastName() : std.getLastName();
				String CIN = toChangeTo.getCIN() != null ? toChangeTo.getCIN() : std.getCIN();
				List<Registration> Re = toChangeTo.getRe() != null && !toChangeTo.getRe().isEmpty() ? toChangeTo.getRe() : std.getRe();

				std.setFirstName(FirstName);
				std.setLastName(LastName);
				std.setCIN(CIN);
				std.setRe(Re);
				System.out.println("==================================================\nBefore "+tmp);
				em.getTransaction().commit();
				System.out.println("The Student by the id "+id+" has been updated successfully !");
				System.out.println("after "+std.toString()+"\n==================================================");
			}
			System.out.println("! Opperation Successful !\n==================================================");
		}catch (Exception e)
		{
			em.getTransaction().rollback();
			System.out.println("Opperation Unsuccessful");
			System.out.println("Here are some errors that might help\n"+e);
		} finally {
			em.close();
		}
	}

	public void ShowStudentsByLvl(String lvl) {
			em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Student> Students = em.createNamedQuery("AllStudentsByLvl", Student.class);
			Students.setParameter(1, lvl);

			if (Students.getResultList().isEmpty())
			{
				System.out.println("No Students in the "+lvl+" of education yet !");
			}
			else{
				System.out.println("All Students in the "+lvl+" of education are :");
				for (Student std : Students.getResultList()) {
					System.out.println(std);
				}
			}
			System.out.println("! Opperation Successful !");
		}catch (Exception e)
		{
			em.getTransaction().rollback();
			System.out.println("Opperation Unsuccessful");
			System.out.println("Here are some errors that might help\n"+e);
		} finally {
			em.close();
		}
	}

	@Override
	public Student FindByID(long id) {
		em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			Student std = em.find(Student.class, id);
			if (std == null){
				System.out.println("No student found by the id => "+id);
				return std;
			}
			else {
				System.out.println("! Opperation Successful !");
				return std;
			}
		}catch (Exception e)
		{
			em.getTransaction().rollback();
			System.out.println("Opperation Unsuccessful");
			System.out.println("Here are some errors that might help\n"+e);
		} finally {
			em.close();
		}
		return null;
	}
}
