package Transactions;

public class transactions {
String itemID;
double value;
int amount;

public transactions(String itemID, int amount , double value) {
    this.itemID = itemID;
    this.amount = amount;
    this.value = value;
}


  public transactions(){
    //Empty Constructor to get access to the class
   }


}
