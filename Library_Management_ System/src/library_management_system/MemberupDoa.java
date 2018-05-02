package library_management_system;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberupDoa {
	public static int update(String name, String email, String password, File img, FileInputStream fis) 
    {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("update registration set(username,password,image) values(?,?,?) where email=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setBinaryStream(3, fis,(int)img.length());
            ps.setString(4, email);
            status = ps.executeUpdate();
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return status;
    }

}
