package view;


import java.util.Iterator;
import model.IAnimationModel;
import model.IShape;

/**
 * Represents a textual output of the model.
 * 
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public class TextView implements IView {
  IAnimationModel model;
  int speed;

  /**
   * Creates an object of TextView when model and speed are given.
   * @param model the IAnimationModel
   * @param speed the display speed
   */
  public TextView(IAnimationModel model, int speed) {
    this.model = model;
    this.speed = speed;
  }
  
  /**
   * Display the animation.
   */
  @Override
  public void display() throws InterruptedException {
    for (int i = 1; i <= this.model.getAnimationInterval(); i++) {
      Thread.sleep((long) Math.floor(1000 / speed));
      Iterator<IShape> iter = model.getState(i).iterator();
      while (iter.hasNext()) {
        System.out.println(i + ": " + iter.next().toString() + "\n");
      }
    }
  }

}
