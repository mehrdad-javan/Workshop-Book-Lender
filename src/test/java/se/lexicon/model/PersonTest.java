package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class PersonTest {

    private Person person;
    private Book book;

    @BeforeEach
    void setUp() {
        person = new Person("Mehrdad", "Javan");
        book = new Book("1984", "George Orwell");
    }


    @Test
    @Order(2)
    void testSetFirstName() {
        person.setFirstName("Mehrdad");
        assertEquals("Mehrdad", person.getFirstName());

        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(null));
    }

    @Test
    @Order(3)
    void testSetLastName() {
        person.setLastName("Javan");
        assertEquals("Javan", person.getLastName());

        assertThrows(IllegalArgumentException.class, () -> person.setLastName(null));
    }

    @Test
    @Order(4)
    void testLoanBook() {
        person.loanBook(book);
        assertFalse(book.isAvailable());
        assertEquals(person, book.getBorrower());
        assertEquals(1, person.getBorrowedBooks().length);
        assertEquals(book, person.getBorrowedBooks()[0]);
    }

    @Test
    @Order(5)
    void testLoanBookWhenNotAvailable() {
        book.setBorrower(new Person("Jane", "Doe"));
        assertThrows(IllegalArgumentException.class, () -> person.loanBook(book));
    }

    @Test
    @Order(6)
    void testReturnBook() {
        person.loanBook(book);
        person.returnBook(book);
        assertTrue(book.isAvailable());
        assertNull(book.getBorrower());
        assertEquals(0, person.getBorrowedBooks().length);
    }

    @Test
    @Order(7)
    void testReturnBookNotBorrowed() {
        assertThrows(IllegalArgumentException.class, () -> person.returnBook(null));
    }

}
