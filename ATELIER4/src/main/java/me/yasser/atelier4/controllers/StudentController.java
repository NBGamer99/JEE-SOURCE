package me.yasser.atelier4.controllers;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.yasser.atelier4.components.StudentBeanEJB;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.yasser.atelier4.entity.Student;

@SessionScoped
@Named(value = "studentBean")
@Data
@NoArgsConstructor
public class StudentController implements Serializable {
	@EJB
	private StudentBeanEJB stdejb;

	private String LastName;
	private String FirstName;
	private String CIN;
	private Date BirthDate;
	private String PhoneNumber;
	private String Email;

	public String DateFormater() throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		Date todayWithZeroTime = formatter.parse(formatter.format(this.BirthDate));
//		System.out.println(formatter.format(this.BirthDate));
//		System.out.println(formatter.parse(formatter.format(this.BirthDate)));
		return formatter.format(this.BirthDate);
	}

	public String saveStudent(){
		Student stds = new Student();
		stds.setFirstName(this.FirstName);
		stds.setLastName(this.LastName);;
		stds.setCIN(this.CIN);
		stds.setBirthDate(this.BirthDate);
		stds.setPhoneNumber(this.PhoneNumber);
		stds.setEmail(this.Email);
		return stdejb.registerStudent(stds);
	}
}
