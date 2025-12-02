package lab5;


public class LibraryApp {

    // Create Controller, It will create an empty Library 
    private static LibrarianController librarian =  new LibrarianController();
    
    // Some functions for the Assignment
    private static void addMember(String name) {
        librarian.addMember(name);
    }    
    private static void addBook(String title) {
        librarian.addPaperBook(title);
    }
    //Added specific classes for when you want to add other types of books, paperBook
    //(Most similar to legacy Book class) remains the default so other code doesn't
    //need to be updated.
    private static void addAudioBook(String title) {
        librarian.addAudioBook(title); // To add AudioBooks
    }
    private static void addEBook(String title) {
        librarian.addEBook(title); // To add eBooks
    }
    private static void borrowBook(String title, String name) {
        librarian.borrowBookByMember(title, name);
    }
    private static void returnBook(String title, String name) {
        librarian.returnBookByMember(title, name);
    }
        
    public static void main(String[] args) {
                             
        System.out.println(" *** Library management system demo *** ");
        
        // Adding one book, see the Sequence diagram in the lab document.
        addBook("Dune");
        
        // TODO: Create three sequence diagrams for each of these method calls 
        addMember("Alice");             // 1. Add a member
        borrowBook("Dune", "Alice");      // 2. Borrow a book
        returnBook("Dune", "Alice");     // 3. Return book        
         
        // Adding some books to the catalog
        //Update (Rylan B) - Changed Moby Dick to an Ebook and added the Count of Monte
        //Cristo as an Audiobook to demonstrate functionality.
        System.out.println("\n *** Adding books to the library:");
        librarian.addPaperBook("Dune");
        librarian.addPaperBook("1984");
        librarian.addEBook("Moby Dick");
        librarian.addAudioBook("The Count of Monte Cristo");
        
        
        // Adding members to the library
        System.out.println("\n *** Adding members to the library:");
        librarian.addMember("Alice");
        librarian.addMember("Bob");
        
        //librarian.borrowBookByMember("Dune", "Alice");
        librarian.borrowBookByMember("1984", "Alice");
        librarian.borrowBookByMember("Moby Dick", "Bob");
        librarian.borrowBookByMember("Dune", "Bob"); // will be rejected
        
        //show to demonstrate that members that do not have a book will be unable to
        //return it.
        librarian.returnBookByMember("The Count of Monte Cristo", "Bob");
        //will be rejected.
        
        System.out.println("\n *** Books borrowed by Alice:");
        librarian.showMemberBooks("Alice");
        
        librarian.showMemberBooks("Bob");
        
        System.out.println("\n *** Book returned by Alice: Dune");
        librarian.returnBookByMember("Dune", "Alice");
        librarian.borrowBookByMember("Dune", "Bob"); // will be successful
        System.out.println("\n *** Books borrowed by Bob:");
        librarian.showMemberBooks("Bob");
    }
    
}
