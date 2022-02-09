package EspaceAdmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;

public class TelechargerListes {

	private JFrame frame;
	public static JTable table;
    public static DefaultTableModel model1;
   
	/**
	 * Launch the application.
	 */
    String Apogee,prenom,id_module,note,nom,num_groupe;
	static String chercher;
	static String filiere;   
    
    public void show () {
		 this.frame.setVisible(true);
		 
		// Etablir la connection avec la base de donneés.
		 
		   try {
			   
			 //charger le pilote de connection.
			   
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
		        
		        //creer un statement pour manipuler nos tables dans la BD.
		        
		        Statement stmt = conn.createStatement();
		        
		      //exécuter le requete sql. 	        
	
		        ResultSet rs = stmt.executeQuery("Select * from etudiant join module on etudiant.id_module = module.id_module where nom_module='"+chercher+"'");
		        
		      //parcourir la table retourner
		        
		        while(rs.next()) {
		        	Apogee= rs.getString(1);
		        	nom= rs.getString(2);
		        	prenom = rs.getString(3);
		        	id_module = rs.getString(4);
		        	note = rs.getString(5);
		        	num_groupe = rs.getString(6);
		        	TelechargerListes.model1.addRow(new Object[] {Apogee,nom,prenom,id_module,note,num_groupe});	
		            
		        }
		        conn.close();
		        }
		        catch (Exception ex){
		            
		            System.out.println(ex.getMessage());
		            
		        }

    }

    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelechargerListes window = new TelechargerListes();
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
	public TelechargerListes() {
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
		panel.setLayout(null);
		panel.setBounds(6, 6, 690, 74);
		panel.setBackground(new Color(220,220,220));
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Responsable Apogée");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/user.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel.setBounds(367, 28, 130, 20);
		panel.add(lblNewLabel);
		
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
		btnAcceuil.setBounds(509, 27, 79, 22);
		panel.add(btnAcceuil);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserType logout = new UserType();
				logout.show();
			}
		});
		btnNewButton.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/logout.png"));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setBounds(600, 27, 84, 22);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/macamara/eclipse-workspace/SGNC/images/2 copie.png"));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 261, 74);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 90, 643, 291);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(0,51,102));
		table.setForeground(new Color(255,255,255));
		table.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Code Etudiant", "Nom", "Prenom", "Module", "Note","Groupe"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		scrollPane.setViewportView(table);
        	
		model1 = (DefaultTableModel) table.getModel();
		
		JButton btnNewButton_1 = new JButton("Telecharger");
		btnNewButton_1.setIcon(new ImageIcon("/Users/macamara/Downloads/download-arrow.png"));
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_1.setBounds(170, 242, 102, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Telecharger");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			//Listener de la boutton telecharger.
			
			public void actionPerformed(ActionEvent e) {
				
				//Creer une instance de la classe document.
				
				 Document doc = new Document();
		
				 
	             try {
	            	 
	            	 //Donner le chemin au niveau du quelle le document sera enregistrer.
	            	 
					PdfWriter.getInstance(doc,new FileOutputStream("/Users/macamara/Downloads/Liste_"+chercher+".pdf"));
					
					//ouvrir le document en mode ecriture.
					
					doc.open();
					
					// inserer une image dans le document 

					Image logo_ensa = Image.getInstance("/Users/macamara/Downloads/2 copie.png");
	    			doc.add(logo_ensa);
	    			
	    			// insere un paragraph dans le pdf.
	    			
	    			doc.add(new Paragraph("\n"));
	    			doc.add(new Paragraph("\n"));
	    			doc.add(new Paragraph(" ----------------------------------- Liste des etudient de la filiere "+filiere+" ----------------------------------------- "));
	    			doc.add(new Paragraph("\n"));
	    			doc.add(new Paragraph("\n"));
	    			doc.add(new Paragraph("\n"));
	    			
	    			//inserer une table dans le document 
	    			
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
	                
	                // ajouter le pdftable dans mon document
	                
	                doc.add(pdfTable);
	                doc.close();
	                System.out.println("Traitement terminer");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("/Users/macamara/Downloads/download-arrow.png"));
		btnNewButton_2.setBounds(261, 387, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
	}
}
