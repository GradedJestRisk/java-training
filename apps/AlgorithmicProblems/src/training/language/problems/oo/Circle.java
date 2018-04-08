package training.language.problems.oo;

class Circle {

  private double radius;

//  Constructors

  Circle() {
    setRadius(1);
  }

  Circle(double radius) {
    setRadius(radius);
  }

//  Getters

  double getRadius() {
    return this.radius;
  }

  double getArea() {
    double area;
    area = Math.PI * Math.pow(this.radius, 2);
    return area;
  }

  @Override
  public String toString() {
    return "Circle[radius=" + String.valueOf(this.getRadius()) + "]";
  }

//  Setters

  void setRadius(double radius) {
    if(radius > 0) {
      this.radius = radius;
    }
  }
}
