

package library_management_system;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;


public class Student_info extends JFrame implements ActionListener 
{
    String colorpanel_ = "#90A4AE";
    String color_up_button_ = "#B0BEC5";
    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();
    
    JLabel l_student_id = new JLabel("Student Id ");
    JTextField tf_student_id = new JTextField(15);
    
    JLabel l_image = new JLabel();
    JButton b_image = new JButton("Browse");
    
    JLabel l_name = new JLabel("Name ");
    JTextField tf_name = new JTextField(15);
    
    JLabel l_roll= new JLabel("Roll ");
    JTextField tf_roll = new JTextField(15);
    
    JLabel l_batch = new JLabel("Batch ");
    JTextField tf_batch = new JTextField(15);
    
    JLabel l_department = new JLabel("Department   ");
    String dep[] = {"","CSE", "Pharmacy", "LLB", "BBA", "ENGLISH"};
    JComboBox tf_department = new JComboBox(dep);
    JComboBox tf_jdepartment = new JComboBox();
    
    JLabel l_year = new JLabel("Year ");
    JTextField tf_year = new JTextField(15);
    
    JLabel l_contact = new JLabel("Contact ");
    JTextField tf_contact = new JTextField(15);
    
    JLabel l_issue_card = new JLabel("Issue Card ");
    JTextField tf_issue_card = new JTextField(15);
    
    JTextField tf_search = new JTextField(15);
    
    JButton b_view_lc_user = new JButton("View library card user");

    JButton sb = new JButton("Save", new ImageIcon("image/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("image/Regis.png"));
    JButton up = new JButton("Update");
    JButton del = new JButton("Delete", new ImageIcon("image/delete.png"));
    JButton b_search = new JButton("Search");

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 14);
    ImageIcon ic = new ImageIcon();
    String path = "";
    File img=null;
    FileInputStream fis = null;
    Connection con=null;
    Statement st = null;
    ResultSet rs=null;
    PreparedStatement ps = null;
        Vector data = new Vector();
        JPanel panel_search = new JPanel();
        JTable table;

    Student_info() {

        super("Student Information");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
        add(panel);
        setSize(550, 665);
        setVisible(true);
        setLocation(480, 40);
        Add_Component_E();

    }

    void Add_Component_E() 
    {

        l_student_id.setBounds(50, 35,200,60);
        l_student_id.setFont(font);
        l_student_id.setForeground(Color.BLACK);
        tf_student_id.setBounds(130, 50, 150, 35);
        tf_student_id.setFont(font);
        panel.add(l_student_id);
        panel.add(tf_student_id);
        
        l_image.setBounds(330, 55,180,200);
        l_image.setFont(font);
        l_image.setForeground(Color.BLACK);
        l_image.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 102), null, null));
        b_image.setBounds(370,270,100,30);
        b_image.setForeground(Color.BLACK);
        b_image.addActionListener(this);
        panel.add(l_image);
        panel.add(b_image);
        
        l_name.setBounds(80, 85, 200, 80);
        l_name.setFont(font);
        l_name.setForeground(Color.BLACK);
        tf_name.setBounds(130, 110, 150, 35);
        tf_name.setFont(font);
        panel.add(l_name);
        panel.add(tf_name);
        
        l_roll.setBounds(88, 170, 130, 40);
        l_roll.setFont(font);
        l_roll.setForeground(Color.BLACK);
        tf_roll.setBounds(130, 175, 150, 35);
        tf_roll.setFont(font);
        panel.add(l_roll);
        panel.add(tf_roll);
        
        l_batch.setBounds(80, 235,130,40);
        l_batch.setFont(font);
        l_batch.setForeground(Color.BLACK);
        tf_batch.setBounds(130, 240, 150, 35);
        tf_batch.setFont(font);
        panel.add(l_batch);
        panel.add(tf_batch);
        
        l_year.setBounds(84, 300,200,60);
        l_year.setFont(font);
        l_year.setForeground(Color.BLACK);
        tf_year.setBounds(130, 310, 150, 35);
        tf_year.setFont(font);
        panel.add(l_year);
        panel.add(tf_year);
        
        l_department.setBounds(43, 360,200,60);
        l_department.setFont(font);
        l_department.setForeground(Color.BLACK);
        tf_department.setBounds(130, 375, 150, 35);
        tf_department.setFont(font);
        tf_jdepartment.setBounds(130, 375, 150, 35);
        tf_jdepartment.setFont(font);
        panel.add(l_department);
        panel.add(tf_department);
        panel.add(tf_jdepartment);
        tf_jdepartment.show(false);
        
        l_contact.setBounds(68, 425,200,60);
        l_contact.setFont(font);
        l_contact.setForeground(Color.BLACK);
        tf_contact.setBounds(130, 440, 150, 35);
        tf_contact.setFont(font);
        panel.add(l_contact);
        panel.add(tf_contact);
        
        
        l_issue_card.setBounds(50, 490,200,60);
        l_issue_card.setFont(font);
        l_issue_card.setForeground(Color.BLACK);
        tf_issue_card.setBounds(130, 505, 150, 35);
        tf_issue_card.setFont(font);
        panel.add(l_issue_card);
        panel.add(tf_issue_card);
        
        
        tf_search.setBounds(282, 1, 150, 34);
        tf_search.setUI(new HintTextFieldUI("  Studen ID", true));
        tf_search.setFont(font);
        panel.add(tf_search);
        
        
        tf_student_id.setBackground(Color.decode(colorbutton_));
        tf_name.setBackground(Color.decode(colorbutton_));
        tf_roll.setBackground(Color.decode(colorbutton_));
        tf_batch.setBackground(Color.decode(colorbutton_));
        tf_department.setBackground(Color.decode(colorbutton_));
        tf_year.setBackground(Color.decode(colorbutton_));
        tf_contact.setBackground(Color.decode(colorbutton_));
        tf_issue_card.setBackground(Color.decode(colorbutton_));
        
        tf_search.setBackground(Color.decode(colorbutton_));
        
        b_view_lc_user.setBounds(1, 1, 170, 35);
        b_view_lc_user.setForeground(Color.BLACK);
        b_view_lc_user.addActionListener(this);
        //b_view_library_member.setToolTipText("View library member");
        //sb.setMnemonic(KeyEvent.VK_S);
        panel.add(b_view_lc_user);
        
        sb.setBounds(95, 565,100,30);
        sb.setForeground(Color.BLACK);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        sb.setForeground(Color.BLACK);
        panel.add(sb);
        
        up.setBounds(90, 565,105,30);
        up.setForeground(Color.BLACK);
        up.addActionListener(this);
        up.setToolTipText("Update");
        up.setMnemonic(KeyEvent.VK_U);
        up.setForeground(Color.BLACK);
        panel.add(up);
        up.show(false);
        

        bb.setBounds(220, 565,100,30);
        bb.setForeground(Color.BLACK);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        bb.setForeground(Color.BLACK);
        panel.add(bb);
        
        del.setBounds(345, 565,100,30);
        del.setForeground(Color.BLACK);
        del.setToolTipText("Delete");
        del.setMnemonic(KeyEvent.VK_D);
        del.addActionListener(this);
        del.setForeground(Color.BLACK);
        panel.add(del);
        del.show(false);
        
        b_search.setBounds(433, 1, 100, 35);
        b_search.setForeground(Color.BLACK);
        b_search.addActionListener(this);
        panel.add(b_search);
        
        b_view_lc_user.setBackground(Color.decode(color_up_button_));
        
        sb.setBackground(Color.decode(colorbutton_));
        bb.setBackground(Color.decode(colorbutton_));
        b_search.setBackground(Color.decode(color_up_button_));

    }

    /*public static void main(String args[]) {
    
    Student_info ob = new Student_info();
    }*/

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

            try {

                String student_id = tf_student_id.getText();
                
                String name = tf_name.getText();
                
                String roll = tf_roll.getText();
                
                String batch = tf_batch.getText();
                
                String department = tf_department.getSelectedItem().toString();
                
                String year = tf_year.getText();
                
                String c_id = tf_contact.getText().toString();
                int contact = Integer.parseInt(c_id);
                
                String issue_card = tf_issue_card.getText();
                
                img = new File(path);
                
                fis = new FileInputStream(img);
                
                int i = StudentDao.save(student_id,name, roll, batch, department,year,contact,issue_card,img,fis);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } 
                else 
                {
                    System.out.println(einfo.toString());
                }
                tf_student_id.setText(null);
                tf_name.setText(null);
                tf_roll.setText(null);
                tf_batch.setText(null);
                tf_department.setSelectedItem(null);
                tf_year.setText(null);
                tf_contact.setText(null);
                tf_issue_card.setText(null);
                l_image.setIcon(null);
                

            } 
            catch (Exception ee) 
            {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }
        if(einfo.getSource()== b_view_lc_user)
        {
            new view_student_info();
            dispose();
        }
        if(einfo.getSource()== bb)
        {
            //new Main_Menu();
            dispose();
        }
        if(einfo.getSource()==b_search)
        {
           try
           {
        	   FileOutputStream fos = null;
              // String book_name=tf_search.getText();
               Connection con=DB.getConnection();
               ps=con.prepareStatement("select * from student where student_id='"+tf_search.getText()+"'");
               
               rs = ps.executeQuery();
               //String book_name=rs.getString("book_name");
               while(rs.next()){
                   tf_student_id.setText(rs.getString("student_id"));
                   tf_name.setText(rs.getString("name"));
                   tf_roll.setText(rs.getString("roll"));
                   tf_batch.setText(rs.getString("batch"));
                   tf_jdepartment.addItem(rs.getString("department"));
                   tf_jdepartment.addItem("LLB");
                   tf_jdepartment.addItem("Eng");
                   tf_jdepartment.addItem("BBA");
                   tf_jdepartment.addItem("Pharmacy");
                   tf_jdepartment.addItem("CSE");
                   tf_department.show(false);
                   tf_jdepartment.show(true);
                   tf_year.setText(rs.getString("year"));
                   tf_contact.setText(rs.getString("contact"));
                   tf_issue_card.setText(rs.getString("issue_card"));
                   sb.show(false);
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
        if (einfo.getSource() == up) {

            try {

                String student_id = tf_student_id.getText();
                
                String name = tf_name.getText();
                
                String roll = tf_roll.getText();
                
                String batch = tf_batch.getText();
                
                String department = tf_jdepartment.getSelectedItem().toString();
                
                String year = tf_year.getText();
                
                String c_id = tf_contact.getText().toString();
                int contact = Integer.parseInt(c_id);
                
                String issue_card = tf_issue_card.getText();
                
                img = new File(path);
                
                fis = new FileInputStream(img);
                
                int i = StudentUpDao.update(student_id,name, roll, batch, department,year,contact,issue_card,img,fis);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully updated!!!");
                } 
                else 
                {
                    System.out.println(einfo.toString());
                }
                tf_student_id.setText(null);
                tf_name.setText(null);
                tf_roll.setText(null);
                tf_batch.setText(null);
                tf_department.setSelectedItem(null);
                tf_year.setText(null);
                tf_contact.setText(null);
                tf_issue_card.setText(null);
                l_image.setIcon(null);
                

            } 
            catch (Exception eeu) 
            {

                 System.out.println(eeu.toString());
                //JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }
        if (einfo.getSource() == del) {

            try {

                String student_id = tf_student_id.getText();
                
                String name = tf_name.getText();
                
                String roll = tf_roll.getText();
                
                
                
                int i = StudentDelDao.delete(student_id,name, roll);
                if (i >= 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully Deleted!!!");
                } 
                else 
                {
                    System.out.println(einfo.toString());
                }
                tf_student_id.setText(null);
                tf_name.setText(null);
                tf_roll.setText(null);
                tf_batch.setText(null);
                tf_department.setSelectedItem(null);
                tf_year.setText(null);
                tf_contact.setText(null);
                tf_issue_card.setText(null);
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
