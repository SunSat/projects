package com.sunsat.sathish.java.hackerrank.preparation.general.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class RequestHandler implements Runnable {
	private List<Socket> socketLi = null;
	private boolean interupt = false;

	public RequestHandler(List<Socket> soLi) {
		this.socketLi = soLi;
	}

	public void run() {
		while (!interupt) {
			Socket s = null;
			InputStream in = null;
			try {
				synchronized (socketLi) {
					if(interupt) break;
					if (socketLi.isEmpty()) {
						socketLi.wait();
					} 
					s = socketLi.remove(0);
				}
				if(s == null) continue;
				in = s.getInputStream();
				InputStreamReader reader = new InputStreamReader(in);
				BufferedReader bufread = new BufferedReader(reader);
				//handle the request with message
				System.out.println(bufread.readLine());
			} catch (Exception e) {
				try {
					if(s != null) {
						s.close();
						in.close();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		}
	}
	
	public void shutDown() {
		try {
			interupt = true;
			synchronized (socketLi) {
				socketLi.notifyAll();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
