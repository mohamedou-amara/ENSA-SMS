package EspaceAdmin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AcceuilScolarité {

	private JFrame frame;
	private JTable table;
	public static String apo ;
	DefaultTableModel model;
	

	/**
	 * Launch the application.
	 */
	public void show() {
		
		this.frame.setVisible(true);
		
		try {
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	    	   Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC","test","Test");
	    	   Statement stmt = conn.createStatement();
	    	   ResultSet rs = stmt.executeQuery("SELECT * FROM Demande Where Traitement='Non Traitée'");
	    	   while(rs.next()) {
	            	apo = rs.getString(1);
	            	String datedemande = rs.getString(7);
	            	String annedocu = rs.getString(6);
	            	String typtd = rs.getString(5);
	            	model.addRow(new Object[] {apo,typtd,datedemande,annedocu});
	           }
	           conn.close();
	      }catch(Exception e) {
	    	  System.out.println(e.getMessage());
	      }
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceuilScolarité window = new AcceuilScolarité();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AcceuilScolarité() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 113, 607, 270);
		frame.getContentPane().add(scrollPane);


		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Traiter_demande.apoo = table.getValueAt(table.getSelectedRow(),0).toString();
				Traiter_demande.typedemande = table.getValueAt(table.getSelectedRow(),1).toString();

			}
			
		});
		table.setBackground(new Color(0,51,102));
		table.setForeground(new Color(255,255,255));
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Apogée", "Type Demande", "Annee Demande","Date"
			}
			
		));
		

		
		 model = (DefaultTableModel) table.getModel();

		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(6, 6, 690, 95);
		frame.getContentPane().add(panel);
		
		JButton deconnexion = new JButton("Logout");
		deconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserType user = new UserType();
				user.show();
				frame.dispose();
			}
		});
		deconnexion.setIcon(new ImageIcon("/Users/macamara/Downloads/logout.png"));
		deconnexion.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		deconnexion.setBackground(new Color(220, 220, 220));
		deconnexion.setBounds(579, 35, 88, 29);
		panel.add(deconnexion);
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil acc = new Acceuil();
				acc.show();
				frame.dispose();
			}
		});
		btnAcceuil.setIcon(new ImageIcon("/Users/macamara/Downloads/home.png"));
		btnAcceuil.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAcceuil.setBackground(new Color(220, 220, 220));
		btnAcceuil.setBounds(474, 34, 97, 29);
		panel.add(btnAcceuil);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		lblLogo.setBackground(new Color(220, 220, 220));
		lblLogo.setBounds(6, 6, 301, 83);
		panel.add(lblLogo);
		
		JLabel lblAgentScolarit = new JLabel("Agent Scolarité");
		lblAgentScolarit.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		lblAgentScolarit.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblAgentScolarit.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgentScolarit.setBounds(365, 35, 97, 29);
		panel.add(lblAgentScolarit);
		
		JButton btnNewButton_1 = new JButton("traité demande");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Traiter_demande page = new Traiter_demande();
				if(table.getSelectedRow() >=0) {
					page.show();
		              frame.dispose();	  
		              }	
					else {
						JOptionPane.showMessageDialog(null,"Vous devez choisire une ligne ");				
					}
			}
			
			
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_1.setBounds(290, 387, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		

	}
}