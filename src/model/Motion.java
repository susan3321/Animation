package model;

/**
 * Create a motion class to implement interface of motion.
 * 
 * @author Xinyao Liu, Jingshan Yang
 */
public class Motion implements IMotion {

  private String name;
  private int startTime;
  private int startX;
  private int startY;
  private int startWidth;
  private int startHeight;
  private int startRed;
  private int startGreen;
  private int startBlue;

  private int endTime;
  private int endX;
  private int endY;
  private int endWidth;
  private int endHeight;
  private int endRed;
  private int endGreen;
  private int endBlue;

  /**
   * Construct the motion.
   * 
   * @param name The name of the shape (added with
   *             {@link AnimationBuilder#declareShape})
   * @param t1   The start time of this transformation
   * @param x1   The initial x-position of the shape
   * @param y1   The initial y-position of the shape
   * @param w1   The initial width of the shape
   * @param h1   The initial height of the shape
   * @param r1   The initial red color-value of the shape
   * @param g1   The initial green color-value of the shape
   * @param b1   The initial blue color-value of the shape
   * @param t2   The end time of this transformation
   * @param x2   The final x-position of the shape
   * @param y2   The final y-position of the shape
   * @param w2   The final width of the shape
   * @param h2   The final height of the shape
   * @param r2   The final red color-value of the shape
   * @param g2   The final green color-value of the shape
   * @param b2   The final blue color-value of the shape
   * @throws IllegalArgumentException when the start time or end time are out of
   *                                  range, or start width or end width are out
   *                                  of range, or start height or end height are
   *                                  out of range, or color value is out of range
   */

  public Motion(String name, int t1, int x1, int y1, int w1, int h1, 
      int r1, int g1, int b1, int t2, int x2, int y2,
      int w2, int h2, int r2, int g2, int b2) throws IllegalArgumentException {
    if (t1 < 0 || t1 > t2) {
      throw new IllegalArgumentException("Start time or end time is invalid.");
    }

    if (w1 < 0 || w2 < 0) {
      throw new IllegalArgumentException("Width has to be non-negative.");
    }

    if (h1 < 0 || h2 < 0) {
      throw new IllegalArgumentException("Height has to be non-negative.");
    }

    if (r1 < 0 || r2 > 255 || g1 < 0 || g1 > 255 || b1 < 0 || b2 > 255) {
      throw new IllegalArgumentException("RGB color value have to be in the range[0,255].");
    }

    this.name = name;
    this.startTime = t1;
    this.startX = x1;
    this.startY = y1;
    this.startWidth = w1;
    this.startHeight = h1;
    this.startRed = r1;
    this.startGreen = g1;
    this.startBlue = b1;

    this.endTime = t2;
    this.endX = x2;
    this.endY = y2;
    this.endWidth = w2;
    this.endHeight = h2;
    this.endRed = r2;
    this.endGreen = g2;
    this.endBlue = b2;
  }

  /**
   * return the shape name.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * return the start x.
   */
  @Override
  public int getStartX() {
    return this.startX;
  }

  /**
   * return the end x.
   */
  @Override
  public int getEndX() {
    return this.endX;
  }

  /**
   * return the start y.
   */
  @Override
  public int getStartY() {
    return this.startY;
  }

  /**
   * return the end y.
   */
  @Override
  public int getEndY() {
    return this.endY;
  }

  /**
   * return the start width.
   */
  @Override
  public int getStartWidth() {
    return this.startWidth;
  }

  /**
   * return the end width.
   */
  @Override
  public int getEndWidth() {
    return this.endWidth;
  }

  /**
   * return the start height.
   */
  @Override
  public int getStartHeight() {
    return this.startHeight;
  }

  /**
   * return the end height.
   */
  @Override
  public int getEndHeight() {
    return this.endHeight;
  }

  /**
   * return the start red color.
   */
  @Override
  public int getStartRedColor() {
    return this.startRed;
  }

  /**
   * return the end red color.
   */
  @Override
  public int getEndRedColor() {
    return this.endRed;
  }

  /**
   * return the start green color.
   */
  @Override
  public int getStartGreenColor() {
    return this.startGreen;
  }

  /**
   * return the end green color.
   */
  @Override
  public int getEndGreenColor() {
    return this.endGreen;
  }

  /**
   * return the start blue color.
   */
  @Override
  public int getStartBlueColor() {
    return this.startBlue;
  }

  /**
   * return the end blue color.
   */
  @Override
  public int getEndBlueColor() {
    return this.endBlue;
  }

  /**
   * return the start time.
   */
  @Override
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * return the end time.
   */
  @Override
  public int getEndTime() {
    return this.endTime;
  }

}
