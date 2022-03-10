package ass3.manager.model;

public class Department {
	private String idDepartment;
	private String nameDepartment;
	private int numberOfStaff;
	public String getIdDepartment() {
		return idDepartment;
	}
	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}
	public String getNameDepartment() {
		return nameDepartment;
	}
	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}
	public int getNumberOfStaff() {
		return numberOfStaff;
	}
	public void setNumberOfStaff(int numberOfStaff) {
		this.numberOfStaff = numberOfStaff;
	}
	public Department(String id, String name, int numberOfStaff) {
		this.setIdDepartment(id);
		this.setNameDepartment(name);
		this.setNumberOfStaff(numberOfStaff);
	}
	
	@Override
	public String toString() {
		return "[ID: " + idDepartment + ", Department Name: " + nameDepartment + ", Number Of Staff: "
				+ numberOfStaff + "]";
	}
	
	
}
