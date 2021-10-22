package ItemReviews;

import itemStore.Item;
import itemStore.ItemCtrl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class ReviewCtrl {


    private ArrayList<Reviews> reviewList = new ArrayList<Reviews>();


    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {

        ArrayList reviewList = new ArrayList();

        if (!ItemCtrl.itemList.contains(itemID) || reviewComment.isEmpty() || reviewGrade <= 0) {
            System.out.println("Invalid data for item.");
        } else {
            Reviews review = new Reviews(itemID, reviewComment, reviewGrade);
            reviewList.add(review);
            System.out.println("Your item review was registered successfully.");
        }
        return "Your item review was registered successfully";

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
            review = "Grade:" + Reviews.reviewGrade + "." + Reviews.reviewComment;     //Not working

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
           printedReview = review.itemID.toString() + "\n" +
                    "Grade:" + Reviews.reviewGrade + "." + reviewComment;
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

        } else if (reviewList.contains(itemID) || Reviews.reviewNumber == 0) {
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
        if (Reviews.reviewComment.isEmpty()) {
            comments = null;
        } else if (!reviewList.contains(itemID)) {
            comments = "Item<ID> " + itemID + " was not registered yet.”";

        } else
            for (Reviews review : reviewList)
                comments = "Comments:" + review.getReviewComment();

        return comments;
    }

    public ArrayList<Reviews> printAllReviews() {

        ArrayList<Reviews> reviewList = new ArrayList<Reviews>();

        String printReview = "";
        if (Reviews.review.isEmpty()) {
            printReview = "No items were reviewed yet";
        } else if (!reviewList.contains(Reviews.itemID)) {
            printReview = "No Items registered yet.”";

        } else
            for (int i = 0; i < reviewList.size(); i++) {
                System.out.println(reviewList.get(i));
                for (Reviews review : reviewList) {
                    printReview = "Review(s) for " + review.itemID + ":" + Item.itemName
                            + ". " + Item.unitPrice + "." + "\n" + review;
                }
            }
                return reviewList;   //reviewList??

    }

    public int getNumberOfReviews(String itemID) {

        int reviewCount = reviewList.size();
       // for (Reviews reviews : reviewList)
       //     reviewCount = reviewList.get(Reviews.review);

        return reviewCount;
    }





    public List<String> getMostReviewedItems() {


            List<String> mostFrequentList = new List<String>(Reviews.reviewNumber); // reviewList?
            for (String num : mostFrequentList) {
                Reviews max = num + ": " + Collections.max(reviewList);
            }
            return Collections.max(reviewList);
        }


        public String printMostReviewedItems () {

        return "Most reviewed:" + Collections.max(reviewList) + "review(s) each" + "\n" + Item.toString();;
        }


    public void sort(){

        List<String> reviewList = new ArrayList(this.reviewList.get());
        Collections.sort(reviewList);
        for ( String sortedList : reviewList){
            System.out.println(sortedList);
        }
    }


    public List<String> getLeastReviewedItems() {

        String min = "";
        List<String> leastFrequentList = new List<String>(Reviews.reviewNumber);
        for (String num : leastFrequentList) {
        min = num + ": " + Collections.min(reviewList));   //Do I have to add instances??
        }
        return Collections.min(reviewList);
    }

    public String printLeastReviewedItems() {

     return "Least reviewed:" + Collections.min(reviewList) + "review(s) each" + "\n" + Item.toString();
    }




    public List<String> getBestReviewedItems() {
        List<String> bestReviewList = new List<String>(Reviews.reviewGrade);
        for(Reviews reviews : this.reviewList) {
            if()
        }
        return null;
    }

    public List<String> getWorseReviewedItems() {
        List<String> worstReviewList = new List<String>(Reviews.reviewGrade);

        return null;
    }
}

















