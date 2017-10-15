package com.sunsat.sathish.java.hackerrank.preparation.general;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class Watcher {

	public static void main(String ...args) throws IOException, URISyntaxException, InterruptedException {
		/*URL url = Watcher.class.getResource("csm.properties");
		System.out.println(url.getPath());
		FileSystem fileSys = FileSystems.getFileSystem(url.toURI());
		WatchService watcher = fileSys.newWatchService();
		Path p = Paths.get(url.toURI());
		WatchKey key = p.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);*/
		
		URL url = Watcher.class.getResource("csm.properties");
		Path p = Paths.get(url.toURI());
		p = p.getParent();
		FileSystem sys = FileSystems.getDefault();
		WatchService service = sys.newWatchService();
		WatchKey key = p.register(service,StandardWatchEventKinds.ENTRY_MODIFY);
		for(;;) {
			List<WatchEvent<?>> li = key.pollEvents();
			
		}	
		
	}
}
