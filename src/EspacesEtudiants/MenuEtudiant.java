package EspacesEtudiants;



import java.awt.BorderLayout;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.beans.PropertyChangeEvent;
//class MenuEtudiant : fct: demander Attestation,Demander certificat, consulter Note:
public class MenuEtudiant  extends  JFrame {

	private JPanel contentPane;
	public JTextField selectedCretificat,selectedAttestation;
	public boolean cliquerNote = false ; 
	public boolean cliquerAtst = false ; 
	public static String y_releve ,certifChoisi,AttestationChoisi;

;

	public JFrame frame = new JFrame("Demander Certificats");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEtudiant frame = new MenuEtudiant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//fonction pour remplir les certificats de la bd
	public static void updateCertificat(JComboBox J) {
		String req ="select Nom from cours";
		
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
			        System.out.println("connexion établie");			        
			        PreparedStatement pstmt = conn.prepareStatement(req);
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()) {
			        	J.addItem(rs.getString("Nom"));
			        	System.out.println("done");
			        }

				}catch(Exception ex){
					ex.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public MenuEtudiant() {

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
		
		
		//variable utile
		JButton btnConsulterNotes = new JButton("Consulter Notes");
		JComboBox Attestation = new JComboBox();
		JComboBox certificat = new JComboBox();
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		//lblNewLabel_1.setIcon(new ImageIcon(MenuEtudiant.class.getResource("/images/girl.jpg")));
		
				
		//Partie Attestation
		Attestation.setModel(new DefaultComboBoxModel(new String[] {"Attestation", "Relevé Note", "Attestation R\u00E9ussite", "Attestation Scolarité"}));
		Attestation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Attestation.setBounds(260, 157, 161, 42);
		contentPane.add(Attestation);
		
			//listener sur le comboBox Attestation
		Attestation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttestationChoisi = Attestation.getSelectedItem().toString();		
				if(AttestationChoisi.equals("Attestation")) {
					JOptionPane.showMessageDialog(null, "Sélectiionner un type d'attestation !");
				}
				else {
					Attestation page1 = new Attestation();
					page1.setVisible(true);
					dispose();
				}
				
			}
		});
		//fin partie demande attestation
		
		//liste des certificats disponible
		certificat.setModel(new DefaultComboBoxModel(new String[] {"Certificats"}));
		
		updateCertificat(certificat);
		certificat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		certificat.setBounds(260, 230, 161, 42);
		contentPane.add(certificat);
		
		//listener sur comboBox certificat
		certificat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				certifChoisi = certificat.getSelectedItem().toString();
				if(certifChoisi.equals("Certificats")) {
					JOptionPane.showMessageDialog(null, "Sélectiionner un type de certificats !");
				}
				else {
					Certificat page1 = new Certificat();
					page1.setVisible(true);
					dispose();	
				}
				}
		});
		//fin button partie certifications disponibles

		//Bouton consulter Notes
		btnConsulterNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("http://notes.ensa-tetouan.ac.ma/"));

				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
							}
		});
		btnConsulterNotes.setBounds(260, 304, 161, 42);
		btnConsulterNotes.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(btnConsulterNotes);
		ButtonModel modelNotes = ((AbstractButton)btnConsulterNotes).getModel();
		
		//fin button consulter Notes

		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(23, 111, 643, 291);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/girl.jpg"));
		lblNewLabel.setBounds(196, 0, 474, 316);
		panel_1.add(lblNewLabel);

		

	}
}
