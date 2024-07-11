package com.java.hiberante.learning.model;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	private String job;
	private BigDecimal mgr;
	private Date hiredate;
	private BigDecimal salary;
	private BigDecimal commission;
	private int deptId;

	public Employee() {
		
	}

	public Employee(int employeeId, String employeeName, String job, BigDecimal mgr, Date hiredate, BigDecimal salary,
			BigDecimal commission, int deptId) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.salary = salary;
		this.commission = commission;
		this.deptId = deptId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public BigDecimal getMgr() {
		return mgr;
	}

	public void setMgr(BigDecimal mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", job=" + job + ", mgr=" + mgr
				+ ", hiredate=" + hiredate + ", salary=" + salary + ", commission=" + commission + ", deptId=" + deptId
				+ "]";
	}
	
	
}
