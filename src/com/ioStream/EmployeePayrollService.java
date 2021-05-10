package com.ioStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	private List<EmployeePayrollData> datas;
	
	
	public EmployeePayrollService() {
	
	}

	
	public EmployeePayrollService(List<EmployeePayrollData> datas) {
		this.datas = datas;
	}


	public static void main(String[] args) {
		
		List<EmployeePayrollData> datas = new ArrayList<EmployeePayrollData>();
		EmployeePayrollService service=new EmployeePayrollService(datas);
		service.readData(new Scanner(System.in));
		service.writeData();
	}


	private void writeData() {
		System.out.println("\nWrinting Employee payroll roater to console : \n"+datas);
	}


	private void readData(Scanner scanner) {
		System.out.println("Enter ID");
		int id=scanner.nextInt();
		

		System.out.println("Enter Name");
		String name=scanner.next();
		
		System.out.println("Enter Salary");
		double sal=scanner.nextDouble();
		
		this.datas.add(new EmployeePayrollData(id,sal, name));
	}
}

class EmployeePayrollData{
	private int id;
	private double salary;
	private String name;
	public EmployeePayrollData(int id, double salary, String name) {
		this.id = id;
		this.salary = salary;
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmployeePayrollData [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}
	
}