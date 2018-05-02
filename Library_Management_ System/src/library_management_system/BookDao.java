
package library_management_system;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDao 
{
public static int save(int b_id,String book_name,String author,String publisher,int quantity)
{
	int status=0;
	try
        {
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into library_books(book_id,book_name,author,publisher,quantity) values(?,?,?,?,?)");
		ps.setInt(1,b_id);
		ps.setString(2,book_name);
		ps.setString(3,author);
		ps.setString(4,publisher);
		ps.setInt(5,quantity);
		status=ps.executeUpdate();
		con.close();
	}
        catch(Exception e)
        {
            System.out.println(e);
        }
	return status;
}
public static int delete(int b_id,String book_name)
{
	int status=0;
	try
        {
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from library_books where book_id=? and book_name =?");
		ps.setInt(1,b_id);
		ps.setString(2,book_name);
		status=ps.executeUpdate();
		con.close();
	}
        catch(Exception e)
        {
            System.out.println(e);
        }
	return status;
}
public static int update(int b_id,String book_name,String author,String publisher,int quantity)
{
	int status=0;
	try
        {
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("update library_books set book_name = ?, author = ?,publisher = ?,quantity = ? where book_id = ?");
		ps.setString(1,book_name);
		ps.setString(2,author);
		ps.setString(3,publisher);
		ps.setInt(4,quantity);
		ps.setInt(5,b_id);
		status=ps.executeUpdate();
		con.close();
	}
        catch(Exception e)
        {
            System.out.println(e);
        }
	return status;
}
}
