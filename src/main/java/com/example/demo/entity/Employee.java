package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String houseNumber;
	private String streetName;
	private String area;
	private String city;
	private int pinCode;
	private String emailAddress;
	private long phoneNumber;
	private LocalDate dateOfBirth;
	private LocalDate weddingDate;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String firstName, String lastName, String houseNumber, String streetName,
			String area, String city, int pinCode, String emailAddress, long phoneNumber, LocalDate dateOfBirth,
			LocalDate weddingDate) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.area = area;
		this.city = city;
		this.pinCode = pinCode;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.weddingDate = weddingDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(LocalDate weddingDate) {
		this.weddingDate = weddingDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, city, dateOfBirth, emailAddress, employeeId, firstName, houseNumber, lastName,
				phoneNumber, pinCode, streetName, weddingDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(area, other.area) && Objects.equals(city, other.city)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(emailAddress, other.emailAddress)
				&& employeeId == other.employeeId && Objects.equals(firstName, other.firstName)
				&& Objects.equals(houseNumber, other.houseNumber) && Objects.equals(lastName, other.lastName)
				&& phoneNumber == other.phoneNumber && pinCode == other.pinCode
				&& Objects.equals(streetName, other.streetName) && Objects.equals(weddingDate, other.weddingDate);
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", houseNumber=" + houseNumber + ", streetName=" + streetName + ", area=" + area + ", city=" + city
				+ ", pinCode=" + pinCode + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber
				+ ", dateOfBirth=" + dateOfBirth + ", weddingDate=" + weddingDate + "]";
	}

}
