package lab5;

public class BorrowingBookResult{
    
    private String borrowingMessage;
    private boolean isSucess;
    
    public BorrowingBookResult(boolean isSucess, String title) {
        this.borrowingMessage = title;
        this.isSucess = isSucess;
    }
    public void setborrowingMessage(String w) {
        borrowingMessage = w;
    }
    public void setisSucess(boolean w) {
        isSucess = w;
    }
    public String getborrowingMessage() {
        return borrowingMessage;
    }
    public boolean getisSucess() {
        return isSucess;
    }
}
