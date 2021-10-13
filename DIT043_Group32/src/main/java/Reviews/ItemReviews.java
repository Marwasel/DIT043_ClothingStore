package Reviews;



public class ItemReviews {
String itemID;
int reviewGrade;
String reviewComment;


public String toString() {
return reviewGrade + ", " + reviewComment;


}
    
   
public ItemReviews(int reviewGrade, String reviewComment, String itemID) {
   
	this.itemID = itemID;
    this.reviewGrade = reviewGrade;
    this.reviewComment = reviewComment;
   
       
     
      
    }
     

}