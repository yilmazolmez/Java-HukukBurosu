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
import java.net.URL;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//public class hukukBurobilgiana extends JFrame {
public class hukukBurobilgiana extends JDialog {
	static Connection myconn1;
	static Statement mystat1;
	private JPanel contentPane;
	private JTextField txtisim;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private JTable table;
	public static int id=0;
	public static int id_sakla=0;
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"Buro Unvan","Buro Ortak1","Buro Aciklama","Buro Vergi Dairesi","ID"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[5]; //SATIR TANIMLAMA
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukBurobilgiana frame = new hukukBurobilgiana();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public hukukBurobilgiana() {
		setModal(true);
		setResizable(false);
		setTitle("Buro ve Sube Buro Bilgileri Ekrani");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 952, 330);
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
					System.out.println("Baðlantý Saðlandý");
					String listele="Select * From burobilgi";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					System.out.println("Listeleme Basarili");
					while(rs1.next())
					{
						satirlar[0]=rs1.getString("BuroUnvani");
						satirlar[1]=rs1.getString("BuroOrtak1");
						satirlar[2]=rs1.getString("BuroAciklama");
						satirlar[3]=rs1.getString("BuroVergiDairesi");
						satirlar[4]=rs1.getString("BuroID");
						modelim.addRow(satirlar);
						
					}
					table.setModel(modelim);
					table.updateUI();
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				//Id'yi saklýyorum ama týklayýnca deðiþkende tutabiliyorum.	 
					final TableColumn column = table.getColumnModel().getColumn(4);
					 column.setMinWidth(0);
	                 column.setMaxWidth(0);
	                 column.setWidth(0);
	                 column.setPreferredWidth(0);
	                 column.setResizable(false);
				
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
		Image  img=new ImageIcon(this.getClass().getResource("/office-women-pink-icon (1).png")).getImage();
		lblmuvekkil.setIcon(new ImageIcon(img));
		lblmuvekkil.setBounds(10, 48, 156, 232);
		contentPane.add(lblmuvekkil);
		
		JLabel lblmuvekkilislemleri = new JLabel("Buro ve Sube Buro Bilgileri Ekrani");
		lblmuvekkilislemleri.setHorizontalAlignment(SwingConstants.LEFT);
		lblmuvekkilislemleri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblmuvekkilislemleri.setBounds(10, 11, 380, 26);
		contentPane.add(lblmuvekkilislemleri);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvazgec.setBounds(823, 250, 100, 30);
		contentPane.add(btnvazgec);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				hukukBurobilgiekleduzenle frame = new hukukBurobilgiekleduzenle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR	
				//dispose();
			}else {
				//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
				Object [] noSaveOption = {"Tamam"};
				int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
			}}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnekle.setBounds(176, 250, 100, 30);
		contentPane.add(btnekle);
		
		JButton btnsil = new JButton("Sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
	
				try {
				String tut_id = table.getValueAt(table.getSelectedRow(),4).toString();
				String tut_ad = table.getValueAt(table.getSelectedRow(),0).toString();
				int selectedOption = JOptionPane.showConfirmDialog(null,tut_ad+" Silmek istiyor musunuz?","SÝL",JOptionPane.YES_NO_OPTION); 
				if (selectedOption == JOptionPane.YES_OPTION)
				{
					
					try {
						myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
						Statement statement = myconn1.createStatement();
						String sorgu_sil="Delete from burobilgi where BuroID='"+tut_id+"'";
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
				 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
					System.err.println(hata);
				}
				}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}		
					
					
			 
			         
			}
		});
		btnsil.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsil.setBounds(401, 250, 100, 30);
		contentPane.add(btnsil);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(176, 48, 747, 153);
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
					 id = Integer.parseInt(table.getValueAt(table.getSelectedRow(),4).toString());
						System.out.println(id);
						hukukBurobilgiekleduzenle form = new hukukBurobilgiekleduzenle();
						form.setVisible(true);
						form.setLocationRelativeTo(null);
						//dispose();
						 
				 }
				 catch(Exception hata)
					{
					 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						System.err.println(hata);
					}
					
					

			
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnduzenle.setBounds(290, 250, 100, 30);
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
		txtisim.setBounds(176, 212, 601, 30);
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
		btnara.setBounds(823, 212, 100, 30);
		contentPane.add(btnara);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//RAPOR ALMA ISLEMI
				hukukBurobilgirapor_cagir rapor = new hukukBurobilgirapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),4).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRapor.setBounds(511, 250, 126, 30);
		contentPane.add(btnRapor);
		
		JButton btnsil_1_1 = new JButton("Yardim");
		btnsil_1_1.addActionListener(new ActionListener() {
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
		btnsil_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		Image  img5=new ImageIcon(this.getClass().getResource("/yardim12pix.png")).getImage();
		btnsil_1_1.setIcon(new ImageIcon(img5));
		btnsil_1_1.setBounds(647, 250, 130, 30);
		contentPane.add(btnsil_1_1);
		
	
	}
}


