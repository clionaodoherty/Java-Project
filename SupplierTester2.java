package part02;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;
public class SupplierTester2 {

	
	//setting up the scanner before main string method to allow it to be used throughout the class by simply calling it
	public static Scanner input = new Scanner (System.in);

	public static void main(String[] args) {
		
		//Setting up the product array list
		ArrayList<product> allProducts = new ArrayList<product>();
		allProducts = createProductArrayList();
	
	// setting up the supplier array list
		ArrayList<Supplier> allSuppliers = new ArrayList<Supplier>();
			allSuppliers = createSupplierArrayList();
			
		
		int menuOption = mainMenu();
		boolean runMenu = true;
		while (runMenu) {

		switch (menuOption) {
		
		case 1 :
			
			//when the user selects option "1" 
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
			//Recalling the add supplier method from the supplierTester class allowing the user to input the relevant supplier details
			allSuppliers.add(addSupplier());
			System.out.println("The new supplier has been added sucessfully");
			
			//reprints all the supplier's details including that of the new supplier 
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
			//reprints all the supplier's details and products assigned to that supplier, including the new product added
			for (Supplier eachSupplier: allSuppliers) {
			eachSupplier.printSupplierDetails();
			}
		
			menuOption = mainMenu();
			break;

		case 4 :
			
			//when the user selects option "4" from the menu, the delete product method should run
			input.nextLine();
			//recalling the delete product method from the supplier tester class
		allProducts = deleteProduct(allSuppliers, allProducts);	
		
		
		menuOption = mainMenu();
			break;
			
			
		case 5 :
			
			//when the user selects option "5" from the menu, the update product price method should run
			input.nextLine();
		 updateProductPrice(allSuppliers, allProducts);
		 menuOption = mainMenu();
			
			
			break;
			
			
		case 6 :
			
			// If the user selects option "6" from the main menu, the search for a supplier method should run
			input.nextLine();
			System.out.println("Please enter the name of the supplier you wish to search for: ");
			String searchName = input.nextLine();
			System.out.println("\n");
			//Recalling the search supplier method from the supplier class
			for (Supplier mySupplier :allSuppliers) {
				 mySupplier.searchSupplier(searchName);
			}
			
			menuOption = mainMenu();
			break;
			
			
		case 7 :
			
			//If the user selects option "7" from the menu, the update stock levels method should run
			input.nextLine();
			//Recalling the update stock levels method from the supplier Tester class
			checkStockLevels(allSuppliers, allProducts);
			
			menuOption = mainMenu();
			break;
			
			
			
		case 8 :
			
			//If the user selects option "8" from the menu, the method to search the cheapest and dearest product
			input.nextLine();
			cheapestDearestPro();
			
			
			menuOption = mainMenu();
			break;
			
			
		case 9 :
			
			//If the user selects option "8" from the menu, the program is terminated
			System.exit(0);
			break;
			
}
}
	}
	
	//The main menu interface which provides the user with the different features that can be executed by the system
	     public static int mainMenu() {
	    	 System.out.println("\n");
		System.out.println("---MAIN MENU---");
		System.out.println("1. Print all products");
		System.out.println("2. Add a new supplier");
		System.out.println("3. Add a new product");
		System.out.println("4. Delete a product");
		System.out.println("5. Update product price");
		System.out.println("6. Search for supplier");
		System.out.println("7. Check stock levels");
		System.out.println("8. Cheapest/Dearest product search");
		System.out.println("9. Exit application");
	    

	    boolean validInput = false;
	    while(!validInput)
	    	
	    {
	    	
	    	//prompts user to enter a main menu option
	     System.out.println("Enter your menu choice: ");
	     //Validates the main menu to accept only data of type integer between 1 and 9
	     if (input.hasNextInt()) {
	      
	           int menuOption = input.nextInt(); 
	           if(menuOption >=1 && menuOption <=9)
	        	   
	      {
	      
	        	   validInput=true;
	           return menuOption;
	           
	      } else { 
	    	  
	    	  //provides user with an error message if invalid option was entered into the menu option
	          System.out.println("***Invalid menu option***");
	    		  System.out.println("Please enter an integer between 1 and 9");
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
		
		while (!input.hasNextInt()) {
			input.next();
			System.out.println("**Error** - Please enter an integer");
		}
		int Code = input.nextInt();
		// "input" Allows user to answer the questions prompted to them by the system by inputting relevant data
		
		input.nextLine();
		System.out.println("Supplier Name: ");
		while (!input.hasNext("[a-zA-Z]+")) {
			// this validation ensures that only data of type string can be entered i.e letters between A and Z 
			//takes into consideration the case of the letters entered
			input.next();
			System.out.println("**Error** - Please enter a valid supplier name");
		}
		String supName = input.nextLine();
	
		
		input.nextLine();
		System.out.println("** Please enter the Address of the Supplier: **");
		System.out.println("Building  Number: ");
		while (!input.hasNextInt()) {
			// this validation ensures that the data entered is an integer
			input.next();
			System.out.println("**Error** - Please enter an integer");
			// this provides the user with an error message if the data inputted is of the incorrect format
		}
		int bldNum = input.nextInt();
		//the user can then renter data of the correct type
		
		input.nextLine();
		System.out.println("Street Name: ");
		while (!input.hasNext("[a-zA-Z]+")) {
			input.next();
			System.out.println("**Error** - Please enter a valid Street name");
		}
		String bldStreet = input.nextLine();
		
		
		//input.nextLine();
		System.out.println("Town Name: ");
		while (!input.hasNext("[a-zA-Z]+")) {
			input.next();
			System.out.println("**Error** - Please enter a valid Town name");
		}
		String bldTown = input.nextLine();
		
		input.nextLine();
		System.out.println("Postcode: ");
		String bldPcode = input.nextLine();
		

		
		input.nextLine();
		System.out.println("Country Name: ");
		while (!input.hasNext("[a-zA-Z]+")) {
			input.next();
			System.out.println("**Error** - Please enter a valid country name");
		}
		String bldCountry = input.nextLine();
		
		//initalising the new address
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
			
			//Main Menu option 5 -Updating the product price method
			public static void updateProductPrice(ArrayList<Supplier> allSuppliers, ArrayList<product> allProducts) {
				double updateProPrice = 0;
				System.out.println("Please enter the the name of the supplier whose product price you wish to update: ");
				String updateProSupplier = input.nextLine();
				
				for (Supplier eachSupplier: allSuppliers) {
					
					if (updateProSupplier.equals(eachSupplier.getSupName()));
					{
				
				
			System.out.println("By entering the product code, please state which product from the supplier " + updateProSupplier + " you wish to update: ");
			int proUpdateCode = input.nextInt();
			
			
			for (product myProduct: allProducts) {
				
				if (proUpdateCode == myProduct.getProCode());
				
				{
					System.out.println("What price do you wish to update product " + proUpdateCode + " to?");
					System.out.printf("£%.2f", myProduct.getProPrice());
					System.out.println(")");
					updateProPrice = input.nextDouble();
					myProduct.setProPrice(updateProPrice);
					System.out.println("The price of the product " + proUpdateCode + " has been successfully updated!" );
					myProduct.getProductDetails();
				
			}
				return;
			}
					}
				}
			}
			
			//Main Menu option 8- Method of checking the cheapest and dearest product in the system
			public static void cheapestDearestPro() {
				double[] proPrice = {159.99, 69.99, 99.99, 119.99, 39.99, 59.99};
				double dearest = Integer.MIN_VALUE;
				double cheapest = Integer.MAX_VALUE;
				
				
				for (double num : proPrice)
				{
					//if statement which works out the dearest product
					if (num>dearest)
					{
						dearest = num;
					}
				}
				
				System.out.println("The dearest available product is : " + dearest);
			   
			    for (double num : proPrice)
			    {
			    	//if statement which works out the cheapest product
				    if (num<cheapest)
				{
					cheapest = num;
				}
			}
			
			System.out.println("The cheapest available product is : " + cheapest);
		}
			
			    
			
			
			//Main Menu option 7- checking the stock level method
			public static void checkStockLevels(ArrayList<Supplier> allSuppliers, ArrayList<product> allProducts) {
				
				System.out.println("Please enter the relevent supplier whose stock levels you wish to view: ");
				String proSupplier = input.nextLine();
				
				for (Supplier eachSupplier: allSuppliers) {
					
					if (proSupplier.equals(eachSupplier.getSupName()));
					{
				
				    System.out.println("Please enter the product code of the product whose stock levels you wish to view: ");
				    int productCode = input.nextInt();
				    input.nextLine();
				
				    for (product myProduct: allProducts) 
				    {
						
						if (productCode==myProduct.getProCode())
						{
							
							System.out.println("There are a total of " + myProduct.getProQtyAvailable() + "  available of product " + productCode);
						}
				
			}

			return;
			}
			
				}
				
			}
			
		
			//Main menu Option 4- Deleting a product method
			public static ArrayList<product> deleteProduct(ArrayList<Supplier> allSuppliers, ArrayList<product> allProducts) {
				
				System.out.println("Please enter the name of the supplier who's product you wish to delete");
				String deleteSupplier = input.nextLine();
				
				for (Supplier mySupplier: allSuppliers) {
					if(deleteSupplier.equalsIgnoreCase(mySupplier.getSupName())) {
						System.out.println("Please enter the product code of the product you wish to delete from the system");
						
						int deleteProduct = input.nextInt();
						input.nextLine();
					
					
						if(deleteSupplier.equals(mySupplier.getSupName())) 
						{
								
							for (int i = 0; i < allSuppliers.size(); i++) 
							{
								if(deleteSupplier.equals(allSuppliers.get(i).getSupName())) 
								{
									for (int j = 0; j < allProducts.size(); j++) 
									{
										if(allProducts.get(j).getProCode()==deleteProduct) {
										
											allSuppliers.get(i).getSupProducts().remove(j);
											System.out.println("Product : " + deleteProduct + " has been removed");
											
										}
									}
								}
								
							}
							
							for (int i = 0; i < allSuppliers.size(); i++)
							{
								allSuppliers.get(i).printSupplierDetails();
							
							}
				
						 
						}
				}
				
				
				  
					  }
				return allProducts;
				
			
}



}
	
	
	
	
	
	
	
