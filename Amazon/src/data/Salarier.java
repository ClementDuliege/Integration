package data;

import java.util.Comparator;

public class Salarier {
	private int id;
	private int salary;

	public Salarier(int id, int salary) {
		this.setId(id);
		this.setSalary(salary);
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
