import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class CreateNewCust implements ActionListener {
	
	String name = "\\b[A-Z][a-z]+([A-Z][a-z]*)*\\b";
	String laname = "\\b[A-Z][a-z]+";
	Connection c;
	ResultSet rs ;
	static JFrame frame;
	private JTextField LName;
	private JTextField FName;
	private JTextField City;
	private JTextField Age;
	private JTextField username;
	private JTextField confirmpass;
	private JTextField Phone;
	private JPasswordField password;
	
	String s1[] = { 
    		"Andaman and Nicobar Islands",
	    	"Andhra Pradesh",
	    	"Arunachal Pradesh",
	    	"Assam",
	    	"Bihar",
	    	"Chandigarh",
	    	"Chhattisgarh",
	    	"Dadra and Nagar Haveli",
	    	"Daman and Diu",
	    	"Delhi",
	    	"Goa",
	    	"Gujarat",
	    	"Haryana",
	    	"Himachal Pradesh",
	    	"Jammu and Kashmir",
	    	"Jharkhand",
	    	"Karnataka",
	    	"Kerala",
	    	"Lakshadweep",
	    	"Madhya Pradesh",
	    	"Maharashtra",
	    	"Manipur",
	    	"Meghalaya",
	    	"Mizoram",
	    	"Nagaland",
	    	"Orissa",
	    	"Pondicherry",
	    	"Punjab",
	    	"Rajasthan",
	    	"Sikkim",
	    	"Tamil Nadu",
	    	"Telangana",
	    	"Tripura",
	    	"Uttaranchal",
	    	"Uttar Pradesh",
	    	"West Bengal"};
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewCust window = new CreateNewCust();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CreateNewCust() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Create Account");
		frame.getContentPane().setBackground(UIManager.getColor("ToolTip.background"));
		frame.setBounds(100, 100, 946, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(600, 565);
		
		JLabel Fname = new JLabel("First Name :");
		Fname.setFont(new Font("SansSerif", Font.BOLD, 11));
		Fname.setHorizontalAlignment(SwingConstants.LEFT);
		Fname.setBounds(35, 82, 66, 21);
		frame.getContentPane().add(Fname);
		
		JLabel Lname = new JLabel("Last  :");
		Lname.setFont(new Font("SansSerif", Font.BOLD, 11));
		Lname.setHorizontalAlignment(SwingConstants.LEFT);
		Lname.setBounds(321, 82, 66, 21);
		frame.getContentPane().add(Lname);
		
		JLabel city = new JLabel("City :");
		city.setFont(new Font("SansSerif", Font.BOLD, 11));
		city.setHorizontalAlignment(SwingConstants.LEFT);
		city.setBounds(35, 151, 66, 13);
		frame.getContentPane().add(city);
		
		JLabel State = new JLabel("State :");
		State.setFont(new Font("SansSerif", Font.BOLD, 11));
		State.setHorizontalAlignment(SwingConstants.LEFT);
		State.setBounds(321, 149, 66, 17);
		frame.getContentPane().add(State);
		
		JComboBox state = new JComboBox(s1);
		state.setMaximumRowCount(29);
		state.setBounds(442, 148, 96, 21);
		frame.getContentPane().add(state);
		frame.setVisible(true);
		
		LName = new JTextField();
		LName.setBounds(442, 84, 96, 19);
		frame.getContentPane().add(LName);
		LName.setColumns(10);
		
		FName = new JTextField();
		FName.setBounds(119, 83, 96, 19);
		frame.getContentPane().add(FName);
		FName.setColumns(10);
		
		City = new JTextField();
		City.setBounds(119, 148, 96, 19);
		frame.getContentPane().add(City);
		City.setColumns(10);
		
		JLabel age = new JLabel("Age :");
		age.setFont(new Font("SansSerif", Font.BOLD, 11));
		age.setBounds(35, 222, 45, 13);
		frame.getContentPane().add(age);
		
		Age = new JTextField();
		Age.setBounds(119, 219, 96, 19);
		frame.getContentPane().add(Age);
		Age.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("User Name :");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblNewLabel_5.setBounds(35, 329, 96, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		username = new JTextField();
		username.setBounds(150, 326, 96, 19);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Password :");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblNewLabel_6.setBounds(35, 363, 66, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Confirm Password : ");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 10));
		lblNewLabel_7.setBounds(35, 397, 96, 13);
		frame.getContentPane().add(lblNewLabel_7);
		
		confirmpass = new JTextField();
		confirmpass.setBounds(150, 394, 96, 19);
		frame.getContentPane().add(confirmpass);
		confirmpass.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 112, 20, 1);
		frame.getContentPane().add(horizontalStrut);
		
		JLabel lblNewLabel_8 = new JLabel("Enter Your Details");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_8.setBounds(150, 28, 237, 21);
		frame.getContentPane().add(lblNewLabel_8);
					
		Phone = new JTextField();
		Phone.setBounds(442, 220, 96, 19);
		frame.getContentPane().add(Phone);
		Phone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Phone Number");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(321, 223, 85, 13);
		frame.getContentPane().add(lblNewLabel);
		
		password = new JPasswordField();
		password.setBounds(150, 361, 96, 19);
		frame.getContentPane().add(password);
		
		JButton ca = new JButton("Create Account");
		ca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Firstname = FName.getText();
       		 	String Lastname = LName.getText();
       		 	String CAge = Age.getText();
       		 	String Ccity = City.getText();
       		 	String Cstate = String.valueOf(state.getSelectedItem());
       		 	String PNO = Phone.getText();
                String uname= username.getText();
                String Password=String.valueOf(password.getPassword());
                String Confirmpass = String.valueOf(confirmpass.getText());
                
                try {                
                	if(Firstname.length() == 0 || Lastname.length() == 0  || CAge.length() == 0 
                			|| Ccity.length() == 0  || Cstate.length() == 0 || uname.length() == 0 
                			 || Password.length() == 0 || Confirmpass.length() == 0 || PNO.length()==0) {                    	
                        JOptionPane.showMessageDialog(ca,"Fill in all the Details");
                    }
                	else if(Pattern.matches(name, Firstname)==false) {
                		JOptionPane.showMessageDialog(ca,"Enter valid name!!");
                	}
                	else if(Pattern.matches(laname,Lastname)==false) {
                		JOptionPane.showMessageDialog(ca,"Enter valid name!!");
                	}              	
                	else if(Integer.parseInt(CAge) < 1) {	                		
	                        JOptionPane.showMessageDialog(ca,"Please Enter valid age");  
                    }
                	else if(PNO.length()>10) {                		
                        JOptionPane.showMessageDialog(ca,"Enter valid Phone Number");
                    }
                	else if(Password.length()<6) {                		
                        JOptionPane.showMessageDialog(ca,"Password should have minimum of 6 characters");
                	}
                	else if(!Password.equals(Confirmpass)) {                		
                        JOptionPane.showMessageDialog(ca,"Passwords are not same!!");
                	}
                	else {
	                	try {
	                	Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "admin");	
	                    PreparedStatement st = (PreparedStatement)connection.prepareStatement("Select customer_id from customer_login where username =?;");
	                    st.setString(1,uname);	                    
	                    rs = st.executeQuery();
	                    if (rs.next()) {	                		
	                        JOptionPane.showMessageDialog(ca, "Username already exists");
	                        frame.setVisible(true);
	                        connection.close();
	                    }
	                    else {
	                    	try {
	                			Class.forName("org.postgresql.Driver");
	                			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "admin");
	                			Statement s = c.createStatement();
	                			String sqll = "select count(customer_id) from customer;";
	                			ResultSet rs1 = s.executeQuery(sqll);
	                			rs1.next();
	                			int count = rs1.getInt(1);	                			
	                			String sql = "select customer_id from customer;";	                			
	                			ResultSet r = s.executeQuery(sql);	                			
	                			int i=1;	                			
	                			while(r.next() && i < count) {
	                				i++;
	                			}
	                			String cid = r.getString(1);
	                			System.out.println(cid);	                			
	                			int a = 0;	                			
	                			for(int k=1;k<cid.length();k++) {
	                				a = a*10 + Character.getNumericValue(cid.charAt(k));
	                			}
	                			a++;
	                			String sql1 ="insert into Customer(customer_id,fname,lname,age,city,state)" +
	                			"values ('C"+ a +"','"+ Firstname +"','"+ Lastname +"',"+ Integer.parseInt(CAge) +",'"+ Ccity +"','"+ Cstate +"');";
	                			s.executeUpdate(sql1);
	                			
	                			String sql2 = "insert into customer_login values"+
	                					"('" + uname + "', '" +Password+ "', 'C" +  a + "');";
	                			s.executeUpdate(sql2);
	                			
	                			String sql3 = "insert into customer_phno values"+
	                					"( 'C"+ a +"', " +  Long.parseLong(PNO) + ");";
	                			s.executeUpdate(sql3);
	                			 
	                			JOptionPane.showMessageDialog(ca, "successfully created account");
	                			frame.dispose();
	                			new CustomerLogin();
	                    	}
	                    	catch(Exception ee) {
	                			ee.printStackTrace();
	                			System.err.println(ee.getClass().getName()+": "+ee.getMessage());
	                			System.exit(0);
	                    }
	                    	
	                    }
	                    
	                    c.close();
                		}
                		catch (SQLException sqlException) {
                            sqlException.printStackTrace();
                        }
                    
                    }
            }     
            catch(Exception ee) {
    			ee.printStackTrace();
    			System.out.println(ee.getClass().getName()+": "+ee.getMessage());
    			System.exit(0);
    		}   
        
        }
    });          
		ca.setBounds(321, 458, 129, 21);
		frame.getContentPane().add(ca);
        JLabel label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        frame.add(label);
        frame.setVisible(true);
        
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
