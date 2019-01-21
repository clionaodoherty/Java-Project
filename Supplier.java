package part1tester;
//importing the scanner into the supplier class to allow user input
import java.util.Scanner;
import java.util.ArrayList;

public class Supplier {
	//Initialising the scanner
	Scanner input = new Scanner(System.in);

	 //The following are the instance variables for the Supplier class
	private int supCode;
	private String supName;
	private Address supAddress;
	private SupRegion supRegion;
	public ArrayList<product> supProducts;

	//Setting up the constructor
	public Supplier(int supCode, String supName, Address supAddress, SupRegion supRegion,
			ArrayList<product> supProducts) {
		this.supCode = supCode;
		this.supName = supName;
		this.supAddress = supAddress;
		this.supRegion = supRegion;
		this.supProducts = supProducts;
		
		//The following are Mutator and accessor methods for each of the instance variables.
	}

	public int getSupCode() {
		return supCode;
	}

	public void setSupCode(int supCode) {
		this.supCode = supCode;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public Address getSupAddress() {
		return supAddress;
	}

	public void setSupAddress(Address supAddress) {
		this.supAddress = supAddress;
	}

	public SupRegion getSupRegion() {
		return supRegion;
	}

	public void setSupRegion(SupRegion supRegion) {
		this.supRegion = supRegion;
	}

	public ArrayList<product> getSupProducts() {
		return supProducts;
	}

	public void setSupProducts(ArrayList<product> supProducts) {
		this.supProducts = supProducts;
	}

	//Recalls the print product list method
	public void printProductList() {

		
		for (product eachProduct : getSupProducts()) 
		eachProduct.getProductDetails();
		System.out.println();
	
	
	}
	 //This method simply returns the string printSupplierDetails to be used when called
	// This method should print the supplier's Details
	public void printSupplierDetails() {
		System.out.println("\n----Supplier Details----");
		System.out.println("\nSupplier: " + this.getSupName());
		System.out.println("ID: " + this.getSupCode());
		//System.out.println("address: " + this.getSupAddress());
		//System.out.println(Address.printSupAddress());
		System.out.println("Region: " + this.getSupRegion().getRegionAsString());

		for (product eachProduct : this.supProducts) {
			eachProduct.getProductDetails();
		}
		
		System.out.println();
		}
	
	
	// The following method will allow us to ask the user for information 
	//to add a new product to the system
	public void addProducts(Scanner input) {
		//scanner declared to allow user input
	System.out.println("Please enter how many products you wish to add: ");
	int numProducts = input.nextInt();
	for (int i=0; i<numProducts; i++) {
		
		input.nextLine();
		System.out.println();
		System.out.println("Product Code: ");
		int proCode = input.nextInt();
		input.nextLine();
		
		System.out.println("Product Make: ");
		String proMake = input.nextLine();
		
		System.out.println("Product Model: ");
		String proModel = input.nextLine();
		
		System.out.println("Product Price: ");
		double proPrice = input.nextDouble();
		
		System.out.println("Quantity Available: ");
		int proQtyAvailable = input.nextInt();
		input.nextLine();
		
		System.out.println("Is the product Discontinued: (Y or N)");
		String userIn = input.nextLine();
		//validation to ensure that only the boolean values "N" or "Y" can be entered 
		boolean proDiscontinued = false;
		
		if (userIn.equalsIgnoreCase("Y") || userIn.equalsIgnoreCase("Yes")) {
			proDiscontinued = true; }
		
	else if (userIn.equalsIgnoreCase("N") || userIn.equalsIgnoreCase("No")) {
		proDiscontinued = false; 
		
		} else {

	System.out.println("***Error***"+"/nPlease enter Y or N");
	//error message provided if data entered is of incorrect data type
	userIn = input.nextLine();

		}
		
	product newProduct = new product(proCode, proMake, proModel, proPrice, proQtyAvailable, proDiscontinued);

	getSupProducts().add(newProduct);
		System.out.println("Product successfully added!");
	 
	
	
	}

}
	}
