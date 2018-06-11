package com.theAvengers;

import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable{
	String name,address,type,password,empID,code;
	Employee(){};
	Employee(String empID,String name,String code,String type,String password,String address){
		this.empID = empID;
		this.name = name;
		this.address = address;
		this.type = type;
		this.password=password;
		this.code = code;
	}
	void showData(){
		System.out.println("EMPLOYEE RECORD :\n");
		System.out.println("EMPLOYEE_ID :  "+empID);
		System.out.println("EMPLOYEE_NAME :  "+name.toUpperCase());
		System.out.println("EMPLOYEE_CODE :  "+code.toUpperCase());
		System.out.println("EMPLOYEE_TYPE :  "+type);
		System.out.println("EMPLOYEE_ADDRESS :  "+ address.toUpperCase());
	}
	void employeeMenu(Employee emp){
		SleepThread st = new SleepThread();
		System.out.println("\n\t\t\t***********************************************************");
		System.out.println("\t\t\t                   THE AVENGERS Pvt Ltd");
		System.out.println("\t\t\t***********************************************************");
		System.out.println("\n\t\t\t               EMPLOYEE INFORMATION WINDOW\n");
		System.out.println("\t\t\tHELLO, " + emp.name.toUpperCase() + " !\n\t\t\t-------------------------------\n\n\t\t\tPLEASE ENTER:\n");
		System.out.println("\t\t\t\t1 - TO VIEW PROFILE\n\n");
		System.out.println("\t\t\t\t2 - LOGOUT AND EXIT\n\n");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		switch(i){
			case 1:{ emp.showData();
					System.out.println("EMPLOYEE _PASSWORD : "+emp.password);
					emp.employeeMenu(emp);
					break;}
			case 2:{	System.out.println("\t\t\tCLOSING PORTAL.........");
						st.run();
						System.out.println("\n\n\t\t\t******THANK YOU******\n");
						System.exit(0);}
			default :{	MainPortal ap = new MainPortal();
						System.out.println("\nPLEASE ENTER CORRECT KEY.\nREDIRECTING  >>>>>>>>>>");
						st.run();
						ap.main("");}
		}
	}
	
}