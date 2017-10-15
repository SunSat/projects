package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.AniSatLogger;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.pojo.Mode;

public class ClientApplication extends Thread{

	AniSatLogger logger = AniSatLogger.getInstance();
	static ArrayList<String> al = new ArrayList<String>();
	static Object lockObj = new Object();
	public static void main(String[] args) {

		ClientApplication app = new ClientApplication();
		app.startClient();
	
		//AniSatLogger logger = AniSatLogger.getInstance();
	
	}
	
	
	public void startClient() {
		ClientApplication app1 = new ClientApplication();
		app1.setName("app1");
		app1.start();
		/*ClientApplication app2 = new ClientApplication();
		app2.setName("app2");
		app2.start();
		ClientApplication app3 = new ClientApplication();
		app3.setName("app3");
		app3.start();*/
		try {
			app1.join();
			//app2.join();
			//app3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Comparing the List");
		logger.compareResult(al);
		logger.shutDown();

	}
	
	public void run() {

		Scanner scan = new Scanner(System.in);
		boolean contiue = true;
		while(contiue) {
			String word = scan.nextLine();
			if(word.contains("exit")) {
				contiue = false;
				break;
			}
			/*synchronized (lockObj) {
				al.add(word);
			}*/
			logger.log(word,Mode.All);//Thread.currentThread().getName()+ " : My msg : " +word, Mode.All);
		}
		System.out.println(Thread.currentThread().getName()+ "Going down.");
	}

}
