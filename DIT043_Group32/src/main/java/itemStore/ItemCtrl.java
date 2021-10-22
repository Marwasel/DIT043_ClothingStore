package itemStore;
import java.util.ArrayList;

public class ItemCtrl {

	Item itemAccess = new Item();



	public ArrayList<Item> itemList = new ArrayList<Item>();

		public String createItem (String itemID, String itemName, double unitPrice) {
			if (itemID.isEmpty() || itemName.isEmpty() || unitPrice <= 0.0) {
				System.out.println("Invalid data for item.");
			} else {
				Item item = new Item(itemID, itemName, unitPrice);
				itemList.add(item);

			}

			return "Item ID" + itemID + "was registered successfully ";
		}

		public String removeItem (String itemID){

			return "";
		}
	}

