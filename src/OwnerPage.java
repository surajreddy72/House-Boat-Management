import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.sql.*;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class OwnerPage {
	String username;
	String password;
	String O_id;
	Connection c;
	Statement s;
	JButton btnNewButton; 

	private JFrame f;
	OwnerPage(String s1,String s2){
		username = s1;
    	password = s2;
    	
		f = new JFrame();
		f.setBounds(100, 100, 599, 384);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		f.setJMenuBar(menuBar);		
		f.setVisible(true);		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);		
		JButton Logout = new JButton("Logout");
		Logout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(Logout);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();				
				JOptionPane.showMessageDialog(btnNewButton, "You have been successfully logged out");
				new Home();				
			}
		});
		menuBar.add(new JMenu(" "));
		
		JButton Home = new JButton("Home");
		Home.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(Home);			
		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				f.dispose();
				new Home();
			}
		});
		
		setConnection();
		Display();
		
	}
		public void setConnection() {
	    	try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "admin");
			}
			catch(Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}
		
	    }
	    public void Display(){
	    	try {
	    		s = (Statement) c.createStatement();
	        	
	        	PreparedStatement st = (PreparedStatement)c.prepareStatement("Select owner_id from owner_login where username =?;");  
	    		
	            st.setString(1,username);
	            ResultSet rs = st.executeQuery() ;
				rs.next();
				
				O_id = rs.getString(1);
				PreparedStatement select = (PreparedStatement)c
	                    .prepareStatement
	                    ("select owner_id,fname||' '|| lname as Name from owner where owner_id =?;");
				select.setString(1, O_id);				
				ResultSet r	= select.executeQuery();
				r.next();
				String O_id =r.getString(1);
				String OName = r.getString(2);
				
				
				Box b1 = Box.createVerticalBox();				
				b1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) UIManager.getColor("Tree.selectionBackground")));
				b1.setBackground(UIManager.getColor("ToolTip.background"));
				JLabel Title = new JLabel("OWNER DETAILS");
				Title.setHorizontalAlignment(SwingConstants.CENTER);
				Title.setVerticalAlignment(SwingConstants.TOP);
				Title.setFont(new Font("Times New Roman", Font.BOLD, 26));
				Title.setForeground(Color.black);
				Title.setAlignmentX( Box.CENTER_ALIGNMENT);
				
				String Cid = "OWNER ID : " + O_id;
				JLabel Cusid = new JLabel(Cid);
				Cusid.setForeground(Color.DARK_GRAY);
				
				String CNAME = "OWNER NAME : " + OName;
				JLabel Custname  = new JLabel(CNAME);
				Custname.setForeground(Color.DARK_GRAY);				
				
				
				b1.add(Title);
				b1.add(Box.createVerticalStrut( 20 ) ); 
				b1.add(Cusid); 
				b1.add(Box.createVerticalStrut( 20 ) ); 
				b1.add(Custname); 
				b1.add(Box.createVerticalStrut( 20 ) ); 
				
				f.getContentPane().add(b1);
				
				JButton btnNewButton_1 = new JButton("Check Boats");
				btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 14));
				btnNewButton_1.setBackground(UIManager.getColor("ToolTip.background"));
				b1.add(btnNewButton_1);
				
	    	}
	    	catch(Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}		
    }    
}
