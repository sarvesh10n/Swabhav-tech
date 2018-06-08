package com.techlabs.directory.test;

import com.techlabs.directory.File;
import com.techlabs.directory.Folder;

public class CompositePatternTest {

	public static void main(String args[]) {
		Folder root = new Folder("movies");
		root.add(new File("abc", "avi", "400mb"));

		Folder f2 = new Folder("songs");
		f2.add(new File("xyz", "mp3", "6mb"));
		root.add(f2);
		
		Folder f3=new Folder("data");
		f3.add(new File("file","ppt","2MB"));
		root.add(f3);

		root.showContent();
		}
	}

