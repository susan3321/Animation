package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import model.IShape;

/**
 * Represents a drawing panel for the animation view, which draws the shapes at
 * each time of an animation.
 * 
 * @author Xinyao Liu, Jingshan Yang
 *
 */

public class AnimationPanel extends JPanel {
  List<IShape> shapes;

  /**
   * Creates an object of AnimationPanel when x, y, width and height are given.
   * 
   * @param x      the location of the panel
   * @param y      the location of the panel
   * @param width  the size of the panel
   * @param height the size of the panel
   */
  public AnimationPanel(int x, int y, int width, int height) {
    super();
    this.setBackground(Color.WHITE);
    this.setSize(width, height);
    this.setLocation(x, y);
    this.setPreferredSize(new Dimension(width, height));
  }

  /**
   * Gets the list of shapes to draw.
   * 
   * @param shapes a list of shape objects
   */
  public void draw(List<IShape> shapes) {
    this.shapes = shapes;
    repaint();
  }

  /**
   * Paint the components for the graphic.
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (this.shapes != null && !this.shapes.isEmpty()) {
      Iterator<IShape> iter = this.shapes.iterator();
      while (iter.hasNext()) {
        IShape shape = iter.next();
        Color color = new Color(shape.getRedColor(), shape.getGreenColor(), shape.getBlueColor());
        g.setColor(color);
        if (shape.getShapeType().equalsIgnoreCase("rectangle")) {
          g.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        } else {
          g.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        }
      }
    }
  }

}
