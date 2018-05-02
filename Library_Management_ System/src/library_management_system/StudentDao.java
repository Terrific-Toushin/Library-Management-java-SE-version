

package library_management_system;


import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDao {
public static int save(String st_id,String name,String roll,String batch,String department,String year,int contact,String issue_card,File img, FileInputStream fis)
{
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into student(student_id,name,roll,batch,department,year,contact,issue_card,image) values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1,st_id);
                ps.setString(2,name);
		ps.setString(3,roll);
		ps.setString(4,batch);
                ps.setString(5,department);
                ps.setString(6,year);
		ps.setInt(7,contact);
                ps.setString(8,issue_card);
                ps.setBinaryStream(9, fis,(int)img.length());
		status=ps.executeUpdate();
		con.close();
	}
        catch(Exception e){System.out.println(e);}
	return status;
}
}