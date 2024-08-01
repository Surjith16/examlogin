package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.mysql.cj.protocol.Resultset;
import dto.User;

public class Dao {

	

	public Connection getconnection() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
		
	}

    public int saveUser(User user) throws ClassNotFoundException, SQLException
	{
		Connection conn = getconnection();
		
		PreparedStatement pst = conn.prepareStatement("insert into userlogin values(?,?,?,?,?)");
		
		pst.setInt(1, user.getUserid());
		
		pst.setString(2, user.getUsername());
		
		pst.setLong(3, user.getUsercontact());
		
		pst.setString(4, user.getUsermail());
		
		pst.setString(5, user.getUserpassword());
		
		
		
		return pst.executeUpdate();
		
		
	}
    
    public User findByEmailUser(String Email) throws ClassNotFoundException, SQLException
	{
		
		Connection conn = getconnection();
		
		PreparedStatement pst = conn.prepareStatement("select * from userlogin where usermail=?");
		
		pst.setString(1, Email);
		
		ResultSet rs = pst.executeQuery();
		
		User a = new User();
		
		if(rs.next())
		{
			a.setUsermail(rs.getString(4));
			a.setUserpassword(rs.getString(5));
			a.setUsername(rs.getString(2));
			
		}
		return a;
		
		
		}
	
}
