package model;

import java.util.List;

/**
 * Create an interface for animation model.
 * 
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public interface IAnimationModel {

  /**
   * Outputs the list of shapes at their instantaneous state in the animation
   * based on the given time.
   * 
   * @param time in ticks
   * @return the list of shapes that represents the instantaneous state of the
   *         animation at the given time.
   */
  List<IShape> getState(int time);

  /**
   * Get the x.
   * 
   * @return the x-position of the animation model.
   */
  int getX();

  /**
   * Get the y.
   * 
   * @return the y-position of the animation model.
   */
  int getY();

  /**
   * Get the width.
   * 
   * @return the width of the animation model.
   */
  int getWidth();

  /**
   * Get the height.
   * 
   * @return the height of the animation model.
   */
  int getHeight();

  /**
   * Get the Interval.
   * 
   * @return the animation interval of the animation model.
   */
  int getAnimationInterval();
  
  /**
   * Get the SVG tags of the motions.
   * 
   * @return the string of all motions' svg tag.
   */
  String getSVG(int tick);

}
