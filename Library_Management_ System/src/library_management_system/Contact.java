package library_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Contact extends JFrame implements ActionListener
{
    String colorpanel_ = "#90A4AE";
    String colorTField_ = "#ECEFF1";
    String colorbutton_ = "#CFD8DC";
    
    JLabel l_Contact = new JLabel("Contact Us");
    JLabel l_uname = new JLabel("Name ");
    JTextField tf_uname = new JTextField(15);
    
    JLabel l_email = new JLabel("Email ");
    JTextField tf_email = new JTextField(15);
    
    JLabel l_phone = new JLabel("Contact Number ");
    JTextField tf_phone = new JTextField(15);
    
    JLabel l_msg = new JLabel("Message");
    JTextArea ta_msg = new JTextArea();
    
    JButton b_send = new JButton("SEND");
    
    JPanel panel = new JPanel();
    JButton btn = new JButton();
    JTextField fld = new JTextField();
    
    Font lgfnt = new Font("Times New Roman", Font.BOLD, 25);
    Font lbfnt = new Font("Times New Roman", Font.BOLD, 17);
    Font lfnt = new Font("Times New Roman", Font.PLAIN, 17);
    Font tfnt = new Font("Times New Roman", Font.PLAIN, 15);
    Connection con=null;
    Statement st = null;
    ResultSet rs=null;

    Contact() 
    {
        super("Contact");
        panel.setLayout(null);
        add(panel);
        panel.setBackground(Color.decode(colorpanel_));
        setSize(480, 600);
        setVisible(true);
        setLocation(800, 100);
        setResizable(false);
        label_and_tex();
        button();

    }
    void label_and_tex()
    {
    	l_Contact.setBounds(20, 5,200,60);
        l_Contact.setFont(lgfnt);
        l_Contact.setForeground(Color.black);
        panel.add(l_Contact);
    	
        l_uname.setBounds(100, 60,200,60);
        l_uname.setFont(lfnt);
        l_uname.setForeground(Color.black);
        panel.add(l_uname);
        
        l_email.setBounds(100, 120, 200, 60);
        l_email.setFont(lfnt);
        l_email.setForeground(Color.black);
        panel.add(l_email);
        
        l_phone.setBounds(28, 180, 200, 60);
        l_phone.setFont(lfnt);
        l_phone.setForeground(Color.black);
        panel.add(l_phone);
        
        l_msg.setBounds(80, 230, 200, 60);
        l_msg.setFont(lfnt);
        l_msg.setForeground(Color.black);
        panel.add(l_msg);
        

        tf_uname.setBounds(160, 75, 180, 30);
        tf_uname.setForeground(Color.black);
        tf_uname.setFont(tfnt);
        tf_uname.setBackground(Color.decode(colorbutton_));
        panel.add(tf_uname);
        
        tf_email.setBounds(160, 135, 180, 30);
        tf_email.setForeground(Color.black);
        tf_email.setFont(tfnt);
        tf_email.setBackground(Color.decode(colorbutton_));
        panel.add(tf_email);
        
        tf_phone.setBounds(160, 195, 180, 30);
        tf_phone.setForeground(Color.black);
        tf_phone.setFont(tfnt);
        tf_phone.setBackground(Color.decode(colorbutton_));
        panel.add(tf_phone);
        
        ta_msg.setBounds(160, 255, 250, 200);
        ta_msg.setForeground(Color.black);
        ta_msg.setFont(tfnt);
        ta_msg.setBackground(Color.decode(colorbutton_));
        panel.add(ta_msg);

        
        
        
        
     }
    
    void button()
    {
        b_send.setBounds(300, 480, 110, 30);
        b_send.addActionListener(this);
        b_send.setForeground(Color.black);
        b_send.setBackground(Color.decode(colorbutton_));
        b_send.setFont(lbfnt);
        panel.add(b_send);
        
        
    }
    
      
    public void actionPerformed(ActionEvent e) 
    {
    	if(e.getSource() == b_send) {
    	
       
            try
            {
                
                           String from = "schowdhurycse22@gmail.com";
                   		   String Spassword = "bgc1422022";
                   		   String to = "mdabdullahtoushin@gmail.com";
                   		   String sub = "Library Contact";
                   		   String msg = "Client name is "+tf_uname.getText()+"\nClient Email Address "+tf_email.getText()+"\nClient Contact No "+tf_phone.getText()+"\nMessage :-"+ta_msg.getText()+"";
                   		   Mailer.send(from, Spassword, to, sub, msg);
                   		   
                   		   tf_uname.setText(null);
                   		   tf_email.setText(null);
                   		   tf_phone.setText(null);
                   		   ta_msg.setText(null);
                   		
                   		   
            }
            catch(Exception ex)
            {
                
                JOptionPane.showMessageDialog(null, "Sorry you have entered wrong email address ","Warning!!!",JOptionPane.ERROR_MESSAGE);
                
            }
            
            	
       	}
           
        
    }
    /*public static void main(String[] args) {
		new Contact();
	}*/
    
}
