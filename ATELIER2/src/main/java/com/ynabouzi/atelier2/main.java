package com.ynabouzi.atelier2;

import com.ynabouzi.atelier2.controllers.RegistrationDAO;
import com.ynabouzi.atelier2.controllers.StudentDAO;
import com.ynabouzi.atelier2.helper.MainHelper;
import com.ynabouzi.atelier2.models.Registration;
import com.ynabouzi.atelier2.models.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class main {
	private static void pressEnterToContinue()
	{
		System.out.println("Press Enter key to continue...");
		try
		{
			System.in.read();
		}
		catch(Exception e)
		{}
	}
	public static void main(String[] args) {
		System.out.println("! Creating Databases !\n==================================================");
		StudentDAO Stddao = new StudentDAO();
		RegistrationDAO Regdao = new RegistrationDAO();
		MainHelper Helper = new MainHelper();

		pressEnterToContinue();
		// Question 6 : Let's Create 3 Students
		Stddao.CreateAll(Helper.CreateStudents());
		pressEnterToContinue();

		// Question 7 : List All Students
		Stddao.ShowAll();

		pressEnterToContinue();
		// Question 8 : Listing student id 44 Registrations
		Registration AnotherOne = new Registration();
		List<Registration> regs = new ArrayList<>();
		regs.addAll(Helper.CreateReg(Stddao.FindByID(44)));
		AnotherOne.setGrouped("Group7");
		AnotherOne.setMajor("GPEE");
		AnotherOne.setLevel("3eme");
		AnotherOne.setRegDate(new Date(100,5,10));
		AnotherOne.setStudent(Stddao.FindByID(88));
		regs.add(AnotherOne);
		Regdao.CreateAll(regs);
		Regdao.ShowRegByStudentId(44);

		pressEnterToContinue();
		// Question 9 : Deleting student by id
		Stddao.DeleteByID(60);

		pressEnterToContinue();
		// Question 10 : Update a student informations
		Student change = new Student();
		change.setFirstName("Hamza");
		change.setCIN("AS6865");
		Stddao.UpdateByID(44,change);

		pressEnterToContinue();
		//Question 11 : Listing  Students by level
		Stddao.ShowStudentsByLvl("3eme");

		pressEnterToContinue();
	}
}
