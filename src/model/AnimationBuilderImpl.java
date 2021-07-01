package model;


import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Create a class to implement AnimationBuilder.
 * 
 * @author Xinyao Liu, Jingshan Yang
 */
public class AnimationBuilderImpl implements AnimationBuilder {

  private LinkedHashMap<String, LinkedList<IMotion>> motions;
  private LinkedHashMap<String, IShape> shapes;
  private int x;
  private int y;
  private int width;
  private int height;
  private int animationInterval = 0;

  /**
   * Create the initial implementation of AnimationBuilder.
   */
  public AnimationBuilderImpl() {
    this.motions = new LinkedHashMap<String, LinkedList<IMotion>>();
    this.shapes = new LinkedHashMap<String, IShape>();
  }

  /**
   * Create a new Animation Model.
   */
  public IAnimationModel build() {
    return new AnimationModel(this.motions, 
                              this.shapes, 
                              this.x, 
                              this.y, 
                              this.width, 
                              this.height,
                              this.animationInterval);
  }

  /**
   * Set the board of AnimationBuilder with given x,y,width and height.
   */
  public AnimationBuilder setBounds(int x, int y, int width, int height) {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("width or height can not be negative.");
    }
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    return this;
  }

  /**
   * Declare the shape by the name of the shape and the type of the shape.
   */
  public AnimationBuilder declareShape(String name, String type) {
    if (this.shapes.containsKey(name)) {
      throw new IllegalArgumentException("The shape type has been declare before.");
    }

    IShape shape;

    if (type.equalsIgnoreCase("rectangle")) {
      shape = new Rectangle();
    }

    else if (type.equalsIgnoreCase("ellipse")) {
      shape = new Ellipse();
    } else {
      throw new IllegalArgumentException("Shape type is not valid.");
    }

    this.shapes.put(name, shape);
    return this;

  }

  /**
   * Add motion to the Animation Builder by the given parameters.
   */
  public AnimationBuilder addMotion(
      String name, 
      int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
      int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {

    if (!this.shapes.containsKey(name)) {
      throw new IllegalArgumentException("Shape is not declared.");
    }

    String type = this.shapes.get(name).getShapeType();

    IMotion motion = new Motion(type, t1, x1, y1, w1, h1, r1, g1, b1, 
                                      t2, x2, y2, w2, h2, r2, g2, b2);

    if (!this.motions.containsKey(name)) {
      this.motions.put(name, new LinkedList<IMotion>());
    }

    this.animationInterval = Math.max(this.animationInterval, t2);

    this.motions.get(name).add(motion);

    return this;
  }

}
