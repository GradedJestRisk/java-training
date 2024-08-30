package basics.test;

import basics.People;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class AssertJ {

  @DisplayName("List of objects")
  @Nested
  class ListOfObjects {

    @DisplayName("To check if objects are the same")
    @Nested
    class ObjectEquality {

      @DisplayName("use isEqualTo")
      @Test
      void isEqualTo() {
        // Given
        People john = new People("John", 10);
        People jane = new People("Jane", 12);
        List<People> expected = List.of(john, jane);

        // When
        List<People> actual = List.of(john, jane);

        // Then
        assertThat(actual).isEqualTo(expected);
      }

      @DisplayName("use #containsExactlyInAnyOrder if order does not matter")
      @Test
      void containsExactlyInAnyOrder() {
        // Given
        People john = new People("John", 10);
        People jane = new People("Jane", 12);

        // When
        List<People> actual = List.of(john, jane);

        // Then
        assertThat(actual).containsExactlyInAnyOrder(jane, john);
      }
    }

    @DisplayName("To check object properties equality")
    @Nested
    class ContentEquality {

      @DisplayName("use #usingRecursiveComparison")
      @Test
      void usingRecursiveComparison() {
        // Given
        List<People> expected = List.of(new People("John", 10), new People("Jane", 12));

        // When
        List<People> actual = List.of(new People("John", 10), new People("Jane", 12));

        // Then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
      }
    }
  }
}
