package EspaceAdmin;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;



public class ConsultationListeInscription {
	
	// Connsulter la liste des étudiants inscrits dans une certification et la télécharger
	
	public void show() {
		this.frame.setVisible(true);
		
		try {
			
		       System.out.println(Track);   
			   String nom,prenom,tel,email,type_certificat;
	    	   Class.forName("com.mysql.cj.jdbc.Driver"); //CHARGER LE PILOTE
	    	    Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC","test","Test"); // CONNEXION
	    	    Statement stmt = conn.createStatement(); // CREER OBJET STATMENT
	    	    DefaultTableModel model = (DefaultTableModel) tableConsultation.getModel();
	    	    ResultSet rs = stmt.executeQuery("SELECT * FROM demandecertificat where type_certificat = '"+Track+"'"); // INTERROGER BdD
	            while(rs.next()) {
	            	nom = rs.getString(2);
	            	prenom = rs.getString(3);
	            	tel = rs.getString(4);
	            	email = rs.getString(5);
	            	type_certificat = rs.getString(6);
	            	model.addRow(new Object[] {nom,prenom,tel,email,type_certificat});
	            	
	            }
	            conn.close(); //Fermer la connexion à la base de donnée.
	      }
		
		catch(Exception e) {
	    	  System.out.println(e.getMessage());
	      }
	}
	
	
	private JFrame frame;
	private JTable tableConsultation;
	public static String Track ;

	//Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultationListeInscription window = new ConsultationListeInscription();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the application.
	
	public ConsultationListeInscription() {
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
		
		// BOUTON DECONNEXION 
		
		JButton deconnexion = new JButton("Logout");
		deconnexion.setIcon(new ImageIcon("/Users/macamara/Downloads/logout.png"));
		deconnexion.setBounds(598, 35, 88, 29);
		panel.add(deconnexion);
		deconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserType logout = new UserType();
				logout.show();
			}
		});
		
		// BOUTON ACCEUIL
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.setIcon(new ImageIcon("/Users/macamara/Downloads/home.png"));
		btnAcceuil.setBounds(489, 35, 97, 29);
		panel.add(btnAcceuil);
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccueilManager acc1 = new AccueilManager();
				acc1.show();
				frame.dispose();
				
			}
		});

		
		// LABEL LOGO ENSA 
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		lblLogo.setBounds(6, 6, 301, 83);
		panel.add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("Manager");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		lblNewLabel.setBounds(395, 36, 82, 24);
		panel.add(lblNewLabel);
		
		
		// TABLEAU DE CONSULTATION DES ETUDIANTS INSCRITS DANS UNE CERTIFICATION
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 171, 619, 175);
		frame.getContentPane().add(scrollPane);
		
		
		tableConsultation = new JTable();
		tableConsultation.setForeground(new Color(0, 0, 0));
		tableConsultation.setBackground(new Color(192, 192, 192));
		tableConsultation.setFont(new Font("Times New Roman", Font.BOLD, 11));
		tableConsultation.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom", "Prenom", "Téléphone","Email", "Certificat"
			}
		));
		tableConsultation.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableConsultation.getColumnModel().getColumn(3).setPreferredWidth(76);
		scrollPane.setViewportView(tableConsultation);
		

		
		 // BOUTON DE TELECHARGEMENT D'UNE LISTE
		
		JButton btnEnvoyerListe = new JButton("Telecharger");
		btnEnvoyerListe.setToolTipText("");
		btnEnvoyerListe.setIcon(new ImageIcon("/Users/macamara/Downloads/download-arrow.png"));
		btnEnvoyerListe.setBounds(281, 367, 117, 29);
		frame.getContentPane().add(btnEnvoyerListe);
		btnEnvoyerListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document doc = new Document();
				
				try {
					PdfWriter.getInstance(doc,new FileOutputStream("/Users/macamara/Downloads/Liste.pdf"));
					doc.open(); // Ouvrir document en mode écriture
					PdfPTable pdfTable = new PdfPTable(tableConsultation.getColumnCount()); // Creer une table pour l'inserer au document
	                //adding table headers
	                for (int i = 0; i < tableConsultation.getColumnCount(); i++) {
	                    pdfTable.addCell(tableConsultation.getColumnName(i));
	                }
	                //extracting data from the JTable and inserting it to PdfPTable
	                for (int rows = 0; rows <= tableConsultation.getRowCount() - 1; rows++) {
	                    for (int cols = 0; cols < tableConsultation.getColumnCount(); cols++) {
	                        pdfTable.addCell(tableConsultation.getModel().getValueAt(rows, cols).toString());

	                    }
	                }
	                doc.add(pdfTable); // Ajouter le tableau dans le document
	                doc.close(); // Fermer le document
	                System.out.println("done");
				} 
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
				catch (DocumentException e1) {
					e1.printStackTrace();
				}
              
                 
				
			}
		});

		


	}
}