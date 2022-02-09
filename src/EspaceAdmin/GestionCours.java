package EspaceAdmin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.Statement;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GestionCours {
	
	// Disposer de la liste des cours dont la date de leur fin de validité n'est pas encore arrivée.
	
	public void show() {
		this.frame.setVisible(true);
		
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //CHARGER LE PILOTE
		    	Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC","test","Test");// CONNEXION 				
                Statement Stmt =  (Statement) ((java.sql.Connection) conn).createStatement();  // CREER OBJET STATMENT
                ResultSet resultet = Stmt.executeQuery("SELECT * FROM cours Where DATEDIFF(Date_fin,SYSDATE())>0"); // INTERROGER BdD
                while(resultet.next())
                {
                	model1.addRow(new Object[] {resultet.getString(1),resultet.getString(2),resultet.getString(3),resultet.getString(4),resultet.getString(5)});
                }
                
                conn.close();
	    	               
	    	      
		}
		catch(Exception exce) {
	    	      JOptionPane.showMessageDialog(null,exce.getMessage(),"DEMANDE",JOptionPane.INFORMATION_MESSAGE);
	}		
	}
	
    
	private JFrame frame;
	private JTable table;

	//Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionCours window = new GestionCours();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	   //Create the application.
	
	public GestionCours() {
		initialize();
	}

	   //Initialize the contents of the frame.
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(6, 6, 690, 95);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		// BOUTON DECONNEXION --> UserType
		
		JButton deconnexion = new JButton("Logout");
		deconnexion.setBackground(new Color(220, 220, 220));
		deconnexion.setIcon(new ImageIcon("/Users/macamara/Downloads/logout.png"));
		deconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserType logout = new UserType();
				logout.show();
				frame.dispose();
			}
		});
		deconnexion.setBounds(579, 35, 88, 29);
		panel.add(deconnexion);
		
		// BOUTON ACCEUIL --> AcceuilManager
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.setBackground(new Color(220, 220, 220));
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccueilManager fw = new AccueilManager();
				fw.show();
				frame.dispose();
			}
		});
		btnAcceuil.setIcon(new ImageIcon("/Users/macamara/Downloads/home.png"));
		btnAcceuil.setBounds(460, 35, 97, 29);
		panel.add(btnAcceuil);
		
		// LABEL LOGO ENSA
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(220, 220, 220));
		lblLogo.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		lblLogo.setBounds(6, 6, 301, 83);
		panel.add(lblLogo);
		
		// LABEL MANAGER
		
		JLabel lblManager = new JLabel("Manager");
		lblManager.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		lblManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblManager.setBounds(365, 35, 97, 29);
		panel.add(lblManager);
		
		// BOUTON AJOUTER COURS --> DescriptionCours
		
		JButton btnAjouter = new JButton("Ajouter Cours");
		btnAjouter.setIcon(new ImageIcon("/Users/macamara/Downloads/add.png"));
		btnAjouter.setBounds(285, 393, 117, 29);
		frame.getContentPane().add(btnAjouter);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionCours d = new DescriptionCours();
				d.show();
				frame.dispose();
			}
		});
		
		
		
		// TABLEAU DES INFORMATIONS DES COURS ENCORE DISPONIBLES POUR LES CERTIFICATIONS
		
		
        JPanel panel_1 = new JPanel();
		panel_1.setBounds(29, 125, 599, 232);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 587, 220);
		panel_1.add(scrollPane);
		

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(192, 192, 192));
		table.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Nom", "Entreprise", "Date de d\u00E9but", "Date de Fin", "Link"
			}
		) {

			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(102);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		
	}
}

