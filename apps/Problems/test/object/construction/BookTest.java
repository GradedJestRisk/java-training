package object.construction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BookTest {

  private Book book;

  @DisplayName("Given constructed with no parameter")
  @Nested
  class WhenConstructedWithNoParameter {

    @BeforeEach
    void setUp() {
      book = new Book();
    }

    @DisplayName("Then default constructor is called")
    @Test
    void testWhenConstructedWithoutParameterThenDefaultConstructorIsCalled() {

      String expectedTitle;
      String expectedAuthor;

      String realTitle;
      String realAuthor;

      expectedTitle = Book.DEFAULT_TITLE;
      expectedAuthor = Book.DEFAULT_AUTHOR;

      realTitle = book.getTitle();
      realAuthor = book.getAuthor();

      assertEquals(expectedTitle, realTitle);
      assertEquals(expectedAuthor, realAuthor);

    }

    @DisplayName("Then initialization bloc is executed")
    @Test
    void testWhenConstructedNoParameterThenInitializationBlockIsExecuted() {

      int expectedPageCount;
      int realPageCount;

      expectedPageCount = Book.DEFAULT_PAGE_COUNT;

      realPageCount = book.getPageCount();

      assertEquals(expectedPageCount, realPageCount);

    }

  }

  @DisplayName("Given constructed with some parameter")
  @Nested
  class WhenConstructedWithParameter {

    @DisplayName("When one parameter, Then initialization bloc is executed")
    @Test
    void testWhenConstructedThenInitializationBlockIsExecuted() {

      String title;
      title = "Learning Perl";

      int expectedPageCount;
      int realPageCount;

      book = new Book(title);

      expectedPageCount = Book.DEFAULT_PAGE_COUNT;

      realPageCount = book.getPageCount();

      assertEquals(expectedPageCount, realPageCount);

    }

    @DisplayName("When one parameter, Then one parameter constructor is called")
    @Test
    void testWhenConstructedOneParameterThenOneParameterConstructorIsCalled() {

      String expectedTitle;
      String realTitle;

      expectedTitle = "Learning Perl";

      book = new Book(expectedTitle);

      realTitle = book.getTitle();

      assertEquals(expectedTitle, realTitle);

    }


    @DisplayName("When two parameters, Then chained one parameter constructor is called")
    @Test
    void testWhenConstructedWithTwoParameterThenChainedOneParameterConstructorIsCalled() {

      String expectedTitle;
      String expectedAuthor;

      String realTitle;
      String realAuthor;

      expectedTitle = "The man-month myth";
      expectedAuthor = "Frederic Brooks";

      book = new Book(expectedTitle, expectedAuthor);

      realAuthor = book.getAuthor();

      assertEquals(expectedAuthor, realAuthor);
    }

    @DisplayName("When two parameters, Then two parameter constructor is called")
    @Test
    void testWhenConstructedWithTwoParameterThenTwoParameterConstructorIsCalled() {

      String expectedTitle;
      String expectedAuthor;

      String realTitle;
      String realAuthor;

      expectedTitle = "The man-month myth";
      expectedAuthor = "Frederic Brooks";

      book = new Book(expectedTitle, expectedAuthor);

      realAuthor = book.getAuthor();

      assertEquals(expectedAuthor, realAuthor);
    }

  }


}

