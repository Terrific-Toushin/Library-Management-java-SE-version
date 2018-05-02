
package library_management_system;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class Delete_MemberDao {

    public static int delete(String name, String position) 
    {
        int status = 0;
        try 
        {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from registration where name=? and email =?");
            ps.setString(1, name);
            ps.setString(2, position);
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
