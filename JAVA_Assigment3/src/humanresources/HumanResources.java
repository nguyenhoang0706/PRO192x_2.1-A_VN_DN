package humanresources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import ass3.manager.model.Department;
import ass3.manager.model.Employee;
import ass3.manager.model.Manager;
import ass3.manager.model.Staff;
import ass3.manager.model.StaffSort;

public class HumanResources {
	public static ArrayList<Staff> companyStaffList = new ArrayList<>();
	public static ArrayList<Department> companyDepartment = new ArrayList<>();

	public static void main(String[] args) {

// khoi tao danh sach nhan vien

		companyStaffList.add(new Manager("B001", "Lê Văn Đức", 45, 4, "2/1/2014", "Marketing", "Business Leader", 13));
		companyStaffList.add(new Manager("B002", "Trần Hữu Bình", 43, 3, "2/1/2014", "Labor", "Project Leader", 24));
		companyStaffList.add(new Manager("B003", "Phan Tấn Trung", 40, 3, "2/1/2014", "Design", "Technical Leader", 4));
		companyStaffList.add(new Employee("L001", "Trương Khánh Ly", 23, 1, "12/12/2017", "Labor", 20, 1));
		companyStaffList.add(new Employee("M001", "Hoàng Hải Miên", 33, 1.5, "15/6/2015", "Marketing", 10, 2));
		companyStaffList.add(new Employee("M001", "Lê Hoài Thanh", 30, 1.5, "13/6/2015", "Marketing", 2, 1));
		companyStaffList.add(new Employee("D001", "Trần Lê Phương", 24, 2, "5/1/2016", "Design", 4, 4));

// khoi tao danh sach cac bo phan 
		companyDepartment.add(new Department("L00", "Labor", 7));
		companyDepartment.add(new Department("M00", "Marketing", 4));
		companyDepartment.add(new Department("D00", "Design", 1));
		companyDepartment.add(new Department("B00", "Salement", 10));
		companyMenu();

	}

// MAN HINH CHINH
	public static void companyMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========================= HUMAN RESOURCES =========================");
		System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
		System.out.println("2. Hiển thị các bộ phận trong công ty");
		System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
		System.out.println("4. Thêm nhân viên mới vào công ty: bao gồm 2 loại");
		System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
		System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
		System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
		int inputSelectMenu;
		do {
			inputSelectMenu = sc.nextInt();
			switch (inputSelectMenu) {
			case 1:
				showCompanyStaffList();
				backToMenu();
				break;

			case 2:
				showCompanyDepartments();
				backToMenu();
				break;

			case 3:
				showStaffListOfDepartments();
				backToMenu();
				break;

			case 4:
				addStaffToCompany();
				backToMenu();
				break;

			case 5:
				findStaff();
				backToMenu();
				break;

			case 6:
				salaryTab();
				backToMenu();
				break;

			case 7:
				salaryTabAscending();
				backToMenu();
				break;
			}
		} while (inputSelectMenu < 1 || inputSelectMenu > 7);

	}

// SHOW COMPANY'S STAFF LIST
	public static void showCompanyStaffList() {
		System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");

		for (int i = 0; i < companyStaffList.size(); i++) {
			companyStaffList.get(i).displayinformation();
		}
	}

// SHOW COMPANY'S DEPARTMENTS
	public static void showCompanyDepartments() {
		System.out.println("2. Hiển thị các bộ phận trong công ty");
		int count;
		for (int i = 0; i < companyDepartment.size(); i++) {
			count = 0;
			for (int j = 0; j < companyStaffList.size(); j++) {
				if (companyStaffList.get(j).getDepartment()
						.equalsIgnoreCase(companyDepartment.get(i).getNameDepartment())) {
					count++;
				}
				companyDepartment.get(i).setNumberOfStaff(count);
			}
			System.out.println(companyDepartment.get(i));

		}
	}

// SHOW STAFFLIST IN DEPARTMENT
	public static void showStaffListOfDepartments() {
		Scanner sc = new Scanner(System.in);
		System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
		for (int i = 0; i < companyDepartment.size(); i++) {
			System.out.println((i + 1) + "/ " + companyDepartment.get(i).getNameDepartment());
		}
		int inputSelect = sc.nextInt();
		for (int i = 0; i < companyStaffList.size(); i++) {
			if (companyDepartment.get(inputSelect - 1).getNameDepartment()
					.equalsIgnoreCase(companyStaffList.get(i).getDepartment())) {
				companyStaffList.get(i).displayinformation();
			}
		}
	}

//	ADD STAFF TO COMPANY
	public static void addStaffToCompany() {
		Scanner sc = new Scanner(System.in);
		System.out.println("4. Thêm nhân viên mới vào công ty: bao gồm 2 loại");
		System.out.println("     1. Thêm nhân viên thông thường");
		System.out.println("     2.Thêm nhân viên là cấp quản lý (có thêm chức vụ)");
		int inputSelectStaff = sc.nextInt();
		do {
			switch (inputSelectStaff) {
			case 1:
				normalStaff();
				break;

			case 2:
				managerStaff();
				break;
			}
		} while (inputSelectStaff < 1 || inputSelectStaff > 2);
	}

// THEM NHAN VIEN THONG THUONG
	public static void normalStaff() {
		Scanner sc = new Scanner(System.in);
		System.out.println("     1. Thêm nhân viên thông thường");
		Employee bonusEmployee;
		System.out.print("Nhập số lượng nhân viên thông thường cần thêm: ");
		int inputNormalStaff = sc.nextInt();
		for (int n = 0; n < inputNormalStaff; n++) {
			bonusEmployee = new Employee();
			System.out.println("Nhập thông tin nhân viên thứ " + (n + 1) + ": ");

			// nhap id bonus

			System.out.print("ID: ");
			String id = sc.next();
			bonusEmployee.setIdStaff(id);
			sc.nextLine();

			// nhap name bonus

			System.out.print("Name: ");
			String name = sc.nextLine();
			bonusEmployee.setNameStaff(name);

			// nhap age bonus

			System.out.print("Age: ");
			int age = sc.nextInt();
			bonusEmployee.setAgeStaff(age);

			// nhap coefficient Salary bonus

			System.out.print("Coefficient Salary: ");
			double coefficientSalary = sc.nextDouble();
			bonusEmployee.setCoefficientSalary(coefficientSalary);

			// nhap Day begin bonus

			System.out.print("Day Begin: ");
			String dayBegin = sc.next();
			bonusEmployee.setDayBegin(dayBegin);

			// nhap department bonus

			System.out.println("Department: ");
			for (int i = 0; i < companyDepartment.size(); i++) {
				System.out.println((i + 1) + "/ " + companyDepartment.get(i).getNameDepartment());
			}
			int selectDepartment;
			do {
				selectDepartment = sc.nextInt();
			} while (selectDepartment < 1 || selectDepartment > companyDepartment.size());

			bonusEmployee.setDepartment(companyDepartment.get(selectDepartment - 1).getNameDepartment());

			// update so nhan vien trong department
//			companyDepartment.get(selectDepartment - 1).setNumberOfStaff(companyDepartment.get(selectDepartment - 1).getNumberOfStaff()+1);

			// nhap day off bonus

			System.out.println("Day Off: ");
			int dayOff = sc.nextInt();
			bonusEmployee.setDayOff(dayOff);
			
			//OT
			System.out.println("OT: ");
			int OT = sc.nextInt();
			bonusEmployee.setOverTime(OT);
			

//			bonusEmployee.displayinformation();
			companyStaffList.add(bonusEmployee);

		}

	}

// THEM NHAN VIEN CAP QUAN LY
	public static void managerStaff() {
		Scanner sc = new Scanner(System.in);
		System.out.println("     2.Thêm nhân viên là cấp quản lý (có thêm chức vụ)");
		Manager bonusManager;
		System.out.print("Nhập số lượng nhân viên là cấp quản lý cần thêm: ");
		int inputManager = sc.nextInt();
		for (int m = 0; m < inputManager; m++) {
			bonusManager = new Manager();
			System.out.println("Nhập thông tin nhân viên thứ " + (m + 1) + ": ");

			// nhap id bonus

			System.out.print("ID: ");
			String id = sc.next();
			bonusManager.setIdStaff(id);
			sc.nextLine();

			// nhap name bonus

			System.out.print("Name: ");
			String name = sc.nextLine();
			bonusManager.setNameStaff(name);

			// nhap age bonus

			System.out.print("Age: ");
			int age = sc.nextInt();
			bonusManager.setAgeStaff(age);

			// nhap coefficient Salary bonus

			System.out.print("Coefficient Salary: ");
			double coefficientSalary = sc.nextDouble();
			bonusManager.setCoefficientSalary(coefficientSalary);

			// nhap Day begin bonus

			System.out.print("Day Begin: ");
			String dayBegin = sc.next();
			bonusManager.setDayBegin(dayBegin);

			// nhap department bonus

			System.out.println("Department: ");
			for (int i = 0; i < companyDepartment.size(); i++) {
				System.out.println((i + 1) + "/ " + companyDepartment.get(i).getNameDepartment());
			}
			int selectDepartment;
			do {
				selectDepartment = sc.nextInt();
			} while (selectDepartment < 1 || selectDepartment > companyDepartment.size());

			bonusManager.setDepartment(companyDepartment.get(selectDepartment - 1).getNameDepartment());

			// nhap title bonus
			System.out.println("title: ");
			System.out.println("1/ Business Leader");
			System.out.println("2/ Project Leader");
			System.out.println("3/ Technical Leader");
			int inputselectManager;
			do {
				inputselectManager = sc.nextInt();

			} while (inputselectManager < 1 || inputselectManager > 3);
			switch (inputselectManager) {
			case 1:
				bonusManager.setTitle("Business Leader");
				break;
			case 2:
				bonusManager.setTitle("Project Leader");
				break;
			case 3:
				bonusManager.setTitle("Technical Leader");
				break;
			}
			// nhap day off bonus

			System.out.println("Day Off: ");
			int dayOff = sc.nextInt();
			bonusManager.setDayOff(dayOff);
			companyStaffList.add(bonusManager);

			// update so nhan vien trong department
//			companyDepartment.get(selectDepartment - 1).setNumberOfStaff(companyDepartment.get(selectDepartment - 1).getNumberOfStaff()+1);

		}

	}

//	FIND STAFF BY ID OR NAME
	public static void findStaff() {
		System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
		Scanner sc = new Scanner(System.in);
		String inputSearchName = sc.nextLine();
		for (int i = 0; i < companyStaffList.size(); i++) {

			// tim kiem tuyet doi
//			if (inputSearchName.equalsIgnoreCase(companyStaffList.get(i).getNameStaff())
//					|| inputSearchName.equalsIgnoreCase(companyStaffList.get(i).getIdStaff())) {
//				companyStaffList.get(i).displayinformation();
//			}

			// tim kiem tuong doi
			if (companyStaffList.get(i).getNameStaff().toLowerCase().contains(inputSearchName.toLowerCase())
					|| companyStaffList.get(i).getIdStaff().toLowerCase().contains(inputSearchName.toLowerCase())) {
				companyStaffList.get(i).displayinformation();
			}

		}
	}

// SHOW COMPANY'S SALARYTAB
	public static void salaryTab() {
		System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
		for (int i = 0; i < companyStaffList.size(); i++) {
			Staff s = companyStaffList.get(i);
			if (s instanceof Employee) {
				s.setSalary(((Employee) s).calculateSalary());
			}
			if (s instanceof Manager) {
				s.setSalary(((Manager) s).calculateSalary());
			}
		}
		for (Staff s : companyStaffList) {
			s.displayinformation();
		}
	}

// SHOW COMPANY'S SALARYTAB FOR ASCENDING
	public static void salaryTabAscending() {
		System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự:");
		System.out.println("\t1/ Tăng dần");
		System.out.println("\t2/ Giảm dần");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < companyStaffList.size(); i++) {
			Staff s = companyStaffList.get(i);
			if (s instanceof Employee) {
				s.setSalary(((Employee) s).calculateSalary());
			}
			if (s instanceof Manager) {
				s.setSalary(((Manager) s).calculateSalary());
			}
		}
		int input;
		do {
			input = sc.nextInt();
		} while (input < 1 || input > 2);
		switch (input) {
		case 1:
			Collections.sort(companyStaffList, new StaffSort());
			break;
		case 2:
			Collections.sort(companyStaffList);
			break;
		}

		for (Staff s : companyStaffList) {
			s.displayinformation();
		}
	}

// BACK TO MENU
	public static void backToMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------");
		System.out.println("Nhấn phím 0 nếu muốn quay về lại màn hình chính! ");
		int inputBackToMenu = sc.nextInt();
		if (inputBackToMenu == 0) {
			companyMenu();
		}
	}

}
