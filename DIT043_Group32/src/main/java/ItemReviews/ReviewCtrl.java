package ItemReviews;

import java.util.ArrayList;
import itemStore.ItemCtrl;


public class ReviewCtrl {


    public ReviewCtrl(String itemID, String reviewComment, int reviewGrade){
        }

        static ArrayList<Reviews> reviewList = new ArrayList<Reviews>();


        public String reviewItem (String itemID, String reviewComment,int reviewGrade){

            //Not able to get access to itemList in ItemCtrl
            if (!itemList.containsKey(itemID) || reviewComment.isEmpty() || reviewGrade <= 0) {
                System.out.println("Invalid data for item.");
            } else {
                Reviews review = new Reviews(itemID, reviewComment, reviewGrade);
                reviewList.add(review);

                System.out.println("Your item review was registered successfully.");

            }
            return review;

        }
    }
