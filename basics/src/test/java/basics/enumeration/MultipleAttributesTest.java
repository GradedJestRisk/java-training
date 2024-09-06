package basics.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MultipleAttributesTest {

  @DisplayName("Properties")
  @Nested
  class properties {

    @DisplayName("you can access to properties using get")
    @Test
    public void usingGet() {
      // Given

      // When
      MultipleAttributes one = MultipleAttributes.ONE;

      // Then
      assertThat(one.getIdentifier()).isEqualTo(1);
      assertThat(one.getName()).isEqualTo("Jane");
    }
  }

  @DisplayName("Lookup")
  @Nested
  class lookup {

    @DisplayName("returns an element")
    @Test
    public void lookupExists() {
      // Given

      // When
      MultipleAttributes one = MultipleAttributes.findByName("Jane");

      // Then
      assertThat(one.getIdentifier()).isEqualTo(1);
      assertThat(one.getName()).isEqualTo("Jane");
    }

    @DisplayName("returns null if element does not exists")
    @Test
    public void lookupNotExists() {
      // Given

      // When
      MultipleAttributes one = MultipleAttributes.findByName("JANE");

      // Then
      assertThat(one).isNull();
    }
  }
}
