package algorithmic.controlflow;

class PrintDayInWord {

  private static final String FIRST_DAY   = "monday";
  private static final String SECOND_DAY  = "tuesday";
  private static final String THIRD_DAY   = "wednesday";
  private static final String FOURTH_DAY  = "thursday";
  private static final String FIFTH_DAY   = "friday";
  private static final String SIXTH_DAY   = "saturday";
  private static final String SEVENTH_DAY = "sunday";
  private static final String UNKNOWN_DAY = "unknow";

  //  no constructor

  void execute() {

    String DayInWord;

    System.out.println("Using if");

    for (int i = 1; i <= 8; i++) {

      if (i == 1) {
        DayInWord = FIRST_DAY;
      } else if (i == 2) {
        DayInWord = SECOND_DAY;
      } else if (i == 3) {
        DayInWord = THIRD_DAY;
      } else if (i == 4) {
        DayInWord = FOURTH_DAY;
      } else if (i == 5) {
        DayInWord = FIFTH_DAY;
      } else if (i == 6) {
        DayInWord = SIXTH_DAY;
      } else if (i == 7) {
        DayInWord = SEVENTH_DAY;
      } else {
        DayInWord = UNKNOWN_DAY;
      }

      if (! DayInWord.equals(UNKNOWN_DAY)) {
        System.out.println("Day " + i + " is: " + DayInWord);
      }
      else {
        System.out.println("Day " + i + " is not a valid day");
      }

    }

    System.out.println("Using switch");

    for (int i = 1; i <= 8; i++) {

      switch (i) {

        case 1:
          DayInWord = FIRST_DAY;
          break;

        case 2:
          DayInWord = SECOND_DAY;
          break;

        case 3:
          DayInWord = THIRD_DAY;
          break;

        case 4:
          DayInWord = FOURTH_DAY;
          break;

        case 5:
          DayInWord = FIFTH_DAY;
          break;

        case 6:
          DayInWord = SIXTH_DAY;
          break;

        case 7:
          DayInWord = SEVENTH_DAY;
          break;

        default:
          DayInWord = UNKNOWN_DAY;
      }

      if (! DayInWord.equals(UNKNOWN_DAY)) {
        System.out.println("Day " + i + " is: " + DayInWord);
      }
      else {
        System.out.println("Day " + i + " is not a valid day");
      }

    }

  }

}
