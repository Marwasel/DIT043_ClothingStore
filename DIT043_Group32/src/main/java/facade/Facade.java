package facade;

import ItemReviews.ReviewCtrl;
import Transaction_History.TransactionsHistory;
import itemStore.Item;
import itemStore.ItemCtrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
        if (!itemCtrlAccess.containsItem(itemID)){
            return "Item " + itemID + " was not registered yet.";
        }
        return reviewCtrlAccess.reviewItem(itemID, reviewComment, reviewGrade);
    }

    public String reviewItem(String itemID, int reviewGrade) {
        if (!itemCtrlAccess.containsItem(itemID)){
            return "Item " + itemID + " was not registered yet.";
        }
        return reviewCtrlAccess.reviewItem(itemID,"", reviewGrade);
    }

    public List<String> getItemComments(String itemID) {
        return reviewCtrlAccess.getItemComments(itemID);
    }

    public String getItemCommentsPrinted(String itemID) {
//        if (itemCtrlAccess.getItemListSize()==0) {
//            return "No items registered yet.";
//        }
        if (reviewCtrlAccess.getItemsReviewsSize() == 0) {
            return "No items were reviewed yet.";
        }

        String data = "All registered reviews:\n" +
                "------------------------------------\n";


        // Iterate over the items with reviews
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
        return reviewCtrlAccess.getItemMeanGrade(itemID);
    }

    public int getNumberOfReviews(String itemID) {
        return reviewCtrlAccess.getNumberOfReviews(itemID);
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        if (!itemCtrlAccess.containsItem(itemID)){
            return "Item " + itemID + " was not registered yet.";
        }
        // Get Item
        Item item = itemCtrlAccess.findItem(itemID);

        if (!reviewCtrlAccess.hasReviewsForItemID(itemID)){
            return "Item " + item.getItemName() + " has not been reviewed yet.";
        }

        return reviewCtrlAccess.getPrintedItemReview(itemID, reviewNumber);
    }

    public String getPrintedReviews(String itemID) {
        if (!itemCtrlAccess.containsItem(itemID)){
            return "Item " + itemID + " was not registered yet.";
        }
        // Get Item
        Item item = itemCtrlAccess.findItem(itemID);
        String data = "Review(s) for " + item.toString() + "\n";

        if (!reviewCtrlAccess.hasReviewsForItemID(itemID)){
            data += "The item " + item.getItemName() + " has not been reviewed yet.";
            return data;
        }

        // Get Item Reviews
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

        List<String> mostItems = getMostReviewedItems();
        int maxReviewsByItem = reviewCtrlAccess.maxReviewsByItem;

        String data = "Most reviews: " + maxReviewsByItem +  " review(s) each.\n";

        for (String itemID: mostItems) {
            data += itemCtrlAccess.findItem(itemID).toString() +"\n";
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

        List<String> leastItems = getLeastReviewedItems();
        int leastReviewsByItem = reviewCtrlAccess.leastReviewsByItem;
        String data = "Least reviews: " + leastReviewsByItem +  " review(s) each.\n";

        for (String itemID: leastItems) {
            data += itemCtrlAccess.findItem(itemID).toString() +"\n";
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
        if (itemCtrlAccess.getItemListSize()==0) {
            return "No items registered yet.";
        }
        if (reviewCtrlAccess.getItemsReviewsSize() == 0) {
            return "No items were reviewed yet.";
        }

        String data = "Items with worst mean reviews:\n";
        List<String> itemIDs = getWorseReviewedItems();

        data += "Grade: " + reviewCtrlAccess.worstReviewsByItem +"\n";

        for (String itemID: itemIDs){
            data += itemCtrlAccess.findItem(itemID).toString() + "\n";
        }

        return data;
    }

    public String printBestReviewedItems() {
        if (itemCtrlAccess.getItemListSize()==0) {
            return "No items registered yet.";
        }
        if (reviewCtrlAccess.getItemsReviewsSize() == 0) {
            return "No items were reviewed yet.";
        }
        String data = "Items with best mean reviews:\n";
        List<String> itemIDs = getBestReviewedItems();

        data += "Grade: " + reviewCtrlAccess.bestReviewsByItem + "\n";

        for (String itemID: itemIDs){
            data += itemCtrlAccess.findItem(itemID).toString() + "\n";
        }

        return data;
    }

    public List<String> getWorseReviewedItems() {
        return reviewCtrlAccess.getWorstReviewedItems();
    }

    public List<String> getBestReviewedItems() {
        return reviewCtrlAccess.getBestReviewedItems();
    }

    public String printAllReviews() {
        if (itemCtrlAccess.getItemListSize()==0) {
            return "No items registered yet.";
        }
        if (reviewCtrlAccess.getItemsReviewsSize() == 0) {
            return "No items were reviewed yet.";
        }

        String data = "All registered reviews:\n" +
                "------------------------------------\n";

        // Iterate over the items with reviews
        for(String itemID: reviewCtrlAccess.getAllRegisteredItems()){
            // get Item
            Item item = itemCtrlAccess.findItem(itemID);
            data += "Review(s) for " + item.toString() + "\n";
            // get reviews
            data += reviewCtrlAccess.getPrintedReviews(itemID) +
                    "------------------------------------\n";
        }
        return data;
    }



    public String printMostProfitableItems() {
        return"";
    }



      public String createEmployee(String EmpID, String EmpName, double GrossSalary) throws Exception {
        GrossSalary = Math.round(GrossSalary*100.0)/100.0;
        double NetSalary_unround = GrossSalary-0.1*GrossSalary;
        double NetSalary = Math.round(NetSalary_unround*100)/100;

            String createResult="";
            if (EmpID.isEmpty() || EmpName.isEmpty() || GrossSalary <= 0) {
                createResult= "Invalid data for item.";
            } else {
                EmpReg emp = new EmpReg(EmpID, EmpName, GrossSalary,NetSalary);
                EmpRegList.add(emp);

                createResult="Employee "+EmpID+" was registered successfully.";

            }
            return createResult;


    }

    public String printEmployee(String employeeID) {
        String messageToPrint="";
        EmpReg EmpRegToPrint=null;
        EmpDir EmpDirToPrint=null;
        EmpMan EmpManToPrint=null;
        EmpInt EmpIntToPrint=null;
        for(EmpReg currentEmp: EmpRegList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpRegToPrint=currentEmp;
            }
        }

        for(EmpDir currentEmp: EmpDirList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpDirToPrint=currentEmp;
            }
        }
        for(EmpMan currentEmp: EmpManList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpManToPrint=currentEmp;
            }
        }
        for(EmpInt currentEmp: EmpIntList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpIntToPrint=currentEmp;
            }
        }

        if(EmpRegToPrint == null && EmpDirToPrint == null && EmpManToPrint == null && EmpIntToPrint == null){
            messageToPrint= "Employee " +employeeID+ " was not registered yet.";
        }else if(EmpRegToPrint != null){
            messageToPrint=EmpRegToPrint.toString();
        }else if(EmpManToPrint != null){
            messageToPrint=EmpManToPrint.toString();
        }else if(EmpDirToPrint != null){
            messageToPrint=EmpDirToPrint.toString();
        }else if(EmpIntToPrint != null){
            messageToPrint=EmpIntToPrint.toString();
        }
        return messageToPrint;
    }

    public String createEmployee(String employeeID, String employeeName, double GrossSalary, String degree) throws Exception {



        switch (degree) {
            case "BSc":
                GrossSalary = GrossSalary*1.1;
                break;
            case "MSc":

                GrossSalary = GrossSalary*1.2;
                break;

            case "PhD":
                GrossSalary = GrossSalary*1.35;
                break;
            //

        }
        GrossSalary = Math.round(GrossSalary * 100.0) / 100.0;

        double NetSalary_unround = GrossSalary - 0.1 * GrossSalary;
        double NetSalary = Math.round(NetSalary_unround * 100.0) / 100.0;

        String createResult="";
        if (employeeID.isEmpty() || employeeName.isEmpty() || GrossSalary <= 0 || degree.equals("")) {
            createResult= "Invalid data for item.";
        } else {
            EmpMan empMan = new EmpMan(employeeID, employeeName, GrossSalary,NetSalary,degree);
            EmpManList.add(empMan);

            createResult="Employee "+employeeID+" was registered successfully.";

        }

        return createResult;

    }

    public String createEmployee(String employeeID, String employeeName, double GrossSalary, int gpa) throws Exception {
        GrossSalary = Math.round(GrossSalary * 100.0) / 100.0;
        double NetSalary_unround = GrossSalary-0.1*GrossSalary;
        double NetSalary = Math.round(NetSalary_unround*100.0)/100.0;

        if (gpa<5){
            GrossSalary=0;
            NetSalary=0;

        }else if ((gpa>5)&(gpa<8)){
            GrossSalary=GrossSalary;
            NetSalary=GrossSalary;

        }else if (gpa>8){
            GrossSalary=GrossSalary+1000;
            NetSalary=GrossSalary;
        }
        String createResult="";
        if (employeeID.isEmpty() || employeeName.isEmpty() || GrossSalary <= -1) {
            createResult= "Invalid data for item.";
        } else {
            EmpInt empInt = new EmpInt(employeeID, employeeName, GrossSalary,NetSalary,gpa);
            EmpIntList.add(empInt);

            createResult="Employee "+employeeID+" was registered successfully.";

        }

        return createResult;
    }

    public double getNetSalary(String employeeID) throws Exception {

        Double NetSalaryToPrint=null;
        EmpReg EmpRegToPrint=null;
        EmpDir EmpDirToPrint=null;
        EmpMan EmpManToPrint=null;
        EmpInt EmpIntToPrint=null;
        for(EmpReg currentEmp: EmpRegList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpRegToPrint=currentEmp;
                NetSalaryToPrint=EmpRegToPrint.getNetSalary();
            }
        }
        for(EmpDir currentEmp: EmpDirList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpDirToPrint=currentEmp;
                NetSalaryToPrint=EmpDirToPrint.getNetSalary();
            }
        }
        for(EmpMan currentEmp: EmpManList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpManToPrint=currentEmp;
                NetSalaryToPrint=EmpManToPrint.getNetSalary();
            }
        }
        for(EmpInt currentEmp: EmpIntList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpIntToPrint=currentEmp;
                NetSalaryToPrint=EmpIntToPrint.getNetSalary();
            }
        }



        return NetSalaryToPrint;
    }

    public String createEmployee(String employeeID, String employeeName, double GrossSalary, String degree, String dept) throws Exception {
        GrossSalary = Math.floor(GrossSalary * 100.0) / 100.0;

        switch (degree) {
            case "BSc":
                GrossSalary = GrossSalary*1.1 +5000;
                break;
            case "MSc":

                GrossSalary = GrossSalary*1.2 +5000;
                break;

            case "PhD":
                GrossSalary = GrossSalary*1.35 +5000;
                break;
            //

        }

        Double NetSalary=null;
        if (GrossSalary<30000){
            NetSalary=GrossSalary - 0.1 * GrossSalary;

        }else if ((GrossSalary>30000)&(GrossSalary<50000)){
            NetSalary=GrossSalary - 0.2 * GrossSalary;

        }else if (GrossSalary>50000){
            NetSalary=GrossSalary - 0.2 * 30000- 0.4 * (GrossSalary-30000);
        }


        String createResult="";
        if (employeeID.isEmpty() || employeeName.isEmpty() || GrossSalary <= 0 || degree.equals("")) {
            createResult= "Invalid data for item.";
        } else {
            EmpDir empDir = new EmpDir(employeeID, employeeName, GrossSalary,NetSalary,degree,dept);
            EmpDirList.add(empDir);

            createResult="Employee "+employeeID+" was registered successfully.";

        }

        return createResult;
    }

    public String removeEmployee(String employeeID) throws Exception {

        String messageToPrint="";
        EmpReg EmpRegToPrint=null;
        EmpDir EmpDirToPrint=null;
        EmpMan EmpManToPrint=null;
        EmpInt EmpIntToPrint=null;
        for(EmpReg currentEmp: EmpRegList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpRegToPrint=currentEmp;
            }
        }
        for(EmpDir currentEmp: EmpDirList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpDirToPrint=currentEmp;
            }
        }
        for(EmpMan currentEmp: EmpManList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpManToPrint=currentEmp;
            }
        }
        for(EmpInt currentEmp: EmpIntList){
            if(currentEmp.getEmpID().equals(employeeID)){
                EmpIntToPrint=currentEmp;
            }
        }

        if(EmpRegToPrint == null && EmpDirToPrint == null && EmpManToPrint == null && EmpIntToPrint == null){
            messageToPrint= "Item " +employeeID+ " was not registered yet.";
        }else if(EmpRegToPrint != null && EmpRegList.remove(EmpRegToPrint)){
            messageToPrint="Employee "+EmpRegToPrint.getEmpID()+" was successfully removed.";
        }else if(EmpManToPrint != null && EmpManList.remove(EmpManToPrint)){
            messageToPrint="Employee "+EmpManToPrint.getEmpID()+" was successfully removed.";
        }else if(EmpDirToPrint != null && EmpDirList.remove(EmpDirToPrint)){
            messageToPrint="Employee "+EmpDirToPrint.getEmpID()+" was successfully removed.";
        }else if(EmpIntToPrint != null && EmpIntList.remove(EmpIntToPrint)){
            messageToPrint="Employee "+EmpIntToPrint.getEmpID()+" was successfully removed.";
        }
        return messageToPrint;

    }

    public String printAllEmployees() throws Exception {


        String message=" All registered employees :";
        EmpDirList.forEach(System.out::println);
        EmpManList.forEach(System.out::println);
        EmpIntList.forEach(System.out::println);
        EmpRegList.forEach(System.out::println);

        return message;
    }

    public double getTotalNetSalary() throws Exception {
        double totalSum = 0;
        for(EmpInt currentEmp: EmpIntList){
            totalSum+=currentEmp.getNetSalary();
        }
        for(EmpDir currentEmp: EmpDirList){
            totalSum+=currentEmp.getNetSalary();
        }
        for(EmpReg currentEmp: EmpRegList){
            totalSum+=currentEmp.getNetSalary();
        }
        for(EmpMan currentEmp: EmpManList){
            totalSum+=currentEmp.getNetSalary();
        }

        return totalSum;
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
