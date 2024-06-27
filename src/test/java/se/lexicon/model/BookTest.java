package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Book;
import se.lexicon.model.Person;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;
    private Person person;

    @BeforeEach
    void setUp() {
        book = new Book("1984", "George Orwell");
        person = new Person("Mehrdad", "Javan");
    }

    @Test
    void testBookConstructor() {
        assertNotNull(book.getId());
        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertTrue(book.isAvailable());
        assertNull(book.getBorrower());
    }

    @Test
    void testBookConstructorWithBorrower() {
        Book bookWithBorrower = new Book("Brave New World", "Aldous Huxley", person);
        assertNotNull(bookWithBorrower.getId());
        assertEquals("Brave New World", bookWithBorrower.getTitle());
        assertEquals("Aldous Huxley", bookWithBorrower.getAuthor());
        assertFalse(bookWithBorrower.isAvailable());
        assertEquals(person, bookWithBorrower.getBorrower());
    }

    @Test
    void testSetBorrower() {
        book.setBorrower(person);
        assertFalse(book.isAvailable());
        assertEquals(person, book.getBorrower());
        
        book.setBorrower(null);
        assertTrue(book.isAvailable());
        assertNull(book.getBorrower());
    }

    @Test
    void testGetBookInformation() {
        String expectedInfo = String.format("Book{ id=%s, title=1984, author=George Orwell, available=true, borrower=- }", book.getId());
        assertEquals(expectedInfo, book.getBookInformation());

        book.setBorrower(person);
        expectedInfo = String.format("Book{ id=%s, title=1984, author=George Orwell, available=false, borrower= PersonId: %d }", book.getId(), person.getId());
        assertEquals(expectedInfo, book.getBookInformation());
    }
}
