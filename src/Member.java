package lab5;

import java.util.ArrayList;

public class Member {
    private String name;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private BorrowingService borrowingService;

    public Member(String name, BorrowingService service) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.borrowingService = service; // Injected from outside
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void borrowBook(Book book) {
        BorrowingBookResult result = borrowingService.borrowBook(this, book);
        System.out.println(result.getBorrowingMessage());
    }

    public void returnBook(Book book) {
        BorrowingBookResult result = borrowingService.returnBook(this, book);
        System.out.println(result.getBorrowingMessage());
    }
    public void deleteBook(Book book) {
        borrowedBooks.remove(book);
    }
    public void listBorrowedBooks() {
        for (Book book : borrowedBooks)
            System.out.println(book);
    }

    public int borrowedBooksCount() {
        return borrowedBooks.size();
    }

    public void returnAllBooks() {
        for (Book book : borrowedBooks) {
            book.setIsAvailable(true);
        }
        borrowedBooks.clear();
    }

    public void addBook(Book book) {
        borrowedBooks.add(book);
    }

    @Override
    public String toString() {
        return "Member: " + name;
    }
    
    public BorrowingService getBorrowingService(){
        return borrowingService;
    }
}

