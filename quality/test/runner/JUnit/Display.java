package basics.test.JUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Junit")
public class Display {

  @Nested
  @DisplayName("Nested test")
  class nested {

    @Nested
    @DisplayName("Using display name")
    class display {
      @Test
      @DisplayName("For test")
      void test() {
        assertThat(true).isEqualTo(true);
      }
    }
  }
}
