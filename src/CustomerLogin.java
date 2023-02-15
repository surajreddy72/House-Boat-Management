import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.EventQueue;
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



public class CustomerLogin implements ActionListener{

	static JFrame f;
	private JTextField textField;
	private JPasswordField passwordField;
	JButton btnNewButton;
	JLabel label;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLogin window = new CustomerLogin();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CustomerLogin() {
		initialize();
	}

	private void initialize() {	
		
		f = new JFrame("Customer Login");
		f.getContentPane().setBackground(UIManager.getColor("ToolTip.background"));
		f.setBounds(100, 100, 450, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setSize(420,420);
		f.setVisible(true);
		
		JLabel Username = new JLabel("Username:");
		Username.setFont(new Font("SansSerif", Font.BOLD, 11));
		Username.setBounds(83, 92, 61, 16);
		f.getContentPane().add(Username);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("SansSerif", Font.BOLD, 11));
		password.setBounds(83, 141, 61, 19);
		f.getContentPane().add(password);
		
		textField = new JTextField();
		textField.setBounds(173, 92, 96, 19);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 141, 96, 19);
		f.getContentPane().add(passwordField);
		
		JCheckBox check = new JCheckBox("Show Password");
		check.setBackground(UIManager.getColor("ToolTip.background"));
		check.setFont(new Font("Tahoma", Font.PLAIN, 8));
		check.setBounds(286, 140, 93, 21);
		f.getContentPane().add(check);
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

		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select username,password from customer_login where username =? and password =?");
		            
		            st.setString(1, UserName);
		            st.setString(2, Password);
		            
		            ResultSet rs = st.executeQuery();
		            if (rs.next()) {           	 
		                f.setVisible(false);
		                new CustomerPage(UserName,Password);
		                JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
		                
		            } else {		           	 
		           	 new CustomerLogin();
		           	 f.dispose();
		                JOptionPane.showMessageDialog(btnNewButton, "Wrong Username 'OR' Password");
		            }
			}
		        catch (SQLException sqlException) {
		        	sqlException.printStackTrace();
		        }
		}
	});
		f.getContentPane().add(btnNewButton);
		 label = new JLabel("");
		 label.setBackground(UIManager.getColor("ToolTip.background"));
         label.setBounds(0, 0, 420, 373);
         
         f.getContentPane().add(label);
         
         JButton NewAcc = new JButton("Create New Account");
         NewAcc.setFont(new Font("SansSerif", Font.ITALIC, 12));         
         NewAcc.setBackground(UIManager.getColor("ToolTip.background"));
         NewAcc.setBounds(240, 297, 139, 21);
         f.getContentPane().add(NewAcc);
         NewAcc.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				String s = e.getActionCommand();
 				if(s.equals("Create New Account")) {
 					new CreateNewCust();
 					CreateNewCust.frame.setVisible(true);
 					f.setVisible(false);
 				}
 			}
         });
        		
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}