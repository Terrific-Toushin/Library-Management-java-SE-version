package library_management_system;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Team extends JFrame{
	String colorpanel_ = "#90A4AE";
    String color_up_button_ = "#B0BEC5";
    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();
    JLabel l_image1 = new JLabel();
    JLabel l_image2 = new JLabel();
    JLabel l_image3 = new JLabel();
    Team(){
    	super("Team member");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
        add(panel);
        setSize(550, 665);
        setVisible(true);
        setLocation(480, 40);
        Add_Component_E();
    }
    void Add_Component_E() {
    	
    	l_image1.setBounds(10, 55,180,200);
        l_image1.setForeground(Color.BLACK);
        l_image1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 102), null, null));
        panel.add(l_image1);
        
        l_image2.setBounds(10, 60,180,200);
        l_image2.setForeground(Color.BLACK);
        l_image2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 102), null, null));
        panel.add(l_image2);
        
        l_image3.setBounds(10, 120,180,200);
        l_image3.setForeground(Color.BLACK);
        l_image3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 102), null, null));
        panel.add(l_image3);
        
    }

	/*public static void main(String[] args) {
		new Team();
		// TODO Auto-generated method stub

	}*/

}
