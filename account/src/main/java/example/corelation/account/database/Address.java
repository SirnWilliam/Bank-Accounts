package example.corelation.account.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressid;
	private String streetName;
	private String cityName;
	private String stateName;
	private long zipCode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String streetName, String cityName, String stateName, long zipCode) {
		super();
		this.streetName = streetName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.zipCode = zipCode;
	}

	public long getAddressid() {
		return addressid;
	}

	public void setAddressid(long addressid) {
		this.addressid = addressid;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
}
