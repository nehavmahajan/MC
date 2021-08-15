package models;

import java.util.HashMap;

public class Theater {

	private String name;
	private String location;
	private HashMap<String, Screen> screens;

	public Theater(String name, String location) {
		this.name = name;
		this.location = location;
		this.screens = new HashMap<String, Screen>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public HashMap<String, Screen> getScreens() {
		return screens;
	}

	public void setScreens(HashMap<String, Screen> screens) {
		this.screens = screens;
	}
}
