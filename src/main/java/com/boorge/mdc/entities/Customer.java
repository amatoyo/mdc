package com.boorge.mdc.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
	@SequenceGenerator(name = "customer_generator", sequenceName = "customer_seq", allocationSize = 1)
	private long customerId;
	
	@NotBlank(message="*Must enter a first name")
	@Size(min=2, max=50, message="*Must be between 2 and 50 characters long")
	private String firstName;
	
	private String lastName;
	
	@NotBlank(message="*Must enter a valid email")
	@Email
	private String email;
	
	private String phone1;
	
	private String phone2;
	
	private String register;
	
	private Date birthday;
	
	private String address1;
	
	private String address2;
	
	private String city;
	
	private String province;
	
	private String country;
	
	@NotBlank(message="*Must enter a gender")
	private String gender;

	public Customer(
			@NotBlank(message = "*Must enter a first name") @Size(min = 2, max = 50, message = "*Must be between 2 and 50 characters long") String firstName,
			String lastName, @NotBlank(message = "*Must enter a valid email") @Email String email, String phone1,
			String phone2, String register, Date birthday, String address1, String address2, String city,
			String province, String country, @NotBlank(message = "*Must enter a gender") String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.register = register;
		this.birthday = birthday;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.province = province;
		this.country = country;
		this.gender = gender;
	}
	
	public Customer() {}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone1=" + phone1 + ", phone2=" + phone2 + ", register=" + register + ", birthday="
				+ birthday + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", province="
				+ province + ", country=" + country + ", gender=" + gender + "]";
	}
	
	
}
