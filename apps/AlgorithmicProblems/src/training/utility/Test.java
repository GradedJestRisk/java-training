package training.utility;

public class Test {

  private static final String TEST_OK = "OK";
  private static final String TEST_KO = "KO";

  private String checkDelta(double expected, double obtained) {

    final double ACCEPTABLE_DELTA = 0.1;

    String testResult;
    double delta;

    if (expected != 0) {
      delta = (expected - obtained) / expected;
    } else {
      delta = expected - obtained;
    }

    if (delta < ACCEPTABLE_DELTA) {
      testResult = Output.putStringInGreen(TEST_OK);
    } else {
      testResult = Output.putStringInRed(TEST_KO);
    }

    return testResult;

  }

  public void CheckResult(String testSubject, double expected, double obtained) {
    String testResult;

    testResult = checkDelta(expected, obtained);

    System.out.println("Testing: " + testSubject);
    System.out.println(
        "Test result: " + testResult + " (expected: " + expected + ", got " + obtained + ")");
    System.out.println();

  }

  public  void CheckResult(String testSubject, String expected, String obtained) {

    String testResult;

    if (expected.equals(obtained)) {
      testResult = Output.putStringInGreen(TEST_OK);
    } else {
      testResult = Output.putStringInRed(TEST_KO);
    }

    System.out.println("Testing: " + testSubject);
    System.out.println(
        "Test result: " + testResult + " (expected: " + expected + ", got " + obtained + ")");
    System.out.println();

  }
}
