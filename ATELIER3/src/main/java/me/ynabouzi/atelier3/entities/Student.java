package me.ynabouzi.atelier3.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student", schema = "ATELIER3")
public class Student {
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		@Column(name = "Id", nullable = false)
		private int Id;
		@Basic
		@Column(name = "FirstName", nullable = true, length = 20)
		private String FirstName;
		@Basic
		@Column(name = "LastName", nullable = true, length = 20)
		private String LastName;
		@Basic
		@Column(name = "BirthDate", nullable = true)
		private String BirthDate;
		@Basic
		@Column(name = "CIN", nullable = true, length = 10)
		private String CIN;
		@Basic
		@Column(name = "PhoneNumber", nullable = true, length = 12)
		private String PhoneNumber;
		@Basic
		@Column(name = "Email", nullable = true, length = 30)
		private String Email;
}