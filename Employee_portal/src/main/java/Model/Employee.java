package Model;

public class Employee implements Comparable<Employee>{
	private int empId;
	private String empName;
	private String empDesignation;
	private String empType;
	private double empSalary;
	private String empDept;
	private String empImage;
	
	@Override
	public int compareTo(Employee e1) {
		
		if(empSalary==e1.getEmpSalary()) {
			return 0;
		}else if(empSalary>e1.getEmpSalary()) {
			return 1;
		}else
			return -1;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getEmpImage() {
		return empImage;
	}
	public void setEmpImage(String empImage) {
		this.empImage = empImage;
	}
	
	

}
