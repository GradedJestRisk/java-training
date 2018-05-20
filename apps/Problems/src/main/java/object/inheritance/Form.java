package object.inheritance;

class Form {

  static int DEFAULT_X = 3;
  private static int DEFAULT_Y = -2;

  private final int x;
  private final int y;

//  public abstract double getArea();

  Form() {

    x = DEFAULT_X;
    y = DEFAULT_Y;

//    System.out.println(" Form() called ");

  }

  Form(int x, int y) {

    this.x = x;
    this.y = y;

//    System.out.println(" Form(int x, int y) called ");

  }

  public String toString() {
    return "Form (" + x + "," + y + ")";
  }

  int getX() {
    return x;
  }

  int getY() {
    return y;
  }
}
