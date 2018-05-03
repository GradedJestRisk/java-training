package object.inheritance;

abstract class Form {

  static int DEFAULT_X = 8;
  private static int DEFAULT_Y = 8;

  private final int x;
  private final int y;

//  public abstract double getArea();

  Form() {

    x = DEFAULT_X;
    y = DEFAULT_Y;

    System.out.println(" Form() !");

  }

  Form(int x) {

    this.x = x;
    y = DEFAULT_Y;

    System.out.println(" Form(int x) !");

  }


  int getX() {
    return x;
  }
}
