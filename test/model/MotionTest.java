package model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Create the test cases for Ellipse.
 * 
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public class MotionTest {

  private Motion motionOne;

  /**
   * Set up for the test cases.
   */
  @Before
  public void setup() {
    motionOne = new Motion("m1", 480, 540, 165, 20, 15, 124, 0, 0, 495, 540, 0, 20, 15, 124, 0, 0);
  }

  /**
   * Test for the new Ellipses.
   */
  @Test
  public void testEllipse() {
    try {
      new Motion("m1", 100, 540, -165, 20, 15, 124, 0, 0, 2, 540, 0, 20, 15, 124, 0, 0);
    } catch (IllegalArgumentException e) {
      System.out.println("end start cannot be smaller than start time");
    }

    try {
      new Motion("m1", 480, 540, -165, 20, 15, 124, 0, 0, 495, 540, 0, 20, 15, 124, 0, 0);
    } catch (IllegalArgumentException e) {
      System.out.println("Width or height cannot be negative!");
    }

    try {
      new Motion("m1", 480, 540, 165, -20, 15, 124, 0, 0, 495, 540, 0, 20, 15, 124, 0, 0);
    } catch (IllegalArgumentException e) {
      System.out.println("Width or height cannot be negative!");
    }

    try {
      new Motion("m1", 480, 540, 165, 20, 15, -124, 0, 0, 495, 540, 0, 20, 15, 124, 0, 0);
    } catch (IllegalArgumentException e) {
      System.out.println("Color is invalid.");
    }

    try {
      new Motion("m1", 480, 540, 165, 20, 15, 124, -10, 0, 495, 540, 0, 20, 15, 124, 0, 0);
    } catch (IllegalArgumentException e) {
      System.out.println("Color is invalid.");
    }

    try {
      new Motion("m1", 480, 540, 165, 20, 15, 124, 10, -100, 495, 540, 0, 20, 15, 124, 0, 0);
    } catch (IllegalArgumentException e) {
      System.out.println("Color is invalid.");
    }
    
    assertEquals("m1", motionOne.getName());
  }

  /**
   * Test case for getting the shape name.
   */
  @Test
  public void testGetShapeName() {
    assertEquals("m1", motionOne.getName());
  }

  /**
   * Test case for getting the start time.
   */
  @Test
  public void testGetStartTime() {
    assertEquals(480, motionOne.getStartTime());
  }

  /**
   * Test case for getting the end time.
   */
  @Test
  public void testGetEndTime() {
    assertEquals(495, motionOne.getEndTime());
  }

  /**
   * Test case for getting the start X.
   */
  @Test
  public void testGetStartX() {
    assertEquals(540, motionOne.getStartX());
  }

  /**
   * Test case for getting the end X.
   */
  @Test
  public void testGetEndX() {
    assertEquals(540, motionOne.getEndX());
  }

  /**
   * Test case for getting the start Y.
   */
  @Test
  public void testGetStartY() {
    assertEquals(165, motionOne.getStartY());
  }

  /**
   * Test case for getting the end Y.
   */
  @Test
  public void testGetEndY() {
    assertEquals(0, motionOne.getEndY());
  }

  /**
   * Test case for getting the start width.
   */
  @Test
  public void testGetStartWidth() {
    assertEquals(20, motionOne.getStartWidth());
  }

  /**
   * Test case for getting the end width.
   */
  @Test
  public void testGetEndWidth() {
    assertEquals(20, motionOne.getEndWidth());
  }

  /**
   * Test case for getting the start height.
   */
  @Test
  public void testGetStartHeight() {
    assertEquals(15, motionOne.getStartHeight());
  }

  /**
   * Test case for getting the end height.
   */
  @Test
  public void testGetEndHeight() {
    assertEquals(15, motionOne.getEndHeight());
  }

  /**
   * Test case for getting the start red color.
   */
  @Test
  public void testGetStartRedColor() {
    assertEquals(124, motionOne.getStartRedColor());
  }

  /**
   * Test case for getting the end red color.
   */
  @Test
  public void testGetEndRedColor() {
    assertEquals(124, motionOne.getEndRedColor());
  }

  /**
   * Test case for getting the start green color.
   */
  @Test
  public void testGetStartGreenColor() {
    assertEquals(0, motionOne.getStartGreenColor());
  }

  /**
   * Test case for getting the end green color.
   */
  @Test
  public void testGetEndGreenColor() {
    assertEquals(0, motionOne.getEndGreenColor());
  }

  /**
   * Test case for getting the start blue color.
   */
  @Test
  public void testGetStartBlueColor() {
    assertEquals(0, motionOne.getStartBlueColor());
  }

  /**
   * Test case for getting the end blue color.
   */
  @Test
  public void testGetEndBlueColor() {
    assertEquals(0, motionOne.getEndBlueColor());
  }

}
