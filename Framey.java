import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import victory.windowy.VicWindowListener;


public class Framey extends Frame implements ActionListener {

  private Double cookiesPerClick = 1.0;
  private Double costOfCookiesPerClick = 1.0;
  private Button cookieBtn;
  private Button buyPowerUpClickBtn;
  private Integer powerClickMax = 3;// max number of power clicks
  private Button buyAutoClickerBtn;

  private TextField cookieText;
  Double numCookies = 0.0;
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
        if (numCookies < costOfCookiesPerClick) {
          new Sorry(
              mainFrame,
              "Can't afford! Current Cost: " + costOfCookiesPerClick);
          return;
        }

        if (cookiesPerClick >= powerClickMax) {
          new Sorry(
              mainFrame,
              "Sorry the limit of power clicks is " + powerClickMax);
          return;
        }

        numCookies -= Math.floor(costOfCookiesPerClick);
        setCookieCount();
        costOfCookiesPerClick = costOfCookiesPerClick * 1.2;
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
            setCookieCount();
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

  private void incrementCounter (Double inc) {
    numCookies += inc;
    setCookieCount();
  }

  private void setCookieCount () {
    Integer c = (int) Math.round(numCookies);
    cookieText.setText(c.toString());
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
        incrementCounter(1.0);
      }
    };

    long delay = 0;
    long period = 1000;
    timer.scheduleAtFixedRate(task, delay, period);
  }
}
