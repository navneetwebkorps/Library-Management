package Sservlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import Users.Susers;
import ValidatorPkg.MailSend;
import dbConnection.DbConnector;

public class SdbMethods {
	        public static boolean Slogin(String Mid,String pass)
	        {
	        	Connection con =DbConnector.getConnection();
	        String sql="select * from Student where SmemberId=?;";
    
    	try {
    		PreparedStatement ps=con.prepareStatement(sql);
    		 ps.setString(1, Mid);
			ResultSet rs =ps.executeQuery();
			System.out.println(rs.next());
			
				System.out.println(rs.getString("SmemberId")+rs.getString("pass"));
			if( rs.getString("pass").equals(pass) )
			{
				return true;
				
			}
				} catch (SQLException e) {
					MyLog.MyLogger.logError("error in Slogin " +e);
				}
	        	return false;
	        	
	        }
			public static boolean Sinsert(Susers obj)
			{
			Connection con=	DbConnector.getConnection();

				String sql="insert into Student values (?,?,?,?)";
				try {
				PreparedStatement ps=con.prepareStatement(sql);
			    ps.setString(1, obj.getSmemberId());
				ps.setString(2, obj.getSname());
				ps.setString(3, obj.getSmail());
				ps.setString(4, obj.getSpass());

			boolean ans=	ps.execute();
                        con.close();
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
			public static List<String> getSmemberId()
			{
				Connection con=	DbConnector.getConnection();
				List<String> mId=new ArrayList<>();
					try {
					String sql="Select SmemberId from Student";
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();

					while(rs.next())
					{
						String id=rs.getString("SmemberId");
						mId.add(id);
						
						System.out.println("connection close");
					}
                                        con.close();
                                        }
					catch(SQLException e)
					{
						MyLog.MyLogger.logError(""+e);
					}
					return mId;



		}

			public  String SmemberId()

			{
				  Random random = new Random();
			      int rNum = 100000 + random.nextInt(900000);
			String Aid="S"+Integer.toString(rNum);
			      List<String> l=SdbMethods.getSmemberId();
			      if(l.contains(rNum))
			      {
			    	  SmemberId();
			      }
			      System.out.println("member id"+rNum);
				
				return Aid;
			}

}
