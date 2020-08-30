package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//public class hukukPersonelanaekrani extends JFrame {
public class hukukPersonelanaekrani extends JDialog {

	private JPanel contentPane;
	private JTextField txtisim;
	static Connection myconn1;
	static java.sql.Statement mystat1;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private JTable table;
	public static String tc="0";
	public static String tc_sakla="0";
	Object [] kolonlar = {"PersonelTC","PersonelAdSoyad","PersonelMaasNET","PersonelTelefon","PersonelTipi","PersonelEposta","PersonelKayitTarihi"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[7]; //SATIR TANIMLAMA
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	
	static Connection con;
 
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukPersonelanaekrani frame = new hukukPersonelanaekrani();
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
	public hukukPersonelanaekrani() {
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Personel Ana Ekrani");
		setBounds(100, 100, 962, 420);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240,240));
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
				
				hukukAnaMenu.avukatanabuton.setEnabled(true);
			    hukukAnaMenu.yardimanabuton.setEnabled(true);
			    hukukAnaMenu.muvekkilanabuton.setEnabled(true);
			    hukukAnaMenu.kullanicianabuton.setEnabled(true);
			    hukukAnaMenu.personelanabuton.setEnabled(true);
			    hukukAnaMenu.burobilgianabuton.setEnabled(true);
			    hukukAnaMenu.cikisbuton.setEnabled(true);
			    hukukAnaMenu.yardimbtn.setEnabled(true);
			    hukukAnaMenu.loganabuton.setEnabled(true);
			    hukukAnaMenu.hatirlatmabuton.setEnabled(true);
			    
				modelim.setRowCount(0);
				ResultSet rs1 = null;
				try 
				{
					
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					System.out.println("Baglanti saglandi");
					String listele="Select * From personelbilgi order by PersonelTC asc";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					System.out.println("Listeleme Basarili");
					while(rs1.next())
					{
						satirlar[0]=rs1.getString("PersonelTC");
						satirlar[1]=rs1.getString("PersonelAdSoyad");
						satirlar[2]=rs1.getString("PersonelMaasNET");
						satirlar[3]=rs1.getString("PersonelTelefon");
						satirlar[4]=rs1.getString("PersonelTipi");
						satirlar[5]=rs1.getString("PersonelEposta");
						satirlar[6]=rs1.getString("PersonelKayitTarihi");
						modelim.addRow(satirlar);
						
					}
					table.setModel(modelim); 
					table.updateUI();
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					
					//final TableColumn column = table.getColumnModel().getColumn(7);
					// column.setMinWidth(0);
	                // column.setMaxWidth(0);
	                // column.setWidth(0);
	                // column.setPreferredWidth(0);
	                // column.setResizable(false);
					}
				}catch(Exception hata)
				{
					System.err.println(hata);
				}

			}
		});
		
		JLabel lblmuvekkil = new JLabel("");
		lblmuvekkil.setHorizontalAlignment(SwingConstants.CENTER);
		lblmuvekkil.setOpaque(true);
		lblmuvekkil.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/Groups-Meeting-Dark-icon.png")).getImage();
		lblmuvekkil.setIcon(new ImageIcon(img));
		lblmuvekkil.setBounds(10, 48, 224, 320);
		contentPane.add(lblmuvekkil);
		
		JLabel lblmuvekkilislemleri = new JLabel("Personel Ana Ekrani");
		lblmuvekkilislemleri.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblmuvekkilislemleri.setBounds(10, 11, 306, 26);
		contentPane.add(lblmuvekkilislemleri);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvazgec.setBounds(833, 338, 100, 30);
		contentPane.add(btnvazgec);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
			
				hukukPersonelekleduzenle frame = new hukukPersonelekleduzenle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR				

			}
				else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnekle.setBounds(244, 338, 100, 30);
		contentPane.add(btnekle);
		
		JButton btnsil = new JButton("Sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
				String tut_TC = table.getValueAt(table.getSelectedRow(),0).toString();
				String tut_ad = table.getValueAt(table.getSelectedRow(),1).toString();
				int selectedOption = JOptionPane.showConfirmDialog(null,tut_ad+" Silmek istediginizden emin misiniz?","sil",JOptionPane.YES_NO_OPTION); 
				if (selectedOption == JOptionPane.YES_OPTION)
				{
					
					try {
						myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
						java.sql.Statement statement = myconn1.createStatement();
						String sorgu_sil="Delete from personelbilgi where PersonelTC='"+tut_TC+"'";
						statement.executeUpdate(sorgu_sil);
						JOptionPane.showMessageDialog(null,tut_ad+" silindi");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
				}
				
			 }
			 catch(Exception hata)
				{
				 JOptionPane.showMessageDialog(null,"1 satir seçiniz");
					System.err.println(hata);
				}
			         
			}
				else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}}
		});
		btnsil.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsil.setBounds(464, 338, 100, 30);
		contentPane.add(btnsil);
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU

				 try {
					 tc = table.getValueAt(table.getSelectedRow(),0).toString();
					 
						System.out.println(tc);
					
						hukukPersonelekleduzenle form = new hukukPersonelekleduzenle();
						form.setVisible(true);
						form.setLocationRelativeTo(null);
						//dispose();
						 
				 } 
				 catch(Exception hata)
					{
					 JOptionPane.showMessageDialog(null,"1 satir seçiniz");
						System.err.println(hata);
					}
			
			}		else {
				//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
				Object [] noSaveOption = {"Tamam"};
				int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
			}
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnduzenle.setBounds(354, 338, 100, 30);
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
		txtisim.setBounds(244, 298, 569, 30);
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
		btnara.setBounds(833, 297, 100, 30);
		contentPane.add(btnara);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//RAPOR ALMA ISLEMI
				hukukPersonelbilgirapor_cagir rapor = new hukukPersonelbilgirapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),0).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRapor.setBounds(574, 338, 100, 30);
		contentPane.add(btnRapor);
		
		JButton btnYardim = new JButton("Yardim");
		btnYardim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					///// YARDIM KILAVUZU ONLINE			
					//String FILE = "D:/Hukukyardim.pdf";
					String FILE = hukukBaglanti.kullanimpdf; //Online Kullanim Kilavuzumuz
					
					try {
						if (new URL(FILE) != null) {
							Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + FILE);
							p.waitFor();
						} else {
							System.out.println("Dosya Bulunamadi");
						}
						System.out.println("Basarili");
					} catch (Exception ex) {
						ex.printStackTrace();
					}


					//YARDIM KILAVUZU ONLINE
			}
		});
		btnYardim.setFont(new Font("Tahoma", Font.BOLD, 13));
		Image  img5=new ImageIcon(this.getClass().getResource("/yardim12pix.png")).getImage();
		btnYardim.setIcon(new ImageIcon(img5));
		btnYardim.setBounds(684, 338, 129, 30);
		contentPane.add(btnYardim);
		
		JScrollPane veritablosu = new JScrollPane();
		veritablosu.setAutoscrolls(true);
		veritablosu.setBounds(244, 48, 689, 229);
		contentPane.add(veritablosu);
		
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		veritablosu.setViewportView(table);
		modelim.setColumnIdentifiers(kolonlar);
	}
}
