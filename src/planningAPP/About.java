package planningAPP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class About extends JFrame {
	
	private JPanel contentPane;

	public About() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel(" one another.");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(176, 297, 343, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_5 = new JLabel("Class-rooms, and  school subjects.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(176, 183, 393, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Having an excellent planning space is key to being able");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(176, 219, 393, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("to make creative decisions and communicate with ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(176, 262, 393, 14);
		contentPane.add(lblNewLabel_6);
		
		
		
		JLabel lblNewLabel = new JLabel("About Planning MANAGER application");
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(151, 22, 407, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("school plannig including Students group, Professors, ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(176, 145, 393, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Planning MANADGER application is a platform for managing ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(176, 87, 382, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 155, 372);
		Image img1 = new ImageIcon(this.getClass().getResource("/time.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img1));
		contentPane.add(lblNewLabel_2);
		
		JLabel back = new JLabel("New label");
		back.setBounds(0, 0, 618, 391);
		Image img2 = new ImageIcon(this.getClass().getResource("/black.jpg")).getImage();
		back.setIcon(new ImageIcon(img2));
		contentPane.add(back);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(158, 145, 400, 21);
		contentPane.add(lblNewLabel_3);
	}
}
