import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;

public class BookGUI implements ActionListener {

	String time = "([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
	String name = "\\b[A-Z][a-z]+([A-Z][a-z]*)*\\b";
	String lname = "\\b[A-Z][a-z]+";
	String customer_id;
	JFrame f ;
	JComboBox combobox;
	Date d = new Date();
	Book obj = new Book();
	JTextField Ddate;
	private JTextField Persons;
	private JTextField Date;
	private JTextField Duration;

	@SuppressWarnings("unchecked")
	BookGUI(String s1) {
		customer_id = s1;
		f = new JFrame("Booking");
		f.getContentPane().setBackground(UIManager.getColor("ToolTip.background"));
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOKING");
		lblNewLabel.setBounds(0, 0, 586, 24);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		f.getContentPane().add(lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(10, 10, 70, 500);
		f.getContentPane().add(verticalStrut);
		
		JLabel HID = new JLabel("HouseBoat Number:");
		HID.setFont(new Font("Tahoma", Font.BOLD, 12));
		HID.setBackground(UIManager.getColor("activeCaption"));
		HID.setBounds(90, 89, 130, 13);
		f.getContentPane().add(HID);
		
		
		String Hid[] = obj.getHid();
		combobox = new JComboBox(Hid);
		combobox.setMaximumRowCount(4);
		combobox.setBounds(251, 86, 96, 21);
		f.getContentPane().add(combobox);
		
		JLabel persons = new JLabel("Number of persons:");
		persons.setFont(new Font("Tahoma", Font.BOLD, 12));
		persons.setBounds(90, 150, 130, 13);
		f.getContentPane().add(persons);
		
		Persons = new JTextField();
		Persons.setBounds(251, 148, 96, 19);
		f.getContentPane().add(Persons);
		Persons.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(90, 112, 130, 28);
		f.getContentPane().add(verticalStrut_1);
		
		Component verticalStrut_1_1 = Box.createVerticalStrut(20);
		verticalStrut_1_1.setBounds(90, 173, 130, 28);
		f.getContentPane().add(verticalStrut_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Date:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(90, 225, 130, 13);
		f.getContentPane().add(lblNewLabel_3);
		
		Ddate = new JTextField();
		Ddate.setBounds(251, 223, 96, 19);
		LocalDate date = LocalDate.now();
		Ddate.setText(" " +date);
		f.getContentPane().add(Ddate);
		Ddate.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Duration(HH:MM:SS):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(90, 286, 142, 13);
		f.getContentPane().add(lblNewLabel_4);
		
		Component verticalStrut_1_1_1 = Box.createVerticalStrut(20);
		verticalStrut_1_1_1.setBounds(90, 248, 130, 28);
		f.getContentPane().add(verticalStrut_1_1_1);
		
		Duration = new JTextField();
		Duration.setBounds(251, 284, 96, 19);
		f.getContentPane().add(Duration);
		Duration.setColumns(10);
		
		JButton Submit = new JButton("Submit");
		Submit.setBounds(262, 409, 85, 21);
		Submit.addActionListener(this);
		f.getContentPane().add(Submit);
		
		Component verticalStrut_1_1_1_1 = Box.createVerticalStrut(20);
		verticalStrut_1_1_1_1.setBounds(90, 309, 130, 28);
		f.getContentPane().add(verticalStrut_1_1_1_1);
		f.setBounds(100, 100, 600, 601);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		f.setJMenuBar(menuBar);
		
		JButton BTH = new JButton("Back To Login");
		BTH.setFont(new Font("SansSerif", Font.BOLD, 12));
		BTH.addActionListener(this);
		
		JButton btnNewButton = new JButton("View Boats");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Boats();
			}
		});
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		menuBar.add(BTH);
		
		JMenu mnNewMenu = new JMenu(" ");
		menuBar.add(mnNewMenu);
		f.setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Submit")) {
			String HID = (String) combobox.getSelectedItem();
			String DATE = Ddate.getText();
			String DUR =  Duration.getText();
			String PEOP = Persons.getText();
			
			
			if(HID.length()==0 || DUR.length()==0 || DATE.length()==0 ) {
				JOptionPane.showMessageDialog(f,"Fill in all the details");
			}
			else if(Pattern.matches(time, DUR) == false) {
				JOptionPane.showMessageDialog(f,"Enter valid Time!!");
			}
			else if(obj.search(HID, DATE)) {
				JOptionPane.showMessageDialog(f,"This HouseBoat is already taken on this date!");
			}
			/*else if(obj.capacity(HID,DATE)) {
				JOptionPane.showMessageDialog(f,"The HouseBoat is full on that moment " );				
			}*/
			else {
				JOptionPane.showMessageDialog(f,"Successfully saved your details!");
							
				obj.insert_rents(HID,customer_id, DATE, DUR,PEOP);
				f.dispose();					
			}
		}
		else {
			CustomerLogin.f.setVisible(true);
			f.setVisible(false);
		}
	}
}
