package object.identity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookTest {

  private static String DEFAULT_TITLE = "Code";
  private static String DEFAULT_AUTHOR = "Charles Petzold";
  private static int DEFAULT_EDITION = 1;

  private Book book;

  private Book createBookWithDefaultValues() {

    String author;
    String title;
    int edition;

    Book localBook;

    author = DEFAULT_AUTHOR;
    title = DEFAULT_TITLE;
    edition = DEFAULT_EDITION;

    localBook = new Book(title, author, edition);
    return localBook;

  }

  @BeforeEach
  void setUp() {

    this.book = createBookWithDefaultValues();

  }

  @DisplayName("When toString is called, Then a proper formatted string is returned")
  @Test
  void testWhenToStringThenReturnFormattedString() {

    String expectedString;
    String realString;

    expectedString = "Book: " + DEFAULT_TITLE + " by " + DEFAULT_AUTHOR + ", edition n°" + Integer
        .toString(DEFAULT_EDITION);

    realString = book.toString();

    assertEquals(expectedString, realString);

  }

  @DisplayName("When a book is compared to something else, Then equals return false")
  @Test
  void testWhenCompareBookWithObjectThenReturnFalse() {

    Object object;
    Boolean equalsReal;

    object = new Object();
    equalsReal = book.equals(object);

    assertFalse(equalsReal);

  }

  @DisplayName("When a book is compared to a different book, Then equals return false")
  @Test
  void testWhenCompareBookWithDifferentBookThenReturnFalse() {

    Boolean equalsReal;
    int edition;
    Book anotherBook;

    edition = BookTest.DEFAULT_EDITION + 1;

    anotherBook = createBookWithDefaultValues();
    anotherBook.setEdition(edition);

    equalsReal = book.equals(anotherBook);

    assertFalse(equalsReal);

  }

  @DisplayName("When a book is compared to same book, Then equals return true")
  @Test
  void testWhenCompareBookWithSameBookThenReturnTrue() {

    Boolean equalsReal;

    Book anotherBook;

    anotherBook = createBookWithDefaultValues();

    equalsReal = book.equals(anotherBook);

    assertTrue(equalsReal);


  }

}
