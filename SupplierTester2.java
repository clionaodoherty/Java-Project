package part1tester;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;
public class SupplierTester2 {

	//setting up the scanner before main string method to allow it to be used throughout the class 
	//by simply calling it
	public static Scanner input = new Scanner (System.in);

	public static void main(String[] args) {
	
		// setting up the supplier array list
		ArrayList<Supplier> allSuppliers = new ArrayList<Supplier>();
			allSuppliers = createSupplierArrayList();
		
			
		
		int menuOption = mainMenu();
		boolean runMenu = true;
		while (runMenu) {

		switch (menuOption) {
		
		case 1 :
			
			//when the user selects option "1", the product list is printed and sorted by supplier
			System.out.println("-----All Products-----");
			
			for(Supplier eachSupplier: allSuppliers)
			{
				eachSupplier.printSupplierDetails();
			}
			
			// Allows the user to return to the main menu after the method is complete
			menuOption = mainMenu();
			//separates the different menu options 
			break;
			
		case 2 :
			
			//when the user selects option "2" the add supplier method should run
			//Recalling the add supplier method from the supplierTester class 
			//allowing the user to input the relevant supplier details
			allSuppliers.add(addSupplier());
			System.out.println("The new supplier has been added sucessfully");
			
			for (Supplier eachSupplier:allSuppliers) {
				eachSupplier.printSupplierDetails();
			}
			
			menuOption = mainMenu();
		    break;
			
		case 3 :
			
			//when the user selects option "3" the add new product method should run
			System.out.println("-----New Product-----");
			input.nextLine();
			//Assigning the new product with its supplier
			System.out.print("Please enter the name of the supplier the product will be assigned to: ");
			String supplierName = input.nextLine();
			
			//recalling the add product method from the supplier class
			//allowing the user to input the relevant product details
			for (Supplier mySupplier: allSuppliers) {
				if (supplierName.equals(mySupplier.getSupName())) {
					mySupplier.addProducts(input);
				}
			}
			
			//reprints all the supplier's details and products assigned to that supplier
			//including the new product added
			for (Supplier eachSupplier: allSuppliers) {
			eachSupplier.printSupplierDetails();
			}
		
			menuOption = mainMenu();
			break;

			
		case 4 :
			
			//If the user selects option "8" from the menu, the program is terminated
			System.exit(0);
			break;
			
}
}
	}
	
	//The main menu interface 
	//which provides the user with the different features that can be executed by the system
	     public static int mainMenu() {
		System.out.println("---MAIN MENU---");
		System.out.println("1. Print all products");
		System.out.println("2. Add a new supplier");
		System.out.println("3. Add a new product");
		System.out.println("4. Exit application");
	    

	    boolean validInput = false;
	    while(!validInput)
	    	
	    {
	    	
	    	//prompts user to enter a main menu option
	     System.out.println("Enter your menu choice: ");
	     if (input.hasNextInt()) {
	      
	    	 //Validates the main menu to accept only data of type integer between 1 and 4
	           int menuOption = input.nextInt(); 
	           if(menuOption >=1 && menuOption <=4)
	        	   
	      {
	      
	        	   validInput=true;
	           return menuOption;
	           
	      } else { 
	    	  
	    	  //provides user with an error message if invalid option was entered into the menu option
	          System.out.println("***Invalid menu option***");
	    		  System.out.println("Please enter an integer between 1 and 4");
	      input.nextLine();
	      }
	    
	     } else {
	      
	          System.out.println("Please enter a valid menu option");
	      input.nextLine();
	     }
	     
	    }
	    
	    return 0;
	    
	     }
	
	
	   //Main Menu option 2 - The following method will allow us to ask the user for information 
	   //to add a new product to the system
	public static Supplier addSupplier() {
		System.out.println("-----Add supplier to the Database-----");
		
		System.out.println("Please enter the following supplier details:");
		
		System.out.println("Supplier Code: ");
		//// "input" Allows user to answer the questions prompted to them 
		//by the system by inputting relevant data
		int Code = input.nextInt();
		
		System.out.println("Supplier Name: ");
		String supName = input.nextLine();
		input.nextLine();
		
		System.out.println("** Please enter the Address of the Supplier: **");
		System.out.println("Building  Number: ");
		int bldNum = input.nextInt();
		
		System.out.println("Street Name: ");
		String bldStreet = input.nextLine();
		
		input.nextLine();
		System.out.println("Town Name: ");
		String bldTown = input.nextLine();
		
		System.out.println("Postcode: ");
		String bldPcode = input.nextLine();
		
		System.out.println("Country Name: ");
		String bldCountry = input.nextLine();
		
		//initialising the new address
		Address newAddress = new Address (bldNum, bldStreet, bldTown, bldPcode, bldCountry);
		
		//prints out the region choices for the user using the Enum supRegion class
		System.out.println("Region Choices: ");
		int index = 1;
		int numOfSupRegionChoices = EnumSet.allOf(SupRegion.class).size();
		
		printRegionChoices(index, numOfSupRegionChoices);
		System.out.println("Please enter the corresponding number of the region: ");
		SupRegion supRegion = SupRegion.values()[input.nextInt()-1];
		
		input.nextLine();
		System.out.println(supName + " will initally be set up with no products. To add a product to the supplier simply select option 3 at the main menu.");
		ArrayList<product> emptyList = new ArrayList<product>();
		Supplier newSupplier = new Supplier(Code, supName, newAddress, supRegion, emptyList);
		return newSupplier;
		}
		
	
	//Adding supplier details to be stored in the supplier array list
		public static ArrayList<Supplier> createSupplierArrayList() {
			int[] supCode = {123, 124, 125, 126};
			String[] supName = {"Boots", "Superdrug", "Tescos", "Argos"};
			
			Address address01 = new Address(14, "35-47 Donegall Place", "Belfast", "BT1 5AD","Ireland" );
			Address address02 = new Address(56, "Royal Avenue", "Belfast", "BT1 1FD","Ireland" );
			Address address03 = new Address(131, "Main Street", "Crumlin", "BT29 4UP","Ireland" );
			Address address04 = new Address(82, "15 Lisburn Square", "Lisburn", "BT28 1TS","Ireland" );
			Address[] supAddress = new Address[]{address01,address02,address03,address04};
			SupRegion[] supRegion = {SupRegion.EUROPE, SupRegion.OUTSIDE_EU, SupRegion.UNITED_KINGDOM, SupRegion.EUROPE, SupRegion.OUTSIDE_EU, SupRegion.UNITED_KINGDOM};
		

			int codeSup = -1;
			String nameSup = null;
			SupRegion regionSup = null;
			Address addressSup = null;
			

			ArrayList<Supplier> suppliers = new ArrayList<Supplier>();		
			for (int i = 0; i<supCode.length; i++) {
				codeSup = supCode[i];
				nameSup =supName[i];
				addressSup = supAddress[i];
				regionSup = supRegion[i];
				
				suppliers.add(new Supplier(codeSup, nameSup, addressSup, regionSup, createProductArrayList()));
			}
			return suppliers;
		}
			
		//Adding product details to be stored in the product array list
			public static ArrayList<product> createProductArrayList() {
				int[] proCode = {123,124,125,126,127,128};
				String[] proMake = {"GHD","BabyLiss", "Lee Stafford", "Toni & Guy", "Remington", "Tresemmé"};
				String[] proModel = {"Smooth 215 Straightener", "Diamond 235", "Play It Straightener", "Illusions styler straightener", "S3500 Ceramic Straight 230", "Keratin Smooth Control"};
				double [] proPrice = {159.99, 69.99, 99.99, 119.99, 39.99, 59.99};
				int [] proQtyAvailable = {5, 4, 7, 2, 3, 6};
				boolean[] proDiscontinued = {true, true, false, true, false, true};
				
				
			ArrayList<product> productList = new ArrayList<product>();
			for (int i= 0; i<proCode.length; i++) {
			
				
				productList.add(new product(proCode[i], proMake[i], proModel[i], proPrice[i], proQtyAvailable[i], proDiscontinued[i]));
			}
			
							return productList;
			}
			
			public static void printRegionChoices(int index, int numofEnums) 
			{
				if(index <= numofEnums) 
				{
					System.out.println(index + ": " + SupRegion.values()[index-1].getRegionAsString());
					index++;
					printRegionChoices(index, numofEnums);

 
			

				}
			}
}




	
	
	
	
	
	
	
