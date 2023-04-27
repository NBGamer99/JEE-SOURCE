package com.ynabouzi.atelier1.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString

public class Student {

	public String FirstName;
	public String LastName;
	public String BirthDate;
	public String CIN;
	public String PhoneNumber;
	public String Email;

}
