package planningAPP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Welcome extends JFrame {
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	Connection conn = null;
	PreparedStatement prepared = null;
	ResultSet res = null;
	
	public static void main(String[] args) {    
        // Creating instance of JFrame
		try {
			JFrame frame = new JFrame("Welcome to Planning MANAGER application");
		     // Setting the width and height of frame
		     frame = new JFrame();
				frame.setResizable(false);
				frame.setBounds(100, 100, 900, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		     /* Creating panel. This is same as a div tag in HTML
		      * We can create several panels and add them to specific 
		      * positions in a JFrame. Inside panels we can add text 
		      * fields, buttons and other components.
		      */
		     JPanel panel = new JPanel();    
		     // adding panel to frame
		     frame.add(panel);
		     /* calling user defined method for adding components
		      * to the panel.
		      */
			Welcome window = new Welcome();
			window.placeComponents(panel);
			// Setting the frame visibility to true
	        frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}     
    }
private void placeComponents(JPanel panel) {
		// TODO Auto-generated method stub
	 panel.setLayout(null);

     // Creating JLabel
     JLabel userLabel = new JLabel("User Name :");
     userLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
     userLabel.setBounds(409, 198, 125, 14);
     panel.add(userLabel);
     //connect BD
     conn= ConnectSQLserver.ConnectDB();
     
     /* Creating text field where user is supposed to
      * enter user name.
      */
     JTextField userText = new JTextField(20);
     userText.setBounds(528, 193, 265, 29);
		
		//textField.setColumns(10);
     panel.add(userText);

     // Same process for password label and text field.
     JLabel passwordLabel = new JLabel("Password   :");
     passwordLabel.setForeground(new Color(0, 0, 0));
     passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
     passwordLabel.setBounds(409, 275, 125, 14);
     panel.add(passwordLabel);

     //
     JPasswordField passwordText = new JPasswordField(20);
     passwordText.setBounds(528, 265, 265, 29);
     panel.add(passwordText);

     // Creating login button
     JButton loginButton = new JButton("LOGIN");
     loginButton.setFont(new Font("Arial", Font.PLAIN, 12));
     loginButton.setForeground(new Color(255, 255, 255));
	 loginButton.setBackground(new Color(30, 144, 255));
	 loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userText.getText().toString();
				String pass = passwordText.getText().toString();
				String sql = "SELECT username, password FROM administrator";
				try {
					prepared = conn.prepareStatement(sql);
					res = prepared.executeQuery();
					if(!user.equals("")&& !pass.equals(""))
					{
					int i=0;
					while(res.next()){
						String user1=res.getString("username");
						String pass1=res.getString("password");
						
						if(user.equals(user1)&& pass.equals(pass1)) {
												i=1;
												JOptionPane.showMessageDialog(null, "Connected succesfully");
												Menu win = new Menu();
												win.setVisible(true);
												
											}
						   }			
						
						if(i==0){JOptionPane.showMessageDialog(null, "Not Connected !!");}
						}else {JOptionPane.showMessageDialog(null, "enter username and password !!");}
									
					
				}catch(SQLException e1) {e1.printStackTrace(); }
				}
		});
	 loginButton.setBounds(528, 357, 265, 36);
     panel.add(loginButton);
     //
     lblNewLabel = new JLabel("Planning MANAGER");
		lblNewLabel.setBackground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 53));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 884, 85);
		panel.add(lblNewLabel);
     
     //
		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setBounds(0, 0, 884, 85);
		Image img3 = new ImageIcon(this.getClass().getResource("/imgg.png")).getImage();
		lblNewLabel2.setIcon(new ImageIcon(img3));
		panel.setLayout(null);
		panel.add(lblNewLabel2);
		//
     lblNewLabel_2 = new JLabel("2SIG EHTP");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(818, 548, 66, 14);
		panel.add(lblNewLabel_2);
     //
     lblNewLabel_1 = new JLabel("Version 1.0  2021");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 548, 121, 14);
		panel.add(lblNewLabel_1);
     //
     
     JLabel lblAboutPlanningManadger = new JLabel("About Planning MANADGER application");
		lblAboutPlanningManadger.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutPlanningManadger.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAboutPlanningManadger.setForeground(new Color(30, 144, 255));
		lblAboutPlanningManadger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				About win2= new About();
				win2.setVisible(true);
			}
		});
		lblAboutPlanningManadger.setBounds(528, 457, 265, 14);
		panel.add(lblAboutPlanningManadger);
     
     //
     JLabel time = new JLabel("New label");
		time.setBounds(0, 0, 360, 600);
		Image img2 = new ImageIcon(this.getClass().getResource("/time.jpg")).getImage();
		time.setIcon(new ImageIcon(img2));
		panel.add(time);
		
		JLabel background = new JLabel("New label");
		background.setBounds(0, 0, 884, 562);
		Image img = new ImageIcon(this.getClass().getResource("/img_jaune.jpg")).getImage();
		panel.setLayout(null);
		background.setIcon(new ImageIcon(img));
		panel.add(background);
		
	}


	
}
