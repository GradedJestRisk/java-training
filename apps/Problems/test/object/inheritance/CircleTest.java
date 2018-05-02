package object.inheritance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CircleTest {

  private Circle circle;

  @BeforeEach
  void setUp() {
    circle = new Circle();
  }

  @DisplayName("When heir constructor is called, Then the parent one is called implicitly")
  @Test
  void whenHeirConstructorCalledThenParentConstructorCalledImplicitly() {

    int expectedX;
    int realX;

    expectedX = Form.DEFAULT_X;
    realX = circle.getX();

    assertEquals(expectedX, realX);

  }

  @DisplayName("When heir constructor call super, Then the parent one is called ")
  @Test
  void whenHeirConstructorCallSuperThenParentConstructorCalled() {

    double radius;
    int expectedX;
    int realX;
    Circle anotherCircle;

    radius = 8;
    anotherCircle = new Circle(radius);

    expectedX = Circle.DEFAULT_CONSTRUCTOR_X;
    realX = anotherCircle.getX();

    assertEquals(expectedX, realX);

  }


}
