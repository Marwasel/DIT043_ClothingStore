package ItemReviews;

import itemStore.Item;



 class Reviews {
String itemID;
int reviewGrade;
String reviewComment;
int reviewNumber;

Item itemAccess = new Item();

Reviews review = new Reviews(itemID, reviewGrade, reviewComment, reviewNumber);



    public Reviews(String itemID, int reviewGrade, String reviewComment, int reviewNumber) {

        this.itemID = itemID;
       this.reviewComment = reviewComment;
       this.reviewGrade = reviewGrade;
       this.reviewNumber = reviewNumber;
    }
public Reviews(String itemID, String reviewComment, int reviewGrade ) {
    this.itemID = itemID;
    this.reviewComment = reviewComment;
    this.reviewGrade = reviewGrade;
}

     public Reviews() {

     }


     String getItemID(){
         return itemID;
     }

     void setItemID(){
         this.itemID = itemID;
     }


    int getReviewGrade(){

        return reviewGrade;
    }

    void setReviewGrade() {
       reviewGrade = reviewGrade;

    }

    String getReviewComment() {

        return reviewComment;
    }
    void setReviewComment() {

       reviewComment = reviewComment;
    }

    int getReviewNumber() {
        return reviewNumber;
    }

    void setReviewNumber() {
        reviewNumber = reviewNumber;
    }

   @Override
    public String toString() {
       return "Review(s) for" + itemID + ":" + itemAccess.itemName + "." + itemAccess.unitPrice ;
    }

}


