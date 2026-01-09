package basics.test.JUnit.Hooks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.assertj.core.api.Assertions.assertThat;

// https://www.baeldung.com/junit-5-extensions
public class Hooks implements BeforeAllCallback, BeforeEachCallback {

  @Override
  public void beforeAll(ExtensionContext extensionContext) throws Exception {
    System.out.println("beforeAll");
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    System.out.println("beforeEach");
  }
}
