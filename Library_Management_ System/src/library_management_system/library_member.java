

package library_management_system;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;


public class library_member extends JFrame implements ActionListener 
{
    String colorpanel_ = "#90A4AE";
    String color_up_button_ = "#B0BEC5";
    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();
    JLabel l_name = new JLabel("Name  : ");
    JTextField tf_name = new JTextField(15);

    JLabel l_email = new JLabel("Email :  ");
    JTextField tf_email = new JTextField(15);

    JLabel l_password = new JLabel("Password :  ");
    JPasswordField tf_password = new JPasswordField(15);

    JLabel l_confirm_pass = new JLabel("Confirm Password :");
    JPasswordField tf_confirm_pass = new JPasswordField(15);
    
    JButton b_view_library_member = new JButton("View Library Member");
    JButton del = new JButton("Delete");

    JButton sb = new JButton("Save", new ImageIcon("image/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("image/Regis.png"));
    JLabel l_image = new JLabel();
    JButton b_image = new JButton("Browse");
    JButton up = new JButton("Update");
    JButton b_search = new JButton("Search");
    JTextField tf_search = new JTextField(15);
    
    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 14);
    Font lfnt = new Font("SERIF", Font.BOLD | Font.PLAIN, 40);
    ImageIcon ic = new ImageIcon();
    String path = "";
    File img=null;
    FileInputStream fis = null;
    Connection con=null;
    Statement st = null;
    ResultSet rs=null;
    PreparedStatement ps = null;

    library_member() {

        super("Library Member");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
        add(panel);
        setSize(550, 500);
        setVisible(true);
        setLocation(480, 70);
        Add_Component_E();

    }

    void Add_Component_E() {
    	
    	tf_search.setBounds(282, 1, 150, 34);
        tf_search.setUI(new HintTextFieldUI("  email", true));
        tf_search.setFont(font);
        panel.add(tf_search);
        
        b_search.setBounds(433, 1, 100, 35);
        b_search.setForeground(Color.BLACK);
        b_search.addActionListener(this);
        panel.add(b_search);

        l_name.setBounds(80, 70, 130, 40);
        tf_name.setBounds(130, 70, 150, 40);
        //l_name.setFont(lfnt);
        panel.add(l_name);
        panel.add(tf_name);

        l_email.setBounds(80, 150, 130, 40);
        tf_email.setBounds(130, 150, 150, 40);
       // l_email.setFont(lfnt);
        panel.add(l_email);
        panel.add(tf_email);

        l_password.setBounds(55, 230, 130, 40);
        tf_password.setBounds(130, 230, 150, 40);
        //l_password.setFont(lfnt);
        panel.add(l_password);
        panel.add(tf_password);

        l_confirm_pass.setBounds(10, 310, 130, 40);
        tf_confirm_pass.setBounds(130, 310, 150, 40);
       // l_confirm_pass.setFont(lfnt);
        panel.add(l_confirm_pass);
        panel.add(tf_confirm_pass);
        
        tf_name.setBackground(Color.decode(colorbutton_));
        tf_email.setBackground(Color.decode(colorbutton_));
        tf_password.setBackground(Color.decode(colorbutton_));
        tf_confirm_pass.setBackground(Color.decode(colorbutton_));
        
        b_view_library_member.setBounds(1, 1, 170, 35);
        b_view_library_member.setForeground(Color.BLACK);
        b_view_library_member.addActionListener(this);
        //b_view_library_member.setToolTipText("View library member");
        //sb.setMnemonic(KeyEvent.VK_S);
        panel.add(b_view_library_member);
        
        up.setBounds(90, 395,105,30);
        up.setForeground(Color.BLACK);
        up.addActionListener(this);
        up.setToolTipText("Update");
        up.setMnemonic(KeyEvent.VK_U);
        up.setForeground(Color.BLACK);
        panel.add(up);
        up.show(false);
        
        del.setBounds(345, 395,100,35);
        del.setForeground(Color.BLACK);
        del.setToolTipText("Delete");
        del.setMnemonic(KeyEvent.VK_D);
        del.addActionListener(this);
        del.setForeground(Color.BLACK);
        panel.add(del);
        del.show(false);

        sb.setBounds(100, 395, 140, 35);
        sb.setForeground(Color.BLACK);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        panel.add(sb);

        bb.setBounds(290, 395, 140, 35);
        bb.setForeground(Color.BLACK);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);
        
        b_view_library_member.setBackground(Color.decode(color_up_button_));
        del.setBackground(Color.decode(colorbutton_));
        sb.setBackground(Color.decode(colorbutton_));
        bb.setBackground(Color.decode(colorbutton_));
        
        l_image.setBounds(330, 55,180,200);
        l_image.setFont(font);
        l_image.setForeground(Color.BLACK);
        l_image.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 102), null, null));
        b_image.setBounds(370,270,100,30);
        b_image.setForeground(Color.BLACK);
        b_image.addActionListener(this);
        panel.add(l_image);
        panel.add(b_image);

    }

    public static void main(String args[]) {
    
    library_member ob = new library_member();
    }
    public void actionPerformed(ActionEvent einfo) {
    	if(einfo.getSource() == b_image) {
    		//path = "";
    		FileDialog fd = new FileDialog(this);
    		fd.show();
    		path = fd.getDirectory()+fd.getFile();
    		ImageIcon Myimage = new ImageIcon(path);
    		Image img1 = Myimage.getImage();
    		Image newimg2 = img1.getScaledInstance(l_image.getWidth(),l_image.getHeight(), Image.SCALE_SMOOTH);
    		ImageIcon newsc = new ImageIcon(newimg2);
    		l_image.setIcon(newsc);
    	}
        if (einfo.getSource() == sb) {
        	if(tf_password.getText().equals(tf_confirm_pass.getText()))
        	{
            try {

                String name = tf_name.getText();
                
                String email = tf_email.getText();
                
                String password = tf_password.getText();
                
                String confirm_pass = tf_confirm_pass.getText();
                
                img = new File(path);
                
                fis = new FileInputStream(img);
                
                int i = library_memberDao.save(name, email, password, img,fis);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } 
                else 
                {
                    System.out.println(einfo.toString());
                }
                tf_name.setText(null);
                tf_email.setText(null);
                tf_password.setText(null);
                tf_confirm_pass.setText(null);
                l_image.setIcon(null);

            } 
            catch (Exception ee) 
            {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "Please!!! Enter password correctly.");
        	}
        }
        if(einfo.getSource()== bb)
        {
            //new Main_Menu();
            dispose();
        }
        if(einfo.getSource()==b_view_library_member)
        {
            new view_library_member();
            dispose();
        
        }
        if(einfo.getSource()==del)
        {
        	String name = tf_name.getText();
            
            String email = tf_email.getText();
        	try 
            {
                Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement("delete from registration where name=? and email =?");
                ps.setString(1, name);
                ps.setString(2, email);
                ps.executeUpdate();
                con.close();
                JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully deleted!!!");
                
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
            dispose();
        
        }
        if(einfo.getSource()==b_search)
        {
        	try
            {
         	   FileOutputStream fos = null;
               // String book_name=tf_search.getText();
                Connection con=DB.getConnection();
                ps=con.prepareStatement("select * from registration where email='"+tf_search.getText()+"'");
                
                rs = ps.executeQuery();
                //String book_name=rs.getString("book_name");
                while(rs.next()){
                    
                    tf_name.setText(rs.getString("username"));
                    tf_email.setText(rs.getString("email"));
                    tf_password.setText(rs.getString("password"));
                    l_confirm_pass.show(false);
                    tf_confirm_pass.show(false);
                    sb.show(false);
                    bb.show(false);
                    up.show(true);
                    del.show(true);
                    Blob b = rs.getBlob("image");
                    String id = rs.getString("student_id");
                    
                    fos = new FileOutputStream("image/"+id+".jpg");
                    int len=(int) b.length();
                    byte[] buf=b.getBytes(1, len);
                    fos.write(buf, 0, len);
                    path = new String("image/"+id+".jpg");
            		   ImageIcon Myimage = new ImageIcon(path);
            		   Image img1 = Myimage.getImage();
            		   Image newimg2 = img1.getScaledInstance(l_image.getWidth(),l_image.getHeight(), Image.SCALE_SMOOTH);
            		   ImageIcon newsc = new ImageIcon(newimg2);
            		   l_image.setIcon(newsc);
                    fos.close();
                    //File f = new File("image/"+id+".jpg");
                    //f.delete();
                   
                 } 
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
        if(einfo.getSource() == up){
        	try {

                String name = tf_name.getText();
                
                String email = tf_email.getText();
                
                String password = tf_password.getText();
                
                img = new File(path);
                
                fis = new FileInputStream(img);
                
                int i = MemberupDoa.update(name, email, password, img,fis);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully updated!!!");
                } 
                else 
                {
                    System.out.println(einfo.toString());
                }
                tf_name.setText(null);
                tf_email.setText(null);
                tf_password.setText(null);
                tf_confirm_pass.setText(null);
                l_image.setIcon(null);

            } 
            catch (Exception ee) 
            {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }

    }

}
