package com.ynabouzi.atelier2.helper;

import com.ynabouzi.atelier2.models.Registration;
import com.ynabouzi.atelier2.models.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainHelper {
	public List<Student> CreateStudents(){
		List<Student> StudentsList = new ArrayList<>();
		String[] LastNames = {"Nabouzi","Mesrar","Imariren"};
		String[] FirstNames = {"Yasser","Hamza","Amine"};
		String[] CINS = {"AD6854","LK8465","QK8754"};
		long[] IDS = {44, 60, 88};

		for (int i = 0; i < LastNames.length; i++) {
			Student student = new Student(IDS[i],LastNames[i],FirstNames[i],CINS[i],null);
			StudentsList.add(student);
		}
		return StudentsList;
	}

	public List<Registration> CreateReg(Student std)
	{
		List<Registration> Regs = new ArrayList<>();
		Date[] Dates = {new Date(118,11,20), new Date(110,12,10),new Date(120,11,15)};
		String[] Groups = {"GROUP3","GROUP2","GROUP4"};
		String[] Levels = {"3eme","1er","4eme"};
		String[] Majors = {"GI","IID","RIRC"};

		for (int i = 0; i < Groups.length; i++) {
			Registration reg = new Registration();
			reg.setRegDate(Dates[i]);
			reg.setGrouped(Groups[i]);
			reg.setMajor(Majors[i]);
			reg.setLevel(Levels[i]);
			reg.setStudent(std);
			Regs.add(reg);
		}
		return Regs;
	}
}
