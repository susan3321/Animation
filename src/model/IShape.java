package model;

/**
 * Create the interface for the shape.
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public interface IShape {
  
  /**
   * Get the shape type of the shape.
   * @return the type of the shape
   */
  String getShapeType();
  
  /**
   * Get the x-position of the shape.
   * @return the x-position of the shape
   */
  int getX();
  
  /**
   * Get the y-position of the shape.
   * @return the y-position of the shape
   */
  int getY();
  
  /**
   * Get the width of the shape.
   * @return the width of the shape
   */
  int getWidth();
  
  /**
   * Get the height of the shape.
   * @return the height of the shape
   */
  int getHeight();
  
  /**
   * Get the red color of the shape.
   * @return the red color of the shape
   */
  int getRedColor();
  
  /**
   * Get the green color of the shape.
   * @return the green color of the shape
   */
  int getGreenColor();
  
  /**
   * Get the blue color of the shape.
   * @return the blue color of the shape
   */
  int getBlueColor();
  
  /**
   * Set the x-position to the give position.
   */
  void setX(int x);
  
  /**
   * Set the y-position to the given position.
   */
  void setY(int y);
  
  /**
   * Set the width of the shape.
   */
  void setWidth(int w);
  
  /**
   * Set the height of the shape.
   */
  void setHeight(int h);
  
  /**
   * Set the color to red for the shape.
   */
  void setRedColor(int r);
  
  /**
   * Set the color to green for the shape.
   */
  void setGreenColor(int g);
  
  /**
   * Set the color to blue for the shape.
   */
  void setBlueColor(int b);
  
  /**
   * Return the string to represent the shape.
   */
  String toString();
  
}
