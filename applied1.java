import javax.swing.*;
import javax.xml.transform.stax.StAXResult;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
 
class appliedFrame
    extends JFrame
    implements ActionListener {
 
    // Components of the Form
    private Container c;
    private JButton ApplyForVisa;
    private JButton Logout;
    private JButton seeStatus;
    private JLabel title;
    private JLabel apply;
   

    
    // constructor, to initialize the components
    // with default values.
    public appliedFrame()
    {   System.out.println("Entered into applied frame");
        setTitle("Apply For Visa");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Apply For Visa");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);


        ApplyForVisa = new JButton("Apply For Visa");
        ApplyForVisa.setFont(new Font("Arial", Font.PLAIN, 15));
        ApplyForVisa.setSize(150, 20);
        ApplyForVisa.setLocation(50, 200);
        ApplyForVisa.addActionListener(this);
        c.add(ApplyForVisa);

        seeStatus = new JButton("See Status");
        seeStatus.setFont(new Font("Arial", Font.PLAIN, 15));
        seeStatus.setSize(150, 20);
        seeStatus.setLocation(50, 250);
        seeStatus.addActionListener(this);
        c.add(seeStatus);

        Logout = new JButton("Logout");
        Logout.setFont(new Font("Arial", Font.PLAIN, 15));
        Logout.setSize(150, 20);
        Logout.setLocation(50, 300);
        Logout.addActionListener(this);
        c.add(Logout);

        apply = new JLabel("Your visa is successfully applied");
        apply.setForeground(new Color(0,100,0));
        apply.setFont(new Font("Arial", Font.PLAIN, 20));
        apply.setSize(300, 30);
        apply.setLocation(300, 250);
        c.add(apply);
        
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == ApplyForVisa) {
            System.out.println("Entered into apply for visa");
            MainFrame f = new MainFrame();
        }
        else if (e.getSource() == seeStatus) {
            // What should we do on clicking on see status
            dispose();
            System.out.println("Entered into status ");
            statusFrame sFrame = new statusFrame();

        }
        else if(e.getSource() == Logout){
            // What should we do on clicking on Logout
            dispose();
            System.out.println("Entered into Logout");
            LoginFrame lFrame = new LoginFrame();
        }
    }
}
 
// Driver Code
class applied1 {
 
    public static void main(String[] args) throws Exception
    {
        appliedFrame f = new appliedFrame();
    }
}

