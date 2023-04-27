package me.ynabouzi.atelier5.repository;

import me.ynabouzi.atelier5.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("SELECT s from Student s WHERE s.Email = ?1")
	Optional<Student> findStudentByEmail(String email);
}
