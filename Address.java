package part1tester;

public class Address {
	////The following are the instance variables for the Address class
	private int bldNum;
	private String bldStreet;
	private String bldTown;
	private String bldPcode;
	private String bldCountry;
	
	//Setting up the constructor
	public Address(int bldNum, String bldStreet, String bldTown, String bldPcode, String bldCountry) {
		super();
		this.bldNum = bldNum;
		this.bldStreet = bldStreet;
		this.bldTown = bldTown;
		this.bldPcode = bldPcode;
		this.bldCountry = bldCountry;
	}
//The following are the Mutator and accessor methods for each of the instance variables.
	
	public int getBldNum() {
		return bldNum;
	}

	public void setBldNum(int bldNum) {
		this.bldNum = bldNum;
	}

	public String getBldStreet() {
		return bldStreet;
	}

	public void setBldStreet(String bldStreet) {
		this.bldStreet = bldStreet;
	}

	public String getBldTown() {
		return bldTown;
	}

	public void setBldTown(String bldTown) {
		this.bldTown = bldTown;
	}

	public String getBldPcode() {
		return bldPcode;
	}

	public void setBldPcode(String bldPcode) {
		this.bldPcode = bldPcode;
	}

	public String getBldCountry() {
		return bldCountry;
	}

	public void setBldCountry(String bldCountry) {
		this.bldCountry = bldCountry;
	}
   
	//This was the initial method I used in order to try and recall the suppliers address
	/*public String printSupAddress() {
	String returnString = "---Suppliers Address---";
	returnString += "\nBuilding Number: " + getBldNum(); 
	returnString += "\nStreet Name: " + getBldStreet();
	returnString += "\nTown Name: " + getBldTown();
	returnString += "\nPostcode: " + getBldPcode();
	returnString += "\nCountry Name: " + getBldCountry();
	return returnString;
	}*/
	
	//This was the second method i used in an attempt to make the recalling of the address work
	 //This method simply returns the string printSupAddresss to be used when called
	// This method should print the supplier's address 
      public void printSupAddress() {
           System.out.println("-----Suppliers Address-----");
           System.out.println("Building Number: " + getBldNum());
           System.out.println("Street Name: " + getBldStreet());
           System.out.println("Town Name: " + getBldTown());
           System.out.println("Postcode: " + getBldPcode());
           System.out.println("Country Name:" + getBldCountry());
           System.out.println("------------------------------------------");

		}
}
