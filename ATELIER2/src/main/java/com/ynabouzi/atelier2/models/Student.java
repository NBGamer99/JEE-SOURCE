package com.ynabouzi.atelier2.models;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@NamedQuery(name = "AllStudents", query = "SELECT e FROM com.ynabouzi.atelier2.models.Student e")
@NamedQuery(name = "AllStudentsByLvl", query = "SELECT e FROM Student e WHERE e.Id_std in (select r.Student.Id_std from Registration r where r.Level = ?1)")
@Entity
@Table(name = "student", schema = "ATELIER2")
public class Student {
// 	this is commented so i can have custom ID
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "Id_std", nullable = false)
	private long Id_std;
	@Basic
	@Column(name = "LastName", nullable = true, length = 20)
	private String LastName;
	@Basic
	@Column(name = "FirstName", nullable = true, length = 20)
	private String FirstName;
	@Basic
	@Column(name = "CIN", nullable = true, length = 20)
	private String CIN;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Student",orphanRemoval = true)
	@ToString.Exclude
	private List<Registration> re = new ArrayList<>();

}
