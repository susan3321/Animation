package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.Timer;
import model.AnimationBuilderImpl;
import model.AnimationReader;
import model.IAnimationModel;
import model.IShape;
import view.AnimationView;
import view.SVGView;
import view.TextView;

/**
 * Create the animation controller to show the different types of views.
 * 
 * @author Xinyao Liu, Jingshan Yang
 */
public class AnimationController {

  private int speed = 1;
  private String inFile;
  private String viewType = "visual";
  private String outFile;
  private Timer timer;
  private int tick = 0;
  private IAnimationModel model;

  /**
   * Construct an animation controller.
   * 
   * @param speed    speed of the animation
   * @param viewType view type of the animation
   * @param inFile   input file of the animation
   * @param outFile  outfile of the animation
   */
  public AnimationController(int speed, String viewType, String inFile, String outFile) {

    this.speed = speed;
    this.inFile = inFile;
    this.viewType = viewType;
    this.outFile = outFile;

    try {
      model = AnimationReader.parseFile(new FileReader(inFile), 
                                        new AnimationBuilderImpl());
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Start method that used to control the showing of different views.
   */
  public void play() {
    AnimationView visualView;
    TextView textView;
    SVGView svgView;

    if (this.viewType.equals("visual")) {

      visualView = new AnimationView(model, speed);
      visualView.display();
      try {
        visualView.addListener(this);
      } catch (UnsupportedOperationException e) {
        e.printStackTrace();
      }
      this.timer = new Timer((int) ((1.0 / speed) * 1000), ((e) -> {
        if (tick == model.getAnimationInterval()) {
          timer.stop();
        }
        List<IShape> curShapes = model.getState(tick++);
        visualView.render(curShapes);
      }));
    }

    else if (this.viewType.equals("text")) {
      textView = new TextView(model, speed);
      try {
        textView.display();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    else if (this.viewType.equals("svg")) {
      svgView = new SVGView(model, outFile, speed);
      try {
        svgView.display();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    else {
      throw new IllegalArgumentException("InValid view type!");
    }
  }

  /**
   * Start button.
   */
  public void start() {
    timer.start();
  }

  /**
   * Stop button.
   */
  public void pause() {
    timer.stop();
  }

  /**
   * Restart button.
   */
  public void restart() {
    try {
      model = AnimationReader.parseFile(new FileReader(inFile), 
                                        new AnimationBuilderImpl());
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    tick = 0;
    timer.start();
  }

}
