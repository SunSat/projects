package com.sunsat.sathish.java.hackerrank.preparation.general.javanio.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ssundar2 on 23-03-2017.
 */
public class NioFileOperation {

    /*public static void main(String ... args) throws FileNotFoundException,IOException {
        /*RandomAccessFile file = new RandomAccessFile("C:\\Users\\ssundar2\\Desktop\\Important links.txt","rw");
        //System.out.println(file.readLine());
        FileChannel ch = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(16);
        while(ch.read(buffer) != -1) {
            buffer.flip();
            while(buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
        }

    }*/
    public static void main(String[] args) {

        String myStr = "good";

        char[] myCharArr = {'g', 'o', 'o', 'd' };

        String newStr = null;

        for(char ch : myCharArr){

            newStr = newStr + ch;

        }

        System.out.println("jjjjjjjjjjjj: "+newStr);
        System.out.println((newStr == myStr)+ " " + (newStr.equals(myStr)));

        int i=10;
        switch(i)
        {
            case 5 : System.out.print("Case 5! ");
            case 10 : System.out.print("Case 10! ");
            case 20 : System.out.print("Case 20! ");
            default : System.out.print("Default Case! ");
                break;
        }

    }
}
