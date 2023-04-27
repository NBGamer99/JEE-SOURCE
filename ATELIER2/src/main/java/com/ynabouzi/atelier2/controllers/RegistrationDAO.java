package com.ynabouzi.atelier2.controllers;


import com.ynabouzi.atelier2.manager.EntityManagerHelper;
import com.ynabouzi.atelier2.models.Registration;
import com.ynabouzi.atelier2.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class RegistrationDAO implements mainDAO<Registration>{

	@PersistenceContext(unitName = "default")
	private static EntityManager em;

	@Override
	public void CreateAll(List<Registration> Objs) {
			em = EntityManagerHelper.getEntityManager();
			System.out.println("! Inserting Data !\n==================================================");
		try {
			em.getTransaction().begin();

			for (Registration re : Objs)
			{
				em.persist(re);
			}
			em.getTransaction().commit();
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
	public void ShowAll() {
			em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();

			TypedQuery<Registration> Regs = em.createNamedQuery("AllRegistrations", Registration.class);
			for(Registration reg : Regs.getResultList())
			{
				System.out.println(reg.toString());
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
	public void ShowByID(long id) {
			em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			Registration reg = em.find(Registration.class, id);
			if (reg == null){
				System.out.println("No registration found by the id => "+id);
			}
			else {
				System.out.println(reg);
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
			Registration reg = em.find(Registration.class, id);
			if (reg == null){
				System.out.println("No registration found by the id => "+id);
			}
			else {
				em.remove(reg);
				System.out.println("The Registration by the id "+id+" has been removed successfully !");
				em.getTransaction().commit();
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
	public void UpdateByID(long id, Registration toChangeTo) {
			em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			Registration reg = em.find(Registration.class, id);
			if (reg == null){
				System.out.println("No student found by the id => "+id);
			}
			else {
				String tmp = reg.toString();
				Date RegDate = toChangeTo.getRegDate() != null ? toChangeTo.getRegDate() : reg.getRegDate();
				String Group = toChangeTo.getGrouped() != null ? toChangeTo.getGrouped() : reg.getGrouped();
				String Major = toChangeTo.getMajor() != null ? toChangeTo.getMajor() : reg.getMajor();
				String Level = toChangeTo.getLevel() != null ? toChangeTo.getLevel() : reg.getLevel();

				reg.setRegDate(RegDate);
				reg.setGrouped(Group);
				reg.setMajor(Major);
				reg.setLevel(Level);
				System.out.println("Before "+tmp);
				em.getTransaction().commit();
				System.out.println("The Registration by the id "+id+" has been updated successfully !");
				System.out.println("after "+reg.toString());
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

	public void ShowRegByStudentId(long id) {
			em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Registration> Regs = em.createNamedQuery("AllRegistrationByStudentId", Registration.class);
			Regs.setParameter(1, id);

			if (Regs.getResultList().isEmpty())
			{
				System.out.println("No Registrations for the "+id+" yet !");
			}
			else{
				System.out.println("All Registrations for the Student"+id+" are :\n==================================================");
				for (Registration reg : Regs.getResultList()) {
					System.out.println(reg);
				}
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
	public Registration FindByID(long id) {
		em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			Registration reg = em.find(Registration.class, id);
			if (reg == null){
				System.out.println("No student found by the id => "+id);
				return reg;
			}
			else {
				System.out.println("! Opperation Successful !");
				return reg;
			}
		}catch (Exception e)
		{
			em.getTransaction().rollback();
			System.out.println("Opperation Unsuccessful");
			System.out.println("Here are some errors that might help\n"+e);
		} finally {
			em.close();
		}
		return null;	}
}
