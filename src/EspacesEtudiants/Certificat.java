package EspacesEtudiants;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuEvent;
//Class certificat : fct : inscrire etudiant à certificat
public class Certificat extends JFrame {

	private JPanel contentPane;
	private JTextField Snom;
	private JTextField Sprenom;
	private JTextField Stel;
	private JTextField Semail;
	public static String certifChoisi,AttestationChoisi,Nom,Prenom,Email;
	private JTextField certificat;
	private JLabel Form_Inscription;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Certificat frame = new Certificat();
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
	public Certificat() {
		//récuppérer d'après l'acceuil etd
		certifChoisi = MenuEtudiant.certifChoisi;
		AttestationChoisi = MenuEtudiant.AttestationChoisi;
		Nom =LoginEtudiant.nom;
		Prenom = LoginEtudiant.prenom;
		Email= LoginEtudiant.Email;
		
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
				//icon_logOut.setBounds(571, 32, 49, 23);
				panel.add(icon_logOut);
				//fin entete
				
		
		
		JPanel panel_form = new JPanel();
		panel_form.setBackground(new Color(220, 220, 220));
		panel_form.setBounds(23, 111, 643, 291);
		contentPane.add(panel_form);
		panel_form.setLayout(null);
		JButton btnSubmit = new JButton("VALIDER");
		
				
				btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 13));
				btnSubmit.setBounds(421, 237, 95, 32);
				panel_form.add(btnSubmit);
				btnSubmit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String tel = Stel.getText().toString();
						String email = Semail.getText().toString();
						
						if (tel.equals("")) {
							JOptionPane.showMessageDialog(null, "Veuillez renseigner votre téléphone !");
						}
						else if (email.equals("")) {
							JOptionPane.showMessageDialog(null, "Veuillez renseigner votre addresse mail !");
						}
						else {
							int n =JOptionPane.showConfirmDialog(null, "Valider votre inscription à "+certifChoisi+" et retourner vers la page d'acceuil ?","Envoie Inscription",JOptionPane.YES_NO_OPTION);
							if (n == JOptionPane.YES_OPTION) {
								try {
									Class.forName("com.mysql.cj.jdbc.Driver");
							        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
							        System.out.println("fatiiii rah tconectitiiiiiii");
							        String s = "INSERT INTO demandecertificat(Apogee, Nom, Prenom, telephone, email, type_certificat) VALUES (?,?,?,?,?,?)";
							        PreparedStatement pstmt = conn.prepareStatement(s);
							        pstmt.setString(1, LoginEtudiant.Apogee);
							        pstmt.setString(2, Nom);
							        pstmt.setString(3, Prenom);
							        pstmt.setString(4, tel);
							        pstmt.setString(5, Email);
							        pstmt.setString(6, certifChoisi);
							        pstmt.executeUpdate();
							     
								}catch(Exception ex){
									ex.printStackTrace();
								}
								//envoyer etudiant vers page Acceuil
								JOptionPane.showMessageDialog(null, "Votre inscription est enregistrée avec succées!");
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
				
				
				
				JLabel label_nom = new JLabel("Nom");
				label_nom.setBounds(228, 24, 120, 32);
				panel_form.add(label_nom);
				label_nom.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
				JLabel label_prenom = new JLabel("Pr\u00E9nom");
				label_prenom.setBounds(228, 67, 120, 32);
				panel_form.add(label_prenom);
				label_prenom.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
				JLabel label_tel = new JLabel("T\u00E9l\u00E9phone");
				label_tel.setBounds(228, 110, 120, 32);
				panel_form.add(label_tel);
				label_tel.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
				JLabel label_email = new JLabel("Email");
				label_email.setBounds(228, 150, 120, 32);
				panel_form.add(label_email);
				label_email.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
				JLabel label_certif = new JLabel("Certificat");
				label_certif.setBounds(228, 190, 120, 32);
				panel_form.add(label_certif);
				label_certif.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
				
				Semail = new JTextField();
				Semail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				Semail.setBounds(342, 152, 250, 32);
				panel_form.add(Semail);
				Semail.setColumns(10);
				Semail.setText(Email);
				Semail.setForeground(new Color(255, 255, 255));
				Semail.setBackground(new Color(0, 51, 102));

				
				Stel = new JTextField();
				Stel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				Stel.setBounds(342, 110, 250, 32);
				panel_form.add(Stel);
				Stel.setColumns(10);
				Stel.setForeground(new Color(255, 255, 255));
				Stel.setBackground(new Color(0, 51, 102));

				
				Sprenom = new JTextField();
				Sprenom.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				Sprenom.setBounds(341, 67, 250, 32);
				panel_form.add(Sprenom);
				Sprenom.setColumns(10);
				Sprenom.setText(Prenom);
				Sprenom.setEditable(false);
				Sprenom.setForeground(new Color(255, 255, 255));
				Sprenom.setBackground(new Color(0, 51, 102));

				
				Snom = new JTextField();
				Snom.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				Snom.setBounds(342, 26, 250, 32);
				panel_form.add(Snom);
				Snom.setColumns(10);
				Snom.setText(Nom);
				Snom.setEditable(false);
				Snom.setForeground(new Color(255, 255, 255));
				Snom.setBackground(new Color(0, 51, 102));
				
				certificat = new JTextField();
				certificat.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				certificat.setBounds(342, 193, 251, 33);
				certificat.setColumns(10);
				certificat.setForeground(new Color(255, 255, 255));
				certificat.setBackground(new Color(0, 51, 102));

				
				panel_form.add(certificat);
				certificat.setText(certifChoisi);
				certificat.setEditable(false);
				
				Form_Inscription = new JLabel("Formulaire d'inscription:");
				Form_Inscription.setBounds(20, 0, 226, 52);
				panel_form.add(Form_Inscription);
				Form_Inscription.setFont(new Font("Times New Roman", Font.BOLD, 16));
				Form_Inscription.setForeground(new Color(0, 51, 102));
				
				JTextPane txtpnCetteApplicationVous = new JTextPane();
				txtpnCetteApplicationVous.setBackground(new Color(220, 220, 220));
				txtpnCetteApplicationVous.setBounds(24, 241, 246, 39);
				panel_form.add(txtpnCetteApplicationVous);
				txtpnCetteApplicationVous.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				txtpnCetteApplicationVous.setText("Renseignez un num\u00E9ro de t\u00E9l\u00E9phone/\u00E9mail valide\r\n pour le suivi de votre inscription.");
				
				JTextPane txtpnCetteApplicationVous_1 = new JTextPane();
				txtpnCetteApplicationVous_1.setForeground(Color.RED);
				txtpnCetteApplicationVous_1.setText("*");
				txtpnCetteApplicationVous_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				txtpnCetteApplicationVous_1.setBackground(new Color(220, 220, 220));
				txtpnCetteApplicationVous_1.setBounds(10, 241, 274, 39);
				panel_form.add(txtpnCetteApplicationVous_1);
	}
}

