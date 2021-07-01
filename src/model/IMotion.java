package model;

/**
 * Create the interface of motion.
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public interface IMotion {
  
  
  /**
   * Get the motion name.
   * @return the motion name
   */
  String getName();
  
  /**
   * Get the start x-position of the motion.
   * @return the start of x-position of the motion.
   */
  int getStartX();
  
  /**
   * Get the end x-position of the motion.
   * @return the end of x-position of the motion
   */
  int getEndX();
  
  /**
   * Get the start y-position of the motion.
   * @return the start of y-position of the motion
   */
  int getStartY();
  
  /**
   * Get the end y-position of the motion.
   * @return the end of y-position of the motion
   */
  int getEndY();
  
  /**
   * Get the start width of the motion.
   * @return the start of width of the motion
   */
  int getStartWidth();
  
  /**
   * Get the end width of the motion.
   * @return the end of width of the motion.
   */
  int getEndWidth();
  
  /**
   * Get the start height of the motion.
   * @return the start of height of the motion
   */
  int getStartHeight();
  
  /**
   * Get the end height of the motion.
   * @return the end of height of the motion
   */
  int getEndHeight();
  
  /**
   * Get the start red color of the motion.
   * @return the start of red color of the motion
   */
  int getStartRedColor();
  
  /**
   * Get the end red color of the motion.
   * @return the end of red color of the motion
   */
  int getEndRedColor();
  
  /**
   * Get the start green color of the motion.
   * @return the start of green color of the motion
   */
  int getStartGreenColor();
  
  /**
   * Get the end green color of the motion.
   * @return the end of green color of the motion
   */
  int getEndGreenColor();
  
  /**
   * Get the start blue color of the motion.
   * @return the start of blue color of the motion
   */
  int getStartBlueColor();
  
  /**
   * Get the end blue color of the motion.
   * @return the end of blue color of the motion
   */
  int getEndBlueColor();
  
  /**
   * Get the start time of the motion.
   * @return the start time of the motion
   */
  int getStartTime();
  
  /**
   * Get the end time of the motion.
   * @return the end time of the motion
   */
  int getEndTime();
  

  

}
