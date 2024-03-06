package basics.text;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


//String iReallyLikeThisStory = """
//    "When I use a word," Humpty Dumpty said,
//    in rather a scornful tone, "it means just what I
//    choose it to mean - neither more nor less."
//    "The question is," said Alice, "whether you
//    can make words mean so many different things."
//    "The question is," said Humpty Dumpty,
//    "which is to be master - that's all."
//    """;    // Note the newline before the closing delimiter

@DisplayName("#text")
public class TextTest {

    @DisplayName("TextBlock")
    @Nested
    class TextBlockTest {

//        https://www.baeldung.com/java-text-blocks

        @DisplayName("it preserves indentation")
        @Test
        void test6() {

            // when
            String actual =  """
                             <html>
                                 <body>
                                     <span>foo</span>
                                 </body>
                             </html>""";

            // then
            String expected = "<html>\n" +
                              "    <body>\n" +
                              "        <span>foo</span>\n" +
                              "    </body>\n" +
                              "</html>";

            assertEquals(expected, actual);
        }


        @DisplayName("it should ignore spaces by default")
        @Test
        void test5() {

            // when
            String actual = """
                    i am followed by four spaces but nobody cares    """;

            // then
            String expected = "i am followed by four spaces but nobody cares";

            assertEquals(expected, actual);
        }

        @DisplayName("it should allow comparing spaces explicitly using \\s")
        @Test
        void test4() {

            // when
            String actual = """
                    i am followed by four spaces    \s""";

            // then
            String expected = "i am followed by four spaces     ";

            assertEquals(expected, actual);
        }


        @DisplayName("it should allow writing one line on several lines with \\")
        @Test
        void test0() {

            // when
            String actual = """
                    a really \
                    long string on a single line""";

            // then
            String expected = "a really long string on a single line";

            assertEquals(expected, actual);
        }

        @DisplayName("it should escape double quotes, as in JSON")
        @Test
        void test1() {

            // when
            String actual = """
                    {"foo":"bar"}""";

            // then
            String expected = "{\"foo\":\"bar\"}";
            ;
            assertEquals(expected, actual);
        }


        @DisplayName("it should escape triple quotes with a single slash")
        @Test
        void test2() {

            // when
            String actual = """
                    triple quotes `\"""` may sometimes be useful in bash scripts""";

            // then
            String expected = "triple quotes `\"\"\"` may sometimes be useful in bash scripts";
            ;
            assertEquals(expected, actual);
        }

        @DisplayName("it should escape four quotes with two slashes")
        @Test
        void test3() {

            // when
            String actual = """
                    four consecutive quotes `\"""\"` may sometimes look useful in bash scripts, but you should consider use another programing language""";

            // then
            String expected = "four consecutive quotes `\"\"\"\"` may sometimes look useful in bash scripts, but you should consider use another programing language";
            ;
            assertEquals(expected, actual);
        }
    }
}

