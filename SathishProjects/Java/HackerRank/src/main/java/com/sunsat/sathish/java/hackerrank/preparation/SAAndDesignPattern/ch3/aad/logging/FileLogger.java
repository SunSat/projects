package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.aad.logging;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileLogger implements Logger {

	File f = null;
	FileOutputStream fout = null;
	BufferedOutputStream bout = null;
	public FileLogger(File fi) {
		f = fi;
		try {
			fout = new FileOutputStream(f);
			bout = new BufferedOutputStream(fout);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	public void log(String msg) {
		
	}
}
