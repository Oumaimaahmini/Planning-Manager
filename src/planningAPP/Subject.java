package planningAPP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Subject extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_firstname;
	private JTextField textField_id;
	Connection conn = null;
	PreparedStatement prepared = null;
	ResultSet res = null;
	
public Subject() {
		
		//connect
	     conn= ConnectSQLserver.ConnectDB();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("HOME PAGE");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu home=new Menu();
				home.setVisible(true);
				CloseJframe();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(574, 140, 375, 309);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int line = table.getSelectedRow();
				
				String cin = table.getValueAt(line, 0).toString();
				
				String fname = table.getValueAt(line, 1).toString(); 
				
				
				textField_id.setText(cin);
				textField_firstname.setText(fname);
				
				
			}
		});
		
		scrollPane.setViewportView(table);
		
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(875, 18, 128, 38);
		contentPane.add(btnNewButton);
	
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
            String sql = "DELETE FROM Subject WHERE id=? ";
				
				try {
					prepared =conn.prepareStatement(sql);
					prepared.setString(1,textField_id.getText().toString());
					prepared.execute();
					
					JOptionPane.showMessageDialog(null, "successfully deleted");
					
					updateTable();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(153, 478, 205, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EDIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
             String sql = "UPDATE Subject SET name=? WHERE id=? ";
				
				try {
					prepared =conn.prepareStatement(sql);
					prepared.setString(2,textField_id.getText().toString());
					prepared.setString(1,textField_firstname.getText().toString());
					prepared.execute();
					
					JOptionPane.showMessageDialog(null, "successfully edited");
					
					updateTable();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBackground(new Color(0, 153, 255));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(153, 419, 205, 38);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ADD NEW");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "INSERT INTO Subject (id,name) values (?,?)";
				
				try {
					prepared =conn.prepareStatement(sql);
					prepared.setString(1,textField_id.getText().toString());
					prepared.setString(2,textField_firstname.getText().toString());
					
					prepared.execute();
					
					JOptionPane.showMessageDialog(null, "successfully Added");
					
					updateTable();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 153, 255));
		btnNewButton_3.setBounds(153, 363, 205, 38);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SHOW LIST");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateTable();
			}
		});
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(673, 478, 205, 38);
		contentPane.add(btnNewButton_4);
		
		textField_firstname = new JTextField();
		textField_firstname.setBounds(153, 164, 220, 30);
		contentPane.add(textField_firstname);
		textField_firstname.setColumns(10);
		
		textField_id = new JTextField();
		textField_id.setColumns(10);
		textField_id.setBounds(153, 74, 220, 30);
		contentPane.add(textField_id);
		
		JLabel lblNewLabel_4_1 = new JLabel("ID           :");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(50, 77, 80, 20);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4 = new JLabel("Name     :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(50, 167, 92, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 470, 562);
		Image img = new ImageIcon(this.getClass().getResource("/black.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("      Subject");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_3.setBounds(472, 0, 375, 74);
		Image img4 = new ImageIcon(this.getClass().getResource("/sub2.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img4));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 1034, 74);
		Image img3 = new ImageIcon(this.getClass().getResource("/imgg.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		contentPane.add(lblNewLabel_2);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(472, 0, 562, 562);
		Image img2 = new ImageIcon(this.getClass().getResource("/img_jaune.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(518, 141, 46, 14);
		contentPane.add(label);
		
		
		
		
		
		
	}
	
	public void updateTable() {
		
		String sql = "SELECT * FROM Subject";
		
		try {
			prepared = conn.prepareStatement(sql);
			res = prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(res));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CloseJframe(){
	    super.dispose();
	}

}
