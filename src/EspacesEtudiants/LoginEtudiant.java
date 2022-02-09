package EspacesEtudiants;



import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginEtudiant extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//variables de la classe
	
	public static String Email,Apogee,nom,prenom,cin;
	public JTextField Sapoge,Semail,CIN,textField;
	private JPanel InterfaceLogin;
	private JPanel Formulaire;
	private JLabel logo_application,logo_ensa,fotoBg,bienvenue;
	private JTextPane description_app;
	private JButton btnValider;
	private MenuEtudiant pageAcceuil;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEtudiant frame = new LoginEtudiant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * CONSTRUCTEUR
	 */	
	public LoginEtudiant() {
		/*=============================
		 *Instanciation des Variables
		 ==============================*/
			InterfaceLogin = new JPanel();
			Formulaire= new JPanel();
			logo_application = new JLabel("");
			logo_ensa = new JLabel("");
			fotoBg = new JLabel("");
			bienvenue = new JLabel("Bienvenue,");
			description_app = new JTextPane();
			btnValider = new JButton("Valider");
		
		//Instancier la page Menu à partir de Sa classe MenuEtudiant
			pageAcceuil = new MenuEtudiant();

		

    	/*=================================================
		 *Instanciation des Champs à remplir par l'etudiant
		 ==================================================*/
			Semail= new JTextField();
			Sapoge = new JTextField();
			CIN = new JTextField();
			textField = new JTextField();
		
		
		/*========================
		 * Taille de l'interface
		 =========================*/
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 702, 450);
			InterfaceLogin.setBackground(UIManager.getColor("Button.highlight"));
			InterfaceLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(InterfaceLogin);
			InterfaceLogin.setLayout(null);
		
		/*================================================
		 * Fonction définissant la forme champ Formulaire
		 =================================================*/
			Formulaire.setBackground(new Color(238, 238, 238));
			Formulaire.setBounds(0, 0, 299, 423);
			InterfaceLogin.add(Formulaire);
			Formulaire.setLayout(null);
		
		/*===============================================
		 * les fonctions définissant la forme champ Email
		 ================================================*/
			Semail.setText("Votre Email institutionnel");
			Semail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			Semail.setForeground(new Color(255, 255, 255));
			Semail.setBounds(34, 197, 226, 31);
			Formulaire.add(Semail);
			Semail.setBackground(new Color(0, 51, 102));
			Semail.setColumns(10);
		//Appel fonction pour remplir le champ Semail par sa description
			addPlaceholderStyle(Semail);
		
		/*============================================
		 * les fonctions définissant la forme champ Apogee
		 =============================================*/
			Sapoge.setText("Votre code Appogé");
			Sapoge.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			Sapoge.setForeground(new Color(255, 255, 255));
			Sapoge.setBounds(34, 239, 226, 31);
			Formulaire.add(Sapoge);
			Sapoge.setBackground(new Color(0, 51, 102));
			Sapoge.setColumns(10);
		//Appel fonction pour remplir le champ Sapoge par sa description
			addPlaceholderStyle(Sapoge);
		
		/*=========================================
		 * les fonctions définissant la forme champ CIN
		 ==========================================*/
			CIN.setText("Votre CIN");
			CIN.setForeground(Color.WHITE);
			CIN.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			CIN.setColumns(10);
			CIN.setBackground(new Color(0, 51, 102));
			CIN.setBounds(34, 281, 226, 31);
			Formulaire.add(CIN);

		//Appel fonction pour remplir le champ cin par sa description
			addPlaceholderStyle(CIN);
			textField.setForeground(new Color(238, 238, 238));
			textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			textField.setColumns(10);
			textField.setBackground(new Color(238, 238, 238));
			textField.setBounds(87, 75, -42, 23);
			Formulaire.add(textField);

		/*==============================
		 * Forme Bouton Valider
		 ===============================*/
			btnValider.setBounds(95, 340, 100, 31);
			Formulaire.add(btnValider);
			btnValider.setBackground(new Color(255, 255, 255));
			btnValider.setFont(new Font("Zilla Slab", Font.BOLD, 14));
			
		/*============================
		 * Ajout des images à la page
		 =============================*/
			logo_application.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/__Logo.png"));
			logo_application.setBounds(66, 75, 194, 128);
			Formulaire.add(logo_application);
			
			logo_ensa.setBounds(10, 0, 279, 81);
			Formulaire.add(logo_ensa);
			logo_ensa.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/unnamed.png"));
			
			fotoBg.setBounds(161, 145, 554, 408);
			InterfaceLogin.add(fotoBg);
			fotoBg.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/students.jpg"));
			
		/*==============================
		 * Description de l'application 
		 ===============================*/
			description_app.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			description_app.setBounds(309, 40, 391, 90);
			InterfaceLogin.add(description_app);
			description_app.setText(" Enasaté SMS vous permet de s'inscrire aux certifications et de demander vos différents documents estudiantains, notamment votre :\r\n1)Relevé de notes.\r\n2)Attestation de scolarité.\r\n3)Attestation de réussite.\r\n");
			
			bienvenue.setForeground(new Color(0, 0, 128));
			bienvenue.setFont(new Font("Times New Roman", Font.BOLD, 14));
			bienvenue.setBounds(309, 0, 252, 42);
			InterfaceLogin.add(bienvenue);
		
		
		/*=========================================================================
		 * 	implémentation de l'interface FocusListener
		 * 	polymorphisme: redefinition de la methode FocusGained() & FocusLost() 
		 * 	Méthode utiliser pour vider la description du champ
			quand l'utilisateur entre ses données dans le champ email
		 ========================================================================*/
		/**/
			Semail.addFocusListener(new FocusAdapter() { 
				@Override
				public void focusGained(FocusEvent e) {
					if(Semail.getText().equals("Votre Email institutionnel")) {
						Semail.setText(null);
						Semail.requestFocus();
						removePlaceholderStyle(Semail);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(Semail.getText().length()==0) {
						Semail.setText("Votre Email institutionnel");
					}
				}
			});
		
		/*=========================================================================
		 *	Méthode utiliser pour vider la description du champ (placeHolder)
			quand l'utilisateur entre ses données dans le champ appoge
		 ========================================================================*/
		/**/
			Sapoge.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(Sapoge.getText().equals("Votre code Appogé")) {
						Sapoge.setText(null);
						Sapoge.requestFocus();
						removePlaceholderStyle(Sapoge);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(Sapoge.getText().length()==0) {
						Sapoge.setText("Votre code Appogé");
					}
				}
			});
		
		
		/*=========================================================================
		 *	Méthode utiliser pour vider la description du champ(PlaceHolder)
			quand l'utilisateur entre ses données dans le champ CIN*
		 ========================================================================*/
		/**/
			CIN.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(CIN.getText().equals("Votre CIN")) {
						CIN.setText(null);
						CIN.requestFocus();
						removePlaceholderStyle(CIN);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(CIN.getText().length()==0) {
						CIN.setText("Votre CIN");
					}
				}
			});
		

		/*=================================================
		 *	ActionListener pour verifier login de l'étudiant
		 *	implémentant l'interfaces ActionListener
		 ==================================================*/
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Récupérer les données entrer par l'étudiant dans les variables Email/Apogee/cin
					Email = Semail.getText().toString();
					Apogee = Sapoge.getText().toString();
					cin = CIN.getText().toString();
					
					//Test : si l'étudiant clique valider sans entrer l'un des champs Email-CIN-Apoge
					if (Email.equals("")||Email.equals("Votre Email institutionnel")) {
						//JOptionPane : boite de dialogue portant un message d'erreur à l'utilisateur
						JOptionPane.showMessageDialog(null, "Veuillez entrer votre email !");
					}
					else if (Apogee.equals("")||Apogee.equals("Votre code Appogé")) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer votre Code appogé !");
					}
					else if (cin.equals("")||cin.equals("Votre CIN")) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer CIN !");
					}
					else {
							int cmt = 0;
								//detection d'erreur de connexion a la base de donnée
									   try {
										   //connexion à la base donnée 
									        Class.forName("com.mysql.cj.jdbc.Driver");
									        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
									        //requete SQL pour selectioner les etudiants de la table d'etudiant base donnée
									        String req = "Select * FROM etudiant";
									        PreparedStatement pstmt = conn.prepareStatement(req);
									        ResultSet rs = pstmt.executeQuery();  
									        //parcours de la table etudiant
									        while(rs.next()) {
									        	System.out.println("je parcours la bd ");
									        	if(Apogee.equals(rs.getString(1)) && cin.equals(rs.getString(7)) && Email.equals(rs.getString(9))) {
									        		nom=rs.getString(2);
									        		prenom=rs.getString(3);
									        		cin=rs.getString(7);
									        		cmt ++;	
									        	}
									        }
									        //condition si l'etudiant est trouvé dans la base de données
									        if(cmt == 1) 
									        {
									        	//Renvoyer l'étudiant vers la page Menu Etudiant 
									        	System.out.println("vous etes connecter");
												pageAcceuil.setVisible(true);
												dispose();
									        }
									        //sinon afficher message d'erreur à l'étudiant
									        else
									        	JOptionPane.showMessageDialog(null, "Email, CIN ou Code Appogée est incorrect");
								           }
									        catch (Exception ex){
									            System.out.println(ex.getMessage()); 
									        }
						}
					
					
				}
			});
	}
	
	/*==================================================================
		Opération permettant définir les champs à remplir par l'étudiant
	 ==================================================================*/

		public void addPlaceholderStyle(JTextField txt) {
			Font font = txt.getFont();
			font = font.deriveFont(Font.ITALIC);
			txt.setFont(font);
			txt.setForeground(Color.white);
		}
	
	/*====================================================================
		Opération permettant de vider le texte description par defaut du champ
	 ======================================================================*/
  
		public void removePlaceholderStyle(JTextField txt) {
			Font font = txt.getFont();
			font = font.deriveFont(Font.ITALIC);
			txt.setFont(font);
			txt.setForeground(Color.white);
		}
	
	
}


