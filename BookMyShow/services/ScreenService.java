package services;

import database.DB;
import models.Screen;
import models.Show;
import models.Theater;

public class ScreenService {
	private static ScreenService screenSvc = null;
	private DB db= DB.getInstance();
	private ScreenService() {
		
	}
	
	public static ScreenService getInstance() {
		if( screenSvc == null) {
			return screenSvc = new ScreenService();
		}
		else {
			return screenSvc;
		}
	}
	
	public void addScreen(Theater t,String screenId) {
		Screen s = new Screen(screenId);
		
		db.getScreenMap().put(screenId, s);
		t.getScreens().put(screenId, s);
	}

	public void addShow(String movieName, String time, String duration, String screen) {
		Show s = new Show(movieName, time, duration,screen);
		db.getShowMap().put(movieName, s);
		db.getScreenMap().get(screen).getShows().put(movieName, s);
		
	}
	
}
