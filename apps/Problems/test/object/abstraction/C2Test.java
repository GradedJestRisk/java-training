package object.abstraction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class C2Test {

  //    C1 is abstract, so can't be instantiated
//    We'll use a heir instead
//    C1 c1;
  private C2 c2;

  @BeforeEach
  void setUp() {

    c2 = new C2();
  }

  @DisplayName("When parent is abstract, Then its method can only be tested from an heir")
  @Test
  void whenParentAbstractTestMethodFromHeirTest() {

    String expectedName;
    String realName;

    expectedName = "Name";
    realName = c2.getName();

    assertEquals(expectedName, realName);

  }

  @DisplayName("When method is implemented, Then it can be called")
  @Test
  void whenMethodImplementedThenMethodCanBeCalledTest() {

    String expectedSurname;
    String realSurname;

    expectedSurname = "Surname";
    realSurname = c2.getSurname();

    assertEquals(expectedSurname, realSurname);

  }


}
