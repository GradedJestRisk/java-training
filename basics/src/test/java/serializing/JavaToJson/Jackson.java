package serializing.JavaToJson;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@DisplayName("jackson")
public class Jackson {

  @Nested
  @DisplayName("serialize a record")
  class Record {

    @Nested
    @DisplayName("#writeValueAsString")
    class writeValueAsString {

      @Nested
      @DisplayName("when property is primitive")
      class Primitive {

        // https://www.baeldung.com/jackson-object-mapper-tutorial

        @Test
        @DisplayName("should return a string")
        void returnString() throws JsonProcessingException {
          // Given
          record Person(int id, String nickname) {}
          Person dorothy = new Person(1, "dorothy");
          ObjectMapper objectMapper = new ObjectMapper();

          // When
          String actual = objectMapper.writeValueAsString(dorothy);

          // Then
          String expected =
              """
                        {"id":1,"nickname":"dorothy"}""";
          assertThat(actual).isEqualTo(expected);
        }
      }

      @Nested
      @DisplayName("when property is not primitive")
      class NotPrimitive {

        @Nested
        @DisplayName("when property is date")
        class Date {

          // https://www.baeldung.com/jackson-serialize-dates

          @Test
          @DisplayName("should return a string")
          void returnString() throws JsonProcessingException {
            // Given
            record Person(int id, LocalDate birth) {}
            Person dorothy = new Person(1, LocalDate.of(1949, 4, 11));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            // When
            String actual = objectMapper.writeValueAsString(dorothy);

            // Then
            String expected =
                """
                            {"id":1,"birth":"1949-04-11"}""";
            assertThat(actual).isEqualTo(expected);
          }
        }
      }
    }
  }

  @Nested
  @DisplayName("serialize an object")
  class Object {

    @Nested
    @DisplayName("#writeValueAsString")
    class writeValueAsString {

      @Nested
      @DisplayName("when property is public")
      class Public {

        @Test
        @DisplayName("should return a string")
        void returnString() throws JsonProcessingException {
          // Given
          class Person {
            public int id;
            public String nickname;

            Person(int id, String nickname) {
              this.id = id;
              this.nickname = nickname;
            }
          }
          Person dorothy = new Person(1, "dorothy");
          ObjectMapper objectMapper = new ObjectMapper();

          // When
          String actual = objectMapper.writeValueAsString(dorothy);

          // Then
          String expected =
              """
                            {"id":1,"nickname":"dorothy"}""";
          assertThat(actual).isEqualTo(expected);
        }
      }

      @Nested
      @DisplayName("when property is private")
      class Private {

        @Nested
        @DisplayName("using @JsonAutoDetect annotation")
        class Annotation {

          @Test
          @DisplayName("should return a string")
          void returnString() throws JsonProcessingException {
            // Given
            @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
            class Person {
              int id;
              String nickname;

              Person(int id, String nickname) {
                this.id = id;
                this.nickname = nickname;
              }
            }
            Person dorothy = new Person(1, "dorothy");
            ObjectMapper objectMapper = new ObjectMapper();

            // When
            String actual = objectMapper.writeValueAsString(dorothy);

            // Then
            String expected =
                """
                                {"id":1,"nickname":"dorothy"}""";
            assertThat(actual).isEqualTo(expected);
          }
        }

        @Nested
        @DisplayName("using setVisibility to ANY on the object mapper")
        class SetVisibility {

          @Test
          @DisplayName("should return a string")
          void returnString() throws JsonProcessingException {
            // Given
            class Person {
              int id;
              String nickname;

              Person(int id, String nickname) {
                this.id = id;
                this.nickname = nickname;
              }
            }
            Person dorothy = new Person(1, "dorothy");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            // When
            String actual = objectMapper.writeValueAsString(dorothy);

            // Then
            String expected =
                """
                                {"id":1,"nickname":"dorothy"}""";
            assertThat(actual).isEqualTo(expected);
          }
        }
      }
    }
  }
}
