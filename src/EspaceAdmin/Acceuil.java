package EspaceAdmin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acceuil {

	private JFrame frame;
	
	
	public void show() 
	{	
		this.frame.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil window = new Acceuil();
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
	public Acceuil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 102, 690, 300);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Historique des demandes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historique hs = new Historique();
				hs.show();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(194, 62, 315, 63);
		panel_1.add(btnNewButton);
		
		JButton btnTraiterLesDemande = new JButton("Traiter les demandes en attentes");
		btnTraiterLesDemande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcceuilScolarité sc = new AcceuilScolarité();
				sc.show();
				frame.dispose();
			}
		});
		btnTraiterLesDemande.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTraiterLesDemande.setBounds(194, 195, 315, 63);
		panel_1.add(btnTraiterLesDemande);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(6, 6, 690, 95);
		frame.getContentPane().add(panel);
		
		JButton deconnexion = new JButton("Logout");
		deconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserType user = new UserType();
				user.show();
				frame.dispose();
			}
		});
		deconnexion.setIcon(new ImageIcon("/Users/macamara/Downloads/logout.png"));
		deconnexion.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		deconnexion.setBackground(new Color(220, 220, 220));
		deconnexion.setBounds(579, 35, 88, 29);
		panel.add(deconnexion);
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAcceuil.setIcon(new ImageIcon("/Users/macamara/Downloads/home.png"));
		btnAcceuil.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAcceuil.setBackground(new Color(220, 220, 220));
		btnAcceuil.setBounds(474, 35, 97, 29);
		panel.add(btnAcceuil);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/2 copie.png"));
		lblLogo.setBackground(new Color(220, 220, 220));
		lblLogo.setBounds(6, 6, 301, 83);
		panel.add(lblLogo);
		
		JLabel lblManager = new JLabel("Agent Scolarité");
		lblManager.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblManager.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		lblManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblManager.setBounds(365, 34, 97, 29);
		panel.add(lblManager);
	}
}