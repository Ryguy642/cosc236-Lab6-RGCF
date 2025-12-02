package lab5;

import java.util.ArrayList;

public class BorrowingService implements BorrowingServiceAPI {
    private static BorrowingService instance; // private member
    private int borrowingLimit; // to restrict the count of borrowed books
    private static final BorrowingService INSTANCE = new BorrowingService();
     public BorrowingService() { // private constructor
        borrowingLimit = 3;
    }
    
    public static BorrowingService getInstance( ) {
    return INSTANCE;
   }

    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {
        ArrayList<Book> borrowed = member.getBorrowedBooks();

        if (borrowed.contains(book)) {
            return new BorrowingBookResult(false,
                    member + " has already borrowed " + book.getTitle());
        }

        if (!book.getIsAvailable()) {
            return new BorrowingBookResult(false,
                    member + " cannot borrow " + book.getTitle() + " because it is already borrowed");
        }

        if (borrowed.size() >= 3) {
            return new BorrowingBookResult(false,
                    member + " has more than two books and cannot borrow " + book.getTitle());
        }

        member.addBook(book);
        book.setIsAvailable(false);

        return new BorrowingBookResult(true,
                member + " has borrowed " + book.getTitle());
    }

    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {
        //System.out.println("Hello there!");
       if(member.getBorrowedBooks() != null) {
         ArrayList<Book> borrowed = member.getBorrowedBooks();
        } else if (member.getBorrowedBooks() == null || !(member.getBorrowedBooks()).contains(book)) {
            return new BorrowingBookResult(false,
                    member + " has not borrowed " + book.getTitle());
        }

        book.setIsAvailable(true);
        member.deleteBook(book);
        return new BorrowingBookResult(true,
                member + " has returned " + book.getTitle());

   }
}
