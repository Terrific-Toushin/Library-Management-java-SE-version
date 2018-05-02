

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


public class Add_book extends JFrame implements ActionListener 
{
    String colorpanel_ = "#90A4AE";
    String color_up_button_ = "#B0BEC5";
    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();
    //Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
    //JMenu menu= new JMenu("Books");
    //JMenuItem view_reserved_books=new JMenuItem("View reserved books");
    JLabel b_id = new JLabel("Book ID  : ");
    JTextField tf_b_id = new JTextField(15);

    JLabel b_name = new JLabel("Book Name :  ");
    JTextField tf_bname = new JTextField(15);

    JLabel author = new JLabel("Author :  ");

    JTextField tf_author = new JTextField(15);

    JLabel publisher = new JLabel("Publisher  :");;
    JTextField tf_publisher = new JTextField(15);

    JLabel quantity = new JLabel("Quantity  :");
    JTextField tf_quantity = new JTextField(15);
    JTextField tf_search = new JTextField(15);
    
    JButton b_view_reserve_book = new JButton("View Reserve Books");
    JButton b_search = new JButton("Search");

    JButton sb = new JButton("Save", new ImageIcon("images/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("images/Regis.png"));
    JButton up = new JButton("Update");
    JButton del = new JButton("Delete", new ImageIcon("image/delete.png"));

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 25);
    ImageIcon ic = new ImageIcon();
    JDesktopPane pane = new JDesktopPane();
    
    Connection con=null;
    Statement st = null;
    ResultSet rs=null;
    PreparedStatement ps = null;
        Vector data = new Vector();
        JPanel panel_search = new JPanel();
        JTable table;


    Add_book() {

        super("Save Books Information");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
        //menu();
        add(panel);
        setSize(550, 600);
        //setSize(dim);
        setVisible(true);
        setLocationRelativeTo(null);
        Add_Component_E();
       //menu();

    }

    void Add_Component_E() {

        b_id.setBounds(90, 70, 130, 40);
        tf_b_id.setBounds(210, 70, 150, 40);
        panel.add(b_id);
        panel.add(tf_b_id);

        b_name.setBounds(90, 160, 130, 40);
        tf_bname.setBounds(210, 160, 150, 40);
        panel.add(b_name);
        panel.add(tf_bname);

        author.setBounds(90, 240, 130, 40);
        tf_author.setBounds(210, 240, 150, 40);
        panel.add(author);
        panel.add(tf_author);

        publisher.setBounds(90, 320, 130, 40);
        tf_publisher.setBounds(210, 320, 150, 40);
        panel.add(publisher);
        panel.add(tf_publisher);

        quantity.setBounds(90, 400, 130, 40);
        tf_quantity.setBounds(210, 400, 150, 40);
        panel.add(quantity);
        panel.add(tf_quantity);
        
        tf_search.setBounds(283, 1, 150, 34);
        tf_search.setUI(new HintTextFieldUI("  Book name", true));
        panel.add(tf_search);
        
        b_view_reserve_book.setBounds(1, 1, 170, 35);
        b_view_reserve_book.setForeground(Color.BLACK);
        b_view_reserve_book.addActionListener(this);
        panel.add(b_view_reserve_book);
        
        
        b_search.setBounds(434, 1, 100, 35);
        b_search.setForeground(Color.BLACK);
        b_search.addActionListener(this);
        panel.add(b_search);

        sb.setBounds(80, 500, 120, 30);
        sb.setForeground(Color.BLACK);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        panel.add(sb);
        
        up.setBounds(80, 500,120,30);
        up.setForeground(Color.BLACK);
        up.addActionListener(this);
        up.setToolTipText("Update");
        up.setMnemonic(KeyEvent.VK_U);
        up.setForeground(Color.BLACK);
        panel.add(up);
        up.show(false);

        bb.setBounds(345, 500,120,30);
        bb.setForeground(Color.BLACK);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);
        
        del.setBounds(215, 500, 120, 30);
        del.setForeground(Color.BLACK);
        del.setToolTipText("Delete");
        del.setMnemonic(KeyEvent.VK_D);
        del.addActionListener(this);
        del.setForeground(Color.BLACK);
        panel.add(del);
        del.show(false);
        
        tf_b_id.setBackground(Color.decode(colorbutton_));
        tf_bname.setBackground(Color.decode(colorbutton_));
        tf_author.setBackground(Color.decode(colorbutton_));
        tf_publisher.setBackground(Color.decode(colorbutton_));
        tf_quantity.setBackground(Color.decode(colorbutton_));
        tf_search.setBackground(Color.decode(colorbutton_));
        
        b_view_reserve_book.setBackground(Color.decode(color_up_button_));
        b_search.setBackground(Color.decode(color_up_button_));

    }
    
   /* void menu()
    {
        JMenuBar mb= new JMenuBar();
        view_reserved_books.addActionListener(this);
        menu.add(view_reserved_books);
        mb.add(menu);
        setJMenuBar(mb);
        
        
    }*/

    /*public static void main(String args[]) {
    
    Add_book ob = new Add_book();
    }*/

    public void actionPerformed(ActionEvent einfo)
    {
        
        if (einfo.getSource() == sb) {

            try {

                String quant = tf_quantity.getText().toString();
                int quantity = Integer.parseInt(quant);

                String s_id = tf_b_id.getText().toString();
                int b_id = Integer.parseInt(s_id);

                String book_name = tf_bname.getText();
                String publisher = tf_publisher.getText();

                String author = tf_author.getText();

                int i = BookDao.save(b_id, book_name, author, publisher, quantity);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } 
                else 
                {
                    System.out.println(einfo.toString());
                }
                tf_b_id.setText(null);
                tf_bname.setText(null);
                tf_author.setText(null);
                tf_publisher.setText(null);
                tf_quantity.setText(null);

            } 
            catch (Exception ee) 
            {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
            
        }
        if(einfo.getSource()== b_view_reserve_book)
        {
            new View_Library_Books();
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
               String book_name=tf_search.getText();
               Connection con=DB.getConnection();
               ps=con.prepareStatement("select * from library_books where book_name='"+tf_search.getText()+"'");
               ps.execute();
               rs = ps.getResultSet();
               //String book_name=rs.getString("book_name");
               while(rs.next()){
                   tf_b_id.setText(rs.getString("book_id"));
                   tf_bname.setText(rs.getString("book_name"));
                   tf_author.setText(rs.getString("author"));
                   tf_publisher.setText(rs.getString("publisher"));
                   tf_quantity.setText(rs.getString("quantity"));
                   sb.show(false);
                   up.show(true);
                   del.show(true);
                  
                }           
           }
           catch(Exception e)
           {
               System.out.println(e.toString());
           }
            

        }
       if (einfo.getSource() == up) {

           try {

        	   String quant = tf_quantity.getText().toString();
               int quantity = Integer.parseInt(quant);

               String s_id = tf_b_id.getText().toString();
               int b_id = Integer.parseInt(s_id);

               String book_name = tf_bname.getText();
               String publisher = tf_publisher.getText();

               String author = tf_author.getText();

               int i = BookDao.update(b_id, book_name, author, publisher, quantity);
               if (i > 0) 
               {
                   JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully updated!!!");
               } 
               else 
               {
                   System.out.println(einfo.toString());
               }
               tf_b_id.setText(null);
               tf_bname.setText(null);
               tf_author.setText(null);
               tf_publisher.setText(null);
               tf_quantity.setText(null);
               sb.show(true);
               up.show(false);
               del.show(false);

           } 
           catch (Exception eeu) 
           {

                System.out.println(eeu.toString());
               //JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
           }
       }
       if (einfo.getSource() == del) {

           try {

        	   
               String s_id = tf_b_id.getText().toString();
               int b_id = Integer.parseInt(s_id);

               String book_name = tf_bname.getText();

               int i = BookDao.delete(b_id, book_name);
               if (i > 0) 
               {
                   JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully Deleted!!!");
               } 
               else 
               {
                   System.out.println(einfo.toString());
               }
               tf_b_id.setText(null);
               tf_bname.setText(null);
               tf_author.setText(null);
               tf_publisher.setText(null);
               tf_quantity.setText(null);
               sb.show(true);
               up.show(false);
               del.show(false);
               

           } 
           catch (Exception ee) 
           {

               // System.out.println(ee.toString());
               JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
           }
       }

}
}
