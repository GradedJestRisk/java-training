package object.inheritance;

final class Circle extends Form {

  private static double DEFAULT_RADIUS = 1;
  static int DEFAULT_CONSTRUCTOR_X = 9;

  private double radius;

  Circle() {
    radius = DEFAULT_RADIUS;
  }


  Circle(double radius) {

    super(DEFAULT_CONSTRUCTOR_X);
    this.radius = radius;

  }

//  public double getRadius() {
//    return this.radius;
//  }
//
//  @Override
//  public double getArea() {
//    double area;
//    area = Math.PI * Math.pow(this.radius, 2);
//    return area;
//  }
//
//  public void setRadius(double radius) {
//    if (radius > 0) {
//      this.radius = radius;
//    } else {
//      this.radius = 0;
//    }
//  }


}
