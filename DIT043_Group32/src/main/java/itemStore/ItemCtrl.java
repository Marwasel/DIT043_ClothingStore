package itemStore;



import Clothing_Store.UserInput;

import java.util.HashMap;
import facade.Facade;

public class ItemCtrl {



	public static void createItem(){


		HashMap<String, Item> list = new HashMap<String, Item>();
		{

			String itemID = UserInput.readLine("Type the item's ID: ");
			String itemName = UserInput.readLine("Type the item's name: ");
			double unitPrice = UserInput.readDouble("Type the item's price per unit: ");

			Item item = new Item(itemID, itemName, unitPrice);
			list.put(itemID, item);

			Facade.createItem(itemID, itemName, unitPrice);
		}

	}
}
