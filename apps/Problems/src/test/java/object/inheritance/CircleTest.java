package object.inheritance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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


  @DisplayName("When method is implemented in both parent and heir, Then the heir one is called ")
  @Test
  void whenMethodImplementedParentHeirThenHeirIsCalled() {

    String expectedString, realString;

    expectedString = "Circle (radius=" + circle.getRadius() + ")";

    realString = circle.toString();

    assertEquals(expectedString, realString);

  }

  @DisplayName("When heir call parent method, Then the parent method is called ")
  @Test
  void whenHeirCallParentMethodThenParentMethodIsCalled() {

    String expectedString, realString;

    expectedString = "Form (" + circle.getX() + "," + circle.getY() + ")";

    realString = circle.toStringForm();

    assertEquals(expectedString, realString);

  }

  // Real name: polymorphism
  @DisplayName("Given the variable type is parent but instance is heir, When method called, Then the heir one is called ")
  @Test
  void givenVariableTypeParentInstanceHeirWhenMethodCalledThenHeirMethodCalled() {

    String expectedString, realString;

    Form form;
    Circle anotherCircle;

    anotherCircle = new Circle();

    expectedString = anotherCircle.toString();

    form = anotherCircle;
    realString = form.toString();

    assertEquals(expectedString, realString);

  }
}
