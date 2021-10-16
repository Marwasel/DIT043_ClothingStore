package itemStore;
import facade.Facade;
import java.util.HashMap;


public class ItemCtrl {

	public static HashMap<String, Item> itemList = new HashMap<String, Item>();

	 //Constructor
	 public ItemCtrl(String itemID, String itemName, double unitPrice){
	 }
        //Creating objects
		ItemCtrl Item1 = new ItemCtrl("ID1", "Black T-shirt", 150.99);
		ItemCtrl Item2 = new ItemCtrl("ID2", "Blue T-shirt", 100.00);


		public static String createItem (String itemID, String itemName,double unitPrice){


			if (itemID.isEmpty() || itemName.isEmpty() || unitPrice <= 0) {
				System.out.println("Invalid data for item.");
			} else {
				Item item = new Item(itemID, itemName, unitPrice);
				itemList.put(itemID, item);

			}

			Facade.createItem(itemID, itemName, unitPrice);

			return itemID;
		}

		public String removeItem (String itemID){

			return "";
		}
	}

