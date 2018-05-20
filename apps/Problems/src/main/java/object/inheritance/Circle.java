package object.inheritance;

final class Circle extends Form {

  private static double DEFAULT_RADIUS = 1;

  static int DEFAULT_CONSTRUCTOR_X = 9;
  private static int DEFAULT_CONSTRUCTOR_Y = -7;

  private double radius;

  Circle() {
    radius = DEFAULT_RADIUS;
  }


  Circle(double radius) {

    super(DEFAULT_CONSTRUCTOR_X, DEFAULT_CONSTRUCTOR_Y);
    this.radius = radius;

  }

  double getRadius() {
    return radius;
  }

  @Override
  public String toString() {
    return "Circle (radius=" + radius + ")";
  }

  String toStringForm() {
    return super.toString();
  }

}
