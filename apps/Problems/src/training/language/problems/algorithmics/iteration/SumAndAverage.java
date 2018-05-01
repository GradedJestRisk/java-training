package training.language.problems.algorithmics.iteration;

public class SumAndAverage {

  private int sum_start;
  private int sum_end;

  private int sum_total;
  private int element_count;
  private float sum_average;

  SumAndAverage(int sum_start, int sum_end) {

    this.sum_start = sum_start;
    this.sum_end = sum_end;

  }

  private void computeAverage() {
    if (this.element_count != 0) {
      this.sum_average = this.sum_total / this.element_count;
    } else {
      this.sum_average = 0;
    }
  }

  private void printResult(String method) {

    System.out.println(
        "- " + method + ": " + this.sum_total + " (average = " + this.sum_average + ")");

  }

  private void computeUsingFor() {
    computeTotalUsingFor();
    computeAverage();
    printResult("all, using for()");
  }


  private void computeTotalUsingFor() {

    this.sum_total = 0;
    this.element_count = 0;

    for (int i = sum_start; i <= this.sum_end; i++) {
      this.sum_total += i;
      this.element_count++;
    }

  }

  private void computeUsingWhile() {
    computeTotalUsingWhile();
    computeAverage();
    printResult("all, using while()");
  }


  private void computeTotalUsingWhile() {

    int current_element;
    current_element = this.sum_start;

    this.sum_total = 0;
    this.element_count = 0;

    while (current_element <= sum_end) {
      sum_total = sum_total + current_element;
      this.element_count++;
      current_element++;
    }

  }

  private void computeUsingDo() {
    computeTotalUsingDo();
    computeAverage();
    printResult("all, using do()");
  }


  private void computeTotalUsingDo() {

    int current_element;

    this.sum_total = 0;
    this.element_count = 0;

    current_element = this.sum_start;

    do {
      sum_total += current_element;
      this.element_count++;
      current_element++;
    }
    while (current_element <= sum_end);

  }

  private void computeOddUsingFor() {
    computeTotalOddUsingFor();
    computeAverage();
    printResult("only odd, using for()");
  }


  private void computeTotalOddUsingFor() {

    this.sum_total = 0;
    this.element_count = 0;

    for (int i = sum_start; i <= this.sum_end; i++) {

      if (i % 2 == 0) {
        this.sum_total += i;
        this.element_count++;
      }
    }

  }

  private void computeDivisible7UsingWhile() {
    computeTotalDivisible7UsingWhile();
    computeAverage();
    printResult("divisible by 7 odd, using while()");
  }

  private void computeTotalDivisible7UsingWhile() {

    int current_element;
    current_element = this.sum_start;

    this.sum_total = 0;
    this.element_count = 0;

    while (current_element <= sum_end) {

      if (current_element % 7 == 0) {
        sum_total = sum_total + current_element;
        this.element_count++;
      }

      current_element++;
    }

  }

  private void computePowerUsingDo() {
    computeTotalPowerUsingDo();
    computeAverage();
    printResult("power of all, using do()");
  }

  private void computeTotalPowerUsingDo() {

    int current_element;
    int power;

    this.sum_total = 0;
    this.element_count = 0;

    current_element = this.sum_start;

    do {
      power = 1;
      for (int i = 1; i<= current_element; i++) {
        power *= i;
      }
      sum_total += power;
      this.element_count++;
      current_element++;
    }
    while (current_element <= sum_end);

  }

  void execute() {

    System.out.println("In integers range [" + this.sum_start + "- " + this.sum_end + "], sum of:");

    computeUsingFor();
    computeUsingWhile();
    computeUsingDo();

    computeOddUsingFor();
    computeDivisible7UsingWhile();

    computePowerUsingDo();
  }

}
