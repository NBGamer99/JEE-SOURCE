package me.ynabouzi.atelier5.service;

import me.ynabouzi.atelier5.models.Student;
import me.ynabouzi.atelier5.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudent(){
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student){
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if (studentByEmail.isPresent()){
			throw new IllegalStateException("The email you enter is already taken!");
		}
		studentRepository.save(student);
	}
}
