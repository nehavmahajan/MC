package models;

public class Ward extends District{

	private String wardName;

	public Ward(String stateName,String districtName, String wardName) {
		super(stateName , districtName);
		this.wardName= wardName;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	
}
