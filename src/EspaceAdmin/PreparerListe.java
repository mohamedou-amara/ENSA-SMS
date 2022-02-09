package EspaceAdmin;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class PreparerListe {

	private JFrame frame;
	private JTextField textField;
	JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
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
					PreparerListe window = new PreparerListe();
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
	public PreparerListe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 450);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 690, 74);
		panel.setBackground(new Color(220,220,220));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/2 copie.png"));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(0, 0, 261, 74);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Responsable Apogée");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/user.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(335, 24, 130, 20);
		panel.add(lblNewLabel_2);
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcceuilApogee acceuil = new AcceuilApogee();
				acceuil.show();
				frame.dispose();
			}
		});
		btnAcceuil.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/home.png"));
		btnAcceuil.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnAcceuil.setBackground(new Color(25, 25, 112));
		btnAcceuil.setBounds(477, 24, 79, 22);
		panel.add(btnAcceuil);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserType logout = new UserType();
				logout.show();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/logout.png"));
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_1.setBackground(new Color(25, 25, 112));
		btnNewButton_1.setBounds(573, 24, 84, 22);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220,220,220));
		panel_1.setBounds(27, 90, 643, 291);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(169, 169, 169));
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField.setColumns(10);
		textField.setBackground(new Color(0, 51, 102));
		textField.setBounds(211, 34, 220, 37);
		panel_1.add(textField);
		
        table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
						"CIN","Groupe","Nom","Prenom","Filiere","Email","Apogee"
				}
			));
		
		JLabel lblNewLabel = new JLabel("Destinataire");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel.setBounds(133, 44, 66, 16);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Envoyer");
		btnNewButton.addActionListener(new ActionListener() {
			
			//listener de la boutton envoiyer.
			
			public void actionPerformed(ActionEvent e) {
				String apogee,cin,cne,email,nom,prenom,filiere;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				    
				// Etablir la connection avec la base de donneés.
				
				   try {
					   
					   //charger le pilote de connection.
					   
				        Class.forName("com.mysql.cj.jdbc.Driver");
				        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
				        
				      //exécuter le requete sql.
				        
				        Statement stmt = conn.createStatement();
				        
				      //parcourir la table retourner
				        
				        ResultSet rs = stmt.executeQuery("Select * FROM etudiant join module on etudiant.id_module = module.id_module  Where filiere = '"+textField_1.getText()+"'");
				        
				      //Creer une instance de la classe document.
				        
		                Document doc = new Document();
		                
		                //Donner le chemin au niveau du quelle le document sera enregistrer.
		                
		                PdfWriter.getInstance(doc,new FileOutputStream("/Users/macamara/Downloads/Liste_"+textField_1.getText()+".pdf"));
		                
		              //ouvrir le document en mode ecriture.
		                
		                doc.open();
		                
		             // inserer une image dans le document 
		                
		    			Image logo_ensa = Image.getInstance("/Users/macamara/Downloads/2 copie.png");
		    			doc.add(logo_ensa);
		    			
		    			// insere un paragraph dans le pdf.
		    			
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("------------------------------------------- Liste des etudient de la filiere "+textField_1.getText()+"----------------------------------------"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			
		    			 //parcourir la table retourner
		    			
				        while(rs.next()) {
				        	cin = rs.getString(7);
				        	cne= rs.getString(6);
				        	nom = rs.getString(2);
				        	prenom = rs.getString("prenom");
				        	filiere = rs.getString(13);
				        	email = rs.getString(9);
				        	apogee = rs.getString(1);
				        	
				    		model.addRow(new Object[] {cin,cne,nom,prenom,filiere,email,apogee});
				              
				                }
				        
				      //inserer une table dans le document .
						
		    			PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
		    			
		                //inserer l'entete de la table
		    			
		                for (int i = 0; i < table.getColumnCount(); i++) {
		                    pdfTable.addCell(table.getColumnName(i));
		                }
		                
		              //extraire les données a partir du JTable et la l'inserer dans PdfPTable
		                
		                for (int rows = 0; rows <= table.getRowCount() - 1; rows++) {
		                    for (int cols = 0; cols < table.getColumnCount(); cols++) {
		                        pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());

		                    }
		                }
		                
		                // inserer le pdftable dans le document.
		                
		                doc.add(pdfTable);
		                doc.close();
		                Mail.send(textField.getText(),textField_2.getText(),textField_3.getText(),"Liste_"+textField_1.getText()+".pdf");
		                System.out.println("done");
				        conn.close();
				        textField.setText("");
				        textField_1.setText("");
				        textField_2.setText("");
				        textField_3.setText("");
				        
				          AcceuilApogee acc = new AcceuilApogee();
				          acc.show();
				          frame.dispose();
				        }
		             catch (DocumentException ex) {
			               System.out.print("erroooooor");
			            }catch (FileNotFoundException ex) {
			            	System.out.print("erroooooor");
			            }
				        catch (Exception ex){
				            
				            System.out.println(ex.getMessage());
				            
				        }
			
				   
			}
		});
		btnNewButton.setIcon(new ImageIcon("/Users/macamara/Downloads/upload.png"));
		btnNewButton.setBounds(272, 258, 93, 27);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Corp");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(133, 199, 46, 16);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(new Color(169, 169, 169));
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(0, 51, 102));
		textField_1.setBounds(211, 83, 220, 37);
		panel_1.add(textField_1);
		
		JLabel lblClasse = new JLabel("Classe ");
		lblClasse.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblClasse.setBounds(133, 93, 66, 16);
		panel_1.add(lblClasse);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(new Color(169, 169, 169));
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(0, 51, 102));
		textField_2.setBounds(211, 132, 220, 37);
		panel_1.add(textField_2);
		
		JLabel lblEntete = new JLabel("Entete");
		lblEntete.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblEntete.setBounds(133, 141, 66, 16);
		panel_1.add(lblEntete);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(new Color(169, 169, 169));
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(0, 51, 102));
		textField_3.setBounds(211, 181, 220, 54);
		panel_1.add(textField_3);
		
	}
}
