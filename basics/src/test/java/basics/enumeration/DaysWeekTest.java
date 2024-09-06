package basics.enumeration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DaysWeekTest {

  @DisplayName("Access values")
  @Nested
  class AccessValues {

    @DisplayName("you can point to a single value")
    @Nested
    class SingleValue {

      @DisplayName("using dot (.)")
      @Test
      public void singleValueDot() {
        // Given
        DaysWeek tuesday = DaysWeek.TUESDAY;

        // When
        DaysWeek monday = DaysWeek.MONDAY;

        // Then
        assertThat(monday).isNotEqualTo(tuesday);
      }

      @DisplayName("using valueOf()")
      @Test
      public void singleValueValueOf() {
        // Given
        DaysWeek one = DaysWeek.MONDAY;

        // When
        DaysWeek two = DaysWeek.valueOf("MONDAY");

        // Then
        assertThat(one).isEqualTo(two);
      }
    }

    @DisplayName("you can get all values")
    @Nested
    class AllValues {

      @DisplayName("using values()")
      @Test
      public void allValues() {
        // Given
        // When
        DaysWeek[] list = DaysWeek.values();

        // Then
        assertThat(list.length).isEqualTo(3);
        assertThat(list).contains(DaysWeek.MONDAY);
      }
    }
  }
}
