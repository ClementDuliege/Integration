package usa;

public class Employees {
	private int id;
	private String firstname;
	private String lastname;
	private Payslip payslip;
	
	
	public Employees(int id, String firstname, String lastname, Payslip payslip) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.payslip = payslip;
	}

	public Employees() {
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Payslip getPayslip() {
		return payslip;
	}


	public void setPayslip(Payslip payslip) {
		this.payslip = payslip;
	}
	
	
	
	
}
