package me.ynabouzi.atelier5.models;

import lombok.*;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "registration", schema = "ATELIER5")
public class Registration {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "Id_reg", nullable = false)
	private long Id_reg;
	@Basic
	@Column(name = "RegDate", nullable = true)
	private String RegDate;
	@Basic
	@Column(name = "Grouped", nullable = true, length = 30)
	private String Grouped;
	@Basic
	@Column(name = "Level", nullable = true, length = 30)
	private String Level;
	@Basic
	@Column(name = "Major", nullable = true, length = 30)
	private String Major;

	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	@JoinColumn(name = "Student_id", referencedColumnName = "Id_std")
	private Student Student;
}