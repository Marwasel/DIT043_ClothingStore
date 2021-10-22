package ItemReviews;

import itemStore.Item;
import itemStore.ItemCtrl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReviewCtrl {


    private ArrayList<Reviews> reviewList = new ArrayList<Reviews>();

    Reviews reviewAccess = new Reviews();
    ItemCtrl ItemCtrlAccess = new ItemCtrl();
    Item itemAccess = new Item();

    //Method is not working...
    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        String reviewAdd = "";
        ArrayList reviewList = new ArrayList();

        if (ItemCtrlAccess.itemList.contains(itemID) || !reviewComment.isEmpty() || reviewGrade <= 5 || reviewGrade >= 0) {
            Reviews review = new Reviews(itemID, reviewComment, reviewGrade);
            reviewList.add(review);
            reviewAdd = "Your item review was registered successfully.";
            System.out.println(itemID + ":" + itemAccess.getItemName() + "." + itemAccess.getUnitPrice() + ".");


        } else if (!ItemCtrlAccess.itemList.contains(itemID) || reviewComment.isEmpty() || reviewGrade < 0 || reviewGrade > 5) {
            reviewAdd = "Invalid data for item.";

        }
        return reviewAdd;

    }


    private boolean invalidIndex(ArrayList<Reviews> reviewList, int index) {
        if (index < 0 || index > reviewList.size()) {
        }
        return false;
    }

    private boolean validIndex(ArrayList<Reviews> reviewList, int index) {
        if (index > 0 || index <= reviewList.size()) {
        }
        return true;
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        int index = 0;
        String review = "";
        if (reviewList.contains(itemID) && validIndex(reviewList, index)) {
            review = "Grade:" + reviewAccess.getReviewGrade() + "." + reviewAccess.getReviewComment();

        } else if (!reviewList.contains(itemID)) {
            review = "Item<ID> " + itemID + " was not registered yet.”";

        } else if (reviewList.contains(itemID) || reviewNumber == 0) {
            review = " Item " + itemID + "Has not been reviewed yet.";

        } else if (reviewList.contains(itemID) && invalidIndex(reviewList, index))
            review = "Invalid review number.Choose between 1 and " + reviewList.size();

        return review;
    }

    public String getPrintedReviews(String itemID) {

        String printedReview = "";

        for (Reviews review : reviewList) {
            printedReview = reviewAccess.toString() + "\n" +
                    "Grade:" + reviewAccess + "." + reviewAccess;
        }
        if (!reviewList.contains(itemID)) {
            printedReview = "Item id: " + itemID + " was not registered yet.";
        }
        return printedReview;

    }


    public double getItemMeanGrade(String itemID) {

        double sum = 0.0;
        double meanGrade = 0.0;

        if (!reviewList.contains(itemID)) {
            System.out.println("Item<ID> " + itemID + " was not registered yet.");

        } else if (reviewList.contains(itemID) || reviewAccess.getReviewNumber() == 0) {
            System.out.println(" Item " + itemID + "Has not been reviewed yet.");

        } else {
            for (Reviews review : reviewList) {
                sum += review.getReviewGrade();
            }
        }
        double meanValue = sum / reviewList.size();
        new DecimalFormat("#.#").format(meanValue);
        return meanGrade;
    }


    public String getItemCommentsPrinted(String itemID) {

        String comments = "";

        if (reviewAccess.getReviewComment().isEmpty()) {
            comments = null;
        } else if (!reviewList.contains(itemID)) {
            comments = "Item<ID> " + itemID + " was not registered yet.”";

        } else
            for (Reviews review : reviewList)
                comments = "Comments:" + reviewAccess.getReviewComment();

        return comments;
    }


    public String printAllReviews() {                            //Wrong method. This might print only one review??

        ArrayList<Reviews> reviewList = new ArrayList<Reviews>();

        String printReviews = "";

        if (reviewAccess.reviewNumber == 0) {
            printReviews = "No items were reviewed yet";
        } else if (!reviewList.contains(reviewAccess.getItemID())) {
            printReviews = "No Items registered yet.”";

        } else
            for (int i = 0; i < reviewList.size(); i++) {
                System.out.println(reviewList.get(i));
                for (Reviews review : reviewList) {
                    printReviews = "Review(s) for " + review.itemID + ":" + itemAccess.itemName
                            + ". " + itemAccess.unitPrice + "." + "\n" + review;
                }
            }
        return printReviews;

    }


    public int getNumberOfReviews(String itemID) {
        for (Reviews reviews : reviewList) ;
        int reviewCount = reviewList.size();


        return reviewCount;
    }

    //Not needed?
    public void sort() {

        List<String> reviewList = new ArrayList();
        Collections.sort(reviewList);
        for (String sortedList : reviewList) {
            System.out.println(sortedList);
        }
    }


    // Is it the right method to find the most reviewed items?
    public List<String> getMostReviewedItems() {


        ArrayList<String> mostFrequentList = new ArrayList<String>(reviewAccess.getReviewNumber());

        if (!reviewList.contains(reviewAccess.getItemID())) {
            System.out.println("No items registered yet.");

        } else if (reviewList.contains(reviewAccess.getItemID()) || reviewAccess.getReviewNumber() == 0) {
            System.out.println("No items were reviewed yet.");

        } else
            System.out.println("Most reviews: " + Collections.max(mostFrequentList));
        {

        }

        return mostFrequentList;
    }


    //What is the difference here from the getMostReviewedItems method? And is it valid to do it this way??
    public String printMostReviewedItems() {

        return "Most reviewed:" + Collections.max(getMostReviewedItems()) + "review(s) each" + "\n"
                + itemAccess.toString();
    }


    public List<String> getLeastReviewedItems() {

        ArrayList<String> leastFrequentList = new ArrayList<String>(reviewAccess.getReviewNumber());

        if (!reviewList.contains(reviewAccess.getItemID())) {
            System.out.println("No items registered yet.");

        } else if (reviewList.contains(reviewAccess.getItemID()) || reviewAccess.getReviewNumber() == 0) {
            System.out.println("No items were reviewed yet.");

        } else
            System.out.println("Least Reviews: " + Collections.min(leastFrequentList));

        return leastFrequentList;
    }


    public String printLeastReviewedItems() {

        return "Least reviewed:" + Collections.min(getLeastReviewedItems()) + "review(s) each" + "\n"
                + itemAccess.toString();

    }

//Wrong method
    public List<String> getBestReviewedItems() {

        ArrayList<String> bestReviewList = new ArrayList<String>();
        int sum = 0;

        if (!reviewList.contains(reviewAccess.getItemID())) {
            System.out.println("No items registered yet.");

        } else if (reviewList.contains(reviewAccess.itemID) || reviewAccess.getReviewNumber() == 0) {
            System.out.println("No Items were reviewed yet.");

        } else {
            System.out.println("Items with best mean reviews: " + Collections.max(bestReviewList));
            double average = sum / bestReviewList.size();
        }

        return null;
    }

//Wrong method
    public List<String> getWorseReviewedItems() {

        ArrayList<String> worstReviewList = new ArrayList<String>(reviewAccess.getReviewGrade());
        int sum = 0;

        if (!reviewList.contains(reviewAccess.getItemID())) {
            System.out.println("No items registered yet.");

        } else if (reviewList.contains(reviewAccess.itemID) || reviewAccess.getReviewNumber() == 0) {
            System.out.println("No Items were reviewed yet.");

        } else {
            System.out.println("Items with best mean reviews: " + Collections.min(worstReviewList));
            double average = sum / worstReviewList.size();
        }
        return null;
    }
}


















