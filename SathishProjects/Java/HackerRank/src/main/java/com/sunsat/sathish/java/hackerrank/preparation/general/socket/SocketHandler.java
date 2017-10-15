package com.sunsat.sathish.java.hackerrank.preparation.general.socket;

import java.net.Socket;
import java.util.List;

public class SocketHandler implements Runnable{ 
	private List<Socket> socketLi = null;
	private Socket socket = null;
	
	public SocketHandler(Socket soc,List<Socket> soLi) {
		this.socketLi = soLi;
		this.socket = soc;
	}
	
	public void run() {
		synchronized (socketLi) {
			socketLi.add(socket);
			socketLi.notifyAll();
		}
	}
}
