package object.abstraction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class C4Test {

  private C4 c4;


  @BeforeEach
  void setUp() {

    c4 = new C4();
  }

  @DisplayName("When method exists in one class, Then it can still exists in another class")
  @Test
  void whenMethodExistsOneClassThenCanExistsAnotherClassTest() {

    String expectedMiddleName;
    String realMiddleName;

    expectedMiddleName = "MiddleName too";
    realMiddleName = c4.getMiddleName();

    assertEquals(expectedMiddleName, realMiddleName);

  }

}
