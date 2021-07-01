package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Create an animation model implementation.
 * 
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public class AnimationModel implements IAnimationModel {

  private LinkedHashMap<String, LinkedList<IMotion>> motions;
  private LinkedHashMap<String, IShape> shapes;
  private int x;
  private int y;
  private int width;
  private int height;
  private int animationInterval;

  /**
   * Construct an animation model.
   * 
   * @param motions           motion of the animation model
   * @param shapes            shapes of the animation model
   * @param x                 Corner x-position of the animation model frame
   * @param y                 Corner y-position of the animation model frame
   * @param width             width of the animation model frame
   * @param height            height of the animation model frame
   * @param animationInterval animation interval of the animation model
   */
  public AnimationModel(LinkedHashMap<String, 
      LinkedList<IMotion>> motions, 
      LinkedHashMap<String, IShape> shapes, 
      int x,
      int y, 
      int width, 
      int height, 
      int animationInterval) {
    this.motions = motions;
    this.shapes = shapes;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.animationInterval = animationInterval;

  }

  /**
   * Return the x of the animation model.
   */
  public int getX() {
    return this.x;
  }

  /**
   * Return the y of the animation model.
   */
  public int getY() {
    return this.y;
  }

  /**
   * Return the width of the animation model.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Return the height of the animation model.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Return the animation interval of the animation model.
   */
  public int getAnimationInterval() {
    return this.animationInterval;
  }

  /**
   * Return the list of shapes showing the status.
   */
  public List<IShape> getState(int time) {
    List<IShape> result = new ArrayList<>();

    for (Map.Entry<String, LinkedList<IMotion>> entry : this.motions.entrySet()) {
      String key = entry.getKey();
      IShape shape = this.shapes.get(key);

      IMotion motion = this.motions.get(key).getFirst();

      if (time > motion.getEndTime()) {
        this.motions.get(key).removeFirst();

        if (this.motions.get(key).isEmpty()) {
          this.motions.remove(key);
          continue;
        }
        motion = this.motions.get(key).getFirst();
      }

      if (time >= motion.getStartTime() && time <= motion.getEndTime()) {
        int timeDiff = motion.getEndTime() - motion.getStartTime();
        int xDiff = motion.getEndX() - motion.getStartX();
        int yDiff = motion.getEndY() - motion.getStartY();
        int widthDiff = motion.getEndWidth() - motion.getStartWidth();
        int heightDiff = motion.getEndHeight() - motion.getStartHeight();
        int redDiff = motion.getEndRedColor() - motion.getStartRedColor();
        int blueDiff = motion.getEndBlueColor() - motion.getStartBlueColor();
        int greenDiff = motion.getEndGreenColor() - motion.getStartGreenColor();

        int resX = motion.getStartX() 
            + (int) Math.round(((time - motion.getStartTime()) / (double) timeDiff) * xDiff);
        int resY = motion.getStartY() 
            + (int) Math.round(((time - motion.getStartTime()) / (double) timeDiff) * yDiff);
        int resWidth = motion.getStartWidth()
            + (int) Math.round(((time - motion.getStartTime()) / (double) timeDiff) * widthDiff);
        int resHeight = motion.getStartHeight()
            + (int) Math.round(((time - motion.getStartTime()) / (double) timeDiff) * heightDiff);
        int resRed = motion.getStartRedColor()
            + (int) Math.round(((time - motion.getStartTime()) / (double) timeDiff) * redDiff);
        int resGreen = motion.getStartGreenColor()
            + (int) Math.round(((time - motion.getStartTime()) / (double) timeDiff) * greenDiff);
        int resBlue = motion.getStartBlueColor()
            + (int) Math.round(((time - motion.getStartTime()) / (double) timeDiff) * blueDiff);

        shape.setX(resX);
        shape.setY(resY);
        shape.setWidth(resWidth);
        shape.setHeight(resHeight);
        shape.setRedColor(resRed);
        shape.setBlueColor(resBlue);
        shape.setGreenColor(resGreen);

        result.add(shape);

      }
    }

    return result;

  }

  /**
   * Return the string of all svg tags.
   */
  public String getSVG(int tick) {
    StringBuilder out = new StringBuilder();

    for (Map.Entry<String, LinkedList<IMotion>> entry : this.motions.entrySet()) {
      String key = entry.getKey();
      IShape shape = this.shapes.get(key);
      IMotion motion = this.motions.get(key).getFirst();

      if (shape.getShapeType().equalsIgnoreCase("Rectangle")) {
        out.append(String.format("<rect id=\"%s\" x=%s y=%s width=%s height=%s " 
                                + "fill=\"rgb(%s, %s, %s)\" visibility=\"hidden\">\n", key,
            motion.getStartX(), motion.getStartY(), motion.getStartWidth(), 
            motion.getStartHeight(),
            motion.getStartRedColor(), motion.getStartGreenColor(), motion.getStartBlueColor()));

        out.append(String.format("<animate attributeType=\"CSS\" begin=\"%fs\" dur=\"%fs\"" +
            " attributeName=\"visibility\" from=\"visible\" to=\"hidden\"/>\n", 
            motion.getStartTime() / (double) tick, animationInterval + 1000 / (double) tick));
        
        while (!this.motions.get(key).isEmpty()) {
          motion = this.motions.get(key).getFirst();
          int duration = motion.getEndTime() - motion.getStartTime();
          String startColor = String.format("rgb(%s, %s, %s)", 
                                            motion.getStartRedColor(), 
                                            motion.getStartGreenColor(),
                                            motion.getStartBlueColor());
          String endColor = String.format("rgb(%s, %s, %s)", 
                                          motion.getEndRedColor(), 
                                          motion.getEndGreenColor(),
                                          motion.getEndBlueColor());

          if (motion.getStartX() != motion.getEndX()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                    + "dur=\"%fs\" attributeName=\"x\" from=%d to=%d "
                    + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) tick, 
                duration / (double) tick, motion.getStartX(), motion.getEndX()));
          }

          if (motion.getStartY() != motion.getEndY()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                    + "dur=\"%fs\" attributeName=\"y\" from=%d to=%d "
                    + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) tick, 
                duration / (double) tick, motion.getStartY(), motion.getEndY()));
          }

          if (motion.getStartWidth() != motion.getEndWidth()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                    + "dur=\"%fs\" attributeName=\"width\" from=%d to=%d "
                    + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) tick, 
                duration / (double) tick, motion.getStartWidth(),
                motion.getEndWidth()));
          }

          if (motion.getStartHeight() != motion.getEndHeight()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                    + "dur=\"%fs\" attributeName=\"height\" from=%d to=%d "
                    + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) tick, 
                duration / (double) tick, motion.getStartHeight(),
                motion.getEndHeight()));
          }

          if (!startColor.equals(endColor)) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" "
                    + "dur=\"%fs\" attributeName=\"fill\" from=\"%s\" to=\"%s\" " 
                    + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) tick, 
                duration / (double) tick, startColor, endColor));
          }

          this.motions.get(key).removeFirst();
        }

        out.append("</rect>\n");
      }

      else {
        out.append(String.format("<ellipse id=\"%s\" cx=%s cy=%s rx=%s ry=%s " 
                                + "fill=\"rgb(%s, %s, %s)\" visibility=\"hidden\">\n", key,
                                 motion.getStartX(), motion.getStartY(), 
                                 motion.getStartWidth(), motion.getStartHeight(),
                                 motion.getStartRedColor(), 
                                 motion.getStartGreenColor(), 
                                 motion.getStartBlueColor()));

        out.append(String.format("<animate attributeType=\"CSS\" begin=\"%fs\" dur=\"%fs\"" +
            " attributeName=\"visibility\" from=\"visible\" to=\"hidden\"/>\n", 
            motion.getStartTime() / (double) tick, animationInterval + 1000 / (double) tick));
        
        while (!this.motions.get(key).isEmpty()) {
          motion = this.motions.get(key).getFirst();
          int duration = motion.getEndTime() - motion.getStartTime();
          String startColor = String.format("rgb(%s, %s, %s)", 
                                            motion.getStartRedColor(), 
                                            motion.getStartGreenColor(),
                                            motion.getStartBlueColor());
          String endColor = String.format("rgb(%s, %s, %s)", 
                                          motion.getEndRedColor(), 
                                          motion.getEndGreenColor(),
                                          motion.getEndBlueColor());

          if (motion.getStartX() != motion.getEndX()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                    + "dur=\"%fs\" attributeName=\"cx\" from=%d to=%d "
                    + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) tick, 
                duration / (double) tick, motion.getStartX(), motion.getEndX()));
          }

          if (motion.getStartY() != motion.getEndY()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                    + "dur=\"%fs\" attributeName=\"cy\" from=%d to=%d "
                    + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) tick, 
                duration / (double) tick, motion.getStartY(), motion.getEndY()));
          }

          if (motion.getStartWidth() != motion.getEndWidth()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                    + "dur=\"%fs\" attributeName=\"rx\" from=%d to=%d "
                    + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) tick, 
                duration / (double) tick, motion.getStartWidth(),
                motion.getEndWidth()));
          }

          if (motion.getStartHeight() != motion.getEndHeight()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                    + "dur=\"%fs\" attributeName=\"ry\" from=%d to=%d "
                    + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) tick, 
                duration / (double) tick, motion.getStartHeight(),
                motion.getEndHeight()));
          }

          if (!startColor.equals(endColor)) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" "
                    + "dur=\"%fs\" attributeName=\"fill\" from=\"%s\" to=\"%s\" " 
                    + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) tick, 
                duration / (double) tick, startColor, endColor));
          }

          this.motions.get(key).removeFirst();
        }

        out.append("</ellipse>\n");
      }

    }

    return out.toString();
  }

}
