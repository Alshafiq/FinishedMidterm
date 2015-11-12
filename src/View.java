import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class View extends JFrame{

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JLabel fnameL, lnameL;
    private JTextField fnameTF, lnameTF, citeTF;
    private JRadioButton ieeeRB, acmRB;
   
    //Button handlers:
    private TextHandler THandler;
    private RadioButtonHandler RHandler;
     
    public View()
    {
        fnameL = new JLabel("FirstName: ", SwingConstants.LEFT);
        lnameL = new JLabel("LastName: ", SwingConstants.LEFT);
 
        fnameTF = new JTextField(10);
        lnameTF = new JTextField(10);
        citeTF = new JTextField(10);

        //SPecify handlers for each button and add (register) ActionListeners to each button.
        ieeeRB = new JRadioButton("IEEE");
        ieeeRB.setMnemonic(KeyEvent.VK_B);
        ieeeRB.setActionCommand("IEEE");
        ieeeRB.setSelected(true);
        RHandler = new RadioButtonHandler();
        ieeeRB.addActionListener(RHandler);
        
        acmRB = new JRadioButton("ACM");
        acmRB.setMnemonic(KeyEvent.VK_B);
        acmRB.setActionCommand("ACM");
        acmRB.setSelected(true);
        THandler = new TextHandler();
        acmRB.addActionListener(THandler);

        setTitle("Citation Generator");
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 2));

        //Add things to the pane in the order you want them to appear (left to right, top to bottom)
        pane.add(fnameL);
        pane.add(fnameTF);
        pane.add(lnameL);
        pane.add(lnameTF);
        pane.add(ieeeRB);
        pane.add(acmRB);
        pane.add(citeTF);
         
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args)
    {
        View view = new View();
    }

}
