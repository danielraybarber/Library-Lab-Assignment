import java.util.ArrayList;
import java.util.List;


public class Library {
    // Add the missing implementation to this class
	
	
	String address;
	private final List<Book> booksList = new ArrayList<>();
	static String hours = "Libraries are open daily from 9am to 5pm.";


	public Library(String address) {
    	this.address = address;
	}
	
	private void addBook(Book bookTitle) {
		booksList.add(bookTitle);
	}
	
	private static void printOpeningHours() {
		System.out.println(hours);
	}
	
	
	private void printAddress() {
		System.out.println(address);
	}
	
	private void borrowBook(String Title) {
		boolean stop = false;
        for (Book book : booksList) {
            if (Title.equals(book.getTitle()) && !book.isBorrowed()) {
                System.out.println("You successfully borrowed " + Title);
                book.borrowed();
                stop = true;
            } else if (Title.equals(book.getTitle()) && book.isBorrowed()) {
                System.out.println("Sorry, " + Title +" is already borrowed.");
                stop = true;
            }
        }
        if (!stop) {
            System.out.println("Sorry, " + Title + " is not in our catalog. ");
        }
		
	}

	private void printAvailableBooks() {
		if (!booksList.isEmpty()) {
            for (Book book : booksList) {
                if (!book.isBorrowed()) {
                    System.out.println(book.getTitle());
                }
            }
        } else {
            System.out.println("No books in catalog.");
        }
    }


	
	private void returnBook(String Title) {
		for (Book book : booksList) {
            if (Title.equals(book.getTitle()) && book.isBorrowed()) {
                System.out.println("You successfully returned " + Title);
                book.returned();
            }
        }
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
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
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
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();

       
    }
	
} 