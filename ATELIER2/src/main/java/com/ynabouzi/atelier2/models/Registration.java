package com.ynabouzi.atelier2.models;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@NamedQuery(name = "AllRegistrations", query = "SELECT e FROM com.ynabouzi.atelier2.models.Registration e")
@NamedQuery(name = "AllRegistrationByStudentId", query = "SELECT e from com.ynabouzi.atelier2.models.Registration e where e.Student.Id_std=?1")
@Table(name = "registration", schema = "ATELIER2")
public class Registration {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "Id_reg", nullable = false)
	private long Id_reg;
	@Basic
	@Column(name = "RegDate", nullable = true)
	private Date RegDate;
	@Basic
	@Column(name = "Grouped", nullable = true, length = 30)
	private String Grouped;
	@Basic
	@Column(name = "Level", nullable = true, length = 30)
	private String Level;
	@Basic
	@Column(name = "Major", nullable = true, length = 30)
	private String Major;
//	@Basic
//	@Column(name = "Student_id")
//	private long Student_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	@JoinColumn(name = "Student_id", referencedColumnName = "Id_std")
	private Student Student;
}