package beans;

import java.time.LocalDate;

public class Employee {
	int id;
	String name;
	String phone;
	LocalDate DoB;
	String address;
	int DepId;
	
	public Employee() {
	}

	public Employee(int id, String name, String phone, LocalDate doB, String address, int depId) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		DoB = doB;
		this.address = address;
		DepId = depId;
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
		return DoB;
	}

	public void setDoB(LocalDate doB) {
		DoB = doB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDepId() {
		return DepId;
	}

	public void setDepId(int depId) {
		DepId = depId;
	}
	
	
	
}
