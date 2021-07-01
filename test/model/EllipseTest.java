package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * Create the test cases for Ellipse.
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public class EllipseTest {

  private Ellipse ellipseOne;
  
  /**
   * Set up for the test cases.
   */
  @Before
  public void setup() {
    ellipseOne = new Ellipse("Ellipse", 0, 0, 10, 22, 0, 0, 0);
  }
  
  /**
   * Test for the new Ellipses.
   */
  @Test
  public void testEllipse() {
    
    try {
      new Ellipse("Ellipse", 1, 0, -1, 22, 0, 0, 0);
    } catch (IllegalArgumentException e) {
      System.out.println("Width or height cannot be negative!");
    }

    try {
      new Ellipse("Ellipse", 1, 0, 1, -22, 0, 0, 0);
    } catch (IllegalArgumentException eOne) {
      System.out.println("Width or height cannot be negative!");
    }

    try {
      new Ellipse("Ellipse", 1, 0, 1, 22, -1, 0, 0);
    } catch (IllegalArgumentException eTwo) {
      System.out.println("Color is invalid.");
    }

    try {
      new Ellipse("Ellipse", 1, 0, -1, 22, 0, 300, 0);
    } catch (IllegalArgumentException eThree) {
      System.out.println("Color is invalid.");
    }

    try {
      new Ellipse("Ellipse", 1, 0, -1, 22, 0, 0, 0);
    } catch (IllegalArgumentException eFour) {
      System.out.println("Color is invalid.");
    }
    
    assertEquals("Color(0, 0, 0) Ellipse at (0, 0) with width: 10, "
        + "height: 22",ellipseOne.toString());
  }
  
  /**
   * Test case for getting the shape type.
   */
  @Test
  public void testGetShapeType() {
    assertEquals("Ellipse", ellipseOne.getShapeType());
  }
  
  /**
   * Test case for getting the X.
   */
  @Test
  public void testGetX() {
    assertEquals(0, ellipseOne.getX());
  }
  
  /**
   * Test case for getting the Y.
   */
  @Test
  public void testGetY() {
    assertEquals(0, ellipseOne.getY());
  }
  
  /**
   * Test case for getting the width.
   */
  @Test
  public void testGetWidth() {
    assertEquals(10, ellipseOne.getWidth());
  }
  
  /**
   * Test case for getting the height.
   */
  @Test
  public void testGetHeight() {
    assertEquals(22, ellipseOne.getHeight());
  }
  
  /**
   * Test case for getting the red color.
   */
  @Test
  public void testRedColor() {
    assertEquals(0, ellipseOne.getRedColor());
  }
  
  /**
   * Test case for getting the green color.
   */
  @Test
  public void testGreenColor() {
    assertEquals(0, ellipseOne.getGreenColor());
  }
  
  /**
   * Test case for getting the blue color.
   */
  @Test
  public void testBlueColor() {
    assertEquals(0, ellipseOne.getBlueColor());
  }
  
  /**
   * Test case for setting the x.
   */
  @Test
  public void testSetX() {
    ellipseOne.setX(1);
    assertEquals(1, ellipseOne.getX());

  }
  
  /**
   * Test case for setting the y.
   */
  @Test
  public void testSetY() {
    ellipseOne.setY(9);
    assertEquals(9, ellipseOne.getY());

  }
  
  /**
   * Test case for setting the width.
   */
  @Test
  public void testSetWidth() {
    try {
      ellipseOne.setWidth(-1);
      fail("An exception shold have been thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Width is invalid");
    }

    ellipseOne.setWidth(55);
    assertEquals(55, ellipseOne.getWidth());

  }
  
  /**
   * Test case for setting the height.
   */
  @Test
  public void testSetHeight() {

    try {
      ellipseOne.setHeight(-1);
      fail("An exception shold have been thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Height is invalid");
    }

    ellipseOne.setHeight(66);
    assertEquals(66, ellipseOne.getHeight());

  }
  
  /**
   * Test case for setting the red color.
   */

  @Test
  public void testSetRedColor() {
    
    try {
      ellipseOne.setRedColor(-1);
      fail("An exception shold have been thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Color is invalid");
    }
    
    ellipseOne.setRedColor(100);
    assertEquals(100, ellipseOne.getRedColor());
  }
  
  /**
   * Test case for setting the green color.
   */
  @Test
  public void testSetGreenColor() {
    try {
      ellipseOne.setGreenColor(-1);
      fail("An exception shold have been thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Color is invalid");
    }
    
    ellipseOne.setGreenColor(99);
    assertEquals(99, ellipseOne.getGreenColor());
  }
  
  /**
   * Test case for setting the blue color.
   */
  @Test
  public void testSetBlueColor() {
    try {
      ellipseOne.setBlueColor(-1);
      fail("An exception shold have been thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Color is invalid");
    }
    
    ellipseOne.setBlueColor(222);
    assertEquals(222, ellipseOne.getBlueColor());
  }

}
