package com.theAvengers;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileFilter;
import java.io.File;
import java.io.IOException;

class Record{
	void showAllRecord(){
		SleepThread st = new SleepThread();
		FileInputStream fis =null;
		ObjectInputStream ois = null;
		File temp = new File("MainPortal.java");
		String s = temp.getAbsolutePath();
		s = s.replace("\\MainPortal.java","");
		File file = new File(s);
		FileFilter ff = new FileFilter(){
			public boolean accept(File f){
				if((f.getName()).endsWith(".txt"))
					return true;
				else
					return false;
			}
		};
		int x = 0;
		File f[] = file.listFiles(ff);
		for(File fl : f){
			if(ff.accept(fl)){
				try{ x=1;
					fis = new FileInputStream(fl);
					ois = new ObjectInputStream(fis);
					Employee emp = (Employee)ois.readObject();
					System.out.println("\n*******************\n");
					emp.showData();
				}
				catch(Exception e){
					System.out.println("\nSomething went wrong!\n");
					System.out.println("\n\nREDIRECTING TO MAIN PORTAL >>>>>>>>>>>>>\n\n");
					MainPortal mp = new MainPortal();
					st.run();
					mp.main("");
					}
				finally{
					try{
						fis.close();
						ois.close();
					}
					catch(IOException ex)
					{System.out.println("\nSomething went wrong!\n");
					System.out.println("\n\nREDIRECTING TO MAIN PORTAL >>>>>>>>>>>>>\n\n");
					MainPortal mp = new MainPortal();
					st.run();
					mp.main("");
					}
				}
			}	
		}
		if(x==0){
				System.out.println("\nNO RECORDS PRESENTS.\n");
				System.out.println("REDIRECTING TO MAIN PORTAL. >>>>>>>>>>>>>>>>\n\n");
				MainPortal mp = new MainPortal();
				st.run();
				mp.main();}
		}
		
	}
