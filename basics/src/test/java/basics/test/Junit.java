package basics.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Junit")
public class Junit {

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

  @Nested
  @DisplayName("Parameterized test")
  class Parameterized {

    // https://mikemybytes.com/2021/10/19/parameterize-like-a-pro-with-junit-5-csvsource/

    @Nested
    @DisplayName("Using formats")
    class Format {

      @DisplayName("length() returns the number of characters in a string:")
      @ParameterizedTest(name = "on \"{0}\", should return {1} [{index}]")
      @CsvSource({"hello world, 11", "JUnit 5,      7"})
      void calculatesPhraseLength(String phrase, int expected) {
        // When
        int actual = phrase.length();

        // Then
        assertThat(actual).isEqualTo(expected);
      }
    }
  }
}
