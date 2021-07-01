import controller.AnimationController;

/**
 * Create an animation class to run the animation in terminal.
 * @author Xinyao Liu, Jingshan Yang
 *
 */
public class Animation {

  /**
   * Main function to run the animation.
   * @param args input from the terminal
   */
  public static void main(String[] args) {
    int speed = 20;
    String in = "./src/buildings.txt";
    String out = "";
    String viewType = "visual";

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-in")) {
        in = args[i + 1];
      } else if (args[i].equals("-out")) {
        out = args[i + 1];
      } else if (args[i].equals("-speed")) {
        speed = Integer.parseInt(args[i + 1]);
      } else if (args[i].equals("-view")) {
        viewType = args[i + 1];
      } else {
        throw new IllegalArgumentException("InValid arguments");
      }

      i++;
    }

    AnimationController ac = new AnimationController(speed, viewType, in, out);
    ac.play();
  }

}
