package com.ynabouzi.atelier1.controllers;

import com.ynabouzi.atelier1.model.Registration;
import com.ynabouzi.atelier1.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;


@WebServlet(name = "SubmitServlet", value = "/register")
public class SubmitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SubmitServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instantiating The Etudiant class
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-M");
		Student std = new Student();
		std.setFirstName(request.getParameter("FirstName"));
		std.setLastName(request.getParameter("LastName"));
		std.setEmail(request.getParameter("Email"));
		std.setCIN(request.getParameter("CIN"));
		std.setBirthDate(request.getParameter("BirthDate"));
		std.setPhoneNumber(request.getParameter("PhoneNumber"));

		// Instantiating The Registration Class

		Registration reg = new Registration();
		reg.setStudent(std);
		reg.setRegDate(request.getParameter("RegDate"));
		reg.setGroup(request.getParameter("Group"));
		reg.setLevel(request.getParameter("Level"));
		reg.setMajor(request.getParameter("Major"));

		// Send values to a Success page
		request.setAttribute("Student", reg.getStudent());
		request.setAttribute("Registration", reg);

		// Forward to the second page
		request.getRequestDispatcher("success.jsp").forward(request, response);
		doGet(request, response);
	}
}
