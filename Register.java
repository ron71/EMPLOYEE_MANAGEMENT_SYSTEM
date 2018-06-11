package com.theAvengers;

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileFilter;
import java.io.File;
import java.io.IOException;

class Register{
	void setdata(){
		SleepThread st = new SleepThread();
		Scanner sc =new Scanner(System.in);
		System.out.println("\t\t\t**********************************\n");
		System.out.println("\t\t\t NEW EMPLOYEE REGISTRATION PORTAL\n");
		System.out.println("\t\t\t**********************************\n");
		System.out.println("ENTER NEW EMPLOYEE ID:");
		String id = sc.nextLine();
		File file = new File(id+ ".txt");
		if(!file.exists()){
			System.out.println("ENTER  NEW EMPLOYEE NAME:");
			String name = sc.nextLine();
			System.out.println("ENTER NEW EMPLOYEE CODE:");
			String code = sc.nextLine();
			System.out.println("ENTER NEW EMPLOYEE TYPE:");
			String type = sc.nextLine();
			System.out.println("ENTER NEW PASSWORD:");
			String password = sc.nextLine();
			System.out.println("ENTER NEW EMPLOYEE ADDRESS:");
			String add = sc.nextLine();
			Employee emp = new Employee(id,name,code,type,password,add);
			writeInFile(emp);
			}
			else{
				System.out.println("EMPLOYEE ID ALREADY EXISTS.\nTRY AGAIN......\n\n");
				MainPortal mp = new MainPortal();
				st.run();
				mp.main("");
			}
		}
	void writeInFile(Employee emp){
		SleepThread st = new SleepThread();
		FileOutputStream fos =null;
		ObjectOutputStream oos = null;
		File file = new File(emp.empID+".txt");
		try{
			fos = new FileOutputStream(emp.empID+".txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(emp);
		}
		catch(Exception e){
			System.out.println("\nREGISTRATION FAILED\n");
			System.out.println("REDIRECTING TO MAIN PORTAL >>>>>>>>>>>>>\n\n");
			MainPortal mp = new MainPortal();
			st.run();
			mp.main("");
		}
		finally{
			try{
				fos.flush();
				oos.flush();
				fos.close();
				oos.close();
				System.out.println("\n RECORD SAVED.\n\nREDIRECTING TO MAIN PORTAL >>>>>>>>>>>>>\n\n");
				MainPortal mp = new MainPortal();
				st.run();
				mp.main("");
			}
			catch(IOException ex){
				System.out.println();
			}
		}
	}
}