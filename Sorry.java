import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Sorry extends Frame {
  private static final long serialVersionUID = 1L;

  public Sorry(Frame parentFrame, String message) {
    setLayout(new FlowLayout());
    setTitle("Sorry");
    setSize(300, 100);

    Label label = new Label(message);
    add(label);

    Button btn = new Button("Close");
    btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }

    });

    add(btn);
    setVisible(true);
  }
}
