package me.ynabouzi.atelier5.models;

import lombok.*;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "student", schema = "ATELIER5")
public class Student {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Basic
	@Column(name = "Email", nullable = true, length = 255)
	private String Email;
	@Basic
	@Column(name = "BirthDate", nullable = true, length = 255)
	private String BirthDate;
	@Basic
	@Column(name = "PhoneNumber", nullable = true, length = 255)
	private String PhoneNumber;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Student",orphanRemoval = true)
	@ToString.Exclude
	private List<Registration> re = new ArrayList<>();

}
