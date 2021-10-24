package Transaction_History;

import java.util.List;
import Clothing_Store.UserInput;
import itemStore.Item;
import itemStore.ItemCtrl;

public class TransactionsHistory {
    List<Transaction> historyList;

    public TransactionsHistory(){

    }

    //sum of all profit made from a specific item
    public double ProfitSum(String itemID)
    {
        double totalSum = 0;

        for (Transaction transaction : historyList)
        {
            if(transaction.itemID == itemID)
                totalSum += transaction.totalPrice;
        }
        return totalSum;
    }

    //retrieves the sum of all units sold of a specific item
    public int UnitsSum()
    {
        String itemID;
        itemID = UserInput.readLine("Type the itemID of the item you want to check:");
        int unitsSum = 0;

        for (Transaction transaction : historyList)
        {
            if(transaction.itemID == itemID)
                unitsSum += transaction.amount;
        }
        return unitsSum;
    }

    //retrieves the total number of transactions for a specific item
    public int TotalTransactions()
    {
        String itemID;
        itemID = UserInput.readLine("Type the itemID of the item that you want to check:");
        int totalTransactions = 0;

        for (Transaction transaction : historyList)
        {
            if(transaction.itemID == itemID)
                totalTransactions++;
        }
        return totalTransactions;
    }

    //Prints all transactions of a specific item
    public String PrintAllItemTransactions(String itemID, ItemCtrl items){

        boolean transactionExists = false;
        boolean idExists = false;
        Item Myitem = null;

        for ( Item item : items.itemList)
        {
            if (item.getItemID() == itemID)
            {
                Myitem = item;
                idExists = true;

            }
        }
        if(!idExists){
            //This itemID is not registered
            return "Item " + itemID + " was not registered yet.";
        }
        String output = "";
        output += "Transactions for item: " + itemID + " : " + Myitem.itemName + ". " + Myitem.unitPrice + "SEK\n";
        for (Transaction transaction : historyList)
        {
            if (transaction.itemID == itemID)
            {
                output += itemID + " : " + transaction.amount + " item(s). " + transaction.totalPrice + "SEK\n";
                transactionExists = true;
            }

        }
        if (!transactionExists)
        {
            output = "Transactions for item: " + itemID + " : " + Myitem.itemName + "." + Myitem.unitPrice + " SEK\n" +
                    "No transactions have been registered for item " + itemID + " yet.\n";
        }
        return  output;
    }
}
