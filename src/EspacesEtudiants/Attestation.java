package EspacesEtudiants;



import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//Class Attestation : fct : demander attestation.

public class Attestation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Snom;
	private JTextField Sprenom;
	private JTextField Sapoge;
	private JTextField Semail;
	public static String AttestationChoisi,AnneeDocument;
	private JTextField Attestation;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attestation frame = new Attestation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Attestation() {
		
		//récuppérer d'après login & AcceuiEtd
		AttestationChoisi = MenuEtudiant.AttestationChoisi;
		
		//Debut entete
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 702, 450);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBounds(6, 6, 690, 74);
				panel.setBackground(new Color(220, 220, 220));
				contentPane.add(panel);
				
				
				JLabel logout = new JLabel("Logout");
				logout.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/logout.png"));
				logout.setBounds(589, 32, 91, 31);
				logout.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						LoginEtudiant pageAcceuil = new LoginEtudiant();
						pageAcceuil.setVisible(true);
						dispose();
					}
				});
				panel.setLayout(null);
				logout.setFont(new Font("Times New Roman", Font.BOLD, 12));
				panel.add(logout);
				
				JLabel home = new JLabel("Acceuil");
				home.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/home.png"));
				home.setBounds(488, 32, 91, 31);
				home.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						MenuEtudiant pageAcceuil = new MenuEtudiant();
						pageAcceuil.setVisible(true);
						dispose();
					}
				});
				home.setFont(new Font("Times New Roman", Font.BOLD, 12));
				panel.add(home);
				
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/unnamed.png"));
				//lblNewLabel_3.setIcon(new ImageIcon("D:\\ProjetUML\\Etudiant\\src\\img\\unnamed.png"));
				lblNewLabel_3.setBounds(436, 40, 27, 14);
				panel.add(lblNewLabel_3);
				
				JLabel student = new JLabel("Etudiant");
				student.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/user.png"));
				student.setFont(new Font("Times New Roman", Font.BOLD, 12));
				student.setBounds(365, 32, 91, 31);
				panel.add(student);
				
				JLabel lblNewLabel_4 = new JLabel("");
				//lblNewLabel_3.setIcon(new ImageIcon("D:\\ProjetUML\\Etudiant\\src\\img\\unnamed.png"));
				lblNewLabel_3.setBounds(10, 0, 277, 74);
				panel.add(lblNewLabel_3);
				
				JLabel iconStudent = new JLabel("");
				//iconStudent.setIcon(new ImageIcon(MenuEtudiant.class.getResource("/images/user.png")));
				iconStudent.setBounds(340, 29, 49, 34);
				panel.add(iconStudent);
				
				JLabel iconHome = new JLabel("");
				//iconHome.setIcon(new ImageIcon(MenuEtudiant.class.getResource("/images/home.png")));
				iconHome.setBounds(466, 32, 49, 23);
				panel.add(iconHome);
				
				JLabel icon_logOut = new JLabel("");
				//icon_logOut.setIcon(new ImageIcon(MenuEtudiant.class.getResource("/images/logout.png")));
				icon_logOut.setBounds(571, 32, 49, 23);
				panel.add(icon_logOut);
				//fin entete
		
		
		//Fin Partie Attestation
		Sprenom = new JTextField();
		Sprenom.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Sprenom.setColumns(10);
		Sprenom.setBounds(440, 159, 205, 32);
		Sprenom.setText(LoginEtudiant.prenom);
		Sprenom.setBackground(new Color(0, 51, 102));
		Sprenom.setForeground(new Color(255, 255, 255));
		contentPane.add(Sprenom);
		
		Semail = new JTextField();
		Semail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Semail.setColumns(10);
		Semail.setText(LoginEtudiant.Email);
		Semail.setBounds(440, 217, 205, 32);
		Semail.setBackground(new Color(0, 51, 102));
		Semail.setForeground(new Color(255, 255, 255));
		contentPane.add(Semail);
		
		JPanel panel_form = new JPanel();
		panel_form.setBackground(new Color(220, 220, 220));
		panel_form.setBounds(23, 111, 643, 291);
		contentPane.add(panel_form);
		panel_form.setLayout(null);
		
		
		
		JLabel lblNewLabel_3_2 = new JLabel("Email");
		lblNewLabel_3_2.setBounds(352, 104, 120, 32);
		panel_form.add(lblNewLabel_3_2);
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_3_5 = new JLabel("Pr\u00E9nom");
		lblNewLabel_3_5.setBounds(352, 46, 120, 32);
		panel_form.add(lblNewLabel_3_5);
		lblNewLabel_3_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_3_4 = new JLabel("Nom");
		lblNewLabel_3_4.setBounds(21, 46, 120, 32);
		panel_form.add(lblNewLabel_3_4);
		lblNewLabel_3_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_3_3 = new JLabel("Appog\u00E9e");
		lblNewLabel_3_3.setBounds(21, 104, 120, 32);
		panel_form.add(lblNewLabel_3_3);
		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//retourner date du systeme
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Attestation = new JTextField();
		Attestation.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Attestation.setColumns(10);
		Attestation.setBounds(256, 160, 205, 32);
		Attestation.setBackground(new Color(0, 51, 102));
		Attestation.setForeground(new Color(255, 255, 255));

		panel_form.add(Attestation);
		Attestation.setText(AttestationChoisi);
		Attestation.setEditable(false);

		JLabel titre_demande = new JLabel();
		titre_demande.setForeground(new Color(0, 51, 102));
		titre_demande.setBounds(40, 11, 354, 24);
		panel_form.add(titre_demande);
		titre_demande.setFont(new Font("Times New Roman", Font.BOLD, 16));
		titre_demande.setText("Demande "+AttestationChoisi+" :");
		
		JLabel type_demande = new JLabel("Document");
		type_demande.setFont(new Font("Times New Roman", Font.BOLD, 14));
		type_demande.setBounds(148, 158, 120, 32);
		panel_form.add(type_demande);
		JComboBox Annee = new JComboBox();
		Annee.setBounds(303, 193, 104, 39);
		panel_form.add(Annee);
		
		Annee.setModel(new DefaultComboBoxModel(new String[] {"Année", "2022-2021", "2021-2020", "2020-2019", "2019-2018", "2018-2017", "2017-2016", "2016-2015"}));
		Annee.setFont(new Font("Times New Roman", Font.BOLD, 11));
		Annee.setBackground(new Color(0, 51, 102));
		Annee.setForeground(Color.BLACK);
		Annee.setToolTipText("");
		AnneeDocument = Annee.getSelectedItem().toString();

				JButton btnValiderAttestation = new JButton("Valider");
				btnValiderAttestation.setBounds(313, 236, 92, 32);
				panel_form.add(btnValiderAttestation);
				
				btnValiderAttestation.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						String email = Semail.getText().toString();
						
						if (email.equals("")) {
							JOptionPane.showMessageDialog(null, "le nom est nécessaire !");

						}	
						else if(Annee.getSelectedItem().toString().equals("Année")) {
								JOptionPane.showMessageDialog(null, "Sélectionner l'année");
								}
						else {
							AnneeDocument = Annee.getSelectedItem().toString();
							int n =JOptionPane.showConfirmDialog(null, "Valider votre demande et retourner vers la page d'acceuil ?","Demande "+AttestationChoisi+" :",JOptionPane.YES_NO_OPTION);
							if (n == JOptionPane.YES_OPTION) {
								try {
									Class.forName("com.mysql.cj.jdbc.Driver");
							        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
							        String s = "INSERT INTO Demande(Apogee, nom, prénom, Email, TypeDemande,année_document, DateDemande,Traitement) VALUES (?,?,?,?,?,?,?,?)";
							        
							        PreparedStatement pstmt = conn.prepareStatement(s);
							        pstmt.setString(1, LoginEtudiant.Apogee);
							        pstmt.setString(2, LoginEtudiant.nom);
							        pstmt.setString(3, LoginEtudiant.prenom);
							        pstmt.setString(4, email);
							        pstmt.setString(5, AttestationChoisi);
							        pstmt.setString(6, AnneeDocument);
							        pstmt.setString(7, format.format(date));
							        pstmt.setString(8, "Non traitée");
							        pstmt.executeUpdate();
							     
								}catch(Exception ex){
									ex.printStackTrace();
								}
								//envoyer etudiant vers page Acceuil
								JOptionPane.showMessageDialog(null, "Votre demande est enregistrée avec succées!");

								MenuEtudiant page1 = new MenuEtudiant();
								page1.setVisible(true);
								dispose();
							} else if (n == JOptionPane.NO_OPTION) {
								MenuEtudiant page1 = new MenuEtudiant();
								page1.setVisible(true);
								dispose();
							}else if (n == JOptionPane.CLOSED_OPTION) {
								
							}
						}
					}
					
				});
				
					btnValiderAttestation.setFont(new Font("Times New Roman", Font.BOLD, 15));
					
					Sapoge = new JTextField();
					Sapoge.setFont(new Font("Times New Roman", Font.PLAIN, 12));
					Sapoge.setBounds(98, 106, 205, 32);
					panel_form.add(Sapoge);
					Sapoge.setColumns(10);
					Sapoge.setText(LoginEtudiant.Apogee);
					Sapoge.setBackground(new Color(0, 51, 102));
					Sapoge.setForeground(new Color(255, 255, 255));
					Sapoge.setEditable(false);

					
					Snom = new JTextField();
					Snom.setFont(new Font("Times New Roman", Font.PLAIN, 12));
					Snom.setBounds(98, 48, 205, 32);
					Snom.setBackground(new Color(0, 51, 102));
					Snom.setText(LoginEtudiant.nom);
					Snom.setForeground(new Color(255, 255, 255));
					Snom.setEditable(false);

					panel_form.add(Snom);
					Snom.setColumns(10);
					Annee.setVisible(true);
		
					JTextPane txtpnCetteApplicationVous = new JTextPane();
					txtpnCetteApplicationVous.setBackground(new Color(220, 220, 220));
					txtpnCetteApplicationVous.setBounds(24, 241, 246, 39);
					panel_form.add(txtpnCetteApplicationVous);
					txtpnCetteApplicationVous.setFont(new Font("Times New Roman", Font.PLAIN, 12));
					txtpnCetteApplicationVous.setText("Renseignez un \u00E9mail valide pour le suivi de votre demande.");
					
					JTextPane txtpnCetteApplicationVous_1 = new JTextPane();
					txtpnCetteApplicationVous_1.setForeground(Color.RED);
					txtpnCetteApplicationVous_1.setText("*");
					txtpnCetteApplicationVous_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
					txtpnCetteApplicationVous_1.setBackground(new Color(220, 220, 220));
					txtpnCetteApplicationVous_1.setBounds(10, 241, 274, 39);
					panel_form.add(txtpnCetteApplicationVous_1);


		
	}
}
