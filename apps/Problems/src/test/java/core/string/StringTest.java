package core.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringTest {

  @Test
  void nullIsNotEmptyTest() {

    String nullString, emptyString;
    Boolean expected, actual;

    nullString = new String(String.NULL_STRING);
    emptyString = new String(String.EMPTY_STRING);

    expected = Boolean.FALSE;
    actual = (nullString == emptyString);

    assertEquals(expected, actual);

  }

  @Test
  void nullDoesNotEqualsEmptyTest() {

    String nullString, emptyString;
    Boolean expected, actual;

    nullString = new String(String.NULL_STRING);
    emptyString = new String(String.EMPTY_STRING);

    expected = Boolean.FALSE;
    actual = (nullString.equals(emptyString));

    assertEquals(expected, actual);

  }


  @Test
  void whenEmptyThenIsEmptyTrueTest() {

    String emptyString;
    Boolean expected, actual;

    emptyString = new String(String.EMPTY_STRING);

    expected = Boolean.TRUE;

    // Implement a test catching Exception
    actual = emptyString.isEmpty();

    assertEquals(expected, actual);

  }

  @Disabled
  @Test
  void whenNullThenIsEmptyThrowsNullPointerException() {

    String nullString;
    Boolean expected, actual;

    nullString = new String(String.NULL_STRING);
    actual = nullString.isEmpty();

    expected = Boolean.FALSE;

    assertEquals(expected, actual);

  }

  @Test
  void lengthGiveLengthTest() {

    String string;
    int expectedLength, actualLength, def;

    string = new String("Foo");

    expectedLength = 3;
    actualLength = string.length();

    assertEquals(expectedLength, actualLength);

  }

  @Test
  void valueOfGiveStringTest() {

    String string;
    java.lang.String expectedValue, actualValue;
    int parameter;

    parameter = 3;

    string = new String();

    expectedValue = "3";
    actualValue = string.valueOf(parameter);

    assertEquals(expectedValue, actualValue);

  }

  @Nested
  @DisplayName("equals")
  class equalsTest {

    @Test
    @DisplayName("When same, Then returns true")
    void whenSameThenReturnTrue() {

      String string;
      java.lang.String firstTerm, secondTerm;
      Boolean expected, actual;

      firstTerm = "Foo";
      secondTerm = "Foo";

      string = new String(firstTerm);

      actual = string.equals(secondTerm);

      expected = Boolean.TRUE;

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("When different, Then returns true")
    void whenDifferentThenReturnFalse() {

      String string;
      java.lang.String firstTerm, secondTerm;
      Boolean expected, actual;

      firstTerm = "Foo";
      secondTerm = "foo";

      string = new String(firstTerm);

      actual = string.equals(secondTerm);

      expected = Boolean.FALSE;

      assertEquals(expected, actual);
    }

  }

  @Nested
  @DisplayName("compareTo")
  class compareToTest {

    @Test
    @DisplayName("When compared to previous, Then returns positive")
    void whenComparedToPreviousReturnsPositive() {

      String string;
      java.lang.String firstTerm, secondTerm;
      int actual;

      firstTerm = "Foo";
      secondTerm = "Bar";

      string = new String(firstTerm);

      actual = string.compareTo(secondTerm);

      assertTrue((actual > 0));

    }

    @Test
    @DisplayName("When compared to same, Then returns zero")
    void whenComparedToSameReturnsPositive() {

      String string;
      java.lang.String firstTerm, secondTerm;
      int actual;

      firstTerm = "Foo";
      secondTerm = "Foo";

      string = new String(firstTerm);

      actual = string.compareTo(secondTerm);

      assertTrue((actual == 0));

    }

    @Test
    @DisplayName("When compared to next, Then returns negative")
    void whenComparedToNextReturnsNegative() {

      String string;
      java.lang.String firstTerm, secondTerm;
      int actual;

      firstTerm = "Bar";
      secondTerm = "Foo";

      string = new String(firstTerm);

      actual = string.compareTo(secondTerm);

      assertTrue((actual < 0));

    }


  }



}
