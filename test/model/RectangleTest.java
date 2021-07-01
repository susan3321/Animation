package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * Create the test cases for Rectangle.
 * 
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public class RectangleTest {

  private Rectangle recOne;

  /**
   * Set up for the test cases.
   */
  @Before
  public void setup() {
    recOne = new Rectangle("Rectangle", 0, 0, 10, 22, 0, 0, 0);
  }

  /**
   * Test for the new rectangles.
   */
  @Test
  public void testRectangle() {
    try {
      new Rectangle("Rectangle", 1, 0, -1, 22, 0, 0, 0);
    } catch (IllegalArgumentException e) {
      System.out.println("Width or height cannot be negative!");
    }

    try {
      new Rectangle("Rectangle", 1, 0, 1, -22, 0, 0, 0);
    } catch (IllegalArgumentException eOne) {
      System.out.println("Width or height cannot be negative!");
    }

    try {
      new Rectangle("Rectangle", 1, 0, 1, 22, -1, 0, 0);
    } catch (IllegalArgumentException eTwo) {
      System.out.println("Color is invalid.");
    }

    try {
      new Rectangle("Rectangle", 1, 0, -1, 22, 0, 300, 0);
    } catch (IllegalArgumentException eThree) {
      System.out.println("Color is invalid.");
    }

    try {
      new Rectangle("Rectangle", 1, 0, -1, 22, 0, 0, 0);
    } catch (IllegalArgumentException eFour) {
      System.out.println("Color is invalid.");
    }
    
    assertEquals("Color(0, 0, 0) Rectangle at (0, 0) with width: 10, "
        + "height: 22",recOne.toString());
  }

  /**
   * Test case for getting the shape type.
   */
  @Test
  public void testGetShapeType() {
    assertEquals("Rectangle", recOne.getShapeType());
  }

  /**
   * Test case for getting the X.
   */
  @Test
  public void testGetX() {
    assertEquals(0, recOne.getX());
  }

  /**
   * Test case for getting the Y.
   */
  @Test
  public void testGetY() {
    assertEquals(0, recOne.getY());
  }

  /**
   * Test case for getting the width.
   */
  @Test
  public void testGetWidth() {
    assertEquals(10, recOne.getWidth());
  }

  /**
   * Test case for getting the height.
   */
  @Test
  public void testGetHeight() {
    assertEquals(22, recOne.getHeight());
  }

  /**
   * Test case for getting the red color.
   */
  @Test
  public void testRedColor() {
    assertEquals(0, recOne.getRedColor());
  }

  /**
   * Test case for getting the green color.
   */
  @Test
  public void testGreenColor() {
    assertEquals(0, recOne.getGreenColor());
  }

  /**
   * Test case for getting the blue color.
   */
  @Test
  public void testBlueColor() {
    assertEquals(0, recOne.getBlueColor());
  }

  /**
   * Test case for setting the x.
   */
  @Test
  public void testSetX() {
    recOne.setX(1);
    assertEquals(1, recOne.getX());

  }

  /**
   * Test case for setting the y.
   */
  @Test
  public void testSetY() {
    recOne.setY(9);
    assertEquals(9, recOne.getY());

  }

  /**
   * Test case for setting the width.
   */
  @Test
  public void testSetWidth() {
    try {
      recOne.setWidth(-1);
      fail("An exception shold have been thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Width is invalid");
    }

    recOne.setWidth(55);
    assertEquals(55, recOne.getWidth());

  }

  /**
   * Test case for setting the height.
   */
  @Test
  public void testSetHeight() {

    try {
      recOne.setHeight(-1);
      fail("An exception shold have been thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Height is invalid");
    }

    recOne.setHeight(66);
    assertEquals(66, recOne.getHeight());

  }

  /**
   * Test case for setting the red color.
   */

  @Test
  public void testSetRedColor() {

    try {
      recOne.setRedColor(-1);
      fail("An exception shold have been thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Color is invalid");
    }

    recOne.setRedColor(100);
    assertEquals(100, recOne.getRedColor());
  }

  /**
   * Test case for setting the green color.
   */
  @Test
  public void testSetGreenColor() {
    try {
      recOne.setGreenColor(-1);
      fail("An exception shold have been thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Color is invalid");
    }

    recOne.setGreenColor(99);
    assertEquals(99, recOne.getGreenColor());
  }

  /**
   * Test case for setting the blue color.
   */
  @Test
  public void testSetBlueColor() {
    try {
      recOne.setBlueColor(-1);
      fail("An exception shold have been thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Color is invalid");
    }

    recOne.setBlueColor(222);
    assertEquals(222, recOne.getBlueColor());
  }

}
