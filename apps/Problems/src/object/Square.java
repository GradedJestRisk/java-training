package object;

public class Square extends Form {

  public static double DEFAULT_SIDE = 1;

  private double side;

//  Constructors

  public Square()  {
    setSide(DEFAULT_SIDE);
  }

  public Square(double side)  {
    setSide(side);
  }

//  Getters

  public double getSide() {
    return this.side;
  }

  @Override
  public double getArea() {
    double area;
    area = Math.pow(this.side, 2);
    return area;
  }

  @Override
  public String toString() {
    return "Square[side=" + String.valueOf(this.getSide()) + "]";
  }

//  Setters

  public void setSide(double side)  {
    if (side > 0) {
      this.side = side;
    } else {
      this.side = 0;
    }
  }


}

