package com.techlabs.directory;

public class File implements IDriveItem{

	private String name;
	private String extension;
	private String size;
	
	public File(String name, String extension, String size) {
		super();
		this.name = name;
		this.extension = extension;
		this.size = size;
	}
	
	@Override
	public void showContent() {
		System.out.println(name+"."+extension+"  "+size);		
	}

	

}
