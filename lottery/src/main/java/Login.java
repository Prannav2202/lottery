import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Login {
	String dbUrl="jdbc:mysql://localhost:3306/lottery";
    String dbUname="root";
    String dbPassword="";
    String dbDriver="com.mysql.cj.jdbc.Driver";
	String name,password;
	int count=0;
	Login(String name,String password){
		this.name=name;
		this.password=password;
		}
	void check() {
		Connection con = null;
   		try {
			Class.forName(dbDriver);  //class not found exception
			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			String sql = "SELECT * FROM signup WHERE name = '" + name + "' AND password = '" + password + "'";
			Statement s = con.createStatement();
		   	ResultSet rs= s.executeQuery(sql);
//		   	System.out.println("SQL Query: " + sql);
		   	if(rs.next()) {
				count=1;
			}else {
				count=0;
			}
		   	con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}   	
	}
	public int getCount() {
        return count;
	}
}
