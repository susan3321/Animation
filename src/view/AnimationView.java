package view;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.AnimationController;
import model.IAnimationModel;
import model.IShape;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Represents a visual animation view of the model.
 * 
 * @author Xinyao Liu, Jingshan Yang
 *
 */

public class AnimationView extends JFrame implements ActionListener {

  private AnimationPanel panel;
  private AnimationController controller;

  /**
   * Creates an object of AnimationView when model and speed are given.
   * 
   * @param model model of the animation model
   * @param speed speed of the view
   */
  public AnimationView(IAnimationModel model, int speed) {
    super("Animation");
    this.setBackground(Color.WHITE);
    this.setBounds(model.getX(), model.getY(), 1000, 1000);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new AnimationPanel(model.getX(), model.getX(), model.getWidth(), model.getHeight());
    this.add(panel);

    JMenuBar menu = new JMenuBar();
    JMenu control = new JMenu("Menu");
    JMenuItem start = new JMenuItem("Start");
    JMenuItem pause = new JMenuItem("Pause");
    JMenuItem restart = new JMenuItem("Restart");
    JMenuItem quit = new JMenuItem("Quit");

    start.setActionCommand("Start");
    start.addActionListener(this);
    pause.setActionCommand("Pause");
    pause.addActionListener(this);
    restart.setActionCommand("Restart");
    restart.addActionListener(this);
    quit.setActionCommand("Quit");
    quit.addActionListener(this);

    control.add(start);
    control.add(pause);
    control.add(restart);
    control.add(quit);
    menu.add(control);
    this.setJMenuBar(menu);

    this.setVisible(true);
    panel.repaint();
  }

  /**
   * Display the animation.
   */
  public void display() {
    panel.repaint();
    this.repaint();
  }

  public void render(List<IShape> shapes) {
    panel.draw(shapes);
  }

  /**
   * Perform the action event.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String b = e.getActionCommand();
    if (b.equals("Quit")) {
      System.exit(0);
    }

    else if (b.equals("Start")) {
      controller.start();
    }

    else if (b.equals("Pause")) {
      controller.pause();
    }

    else if (b.equals("Restart")) {
      controller.restart();
    }
  }

  public void addListener(AnimationController controller) {
    this.controller = controller;
  }

}
