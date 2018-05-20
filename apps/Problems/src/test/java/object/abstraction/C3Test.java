package object.abstraction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class C3Test {

  private C3 c3;

  @BeforeEach
  void setUp() {

    c3 = new C3();
  }

  @DisplayName("When method does not exist in parent, Then it can be implemented")
  @Test
  void whenMethodDoesNotExitsParentThenCanBeImplementedTest() {

    String expectedMiddleName;
    String realMiddleName;

    expectedMiddleName = "MiddleName";
    realMiddleName = c3.getMiddleName();

    assertEquals(expectedMiddleName, realMiddleName);

  }


}
