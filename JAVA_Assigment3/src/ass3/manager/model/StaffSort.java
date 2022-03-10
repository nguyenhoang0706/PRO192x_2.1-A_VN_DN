package ass3.manager.model;

import java.util.Comparator;

public class StaffSort implements Comparator<Staff> {
	//sx tang
	@Override
	public int compare(Staff o1, Staff o2) {
		return Double.valueOf(o1.getSalary()).compareTo(Double.valueOf(o2.getSalary()));
	}

}
