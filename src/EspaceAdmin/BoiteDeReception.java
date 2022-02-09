package EspaceAdmin;
import java.awt.EventQueue;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class BoiteDeReception {

	public JFrame frame;
	public JTable table_1;
	JButton btnNewButton_1=new JButton();
	

	
	/**
	 * Launch the application.
	 */
    public void show () 
    {
    	frame.setVisible(true);
    	String s = "True";
    	DefaultTableModel model = (DefaultTableModel) table_1.getModel();
    	String module,filiere,date;
    	
    	// Etablir la connection avec la base de donneés.
    	
		   try {
			   
			   //charger le pilote de connection.
			   
		        Class.forName("com.mysql.cj.jdbc.Driver");        
		        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGNC", "test", "Test");
		        
		        //creer un statement pour manipuler nos tables dans la BD.
		        
		        Statement stmt = conn.createStatement();
		        
		        //exécuter le requete sql. 
		        
		        ResultSet rs = stmt.executeQuery("Select * from module where noteEnregistrer='"+s+"'");
		        
		        //parcourir la table retourner 
		        
		        while(rs.next()) {
		        	
		        	module= rs.getString(2);
		        	filiere = rs.getString(4);
		        	date = rs.getString(6);
		    		model.addRow(new Object[] {date,filiere,module});
		              
		        }
                
		        conn.close();
		        System.out.println("done");
		        }
		        
		        catch (Exception ex){
		            
		            System.out.println(ex.getMessage());
		            
		        }
	            
		   
	}
    	
    	
 

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoiteDeReception window = new BoiteDeReception();
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
	public BoiteDeReception() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	  
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 702, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 690, 74);
		panel.setBackground(new Color(220,220,220));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
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
			
			//Listener de la boutton logout .
			
			public void actionPerformed(ActionEvent e) {
				
				//fonction de logout qui permet de nous retourner a la page de Usertype.
				
				UserType logout = new UserType();
				logout.show();
				
				//fonction de logout qui permet de fermer la page actuel.
				
				frame.dispose();
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
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(27, 90, 643, 291);
		frame.getContentPane().add(scrollPane1);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(0,51,102));
		table_1.setForeground(new Color(255,255,255));
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date_reception","Filiere", "Module", "Apercu"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
		scrollPane1.setViewportView(table_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			  //Listener de la boutton apercus.
			
			public void actionPerformed(ActionEvent e) {
            	TelechargerListes page2 = new TelechargerListes();
            	
            	//verifer si une est selctionner ou non .
            	
				if(table_1.getSelectedRow()>=0) 
				{
					TelechargerListes.chercher = (String) table_1.getValueAt(table_1.getSelectedRow(),2);
					TelechargerListes.filiere = (String) table_1.getValueAt(table_1.getSelectedRow(),1);
                    page2.show();
	              	frame.dispose();	  	
	            }	

				else {
					JOptionPane.showMessageDialog(null,"Vous devez choisire une ligne ");				
				}
				
			}
		});
		
		frame.getContentPane().add(btnNewButton_1);
		table_1.getColumn("Apercu").setCellRenderer(new ButtonRenderer());
		table_1.getColumn("Apercu").setCellEditor(new ButtonEditor(new JCheckBox()));
		
	}
	
	// class pour inserer une boutton dans mon tableau.
	
	class ButtonEditor extends DefaultCellEditor 
	  {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String label;
	    
	    public ButtonEditor(JCheckBox checkBox)
	    {
	      super(checkBox);
	    }
	    public Component getTableCellEditorComponent(JTable table, Object value,
	    boolean isSelected, int row, int column) 
	    {
	      label = (value == null) ? " Afficher " : value.toString();
	      btnNewButton_1.setText(label);
	      return btnNewButton_1;
	    }
	    public Object getCellEditorValue() 
	    {
	      return new String(label);
	    }
	  }
	
	 class ButtonRenderer extends JButton implements TableCellRenderer 
		  {
		    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

			public ButtonRenderer() {
		      setOpaque(true);
		    }
		    
		    public Component getTableCellRendererComponent(JTable table, Object value,
		    boolean isSelected, boolean hasFocus, int row, int column) {
		      setText((value == null) ? " Afficher " : value.toString());
		      return this;
		    }
		  }
	
	
}
