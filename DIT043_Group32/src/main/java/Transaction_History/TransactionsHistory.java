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
    public String PrintAllItemTransactions(String itemID){
        String itemName = "";
        double unitPrice = 0;
       ItemCtrl itemAccess = new ItemCtrl();
        //Extracts an itemName and unitPrice from the list of registered items
            for ( String itemInfo : itemAccess.itemList)
        {
            if (itemInfo.contains(itemID))
            {
                //This itemID is registered
                int begin = itemInfo.indexOf(":");
                int end = itemInfo.indexOf(("."));
                itemName = itemInfo.substring(begin,end);

                int index = itemInfo.indexOf(".");
                unitPrice = Double.parseDouble(itemInfo.substring(index));
                break;
            }
            else
            {
                //This itemID is not registered
                return "Item <ID> was not registered yet.";
            }
        }
        String output = "";
        output += "Transactions for item: " + itemID + " : " + itemName + ". " + unitPrice + "SEK\n";
        for (Transaction transaction : historyList)
        {
            if (transaction.itemID == itemID)
                output += itemID + " : " + transaction.amount + " item(s). " + transaction.totalPrice + "SEK\n";
            else
            {
                output = "Transactions for item: <item ID>: <item name>. <unit price> SEK\n" +
                        "No transactions have been registered for item <item ID> yet.\n";
            }
        }
        return  output;
    }
}
