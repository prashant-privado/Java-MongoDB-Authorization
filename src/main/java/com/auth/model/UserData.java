package com.auth.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
import org.springframework.data.annotation.Id;
//import javax.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Entity(name = "user")
@Document(collection="user")
public class UserData {

	@Id
	@Field
	private String userid;
	@Field
	private String upassword;
	@Field
	private String firstName;

	@Field
	private String lastName;
	private String authToken;
	@Field
	private String urole;

}
