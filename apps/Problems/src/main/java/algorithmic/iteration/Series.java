package algorithmic.iteration;

class Series {

  private int rangeStart;
  private int rangeEnd;

  private int sum;
  private int count;

  Series(int rangeStart, int rangeEnd) {

    this.rangeStart = rangeStart;
    this.rangeEnd = rangeEnd;

  }

  int sumAllUsingFor() {

    this.sum = 0;
    this.count = 0;

    for (int i = rangeStart; i <= this.rangeEnd; i++) {
      this.sum += i;
      this.count++;
    }

    return sum;

  }

  int sumAllUsingWhile() {

    int current_element;
    current_element = this.rangeStart;

    this.sum = 0;
    this.count = 0;

    while (current_element <= rangeEnd) {
      sum = sum + current_element;
      this.count++;
      current_element++;
    }

    return sum;

  }


  int sumAllUsingDo() {

    int current_element;

    this.sum = 0;
    this.count = 0;

    current_element = this.rangeStart;

    do {
      sum += current_element;
      this.count++;
      current_element++;
    }
    while (current_element <= rangeEnd);

    return sum;

  }

  double averageSumAll() {

    double sumAllAverage;

    sumAllUsingDo();

    sumAllAverage = sum / count;

    return sumAllAverage;

  }


  int sumOddUsingFor() {

    this.sum = 0;
    this.count = 0;

    for (int i = rangeStart; i <= this.rangeEnd; i++) {

      if (i % 2 == 0) {
        this.sum += i;
        this.count++;
      }
    }

    return sum;

  }

  int sumDivisible7UsingWhile() {

    int current_element;
    current_element = rangeStart;

    sum = 0;
    count = 0;

    while (current_element <= rangeEnd) {

      if (current_element % 7 == 0) {
        sum = sum + current_element;
        count++;
      }

      current_element++;
    }

    return sum;

  }

  int sumPowerUsingDo() {

    int power;

    sum = 0;
    count = 0;

    count = rangeStart;

    do {
      power = 1;
      for (int i = 1; i <= count; i++) {
        power *= i;
      }
      sum += power;
      count++;
    }
    while (count <= rangeEnd);

    return sum;

  }

  @Override
  public String toString() {
    return "Series [" + this.rangeStart + "- " + this.rangeEnd + "]";
  }

}
