package itemStore;


import java.util.ArrayList;

public class Item {

 public ArrayList<Item> itemList = new ArrayList<Item>();

  String itemID;
 public String itemName;
 public double unitPrice ;
 public int amount;


//Item item = new Item(itemID, itemName, unitPrice);


    public Item(String itemID, String itemName, double unitPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.amount = 0;
    }

    public Item(){
        //Empty Constructor to get access to the class.
    }



 public String getItemID(){
  return itemID;
}

public void setItemID(){

 this.itemID = itemID;
}


public String getItemName() {
   return itemName;
}

public void setItemName() {

    this.itemName = itemName;
}

public double getUnitPrice() {
   return unitPrice;
}

 public void setUnitPrice() {
   this.unitPrice = unitPrice;
}


@Override
    public String toString() {

    return itemID + ":"	 + itemName + "." + unitPrice + "SEK";
	}



}
