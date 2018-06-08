package com.techlabs.employee;


public class Employee implements Comparable<Employee>{

	private int eNo;
	private String eName;
	private String role;
	private int mId;
	private String doj;
	private double salary;
	private double commision;
	private int deptNo;
	
	public Employee()
	{
		
	}
	public Employee(int eNo, String eName, String role, int mId, String doj,
			double salary, double commision, int deptNo) {
		this.eNo = eNo;
		this.eName = eName;
		this.role = role;
		this.mId = mId;
		this.doj = doj;
		this.salary = salary;
		this.commision = commision;
		this.deptNo = deptNo;
	}
	

	public void seteNo(int eNo) {
		this.eNo = eNo;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setCommision(double commision) {
		this.commision = commision;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	

	public double calcAnuualSalary() {
		return (commision + salary) * 12;
	}

	public int geteNo() {
		return eNo;
	}

	public String geteName() {
		return eName;
	}

	public String getRole() {
		return role;
	}

	public int getmId() {
		return mId;
	}

	public String getDoj() {
		return doj;
	}

	public double getSalary() {
		return salary;
	}

	public double getCommision() {
		return commision;
	}

	public int getDeptNo() {
		return deptNo;
	}
	@Override
	public int compareTo(Employee arg0) {
		if(arg0.getmId()<this.getmId())
			return -1;
		else
			return 1;
	}

}
