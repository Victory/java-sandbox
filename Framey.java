import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import victory.windowy.VicWindowListener;


public class Framey extends Frame implements ActionListener {

  private Button btn;
  private TextField cookieText;
  Integer numCookies = 0;

  private static final long serialVersionUID = 1L;

  Framey () {
    setLayout(new FlowLayout());
    setTitle("Framey Thing");
    btn = new Button("Cookie");
    btn.addActionListener(this);
    add(btn);


    cookieText = new TextField(numCookies.toString(), 5);
    cookieText.setEditable(false);
    cookieText.setText(numCookies.toString());
    add(cookieText);

    addWindowListener(new VicWindowListener());

    setSize(250, 250);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Framey();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    numCookies += 1;
    cookieText.setText(numCookies.toString());
  }

}
