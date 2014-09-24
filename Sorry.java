import java.awt.Frame;

import javax.swing.JOptionPane;

/**
 *
 */

/**
 * @author user
 *
 */
public class Sorry extends Frame {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public static void sayYouAre(Frame parentFrame, String message) {
    JOptionPane.showMessageDialog(parentFrame, message);
  }

}
