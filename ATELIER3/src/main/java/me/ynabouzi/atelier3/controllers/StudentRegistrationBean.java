package me.ynabouzi.atelier3.controllers;

import me.ynabouzi.atelier3.entities.Student;
import javax.ejb.Remote;

@Remote
public interface StudentRegistrationBean {
    // for inserting a student in the database
    void registerStudent(Student std);
    // for getting a student from the database
    Student getStudent(int id);
}
