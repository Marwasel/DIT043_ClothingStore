package ItemReviews;



public class Reviews {
String itemID;
int reviewGrade;
String reviewComment;


    public Reviews(String itemID, String reviewComment,int reviewGrade) {

        this.itemID = itemID;
        this.reviewComment = reviewComment;
        this.reviewGrade = reviewGrade;

    }


    int getReviewGrade(){

        return reviewGrade;
    }

    void setReviewGrade() {
        this.reviewGrade = reviewGrade;

    }

    String getReviewComment() {

        return reviewComment;
    }
    void setReviewComment() {
        this.reviewComment = reviewComment;
    }


@Override
public String toString() {
return itemID + "," + reviewGrade + ", " + reviewComment;


}





}