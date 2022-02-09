package EspaceAdmin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.SwingConstants;


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class DescriptionCours {
	
	// Ajouter un cours dans l'espace de GestionCours

	public void show() {
		this.frame.setVisible(true);
	}

	private JFrame frame;
	private JTextField txtDateDeFin;
	private JTextField txtDateDeDbut;
	private JTextField txtLienDuCours;
	private JTextField txtNomCertificat;
	private JTextField txtEntreprise;

	// Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DescriptionCours window = new DescriptionCours();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the application.
	
	public DescriptionCours() {
		initialize();
	}

	//Initialize the contents of the frame.
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(6, 6, 691, 94);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		// BOUTON ACCEUIL --> AcceuilManager
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccueilManager acc1 = new AccueilManager();
				acc1.show();
				frame.dispose();
				
			}
		});
		btnAcceuil.setIcon(new ImageIcon("/Users/macamara/Downloads/home.png"));
		btnAcceuil.setBounds(443, 36, 117, 29);
		panel_1.add(btnAcceuil);
		
		
		// BOUTON DECONNEXION --> UserType
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserType logout = new UserType();
				logout.show();
			}
		});
		btnLogout.setIcon(new ImageIcon("/Users/macamara/Downloads/logout.png"));
		btnLogout.setBounds(568, 36, 117, 29);
		panel_1.add(btnLogout);
		
		
		// LABEL LOGO ENSA 
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		lblLogo.setBounds(6, 6, 275, 82);
		panel_1.add(lblLogo);
		
		
		// LABEL ICONE MANAGER
		
		JLabel lblNewLabel = new JLabel("Manager");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		lblNewLabel.setBounds(348, 36, 83, 29);
		panel_1.add(lblNewLabel);
		
		
		// LABEL REMPLIR LES INFORMATIONS DES COURS
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220, 220, 220));
		panel_2.setBounds(112, 161, 474, 239);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		// CHAMPS DE TEXTE POUR INSERER DATE DE FIN COURS
		
		txtDateDeFin = new JTextField();
		txtDateDeFin.setBounds(174, 162, 130, 26);
		panel_2.add(txtDateDeFin);
		txtDateDeFin.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateDeFin.setText("Date de fin");
		txtDateDeFin.setColumns(10);
		txtDateDeFin.addFocusListener((FocusListener) new FocusListener(){
		        
				public void focusGained(FocusEvent e) {
					txtDateDeFin.setText("");
				}

				
				public void focusLost(FocusEvent e) {
				}
		    });
		
		
		// CHAMPS DE TEXTE POUR INSERER DATE DE DEBUT COURS
		
		txtDateDeDbut = new JTextField();
		txtDateDeDbut.setBounds(174, 125, 130, 26);
		panel_2.add(txtDateDeDbut);
		txtDateDeDbut.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateDeDbut.setText("Date de début");
		txtDateDeDbut.setColumns(10);
		txtDateDeDbut.addFocusListener((FocusListener) new FocusListener(){
	        
			public void focusGained(FocusEvent e) {
				txtDateDeDbut.setText("");
			}

			public void focusLost(FocusEvent e) {
				
			}
	    });
		
		
		// CHAMPS DE TEXTE POUR INSERER LE LIEN DU COURS

		txtLienDuCours = new JTextField();
		txtLienDuCours.setBounds(174, 88, 130, 26);
		panel_2.add(txtLienDuCours);
		txtLienDuCours.setHorizontalAlignment(SwingConstants.CENTER);
		txtLienDuCours.setText("Lien du cours");
		txtLienDuCours.setColumns(10);
		txtLienDuCours.addFocusListener((FocusListener) new FocusListener(){
	        
			public void focusGained(FocusEvent e) {
				txtLienDuCours.setText("");
			}

			public void focusLost(FocusEvent e) {
				
			}
	    });
		
		
		// CHAMPS DE TEXTE POUR INSERER NOM DE CERTIFICATION/COURS

		txtNomCertificat = new JTextField();
		txtNomCertificat.setBounds(174, 14, 130, 26);
		panel_2.add(txtNomCertificat);
		txtNomCertificat.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomCertificat.setText("Certificat");
		txtNomCertificat.setColumns(10);
		txtNomCertificat.addFocusListener((FocusListener) new FocusListener(){
	        
			public void focusGained(FocusEvent e) {
				txtNomCertificat.setText("");
			}

			public void focusLost(FocusEvent e) {
				
			}
	    });
		
		
		// CHAMPS DE TEXTE POUR INSERER LE NOM DE L'ENTREPRISE EN CHARGE DE FOURNISSAGE DES CERTIFICATS

		txtEntreprise = new JTextField();
		txtEntreprise.setText("Entreprise");
		txtEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
		txtEntreprise.setColumns(10);
		txtEntreprise.setBounds(174, 51, 130, 26);
		panel_2.add(txtEntreprise);
		txtEntreprise.addFocusListener((FocusListener) new FocusListener(){
	        
			public void focusGained(FocusEvent e) {
				txtEntreprise.setText("");
			}

			public void focusLost(FocusEvent e) {				
			}
	    });
		
		
		
		// BOUTON VALIDER LES INFORMATIONS

		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionCours gr = new GestionCours();
				String typeCertificat = txtEntreprise.getText();
				String nomCours = txtNomCertificat.getText();
				String lienCours = txtLienDuCours.getText();
				String dateFin = txtDateDeFin.getText();
				String dateDebut = txtDateDeDbut.getText();
				try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");  // CONNEXION 	
			        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC","test","Test");  // CONNEXION
			        String m = "insert into cours(Nom,Entreprise,Date_debut,Date_fin,Lien) VALUES (?,?,?,?,?)";  // REQUETE SQL
			    	             PreparedStatement pstmt = conn.prepareStatement(m);  // PreparedStatement
			    	             
			    	             pstmt.setString(1, nomCours);
			    	             pstmt.setString(2, typeCertificat);
			    	             pstmt.setDate(3, java.sql.Date.valueOf(dateDebut));
			    	             pstmt.setDate(4, java.sql.Date.valueOf(dateFin));
			    	             pstmt.setString(5, lienCours);
			    	             pstmt.executeUpdate();  // INSERER LES DONNEES DANS LA TABLE cours
			    	             gr.show();

				}
				catch (Exception ex){
	            
	            System.out.println(ex.getMessage());
	            
	        }
	}
			
 } );
		btnValider.setBounds(193, 199, 87, 29);
		panel_2.add(btnValider);
}
}