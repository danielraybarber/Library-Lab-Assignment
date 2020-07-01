import java.util.ArrayList;


public class Library {
    // Add the missing implementation to this class
	
	String address;
	static ArrayList<Book> booksAvailable = new ArrayList<>();
	ArrayList<Book> booksBorrowed = new ArrayList<>();
	static String hours = "Libraries are open daily from 9am to 5pm.";


	public Library(String address) {
    	this.address = address;
	}
	
	private void addBook(Book bookTitle) {
		booksAvailable.add(bookTitle);
	}
	
	private static void printOpeningHours() {
		System.out.println(hours);
	}
	
	
	private void printAddress() {
		System.out.println(address);
	}
	
	private void borrowBook(Book bookTitle) {
		
		if(!booksBorrowed.contains(bookTitle)) {
			System.out.println(bookTitle +" was successfully borrowed.");
			booksAvailable.remove(bookTitle);
			booksBorrowed.add(bookTitle);		
		}else {
			System.out.println(bookTitle + " was not available.");
		}
		
	}

	
	private void printAvailableBooks() {
		System.out.println(booksAvailable);
	}
	
	private void returnBook(Book bookTitle) {
		booksBorrowed.remove(bookTitle);
		booksAvailable.add(bookTitle);
	}

	
	public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook(new Book("The Lord of the Rings"));
        firstLibrary.borrowBook(new Book("The Lord of the Rings"));
        secondLibrary.borrowBook(new Book("The Lord of the Rings"));
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook(new Book("The Lord of the Rings"));
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();

       
    }
	
} 