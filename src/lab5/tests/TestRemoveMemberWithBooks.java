package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Member;
import lab5.EBook;
import lab5.PaperBook;
import lab5.AudioBook;
import lab5.Book;
import lab5.BorrowingService;
import lab5.Library;


class TestRemoveMemberWithBooks {

    Library library;
    Member member;
    Book book1;
    Book book2;
    Book book3;

    @BeforeEach
    void setUp() throws Exception {
        this.library = new Library(); // Fresh library: one member, two tests
        book1 = new AudioBook("Dune");
        book2 = new EBook("1984");
        book3 = new PaperBook("Moby Dick");
        BorrowingService borrowingService = new BorrowingService();
        member = new Member("Dude", borrowingService);
        library.addMember(member);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }
    
    @Test
    void removeMemberReturnBooks() {
        
        member.borrowBook(book1);
        member.borrowBook(book2);
        member.borrowBook(book3);
        assertAll("Check inital library state", 
            () -> assertEquals(library.membersCount(),1),
            () -> assertEquals(library.booksCount(),3),
            () -> assertFalse(book1.getIsAvailable()),
            () -> assertFalse(book2.getIsAvailable()),
            () -> assertEquals(member.borrowedBooksCount(),3)
        );
        
        library.removeMember(member);
        
        assertEquals(library.membersCount(),0);
        assertEquals(library.booksCount(),3);
        assertTrue(book1.getIsAvailable());
        assertTrue(book2.getIsAvailable());
        assertTrue(book3.getIsAvailable());
        assertEquals(member.borrowedBooksCount(),0);
    }

}
