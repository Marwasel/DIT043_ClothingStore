package itemStore;
import java.util.ArrayList;

public class ItemCtrl {

	Item itemAccess = new Item();


//When testing, although the item was registered successfully, the "Actual" appears empty.
	public ArrayList<String> itemList = new ArrayList<String>();

		public String createItem (String itemID, String itemName, double unitPrice) {

			if (itemID.isEmpty() || itemName.isEmpty() || unitPrice <= 0.0) {
				System.out.println("Invalid data for item.");
			} else {
				Item item = new Item(itemID, itemName, unitPrice);
				itemList.add(item + ":" + itemName + "." + unitPrice);

                System.out.println("Item " + itemID + " was registered successfully.");
			}

			return "Item " + itemID + " was registered successfully.";
		}

		public String removeItem (String itemID){

			return "";
		}
	}

