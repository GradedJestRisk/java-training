package basics.text;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("#text")
class textTest {

    @DisplayName("block text")
    @Nested
    class BlockTest {

        @DisplayName("it should escape JSON")
        @Test
        void test1() {

            // when
            String plainJson = """
                    {"foo":"bar"}""";

            // then
            assertEquals(plainJson, "{\"foo\":\"bar\"}");
        }
    }
}
