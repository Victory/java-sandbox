import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import victory.windowy.VicWindowListener;


public class Framey extends Frame implements ActionListener {

  private static final long serialVersionUID = 1L;

  Framey () {
    setLayout(new FlowLayout());
    setTitle("Framey Thing");
    Button btn = new Button("press me");
    add(btn);
    setSize(250, 250);
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    WindowListener windowListener = new VicWindowListener();

    addWindowListener(windowListener);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Framey();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub

  }

}
