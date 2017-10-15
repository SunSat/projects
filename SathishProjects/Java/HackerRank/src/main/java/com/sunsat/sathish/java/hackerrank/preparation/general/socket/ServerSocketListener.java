package com.sunsat.sathish.java.hackerrank.preparation.general.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Executor;


public class ServerSocketListener implements Runnable{
	private ServerSocket socket = null;
	private Executor executor = null;
	private List<Socket> socketList = null;
	
	public ServerSocketListener(int port,Executor exec,List<Socket> soList) throws IOException {
		this.socket = new ServerSocket(port);
		this.executor = exec;
		this.socketList = soList;
	}
	
	public void run() {
		while(true) {
			try {
				executor.execute(new SocketHandler(socket.accept(), socketList));
			}catch(Exception e) {
				System.out.println("Issue in handleing the socket"+e.getMessage());
			}
		}
	}
	
	public void shutDown() {
		try {
			if(this.socket != null && socket.isClosed()) {
				socket.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
