package com.sunsat.sathish.java.hackerrank.preparation.general;

public class PrintNumbers {
	   public boolean printOdd=false;
	    public static int number=0;

	    public boolean isPrintOdd() {
	        return printOdd;
	    }

	    public synchronized void setPrintOdd(boolean printOdd) {
	        this.printOdd = printOdd;
	        number++;
	    }
}
