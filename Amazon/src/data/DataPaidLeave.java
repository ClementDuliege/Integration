package data;

public class DataPaidLeave {
	private int id;
	private int paid_leave;

	public DataPaidLeave(int id, int paid_leave) {
		this.setId(id);
		this.setPaidLeave(paid_leave);
	}
	
	public int getPaidLeave() {
		return paid_leave;
	}

	public void setPaidLeave(int paid_leave) {
		this.paid_leave = paid_leave;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
