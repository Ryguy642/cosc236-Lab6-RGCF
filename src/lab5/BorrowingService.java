package lab5;
import java.util.ArrayList;
import java.util.Iterator;
public class BorrowingService implements BorrowingServiceAPI{
    
    private Member member;
    private Book book;
    
    public BorrowingService(Member member, Book book) {
        this.member = member;
        this.book = book;
    }
    public BorrowingBookResult borrowBook() {
        //Make sure this user doesn't already have this book, this book is
        //available, and that the member has no more than two books
        ArrayList<Book> borrowed = member.getBorrowedBooks();
        if(borrowed.indexOf(book) != -1) {
            BorrowingBookResult ret = new BorrowingBookResult(false, "" + member.toString() + " has already borrowed " + book.getTitle());
            return ret;
        }
        if(book.getIsAvailable() == false) {
            BorrowingBookResult ret = new BorrowingBookResult(false, "" + member.toString() + " is unable to borrow " + book.getTitle() + "because it has already been borrowed");
            return ret;
        }
        if(borrowed.size() == 3 ){
            BorrowingBookResult ret = new BorrowingBookResult(false, "" + member.toString() + " has more than two books so they cannot borrow " + book.getTitle());
            return ret;
        }
        //yay
        member.addBook(book);
        book.setIsAvailable(false);
        BorrowingBookResult ret = new BorrowingBookResult(true, member.toString() + " has borrowed " + book.getTitle());
        return ret;
    }
    public BorrowingBookResult returnBook() {
        //Make sure the member has borrowed this book and that it hasn't 
        //already been returned
        ArrayList<Book> borrowed = member.getBorrowedBooks();
        if(borrowed.indexOf(book) == -1) {
            BorrowingBookResult ret = new BorrowingBookResult(false, "" + member.toString() + " has not borrowed " + book.getTitle());
            return ret;
        }
        if(book.getIsAvailable() == true) {
            BorrowingBookResult ret = new BorrowingBookResult(false, book.getTitle() + " has already been returned.");
            return ret;
        }
        member.returnBook(book);
        book.setIsAvailable(true);
        BorrowingBookResult ret = new BorrowingBookResult(true, member.toString() + " has returned " + book.getTitle());
        return ret;
    }
}
