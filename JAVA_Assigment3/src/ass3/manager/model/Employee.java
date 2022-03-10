package ass3.manager.model;

import iservice.ICalculator;

public class Employee extends Staff implements ICalculator {

	private int overTime;

	public int getOverTime() {
		return overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	public Employee() {

	}

	public Employee(String id, String name, int age, double coefficientSalary, String dayBegin, String department,
			int dayOff, int OT) {
		this.setIdStaff(id);
		this.setNameStaff(name);
		this.setAgeStaff(age);
		this.setCoefficientSalary(coefficientSalary);
		this.setDayBegin(dayBegin);
		this.setDepartment(department);
		this.setDayOff(dayOff);
		this.setOverTime(OT);
	}

	@Override
	public void displayinformation() {
		System.out.println("ID: " + this.getIdStaff() + ", Name: " + this.getNameStaff() + ", Age: "
				+ this.getAgeStaff() + ", Coefficient Salary: " + this.getCoefficientSalary() + ", Day Begin: "
				+ this.getDayBegin() + ", Department: " + this.getDepartment() + ", Day Off: " + this.getDayOff()
				+ ", OT: " + this.overTime + ", Salary: " + String.format("%,.0f", this.getSalary()));

	}

	@Override
	public double calculateSalary() {
		return this.getCoefficientSalary() * 3000000 + this.overTime * 200000;

	}

	@Override
//	sx giam
	public int compareTo(Staff o) {
		return Double.valueOf(o.getSalary()).compareTo(Double.valueOf(this.getSalary()));
	}

}
