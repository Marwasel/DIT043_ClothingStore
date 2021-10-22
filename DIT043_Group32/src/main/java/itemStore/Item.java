package itemStore;



public class Item {

String itemID;
 String itemName;
 double unitPrice ;
 int amount;


Item item = new Item(itemID, itemName, unitPrice);
Item items = new Item(itemID, itemName, unitPrice, amount);

public Item(String itemID, String itemName , double unitPrice, int amount) {
    this.itemID = itemID;
    this.itemName = itemName;
    this.unitPrice = unitPrice;
    this.amount = amount;
}
    public Item(String itemID, String itemName, double unitPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }


    String getItemID(){
return itemID;
}

void setItemID(){
  this.itemID = itemID;
}


String getItemName() {
  return itemName;
}

void setItemName(){
this.itemName = itemName;
}

double getUnitPrice() {
    return unitPrice;
}
void setUnitPrice() {
    this.unitPrice = unitPrice;
}


@Override
    public String toString() {

    return itemID + ","	 + itemName + "," + unitPrice + "SEK";
	}



}
