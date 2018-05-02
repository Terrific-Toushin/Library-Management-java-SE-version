

package library_management_system;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Retrive_password extends JFrame implements ActionListener
{
    String colorpanel_ = "#90A4AE";
    String colorTField_ = "#ECEFF1";
    String colorbutton_ = "#CFD8DC";
    
    
    JLabel l_uname = new JLabel("Username ");
    JTextField tf_uname = new JTextField(15);
    
    JLabel l_email = new JLabel("Email ");
    JTextField tf_email = new JTextField(15);
    
    //JLabel  l_new_password = new JLabel("New password :");
    //JPasswordField tf_new_password = new JPasswordField(15);
    
    //JLabel  l_confirm_newpass = new JLabel("Confirm password :");
    //JPasswordField tf_confirm_newpass = new JPasswordField(15);
    
    JButton b_back = new JButton("Back");
    JButton b_save = new JButton("Get password");
    
    JPanel panel = new JPanel();
    JButton btn = new JButton();
    JTextField fld = new JTextField();
    
    
    Font lfnt = new Font("Times New Roman", Font.PLAIN, 17);
    Font tfnt = new Font("Times New Roman", Font.PLAIN, 15);
    Connection con=null;
    Statement st = null;
    ResultSet rs=null;

    Retrive_password() 
    {
        super("Retrive password");
        panel.setLayout(null);
        add(panel);
        panel.setBackground(Color.decode(colorpanel_));
        setSize(420, 380);
        setVisible(true);
        setLocation(400, 100);
        setResizable(false);
        label_and_tex();
        button();

    }
    void label_and_tex()
    {
        l_uname.setBounds(50, 40,200,60);
        l_uname.setFont(lfnt);
        l_uname.setForeground(Color.black);
        panel.add(l_uname);
        
        l_email.setBounds(80, 110, 200, 80);
        l_email.setFont(lfnt);
        l_email.setForeground(Color.black);
        panel.add(l_email);
        

        
        /*l_confirm_newpass.setBounds(80, 200, 200, 80);
        l_confirm_newpass.setFont(lfnt);
        l_confirm_newpass.setForeground(Color.black);
        panel.add(l_confirm_newpass);*/

        tf_uname.setBounds(130, 55, 200, 35);
        tf_uname.setForeground(Color.black);
        tf_uname.setFont(tfnt);
        tf_uname.setBackground(Color.decode(colorbutton_));
        tf_uname.setUI(new HintTextFieldUI("  username", true));
        panel.add(tf_uname);
        
        tf_email.setBounds(130, 135, 200, 35);
        tf_email.setForeground(Color.black);
        tf_email.setFont(tfnt);
        tf_email.setBackground(Color.decode(colorbutton_));
        tf_email.setUI(new HintTextFieldUI("  email@example.com", true));
        panel.add(tf_email);
         

        
       /* tf_confirm_newpass.setBounds(240, 225, 140, 35);
        tf_confirm_newpass.setForeground(Color.black);
        tf_confirm_newpass.setFont(tfnt);
        tf_confirm_newpass.setBackground(Color.decode(colorbutton_));
        panel.add(tf_confirm_newpass);*/
        
        
        
     }
    
    void button()
    {
        b_save.setBounds(60, 230, 140, 30);
        b_save.addActionListener(this);
        b_save.setForeground(Color.black);
        b_save.setBackground(Color.decode(colorbutton_));
        panel.add(b_save);
        
        b_back.setBounds(230, 230, 110, 30);
        b_back.addActionListener(this);
        b_back.setForeground(Color.black);
        b_back.setBackground(Color.decode(colorbutton_));
        panel.add(b_back);
    }
    
      
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b_save)
        {
            
            boolean c=false;
            if(tf_uname.getText().equals("")||tf_email.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null, "Please enter correct information");
               
           }
           
           else
           {
            try
            {
                Connection con=DB.getConnection();
                String query="select * from registration where username='"+tf_uname.getText()+"'"
                               + "&& email='"+tf_email.getText()+"'";
                st=con.createStatement();
                rs=st.executeQuery(query);
                rs.next();
                String username=rs.getString("username");
                String email = rs.getString("email");
                String password=rs.getString("password");
                //Statement st = con.createStatement();                
                
                       if(tf_uname.getText().equals(username)&&tf_email.getText().equals(email))
                       {
                           c=true;
                           String from = "schowdhurycse22@gmail.com";
                   		   String Spassword = "bgc1422022";
                   		   String to = email;
                   		   String sub = "Library management admin password";
                   		   String msg = "Your password is ("+password+"). Please change password after login";
                   		Mailer.send(from, Spassword, to, sub, msg);
                           //new Main_Menu();
                                           
                          //dispose();
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null, "Sorry you have entered wrong name or email","Warning!!!",JOptionPane.ERROR_MESSAGE);
                       }
                
                
             
               //JOptionPane.showMessageDialog(null,"Update Successfully");
               tf_uname.setText("");
               tf_email.setText(""); 
               //tf_confirm_newpass.setText("");
            }
            catch(Exception ex)
            {
                
                JOptionPane.showMessageDialog(null, "Sorry you have entered wrong name or email ","Warning!!!",JOptionPane.ERROR_MESSAGE);
                
            }
           }
            //new Login();
            //dispose();
        
        }
        if(e.getSource()==b_back)
        {
            new Login();
            dispose();
        
        }
    }
    /*public static void main(String[] args) {
		new Retrive_password();
	}*/
    
}
