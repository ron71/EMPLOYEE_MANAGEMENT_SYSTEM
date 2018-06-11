package com.theAvengers;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileFilter;
import java.io.File;
import java.io.IOException;


class AdminWindow{
	void adminMenu(Employee emp){
		System.out.println("\n\n\n\t\t\t***********************************************************");
		System.out.println("\t\t\t                   THE AVENGERS Pvt Ltd");
		System.out.println("\t\t\t***********************************************************");
		System.out.println("\n\t\t\t                  ADMINISTRATOR WINDOW\n");
		System.out.println("\t\t\tHELLO, " + emp.name.toUpperCase() + " !\n\t\t\t-------------------------------\n\n\t\t\tPLEASE ENTER:\n");
		System.out.println("\t\t\t\t1 - TO VIEW PROFILE\n\n");
		System.out.println("\t\t\t\t2 - TO VIEW ALL RECORDS\n\n");
		System.out.println("\t\t\t\t3 - LOGOUT AND EXIT\n\n");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		SleepThread st = new SleepThread();
		switch(i){
			case 1:{ emp.showData();
					 System.out.println("EMPLOYEE _PASSWORD : "+emp.password);
					adminMenu(emp);					
					break;}
			case 2:{	Record ar = new Record();
						ar.showAllRecord();
						adminMenu(emp);
						
						break;
					}
			case 3:{ System.out.println("\t\t\tCLOSING PORTAL.........");
						st.run();
						System.out.println("\n\n\t\t\t******THANK YOU******\n");
						System.exit(0);
					}
			default :{	MainPortal ap = new MainPortal();
						System.out.println("\nPLEASE ENTER CORRECT KEY.\nREDIRECTING  >>>>>>>>>>");
						st.run();
						ap.main("");}
		}
		
	}
}