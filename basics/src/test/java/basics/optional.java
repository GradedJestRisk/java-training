package basics;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

// https://www.baeldung.com/java-optional

@DisplayName("optional")
public class optional {

  @Nested
  @DisplayName("to check if a value is present")
  class present {

    @Nested
    @DisplayName("use #IsPresent")
    class isPresent {
      @Test
      @DisplayName("return false if not present")
      void present() {
        // Given
        Optional<String> value = Optional.empty();

        // When
        Boolean present = value.isPresent();

        // Then
        assertThat(present).isEqualTo(false);
      }

      @Test
      @DisplayName("return true if present")
      void missing() {
        // Given
        Optional<String> value = Optional.of("foo");

        // When
        Boolean present = value.isPresent();

        // Then
        assertThat(present).isEqualTo(true);
      }
    }
  }

  @Nested
  @DisplayName("to check a value is missing")
  class isMissing {

    @Nested
    @DisplayName("use #IsEmpty")
    class isEmpty {
      @Test
      @DisplayName("return true if missing")
      void present() {
        // Given
        Optional<String> value = Optional.empty();

        // When
        Boolean present = value.isEmpty();

        // Then
        assertThat(present).isEqualTo(true);
      }

      @Test
      @DisplayName("return false if present")
      void missing() {
        // Given
        Optional<String> value = Optional.of("foo");

        // When
        Boolean present = value.isEmpty();

        // Then
        assertThat(present).isEqualTo(false);
      }
    }
  }

  @Nested
  @DisplayName("to return a value if missing")
  class returnIfMissing {

    @Nested
    @DisplayName("use orElse")
    class display {
      @Test
      @DisplayName("return the value if present")
      void present() {
        // Given
        Optional<String> foo = Optional.of("foo");

        // When
        String actual = foo.orElse("bar");

        // Then
        assertThat(actual).isEqualTo("foo");
      }

      @Test
      @DisplayName("return the alternative if missing")
      void missing() {
        // Given
        Optional<String> empty = Optional.empty();

        // When
        String actual = empty.orElse("bar");

        // Then
        assertThat(actual).isEqualTo("bar");
      }
    }
  }
}
