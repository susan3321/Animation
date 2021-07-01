
package view;

import java.io.IOException;
import java.io.PrintWriter;
import model.IAnimationModel;


/**
 * Represents the transformation from a textual view to the SVG format.
 * 
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public class SVGView implements IView {
  IAnimationModel model;
  String outFile;
  int speed;

  /**
   * Creates an object of SVGView when the model output file path and speed given.
   * 
   * @param model   the IAnimationModel
   * @param outFile output svg file
   * @param speed   tick speed
   */
  public SVGView(IAnimationModel model, String outFile, int speed) {
    this.model = model;
    this.outFile = outFile;
    this.speed = speed;
  }

  @Override
  public void display() throws IOException {
    try {
      PrintWriter out = new PrintWriter(outFile);
      out.print(String.format("<svg xmlns=\"http://www.w3.org/2000/svg\" x=%s"
          + " y=%s width=%s height=%s version=\"1.1\">\n", 
          model.getX(), model.getY(), model.getWidth(), model.getHeight()));

      out.print(model.getSVG(speed));
      out.print("</svg>\n");
      out.close();
    } catch (IOException e) {
      throw new IOException("Error when appending the svg view.");
    }
  }

}
