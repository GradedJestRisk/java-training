package training.language.problems.oo;

public class Circle extends Form {

  public static double DEFAULT_RADIUS = 1;
  private double radius;

//  Constructors

  public Circle() throws ZeroOrNegativeRadiusException {
    setRadius(1);
  }

  public Circle(double radius) throws ZeroOrNegativeRadiusException {
    setRadius(radius);
  }

//  Getters

  public double getRadius() {
    return this.radius;
  }

  @Override
  public double getArea() {
    double area;
    area = Math.PI * Math.pow(this.radius, 2);
    return area;
  }

  @Override
  public String toString() {
    return "Circle[radius=" + String.valueOf(this.getRadius()) + "]";
  }

//  Setters

  public void setRadius(double radius) throws ZeroOrNegativeRadiusException {
    if (radius > 0) {
      this.radius = radius;
    } else {
      throw new ZeroOrNegativeRadiusException();
    }
  }


}
