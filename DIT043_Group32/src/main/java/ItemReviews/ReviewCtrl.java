package ItemReviews;

import itemStore.ItemCtrl;

import java.util.ArrayList;


public class ReviewCtrl {


    public ReviewCtrl(String itemID, String reviewComment, int reviewGrade){
        }

        static ArrayList<Reviews> reviewList = new ArrayList<Reviews>();


        public static String reviewItem (String itemID, String reviewComment,int reviewGrade){


            if (!ItemCtrl.itemList.contains(itemID) || reviewComment.isEmpty() || reviewGrade <= 0) {
                System.out.println("Invalid data for item.");
            } else {
                Reviews review = new Reviews(itemID, reviewComment, reviewGrade);
                reviewList.add(review);

                System.out.println("Your item review was registered successfully.");

            }
            return "" ;
        }
    }
