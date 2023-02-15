import java.awt.EventQueue;

import javax.swing.JFrame;

public class Status {
	String C_id;

	private JFrame frame;
	Status(String s1){
		C_id = s1;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
