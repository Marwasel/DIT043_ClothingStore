package itemStore;
import facade.Facade;
import java.util.HashMap;


public class ItemCtrl {


	public static HashMap<String, Item> itemList = new HashMap<String, Item>();

	public static String createItem(String itemID, String itemName, double unitPrice) {


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

