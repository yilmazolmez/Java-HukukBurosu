package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//public class hukukMuvekkilhukukihareketler extends JFrame {
public class hukukMuvekkilhukukihareketler extends JDialog {

	private JPanel contentPane;
	private JTextField txtisim;
	private JTable table;

	private PreparedStatement preparedStatement = null;
	private Statement statement = null;

	public static int id=0;
	public static int sakla_id=0;
	
	public static String id_al;

	
	static Connection myconn1;
	static Statement mystat1;
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"MuvekkilTC","HareketTipi","IcraTakipTarihi","IcraMemuru","Hareket No"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[5]; //SATIR TANIMLAMA
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukMuvekkilhukukihareketler frame = new hukukMuvekkilhukukihareketler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public hukukMuvekkilhukukihareketler() {
		setModal(true);
		setResizable(false);
		setTitle("Muvekkil Hukuki Hareketler");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 930, 386);
		setLocationRelativeTo(null); 
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("Pencere Acildi");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("Pencere kapandi");
			}
			@Override
			public void windowActivated(WindowEvent e) {
				
				modelim.setRowCount(0);
				id_al=hukukMuvekkilanaform.id2;
				ResultSet rs1 = null;
				try 
				{
					
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					System.out.println("Baðlantý Saðlandý");
					String listele="Select * From muvekkilhukukihareket where MuvekkilTC='"+id_al+"'";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					System.out.println("Listeleme Basarili");
					while(rs1.next())
					{
						satirlar[0]=rs1.getString("MuvekkilTC");
						satirlar[1]=rs1.getString("HareketTipi");
						satirlar[2]=rs1.getString("IcraTakipTarihi");
						satirlar[3]=rs1.getString("IcraMemuru");
						satirlar[4]=rs1.getString("HareketNo");
						modelim.addRow(satirlar);
						
					}
					table.setModel(modelim);
					table.updateUI();
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					
					//final TableColumn column = table.getColumnModel().getColumn(4);
					// column.setMinWidth(0);
	                // column.setMaxWidth(0);
	                // column.setWidth(0);
	                // column.setPreferredWidth(0);
	                // column.setResizable(false);
	                 txtisim.setText("");
				
				}catch(SQLException e1)
				{
					e1.printStackTrace();
				}

			}
		});
		JLabel lblmuvekkil = new JLabel("");
		lblmuvekkil.setHorizontalAlignment(SwingConstants.CENTER);
		lblmuvekkil.setOpaque(true);
		lblmuvekkil.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/Notary-icon.png")).getImage();
		lblmuvekkil.setIcon(new ImageIcon(img));
		lblmuvekkil.setBounds(10, 47, 198, 276);
		contentPane.add(lblmuvekkil);
		
		JLabel lblmuvekkilislemleri = new JLabel("Muvekkil Hukuki Hareketler");
		lblmuvekkilislemleri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblmuvekkilislemleri.setBounds(10, 11, 316, 26);
		contentPane.add(lblmuvekkilislemleri);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvazgec.setBounds(804, 293, 100, 30);
		contentPane.add(btnvazgec);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_al=hukukMuvekkilanaform.id2;
				hukukMuvekkilhukukihareketekle frame = new hukukMuvekkilhukukihareketekle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				//dispose();
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnekle.setBounds(218, 293, 100, 30);
		contentPane.add(btnekle);
		
		JButton btnsil = new JButton("Sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
		
						try {
							String tut_no = table.getValueAt(table.getSelectedRow(),4).toString();
							String tut_tc = table.getValueAt(table.getSelectedRow(),0).toString();
							int selectedOption = JOptionPane.showConfirmDialog(null,tut_tc+" Silmek istiyor musunuz?","SÝL",JOptionPane.YES_NO_OPTION); 
							if (selectedOption == JOptionPane.YES_OPTION)
							{
								
								try {
									myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
									Statement statement = myconn1.createStatement();
									String sil="Delete from muvekkilhukukihareket where HareketNo='"+tut_no+"'";
									statement.executeUpdate(sil);
									JOptionPane.showMessageDialog(null,tut_tc+" silindi");
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									
								}
							}
							
						 }
						 catch(Exception hata)
							{
							 	JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
								System.err.println(hata);
							}
						}		else {
							//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
							Object [] noSaveOption = {"Tamam"};
							int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
						}}
			
		});
		btnsil.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsil.setBounds(436, 293, 100, 30);
		contentPane.add(btnsil);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(218, 48, 686, 179);
		contentPane.add(scrollPane);
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		modelim.setColumnIdentifiers(kolonlar);
		
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						id  = Integer.parseInt(table.getValueAt(table.getSelectedRow(),4).toString());
				 
						hukukMuvekkilhukukihareketekle frame = new hukukMuvekkilhukukihareketekle();
						frame.show();
						frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
						//dispose();
				}
				catch(Exception e1)
				{
				 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
					e1.printStackTrace();
				}
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnduzenle.setBounds(326, 293, 100, 30);
		
		contentPane.add(btnduzenle);
		
		txtisim = new JTextField();
		txtisim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					///HER KELIMEYLE ARAMA
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelim);
				    table.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(txtisim.getText()));
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					///
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		txtisim.setBounds(218, 252, 576, 30);
		contentPane.add(txtisim);
		txtisim.setColumns(10);
		
		JButton btnara = new JButton("Ara");
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					txtisim.setText("");
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					txtisim.requestFocus();
				} catch (Exception e2) {
					System.out.println(e2);
					// TODO: handle exception
				}
			}
		});
		btnara.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnara.setBounds(804, 252, 100, 30);
		contentPane.add(btnara);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RAPOR ALMA ISLEMI
				hukukMuvekkilhukukihareketrapor_cagir rapor = new hukukMuvekkilhukukihareketrapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),4).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRapor.setBounds(546, 293, 100, 30);
		contentPane.add(btnRapor);
		
		JButton btnYardim = new JButton("Yardim");
		btnYardim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnYardim.setBounds(658, 293, 100, 30);
		contentPane.add(btnYardim);
		
		
			}}
	