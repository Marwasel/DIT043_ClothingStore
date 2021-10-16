package Clothing_Store;


import ItemReviews.ReviewCtrl;
import itemStore.ItemCtrl;


public class Menu {


	public static void main(String[] args) {
		entryMenu();
	}


	public static void entryMenu() {
		int input = -1;

		do {

			System.out.println("Please choose among the options below.");
			System.out.println("0. Close system.");
			System.out.println("1. Open item option");
			System.out.println("2. Open reviews option.");
			System.out.println("3. Open transactions option.");
			System.out.println("Type an option number:");

			input = UserInput.readInt("Type an option: ");

			switch (input) {
				case 0:
					System.exit(0);
					break;
				case 1:
					openItemOptions();
					break;
				case 2:
					openReviewOptions();
					break;
				case 3:
					openTransactionOptions();
					break;
				default:
					System.out.println("Invalid input. Try again!");
					break;
			}
		} while (input < 0 || input > 3);
	}


	static void openItemOptions() {
		int input;

		do {
			System.out.println("Item options menu:\n" +
					"0. Return to Main Menu. \n" +
					"1. Create an Item \n" +
					"2. Remove an Item. \n" +
					"3. Print all registered Items. \n" +
					"4. Buy an Item. \n" +
					"5. Update an item’s name. \n" +
					"6. Update an item’s price. \n" +
					"7. Print a specific item \n ");

			input = UserInput.readInt("Type an option number:");

			switch (input) {

				case 0:
					System.out.println("Return to main menu.");
					break;
				case 1:
					String itemID = UserInput.readLine("Type the item's ID: ");
					String itemName = UserInput.readLine("Type the item's name: ");
					double unitPrice = UserInput.readDouble("Type the item's price per unit: ");
					ItemCtrl.createItem(itemID, itemName, unitPrice);
					break;
				case 2:
					String removeId = UserInput.readLine("type the item ID you want to remove: ");
					ItemCtrl.removeItem(itemID);
					break;
				case 3:
					ItemCtrl.printAllItems();
					break;
				case 4:
					ItemCtrl.buyItem(itemID, amount);
					break;
				case 5:
					ItemCtrl.updateItemName(itemID, newName);
					break;
				case 6:
					ItemCtrl.updateItemPrice(itemID, newPrice);
					break;
				case 7:
					ItemCtrl.printItem(itemID);
					break;
				default:
					System.out.println("Invalid input. Try again!");
					break;
			}
		} while (input < 0 || input > 7);
	}

	static void openReviewOptions() {
		int input;
		do {
			System.out.println("reviews options menu:\n" +
					"0. Return to Main Menu. \n" +
					"1. Create a review for an item \n" +
					"2. Print a specific review of an item. \n" +
					"3. print all reviews of an item \n" +
					"4. print mean grade of an item \n" +
					"5. Print all comments of an item" +
					"6. Print all registered reviews \n" +
					"7.Print item(s) with most reviews" +
					"8.Print item(s) with least reviews" +
					"9. Print item(s) with best mean review grade" +
					"10. print item(s) with worst mean review grade");

			input = UserInput.readInt("Type an option number:");

			switch (input) {
				case 0:
					System.out.println("Return to main menu.");
					break;
				case 1:
					String itemID = UserInput.readLine("Enter the item's id: ");
					String reviewComment = UserInput.readLine("Add a comment:");
					int reviewGrade = UserInput.readInt("Grade values must be between 1 and 5.");

					ReviewCtrl.reviewItem(itemID, reviewComment, reviewGrade);
					break;
				case 2:
					ReviewCtrl.getPrintedItemReview(itemID, reviewNumber);
					break;
				case 3:
					ReviewCtrl.getPrintedReviews(itemID);
					break;
				case 4:
					ReviewCtrl.getItemMeanGrade(itemID);
					break;
				case 5:
					ReviewCtrl.getItemCommentsPrinted(itemID);
					break;
				case 6:
					ReviewCtrl.printAllReviews();
					break;
				case 7:
					ReviewCtrl.printMostReviewedItems();
					break;
				case 8:
					ReviewCtrl.printLeastReviewedItems();
					break;
				case 9:
					ReviewCtrl.printBestReviewedItems();
					break;
				case 10:
					ReviewCtrl.getWorseReviewedItems();
					break;
				default:
					System.out.println("Invalid input. Try again!");
					break;
			}
		} while (input < 0 || input > 10);
	}

	static void openTransactionOptions() {
		int input;
		do {
			System.out.println("Transaction history options menu:\n" +
					"0. Return to Main Menu. \n" +
					"1. Print total profit from all item purshases \n" +
					"2. Print total units sold from all item purshases \n" +
					"3. Print the total number of item transactions made \n" +
					"4. Print all transactions made \n" +
					"5. Print the total profit of a specific item. \n" +
					"6. Print the number of units sold of a specific item. \n" +
					"7.Print all transactions of a specific item. \n" +
					"8.Print item with highest profit. \n");

			input = UserInput.readInt("Type an option number:");

			switch (input) {

				case 0:
					System.out.println("Return to main menu.");
					break;

				case 1:
					TransactionCtrl.getTotalProfit();
					break;
				case 2:
					TransactionCtrl.getTotalUnitsSold();
					break;
				case 3:
					TransactionCtrl.getTotalTransactions();
					break;
				case 4:
					TransactionCtrl.printAllTransactions();
					break;
				case 5:
					TransactionCtrl.getProfit(itemID);
					break;
				case 6:
					TransactionCtrl.getUnitsSolds(itemID);
					break;
				case 7:
					TransactionCtrl.printItemTransactions(itemID);
					break;
				case 8:
					TransactionCtrl.printMostProfitableItems();
					break;
				default:
					System.out.println("Invalid input. Try again!");
					break;
			}
		} while (input < 0 || input > 8);
	}
}








	

