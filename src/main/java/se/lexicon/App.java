package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        // Create a book instance
        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("SQL", "John Doe");

        // Display book information
        System.out.println("Book information:");
        System.out.println(book1.getBookInformation());
        System.out.println(book2.getBookInformation());
        System.out.println();

        // Create a person instance
        Person person1 = new Person("Alice", "Smith");

        // Display person information
        System.out.println("Person information:");
        System.out.println(person1.getPersonInformation());
        System.out.println();

        // Loan a book to the person
        person1.loanBook(book1);

        // Display person information after borrowing a book
        System.out.println("Person information after borrowing a book:");
        System.out.println(person1.getPersonInformation());
        System.out.println();

        // Display book information after borrowing a book
        System.out.println("Book information:");
        System.out.println(book1.getBookInformation());
        System.out.println(book2.getBookInformation());
        System.out.println();


        // Return the borrowed book
        person1.returnBook(book1);

        // Display person information after returning the book
        System.out.println("Person information after returning the book:");
        System.out.println(person1.getPersonInformation());

    }

}
