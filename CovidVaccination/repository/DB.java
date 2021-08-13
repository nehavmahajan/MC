package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import models.*;
/* search criteria :  1. vaccine type 2. date 3. slot(1/2) */
/*user - <aadhar, user>
 * state: state name , districts
 * district: district name, wards
 * ward : ward name , centers 
 * vaccine center: <center name, slot , bookings_past_data >
 * slot: <vaccine type, date, slot(1/2), age ,price (paid\free) >
 * 
 */
public class DB {
		private static DB db = null;
		public static String userId = null;
		private HashMap<String,User > userMap = null;
		private HashMap<String, ArrayList<District>> stateMap = null;
		private HashMap<String, ArrayList<Ward>> districtMap = null;
		private HashMap<String, ArrayList<VaccineCenter>> wardMap = null;
		private HashMap<String, ArrayList<Slot>> centerMap = null;
		private HashMap<VaccineType, Integer > slotMap = null;
		private HashMap<String, Booking>  bookingMap = null;
		private Vector<Booking> bookings = null;
		
		private DB() {
			userMap = new 	HashMap<String,User>();
			stateMap = new HashMap<String, ArrayList<District>>();
			districtMap = new HashMap<String, ArrayList<Ward>>();
			wardMap = new HashMap<String, ArrayList<VaccineCenter>>();
			centerMap = new HashMap<String, ArrayList<Slot>>();
			slotMap = new HashMap<VaccineType, Integer>();
			bookingMap = new HashMap<String, Booking>();
			bookings = new Vector<Booking>();
		}
		
		public Vector<Booking> getBookings() {
			return bookings;
		}

		public void setBookings(Vector<Booking> bookings) {
			this.bookings = bookings;
		}

		public HashMap<String, Booking> getBookingMap() {
			return bookingMap;
		}

		public void setBookingMap(HashMap<String, Booking> bookingMap) {
			this.bookingMap = bookingMap;
		}

		public HashMap<VaccineType, Integer> getSlotMap() {
			return slotMap;
		}

		public void setSlotMap(HashMap<VaccineType, Integer> slotMap) {
			this.slotMap = slotMap;
		}
		public HashMap<String, ArrayList<Slot>> getCenterMap() {
			return centerMap;
		}
		public void setCenterMap(HashMap<String, ArrayList<Slot>> centerMap) {
			this.centerMap = centerMap;
		}

		public HashMap<String, User> getUserMap() {
			return userMap;
		}

		public void setUserMap(HashMap<String, User> userMap) {
			this.userMap = userMap;
		}

		public HashMap<String, ArrayList<District>> getStateMap() {
			return stateMap;
		}

		public void setStateMap(HashMap<String, ArrayList<District>> stateMap) {
			this.stateMap = stateMap;
		}

		public HashMap<String, ArrayList<Ward>> getDistrictMap() {
			return districtMap;
		}

		public void setDistrictMap(HashMap<String, ArrayList<Ward>> districtMap) {
			this.districtMap = districtMap;
		}

		public HashMap<String, ArrayList<VaccineCenter>> getWardMap() {
			return wardMap;
		}

		public void setWardMap(HashMap<String, ArrayList<VaccineCenter>> wardMap) {
			this.wardMap = wardMap;
		}

		
		
		
		public static DB getInstance() {
			if( db == null) {
				return db = new DB();
			}
			else {
				return db;
			}
		}
		
}
