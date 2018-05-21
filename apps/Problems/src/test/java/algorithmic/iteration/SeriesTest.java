package algorithmic.iteration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SeriesTest {

  @Test
  void SumAllUsingForTest() {

    Series series;
    int sumStart, sumEnd;
    int expectedSum, obtainedSum;

    sumStart = 1;
    sumEnd = 3;

    series = new Series(sumStart, sumEnd);
    expectedSum = 1 + 2 + 3;

    obtainedSum = series.sumAllUsingFor();

    assertEquals(expectedSum, obtainedSum);


  }


  @Test
  void SumAllUsingWhileTest() {

    Series series;
    int sumStart, sumEnd;
    int expectedSum, obtainedSum;

    sumStart = 1;
    sumEnd = 3;

    series = new Series(sumStart, sumEnd);
    expectedSum = 1 + 2 + 3;

    obtainedSum = series.sumAllUsingWhile();

    assertEquals(expectedSum, obtainedSum);


  }

  @Test
  void sumAllUsingDoTest() {

    Series series;
    int sumStart, sumEnd;
    int expectedSum, obtainedSum;

    sumStart = 1;
    sumEnd = 3;

    series = new Series(sumStart, sumEnd);
    expectedSum = 1 + 2 + 3;

    obtainedSum = series.sumAllUsingDo();

    assertEquals(expectedSum, obtainedSum);


  }


  @Test
  void averageSumAllTest() {

    Series series;
    int sumStart, sumEnd;
    double expectedSumAverage, obtainedSumAverage;

    sumStart = 3;
    sumEnd = 6;

    series = new Series(sumStart, sumEnd);
    expectedSumAverage = (double) (3 + 4 + 5 + 6) / 4;

    obtainedSumAverage = series.averageSumAll();

    assertEquals(expectedSumAverage, obtainedSumAverage);

  }

  @Test
  void sumOddUsingForTest() {

    Series series;
    int sumStart, sumEnd;
    int expectedSum, obtainedSum;

    sumStart = 1;
    sumEnd = 6;

    series = new Series(sumStart, sumEnd);
    expectedSum = 2 + 4 + 6;

    obtainedSum = series.sumOddUsingFor();

    assertEquals(expectedSum, obtainedSum);


  }


  @Test
  void sumDivisible7UsingWhileTest() {

    Series series;
    int sumStart, sumEnd;
    int expectedSum, obtainedSum;

    sumStart = 7;
    sumEnd = 14;

    series = new Series(sumStart, sumEnd);
    expectedSum = 7 + 14;

    obtainedSum = series.sumDivisible7UsingWhile();

    assertEquals(expectedSum, obtainedSum);


  }

  @Test
  void sumPowerUsingDoTest() {

    Series series;
    int sumStart, sumEnd;
    double expectedSum, obtainedSum;

    sumStart = 1;
    sumEnd = 3;

    series = new Series(sumStart, sumEnd);
//    expectedSum = (1) + (1*2) + (1*2*3) = 1 + 2 + 6 = 9
    expectedSum = 9;
    obtainedSum = series.sumPowerUsingDo();

    assertEquals(expectedSum, obtainedSum);


  }

  @Test
  void toStringTest() {

    Series series;
    int seriesStart, seriesEnd;
    String expectedString, obtainedString;

    seriesStart = 1;
    seriesEnd = 3;

    series = new Series(seriesStart, seriesEnd);
    expectedString = "Series [" + seriesStart + "- " + seriesEnd + "]";

    obtainedString = series.toString();

    assertEquals(expectedString, obtainedString);


  }


}
