package models;

import java.util.HashMap;

import repository.Status;
import repository.VaccineType;

public class VaccineCenter extends Ward {

	private String vaccineCenter;
	private Status status;
	private HashMap<VaccineType, Integer > slotMap = null;
	public VaccineCenter(String stateName, String districtName, String wardName, String vaccineCenter) {
		super(stateName, districtName, wardName);
		this.vaccineCenter = vaccineCenter;
		this.setStatus(Status.AVAILABLE);
		this.slotMap = new HashMap<VaccineType ,Integer>();
	}

	public HashMap<VaccineType, Integer> getSlotMap() {
		return slotMap;
	}

	public void setSlotMap(HashMap<VaccineType, Integer> slotMap) {
		this.slotMap = slotMap;
	}

	public String getVaccineCenter() {
		return vaccineCenter;
	}

	public void setVaccineCenter(String vaccineCenter) {
		this.vaccineCenter = vaccineCenter;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
}
