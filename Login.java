import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LoginFrame extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("REGISTER");
    JCheckBox showPassword = new JCheckBox("Show Password");
    private Boolean userFound = false;
    public static String userText;
    public static String pwdText;
 
    public LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 350, 100, 30);
        resetButton.setBounds(200, 350, 100, 30);
    }
 
    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            try {
                File Obj = new File("Users.txt");
                Scanner Reader = new Scanner(Obj);
                while (Reader.hasNextLine()) {
                    String data = Reader.nextLine();
                    String[] credentials = data.split(" ",5);
                    System.out.println(credentials[0]+credentials[1]);
                    if (userText.equalsIgnoreCase(credentials[0]) && pwdText.equalsIgnoreCase(credentials[1])) {
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        dispose();
                        userFound = true;
                        MainFrame frame1 = new MainFrame();
                        break;
                    }    
                }
                if(userFound == false){
                    JOptionPane.showMessageDialog(this,"You are not Registered Bro");
                }
                Reader.close();
            }
            catch (FileNotFoundException except) {
                System.out.println("An error has occurred.");
                except.printStackTrace();
            }
            
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            MyFrame frame = new MyFrame();
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
 
}
 
class Login {
    public static void main(String[] a) {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
 
}