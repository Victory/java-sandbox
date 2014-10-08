import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import victory.windowy.VicWindowListener;


public class Framey extends Frame implements ActionListener {

  private Integer cookiesPerClick = 1;
  private Button cookieBtn;
  private Button buyPowerUpClickBtn;
  private Button buyAutoClickerBtn;

  private TextField cookieText;
  Integer numCookies = 0;
  int numAutoClickers = 0;

  static final Integer costAutoClicker = 10;

  private static final long serialVersionUID = 1L;

  Framey () {
    setLayout(new FlowLayout());
    setTitle("Cookie Framey Thing");
    cookieBtn = new Button("Cookie");
    cookieBtn.addActionListener(this);
    add(cookieBtn);

    cookieText = new TextField(numCookies.toString(), 5);
    cookieText.setEditable(false);
    cookieText.setText(numCookies.toString());
    add(cookieText);

    bindByAutoClicker();
    add(buyAutoClickerBtn);

    bindByPowerUpClickBtn();
    add(buyPowerUpClickBtn);

    addWindowListener(new VicWindowListener());

    setSize(250, 250);
    setVisible(true);
  }

  private void bindByPowerUpClickBtn() {
    buyPowerUpClickBtn = new Button("Buy Power Up Click");
    final Framey mainFrame = this;
    buyPowerUpClickBtn.addActionListener(new ActionListener (){
      @Override
      public void actionPerformed(ActionEvent e) {
        cookiesPerClick += 1;
      }
    });
  }

  private void bindByAutoClicker() {
    buyAutoClickerBtn = new Button("Buy Auto Clicker");
    final Framey mainFrame = this;
    buyAutoClickerBtn.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (numCookies < costAutoClicker) {
              String c = costAutoClicker.toString();
              new Sorry(
                  mainFrame,
                  "you can't afford that (costs " + c + " cookies)");
              return;
            }
            numCookies -= 10;
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
    incrementCounter(this.cookiesPerClick);
  }

  private void incrementCounter (int inc) {
    numCookies += inc;
    cookieText.setText(numCookies.toString());
  }

  private void startAutoClicker () {

    if (numAutoClickers > 0) {
      new Sorry(this, "you already have an auto clicker");
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
