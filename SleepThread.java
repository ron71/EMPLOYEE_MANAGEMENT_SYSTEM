package com.theAvengers;

class SleepThread extends Thread{
		public void run(){
		try{
			sleep(1200);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
}