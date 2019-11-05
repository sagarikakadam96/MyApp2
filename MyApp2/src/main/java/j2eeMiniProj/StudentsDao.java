package j2eeMiniProj;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsDao {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sava2","sava");
			System.out.println("hello");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	//REGISTER
	public static int register(Students s){
		int status=0;
		try{
			Connection con=StudentsDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Students(rollno,fname,lname,course,result) values (?,?,?,?,?)");
			ps.setString(1,s.getRollno());
			ps.setString(2,s.getFname());
			ps.setString(3,s.getLname());
			ps.setString(4,s.getCourse());
			ps.setString(5,s.getResult());
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	//DISPLAY
	
	public static List<Students> display(){
		List<Students> list=new ArrayList<Students>();
		
		try{
			Connection con=StudentsDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Students");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Students s=new Students();
				s.setRollno(rs.getString(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				s.setCourse(rs.getString(4));
				s.setResult(rs.getString(5));
				list.add(s);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	
	//DELETE
	public static int delete(int rollno){
		int status=0;
		try{
			Connection con=StudentsDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from Students where eid=?");
			ps.setInt(1,rollno);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
}
