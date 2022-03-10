package ass3.manager.model;

import iservice.ICalculator;

public class Manager extends Staff implements ICalculator {

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Manager() {
	}

	public Manager(String id, String name, int age, double coefficientSalary, String dayBegin, String department,
			String title, int dayOff) {
		this.setIdStaff(id);
		this.setNameStaff(name);
		this.setAgeStaff(age);
		this.setCoefficientSalary(coefficientSalary);
		this.setDayBegin(dayBegin);
		this.setDepartment(department);
		this.setTitle(title);
		this.setDayOff(dayOff);
	}

	@Override
	public void displayinformation() {
		System.out.println("ID: " + this.getIdStaff() + ", Name: " + this.getNameStaff() + ", Age: "
				+ this.getAgeStaff() + ", Coefficient Salary: " + this.getCoefficientSalary() + ", Day Begin: "
				+ this.getDayBegin() + ", Department: " + this.getDepartment() + ", Title: " + this.title
				+ ", Day Off: " + this.getDayOff() + ", Salary: " + String.format("%,.0f", this.getSalary()));

	}

	@Override
	public double calculateSalary() {
		int responsiveSalary = 0;
		if (title.equalsIgnoreCase("Business Leader")) {
			responsiveSalary = 8000000;
		}
		if (title.equalsIgnoreCase("Project Leader")) {
			responsiveSalary = 5000000;
		}
		if (title.equalsIgnoreCase("Technical Leader")) {
			responsiveSalary = 6000000;
		}
		return this.getCoefficientSalary() * 5000000 + responsiveSalary;
	}

	@Override
	public int compareTo(Staff o) {
		return Double.valueOf(o.getSalary()).compareTo(Double.valueOf(this.getSalary()));
	}

}
