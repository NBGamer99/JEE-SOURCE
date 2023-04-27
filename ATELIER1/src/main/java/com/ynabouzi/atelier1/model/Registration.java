package com.ynabouzi.atelier1.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Registration {
	private Student student;
	private String RegDate;
	private String Major;
	private String Group;
	private String Level;
}
