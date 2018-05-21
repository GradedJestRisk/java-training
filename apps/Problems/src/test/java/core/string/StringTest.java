package core.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringTest {

  @Test
  void nullIsNotEmptyTest() {

    String nullString, emptyString;
    Boolean expected, obtained;

    nullString = new String(String.NULL_STRING);
    emptyString = new String(String.EMPTY_STRING);

    expected = Boolean.FALSE;
    obtained = (nullString == emptyString);

    assertEquals(expected, obtained);

  }

  @Test
  void nullDoesNotEqualsEmptyTest() {

    String nullString, emptyString;
    Boolean expected, obtained;

    nullString = new String(String.NULL_STRING);
    emptyString = new String(String.EMPTY_STRING);

    expected = Boolean.FALSE;
    obtained = (nullString.equals(emptyString));

    assertEquals(expected, obtained);

  }

  @Test
  void whenEmptyThenIsEmptyTrueTest() {

    String emptyString;
    Boolean expected, obtained;

    emptyString = new String(String.EMPTY_STRING);

    expected = Boolean.TRUE;

    // Implement a test catching Exception
    obtained = emptyString.isEmpty();

    assertEquals(expected, obtained);

  }

  @Disabled
  @Test
  void whenNullThenIsEmptyFalseTest() {

    String nullString;
    Boolean expected, obtained;

    nullString = new String(String.NULL_STRING);
    obtained = nullString.isEmpty();

    expected = Boolean.FALSE;

    assertEquals(expected, obtained);

  }

  @Test
  void lengthGiveLengthTest() {

    String string;
    int expectedLength, obtainedLength, def;

    string = new String("Foo");

    expectedLength = 3;
    obtainedLength = string.length();

    assertEquals(expectedLength, obtainedLength);

  }

  @Test
  void valueOfGiveStringTest() {

    String string;
    java.lang.String expectedValue, obtainedValue;
    int parameter;

    parameter = 3;

    string = new String();

    expectedValue = "3";
    obtainedValue = string.valueOf(parameter);

    assertEquals(expectedValue, obtainedValue);

  }


}
