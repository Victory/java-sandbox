import java.awt.Component;

import javax.swing.JOptionPane;


public class HelloWorldGUI {
  /**
   * @param args
   */
  public static void main(String[] args) {
    Component parentComponent = null;
    String message = "Hello World With GUI";
    JOptionPane.showMessageDialog(parentComponent, message);
  }

}
