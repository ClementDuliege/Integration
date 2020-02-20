package usa;

public class Payslip {
	private int id;
	private int salary;
	private int bonus;
	private int paidLeave;
	
	
	public Payslip(int id, int salary, int bonus, int paidLeave) {
		this.id = id;
		this.salary = salary;
		this.bonus = bonus;
		this.paidLeave = paidLeave;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}


	public int getPaidLeave() {
		return paidLeave;
	}


	public void setPaidLeave(int paidLeave) {
		this.paidLeave = paidLeave;
	}
	
	
	
	
}
