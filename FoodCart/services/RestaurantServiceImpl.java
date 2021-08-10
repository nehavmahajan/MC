package services;

import java.util.ArrayList;
import models.Restaurant;
import repository.DB;

public class RestaurantServiceImpl {
	private static RestaurantServiceImpl restaurantServiceImpl = null;
	
	private RestaurantServiceImpl() {}
	
	public static RestaurantServiceImpl getInstance() {
		if(restaurantServiceImpl == null) {
			return new RestaurantServiceImpl();
		}
		else {
			return restaurantServiceImpl;
		}
	}
	
	/*-----------------------------------------------------------------------------------*/
	
	public void registerRestaurant(String resturantName,String pinCodes, String foodItem, int foodItemPrice , int quantity,String userId) {
		if(resturantName== "" || pinCodes == "" || foodItem == "" ) {
			System.out.println("Input is incorrect");
		}
		Restaurant r = new Restaurant(resturantName, getPinCodes(pinCodes) , foodItem, foodItemPrice, quantity,userId) ;
		DB.getRestoMap().put(resturantName, r);
	}
	
	/*-------------------------------------------------------------------------------------*/
	
	public void updateQuantity(String restoName, int quantity) {
		DB.getRestoMap().get(restoName).setQuantity(quantity+DB.getRestoMap().get(restoName).getQuantity());
		System.out.println("\nQuantity Updated :\n");
		System.out.println("Name:"+ DB.getRestoMap().get(restoName).getResturantName()+",Item : "+DB.getRestoMap().get(restoName).getFoodItem()+
				",Quantity : "+DB.getRestoMap().get(restoName).getQuantity());
	}
	
	/*-------------------------------------------------------------------------------------*/
	
	private ArrayList<String> getPinCodes(String pinCodes) {
		ArrayList<String>  pinCodeList = new ArrayList<String>();
		String [] pins = pinCodes.split("/");
		for(String  i : pins) {
			pinCodeList.add(i);
		}
		return pinCodeList;
	}
	
	/*-------------------------------------------------------------------------------------*/
	
	public void updateLocation(String restoName, String pinCodes) {
		DB.getRestoMap().get(restoName).setPinCodes(getPinCodes(pinCodes));
		System.out.println("\nLocation Updated :");
		System.out.println("Name : "+ DB.getRestoMap().get(restoName).getResturantName()+"Item :"+DB.getRestoMap().get(restoName).getFoodItem()+", PinCodes :"+DB.getRestoMap().get(restoName).getPinCodes());
	}
}
