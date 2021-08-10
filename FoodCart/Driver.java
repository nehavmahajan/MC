import exceptions.UserNotExistException;
import repository.Gender;
import services.OrderServiceImpl;
import services.RatingServiceImpl;
import services.RestaurantServiceImpl;
import services.UserServiceImpl;
import services.showRestaurantServiceImpl;

public class Driver {
	
	public static String phoneNumber = "";
	
	public static void main(String args[]) throws UserNotExistException {
		
		OrderServiceImpl orderServiceImpl = OrderServiceImpl.getInstance() ;
		UserServiceImpl userServiceImpl = UserServiceImpl.getInstance();
		RestaurantServiceImpl restaurantServiceImpl = RestaurantServiceImpl.getInstance();
		RatingServiceImpl ratingServiceImpl = RatingServiceImpl.getInstance();
		showRestaurantServiceImpl showRestaurantSvcImpl = showRestaurantServiceImpl.getInstance();
		
		userServiceImpl.registerUser("Pralove", Gender.FEMALE, "PhNumber-1", "HSR");
		userServiceImpl.registerUser("Nitesh", Gender.MALE, "PhNumber-2", "BTM");
		userServiceImpl.registerUser("Vatsal", Gender.MALE, "PhNumber-3", "BTM");
		
		phoneNumber = userServiceImpl.login("PhNumber-1");
		restaurantServiceImpl.registerRestaurant("Food Court-1", "BTM/HSR", "NI Thali", 100, 5, phoneNumber );
		restaurantServiceImpl.registerRestaurant("Food Court-2", "BTM", "Burger", 120, 3, phoneNumber);
		
		phoneNumber = userServiceImpl.login("PhNumber-2");
		restaurantServiceImpl.registerRestaurant("Food Court-3", "HSR", "SI Thali", 100, 1, phoneNumber );
		
		phoneNumber = userServiceImpl.login("PhNumber-3");
		showRestaurantSvcImpl.showRestaurant(showRestaurantSvcImpl.sortRestaurant("price"), phoneNumber);
		
		orderServiceImpl.placeOrder(phoneNumber, "Food Court-1", 2);
		orderServiceImpl.showMyOrders(phoneNumber);
		
		orderServiceImpl.placeOrder(phoneNumber, "Food Court-2", 7);
		
		ratingServiceImpl.createReview("Food Court-2", 3, "Good Food", phoneNumber);
		ratingServiceImpl.createReview("Food Court-1", 5, "Nice Food", phoneNumber);
		
		showRestaurantSvcImpl.showRestaurant(showRestaurantSvcImpl.sortRestaurant("rating"), phoneNumber);
		
		phoneNumber = userServiceImpl.login("PhNumber-1");
		orderServiceImpl.showMyOrders(phoneNumber);
		restaurantServiceImpl.updateQuantity("Food Court-2", 5);
		
		restaurantServiceImpl.updateLocation("Food Court-2", "BTM/HSR");
	}
}
