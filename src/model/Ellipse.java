package model;

/**
 * Create the ellipse class that extends the abstract shape.
 * 
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public class Ellipse extends AbstractShape {

  /**
   * Construct a ellipse class.
   * 
   * @param shapeType  shape type of the shape
   * @param x          x-position of the shape
   * @param y          y-position of the shape
   * @param width      width of the shape
   * @param height     height of the shape
   * @param redColor   red color of the shape
   * @param greenColor green color of the shape
   * @param blueColor  blue color of the shape
   */
  public Ellipse(String shapeType, int x, int y, int width, 
                int height, int redColor, int greenColor, int blueColor) {
    super(shapeType, x, y, width, height, redColor, greenColor, blueColor);

    this.shapeType = "Ellipse";

  }

  /**
   * Set the shape type to be ellipse.
   */
  public Ellipse() {
    super();
    this.shapeType = "Ellipse";
  }

}
