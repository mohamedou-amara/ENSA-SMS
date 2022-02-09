package EspaceAdmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class ListeEtu {

	private JFrame frame;
	private JTable table;
	public static DefaultTableModel model1;
	String codEtu,nom,prenom,numGrp;
	float note;
	String module;
	String idmodule;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextField textField;
	
	
	/**
	 * Create the application.
	 */
	public ListeEtu() {
		initialize();
	}
	/* Constructeur qui initialise le nom du module */
	public ListeEtu(String module) {
		initialize();
		this.module = module;
	}
	
	public void show () {
		   this.frame.setVisible(true);
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGCN","test","Test");
		        Statement stmt = conn.createStatement();
		        ResultSet rs1 = stmt.executeQuery("Select id_module FROM modules Where nom_module = '"+module+"'");
				/*Selectionner l'id du module à partir de la table modules dans la BD */
		        rs1.next();
		        idmodule = rs1.getString(1);
		        
		        ResultSet rs = stmt.executeQuery("Select num_apogee, nom, prenom, note, num_Grp FROM etudiants Where id_Module = '"+rs1.getString(1)+"'");
		        while(rs.next()) {
					/*Afficher les données de la liste des étudiants selectionnées dans Jtable  */
		        	codEtu= rs.getString(1);
		        	nom= rs.getString(2);
		        	prenom = rs.getString(3);
		        	note = rs.getFloat(4);
		        	numGrp = rs.getString(5);
		        	ListeEtu.model1.addRow(new Object[] {codEtu,nom,prenom,note,numGrp});	
		        }
		        }
		        catch (Exception ex){
		            
		            System.out.println(ex.getMessage());
		            
		        }
	}




	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 127, 644, 210);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num Apogée", "Nom", "Prenom", "Note", "N\u00B0 GRP"
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
		scrollPane.setViewportView(table);
		
		
		model1 = (DefaultTableModel) table.getModel();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(10, 11, 666, 85);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setIcon(new ImageIcon("/Users/macamara/Downloads/logout.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserType logout = new UserType(); /*Revenir à la page initiale UserType */
				logout.show();
					frame.dispose();
			}
		});
		btnNewButton.setBounds(554, 31, 91, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Accueil");
		btnNewButton_2.setIcon(new ImageIcon("/Users/macamara/Downloads/home.png"));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_2.setForeground(new Color(51, 102, 153));
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        	AccueilProfesseur f1 = new AccueilProfesseur();
					f1.show(); /*Revenir à la page d'accueil */
					frame.dispose();
			}
		});
		btnNewButton_2.setBounds(447, 31, 97, 23);
		panel.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("Professeur");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel.setBounds(346, 33, 91, 19);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 285, 85);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(10, 107, 666, 293);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 11));
		textField.setForeground(new Color(0, 51, 102));
		textField.setBounds(194, 248, 143, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Ins\u00E9rer");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_4.setBackground(new Color(220, 220, 220));
		btnNewButton_4.setForeground(new Color(0, 51, 102));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0) 
				{
					String a = textField.getText();
					float f = Float.parseFloat(a);
					model1.setValueAt(f,table.getSelectedRow(), 3);
					/*Insérer la note dans la ligne sélectionnée */
				}
				else {
					/*Cas ou je clique insérer sans choisir la ligne à modifier */
					JOptionPane.showMessageDialog(null," Veuillez Sélectioner la ligne à modifier ");
				}
			}
		});
		btnNewButton_4.setBounds(338, 247, 117, 23);
		panel_1.add(btnNewButton_4);

		/*Donner modifier je clique valider pour les enregistrer dans la base de données */
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.setIcon(new ImageIcon("/Users/macamara/Downloads/check-2.png"));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setBackground(new Color(0, 51, 102));
		btnNewButton_1.setForeground(new Color(0,51,102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float f;
				AccueilProfesseur pr = new AccueilProfesseur();
				for(int i=0; i<table.getRowCount(); i++) {
					try {
			        	Class.forName("com.mysql.cj.jdbc.Driver");
				        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGCN","test","Test");
				        Statement stmt = conn.createStatement();
				        Statement stmt1 = conn.createStatement();
				    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				    	LocalDateTime now = LocalDateTime.now();
				        System.out.println(dtf.format(now));
				        /* Insérer les notes saisies en précisant la date de modification et la décision selon la note enregistrée */
				        f = (float) table.getValueAt(i,3);
				        if(f>=12.0)
				        {
							
				        int m = stmt.executeUpdate("UPDATE etudiants SET Decision = 'Validé', note = "+table.getValueAt(i,3)+" WHERE num_apogee = "+table.getValueAt(i,0)); 
				        }
				        else 
				        {
				        int m = stmt.executeUpdate("UPDATE etudiants SET Decision ='Non Validé', note = "+table.getValueAt(i,3)+" WHERE num_apogee = "+table.getValueAt(i,0));	
				        System.out.println(m);
				        }
						/*Aprés modification on insére la date d'enregistrement des notes anisi on précise que les notes sont bien enregistrer 
						pour que le responsable apogée puisse les consulteés*/
				        int n = stmt1.executeUpdate("UPDATE modules SET noteEnregistrer = 'True', dateEnregistrement ='"+ now +"'"+" WHERE id_module = '"+idmodule+"'");
				        System.out.println(n);
                        conn.close();
                        pr.show();
                        frame.dispose();
                        
					}
		            catch (Exception ex){
		            	System.out.println("Catch u 1!!!!");
		            System.out.println(ex.getMessage());   
		        }
			}

					
				
		}
		});
		btnNewButton_1.setBounds(554, 247, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Retour"); /*Revenir à la table des modules */
		btnNewButton_3.setIcon(new ImageIcon("/Users/macamara/Downloads/left.png"));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_3.setForeground(new Color(0, 51, 102));
		btnNewButton_3.setBackground(new Color(0, 51, 102));
		btnNewButton_3.setBounds(10, 247, 89, 23);
		panel_1.add(btnNewButton_3);
				btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccueilProfesseur f = new AccueilProfesseur();
				f.show();
				frame.dispose();
			}
		});
		
		
}
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeEtu window = new ListeEtu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}