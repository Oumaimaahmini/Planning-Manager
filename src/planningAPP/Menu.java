package planningAPP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JFrame {
	
	private JPanel contentPane;
	
	JFrame Menu;

	
	public Menu() {
	
	setResizable(false);
	setBounds(100, 100, 900, 700);
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	getContentPane().setLayout(null);
	
	//
	JLabel lblNewLabel = new JLabel("Administrator");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
	lblNewLabel.setBounds(181, 380, 160, 22);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Professor");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setForeground(new Color(0, 0, 0));
	lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
	lblNewLabel_1.setBounds(373, 380, 159, 22);
	
	getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Students");
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
	lblNewLabel_2.setBounds(560, 379, 160, 25);
	
	getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Subject");
	lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	
	lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
	lblNewLabel_3.setBounds(181, 577, 160, 22);
	
	getContentPane().add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Class-rooms");
	lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	
	lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 18));
	lblNewLabel_4.setBounds(372, 577, 160, 22);
	
	getContentPane().add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Planning");
	lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 18));
	lblNewLabel_5.setBounds(560, 577, 160, 22);
	
	getContentPane().add(lblNewLabel_5);
	
	JLabel lblNewLabel_7 = new JLabel("Welcome to planning MANAGER");
	lblNewLabel_7.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
	lblNewLabel_7.setForeground(Color.WHITE);
	lblNewLabel_7.setBounds(23, 43, 562, 37);
	getContentPane().add(lblNewLabel_7);
	
	JButton btnNewButton = new JButton("LOG OUT");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			CloseJframe();
		}
	});
	btnNewButton.setForeground(Color.WHITE);
	btnNewButton.setBackground(new Color(0, 153, 255));
	btnNewButton.setBounds(635, 46, 222, 37);
	getContentPane().add(btnNewButton);
	
	JLabel lblNewLabel_6 = new JLabel("New label");
	lblNewLabel_6.setBounds(0, 0, 904, 138);
	Image img7 = new ImageIcon(this.getClass().getResource("/black.jpg")).getImage();
	lblNewLabel_6.setIcon(new ImageIcon(img7));
	getContentPane().add(lblNewLabel_6);
	
	JButton btnNewButton_Adminisrateur = new JButton("");
	btnNewButton_Adminisrateur.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			Admin win=new Admin();
			win.setVisible(true);
			CloseJframe();
		}
	});
	btnNewButton_Adminisrateur.setBackground(SystemColor.menu);
	btnNewButton_Adminisrateur.setBounds(181, 222, 160, 160);
	Image img1 = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
	btnNewButton_Adminisrateur.setIcon(new ImageIcon(img1));
	getContentPane().add(btnNewButton_Adminisrateur);
	
	JButton btnNewButton_prof = new JButton("");
	btnNewButton_prof.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Prof win=new Prof();
			win.setVisible(true);
			CloseJframe();
		}
	});
	btnNewButton_prof.setBackground(SystemColor.menu);
	btnNewButton_prof.setBounds(371, 222, 160, 160);
	Image img2 = new ImageIcon(this.getClass().getResource("/teacher.png")).getImage();
	btnNewButton_prof.setIcon(new ImageIcon(img2));
	getContentPane().add(btnNewButton_prof);
	
	JButton btnNewButton_stud = new JButton("");
	btnNewButton_stud.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Student win=new Student();
			win.setVisible(true);
			CloseJframe();
		}
		
	});
	btnNewButton_stud.setBackground(SystemColor.menu);
	btnNewButton_stud.setBounds(560, 222, 160, 160);
	Image img3 = new ImageIcon(this.getClass().getResource("/student.png")).getImage();
	btnNewButton_stud.setIcon(new ImageIcon(img3));
	getContentPane().add(btnNewButton_stud);
	
	JButton btnNewButton_sub = new JButton("");
	btnNewButton_sub.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Subject win=new Subject();
			win.setVisible(true);
			CloseJframe();
		}
	});
	btnNewButton_sub.setBackground(SystemColor.menu);
	btnNewButton_sub.setBounds(181, 418, 160, 160);
	Image img4 = new ImageIcon(this.getClass().getResource("/subject.png")).getImage();
	btnNewButton_sub.setIcon(new ImageIcon(img4));
	getContentPane().add(btnNewButton_sub);
	
	JButton btnNewButton_class = new JButton("");
	btnNewButton_class.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Classroom win=new Classroom();
			win.setVisible(true);
			CloseJframe();
		}
	});
	btnNewButton_class.setBackground(SystemColor.menu);
	btnNewButton_class.setBounds(371, 418, 160, 160);
	Image img5 = new ImageIcon(this.getClass().getResource("/salle.png")).getImage();
	btnNewButton_class.setIcon(new ImageIcon(img5));
	getContentPane().add(btnNewButton_class);
	
	JButton btnNewButton_plan = new JButton("");
	btnNewButton_plan.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Plan win=new Plan();
			win.setVisible(true);
			CloseJframe();
		}
	});
	btnNewButton_plan.setBackground(SystemColor.menu);
	btnNewButton_plan.setBounds(560, 418, 160, 160);
	Image img6 = new ImageIcon(this.getClass().getResource("/plan.png")).getImage();
	btnNewButton_plan.setIcon(new ImageIcon(img6));
	getContentPane().add(btnNewButton_plan);
	
	JLabel lblNewLabel_8 = new JLabel("New label");
	lblNewLabel_8.setBounds(0, 138, 884, 517);
	Image img8 = new ImageIcon(this.getClass().getResource("/img_jaune.jpg")).getImage();
	lblNewLabel_8.setIcon(new ImageIcon(img8));
	getContentPane().add(lblNewLabel_8);
	
	
	
	}
	public void CloseJframe(){
	    super.dispose();
	}

}
