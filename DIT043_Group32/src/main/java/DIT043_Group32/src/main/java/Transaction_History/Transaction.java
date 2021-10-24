package Transaction_History;

import itemStore.Item;

public class Transaction {

    Item myItem;

    String itemID;
    public int amount;
    public double totalPrice;

    public Transaction(Item item, TransactionsHistory history)
    {
        myItem = item;
        itemID = item.getItemID();
        amount = item.amount;
        totalPrice = item.unitPrice * amount;

        history.historyList.add(this);

    }

  public Transaction(){
    //Empty Constructor to get access to the class
   }


}
