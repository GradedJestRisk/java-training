package com.pluralsight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircleTest {

  private Circle circle;

  @BeforeEach
  void setUp(){

    circle = new Circle();

  }

  @Test
  void constructorTest(){

    assertEquals(1, circle.getRadius());

  }

}
