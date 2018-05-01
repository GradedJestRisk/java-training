package training.test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;


import training.language.problems.oo.Circle;
import training.language.problems.oo.ZeroOrNegativeRadiusException;

class CircleTest {

  private Circle circle;

  @BeforeEach
   void setUp() throws ZeroOrNegativeRadiusException {
    circle = new Circle();
  }

  @AfterEach
   void tearDown() {}

  @Nested
  class NewCircle {

    @BeforeEach
     void setUp() throws ZeroOrNegativeRadiusException {
      circle = new Circle();
    }

    @Test
    @DisplayName("Has new circle the default radius ?")
     void testNewCircleHasRadiusOne() {

      double expected_radius = Circle.DEFAULT_RADIUS;
      double real_radius;
      double delta = 0.01;

      real_radius = circle.getRadius();
      assertEquals(expected_radius, real_radius, delta);

    }

  }

  @Test
  void testSetNullRadiusThrowsException() throws ZeroOrNegativeRadiusException {

    assertThrows(ZeroOrNegativeRadiusException.class, () -> {
      circle.setRadius(0);
    });
  }

  @Test
  void testSetRadiusChangeRadius() throws ZeroOrNegativeRadiusException {

    double radius3 = 3;
    circle.setRadius(radius3);

    //assumeTrue(radius3=3,"3!");
    assertEquals(radius3, circle.getRadius());

  }

  @Test
  @Disabled("WIP: Optimization")
   void testTimeout() {
    assertTimeout(ofMillis(100), () -> {
      // Simulate task that takes more than 10 ms.
      Thread.sleep(1);
    });

    assertTimeoutPreemptively(ofMillis(1), () -> {
      // Simulate task that takes more than 10 ms.
      Thread.sleep(100_000);
    });
  }

  ;

}
