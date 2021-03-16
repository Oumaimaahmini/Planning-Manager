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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

public class Plan extends JFrame{

	private JPanel contentPane;
	private JTable table;
	Connection conn = null;
	PreparedStatement prepared = null;
	ResultSet res = null;
	JDateChooser dateChooser;
	String id_tab;
	
	JComboBox comboBox_group;
	JComboBox comboBox_subject;
	JComboBox comboBox_prof;
	JComboBox comboBox_salle;
	private JTextField textField_time;
	
public Plan() {
		
		//
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
		scrollPane.setBounds(500, 140, 524, 309);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int line = table.getSelectedRow();
				

				
				//String date = table.getValueAt(line, 0).toString();
				String time = table.getValueAt(line, 1).toString(); 
				String group =table.getValueAt(line, 2).toString(); 
				String sub = table.getValueAt(line, 3).toString(); 
				String prof = table.getValueAt(line, 4).toString(); 
				String clas = table.getValueAt(line, 5).toString(); 
				
				
				textField_time.setText(time);
				comboBox_group.setSelectedItem(group);
				comboBox_subject.setSelectedItem(sub);
				comboBox_prof.setSelectedItem(prof);
				comboBox_salle.setSelectedItem(clas);
				
				id_tab = table.getValueAt(line, 6).toString(); 
				
				//JOptionPane.showMessageDialog(null,id_tab);
				
				
				
				
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
				
           String sql = "DELETE FROM Tab WHERE id=? ";
				
				try {
					updateTable();
					prepared =conn.prepareStatement(sql);
					prepared.setString(1,id_tab);
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
				
            String sql = "update Tab set  date = ?,time = ?,class= ?,subject = ?,professor = ?,classroom = ?  where id = ? ";
				
				try {
					updateTable();
					String dt=dateChooser.getDate().toString();
					prepared =conn.prepareStatement(sql);
					prepared.setString(1,dt.substring(0, 11));
					prepared.setString(2,textField_time.getText().toString());
					prepared.setString(3, comboBox_group.getSelectedItem().toString());
					prepared.setString(4, comboBox_subject.getSelectedItem().toString());
					prepared.setString(5,comboBox_prof.getSelectedItem().toString());
					prepared.setString(6, comboBox_salle.getSelectedItem().toString());
					prepared.setString(7, id_tab);
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
		
		JButton btnNewButton_3 = new JButton("SAVE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "insert into Tab (date, time, class, subject, professor, classroom) values (?,?,?,?,?,?)";
				
				try {
					updateTable();
					String dt=dateChooser.getDate().toString();
					prepared =conn.prepareStatement(sql);
					prepared.setString(1,dt.substring(0, 11));
					prepared.setString(2,textField_time.getText().toString());
					prepared.setString(3, comboBox_group.getSelectedItem().toString());
					prepared.setString(4,comboBox_subject.getSelectedItem().toString());
					prepared.setString(5, comboBox_prof.getSelectedItem().toString());
					prepared.setString(6, comboBox_salle.getSelectedItem().toString());
					
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
		
		JButton btnNewButton_4 = new JButton("SHOW Planning");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateTable();
			}
		});
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(673, 478, 205, 38);
		contentPane.add(btnNewButton_4);
		
		/*
		 Date date = new Date();
		 SpinnerDateModel sm = 
		 new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		*/
		/*
		spinner = new JSpinner(sm);

		
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		spinner.setEditor(de);
		
		spinner.setBounds(337, 46, 112, 20);
		contentPane.add(spinner);*/
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(105, 46, 118, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_4_2 = new JLabel("Time :");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(254, 44, 63, 20);
		contentPane.add(lblNewLabel_4_2);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Date :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(23, 44, 72, 20);
		contentPane.add(lblNewLabel_4);
		
		comboBox_salle = new JComboBox();
		comboBox_salle.setBounds(337, 235, 112, 22);
		contentPane.add(comboBox_salle);
		remplirCombox_salle();
		
		comboBox_group = new JComboBox();
		comboBox_group.setBounds(105, 137, 118, 22);
		contentPane.add(comboBox_group);
		remplirCombox_group();
		
		comboBox_subject = new JComboBox();
		comboBox_subject.setBounds(337, 137, 112, 22);
		contentPane.add(comboBox_subject);
		remplirCombox_subject();
		
		comboBox_prof = new JComboBox();
		comboBox_prof.setBounds(105, 235, 118, 22);
		contentPane.add(comboBox_prof);
		remplirCombox_prof();
		
		textField_time = new JTextField();
		textField_time.setBounds(337, 46, 112, 20);
		contentPane.add(textField_time);
		textField_time.setColumns(10);
		
		//
		JLabel label = new JLabel("New label");
		label.setBounds(518, 141, 46, 14);
		contentPane.add(label);
		//remplirCombox();
		
		JLabel lblNewLabel_5 = new JLabel("Group :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(23, 141, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Subject :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(242, 140, 63, 14);
		contentPane.add(lblNewLabel_6);
		//remplirCombox_subject();
		
		JLabel lblNewLabel_7 = new JLabel("Professor :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(23, 238, 72, 14);
		contentPane.add(lblNewLabel_7);
		//remplirCombox_prof();
		
		
		JLabel lblNewLabel_8 = new JLabel("Class-room :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(242, 238, 81, 14);
		contentPane.add(lblNewLabel_8);
		//remplirCombox_salle();
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 470, 562);
		Image img = new ImageIcon(this.getClass().getResource("/black.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("      Planning");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_3.setBounds(472, 0, 375, 74);
		Image img4 = new ImageIcon(this.getClass().getResource("/plan2.png")).getImage();
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
		
		
		
		
		
		
		
		
		
		
	}
	
	public void updateTable() {
		
		String sql = "select * from Tab ";
		
		try {
			prepared = conn.prepareStatement(sql);
			res = prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(res));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void remplirCombox_group() {
		
		String sql="Select * from class ";
		
		try {
			prepared =conn.prepareStatement(sql);
			res= prepared.executeQuery();
			
			while(res.next()) {
				
				String nom= res.getString("name").toString();
				comboBox_group.addItem(nom);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
public void remplirCombox_subject() {
		
		String sql="Select * from Subject ";	
		try {
			prepared =conn.prepareStatement(sql);
			res= prepared.executeQuery();
			
			while(res.next()) {
				
				String nom= res.getString("name").toString();
				comboBox_subject.addItem(nom);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

public void remplirCombox_prof() {
	
	String sql="Select * from professor ";	
	try {
		prepared =conn.prepareStatement(sql);
		res= prepared.executeQuery();
		
		while(res.next()) {
			
			String nom= res.getString("first_name").toString()+" "+ res.getString("last_name").toString();
			comboBox_prof.addItem(nom);
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
}

public void remplirCombox_salle() {
	
	String sql="Select * from salle ";
	
	try {
		prepared =conn.prepareStatement(sql);
		res= prepared.executeQuery();
		
		while(res.next()) {
			
			String nom= res.getString("name").toString();
			comboBox_salle.addItem(nom);			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
}
public void CloseJframe(){
    super.dispose();
}

}
