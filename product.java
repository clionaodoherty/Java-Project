package part1tester;

public class product {
	//The following are the instance variables for the product class
	private int proCode;
	private String proMake;
	private String proModel;
	private double proPrice;
	private int proQtyAvailable;
	private boolean proDiscontinued;
	
	//Setting up the constructor
	public product(int proCode, String proMake, String proModel, double proPrice, int proQtyAvailable, boolean proDiscontinued) {
		this.proCode = proCode;
		this.proMake = proMake;
		this.proModel = proModel;
		this.proPrice = proPrice;
		this.proQtyAvailable = proQtyAvailable;
		this.proDiscontinued = proDiscontinued;
		
		 //the following are Mutator and accessor methods for each of the instance variables.
				
	}

	public int getProCode() {
		return proCode;
	}

	public void setProCode(int proCode) {
	   this.proCode = proCode;
	}

	public String getProMake() {
		return proMake;
	}

	public void setProMake(String proMake) {
		this.proMake = proMake;
	}

	public String getProModel() {
		return proModel;
	}

	public void setProModel(String proModel) {
		this.proModel = proModel;
	}

	public double getProPrice() {
		return proPrice;
	}

	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}

	public int getProQtyAvailable() {
		return proQtyAvailable;
	}

	public void setProQtyAvailable(int proQtyAvailable) {
		this.proQtyAvailable = proQtyAvailable;
	}

	public boolean isProDiscontinued() {
		return proDiscontinued;
	}

	public void setProDiscontinued(boolean proDiscontinued) {
		this.proDiscontinued = proDiscontinued;
	}
	
	
	//This method simply returns the string getProductDetails to be used when called
	// This method should print the product details
	public void getProductDetails() {
	  System.out.println("Product Code: " + getProCode());
	  System.out.println("Product Make: " + getProMake());
	  System.out.println("Product Model: " + getProModel());
	  System.out.println("Product Price: £" + getProPrice());
	  System.out.println("------------------------------------------");
	 }
	
	//This method prints the product list to the console window
	public String printProductList()
	{
		
		String returnString = getProCode() + ":" + getProMake() + "(" + getProModel() + ")";
		return returnString;
	}
}