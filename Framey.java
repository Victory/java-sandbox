import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import victory.windowy.VicWindowListener;


public class Framey extends Frame implements ActionListener {

  private Button btn;
  private Button buyAutoClicker;

  private TextField cookieText;
  Integer numCookies = 0;
  int numAutoClickers = 0;

  private static final long serialVersionUID = 1L;

  Framey () {
    setLayout(new FlowLayout());
    setTitle("Framey Thing");
    btn = new Button("Cookie");
    btn.addActionListener(this);
    add(btn);

    bindByAutoClicker();

    cookieText = new TextField(numCookies.toString(), 5);
    cookieText.setEditable(false);
    cookieText.setText(numCookies.toString());
    add(cookieText);

    add(buyAutoClicker);

    addWindowListener(new VicWindowListener());

    setSize(250, 250);
    setVisible(true);
  }

  private void bindByAutoClicker() {
    buyAutoClicker = new Button("Buy Auto Clicker");
    buyAutoClicker.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            startAutoClicker();
          }
        });
  }

  public static void main(String[] args) {
    new Framey();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    incrementCounter(1);
  }

  private void incrementCounter (int inc) {
    numCookies += inc;
    cookieText.setText(numCookies.toString());
  }

  private void startAutoClicker () {

    if (numAutoClickers > 0) {
      String message = "you already have an auto clicker";
      JOptionPane.showMessageDialog(this, message);
      return;
    }
    numAutoClickers += 1;

    Timer timer = new Timer(true);
    TimerTask task = new TimerTask() {

      @Override
      public void run() {
        incrementCounter(1);
      }
    };

    long delay = 0;
    long period = 1000;
    timer.scheduleAtFixedRate(task, delay, period);
  }
}
