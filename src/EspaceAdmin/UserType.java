package EspaceAdmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserType {

	private JFrame frame;
    String typeUser;
	FenetreLogin log = new FenetreLogin();

    public void show () 
    {
    	frame.setVisible(true);
    }
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserType window = new UserType();
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
	public UserType() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 690, 74);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/2 copie.png"));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(223, 0, 261, 74);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/Ensa copie.jpeg"));
		lblNewLabel.setBounds(371, 92, 325, 324);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 92, 356, 324);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//choisir le type d'accées disponible : professeur , Agent scolarité , Responsable apogée , Manager
		
		JButton btnNewButton = new JButton("Professeur");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//appel a la fonction show pour recharger l'interface en quetion .
				
              	log.show();
				frame.dispose();
				
				//passer le type d'utilisateur a une variable pour verifier ces données dans la BD
				
				FenetreLogin.typeUser = "Professeur";
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.setBounds(44, 106, 240, 37);
		btnNewButton.setForeground(new Color(0,51,102));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agent scolarité");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//appel a la fonction show pour recharger l'interface en quetion.
				
              	log.show();
				frame.dispose();
				
				//passer le type d'utilisateur a une variable pour verifier ces données dans la BD
				
				FenetreLogin.typeUser = "Agent scolarité";
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_1.setBounds(44, 155, 240, 37);
		btnNewButton_1.setForeground(new Color(0,51,102));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Responsable apogée");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//appel a la fonction show pour recharger l'interface en quetion.
				
              	log.show();
				frame.dispose();
				
				//passer le type d'utilisateur a une variable pour verifier ces données dans la BD
				
				FenetreLogin.typeUser = "Responsable apogée";
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_2.setBounds(44, 204, 240, 37);
		btnNewButton_2.setForeground(new Color(0,51,102));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Manager");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//appel a la fonction show pour recharger l'interface en quetion.
				
              	log.show();
				frame.dispose();
				
				//passer le type d'utilisateur a une variable pour verifier ces données dans la BD
				
				FenetreLogin.typeUser = "Manager";
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_3.setBounds(44, 253, 240, 37);
		btnNewButton_3.setForeground(new Color(0,51,102));
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Bienvenu , vous êtes ");
		lblNewLabel_2.setForeground(new Color(0,51,102));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(44, 25, 240, 44);
		panel_1.add(lblNewLabel_2);
	}

}
