import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ticket {
	String dbUrl="jdbc:mysql://localhost:3306/lottery";
    String dbUname="root";
    String dbPassword="";
    String dbDriver="com.mysql.cj.jdbc.Driver";
	String won,name;
	String w="true";
	ticket(String name,String won){
		this.name=name;
		this.won=won;
	}
	void store() {
		Connection con = null;
   		try {
   			if(won.equals(w)) {
   				won="win";
   			}
   			else {
   				won="lost";
   			}
			Class.forName(dbDriver);  //class not found exception
			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
			String sql = "insert into ticket (name,status)"
					+ "values('"+name+"','"+won+"')";
			Statement s = con.createStatement();
			s.execute(sql);
		   	con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}   	 
	}
}
