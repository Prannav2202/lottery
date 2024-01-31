import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Sign {
	String dbUrl="jdbc:mysql://localhost:3306/lottery";
    String dbUname="root";
    String dbPassword="";
    String dbDriver="com.mysql.cj.jdbc.Driver";
	String name,password;
	Sign(String name,String password){
		this.name=name;
		this.password=password;
	}
	void store() {
		Connection con = null;
   		try {
			Class.forName(dbDriver);  //class not found exception
			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
			String sql = "insert into signup (name,password)"
					+ "values('"+name+"','"+password+"')";
			Statement s = con.createStatement();
			s.execute(sql);
		   	con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}   	 
	}
}
