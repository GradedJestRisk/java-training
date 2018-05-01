package training.language.problems.algorithmics.controlflow;

class PrintNumberInWord {

  private static final String ONE = "one";
  private static final String TWO = "two";
  private static final String THREE = "three";
  private static final String FOUR = "four";
  private static final String FIVE = "five";
  private static final String SIX = "six";
  private static final String SEVEN = "seven";
  private static final String EIGHT = "eight";
  private static final String NINE = "nine";
  private static final String TEN = "ten";
  private static final String UNKNOWN = "unknown";

  //  no constructor

  void execute() {

    String numberInWord;

    System.out.println("Using if");

    for (int i = 1; i <= 11; i++) {

      if (i == 1) {
        numberInWord = ONE;
      } else if (i == 2) {
        numberInWord = TWO;
      } else if (i == 3) {
        numberInWord = THREE;
      } else if (i == 4) {
        numberInWord = FOUR;
      } else if (i == 5) {
        numberInWord = FIVE;
      } else if (i == 6) {
        numberInWord = SIX;
      } else if (i == 7) {
        numberInWord = SEVEN;
      } else if (i == 8) {
        numberInWord = EIGHT;
      } else if (i == 9) {
        numberInWord = NINE;
      } else if (i == 10) {
        numberInWord = TEN;
      } else {
        numberInWord = UNKNOWN;
      }

      System.out.println(i + " in word is: " + numberInWord);

    }

    System.out.println("Using switch");

    for (int i = 1; i <= 11; i++) {

      switch (i) {

        case 1:
          numberInWord = ONE;
          break;

        case 2:
          numberInWord = TWO;
          break;

        case 3:
          numberInWord = THREE;
          break;

        case 4:
          numberInWord = FOUR;
          break;

        case 5:
          numberInWord = FIVE;
          break;

        case 6:
          numberInWord = SIX;
          break;

        case 7:
          numberInWord = SEVEN;
          break;

        case 8:
          numberInWord = EIGHT;
          break;

        case 9:
          numberInWord = NINE;
          break;

        case 10:
          numberInWord = TEN;
          break;

        default:
          numberInWord = UNKNOWN;
      }

      System.out.println(i + " in word is: " + numberInWord);
    }

  }

}
