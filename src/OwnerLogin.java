import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.UIManager;

public class OwnerLogin implements ActionListener{

	JFrame fra;
	private JTextField textField;
	private JPasswordField passwordField;
	JButton btnNewButton;
	JLabel label;
	ResultSet rs;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerLogin window = new OwnerLogin();
					window.fra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public OwnerLogin() {
		initialize();
	}

	private void initialize() {		
		fra = new JFrame("Owner Login");
		fra.getContentPane().setBackground(UIManager.getColor("ToolTip.background"));
		fra.setBounds(100, 100, 450, 300);
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fra.getContentPane().setLayout(null);
		fra.setSize(420,420);
		
		JLabel Username = new JLabel("Username:");
		Username.setFont(new Font("SansSerif", Font.BOLD, 11));
		Username.setBounds(83, 92, 61, 16);
		fra.getContentPane().add(Username);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("SansSerif", Font.BOLD, 11));
		password.setBounds(83, 141, 61, 19);
		fra.getContentPane().add(password);
		
		textField = new JTextField();
		textField.setBounds(173, 92, 96, 19);
		fra.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 141, 96, 19);
		fra.getContentPane().add(passwordField);
		
		JCheckBox check = new JCheckBox("Show Password");
		check.setBackground(UIManager.getColor("ToolTip.background"));
		check.setFont(new Font("Tahoma", Font.PLAIN, 8));
		check.setBounds(286, 140, 93, 21);
		fra.getContentPane().add(check);
		check.addItemListener(new ItemListener() {
       	 public void itemStateChanged(ItemEvent e) {
       		if(e.getStateChange()==ItemEvent.SELECTED)
       		{
       			passwordField.setEchoChar((char)0);
       		}
       		else
       		{
       		passwordField.setEchoChar('\u2022');
       		}
       	
       	 }
        });
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton.setBounds(173, 186, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName = textField.getText();        
		        String Password=String.valueOf(passwordField.getPassword());
		        try {
		       	 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "Suraj@27");
		       	 PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select username,password from owner_login where username =? and password =?");
		       	 st.setString(1, UserName);
		       	 st.setString(2, Password);
		       	 
		       	 rs = st.executeQuery();
		       	 
		       	 if (rs.next()) {           	 
	                fra.setVisible(false);
	                new CustomerPage(UserName,Password);
	                JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
		       	 }
		       	 else {		           	 
	           	 new CustomerLogin();
	           	 fra.dispose();
	                JOptionPane.showMessageDialog(btnNewButton, "Wrong Username 'OR' Password");
	            }
		}
	        catch (SQLException sqlException) {
	        	sqlException.printStackTrace();
	        }
		}			
		});
		fra.add(btnNewButton);
		fra.getContentPane().add(btnNewButton);
		label = new JLabel("");
		label.setBackground(UIManager.getColor("ToolTip.background"));
        label.setBounds(0, 0, 420, 373);        
        fra.getContentPane().add(label);
        fra.setVisible(true);
	}
			

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}
