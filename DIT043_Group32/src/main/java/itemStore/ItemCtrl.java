package itemStore;
import java.util.ArrayList;
import java.util.Objects;

public class ItemCtrl {


	public ArrayList<Item> itemList = new ArrayList<Item>();


	public int getItemListSize() {

		return itemList.size();
	}

	public String createItem(String itemID, String itemName, double unitPrice) {
		Item itemAccess = findItem(itemID);

		if (!Objects.isNull(itemAccess) || itemID.isEmpty() || itemName.isEmpty() || unitPrice <= 0.0) {
			return "Invalid data for item.";
		}
		Item item = new Item(itemID, itemName, unitPrice);
		itemList.add(item);

		return "Item " + itemID + " was registered successfully.";
	}

	public Item findItem(String itemID) {
		Item itemAccess = null;
		for (Item item : itemList) {
			if (item.getItemID().equals(itemID)) {
				itemAccess = item;
			}
		}
		return itemAccess;
	}

	public String updateItemName(String itemID, String itemName) {
		Item itemAccess = findItem(itemID);

		if (Objects.isNull(itemAccess)) {
			return "Item " + itemID + " was not registered yet.";
		}
		if (itemID.isEmpty() || itemName.isEmpty()) {
			return "Invalid data for item.";
		}
		itemAccess.setItemName(itemName);
		return "Item " + itemID + " was updated successfully.";
	}

	public String updateItemPrice(String itemID, double unitPrice) {
		Item itemAccess = findItem(itemID);

		if (Objects.isNull(itemAccess)) {
			return "Item " + itemID + " was not registered yet.";
		}
		if (itemID.isEmpty() || unitPrice <= 0.0) {
			return "Invalid data for item.";
		}

		itemAccess.setUnitPrice(unitPrice);
		return "Item " + itemID + " was updated successfully.";
	}

}