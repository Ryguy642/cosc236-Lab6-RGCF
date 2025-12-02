package lab5;

public class BorrowingBookResult{
    
    private String borrowingMessage;
    private boolean isSuccess;
    
    public BorrowingBookResult(boolean isSuccess, String title) {
        this.borrowingMessage = title;
        this.isSuccess = isSuccess;
    }
    public void setBorrowingMessage(String w) {
        borrowingMessage = w;
    }
    public void setisSuccess(boolean w) {
        isSuccess = w;
    }
    public String getBorrowingMessage() {
        return borrowingMessage;
    }
    public boolean getIsSuccess() {
        return isSuccess;
    }
}
