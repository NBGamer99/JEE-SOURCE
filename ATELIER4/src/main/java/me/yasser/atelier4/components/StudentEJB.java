package me.yasser.atelier4.components;

import me.yasser.atelier4.entity.Student;
import javax.ejb.Remote;

@Remote
public interface StudentEJB {
	// for inserting a student in the database
	String registerStudent(Student std);
	// for getting a student from the database
	Student getStudent(int id);
}
