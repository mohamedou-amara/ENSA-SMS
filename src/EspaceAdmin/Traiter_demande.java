package EspaceAdmin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class Traiter_demande {

	private JFrame frame;
	private JTextField txtCin;
	private JTextField txtNumeroApoge;
	private JTextField txtAttestationDemande;
	public static String chercher_apo;
	public static String apoo ;
	public static String typedemande ;
    String cin;
	String ml;
    String nom_etudi ;
    String prenom_etudi,année_document ;
    
	
	/**
	 * Launch the application.
	 */

	
	public void show() {
		
		this.frame.setVisible(true);
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traiter_demande window = new Traiter_demande();
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
	public Traiter_demande() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		try {
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	    	   Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC","test","Test");
	    	    Statement stmt = conn.createStatement();
	    	    String rqt = "SELECT * FROM Demande join etudiant on Demande.Apogee = etudiant.num_apogee  Where Apogee=" +apoo ;
		    	ResultSet rs = stmt.executeQuery(rqt);
	            while(rs.next()) {
	            	cin = Integer.toString(rs.getInt(15));
	            	System.out.println(cin);
	            	nom_etudi=rs.getString(2);
	            	prenom_etudi=rs.getString(3);
	            	ml = rs.getString(4);
	            	année_document= rs.getString(6);
	            	System.out.println("fgbh "+cin);
	            }

	            conn.close();
	      }catch(Exception e) {
	    	  System.out.println(e.getMessage());
	      }
		
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(122, 112, 444, 261);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		
		

		txtCin = new JTextField();
		txtCin.setForeground(new Color(255, 255, 255));
		txtCin.setBackground(new Color(0,51,102));
		txtCin.setText(cin);
		txtCin.setEditable(false);
		txtCin.setHorizontalAlignment(SwingConstants.CENTER);
		System.out.println("fc"+cin);
		
		txtCin.setBounds(76, 152, 300, 32);
		panel_1.add(txtCin);
		txtCin.setColumns(10);
		
		txtNumeroApoge = new JTextField();
		txtNumeroApoge.setForeground(new Color(255, 255, 255));
		txtNumeroApoge.setBackground(new Color(0,51,102));
		txtNumeroApoge.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroApoge.setEditable(false);
		txtNumeroApoge.setBounds(76, 106, 300, 32);
		panel_1.add(txtNumeroApoge);
		txtNumeroApoge.setColumns(10);
		txtNumeroApoge.setText(apoo);
		
		txtAttestationDemande = new JTextField();
		txtAttestationDemande.setForeground(new Color(255, 255, 255));
		txtAttestationDemande.setBackground(new Color(0,51,102));
		txtAttestationDemande.setEditable(false);
	    
		txtAttestationDemande.setText(typedemande);
		txtAttestationDemande.setHorizontalAlignment(SwingConstants.CENTER);
		txtAttestationDemande.setBounds(76, 198, 300, 33);
		panel_1.add(txtAttestationDemande);
		txtAttestationDemande.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/Downloads/id-2.png"));
		lblNewLabel.setBounds(189, 6, 88, 88);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apogee");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(3, 114, 61, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CIN");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(3, 160, 61, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type Demande");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(3, 206, 71, 16);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_6_1 = new JButton("Refuser");
		btnNewButton_6_1.setIcon(new ImageIcon("/Users/macamara/Downloads/close.png"));
		btnNewButton_6_1.setBounds(384, 385, 85, 21);
		frame.getContentPane().add(btnNewButton_6_1);
		btnNewButton_6_1.setForeground(Color.BLUE);
		btnNewButton_6_1.setBackground(Color.RED);
		

		JButton btnNewButton_6 = new JButton("Valider");
		btnNewButton_6.setIcon(new ImageIcon("/Users/macamara/Downloads/check-2.png"));
		btnNewButton_6.setBounds(214, 385, 85, 21);
		frame.getContentPane().add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(typedemande.equals("Relevé Note"))
				{
					   try {
					        Class.forName("com.mysql.cj.jdbc.Driver");
					        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
					        Statement stmt = conn.createStatement();
					        Statement stmt1 = conn.createStatement();
					        ResultSet rs = stmt.executeQuery("Select * FROM etudiant join module on etudiant.id_module = module.id_module Where num_apogee = '"+apoo+"'");
			                Document doc = new Document();
			                PdfWriter.getInstance(doc,new FileOutputStream("/Users/macamara/Downloads/"+typedemande+".pdf"));
			                doc.open();
			    			Image logo_ensa = Image.getInstance("/Users/macamara/Downloads/2 copie.png");
			    			doc.add(logo_ensa);
			    			doc.add(new Paragraph("\n"));
			    			doc.add(new Paragraph("\n"));
			    			doc.add(new Paragraph("------------------------------------------- "+typedemande+"----------------------------------------"));
			    			doc.add(new Paragraph("\n"));
			    			doc.add(new Paragraph("\n"));
			    			doc.add(new Paragraph("Nom : "+" "+nom_etudi+"  "+prenom_etudi));
			    			doc.add(new Paragraph("Apoogée : "+apoo));
			    			doc.add(new Paragraph("Anneé : "+année_document));
			    			doc.add(new Paragraph("\n"));
			    			doc.add(new Paragraph("\n"));
			    			doc.add(new Paragraph("\n"));
			    			PdfPTable pdfTable = new PdfPTable(3);
			    			pdfTable.setWidthPercentage(100);
			    			
			    			PdfPCell cell;
			    			
			    			cell = new PdfPCell(new Phrase("Module",FontFactory.getFont("Times New Roman", 12)));
			    			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    			cell.setBackgroundColor(BaseColor.GRAY);
			    			pdfTable.addCell(cell);
			    			
			    			
			    			cell = new PdfPCell(new Phrase("Note",FontFactory.getFont("Times New Roman", 12)));
			    			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    			cell.setBackgroundColor(BaseColor.GRAY);
			    			pdfTable.addCell(cell);
			    			
			    		
			    			cell = new PdfPCell(new Phrase("Decision",FontFactory.getFont("Times New Roman", 12)));
			    			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    			cell.setBackgroundColor(BaseColor.GRAY);
			    			pdfTable.addCell(cell);
			    			
			    	
					        while(rs.next()) {
					        	
					        	cell = new PdfPCell(new Phrase(rs.getString(11),FontFactory.getFont("Times New Roman", 11)));
				    			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				    			pdfTable.addCell(cell);
				    			
				    		   	cell = new PdfPCell(new Phrase(rs.getString(5),FontFactory.getFont("Times New Roman", 11)));
				    			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				    			pdfTable.addCell(cell);
				    			
				    		   	cell = new PdfPCell(new Phrase(rs.getString(8),FontFactory.getFont("Times New Roman", 11)));
				    			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				    			pdfTable.addCell(cell);

					              
					                }
					        
			                doc.add(pdfTable);
			                doc.close();
			                Mail.send(ml,"demande de "+typedemande,"Voici le document que vous avez demandé bonne reception",typedemande+".pdf");
			                int n = stmt1.executeUpdate("UPDATE Demande SET Traitement = 'Acceptée' WHERE Typedemande ='Relevé Note' and Apogee = '"+apoo+"'");
			                AcceuilScolarité sc = new AcceuilScolarité();
			                sc.show();
			                System.out.println(n);
			                System.out.println("done");
					        conn.close();
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
				
				if(typedemande.equals("Attestation Scolarité"))
				{
					try {
				        Class.forName("com.mysql.cj.jdbc.Driver");
				        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
				        Statement stmt = conn.createStatement();
				        Statement stmt1 = conn.createStatement();
				        ResultSet rs = stmt.executeQuery("Select * FROM etudiant join module on etudiant.id_module = module.id_module Where num_apogee = '"+apoo+"'");
		                Document doc = new Document();
		                PdfWriter.getInstance(doc,new FileOutputStream("/Users/macamara/Downloads/"+typedemande+".pdf"));
		                doc.open();
		                Image logo_ensa = Image.getInstance("/Users/macamara/Downloads/2 copie.png");
		    			doc.add(logo_ensa);
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph(new Phrase(typedemande,FontFactory.getFont("Times New Roman", 16))));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Phrase("Le directeur de l'ecole national des sciences appliquées de tetouan certifie que :",FontFactory.getFont("Times New Roman", 12)));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Phrase("Nom : "+" "+nom_etudi+"  "+prenom_etudi,FontFactory.getFont("Times New Roman", 12)));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Phrase("Apoogée : "+apoo,FontFactory.getFont("Times New Roman", 12)));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Phrase("CIN : "+cin,FontFactory.getFont("Times New Roman", 12)));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Phrase("Est regulierement inscrit pour l'année :"+année_document,FontFactory.getFont("Times New Roman", 12)));
		    		
		                doc.close();
		                Mail.send(ml,"demande de "+typedemande,"Voici le document que vous avez demandé bonne reception",typedemande+".pdf");
		                int n = stmt1.executeUpdate("UPDATE Demande SET Traitement = 'Acceptée' WHERE Typedemande ='Attestation Scolarité' and Apogee = '"+apoo+"'");
		                AcceuilScolarité sc = new AcceuilScolarité();
		                sc.show();
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
				
				if(typedemande.equals("Attestation Réussite"))
				{
					try {
				        Class.forName("com.mysql.cj.jdbc.Driver");
				        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
				        Statement stmt = conn.createStatement();
				        Statement stmt1 = conn.createStatement();
				        ResultSet rs = stmt.executeQuery("Select * FROM etudiant join module on etudiant.id_module = module.id_module Where num_apogee = '"+apoo+"'");
		                Document doc = new Document();
		                PdfWriter.getInstance(doc,new FileOutputStream("/Users/macamara/Downloads/"+typedemande+".pdf"));
		                doc.open();
		                Image logo_ensa = Image.getInstance("/Users/macamara/Downloads/2 copie.png");
		    			doc.add(logo_ensa);
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph(new Phrase(typedemande,FontFactory.getFont("Times New Roman", 16))));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("Le directeur de l'ecole national des sciences appliquées de tetouan certifie que :",FontFactory.getFont("Times New Roman", 12)));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("Nom : "+" "+nom_etudi+"  "+prenom_etudi,FontFactory.getFont("Times New Roman", 12)));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("Apoogée : "+apoo,FontFactory.getFont("Times New Roman", 12)));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("CIN : "+cin,FontFactory.getFont("Times New Roman", 12)));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Paragraph("\n"));
		    			doc.add(new Phrase("a été declaré admis pour l'année :"+année_document,FontFactory.getFont("Times New Roman", 12)));
		    		
		                doc.close();
		                Mail.send(ml,"demande de "+typedemande,"Voici le document que vous avez demandé bonne reception",typedemande+".pdf");
		                int n = stmt1.executeUpdate("UPDATE Demande SET Traitement = 'Acceptée' WHERE Typedemande ='Attestation Réussite' and Apogee = '"+apoo+"'");
		                AcceuilScolarité sc = new AcceuilScolarité();
		                sc.show();
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
				
				
			}
		});
		btnNewButton_6.setForeground(Color.BLUE);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(220, 220, 220));
		panel_1_1.setBounds(6, 6, 691, 94);
		frame.getContentPane().add(panel_1_1);
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil acc = new Acceuil();
				acc.show();
				frame.dispose();
			}
		});
		btnAcceuil.setIcon(new ImageIcon("/Users/macamara/Downloads/home.png"));
		btnAcceuil.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAcceuil.setBounds(443, 36, 117, 29);
		panel_1_1.add(btnAcceuil);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserType user = new UserType();
				user.show();
				frame.dispose();
			}
		});
		btnLogout.setIcon(new ImageIcon("/Users/macamara/Downloads/logout.png"));
		btnLogout.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnLogout.setBounds(568, 36, 117, 29);
		panel_1_1.add(btnLogout);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		lblLogo.setBounds(6, 6, 275, 82);
		panel_1_1.add(lblLogo);
		
		JLabel lblAgentScolarit = new JLabel("Agent Scolarité");
		lblAgentScolarit.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		lblAgentScolarit.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblAgentScolarit.setBounds(328, 35, 103, 29);
		panel_1_1.add(lblAgentScolarit);
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typedemande.equals("Relevé Note"))
				{
				try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC","test","Test");
			        Statement stmt1 = conn.createStatement();
			        int n = stmt1.executeUpdate("UPDATE Demande SET Traitement = 'Refuse' WHERE Typedemande = Relevé Note and Apogee = '"+apoo+"'");
			        System.out.println(n);
                    conn.close();
				}
	            catch (Exception ex){
	            System.out.println(ex.getMessage());   
	        }
				Mailrefus.send(ml,"Nous avons le regret de vous informer que votre demande de connexion a échoué, Veuillez contacter l'administration pour plus d'information ","demande de "+typedemande);	
				
				AcceuilScolarité acc = new AcceuilScolarité();
				acc.show();
				frame.dispose();
				
				}
				
				if(typedemande.equals("Attestation Scolarité"))
				{
				try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC","test","Test");
			        Statement stmt1 = conn.createStatement();
			        int n = stmt1.executeUpdate("UPDATE Demande SET Traitement = 'Refuse' WHERE Typedemande = Attestation Scolarité and Apogee = '"+apoo+"'");
			        System.out.println(n);
                    conn.close();
				}
	            catch (Exception ex){
	            System.out.println(ex.getMessage());   
	        }
				Mailrefus.send(ml,"Nous avons le regret de vous informer que votre demande de connexion a échoué, Veuillez contacter l'administration pour plus d'information ","demande de "+typedemande);	
				
				AcceuilScolarité acc = new AcceuilScolarité();
				acc.show();
				frame.dispose();
				
				}
				
				
				if(typedemande.equals("Attestation Réussite"))
				{
				try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC","test","Test");
			        Statement stmt1 = conn.createStatement();
			        int n = stmt1.executeUpdate("UPDATE Demande SET Traitement = 'Refuse' WHERE Typedemande = Attestation Réussite and Apogee = '"+apoo+"'");
			        System.out.println(n);
                    conn.close();
				}
	            catch (Exception ex){
	            System.out.println(ex.getMessage());   
	        }
				Mailrefus.send(ml,"Nous avons le regret de vous informer que votre demande de connexion a échoué, Veuillez contacter l'administration pour plus d'information ","demande de "+typedemande);	
				
				AcceuilScolarité acc = new AcceuilScolarité();
				acc.show();
				frame.dispose();
				
				}
				
			}
			
		});
	}
}
