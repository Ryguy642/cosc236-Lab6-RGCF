package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Library;
import lab5.EBook;
import lab5.AudioBook;
import lab5.Book;
import lab5.PaperBook;
import lab5.BorrowingService;
import lab5.Member;
import lab5.PaperBook;
import lab5.LibrarianController;
import lab5.PaperBookFactory;
import lab5.EBookFactory;
import lab5.AudioBookFactory;

class TestFactories {
   BorrowingService service = BorrowingService.getInstance();
   private LibrarianController Martha;
   Book book1 = new PaperBook("Dune");
    Book book2 = new EBook("1984");
    Book book3 = new PaperBook("Moby Dick");
    private Library library = new Library();
    Member member = new Member("Grady Booch", service);
@Test
void TestTypes() {
       library.addBook(book1);
       library.addBook(book2);
       library.addBook(book3);
       assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
      // assertTrue(, "Paper Factory books should be identical");
}
public void paperTime() {
    PaperBookFactory bob = new PaperBookFactory();
    Book BookA = bob.createBook("Dune");
    assertEquals(BookA.getClass(), book1.getClass(), "Identical Paperbooks should be identical");
}
public void ETime() {
    EBookFactory bob = new EBookFactory();
    Book BookA = bob.createBook("1984");
    assertEquals(BookA.getClass(), book2.getClass(), "Identical Ebooks should be identical");
}
public void AudioTime() {
    AudioBookFactory bob = new AudioBookFactory();
    Book BookA = bob.createBook("Dune");
    assertEquals(BookA.getClass(), book3.getClass(), "Identical Audiobooks should be identical");
}
public void nonExtandTime() {
    AudioBookFactory bob = new AudioBookFactory();
    Book BookA = bob.createBook("Dune");
    assertNotEquals(BookA.getClass(), book1.getClass(), "Books of different factories should not have the same type");
}
//I HAVE NO IDEA HOW TO TEST FOR UNSUPPORTED TYPES.
}
