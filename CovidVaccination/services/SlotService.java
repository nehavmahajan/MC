package services;

public class SlotService {
	private static SlotService slotService = null;
	
	private SlotService() {
		
	}
	
	public static SlotService getInstance() {
		if( slotService == null) {
			return slotService = new SlotService();
		}
		else {
			return slotService;
		}
	}
}
