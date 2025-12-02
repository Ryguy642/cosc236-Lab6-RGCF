package lab5;
import java.util.*;

public class LibrarianController {
    
    /* WTH is this? WHY?
     * 3. Update the LibrarianController class to include three members, one for each type of
BookFactory. Initialize these members in the constructor.
     */
    private Library library; // Library dependency
    private BorrowingService borrowingService; // Singleton
    private PaperBookFactory PFac;
     private EBookFactory EFac;
     private AudioBookFactory AFac;
    public LibrarianController( ) {
        this.library = new Library(); // Constructor injection
        //Holds the single instance of borrowingService
        this.borrowingService = BorrowingService.getInstance();
        
        //Holds garbage members for some reason
        this.addMember("Secret Wizard who likes Paperbooks");
        this.addMember("Secret Warlock who likes Audiobooks");
        this.addMember("Secret Witch who likes EBooks");
        this.PFac = new PaperBookFactory();
        this.EFac = new EBookFactory();
        this.AFac = new AudioBookFactory();
    }
    public Library getLibrary() {
        return this.library;
    }
    public void showBooks() {
        library.showBooks();
    }
    public void showMembers() {
        library.showMembers();
    }
    
    //Specify Book type in this method
    public void addPaperBook(String title) {
        addBook(PFac, title);  // Book class constructor dependency
    }
    public void addEBook(String title) {
        addBook(EFac, title);  // Book class constructor dependency
    }
    public void addAudioBook(String title) {
        addBook(AFac, title);  // Book class constructor dependency
    }
    
    public void addBook(BookFactory factory, String title) {
library.addBook(factory.createBook(title)); // Book type depends on
 // the factory passed in
}

    public void addMember(String name) {
        library.addMember(new Member(name, borrowingService)); // Member class constructor dependency
    }
    public void removeBook(String title) {
        library.removeBook(title); // remove 
    }
    public void removeMember(String name) {
        library.removeMember(name);
    }
    public void showMember(String name) {
        Member member = library.findMemberByName(name);
        if (member != null)
            System.out.println(member);
        else 
            System.out.println("Member " + name + " not found.");
    }
    public void showBook(String title) {
        Book book = library.findBookByTitle(title);
        if (book != null)
            System.out.println(book);
        else 
            System.out.println("Book " + title + " not found.");
    }
    public void showMemberBooks(String name) {
        Member member = library.findMemberByName(name);
        if (member != null)
            member.listBorrowedBooks();
        else 
            System.out.println("Member " + name + " not found.");
    }
    
    public void borrowBookByMember(String title, String name) {
        Member member = library.findMemberByName(name); // use library for search
        Book book = library.findBookByTitle(title);  // use library for search
        if (book != null && member != null)
            member.borrowBook(book); // member borrows a book, not library 
        else     
            System.out.println("Either book " + title + " or member " + name + " not found.");
    }
    
    public void returnBookByMember(String title, String name) {
        Member member = library.findMemberByName(name); // use library for search
        Book book = library.findBookByTitle(title); // use library for search 
        if (book != null && member != null)
            member.returnBook(book); // members returns book. 
        else      
            System.out.println("Either book " + title + " or member " + name + " not found.");
    }
}
