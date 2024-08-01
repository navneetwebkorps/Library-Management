package Aservlets;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Users.Ausers;
import Users.Book;
import ValidatorPkg.MailSend;
import dbConnection.DbConnector;

public class AdbMethods {
    public static boolean Alogin(String Mid,String pass)
    {
    	Connection con =DbConnector.getConnection();
    	String sql="select * from admin where AmemberId=?;";
    
    	try {
    		PreparedStatement ps=con.prepareStatement(sql);
    		 ps.setString(1, Mid);
			ResultSet rs =ps.executeQuery();
			System.out.println(rs.next());
			
				System.out.println(rs.getString("AmemberId")+rs.getString("pass"));
			if(rs.getString("AmemberId").equals(Mid) && rs.getString("pass").equals(pass) )
			{
				return true;
				
			}
			
		} catch (SQLException e) {
			MyLog.MyLogger.logError("error in Alogin " +e);
		}
    	return false;
    	
    }
			
	
			public static boolean Ainsert(Ausers obj)
			{
			Connection con=	DbConnector.getConnection();

				String sql="insert into Admin values (?,?,?,?,?)";
				try {
				PreparedStatement ps=con.prepareStatement(sql);
			    ps.setString(1, obj.getAmemberId());
				ps.setString(2, obj.getName());
				ps.setString(3, obj.getLibrary());
				ps.setString(4, obj.getMail());
				ps.setString(5, obj.getPass());

			boolean ans=	ps.execute();
			if(ans)
			{
				MyLog.MyLogger.logError("Successfully admin reisterd");
			}
				}
				catch (SQLException e)
				{
					MyLog.MyLogger.logError("error in"+e);
				}

				return false;

			}
			public static List<String> getAmemberId()
				{
					Connection con=	DbConnector.getConnection();
					List<String> mId=new ArrayList<>();
						try {
						String sql="Select AmemberId from Admin";
						PreparedStatement ps=con.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();

						while(rs.next())
						{
							String id=rs.getString("AmemberId");
							mId.add(id);
							//con.close();
							System.out.println("connection close");
						}}
						catch(SQLException e)
						{
							MyLog.MyLogger.logError(""+e);
						}
						return mId;



			}

			public  String AmemberId()

			{
				  Random random = new Random();
			      int rNum = 100000 + random.nextInt(900000);
			String Aid="A"+Integer.toString(rNum);
			      List<String> l=AdbMethods.getAmemberId();
			      if(l.contains(rNum))
			      {
			    	  AmemberId();
			      }
			      System.out.println("member id"+rNum);
				
				return Aid;
			}
                        
                        
                        
}
