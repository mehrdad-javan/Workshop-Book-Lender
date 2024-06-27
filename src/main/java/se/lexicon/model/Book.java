package se.lexicon.model;

import java.util.Objects;
import java.util.UUID;


public class Book {
    private final String id;
    private final String title;
    private final String author;
    private boolean available;
    private Person borrower;

    public Book(String title, String author) {
        this.id = UUID.randomUUID().toString();
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.author = Objects.requireNonNull(author, "Author cannot be null");
        this.available = true;
    }

    public Book(String title, String author, Person borrower) {
        this(title, author);
        setBorrower(borrower);
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public Person getBorrower() {
        return borrower;
    }


    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        this.available = (borrower == null);
    }


    /*public String getBookInformation() {
        return "Book{ id=" + id + ", title=" + title + ", author=" + author + ", available=" + available +
                ", borrower=" + (borrower != null ? " PersonId: " + borrower.getPersonId() : "-") + " } ";
    }*/

    public String getBookInformation() {
        String borrowerInfo = borrower != null ? " PersonId: " + borrower.getId() : "-";
        return String.format("Book{ id=%s, title=%s, author=%s, available=%b, borrower=%s }", id, title, author, available, borrowerInfo);
    }

}