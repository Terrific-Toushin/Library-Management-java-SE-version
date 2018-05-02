package library_management_system;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
public class StudentUpDao {
	public static int update(String st_id,String name,String roll,String batch,String department,String year,int contact,String issue_card,File img, FileInputStream fis){
		int status=0;
		try{
			Connection con=DB.getConnection();
	        PreparedStatement ps=con.prepareStatement("update student set name= ?,roll= ?,batch= ?,department= ?,year= ?,contact= ?,issue_card= ?,image= ? where student_id=?");
			
	                ps.setString(1,name);
			ps.setString(2,roll);
			ps.setString(3,batch);
	                ps.setString(4,department);
	                ps.setString(5,year);
			ps.setInt(6,contact);
	                ps.setString(7,issue_card);
	                ps.setBinaryStream(8, fis,(int)img.length());
	                ps.setString(9,st_id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e.toString());}
		System.out.println(status);
		return status;
		
	}
}
