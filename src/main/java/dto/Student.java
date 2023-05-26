package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data  
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // it will auto generate vaule numbers
	int id;
	String name;
	String email;
	long mobile;
	String password;
	String gender;
//public int getId() {
//	return id;
//}
//public void setId(int id) {
//	this.id = id;
//}
//public String getName() {
//	return name;
//}
//public void setName(String name) {
//	this.name = name;
//}
//public String getEmail() {
//	return email;
//}
//public void setEmail(String email) {
//	this.email = email;
//}
//public long getMobile() {
//	return mobile;
//}
//public void setMobile(long mobile) {
//	this.mobile = mobile;
//}
//public String getPassword() {
//	return password;
//}
//public void setPassword(String password) {
//	this.password = password;
//}
//public String getGender() {
//	return gender;
//}
//public void setGender(String gender) {
//	this.gender = gender;
//}
	
}