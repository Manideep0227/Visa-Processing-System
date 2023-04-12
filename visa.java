import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
 
class MainFrame
    extends JFrame
    implements ActionListener {
 
    // Components of the Form
    private Container c;
    private JLabel country;
    private JTextField tcountry;
    private JButton ApplyForVisa;
    private JButton Logout;
    private JButton seeStatus;
    private JLabel startDate;
    private JLabel endDate;
    private JComboBox startDay;
    private JComboBox startMonth;
    private JComboBox startYear;
    private JComboBox endDay;
    private JComboBox endMonth;
    private JComboBox endYear;
    private JLabel title;
    private JLabel visa;
    private JTextField tvisa;
    private JButton Apply;
    public Boolean ApplyVisa = false;

    private String dates[]
        = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
        = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sep", "Oct", "Nov", "Dec" };
    private String years[]
        = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };
 
    // const
 
    // constructor, to initialize the components
    // with default values.
    public MainFrame()
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

        startDate = new JLabel("Start Date");
        startDate.setFont(new Font("Arial", Font.PLAIN, 20));
        startDate.setSize(100, 20);
        startDate.setLocation(300, 150);
        c.add(startDate);
 
        startDay = new JComboBox(dates);
        startDay.setFont(new Font("Arial", Font.PLAIN, 15));
        startDay.setSize(50, 20);
        startDay.setLocation(400, 150);
        c.add(startDay);
 
        startMonth = new JComboBox(months);
        startMonth.setFont(new Font("Arial", Font.PLAIN, 15));
        startMonth.setSize(60, 20);
        startMonth.setLocation(450, 150);
        c.add(startMonth);
 
        startYear = new JComboBox(years);
        startYear.setFont(new Font("Arial", Font.PLAIN, 15));
        startYear.setSize(60, 20);
        startYear.setLocation(520, 150);
        c.add(startYear);

        endDate = new JLabel("End Date");
        endDate.setFont(new Font("Arial", Font.PLAIN, 20));
        endDate.setSize(100, 20);
        endDate.setLocation(300, 200);
        c.add(endDate);
 
        endDay = new JComboBox(dates);
        endDay.setFont(new Font("Arial", Font.PLAIN, 15));
        endDay.setSize(50, 20);
        endDay.setLocation(400, 200);
        c.add(endDay);
 
        endMonth = new JComboBox(months);
        endMonth.setFont(new Font("Arial", Font.PLAIN, 15));
        endMonth.setSize(60, 20);
        endMonth.setLocation(450, 200);
        c.add(endMonth);
 
        endYear = new JComboBox(years);
        endYear.setFont(new Font("Arial", Font.PLAIN, 15));
        endYear.setSize(60, 20);
        endYear.setLocation(520, 200);
        c.add(endYear);

        visa = new JLabel("Visa Type");
        visa.setFont(new Font("Arial", Font.PLAIN, 20));
        visa.setSize(100, 20);
        visa.setLocation(300, 250);
        c.add(visa);
 
        tvisa = new JTextField();
        tvisa.setFont(new Font("Arial", Font.PLAIN, 15));
        tvisa.setSize(190, 20);
        tvisa.setLocation(400, 250);
        c.add(tvisa);

        Apply = new JButton("Apply");
        Apply.setFont(new Font("Arial", Font.PLAIN, 15));
        Apply.setSize(100, 40);
        Apply.setLocation(350, 300);
        Apply.addActionListener(this);
        c.add(Apply);




        country = new JLabel("to Country");
        country.setFont(new Font("Arial", Font.PLAIN, 20));
        country.setSize(100, 20);
        country.setLocation(300, 100);
        c.add(country);
 
        tcountry = new JTextField();
        tcountry.setFont(new Font("Arial", Font.PLAIN, 15));
        tcountry.setSize(190, 20);
        tcountry.setLocation(400, 100);
        c.add(tcountry);


 
 
 
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
            if(ApplyVisa == true){
                appliedFrame f = new appliedFrame();
            }
            else{
                MainFrame f = new MainFrame();
            }
            
        }
        else if (e.getSource() == seeStatus) {
            // What should we do on clicking on see status
        }
        else if(e.getSource() == Logout){
            // What should we do on clicking on Logout
            dispose();
            LoginFrame lFrame = new LoginFrame();
        }
        else if(e.getSource() == Apply){
            // Whot should we do on clicking Apply button
            try{
                String result = LoginFrame.userText+" "+ tcountry.getText() +" "+tvisa.getText()+" "+"In Progress"+"\n";
                FileWriter writer = new FileWriter("Visa.txt",true);
                writer.write(result);
                writer.close();
                dispose();
                ApplyVisa = true;
                appliedFrame frame1 = new appliedFrame();
            }
            catch(IOException exception){
                exception.printStackTrace();
                System.out.println("An error has occurred");
            }
        }
    }
}
 
// Driver Code
class visa {
    public static void main(String[] args) throws Exception
    {
        MainFrame f = new MainFrame();
    }
}
