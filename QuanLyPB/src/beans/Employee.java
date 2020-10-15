package beans;

import java.time.LocalDate;

import dao.ConnectDB;

public class Employee {
	int id;
	String name;
	String phone;
	LocalDate doB;
	String address;
	int depId;
	
	public Employee() {
	}

	public Employee(int id, String name, String phone, LocalDate doB, String address, int depId) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.doB = doB;
		this.address = address;
		this.depId = depId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDoB() {
		return doB;
	}

	public void setDoB(LocalDate doB) {
		this.doB = doB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}
	
	@Override
	public String toString() {
		return name+" "+ doB;
	}
	
}
