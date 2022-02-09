package EspaceAdmin;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.Font;


public class Historique {

	private JFrame frame;
	private JTable table;
	DefaultTableModel model;
	private JTextField txtSaisirLapoge;

	public void show() 
	{	
		this.frame.setVisible(true);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historique window = new Historique();
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
	public Historique() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(255,255,255));
		frame.getContentPane().setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 151, 611, 265);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);		
		
	
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//apo = table.getValueAt(table.getSelectedRow(),0).toString();
				//typedemande = table.getValueAt(table.getSelectedRow(),1).toString();
			}
			
		});
		table.setBackground(new Color(0,51,102));
		table.setForeground(new Color(255,255,255));
		//table.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Apogée", "Type Demande", "Annee Demande","Date","Etat de traitement"
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
		btnAcceuil.setBackground(new Color(220, 220, 220));
		btnAcceuil.setBounds(460, 35, 97, 29);
		panel.add(btnAcceuil);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		lblLogo.setBackground(new Color(220, 220, 220));
		lblLogo.setBounds(6, 6, 301, 83);
		panel.add(lblLogo);
		
		JLabel lblManager = new JLabel("Agent Scolarité");
		lblManager.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblManager.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		lblManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblManager.setBounds(351, 35, 97, 29);
		panel.add(lblManager);
		
		txtSaisirLapoge = new JTextField("");
		txtSaisirLapoge.setBounds(98, 113, 218, 34);
		frame.getContentPane().add(txtSaisirLapoge);
		txtSaisirLapoge.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Chercher:");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/Downloads/magnifying-glass.png"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(16, 123, 86, 16);
		frame.getContentPane().add(lblNewLabel);
		txtSaisirLapoge.addFocusListener((FocusListener) new FocusListener(){ 
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtSaisirLapoge.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
	    });
		
		txtSaisirLapoge.addKeyListener(new KeyListener(){

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
						Search(txtSaisirLapoge.getText());
						
					}
	            }
	        );
		
		JButton btnNewButton = new JButton("Traiter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Traiter_demande page2 = new Traiter_demande();
				if(table.getSelectedRow() >=0) {
					page2.show();
		              frame.dispose();	  
		              }	
					else {
						JOptionPane.showMessageDialog(null,"Vous devez choisire une ligne ");				
					}
			}
		});
		
		try {
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	    	   Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC","test","Test");
	    	   Statement stmt = conn.createStatement();
	    	   ResultSet rs = stmt.executeQuery("SELECT * FROM Demande Where Traitement != 'Non Traitée'");
	    	   while(rs.next()) {
	            	String apo = rs.getString(1);
	            	String datedemande = rs.getString(7);
	            	String annedocu = rs.getString(6);
	            	String typtd = rs.getString(5);
	            	String etat = rs.getString(8);
	            	model.addRow(new Object[] {apo,typtd,datedemande,annedocu,etat});
	           }
	           conn.close();
	      }catch(Exception e) {
	    	  System.out.println(e.getMessage());
	      }
		
		

	}
	
	public void Search(String str) 
	{
		model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter <>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
}