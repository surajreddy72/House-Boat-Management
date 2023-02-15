import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login implements ActionListener {

	static JFrame f;
	
	public Login() {
		f = new JFrame("Login");
		f.getContentPane().setBackground(UIManager.getColor("ToolTip.background"));
		f.setBounds(100, 100, 420, 420);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		JButton Customer = new JButton("Customer");
		Customer.setBackground(UIManager.getColor("activeCaption"));
		Customer.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		Customer.setBounds(138, 96, 121, 29);
		f.getContentPane().add(Customer);
		
		JButton Owner = new JButton("Owner");
		Owner.setBackground(UIManager.getColor("activeCaption"));
		Owner.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		Owner.setBounds(138, 164, 121, 29);
		f.getContentPane().add(Owner);
		
		JLabel lblNewLabel = new JLabel("Login privilege");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 31, 121, 29);
		f.getContentPane().add(lblNewLabel);
		f.setVisible(true);
		
		Owner.addActionListener(this);
		Customer.addActionListener(this);	
		
	}
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Owner")) {
			new OwnerLogin();
			f.setVisible(false);
		}
		else if(s.equals("Customer")) {
			new CustomerLogin();
			f.setVisible(false);
		}
		else {
			Home.fr.setVisible(true);
			f.setVisible(false);
		}
	}
	public static void main(String[] args) {
		new Login();
	}
}

