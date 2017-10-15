package com.sunsat.sathish.java.hackerrank.preparation.general.javanio.socket.serverSocket;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * Created by ssundar2 on 6/21/2017.
 */
public class ServerSocketChannel {

    public static void main(String[] args) {
        try {
            new ServerSocketChannel().go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void go() throws Exception {
        AsynchronousServerSocketChannel serverSoc = AsynchronousServerSocketChannel.open();
        InetSocketAddress add = new InetSocketAddress("localhost",8999);
        serverSoc.bind(add);
    }
}
