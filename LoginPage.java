import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {

  JFrame frame = new JFrame();
  JButton loginbutton = new JButton("Login");
  JButton resetbutton = new JButton("Reset");
  JTextField userIDField = new JTextField();
  JPasswordField userPasswordField = new JPasswordField();
  JLabel userIDLabel = new JLabel("USER ID:");
  JLabel userPasswordLabel = new JLabel("Password:");
  JLabel messageLabel = new JLabel();

  HashMap<String, String> logininfo = new HashMap<String, String>();

  LoginPage(HashMap<String, String> loginfoOriginal) {
    logininfo = loginfoOriginal;

    userIDLabel.setBounds(50, 100, 75, 25);
    userPasswordLabel.setBounds(50, 150, 75, 25);

    messageLabel.setBounds(125, 250, 250, 35);
    messageLabel.setFont(new Font(null, Font.ITALIC, 25));

    userIDField.setBounds(125, 100, 200, 25);
    userPasswordField.setBounds(125, 150, 200, 25);

    loginbutton.setBounds(125, 200, 100, 25);
    loginbutton.setFocusable(false);
    loginbutton.addActionListener(this);

    resetbutton.setBounds(225, 200, 100, 25);
    resetbutton.setFocusCycleRoot(false);
    resetbutton.addActionListener(this);

    frame.add(userIDLabel);
    frame.add(loginbutton);
    frame.add(resetbutton);
    frame.add(userPasswordLabel);
    frame.add(messageLabel);
    frame.add(userIDField);
    frame.add(userPasswordField);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 420);
    frame.setLayout(null);
    frame.setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == resetbutton) {
      userIDField.setText("");
      userPasswordField.setText(null);
    }

    if (e.getSource() == loginbutton) {
      String userID = userIDField.getText();
      String password = String.valueOf(userPasswordField.getPassword());
      if (logininfo.containsKey(userID)) {
        if (logininfo.get(userID).equals(password)) {

          messageLabel.setText("Login Successful");
          messageLabel.setForeground(Color.ORANGE);
          frame.dispose();
          Welcome welcomePage = new Welcome(userID);
        } else {
          messageLabel.setText("Wrong Password");
          messageLabel.setForeground(Color.RED);
        }
      } else {
        messageLabel.setText("Username Not Found");
        messageLabel.setForeground(Color.RED);
      }

    }

  }
}
