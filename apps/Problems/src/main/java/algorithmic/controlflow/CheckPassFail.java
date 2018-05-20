package algorithmic.controlflow;

public class CheckPassFail {

  private int mark;

  public void CheckPassFail() {
    mark = 0;
  }

  public void execute() {

    // Set the value of "mark" here!
    mark = 49;
    System.out.println("The mark is " + mark);

    if (mark > 50) {
      System.out.println("Success");
    } else {
      System.out.println("Failure");
    }
    System.out.println("Done");
  }


}
