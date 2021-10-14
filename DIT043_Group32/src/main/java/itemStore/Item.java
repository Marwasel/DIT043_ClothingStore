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
    


	public String toString() {
	return itemID + ","	 + name + "," + unitPrice + "SEK";
	}
	

}
