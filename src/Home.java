import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

import java.awt.Font;


public class Home {

	static JFrame fr;
	
	public Home() {
		fr = new JFrame();
		fr.setTitle("Home");
		fr.setSize(600,600);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.getContentPane().setLayout(new BorderLayout(30,30));
		
		
		JMenuBar mb = new JMenuBar();
		mb.setAlignmentY(Component.CENTER_ALIGNMENT);
		mb.setBorder(new EmptyBorder(10,10,10,10));
		mb.add(Box.createGlue());
		fr.getContentPane().add(mb);
		mb.setBackground(new Color(153, 204, 255));
		fr.getContentPane().add(mb,BorderLayout.NORTH);
		JButton Loginbtn = new JButton("Login");
		Loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = e.getActionCommand();
				if(s.equals("Login")) {
					new Login();
					fr.setVisible(false);
				}
				else if (s.equals("Home")) {
					new Home();
					fr.setVisible(false);
				}
			}
		});
		
		Loginbtn.setBackground(UIManager.getColor("ToolTip.background"));
		mb.add(Loginbtn);
		mb.add(new JMenu(" "));		
		
		JButton Home = new JButton("Home");
		Home.setHorizontalAlignment(SwingConstants.RIGHT);
		mb.add(Home);
		
		JLabel HBM = new JLabel("HOUSEBOAT MANAGEMENT");		
		HBM.setFont(new Font("Tahoma", Font.BOLD, 20));
		HBM.setVerticalAlignment(SwingConstants.TOP);
		HBM.setHorizontalTextPosition(SwingConstants.CENTER);
		HBM.setHorizontalAlignment(SwingConstants.CENTER);
		HBM.setAlignmentY(Component.TOP_ALIGNMENT);
		HBM.setAlignmentX(Component.CENTER_ALIGNMENT);
		fr.getContentPane().add(HBM, BorderLayout.CENTER);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		fr.getContentPane().add(horizontalGlue, BorderLayout.WEST);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		fr.getContentPane().add(horizontalGlue_1, BorderLayout.EAST);
		
		Component verticalGlue = Box.createVerticalGlue();
		fr.getContentPane().add(verticalGlue, BorderLayout.SOUTH);
		fr.setVisible(true);
	}
	public static void main(String[] args) {
		new Home();
	}
}
