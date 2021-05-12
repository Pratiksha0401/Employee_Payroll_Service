package com.ioStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	
	public enum IOService {
		  CONSOLE_ID, FILE_ID;		
	        }
	
	private List<EmployeePayrollData> data;
	
	public EmployeePayrollService() {}

	public EmployeePayrollService(List<EmployeePayrollData> data) {
		this.data = data;
	}

	public static void main(String[] args) throws Exception  {
		
		List<EmployeePayrollData> data = new ArrayList<EmployeePayrollData>();
		EmployeePayrollService service=new EmployeePayrollService(data);		
		
		service.readData(new Scanner(System.in));
		service.writeData(IOService.FILE_ID);
		
	}
	
	private void writeData(IOService service) throws IOException {
		
		if(service.equals(IOService.FILE_ID)) {
			writeDatainfile();
		}
		else if(service.equals(IOService.CONSOLE_ID)) {
			System.out.println("\nData Written:"+data);
		}	
	}
	
	private void writeDatainfile() throws IOException {
		
		StringBuffer buffer = new StringBuffer();
		data.forEach(emp -> {	
		String empData=emp.toString().concat("\n");
		buffer.append(empData);
		});
		
		Files.write(Paths.get("D:\\Pratiksha\\Java_programs\\Day-27\\employeeData.txt"), buffer.toString().getBytes());
			
	}
	
	private void readData(Scanner scanner) {
		System.out.println("Enter ID: ");
		int id = scanner.nextInt();
		
		System.out.println("Enter name: ");
		String name = scanner.next();
		
		System.out.println("Enter salary: ");
		double sal = scanner.nextDouble();
		
		data.add(new EmployeePayrollData(id, name, sal));
		
	}

}

class EmployeePayrollData{
	private int id;
	private double salary;
	private String name;
	
	
	public EmployeePayrollData() {
	}
	public EmployeePayrollData(int id, String name, double salary) {
		this.id = id;
		this.salary = salary;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmployeePayrollData [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}
}