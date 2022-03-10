package ass3.manager.model;

public abstract class Staff implements Comparable<Staff> {
	private String idStaff;
	private String nameStaff;
	private int ageStaff;
	private double coefficientSalary;
	private String dayBegin;
	private String department;
	private int dayOff;
	private double salary;
	
	public String getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}

	public String getNameStaff() {
		return nameStaff;
	}

	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}

	public int getAgeStaff() {
		return ageStaff;
	}

	public void setAgeStaff(int ageStaff) {
		this.ageStaff = ageStaff;
	}

	public double getCoefficientSalary() {
		return coefficientSalary;
	}

	public void setCoefficientSalary(double coefficientSalary) {
		this.coefficientSalary = coefficientSalary;
	}

	public String getDayBegin() {
		return dayBegin;
	}

	public void setDayBegin(String dayBegin) {
		this.dayBegin = dayBegin;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getDayOff() {
		return dayOff;
	}

	public void setDayOff(int dayOff) {
		this.dayOff = dayOff;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public abstract void displayinformation(); 
}
