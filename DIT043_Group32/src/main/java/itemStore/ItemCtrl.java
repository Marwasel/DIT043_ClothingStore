package itemStore;
import java.util.ArrayList;


public class ItemCtrl {


	public static ArrayList<Item> itemList = new ArrayList<Item>();

		public static String createItem (String itemID, String itemName, double unitPrice) {
			if (itemID.isEmpty() || itemName.isEmpty() || unitPrice <= 0) {
				System.out.println("Invalid data for item.");
			} else {
				Item item = new Item(itemID, itemName, unitPrice);
				itemList.add(item);

			}

			return itemID;
		}

		public static String removeItem (String itemID){

			return "";
		}
	}

