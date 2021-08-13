package models;

//district: district name, wards

public class District extends State{
	private String districtName ; 

	public District(String stateName, String districtName) {
		super(stateName);
		this.setDistrictName(districtName);
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
}
