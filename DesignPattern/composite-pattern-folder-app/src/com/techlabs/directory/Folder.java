package com.techlabs.directory;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IDriveItem {

	private String name;
	List<IDriveItem> idriveList;

	public Folder(String name) {
		this.name = name;
		idriveList = new ArrayList<IDriveItem>();
	}

	@Override
	public void showContent() {
		
		System.out.println("Folder name is " + name);
		for (IDriveItem item : idriveList) {
			item.showContent();
		}
	}

	public void add(IDriveItem item) {
		idriveList.add(item);
	}

	public List<IDriveItem> getList() {
		return idriveList;
	}

}
