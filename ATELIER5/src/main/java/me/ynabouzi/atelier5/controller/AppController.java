package me.ynabouzi.atelier5.controller;

import me.ynabouzi.atelier5.models.Registration;
import me.ynabouzi.atelier5.models.Student;
import me.ynabouzi.atelier5.service.RegistrationService;
import me.ynabouzi.atelier5.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {
	private final RegistrationService registrationService;
	private final StudentService studentService;

	@Autowired
	public AppController(RegistrationService registrationService, StudentService studentService) {
		this.registrationService = registrationService;
		this.studentService = studentService;
	}
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute Registration registration, @ModelAttribute Student student)
	{
		studentService.addNewStudent(student);
		registration.setStudent(student);
		System.out.println("Registration from UI = "+ registration);
		System.out.println("Student from UI = "+ registration.getStudent());

		registrationService.addNewRegistration(registration);
		// Logique pour sauvegarder l'étudiant dans la base de données ou autre traitement
		ModelAndView modelAndview = new ModelAndView();
		modelAndview.setViewName("success");
		modelAndview.addObject("reg",registration);
		return modelAndview;
	}

}
