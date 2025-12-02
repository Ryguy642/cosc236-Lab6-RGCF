package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Library;
import lab5.Book;
import lab5.BorrowingService;
import lab5.Member;
import lab5.PaperBook;



class TestSingletonBorrowing {
    
    private Library library;
    @Test void TestSingletonBorrowing() { 
    BorrowingService service1 = BorrowingService.getInstance();
BorrowingService service2 = BorrowingService.getInstance();
assertEquals(service1, service2,"Two Singleton instances detected");
  
}
}
