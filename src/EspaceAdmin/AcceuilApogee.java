package EspaceAdmin;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;


import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class AcceuilApogee {

	private JFrame frame;
	//JTable table;
	/**
	 * Launch the application.
	 */
	
    public void show () 
    {
    	frame.setVisible(true);
    }
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceuilApogee window = new AcceuilApogee();
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
	public AcceuilApogee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100,702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 690, 74);
		panel.setBackground(new Color(220,220,220));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/logout.png"));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			
			//fonction listener pour la boutton logout.
			
			public void actionPerformed(ActionEvent e) {
				
				//fonction de logout qui permet de nous retourner a la page de Usertype.
				
				UserType logout = new UserType();
				logout.show();
				
				//fonction de logout qui permet de fermer la page actuel.
				
				frame.dispose();
			}
		});
		btnNewButton.setBounds(600, 27, 84, 22);
		panel.add(btnNewButton);
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAcceuil.setBackground(new Color(25, 25, 112));
		btnAcceuil.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/home.png"));
		btnAcceuil.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnAcceuil.setBounds(509, 27, 79, 22);
		panel.add(btnAcceuil);
		
		JLabel lblNewLabel = new JLabel("Responsable Apogée");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/user.png"));
		lblNewLabel.setBackground(new Color(250,250,250));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel.setBounds(367, 28, 130, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/2 copie.png"));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 261, 74);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220,220,220));
		panel_1.setBounds(27, 90, 643, 291);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btn1 = new JButton("Boite de Reception");
		btn1.addActionListener(new ActionListener() {
			
			//fonction listener pour la boutton Boite de Reception.
			
			public void actionPerformed(ActionEvent e) {
				
				//fonction de logout qui permet de nous renvoiyer a la page de BoiteDeReception.
				
				BoiteDeReception Recep = new BoiteDeReception();
				Recep.show();
				
				//fonction de logout qui permet de fermer la page actuel.
				
              	frame.dispose();	  	
			}
		});
		btn1.setIcon(new ImageIcon("/Users/macamara/Downloads/messages.png"));
		btn1.setBounds(148, 55, 350, 41);
		panel_1.add(btn1);
		
		JButton btnImporterUneListe = new JButton("Importer une liste");
		btnImporterUneListe.addActionListener(new ActionListener() {
			
			//fonction listener pour la boutton Boite de Reception.
			
			public void actionPerformed(ActionEvent e) {
				
				//fonction de logout qui permet de nous renvoiyer a la page de PreparerListe.
				
				PreparerListe preparer = new PreparerListe();
				preparer.show();
		
				//fonction de logout qui permet de fermer la page actuel.
				
              	frame.dispose();

			}
		});
		

		btnImporterUneListe.setIcon(new ImageIcon("/Users/macamara/Downloads/upload.png"));
		btnImporterUneListe.setBounds(148, 166, 350, 41);
		panel_1.add(btnImporterUneListe);
	}
}
