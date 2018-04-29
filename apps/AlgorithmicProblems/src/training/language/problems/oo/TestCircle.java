package training.language.problems.oo;

import training.utility.Test;

public class TestCircle {

  private static final double SUBSTITUTE_PI = 3;

  public static void main(String[] args) {

    System.out.println("================ Testing circle ================");
    testCircle();

  }

  private static void testCircle() {

    testConstructors();
    testSetters();
    testGetters();

  }

  private static void testConstructors() {
    testConstructorUnadorned();
    testConstructorRadius();
    testConstructorRadiusNegative();
  }

  private static void testSetters() {
    testSetterRadius();
  }


  private static void testGetters() {
    testCircleGetterArea();
    testCircleGetterString();
  }


  private static void testConstructorUnadorned() {

    Circle circle;
    double expectedRadius, obtainedRadius;

    String testSubject;
    Test circle_test;

    circle_test = new Test();
    testSubject = "constructor - unadorned";

    circle = new Circle();
    obtainedRadius = circle.getRadius();
    expectedRadius = 1;
    circle_test.CheckResult(testSubject, expectedRadius, obtainedRadius);

  }

  private static void testConstructorRadius() {

    Circle circle;
    double expectedRadius, obtainedRadius;

    String testSubject;
    Test circle_test;

    circle_test = new Test();
    testSubject = "constructor - radius";

    expectedRadius = 2;
    circle = new Circle(expectedRadius);
    obtainedRadius = circle.getRadius();
    circle_test.CheckResult(testSubject, expectedRadius, obtainedRadius);

  }


  private static void testConstructorRadiusNegative() {

    Circle circle;
    double expectedRadius, obtainedRadius;

    String testSubject;
    Test circle_test;

    circle_test = new Test();
    testSubject = "constructor - radius < 0";

    expectedRadius = -1;
    circle = new Circle(expectedRadius);
    expectedRadius = 0;
    obtainedRadius = circle.getRadius();
    circle_test.CheckResult(testSubject, expectedRadius, obtainedRadius);

  }



  private static void testSetterRadius() {

    Circle circle;
    double expectedRadius, obtainedRadius;


    String testSubject;
    Test circle_test;

    circle_test = new Test();
    testSubject = "setter - radius ";

    expectedRadius = 1;
    circle = new Circle(expectedRadius);
    expectedRadius = 2;
    circle.setRadius(expectedRadius);
    obtainedRadius = circle.getRadius();
    circle_test.CheckResult(testSubject, expectedRadius, obtainedRadius);

  }

   private static void testCircleGetterArea() {

    Circle circle;
    double radius;
    double expectedArea, obtainedArea;

    String testSubject;
    Test circle_test;

    circle_test = new Test();
    testSubject = "area";

    radius = 2;
    circle = new Circle(radius);

    obtainedArea = circle.getArea();
    expectedArea = SUBSTITUTE_PI * Math.pow(radius, 2);
    circle_test.CheckResult(testSubject, expectedArea, obtainedArea);

  }

  private static void testCircleGetterString() {

    Circle circle;
    double expectedRadius;

    String testSubject;
    String expectedClassString, obtainedClassString;

    Test circle_test = new Test();
    testSubject = "toString()";

    expectedRadius = 2;
    circle = new Circle(expectedRadius);
    expectedClassString = "Circle[radius=" + String.valueOf(expectedRadius) + "]";

    obtainedClassString = circle.toString();
    circle_test.CheckResult(testSubject, expectedClassString, obtainedClassString);

  }

}
