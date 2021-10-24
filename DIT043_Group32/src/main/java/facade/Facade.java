package facade;

import ItemReviews.ReviewCtrl;
import itemStore.Item;
import itemStore.ItemCtrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Transaction_History.TransactionsHistory;

public class Facade {

    public Facade() {

    }

    ItemCtrl itemCtrlAccess = new ItemCtrl();
    ReviewCtrl reviewCtrlAccess = new ReviewCtrl();

    TransactionsHistory history = new TransactionsHistory();

    // ItemCtrl Related Methods
    public String createItem(String itemID, String itemName, double unitPrice){
        return itemCtrlAccess.createItem(itemID, itemName, unitPrice);
    }

    public String printItem(String itemID) {
        return itemCtrlAccess.printItem(itemID);
    }

    public String removeItem(String itemID) {
        return itemCtrlAccess.removeItem(itemID);
    }

    public boolean containsItem(String itemID) {
        return itemCtrlAccess.containsItem(itemID);
    }

    public double buyItem(String itemID, int amount) {
        return itemCtrlAccess.buyItem(itemID, amount);
    }

    public String updateItemName(String itemID, String newName) {
        return itemCtrlAccess.updateItemName(itemID, newName);
    }

    public String updateItemPrice(String itemID, double newPrice) {
        return itemCtrlAccess.updateItemPrice(itemID, newPrice);
    }

    public String printAllItems() {
        return itemCtrlAccess.printAllItems();
    }


    // ReviewCtrl related Methods
    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
//       if (itemCtrlAccess.containsItem(itemID)){
//           return "Item " + itemID + " was not registered yet.";
//        }
        return reviewCtrlAccess.reviewItem(itemID, reviewComment, reviewGrade);
    }

    public String reviewItem(String itemID, int reviewGrade) {
//        if (itemCtrlAccess.containsItem(itemID)){
//            return "Item " + itemID + " was not registered yet.";
//        }
        return reviewCtrlAccess.reviewItem(itemID,"", reviewGrade);
    }

    public List<String> getItemComments(String itemID) {
        return reviewCtrlAccess.getItemComments(itemID);
    }

    public String getItemCommentsPrinted(String itemID) {
        if (itemCtrlAccess.getItemListSize()==0) {
            return "No items registered yet.";
        }
        if (reviewCtrlAccess.getItemsReviewsSize() == 0) {
            return "No items were reviewed yet.";
        }

        String data = "All registered reviews:\n" +
                "------------------------------------\n";

        // Iterate over the items
        for(Item item: itemCtrlAccess.itemList){
            data += item.toString()+"\n" +
                    "------------------------------------\n";

            // Get all comments related to the item
            List<String> comments = getItemComments(item.getItemID());
            for (String comment: comments){
                data += comment + "\n" +
                        "------------------------------------\n";
            }
        }
        return data;
    }

    public double getItemMeanGrade(String itemID) {

        if (itemCtrlAccess.containsItem(itemID)){
            System.out.println("Item " + itemID + " was not registered yet.");
        }
        return reviewCtrlAccess.getItemMeanGrade(itemID);
    }

    public int getNumberOfReviews(String itemID) {
        if (itemCtrlAccess.containsItem(itemID)){
            System.out.println("Item " + itemID + " was not registered yet.");
        }
        return reviewCtrlAccess.getNumberOfReviews(itemID);
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        if (!itemCtrlAccess.containsItem(itemID)){
            return "Item " + itemID + " was not registered yet.";
        }
        return reviewCtrlAccess.getPrintedItemReview(itemID, reviewNumber);
    }

    public String getPrintedReviews(String itemID) {
        if (!itemCtrlAccess.containsItem(itemID)){
            return "Item " + itemID + " was not registered yet.";
        }

        Item item = itemCtrlAccess.findItem(itemID);

        String data = item.toString() + "\n";

        data += reviewCtrlAccess.getPrintedReviews(itemID);
        return data;
    }

    public List<String> getMostReviewedItems() {
        List<String> data = new ArrayList<String>();
        List<String> topItemsID = reviewCtrlAccess.getMostReviewedItemID();

        for(String itemID: topItemsID){
            Item item = itemCtrlAccess.findItem(itemID);
            data.add(itemID.toString());
        }

        return data;
    }

    public List<String> getLeastReviewedItems() {
        List<String> data = new ArrayList<String>();
        List<String> leastItemsID = reviewCtrlAccess.getLeastReviewedItemID();

        for(String itemID: leastItemsID){
            Item item = itemCtrlAccess.findItem(itemID);
            data.add(itemID.toString());
        }
        return data;
    }

    public String printMostReviewedItems() {
        if (itemCtrlAccess.getItemListSize()==0) {
            return "No items registered yet.";
        }
        if (reviewCtrlAccess.getItemsReviewsSize() == 0) {
            return "No items were reviewed yet.";
        }
        double maxReviewsByItem = reviewCtrlAccess.maxReviewsByItem;

        String data = "Most reviews: " + maxReviewsByItem +  " review(s) each.\n";

        for (String item: getMostReviewedItems()) {
            data += item + "\n";
        }
        return data;
    }

    public String printLeastReviewedItems() {
        if (itemCtrlAccess.getItemListSize()==0) {
            return "No items registered yet.";
        }
        if (reviewCtrlAccess.getItemsReviewsSize() == 0) {
            return "No items were reviewed yet.";
        }
        int leastReviewsByItem = reviewCtrlAccess.leastReviewsByItem;

        String data = "Least reviews: " + leastReviewsByItem +  " review(s) each.\n";

        for (String item: getLeastReviewedItems()) {
            data += item + "\n";
        }
        return data;
    }


    public double getTotalProfit() {
        return -1.0;
    }

    public String printItemTransactions(String itemID) {
        String output = history.PrintAllItemTransactions(itemID, itemCtrlAccess);
        System.out.print(output);
        return "";
    }

    public int getTotalUnitsSold() {
        return history.UnitsSum();
    }

    public int getTotalTransactions() {
        return history.TotalTransactions();
    }

    public double getProfit(String itemID) {
        return history.ProfitSum(itemID);
    }

    public int getUnitsSolds(String itemID) {
        return -1;
    }

    public String printAllTransactions() {
        return "";
    }

    public String printWorseReviewedItems() {
        return "";
    }

    public String printBestReviewedItems() {
        return "";
    }

    public List<String> getWorseReviewedItems() {

        return reviewCtrlAccess.getWorseReviewedItems();
    }

    public List<String> getBestReviewedItems() {

       // return new ArrayList<String>();
        return reviewCtrlAccess.getBestReviewedItems();
    }

    public String printAllReviews() {


        return reviewCtrlAccess.printAllReviews();
    }

    public String printMostProfitableItems() {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        return "";
    }

    public String printEmployee(String employeeID) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        return "";
    }

    public double getNetSalary(String employeeID) throws Exception {
        return -1.0;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        return "";
    }

    public String removeEmployee(String empID) throws Exception {
        return "";
    }

    public String printAllEmployees() throws Exception {
        return "";
    }

    public double getTotalNetSalary() throws Exception {
        return -1.0;
    }

    public String printSortedEmployees() throws Exception {
        return "";
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        return "";
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        return "";
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        return "";
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        return "";
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        return "";
    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        return null;
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        return "";

    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        return "";
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        return "";
    }
}
