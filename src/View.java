import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class View extends JFrame{

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JLabel fnameL, lnameL;
    private JTextField fnameTF, lnameTF, citeTF;
    private JRadioButton ieeeRB, acmRB;
    private Citation cite;
   
    //Button and text handlers:
    private TextHandler THandler;
    private RadioButtonHandler RHandler;
     
    public View()
    {
    	cite = new Citation("","");
        fnameL = new JLabel("FirstName: ", SwingConstants.LEFT);
        lnameL = new JLabel("LastName: ", SwingConstants.LEFT);
 
        fnameTF = new JTextField(10);
        lnameTF = new JTextField(10);
        citeTF = new JTextField(10);
        
        fnameTF.addKeyListener(THandler);
        lnameTF.addKeyListener(THandler);
        citeTF.setEditable(false);

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
        acmRB.setSelected(false);
        THandler = new TextHandler();
        acmRB.addActionListener(RHandler);

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
    
    public class RadioButtonHandler implements ActionListener {

    	@Override
    	public void actionPerformed(ActionEvent e) {
   
    		cite.setFirstName(fnameTF.getText());
			cite.setLastName(lnameTF.getText());
			
    		switch(e.getActionCommand()){
    			case "IEEE" :	
    				if(ieeeRB.isSelected())
    				{
    					acmRB.setSelected(false);
    					citeTF.setText(cite.getFirstNameAbbrev() + "" + cite.getLastName());
    				}
    				break;
    							
    			case "ACM" :	
    				if(acmRB.isSelected())
    				{
    					ieeeRB.setSelected(false);
    					citeTF.setText(cite.getFirstName() + "" + cite.getLastNameWPeriod());
    				}
    				break;
    							
    			default:break;
    		}
    	}

    }
    
    public class TextHandler implements KeyListener {

    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		// TODO Auto-generated method stub
    		System.out.println(arg0.getKeyCode());
    	}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		// TODO Auto-generated method stub
    		System.out.println(arg0.getKeyCode());
    	}

    	@Override
    	public void keyTyped(KeyEvent arg0) {
    		// TODO Auto-generated method stub
    		
    	}


    }
    
    public static void main(String[] args)
    {
        View view = new View();
    }

}
