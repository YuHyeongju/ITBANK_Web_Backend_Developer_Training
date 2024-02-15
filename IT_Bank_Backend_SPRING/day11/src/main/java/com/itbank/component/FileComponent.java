package com.itbank.component;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class FileComponent {
	private String saveDirectory = "C://upload";

	public FileComponent() {
		File f = new File(saveDirectory);
		if(f.exists() == false) {
			f.mkdirs();
		}
		
		
	}
	
}
