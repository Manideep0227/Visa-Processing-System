import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.*;
class statusFrame
    extends JFrame
    implements ActionListener {
 
    // Components of the Form
    private Container c;
    private JButton ApplyForVisa;
    private JButton Logout;
    private JButton seeStatus;
    private JLabel title;
    private JLabel name;
    private JLabel country;
    private JLabel VisaType;
    private JLabel Progress;
    private JLabel tname;
    private JLabel tcountry;
    private JLabel tVisaType;
    private JLabel tProgress;
    private String visaName;
    private String visaCountry;
    private String visaType;
   

    
    // constructor, to initialize the components
    // with default values.
    public statusFrame()
    {
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

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 30));
        name.setSize(300, 30);
        name.setLocation(300, 200);
        c.add(name);

        country = new JLabel("Country");
        country.setFont(new Font("Arial", Font.PLAIN, 30));
        country.setSize(300, 30);
        country.setLocation(300, 250);
        c.add(country);

        VisaType = new JLabel("Visa Type");
        VisaType.setFont(new Font("Arial", Font.PLAIN, 30));
        VisaType.setSize(300, 30);
        VisaType.setLocation(300, 300);
        c.add(VisaType);

        Progress = new JLabel("status");
        Progress.setFont(new Font("Arial", Font.PLAIN, 30));
        Progress.setSize(300, 30);
        Progress.setLocation(300, 350);
        c.add(Progress);
        try {
            File Obj = new File("Visa.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                String[] visaData = data.split(" ",4);
                System.out.println(visaData[0]+" "+visaData[1]+" ");
                System.out.println(LoginFrame.userText);
                if(LoginFrame.userText.equals(visaData[0])){
                    System.out.println(LoginFrame.userText);
                    visaName = visaData[0];
                    visaCountry = visaData[1];
                    visaType = visaData[2];
                    break;
                }
            }
            Reader.close();
        }
        catch (IOException except) {
            System.out.println("An error has occurred.");
            except.printStackTrace();
        }

        tname = new JLabel(visaName);
        tname.setFont(new Font("Arial", Font.PLAIN, 30));
        tname.setSize(300, 30);
        tname.setLocation(500, 200);
        c.add(tname);

        tcountry = new JLabel(visaCountry);
        tcountry.setFont(new Font("Arial", Font.PLAIN, 30));
        tcountry.setSize(300, 30);
        tcountry.setLocation(500, 250);
        c.add(tcountry);

        tVisaType = new JLabel(visaType);
        tVisaType.setFont(new Font("Arial", Font.PLAIN, 30));
        tVisaType.setSize(300, 30);
        tVisaType.setLocation(500, 300);
        c.add(tVisaType);

        tProgress = new JLabel("In Progress");
        tProgress.setFont(new Font("Arial", Font.PLAIN, 30));
        tProgress.setSize(300, 30);
        tProgress.setLocation(500, 350);
        c.add(tProgress);






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
        
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == ApplyForVisa) {
            MainFrame f = new MainFrame();
        }
        else if (e.getSource() == seeStatus) {
            // What should we do on clicking on see status

        }
        else if(e.getSource() == Logout){
            dispose();
            LoginFrame lFrame = new LoginFrame();
        }
    }
}
 
// Driver Code
class visa {
 
    public static void main(String[] args) throws Exception
    {
        statusFrame f = new statusFrame();
    }
}
