package Clothing_Store;

import facade.Facade;




public class Menu {
	
	
	private static Facade facade = new Facade();
	
	
		static void EntryMenu() {
		 int input = -1;
	
		do {
			 
		System.out.println("Please choose among the options below.");
		System.out.println("0. Close system.");
		System.out.println("1. Open item option");
		System.out.println("2. Open reviews option.");
		System.out.println("3. Open transactions option.");
		System.out.println("Type an option number:");
		input =UserInput.readInt("Type an option: ");
		
		} while(input < 0 || input > 3);              
		 System.out.println("Invalid input. Try again!");
		   EntryMenu();
		   
		}     
		
	// changed from private to public 
	    public static void getInput(int input, String itemID, String itemName, double unitPrice, int amount, String reviewComment, int reviewGrade, int reviewNumber) {      
	   
	 	
	    	  
	     if(input==0) {
	      System.exit(0);
			
		
		} else if(input==1) {
			System.out.println("Item options menu:\n" + 
		            "0. Return to Main Menu. \n" +
					"1. Create an Item \n" + 
		            "2. Remove an Item. \n"+ 
					"3. Print all registered Items. \n" +
		            "4. Buy an Item. \n" +    
					"5. Update an item’s name." + 
		            "6. Update an item’s price. \n" +
					"7. Print a specific item \n ");
					input=UserInput.readInt("Type an option number:" );
					
					
			switch(input) {
			
			
			    case 0:
				System.out.println("Return to main menu.");
				break;
		
			    case 1:
				facade.createItem(itemID, itemName,unitPrice); 
				//Created parameters
				break;
			    case 2: 
			    facade.removeItem(itemID);
			    break;
			    case 3:
			    facade.printItem(itemID);
			    break;
			    case 4:
			    facade. containsItem(itemID);
			    break;
			    case 5:
			    facade.buyItem(itemID, amount);
			    break;
			    //case 6:
			    	//to be finished(epic5)
			}
		    
			    }else if(input==2) {
			    	System.out.println("reviews options menu:\n" + 
				            "0. Return to Main Menu. \n" +
							"1. Create a review for an item \n" + 
				            "2. Print a specific review of an item. \n"+ 
							"3. print all reviews of an item \n" +
				            "4. print mean grade of an item \n" +    
							"5. Print all comments of an item" + 
				            "6. Print all registered reviews \n" +
			    	        "7.Print item(s) with most reviews" +
				            "8.Print item(s) with least reviews" +
			    	        "9. Print item(s) with best mean review grade" +
				            "10. print item(s) with worst mean review grade");
							input=UserInput.readInt("Type an option number:" );
							
			  
			    		switch(input) {
			    		case 0:
							System.out.println("Return to main menu.");
							break;
			    		case 1:
			    			facade.reviewItem(reviewComment, reviewGrade);
			    			break;
			    		case 2:
			    			facade.getPrintedItemReview(itemID, reviewNumber); 
			    			break;
			    		case 3:
			    			facade.getPrintedReviews(itemID);
			    			break;
			    		case 4: 
			    			facade.getItemMeanGrade(itemID);  
			    			break;
			    		case 5:
			    			facade.getItemCommentsPrinted(itemID);
			    			break;
			    		case 6:
			    			facade.getPrintedReviews(itemID);
			    			break;
			    		case 7:
			    			facade.printMostReviewedItems();
			    			break;
			    		case 8:
			    			facade.printLeastReviewedItems();
			    			break;
			    		case 9:
			    			facade.printBestReviewedItems();
			    			break;
			    		case 10:
			    			facade.getWorseReviewedItems();
			    			break;
			    		}
		
			    }else if(input==3) {
			    	System.out.println("Transaction history options menu:\n" + 
				            "0. Return to Main Menu. \n" +
							"1. Print total profit from all item purshases \n" + 
				            "2. Print total units sold from all item purshases \n"+ 
							"3. Print the total number of item transactions made \n" +
				            "4. Print all transactions made \n" +    
							"5. Print the total profit of a specific item. \n" + 
				            "6. Print the number of units sold of a specific item. \n" +
			    	        "7.Print all transactions of a specific item. \n" +
				            "8.Print item with highest profit. \n");
			    	    
			             input=UserInput.readInt("Type an option number:" );
			    	      
			              switch(input) {
			              
			              
			    	      case 0:
			    		  System.out.println("Return to main menu.");
						  break;
						  
			    	      case 1:
			    	    	  facade.getTotalProfit();
				    			break;
				    		case 2:
				    			facade.getTotalUnitsSold();
				    			break;
				    		case 3:
				    			facade.getTotalTransactions();
				    			break;
				    		case 4: 
				    			facade.printAllTransactions();  
				    			break;
				    		case 5:
				    			facade.getProfit(itemID);
				    			break;
				    		case 6:
				    			facade.getUnitsSolds(itemID);
				    			break;
				    		case 7:
				    			facade.printAllTransactions();
				    			break;
				    		case 8:
				    			facade.printMostProfitableItems(); //Not sure if its the right method used here 
				    			break;
				    		
			    		
	}
							
					
	  } 
	}
		
	}
	     
	
	

