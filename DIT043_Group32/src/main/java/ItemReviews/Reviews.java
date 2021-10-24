package ItemReviews;


class Review {

    String itemID;
    int reviewGrade;
    int reviewNumber;
    String reviewComment;


    public Review(String itemID, String reviewComment, int reviewGrade ) {
        this.itemID = itemID;
        this.reviewComment = reviewComment;
        this.reviewGrade = reviewGrade;
    }
    public Review() {}

    public int getReviewGrade() {
        return reviewGrade;
    }

    public void setReviewGrade(int reviewGrade) {
        this.reviewGrade = reviewGrade;
    }

    public int getReviewNumber() {
        return reviewNumber;
    }

    public void setReviewNumber(int reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    @Override
    public String toString() {
        return "Grade: " + this.reviewGrade + "." + this.reviewComment;
    }

}


