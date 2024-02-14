package Controller;

import java.util.Comparator;

import Model.Employee;

public class NameComparatorClass implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o1.getEmpName().compareTo(o2.getEmpName());
	}
	

}
