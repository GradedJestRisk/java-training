package HelloGradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GreeterTest {
    @Test public void greetSaysHelloToName() {
        // given
        Greeter greeter = new Greeter();
        String name = "bar";

        // when
        String greet = greeter.greet(name);

        // then
        assertEquals("Hello, bar!", greet);
    }
}
