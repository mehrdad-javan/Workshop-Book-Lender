package se.lexicon.model;


import java.util.Arrays;

public class Person {
    private static int sequencer = 0;

    private final int id;
    private String firstName;
    private String lastName;

    private Book[] borrowedBooks;

    public Person(String firstName, String lastName) {
        this.id = getNextId();
        this.borrowedBooks = new Book[0];
        setFirstName(firstName);
        setLastName(lastName);
    }

    public int getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("FirstName cannot be null");
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("LastName cannot be null");
        this.lastName = lastName;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }


    private static int getNextId() {
        return ++sequencer;
    }

    public void loanBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        if (!book.isAvailable()) throw new IllegalArgumentException("Book is not available");

        book.setBorrower(this);
        Book[] newArray = Arrays.copyOf(borrowedBooks, borrowedBooks.length + 1);
        newArray[newArray.length - 1] = book;
        borrowedBooks = newArray;

    }

    public void returnBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");

        Book[] newArray = new Book[borrowedBooks.length - 1];
        int counter = 0;
        for (Book elementArray : borrowedBooks) {
            if (elementArray.getId().equals(book.getId())) {
                book.setBorrower(null);
                continue;
            }
            newArray[counter++] = elementArray;
        }
        borrowedBooks = newArray;
    }

    public String getPersonInformation() {
        return "Person{ id=" + id + ", firstName='" + firstName + ", lastName='" + lastName +
                ",number of borrowedBooks=" + borrowedBooks.length + '}';
    }

}