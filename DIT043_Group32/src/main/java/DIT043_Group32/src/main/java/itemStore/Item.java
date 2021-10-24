package itemStore;


//import java.util.ArrayList;

public class Item {

//     public ArrayList<Item> itemList = new ArrayList<Item>();

    String itemID;
    public String itemName;
    public double unitPrice ;
    public int amount;

    public Item(String itemID, String itemName, double unitPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }
    public Item(String itemID, String itemName, double unitPrice, int amount) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.amount = amount;

    }
    public Item(){
        //Empty Constructor to get access to the class.
    }

    public String getItemID(){
        return itemID;
    }
    //public void setItemID(itemID){this.itemID = itemID;}

    // ItemName
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) { this.itemName = itemName;}

    //unitPrice
    public double getUnitPrice() { return unitPrice;}
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        // Truncate Unit Price
        String unitPrice = (String) String.format("%.2f", this.unitPrice);
        return this.itemID + ": " + this.itemName + ". " + unitPrice + " SEK";
    }
}
