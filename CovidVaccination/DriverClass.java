import exceptions.UserNotFoundException;
import repository.Price;
import repository.VaccineType;
import services.DistrictService;
import services.SlotService;
import services.StateService;
import services.UserService;
import services.VaccineCenterService;
import services.WardService;

public class DriverClass {
	
	public static void main(String[] args) throws UserNotFoundException {
		
		 UserService userService = UserService.getInstance();
		 StateService stateService = StateService.getInstance();
		 DistrictService districtService = DistrictService.getInstance();
		 WardService wardService = WardService.getInstance();
		 VaccineCenterService vaccineCenterService = VaccineCenterService.getInstance();
		 SlotService slotService = SlotService.getInstance();
		
	
		userService.registerUser("409213448906", "Neha" , "Neha", 22 , "Maharashtra", "Nashik" , "Nashik"  );
		userService.registerUser("409213448906", "Neha" , "Neha", 22 , "Maharashtra", "Nashik" , "Nashik"  );
		userService.registerUser("409213448906", "Neha" , "Neha", 22 , "Maharashtra", "Nashik" , "Nashik"  );
		stateService.addState("Maharashtra");
		stateService.addDistrict("Maharashtra","Nashik");
		districtService.addWard("Maharashtra","Nashik","Nashik");
		wardService.addCenter("Maharashtra","Nashik","Nashik","CnterName");
		
		vaccineCenterService.addSlots("Maharashtra", "Nashik" , "Nashik","CnterName",VaccineType.COVISHIELD, 20, 45, "12-2-2010", Price.FREE);
		vaccineCenterService.addSlots("Maharashtra", "Nashik" , "Nashik","CnterName",VaccineType.COVAXIN, 20, 45, "12-2-2010", Price.FREE);
		vaccineCenterService.addSlots("Maharashtra", "Nashik" , "Nashik","CnterName1",VaccineType.COVISHIELD, 20, 45, "12-2-2010", Price.FREE);
		
		userService.loginUser("409213448906");
		
		userService.checkSlot("Maharashtra", "Nashik", "Nashik", VaccineType.COVISHIELD , "12-2-2010", 45 , Price.FREE);
		userService.bookSlot("Nashik","CnterName",VaccineType.COVISHIELD , "12-2-2010", 45, Price.FREE,"12-2-2010");
		
		userService.checkSlot("Maharashtra", "Nashik", "Nashik",VaccineType.COVISHIELD , "12-2-2010", 45 , Price.FREE);
		
		userService.showBookingData();
		vaccineCenterService.showCenterBookingData("Maharashtra", "Nashik" , "Nashik", "CnterName");
		

	}

}
