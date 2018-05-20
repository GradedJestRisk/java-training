package algorithmic.controlflow;

class CheckOddEven {

  private int number;

  CheckOddEven() {
  }

  CheckOddEven(int number) {
    setNumber(number);
  }

  void setNumber(int number) {
    this.number = number;
  }

  void execute() {

    int remainder;

    System.out.println("The number is " + number);

    remainder = number % 2;

    if (remainder == 0) {
      System.out.println("Number is odd");
    } else {
      System.out.println("Number is even");
    }

    System.out.println("Done");
  }


}
