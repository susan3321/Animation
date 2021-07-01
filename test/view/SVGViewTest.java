package view;

import static org.junit.Assert.fail;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import model.AnimationBuilderImpl;
import model.AnimationReader;
import model.IAnimationModel;

/**
 * Test if the SVGView could handle no such file exception.
 * @author xinyaoliu
 *
 */

public class SVGViewTest {
  IAnimationModel model;
  SVGView view;
  Appendable out;
  String outFile;
  int speed;
  
  @Test
  public void test() {
    try {
      model = AnimationReader.parseFile(new FileReader("./src/controller/123.txt"), 
                                        new AnimationBuilderImpl());
      view = new SVGView(model, outFile, speed);
      view.display();
      fail("FileNotFoundException did not thrown.");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
  }

}
