package Items;

public class item {
String itemID;
String name;
double value;
String review;

public item(String itemID, String name , double value, String review) {
    this.itemID = itemID;
    this.name = name;
    this.value = value;
    this.review = review;
}
    
	public String toString() {
	return itemID + ","	 + name + "," + value + "SEK";
	}
	
	
}
