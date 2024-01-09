package records;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

// https://www.baeldung.com/java-record-keyword
@DisplayName("#record")
class recordTest {

  @DisplayName("it should be instantiated")
  @Test
  void test1() {

    // given
    record Person(String name) {}
    ;

    // when
    Person john = new Person("john");

    // then
    assertEquals(john.name(), "john");
  }

  @DisplayName("it cannot be mutated")
  @Test
  void test2() {

    // given
    record Person(String name) {}
    ;
    Person john = new Person("john");

    // when
    // Cannot assign a value to final variable 'name'
    //      john.name = "Mary";

    // then
    assertEquals(john.name(), "john");
  }

  @DisplayName("it can be compared")
  @Nested
  class comparison {
    @DisplayName("using equals")
    @Test
    void test3() {

      // given
      record Person(String name) {}
      ;
      Person johnDoe = new Person("john");
      Person johnWayne = new Person("john");

      // when
      // then
      assertEquals(johnDoe, johnWayne);
    }

    @DisplayName("using hasCode")
    @Test
    void test3b() {

      // given
      record Person(String name) {}
      ;
      Person johnDoe = new Person("john");
      Person johnWayne = new Person("john");

      // when
      // then
      assertEquals(johnDoe.hashCode(), johnWayne.hashCode());
    }
  }

  @DisplayName("it can be serialized")
  @Test
  void test4() {

    // given
    record Person(String name) {}
    ;
    Person john = new Person("john");

    // when
    String data = john.toString();

    // then
    assertEquals(data, "Person[name=john]");
  }
}
