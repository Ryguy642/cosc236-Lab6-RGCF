package lab5;

public interface BorrowingServiceAPI {

    String toString();
    BorrowingBookResult borrowBook();
    BorrowingBookResult returnBook();
}
