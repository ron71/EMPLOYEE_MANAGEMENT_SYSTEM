package com.theAvengers;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileFilter;
import java.io.File;
import java.io.IOException;

class MainPortal{
	
	void login(){
		Scanner sc = new Scanner(System.in);
		System.out.println("**********************\n");
		System.out.println("LOGIN:\n");
		System.out.println("ENTER EMPLOYEE ID : ");
		int userId = sc.nextInt();
		File file = new File(userId+".txt");
		if(file.exists()){
			checkPassword(file);
		}
		else{
			System.out.println("USER_ID DOESN'T EXITS.\n\n");
			
			main("");
		}
	
	}
	void checkPassword(File f){
		Scanner sc = new Scanner(System.in);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try{
			char password1[] = System.console().readPassword("PASSWORD : ");
			String pass = new String(password1);
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			Employee emp = (Employee)ois.readObject();
			if(pass.equalsIgnoreCase(emp.password)){
				System.out.println("ENTER TYPE : ");
				String type = sc.next();
				if((type.equalsIgnoreCase(emp.type))&&type.equalsIgnoreCase("admin")){
					AdminWindow adw = new AdminWindow();
					adw.adminMenu(emp);
				}
				else if((type.equalsIgnoreCase(emp.type))&&type.equalsIgnoreCase("employee")){
						Employee empl = new Employee();
						empl.employeeMenu(emp);}
					
				else
				{	System.out.println("\n\nINVALID EMPLOYEE TYPE.");
					System.out.println("\n\nREDIRECTING TO MAIN PORTAL >>>>>>>>>>>>>\n\n");
					SleepThread st = new SleepThread();
					st.run();
					main("");}
			}
			else{
				System.out.println("\nINVALID INPUT");
				System.out.println("\nREDIRECTING TO MAIN MENU. >>>>>>>>>>\n\n");
				SleepThread st = new SleepThread();
				st.run();
				main("");
			}
		}
		catch(Exception e){
		System.out.println("FILE NOT FOUND");
		}
		finally{
			try{
				fis.close();
				ois.close();}
				catch(IOException ex)
				{System.out.println(ex);}
		}
	}
	public static void main(String ... args){
		MainPortal mp = new MainPortal();
		SleepThread st = new SleepThread();
		System.out.println("\n\n\t\t\t***********************************************************");
		System.out.println("\t\t\t                   THE AVENGERS Pvt Ltd");
		System.out.println("\t\t\t***********************************************************");
		System.out.println("\n\t\t\t                  MAIN PORTAL\n");
		System.out.println("\t\t\tPLEASE ENTER:\n");
		System.out.println("\t\t\t\t1 - LOGIN\n");
		System.out.println("\t\t\t\t2 - REGISTER\n");
		System.out.println("\t\t\t\t3 - EXIT\n");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		switch(i){
			case 1:{
					mp.login();
					break;}
			case 2:{ Register r = new Register();
					 r.setdata();
					 break;}
			case 3:{ System.out.println("\t\t\tCLOSING PORTAL.........");
					 st.run();
					 System.out.println("\n\n\t\t\t******THANK YOU******\n");
					System.exit(0);}
			default :{
						System.out.println("\nPLEASE ENTER CORRECT KEY.\nREDIRECTING  >>>>>>>>>>");
						st.run();
						main("");
			}
			}
	}
}