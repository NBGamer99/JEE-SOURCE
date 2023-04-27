package me.yasser.atelier4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="student",schema = "ATELIER4")
public class Student {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private long id;
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
	@Column(name="BirthDate", nullable = true)
	private Date BirthDate;
	@Basic
	@Column(name="PhoneNumber", nullable = true,length = 255)
	private String PhoneNumber;
	@Basic
	@Column(name="Email", nullable = true,length = 255)
	private String Email;

}
