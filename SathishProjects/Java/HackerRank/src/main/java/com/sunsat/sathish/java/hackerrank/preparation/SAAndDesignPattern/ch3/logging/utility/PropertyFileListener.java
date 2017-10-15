package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.utility;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class PropertyFileListener extends Thread {
	
	
	public PropertyFileListener() {

	}
	
	
	public static void main(String ... args) throws IOException {
		URI url;
		try {
			url = new URI("AniSatlogger.properties");
			FileSystem sys = FileSystems.getDefault();
			Path path = sys.getPath("AniSatlogger.properties", "");
			System.out.println(path.toAbsolutePath());
			WatchService watcher = sys.newWatchService();
			WatchKey key = path.register(watcher, java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY);

			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
