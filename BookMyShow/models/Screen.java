package models;

import java.util.HashMap;

public class Screen {
		
	private Object screenID;
	private HashMap<String, Show> shows;

	public Screen(String screenID) {
		this.screenID = screenID;
		this.shows = new HashMap<String,Show> ();
	}

	public Object getScreenID() {
		return screenID;
	}

	public void setScreenID(Object screenID) {
		this.screenID = screenID;
	}

	public HashMap<String, Show> getShows() {
		return shows;
	}

	public void setShows(HashMap<String, Show> shows) {
		this.shows = shows;
	}
	
	
}
