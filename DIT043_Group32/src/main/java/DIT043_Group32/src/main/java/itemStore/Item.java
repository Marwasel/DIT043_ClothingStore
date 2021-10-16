package itemStore;



public class Item {

private String itemID;
private String name;
private double unitPrice ;


public Item(String itemID, String name , double unitPrice) {
    this.itemID = itemID;
    this.name = name;
    this.unitPrice = unitPrice;
}


String getItemID(){
    return itemID;
}
void setItemID(){
    this.itemID = itemID;
}

String getName() {
    return name;
}
void setName(){
    this.name = name;
}
double getUnitPrice() {
    return unitPrice;
}
void setUnitPrice() {
    this.unitPrice = unitPrice;
}


@Override
    public String toString() {

    return itemID + ","	 + name + "," + unitPrice + "SEK";
	}



}
