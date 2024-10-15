package basics.test.JUnit.Hooks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

@ExtendWith({Hooks.class})
// Does not work
// public class Tests extends  Hooks{
public class Tests {

  @Test
  @DisplayName("First test")
  void first() {
    System.out.println("First test");
  }

  @Test
  @DisplayName("Second test")
  void second() {
    System.out.println("Second test");
  }
}
