import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class Book {
	Connection connection;
	Statement stmt;
	
		Book(){
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "admin");
			stmt = connection.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
		public String[] getHid() {
			int i=0;
			String Hid[] = new String[8];
			try {
				Class.forName("org.postgresql.Driver");
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "admin");
				stmt = connection.createStatement();
				ResultSet r = stmt.executeQuery("select Houseboat_id from Houseboat;") ;
				while(r.next()) {
					String id = r.getString(1);
					Hid[i] = id;
					i++;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}
			return Hid;
		}
		public void insert_rents(String H_id, String C_id, String Date, String duration,String people) {
			try {
				Class.forName("org.postgresql.Driver");
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "admin");
				stmt = connection.createStatement();
				String sql = "insert into book(houseboat_id,customer_id,Orderdate,duration,people)"
						+" values ( '"+H_id+"' , '"+C_id+"' , '"+Date+"' , '"+duration+"', '"+people+"');"; 
				stmt.executeUpdate(sql);
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}
		}
		public boolean search(String H_id,String date) {
			try {
				Class.forName("org.postgresql.Driver");
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "admin");
				stmt = connection.createStatement();
				String sql = "select Orderdate from book where houseboat_id = '"+ H_id + "';";
				ResultSet r = stmt.executeQuery(sql);
				r.next();
				while(r.next()) {
					String DATE = r.getString(1);
					if(DATE.equals(date)) {
						return true;
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}
			return false;
		}
		/*public boolean capacity(String s1,String sdate) {
			String HID = s1;
			try {
				Class.forName("org.postgresql.Driver");
				/*Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "admin");
				PreparedStatement stmt=connection.prepareStatement("select Orderdate from book where houseboat_id=? and customer_id=? ");
				stmt.setString(1, HID);
				stmt.setString(2, custid);
				ResultSet r = stmt.executeQuery();
				r.next();
				Date date = r.getDate(1);
				
				SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");  
				Date k = formatter.parse(sdate);
				PreparedStatement stmt1 = connection.prepareStatement("select sum(people) from book where houseboat_id=? and Orderdate=? ");
				stmt1.setString(1, HID);
				stmt1.setDate(2,k);
				ResultSet r1 = stmt1.executeQuery();
				r1.next();
				int cap = r1.getInt(1);
				
				
				PreparedStatement stmt2 = connection.prepareStatement("select boat_capacity from Houseboat where houseboat_id=? ");
				stmt2.setString(1, HID);
				ResultSet r2 = stmt2.executeQuery();
				r2.next();
				int bcap = r2.getInt(1);
				
				if(cap > bcap ) {
					return true;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}
			return false;
		}*/
		
	}
