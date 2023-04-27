package me.ynabouzi.atelier3.controllers;


import me.ynabouzi.atelier3.entities.Student;
import me.ynabouzi.atelier3.manager.EntityManagerHelper;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class SubmitRegistrationEJB implements StudentRegistrationBean {
    @PersistenceContext(unitName = "default")
    private static final EntityManager em = EntityManagerHelper.getEntityManager();

    @Override
    public void registerStudent(Student std) {
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
    }

    @Override
    public Student getStudent(int id) {
        return em.find(Student.class, id);
    }
}
