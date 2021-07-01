package model;

/**
 * Create an abstract shape class.
 * 
 * @author Xinyao Liu, Jingshan Yang
 */
public abstract class AbstractShape implements IShape {

  protected String shapeType;
  protected int x;
  protected int y;
  protected int width;
  protected int height;
  protected int redColor;
  protected int greenColor;
  protected int blueColor;

  /**
   * Construct an abstract shape.
   * 
   * @param shapeType  shape type of the shape
   * @param x          x-position of the shape
   * @param y          y-position of the shape
   * @param width      width of the shape
   * @param height     height of the shape
   * @param redColor   redColor of the shape
   * @param greenColor greenColor of the shape
   * @param blueColor  blueColor of the shape
   * @throws IllegalArgumentException throw when width or height is less than zero
   */
  public AbstractShape(String shapeType, 
                                  int x, 
                                  int y, 
                                  int width, 
                                  int height, 
                                  int redColor, 
                                  int greenColor,
                                  int blueColor) throws IllegalArgumentException {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Width or height cannot be negative!");
    }
    
    if (redColor < 0 || greenColor < 0 || blueColor < 0
        || redColor > 255 || greenColor > 255 || blueColor > 255) {
      throw new IllegalArgumentException("Color value is invalid!");
    }
    
    this.shapeType = shapeType;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.redColor = redColor;
    this.greenColor = greenColor;
    this.blueColor = blueColor;
  }

  /**
   * Create an abstract shape at the initial.
   */
  protected AbstractShape() {
    this.shapeType = "";
  }

  /**
   * Return the shape type of the shape.
   */
  @Override
  public String getShapeType() {
    return this.shapeType;
  }

  /**
   * Return the x-position of the shape.
   */
  @Override
  public int getX() {
    return this.x;
  }

  /**
   * Return the y-position of the shape.
   */
  @Override
  public int getY() {
    return this.y;
  }

  /**
   * Return the width of the shape.
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Return the height of the shape.
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Return the red color of the shape.
   */
  @Override
  public int getRedColor() {
    return this.redColor;
  }

  /**
   * Return the green color of the shape.
   */
  @Override
  public int getGreenColor() {
    return this.greenColor;
  }

  /**
   * Return the blue color of the shape.
   */
  @Override
  public int getBlueColor() {
    return this.blueColor;
  }

  /**
   * Set the x to the given x.
   */
  @Override
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Set the y to the given y.
   */
  @Override
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Set the width to the given width. Throws illegalException if the width is
   * negative.
   */
  @Override
  public void setWidth(int w) throws IllegalArgumentException {
    if (w < 0) {
      throw new IllegalArgumentException("Width cannot be negative!");
    }
    this.width = w;
  }

  /**
   * Set the height to the given height. Throws illegalException if the height is
   * negative.
   */
  @Override
  public void setHeight(int h) throws IllegalArgumentException {
    if (h < 0) {
      throw new IllegalArgumentException("Height cannot be negative!");
    }
    this.height = h;
  }

  /**
   * Set the red color to the given red color.
   */
  @Override
  public void setRedColor(int r) {
    if (r < 0 || r > 255) {
      throw new IllegalArgumentException("Color is invalid.");
    }
    
    this.redColor = r;
  }

  /**
   * Set the green color to the given green color.
   */
  @Override
  public void setGreenColor(int g) {
    if (g < 0 || g > 255) {
      throw new IllegalArgumentException("Color is invalid.");
    }
    
    this.greenColor = g;
  }

  /**
   * Set the blue color to the given blue color.
   */
  @Override
  public void setBlueColor(int b) {
    
    if (b < 0 || b > 255) {
      throw new IllegalArgumentException("Color is invalid.");
    }
    
    this.blueColor = b;
  }

  /**
   * Return the data into string format.
   */
  @Override
  public String toString() {
    String result = 
        "Color(" + this.redColor + ", " 
                 + this.blueColor + ", " 
                 + this.greenColor + ") " 
        + this.shapeType
        + " at (" + this.x + ", " + this.y + ") with width: " 
        + this.width + ", height: " + this.height;

    return result;
  }

}
