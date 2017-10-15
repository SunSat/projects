package com.sunsat.sathish.java.hackerrank.preparation.general.javanio.socket.clientSocket;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by ssundar2 on 23-03-2017.
 */
public class TcpEventPublisher extends  Thread{
    public static void main(String ... args) throws IOException {

        Socket s = new Socket("localhost",9999);
        SocketChannel socCh = s.getChannel();
        ByteBuffer b = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter the character: exit to exit");
            String st  = scanner.nextLine();
            if(st.equals("exit")) break;
            b.put(st.getBytes());
            b.flip();
            socCh.write(b);
            b.clear();
        }
    }
}
