package EspaceAdmin;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JLabel;


public class AccueilProfesseur {

	private JFrame frame;
	private JTable table_1;
	public static DefaultTableModel model1;
	static String idRespo;
	JButton button = new JButton();
	
	/**
	 * Create the application.
	 */
	public AccueilProfesseur() {
		initialize();
	}
	
	/*Constructeur permet d'initialiser la valeur idRespo */
	public AccueilProfesseur(String idRespo) {
		initialize();
		this.idRespo = idRespo;
	}
	
	/* Méthode permet d'afficher l'interface d'accueil personnalisé*/
	public void show () { 
		 this.frame.setVisible(true);
		 try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/SGCN","test","Test");
		        java.sql.Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery("Select nom_module, filiere FROM modules Where respo_module = '"+idRespo+"' AND noteEnregistrer = 'False'");
				/* Requete permet de sélectionner seulement les modules non corrigés dont le prof authentifié est responsable */
		        while(rs.next()) {
		        	String module= rs.getString(1);
		        	String filiere= rs.getString(2);
		        	AccueilProfesseur.model1.addRow(new Object[] {module,filiere});	/*afficher les modules dans la Jtable*/
		        }
		        }
		        catch (Exception ex){
		            
		            System.out.println(ex.getMessage());
		            
		        }
	}
	
	/*Classes permettent d'ajouter un boutton dans la colonne Aperçu de la table module */
	class ButtonEditor extends DefaultCellEditor 
	  {
	    private String label;
	    
	    public ButtonEditor(JCheckBox checkBox)
	    {
	      super(checkBox);
	    }
	    public Component getTableCellEditorComponent(JTable table, Object value,
	    boolean isSelected, int row, int column) 
	    {
	      label = (value == null) ? "Afficher" : value.toString();
	      button.setText(label);
	      return button;
	    }
	    public Object getCellEditorValue() 
	    {
	      return new String(label);
	    }
	  }
	
	 class ButtonRenderer extends JButton implements TableCellRenderer 
		  {
		    public ButtonRenderer() {
		      setOpaque(true);
		    }
		    
		    public Component getTableCellRendererComponent(JTable table, Object value,
		    boolean isSelected, boolean hasFocus, int row, int column) {
		      setText((value == null) ? "Afficher" : value.toString());
		      return this;
		    }
		  }
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 701, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(10, 11, 665, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setIcon(new ImageIcon("/Users/macamara/Downloads/logout.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserType logout = new UserType(); /*Revenir à la page initiale UserType */
				logout.show();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(564, 29, 91, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Accueil");
		btnNewButton_2.setIcon(new ImageIcon("/Users/macamara/Downloads/home.png"));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_2.setForeground(new Color(25, 25, 112));
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        	AccueilProfesseur f1 = new AccueilProfesseur(idRespo); /*Revenir à la page d'accueil */
							f1.show();
							frame.dispose();
			}
		});
		btnNewButton_2.setBounds(463, 29, 91, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Professeur");
		lblNewLabel.setIcon(new ImageIcon("/Users/macamara/Downloads/user-2.png"));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel.setBounds(362, 31, 91, 19);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 285, 81);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/macamara/Downloads/2 copie.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		table_1 = new JTable();
		table_1.setForeground(Color.WHITE);
		table_1.setBackground(new Color(0, 51, 102));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Module", "Fili\u00E8re", "Aper\u00E7u" /* Table des modules */
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(53, 125, 575, 260);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(10, 103, 665, 297);
		frame.getContentPane().add(panel_1);
		/*Ajouter le boutton afficher dans la colonne aperçu */
		table_1.getColumn("Aper\u00E7u").setCellRenderer(new ButtonRenderer());
		table_1.getColumn("Aper\u00E7u").setCellEditor(new ButtonEditor(new JCheckBox()));
		model1 = (DefaultTableModel) table_1.getModel();
		button.addActionListener(
		      new ActionListener()
		      {
		        public void actionPerformed(ActionEvent event)
		        {
		        	//Afficher la liste des étudiants du module sélectionner
		        	
		        	ListeEtu f1 = new ListeEtu((String) table_1.getValueAt(table_1.getSelectedRow(), 0));/*Passant le nom de module par paramétre*/
					f1.show();
					frame.dispose();
		        }
		      }
		    );
		  }
	 
	 
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AccueilProfesseur window = new AccueilProfesseur();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		
}

