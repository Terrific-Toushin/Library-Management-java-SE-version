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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;



public class Login extends JFrame implements ActionListener 
{
    String colorpanel_ = "#90A4AE";
    String colorTField_ = "#ECEFF1";
    String colorbutton_ = "#CFD8DC";
    
    
    JLabel l_uname = new JLabel("Username ");
    JTextField tf_u_name = new JTextField(30);
    
    JLabel l_password = new JLabel("Password              ");
    JPasswordField tf_password = new JPasswordField(30);
    
    
    JButton b_login = new JButton("   Login   ");
    JButton b_retrive_password = new JButton("Forgot password");
    
    JPanel panel = new JPanel();
    JButton btn = new JButton();
    
   // JTextField fld = new JTextField();
    Font lfnt = new Font("Times New Roman", Font.PLAIN, 17);
    Font tfnt = new Font("Times New Roman", Font.PLAIN, 15);
    
    Connection con=null;
    Statement st = null;
    ResultSet rs=null;

    Login() {
        super("Login");
        panel.setLayout(null);
        add(panel);
        panel.setBackground(Color.decode(colorpanel_));
        setSize(480, 400);
        setVisible(true);
        setLocation(800, 100);
        setResizable(false);
        label_and_tex();
        button();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

    }

   

    void label_and_tex() 
    {

        l_uname.setBounds(120, 55,200,60);
        l_uname.setFont(lfnt);
        l_uname.setForeground(Color.black);
        panel.add(l_uname);
        
        l_password.setBounds(120, 125, 200, 80);
        l_password.setFont(lfnt);
        l_password.setForeground(Color.black);
        panel.add(l_password);
        
        
        

        tf_u_name.setBounds(200, 70, 150, 33);
        tf_u_name.setForeground(Color.black);
        tf_u_name.setBackground(Color.decode(colorbutton_));
        tf_u_name.setFont(tfnt);
        panel.add(tf_u_name);
        
        tf_password.setBounds(200, 150, 150, 33);
        tf_password.setForeground(Color.black);
        tf_password.setBackground(Color.decode(colorbutton_));
        tf_password.setFont(tfnt);
        panel.add(tf_password);
    }
    void button() 
    {
        
        b_login.addActionListener(this);
        b_login.setBounds(90, 250, 110, 30);
        b_login.setForeground(Color.black);
        b_login.setBackground(Color.decode(colorbutton_));
        panel.add(b_login);
        
        
        b_retrive_password.addActionListener(this);
        b_retrive_password.setBounds(240, 250, 180, 30);
        b_retrive_password.setForeground(Color.black);
        b_retrive_password.setBackground(Color.decode(colorbutton_));
        panel.add(b_retrive_password);
        

    }


    public static void main(String[] args)  
    {
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception classNotFoundException) {
        } 
        new Login();
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==b_login)
        {
            boolean c=false;
            if(tf_u_name.getText().equals("")||tf_password.getText().equals(""))
               {
                   
                 JOptionPane.showMessageDialog(null,"Please enter correct username or password","Warning!!!",JOptionPane.ERROR_MESSAGE);
            
               }
             else
               {
                   
                   
                   try
                   {
                       Connection con=DB.getConnection();
                       String query="select * from registration where username='"+tf_u_name.getText()+"'"
                               + "&& password='"+tf_password.getText()+"'";
                       st=con.createStatement();
                       rs=st.executeQuery(query);
                       rs.next();
                       String username=rs.getString("username");
                       String password=rs.getString("password");
                       if(tf_u_name.getText().equals(username)&&tf_password.getText().equals(password))
                       {
                           c=true;
                           
                           new Main_Menu();
                             dispose();              
                          
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null, "Sorry you have entered wrong name or passord","Warning!!!",JOptionPane.ERROR_MESSAGE);
                       }
                               
                   }
                  catch(Exception e)
                  {
                       JOptionPane.showMessageDialog(null, "Sorry you have entered wrong name or id,try again!","Warning!!!",JOptionPane.WARNING_MESSAGE);
                     
                      // JOptionPane.showMessageDialog(null, ez.toString());
                  }
                  finally
                  {
                      
                       
                  }
            
               }
           // new Main_Menu();
           // dispose();
        
        }

        if(ae.getSource()==b_retrive_password)
        {
            new Retrive_password();
            dispose();
        
        }

        }
    }
