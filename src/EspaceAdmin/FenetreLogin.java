package EspaceAdmin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
//import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class FenetreLogin {

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField passwordField;
    public static String typeUser;
    String login;
    String passwd;
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
					FenetreLogin window = new FenetreLogin();
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
	public FenetreLogin() {
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
		panel.setBounds(6, 6, 690, 74);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(217, 0, 261, 74);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(115, 105, 478, 283);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 163, 220, 20);
		panel_1.add(passwordField);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(new Color(169, 169, 169));
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		passwordField.setBackground(new Color(0, 51, 102));
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(71, 166, 76, 14);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		
		txtLogin = new JTextField();
		txtLogin.setBounds(139, 97, 220, 20);
		panel_1.add(txtLogin);
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtLogin.setForeground(new Color(169, 169, 169));
		txtLogin.setBackground(new Color(0, 51, 102));
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(71, 100, 46, 14);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(175, 218, 141, 23);
		panel_1.add(btnNewButton);
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(220, 220, 220));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/macamara/Downloads/user-interface-3.png"));
		lblNewLabel_2.setBounds(218, 18, 67, 67);
		panel_1.add(lblNewLabel_2);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				/* Si l'utilisateur est un professeur */
				if(typeUser.equals("Professeur")) {
					int cmt = 0;  /* variable qui s'incrémente une fois le professeur est bien authentifié*/
					
					   try {
					        Class.forName("com.mysql.cj.jdbc.Driver");
					        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
					        Statement stmt = conn.createStatement();
					        ResultSet rs = stmt.executeQuery("Select id_prof,motDePasse FROM professeur");  
					           /* Sélectionner le id et le mot de passe de chaque professeur dans la table professeur de la base de données */
					        while(rs.next()) {
					        	if(txtLogin.getText().equals(rs.getString(1))&&passwordField.getText().equals(rs.getString(2))) {
					        		cmt ++;	/* Test si les infos saisis existe dans la table de la base de données */
					        	}
					        }
					        if(cmt == 1) 
					        {
					        	AccueilProfesseur f1 = new AccueilProfesseur(txtLogin.getText()); /*Constructeur initialise la valeur idRespo */
					        	f1.show(); /* Afficher la page d'accueil en passant l'id du professeur en paramètre */
					        	frame.dispose();
					        }
					        else
					        {
								/*Données introuvables Professeur non identifié */
					        	JOptionPane.showMessageDialog(frame,"Verifier votre Login ou mot de passe ","Error d'authentification",JOptionPane.WARNING_MESSAGE);
					            txtLogin.setText("");
					            passwordField.setText("");
					        }
					        conn.close();
				           }
					        catch (Exception ex){
					            
					            System.out.println(ex.getMessage());
					            
					        }
					   
				}
				else if(typeUser.equals("Agent scolarité")) {
					int cmt = 0;
					   try {
					        Class.forName("com.mysql.cj.jdbc.Driver");
					        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
					        Statement stmt = conn.createStatement();
					        ResultSet rs = stmt.executeQuery("Select Login,PasseWord FROM SingInAS ");
					        while(rs.next()) {
					        	if(txtLogin.getText().equals(rs.getString(1))&&passwordField.getText().equals(rs.getString(2))) {
					        		cmt ++;	
					        	}
					        }
					        if(cmt == 1) 
					        {
					        	Acceuil acc = new Acceuil();
					        	acc.show();
					        	frame.dispose();
					        }
					        else
					        {
					        	JOptionPane.showMessageDialog(frame,"Verifier votre Login ou mot de passe ","Error d'authentification",JOptionPane.WARNING_MESSAGE);
					            txtLogin.setText("");
					            passwordField.setText("");
					        }
					        conn.close();

				           }
					        catch (Exception ex){
					            
					            System.out.println(ex.getMessage());
					            
					        }
				}
				else if(typeUser.equals("Responsable apogée")) {
					int cmt = 0;
					AcceuilApogee br =  new AcceuilApogee();
					   try {
					        Class.forName("com.mysql.cj.jdbc.Driver");
					        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
					        Statement stmt = conn.createStatement();
					        ResultSet rs = stmt.executeQuery("Select Login,PasseWord FROM SingInRA");   
					        while(rs.next()) {
					        	if(txtLogin.getText().equals(rs.getString(1))&&passwordField.getText().equals(rs.getString(2))) {
					        		cmt ++;	
					        	}
					        }
					        if(cmt == 1) 
					        {
					        	br.show();
					        	frame.dispose();
					        }
					        else 
					        {
					        	
					        	JOptionPane.showMessageDialog(frame,"Verifier votre Login ou mot de passe ","Error d'authentification",JOptionPane.WARNING_MESSAGE);
					            txtLogin.setText("");
					            passwordField.setText("");
					        }
					        
					        	conn.close();
				           }
					        catch (Exception ex){
					            
					            System.out.println(ex.getMessage());
					            
					        }
				}
				else if(typeUser.equals("Manager")) {
					int cmt = 0;
					AccueilManager man = new AccueilManager();
					   try {
					        Class.forName("com.mysql.cj.jdbc.Driver");
					        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
					        Statement stmt = conn.createStatement();
					        ResultSet rs = stmt.executeQuery("SELECT * FROM SingInManger ");
					        
					        while(rs.next()) {
					        	if(txtLogin.getText().equals(rs.getString(1))&&passwordField.getText().equals(rs.getString(2))) {
					        		cmt ++;	
					        	}
					        }
					        if(cmt == 1) 
					        {
					        	man.show();
					        	frame.dispose();
					        }
					        else
					        {
					        	JOptionPane.showMessageDialog(frame,"Verifier votre Login ou mot de passe ","Error d'authentification",JOptionPane.WARNING_MESSAGE);
					            txtLogin.setText("");
					            passwordField.setText("");
					        }
					        conn.close();
					        	
					   }
				           
					        catch (Exception ex){
					            
					            System.out.println(ex.getMessage());
					            
					        }
				}
			/*	else if(typeUser.equals("Etudiant")) {
					int cmt = 0;
					   try {
					        Class.forName("com.mysql.cj.jdbc.Driver");
					        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
					        Statement stmt = conn.createStatement();
					        ResultSet rs = stmt.executeQuery("Select Login,PasseWord FROM SingInEtu");  
					        
					        while(rs.next()) {
					        	if(txtLogin.getText().equals(rs.getString(1))&&passwordField.getText().equals(rs.getString(2))) {
					        		cmt ++;	
					        	}
					        }
					        if(cmt == 1) 
					        {
					        	System.out.println("vous etes connecter");
					        }
					        else
					        {
					        	JOptionPane.showMessageDialog(frame,"Verifier votre Login ou mot de passe ","Error d'authentification",JOptionPane.WARNING_MESSAGE);
					            txtLogin.setText("");
					            passwordField.setText("");
					        }
					        conn.close();
					        
				           }
					        catch (Exception ex){
					            
					            System.out.println(ex.getMessage());
					            
					        }
				}*/
			}
		});
	}
}

