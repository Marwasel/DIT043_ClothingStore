package ItemReviews;

import java.text.DecimalFormat;
import java.util.*;

public class ReviewCtrl {

    private HashMap<String, ArrayList<Review>> reviewMap = new HashMap<String, ArrayList<Review>>();



    public int getItemsReviewsSize() {
        return reviewMap.size();
    }

    public double maxReviewsByItem = 0;
    public int leastReviewsByItem = 0;


    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        if (0 < reviewGrade && reviewGrade <= 5) {
            Review review = new Review(itemID, reviewComment, reviewGrade);

            if (reviewMap.containsKey(itemID)) {
                ArrayList reviews = reviewMap.get(itemID);
                reviews.add(review);
            }

            else {
                ArrayList reviews = new ArrayList<Review>();
                reviews.add(review);
                reviewMap.put(itemID, reviews);
            }
            return "Your item review was registered successfully.";
        }
        return "Grade values must be between 1 and 5.";
    }

    private boolean isValidIndex(String itemID, int index) {
        ArrayList reviews = reviewMap.get(itemID);
        return (index > 0 || index <= reviews.size());
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        if (!reviewMap.containsKey(itemID)) {
            return " Item " + itemID + "Has not been reviewed yet.";
        }
        if (!isValidIndex(itemID, reviewNumber)) {
            return "Invalid review number.Choose between 1 and " + reviewMap.get(itemID).size();
        }
        Review review = reviewMap.get(itemID).get(reviewNumber);
        return review.toString();
    }


    public String getPrintedReviews(String itemID) {

        if (!reviewMap.containsKey(itemID)) {
            return " Item " + itemID + " has not been reviewed yet.";
        }
        String printedReview = "";



        for (Review review : reviewMap.get(itemID)) {
            printedReview += review.toString() + "\n";
        }

        return printedReview;
    }


    public double getItemMeanGrade(String itemID) {
        double sum = 0.0;
        double meanGrade = 0.0;

        if (!reviewMap.containsKey(itemID)) {
            System.out.println(" Item " + itemID + " has not been reviewed yet.");
            return -1;
        }


        for (Review review : reviewMap.get(itemID)) {
            sum += review.getReviewGrade();
        }

        meanGrade = sum / reviewMap.get(itemID).size();
        new DecimalFormat("#.#").format(meanGrade);
        return meanGrade;
    }

    public List<String> getItemComments(String itemID) {
        List<String> comments = new ArrayList<String>();


        if (!reviewMap.containsKey(itemID)) {
            System.out.println(" Item " + itemID + " has not been reviewed yet.");
            return comments;
        }


        for (Review review : reviewMap.get(itemID)) {
            comments.add(review.getReviewComment());
        }
        return comments;
    }


    public int getNumberOfReviews(String itemID) {

        if (!reviewMap.containsKey(itemID)) {
            System.out.println(" Item " + itemID + " has not been reviewed yet.");
            return 0;
        }
        return reviewMap.get(itemID).size();
    }


    public List<String> getMostReviewedItemID() {
        HashMap<String, Integer> reviewdItemCount = new HashMap<String, Integer>();
        ArrayList<String> maxItemIDs = new ArrayList<String>();
        int maxReviews = 0;
        int reviewCount = 0;

        // Iterate over map
        for (String itemID : reviewMap.keySet()) {
            // If there are reviews before
            if (reviewdItemCount.containsKey(itemID)) {
                int count = reviewdItemCount.get(itemID);
                count++;
            }

            else {
                reviewdItemCount.put(itemID, 1);
            }
        }

        for (String itemID : reviewdItemCount.keySet()) {
            reviewCount = reviewdItemCount.get(itemID);
            if (maxReviews < reviewCount) {
                maxReviews = reviewCount;
            }
        }


        // Get top Items
        for (String itemID : reviewdItemCount.keySet()) {
            reviewCount = reviewdItemCount.get(itemID);
            if (maxReviews == reviewCount) {
                maxItemIDs.add(itemID);
            }
        }

        this.maxReviewsByItem = maxReviews;
        return maxItemIDs;
    }


    public List<String> getLeastReviewedItemID() {
        HashMap<String, Integer> reviewdItemCount = new HashMap<String, Integer>();
        ArrayList<String> leastItemIDs = new ArrayList<String>();
        int leastReviews = 100;
        int reviewCount = 0;


        for (String itemID : reviewMap.keySet()) {

            if (reviewdItemCount.containsKey(itemID)) {
                int count = reviewdItemCount.get(itemID);
                count++;
            }
            // for the first review
            else {
                reviewdItemCount.put(itemID, 1);
            }
        }
        //Then to be able to get the least review...
        for (String itemID : reviewdItemCount.keySet()) {
            reviewCount = reviewdItemCount.get(itemID);
            if (reviewCount < leastReviews) {
                leastReviews = reviewCount;
            }
        }


        for (String itemID : reviewdItemCount.keySet()) {
            reviewCount = reviewdItemCount.get(itemID);
            if (leastReviews == reviewCount) {
                leastItemIDs.add(itemID);
            }
        }
        this.leastReviewsByItem = leastReviews;
        return leastItemIDs;
    }

    public String printAllReviews() {
        String printedReview = "";


        for (String itemID : reviewMap.keySet()) {
            for (Review review : reviewMap.get(itemID)) {
                printedReview += review.toString() + "\n";
            }
        }
        return printedReview;
    }

   public List<String> getBestReviewedItems() {

       HashMap<String, Integer> bestReviewedItemCount = new HashMap<String, Integer>();
       ArrayList<String> maxItemIDs = new ArrayList<String>();

       int reviewCount = 0;
       double bestMeanGrade = 0.0;
       for (Review review : reviewMap.get(maxItemIDs)) {
           reviewCount += review.getReviewGrade();
       }
       bestMeanGrade = reviewCount / reviewMap.size();


       for (String itemID : reviewMap.keySet()) {
           // If there are reviews before
           if (bestReviewedItemCount.containsKey(itemID)) {
               int count = bestReviewedItemCount.get(itemID);
               count++;
           }

           else {
               bestReviewedItemCount.put(itemID, 1);
           }
       }

       for (String itemID : bestReviewedItemCount.keySet()) {
           reviewCount = bestReviewedItemCount.get(itemID);
           if (bestMeanGrade < reviewCount) {
               bestMeanGrade = reviewCount;
           }
       }

       // Get top Items
       for (String itemID : bestReviewedItemCount.keySet()) {
           reviewCount = bestReviewedItemCount.get(itemID);
           if (bestMeanGrade == reviewCount) {
               maxItemIDs.add(itemID);
           }
       }

       this.maxReviewsByItem = bestMeanGrade;
       return maxItemIDs;
   }

    public List<String> getWorseReviewedItems() {

        HashMap<String, Integer> worstReviewedItemCount = new HashMap<String, Integer>();
        ArrayList<String> worseItemIDs = new ArrayList<String>();

        int reviewCount = 0;
        double worstMeanGrade = 0.0;
        for (Review review : reviewMap.get(worseItemIDs)) {
            reviewCount += review.getReviewGrade();
        }
        worstMeanGrade = reviewCount / reviewMap.size();

        // Iterate over map
        for (String itemID : reviewMap.keySet()) {
            // If there are reviews before
            if (worstReviewedItemCount.containsKey(itemID)) {
                int count = worstReviewedItemCount.get(itemID);
                count++;
            }

            else {
                worstReviewedItemCount.put(itemID, 1);
            }
        }

        for (String itemID : worstReviewedItemCount.keySet()) {
            reviewCount = worstReviewedItemCount.get(itemID);
            if (worstMeanGrade > reviewCount) {
                worstMeanGrade = reviewCount;
            }
        }


        //get items with worst mean. Correct method?
        for (String itemID : worstReviewedItemCount.keySet()) {
            reviewCount = worstReviewedItemCount.get(itemID);
            if (worstMeanGrade == reviewCount) {
                worseItemIDs.add(itemID);
            }
        }

        this.maxReviewsByItem = worstMeanGrade;
        return worseItemIDs;
    }
    }













