package training.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import object.Square;

public class SquareTest {

  Square square;

  @BeforeEach
  public void setUp(){
    this.square = new Square();
   }

  @Test
  public void getSide() {
    double expected_side;
    double real_side;

    expected_side = square.DEFAULT_SIDE;
    real_side = square.getSide();
    assertEquals(expected_side, real_side);

  }

  @Test
  public void getArea() {
    double expected_area;
    double real_area;

    expected_area = Math.pow(square.getSide(), 2);
    real_area = square.getArea();
    assertEquals(expected_area, real_area);
  }
}
