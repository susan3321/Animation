package view;

import static org.junit.Assert.fail;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.junit.Test;
import model.AnimationBuilderImpl;
import model.AnimationReader;
import model.IAnimationModel;

/**
 * Test if the TextView could handle no such file exception.
 * @author xinyaoliu
 *
 */
public class TextViewTest {
  IAnimationModel model;
  TextView view;
  int speed;

  @Test
  public void test() {
    try {
      model = AnimationReader.parseFile(new FileReader("./src/controller/123.txt"), 
                                        new AnimationBuilderImpl());
      view = new TextView(model, speed);
      view.display();
      fail("FileNotFoundException did not thrown.");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
