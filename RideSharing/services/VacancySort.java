package services;

import java.util.Comparator;

import models.Ride;

public class VacancySort implements Comparator<Ride> {

	public int compare(Ride o1, Ride o2) {
		if(o1.getNoOfSeats() > o2.getNoOfSeats()) {
			return -1;
		}
		else if(o1.getNoOfSeats() == o2.getNoOfSeats()) {
			return 0;
		}
		return 1;
	}
}
