package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Library;
import lab5.Member;
import lab5.PaperBook;
import lab5.EBook;
import lab5.AudioBook;
import lab5.Book;
import lab5.BorrowingService;

class TestExoticBooks {
    /* This class is intended to test the addition of exotic book types.
     * Other classes have been modified to incorporate exotic book types.
     * 
     */
    Member member1;
    Member member2;
    private Library library;
    Book book1 = new AudioBook("Dune");
    Book book2 = new EBook("1984");
    Book book3 = new AudioBook("The Count of Monte Cristo");
    @BeforeEach
    void setUp() throws Exception {
    	BorrowingService borrowingService = new BorrowingService();
    	member1 = new Member("Alice", borrowingService); // flush borrowedBook array 
    	member2 = new Member("Bob", borrowingService);   // flush borrowedBook array 
 
        book1.setIsAvailable(true);
        book2.setIsAvailable(true);
        this.library = new Library(); // empty library for each test
    }
    @Test
    void borrowBookBook() {
        
        // borrow first book
        assertEquals(member1.borrowedBooksCount(), 0, "Borrowed book should be zero");
        assertTrue(book1.getIsAvailable(), "Book 1 must be available");
        member1.borrowBook(book1);
        assertFalse(book1.getIsAvailable(),"Book 1 must be not available");
        assertEquals(member1.borrowedBooksCount(),1, "Count of borrowed books must be 1");
        
        // borrow second book
        assertTrue(book2.getIsAvailable(),"Book must be available");
        member1.borrowBook(book2);
        assertFalse(book1.getIsAvailable(), "Book should not be available");
        assertEquals(member1.borrowedBooksCount(), 2, "The book coubnt shoud be 2");
    }
    
    @Test
    void returnBookBook() {
        
        // borrow two books
        assertTrue(book1.getIsAvailable(), "Book 1 should be available");
        assertTrue(book2.getIsAvailable(), "Book 2 should be available");
        assertEquals(member1.borrowedBooksCount(), 0,"Member1 should not have any books" );
        member1.borrowBook(book1);
        member1.borrowBook(book2);
        assertEquals(member1.borrowedBooksCount(),2, "The count of books must be 2");
        assertFalse(book1.getIsAvailable(), "Book 1 should not be available");
        assertFalse(book2.getIsAvailable(), "Book 2 should not be available");
        
        // return first book
        member1.returnBook(book1);
        assertTrue(book1.getIsAvailable(), "Book should be available after return");
        assertEquals(member1.borrowedBooksCount(), 1, "Count of books must be 1");
        // return second book
        member1.returnBook(book2);
        assertTrue(book2.getIsAvailable(), "Book should be available after return");
        assertEquals(member1.borrowedBooksCount(), 0, "Member 1 should have no books");
        
    }
    void AddBooks() {
        
        assertEquals(library.booksCount(), 0, "Should be no books in library");    
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
    }
    @Test
    void testRemoveBook() {
        
        AddBooks();
        assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
        
        member1.borrowBook(book1);
        assertEquals(member1.borrowedBooksCount(), 1, "Should be 1 borrowed book");
        
        library.removeBook(book1);
        assertEquals(library.booksCount(), 2, "There should be only two book left in the library");
        
        assertEquals(member1.borrowedBooksCount(), 1, "The book should stay with member"); // 
        
        Book b = member1.getBorrowedBooks().get(0); // the only book
        assertEquals(b, book1,"The owned book should be the removed book");
    }
}
