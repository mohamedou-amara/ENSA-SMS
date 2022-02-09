package EspaceAdmin;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class AccueilManager {

	private JFrame frame;
	
	
	
	public void show() {
		this.frame.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilManager window = new AccueilManager();
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
	public AccueilManager() {
		initialize();
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(6, 6, 690, 95);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
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
		deconnexion.setBounds(570, 35, 97, 29);
		panel.add(deconnexion);
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcceuil.setBackground(new Color(220, 220, 220));
		btnAcceuil.setIcon(new ImageIcon("/Users/macamara/Downloads/home.png"));
		btnAcceuil.setBounds(463, 35, 97, 29);
		panel.add(btnAcceuil);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		lblNewLabel.setBounds(6, 6, 301, 83);
		panel.add(lblNewLabel);
		
		JLabel LblManager = new JLabel("Manager");
		LblManager.setHorizontalAlignment(SwingConstants.CENTER);
		LblManager.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		LblManager.setBounds(368, 36, 97, 26);
		panel.add(LblManager);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(131, 172, 409, 228);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton gestion = new JButton("Espace Gestion");
		gestion.setForeground(new Color(0, 51, 102));
		gestion.setBackground(new Color(0, 51, 102));
		gestion.setFont(new Font("Times New Roman", Font.BOLD, 11));
		gestion.setBounds(121, 110, 147, 29);
		panel_1.add(gestion);
		gestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultationListeInscription g1 = new ConsultationListeInscription();
				String m = JOptionPane.showInputDialog(frame, "Entrer le type de certificat");
				ConsultationListeInscription.Track = m;
				g1.show();
				frame.dispose();
				
			}
		});
		
		
		JButton cours = new JButton("Espace Cours");
		cours.setFont(new Font("Times New Roman", Font.BOLD, 11));
		cours.setForeground(new Color(0, 51, 102));
		cours.setBounds(121, 39, 147, 29);
		cours.setBackground(new Color(0, 51, 102));
		panel_1.add(cours);
		
		JButton btnHistorique = new JButton("Historique des cours ");
		btnHistorique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoriqueManager hs = new HistoriqueManager();
				hs.show();
				frame.dispose();
			}
		});
		btnHistorique.setForeground(new Color(0, 51, 102));
		btnHistorique.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnHistorique.setBackground(new Color(0, 51, 102));
		btnHistorique.setBounds(121, 180, 147, 29);
		panel_1.add(btnHistorique);
		cours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionCours c1 = new GestionCours();
				c1.show();
				frame.dispose();
				
			}
		});
	}
}
