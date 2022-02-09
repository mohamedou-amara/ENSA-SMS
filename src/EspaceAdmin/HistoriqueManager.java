package EspaceAdmin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoriqueManager {
	
	// Consulter l'historique des cours qui sont achevés avec possibilité de trier et rechercher 

	private JFrame frame;
	private JTable table;
	private JPanel panel;
	private JButton deconnexion;
	private JButton btnAcceuil;
	private JLabel lblLogo;
	private JLabel lblManager;
	private JTextField textField;
	DefaultTableModel model1;
	
	public void show() {
		this.frame.setVisible(true);
		
		try {
			 model1 =  (DefaultTableModel) table.getModel();
			Class.forName("com.mysql.cj.jdbc.Driver");  //CHARGER LE PILOTE
		    	Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC","test","Test");	 // CONNEXION 					
                Statement Stmt =  (Statement) ((java.sql.Connection) conn).createStatement();  // CREER OBJET STATMENT
                ResultSet resultet = Stmt.executeQuery("SELECT * FROM cours Where DATEDIFF(Date_fin,SYSDATE())<0"); // INTERROGER BdD
                while(resultet.next()) // aCCEDER à la première ligne, utiliser la boucle while pour passer à la ligne suivante
                {
                	
                	model1.addRow(new Object[] {resultet.getString(1),resultet.getString(2),resultet.getString(3),resultet.getString(4),resultet.getString(5)});
                }
                
                conn.close(); // Fermer Connexion
	    	               
	    	      
		}catch(Exception exce) {
	    	      JOptionPane.showMessageDialog(null,exce.getMessage(),"DEMANDE",JOptionPane.INFORMATION_MESSAGE);
	}		
	}
	

	// Launch the application.
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoriqueManager window = new HistoriqueManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.
	
	
	public HistoriqueManager() {
		initialize();
	}

	// Initialize the contents of the frame.
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(41, 159, 599, 232);
		frame.getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 587, 220);
		panel_1.add(scrollPane);
		
		
		// TABLEAU CONTENANT LES INFORMATIONS DES COURS DEJA ACHEVES
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
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(6, 6, 690, 95);
		frame.getContentPane().add(panel);
		
		
		// BOUTON DECONNEXION --> UserType
		
		deconnexion = new JButton("Logout");
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
		
		
		// BOUTON ACCEUIL --> AcceuilManager
		
		
		btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccueilManager ac = new AccueilManager();
				ac.show();
				frame.dispose();
			}
		});
		btnAcceuil.setIcon(new ImageIcon("/Users/macamara/Downloads/home.png"));
		btnAcceuil.setBackground(new Color(220, 220, 220));
		btnAcceuil.setBounds(460, 35, 97, 29);
		panel.add(btnAcceuil);
		
		
		// LABEL LOGO ENSA
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		lblLogo.setBackground(new Color(220, 220, 220));
		lblLogo.setBounds(6, 6, 301, 83);
		panel.add(lblLogo);
		
		
		// LABEL ICONE MANAGER
		
		lblManager = new JLabel("Manager");
		lblManager.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		lblManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblManager.setBounds(365, 35, 97, 29);
		panel.add(lblManager);
		
		
		// CHAMPS DE TEXTE POUR INSERER UNE CHAINE DE CARACTERE QU'ON CHERCHE
		
		textField = new JTextField();
		textField.setBounds(109, 113, 194, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				
			}

			public void keyPressed(KeyEvent e) {
				
			}

			public void keyReleased(KeyEvent e) {
				
				Search(textField.getText());
				
			}
        }
    );

		
		
		// LABEL ICONE CHERHCHER
		
		
		JLabel lblNewLabel = new JLabel("Chercher");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/Downloads/magnifying-glass.png"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel.setBounds(16, 122, 81, 16);
		frame.getContentPane().add(lblNewLabel);
			
	}
	
	
	/* ********* Methode chercher qui prend comme parametre un string qui va être affecté à la methode regexFilter() pour effectuer le tri en affichant 
	 
	 que les lignes qui contiennent cette chaine de carac.*************** */
	
	
	public void Search(String str) 
	{
		model1 = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter <>(model1);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str)); 
	}
}
