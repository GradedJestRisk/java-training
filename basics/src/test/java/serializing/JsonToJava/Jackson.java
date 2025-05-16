package serializing.JsonToJava;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("jackson")
public class Jackson {

  @Nested
  @DisplayName("deserialize a record")
  class Record {

    @Nested
    @DisplayName("#writeValueAsString")
    class writeValueAsString {

      @Nested
      @DisplayName("when property is primitive")
      class Primitive {

        // https://www.baeldung.com/jackson-object-mapper-tutorial
        @Test
        @DisplayName("should instantiate a record")
        void returnRecord() throws JsonProcessingException {
          // Given
          record Person(int id, String nickname) {}
          String json =
              """
                            {"id":1,"nickname":"dorothy"}""";
          ObjectMapper objectMapper = new ObjectMapper();

          // When
          Person actual = objectMapper.readValue(json, Person.class);

          // Then
          Person expected = new Person(1, "dorothy");
          assertThat(actual).isEqualTo(expected);
        }
      }

      @Nested
      @DisplayName("when JSON is multi-line")
      class MultiLine {
        @Test
        @DisplayName("should instantiate a record")
        void returnRecord() throws JsonProcessingException {
          // Given
          record Person(int id, String nickname) {}
          String json =
              """
              {
                "id": 1,
                "nickname": "dorothy"
              }""";
          ObjectMapper objectMapper = new ObjectMapper();

          // When
          Person actual = objectMapper.readValue(json, Person.class);

          // Then
          Person expected = new Person(1, "dorothy");
          assertThat(actual).isEqualTo(expected);
        }
      }

      @Nested
      @DisplayName("when JSON key is contains hyphens")
      class Hyphens {
        @Test
        @DisplayName("should instantiate a record removing hyphens")
        void returnRecord() throws JsonProcessingException {
          // Given
          record Person(int id, @JsonProperty("nick-name") String nickname) {}
          String json =
              """
                  {
                    "id": 1,
                    "nick-name": "dorothy"
                  }""";
          ObjectMapper objectMapper = new ObjectMapper();

          // When
          Person actual = objectMapper.readValue(json, Person.class);

          // Then
          Person expected = new Person(1, "dorothy");
          assertThat(actual).isEqualTo(expected);
        }
      }
    }
  }
}
