package com.sunsat.sathish.java.hackerrank.preparation.general.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	public static void main(String ... args) {
		List<Socket> socketLi = new LinkedList<Socket>();
		ExecutorService exector = Executors.newFixedThreadPool(5);
		int port = 5560;
		ServerSocketListener slistner = null;
		RequestHandler rhandler = null;
		try {
			slistner = new ServerSocketListener(port, exector, socketLi);
			rhandler = new RequestHandler(socketLi);
			
			exector.execute(slistner);
			exector.execute(rhandler);
			
		}catch(Exception e) {
			if(slistner !=null) {
				slistner.shutDown();				
			} 
			if(rhandler != null) {
				rhandler.shutDown();
			}
			e.printStackTrace();
		} 
		try {
			Socket s = new Socket("127.0.0.1", port);
			OutputStream out = s.getOutputStream();
			Scanner sc = new Scanner(System.in);
			String str = "";
			while(true) {
				System.out.println("Enter a word and press enter");
				str = sc.nextLine();
				if(str.trim().length() == 0) continue;
				if(str.equals("Exit")) {
					break;
				}
				out.write(str.getBytes());
				out.flush();
			}
			rhandler.shutDown();			
			slistner.shutDown();			
			exector.shutdown();
			exector.shutdownNow();
			out.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(slistner !=null) {
				slistner.shutDown();				
			} 
			if(rhandler != null) {
				rhandler.shutDown();
			} 
			if(exector != null) {
				exector.shutdown();
				exector.shutdownNow();
			}
		}
	}
}
