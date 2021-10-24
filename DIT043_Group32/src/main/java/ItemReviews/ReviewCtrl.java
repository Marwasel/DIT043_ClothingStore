package ItemReviews;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewCtrl {

    // review map contains all reviews per ItemID
    private HashMap<String, ArrayList<Review>> reviewMap = new HashMap<String, ArrayList<Review>>();
    // This should record the max/min reviews per item ever
    public int maxReviewsByItem = 0;
    public int leastReviewsByItem = 0;
    public double bestReviewsByItem = 0;
    public double worstReviewsByItem = 0;


    public int getItemsReviewsSize() {
        return reviewMap.size();
    }


    public int getNumberOfReviews(String itemID) {

        if (!reviewMap.containsKey(itemID)) {
            System.out.println(" Item " + itemID + " has not been reviewed yet.");
            return 0;
        }
        return reviewMap.get(itemID).size();
    }


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
            System.out.println("Creating review " + review.toString());
            return "Your item review was registered successfully.";
        }
        return "Grade values must be between 1 and 5.";
    }


    private boolean isValidIndex(String itemID, int index) {
        ArrayList reviews = reviewMap.get(itemID);
        return (index >= 0 && index < reviews.size());
    }


    public boolean hasReviewsForItemID(String itemID) {
        if (!reviewMap.containsKey(itemID)) {
            System.out.println(" Item " + itemID + " has not been reviewed yet.");
            return false;
        }
        return true;
    }


    public List<String> getAllRegisteredItems() {
        List<String> itemIDs = new ArrayList<>();
        for (String itemID : reviewMap.keySet()) {
            itemIDs.add(itemID);
        }
        return itemIDs;
    }


    public String getPrintedItemReview(String itemID, int reviewNumber) {
        String errorMessage = "Invalid review number. Choose between 1 and " + reviewMap.get(itemID).size() +".";

        if (reviewNumber == 0) {
            return errorMessage;
        }

        if (!isValidIndex(itemID, reviewNumber)) {
            return errorMessage;
        }


        reviewNumber--;
        Review review = reviewMap.get(itemID).get(reviewNumber);
        return review.toString();
    }


    public String getPrintedReviews(String itemID) {

        String printedReview = "";

        for (Review review : reviewMap.get(itemID)) {
            printedReview += review.toString() + "\n";
        }

        return printedReview;
    }


    public double getItemMeanGrade(String itemID) {
        double sum = 0.0;
        double meanGrade = 0.0;
        int reviewsCount = getNumberOfReviews(itemID);


        if (!reviewMap.containsKey(itemID)) {
            System.out.println(" Item " + itemID + " has not been reviewed yet.");
            return 0;
        }


        for (Review review : reviewMap.get(itemID)) {
            sum += review.getReviewGrade();
        }

        double meanValue = sum / reviewsCount;

        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.DOWN);
        String x = df.format(meanValue);


        return Double.parseDouble(x);
    }


    public List<String> getItemComments(String itemID) {
        List<String> comments = new ArrayList<String>();


        if (!hasReviewsForItemID(itemID)) {
            return comments;
        }

        String comment = "";
        for (Review review : reviewMap.get(itemID)) {
            comment = review.getReviewComment();
            if (!comment.isEmpty()) {
                comments.add(comment);
            }
        }
        return comments;
    }

    public List<String> getMostReviewedItemID() {
        HashMap<String, Integer> reviewedItemCount = new HashMap<String, Integer>();
        ArrayList<String> maxItemIDs = new ArrayList<String>();
        int maxReviews = 0;
        int reviewCount = 0;


        for (String itemID : reviewMap.keySet()) {

            for (Review review : reviewMap.get(itemID)) {

                if (reviewedItemCount.containsKey(itemID)) {

                    reviewedItemCount.put(itemID, reviewedItemCount.get(itemID) + 1);
                }

                else {
                    reviewedItemCount.put(itemID, 1);
                }
            }
        }

        // Get top review
        for (String itemID : reviewedItemCount.keySet()) {
            reviewCount = reviewedItemCount.get(itemID);
            if (maxReviews < reviewCount) {
                maxReviews = reviewCount;
            }
        }



        for (String itemID : reviewedItemCount.keySet()) {
            reviewCount = reviewedItemCount.get(itemID);
            if (maxReviews == reviewCount) {
                maxItemIDs.add(itemID);
            }
        }

        this.maxReviewsByItem = maxReviews;
        System.out.println("Max Item IDS: " + maxItemIDs + " Review Count: " + maxReviews);
        return maxItemIDs;
    }

    public List<String> getLeastReviewedItemID() {
        HashMap<String, Integer> reviewedItemCount = new HashMap<String, Integer>();
        ArrayList<String> leastItemIDs = new ArrayList<String>();
        int leastReviews = 100;
        int reviewCount = 0;


        for (String itemID : reviewMap.keySet()) {

            for (Review review : reviewMap.get(itemID)) {

                if (reviewedItemCount.containsKey(itemID)) {
                    // increment by 1
                    reviewedItemCount.put(itemID, reviewedItemCount.get(itemID) + 1);
                }

                else {
                    reviewedItemCount.put(itemID, 1);
                }
            }
        }


        for (String itemID : reviewedItemCount.keySet()) {
            reviewCount = reviewedItemCount.get(itemID);
            if (reviewCount < leastReviews) {
                leastReviews = reviewCount;
            }
        }


        for (String itemID : reviewedItemCount.keySet()) {
            reviewCount = reviewedItemCount.get(itemID);
            if (leastReviews == reviewCount) {
                leastItemIDs.add(itemID);
            }
        }
        this.leastReviewsByItem = leastReviews;
        return leastItemIDs;
    }

    public List<String> getBestReviewedItems() {

        HashMap<String, Double> bestReviewedItemCount = new HashMap<String, Double>();
        ArrayList<String> bestItemIDs = new ArrayList<String>();
        double bestMeanGrade = 0.0;


        for (String itemID : reviewMap.keySet()) {

            double meanGrade = getItemMeanGrade(itemID);
            bestReviewedItemCount.put(itemID, meanGrade);
        }




        for (String itemID : bestReviewedItemCount.keySet()) {
            double meanGrade = bestReviewedItemCount.get(itemID);
            if (meanGrade > bestMeanGrade) {
                bestMeanGrade = meanGrade;
            }
        }




        for (String itemID : reviewMap.keySet()) {

            double meanGrade = getItemMeanGrade(itemID);
            if (meanGrade == bestMeanGrade) {
                bestItemIDs.add(itemID);
            }
        }

        System.out.println("bestItemIDs: " + bestItemIDs);
        this.bestReviewsByItem = bestMeanGrade;
        // sort
        return bestItemIDs.stream().sorted().collect(Collectors.toList());
    }

    public List<String> getWorstReviewedItems() {

        HashMap<String, Double> worstReviewedItemCount = new HashMap<String, Double>();
        ArrayList<String> worstItemIDs = new ArrayList<String>();
        double worstMeanGrade = 100.0;


        for (String itemID : reviewMap.keySet()) {

            double meanGrade = getItemMeanGrade(itemID);
            worstReviewedItemCount.put(itemID, meanGrade);
        }


        for (String itemID : worstReviewedItemCount.keySet()) {
            double meanGrade = worstReviewedItemCount.get(itemID);
            if (meanGrade < worstMeanGrade) {
                worstMeanGrade = meanGrade;
            }
        }

        System.out.println("Best item for now: " + worstMeanGrade);

        // get those with the best mean grade:
        for (String itemID : reviewMap.keySet()) {
            // Calculate the meanGrade
            double meanGrade = getItemMeanGrade(itemID);
            if (meanGrade == worstMeanGrade) {
                worstItemIDs.add(itemID);
            }
        }

        this.worstReviewsByItem = worstMeanGrade;
        // sort
        return worstItemIDs.stream().sorted().collect(Collectors.toList());
    }
}





