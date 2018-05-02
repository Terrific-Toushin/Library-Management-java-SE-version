package library_management_system;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class StudentDelDao {
	public static int delete(String st_id,String name,String roll){
		int status=0;
		try{
			Connection con=DB.getConnection();	        
	            String sql="delete from student where student_id=? and name=? and roll=?";
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1,st_id);
	            pst.setString(2,name);
	            pst.setString(3,roll);
	            pst.execute();
	            
		}
	        catch(Exception e){
	            JOptionPane.showMessageDialog(null,e.toString());
	        }
		System.out.println(status);
		return status;
	}
}
