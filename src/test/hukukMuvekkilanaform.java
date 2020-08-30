package test;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


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
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//public class hukukMuvekkilanaform extends JFrame {
public class hukukMuvekkilanaform extends JDialog {

	//public static int id=0;
	//public static int id_sakla=0;
	public static String id="0";
	public static String id_sakla="0";
	public static String id1;
	public static String id2;
	
	static Connection myconn1;
	static Statement mystat1;
	private JPanel contentPane;
	private JTextField txtisim;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"Müvekkil TC","Ad","Soyad","Telefon","Avukati"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[5]; //SATIR TANIMLAMA
	private JTextField control;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					hukukMuvekkilanaform frame = new hukukMuvekkilanaform();
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
	public hukukMuvekkilanaform() {
		setModal(true);
		setResizable(false);
		setTitle("Muvekkil Ana Ekrani");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1186, 584);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240,240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		addWindowListener(new WindowAdapter() {
			
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
				ResultSet rs = null;
				try {
					System.out.println(hukukBaglanti.sunucuparametresi);
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					String listele = "select * from muvekkilbilgi";
					mystat1=myconn1.createStatement();
					rs=mystat1.executeQuery(listele);
					while(rs.next()) {
						 
						satirlar[0]=rs.getString("MuvekkilTC");
						satirlar[1]=rs.getString("MuvekkilAdi");
						satirlar[2]=rs.getString("MuvekkilSoyadi");
						satirlar[3]=rs.getString("MuvekkilTelefon");
						satirlar[4]=rs.getString("MuvekkilAvukat");
						modelim.addRow(satirlar);
					}
					table.setModel(modelim);
					table.updateUI();
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		
		
		
		JLabel lblmuvekkil = new JLabel("");
		lblmuvekkil.setBounds(10, 58, 140, 473);
		lblmuvekkil.setHorizontalAlignment(SwingConstants.CENTER);
		lblmuvekkil.setOpaque(true);
		lblmuvekkil.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/Jury-Law-icon.png")).getImage();
		contentPane.setLayout(null);
		lblmuvekkil.setIcon(new ImageIcon(img));
		contentPane.add(lblmuvekkil);
		
		JLabel lblmuvekkilislemleri = new JLabel("Muvekkil Ana Ekrani");
		lblmuvekkilislemleri.setBounds(10, 11, 392, 26);
		lblmuvekkilislemleri.setHorizontalAlignment(SwingConstants.LEFT);
		lblmuvekkilislemleri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblmuvekkilislemleri);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.setBounds(1003, 453, 150, 78);
		btnvazgec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnvazgec);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.setBounds(160, 412, 156, 30);
		btnekle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				hukukMuvekkilekleduzenle frame;
				try {
					frame = new hukukMuvekkilekleduzenle();
					frame.show();
					frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
					//dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnekle);
		
		JButton btnsil = new JButton("Sil");
		btnsil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					
					String tut_tc = table.getValueAt(table.getSelectedRow(),0).toString();
					String tut_ad = table.getValueAt(table.getSelectedRow(),1).toString();
					int selectedOption = JOptionPane.showConfirmDialog(null,tut_ad+" Silmek istiyor musunuz?","SÝL",JOptionPane.YES_NO_OPTION); 
					if (selectedOption == JOptionPane.YES_OPTION)
					{
						try {
							System.out.println(hukukBaglanti.sunucuparametresi);
							myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
							Statement statement = myconn1.createStatement();
							String sil = "delete from muvekkilbilgi where MuvekkilTC='"+tut_tc+"'";
							statement.executeUpdate(sil);
							JOptionPane.showMessageDialog(null,tut_ad+" silindi");
	
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							
							e1.printStackTrace();
						}
	
					}
				}catch(Exception hata)
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
		btnsil.setBounds(489, 412, 156, 30);
		btnsil.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnsil);
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					
			
				try {
					//id = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
					id = (table.getValueAt(table.getSelectedRow(),0).toString());
					 System.out.println(id);
					hukukMuvekkilekleduzenle form= new hukukMuvekkilekleduzenle();
					form.show();
					form.setLocationRelativeTo(null);
					//dispose();
				}catch(Exception hata)
				{
					 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						System.err.println(hata);
					}
					
			}
		});
		btnduzenle.setBounds(323, 412, 156, 30);
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnduzenle);
		
		txtisim = new JTextField();
		txtisim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

			}
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
			@Override
			public void keyPressed(KeyEvent e) {
				

			}
		});
		txtisim.setBounds(160, 371, 818, 30);
		contentPane.add(txtisim);
		txtisim.setColumns(10);
		
		JButton btnara = new JButton("Ara");
		btnara.addActionListener(new ActionListener() {
			@Override
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
		btnara.setBounds(1003, 372, 150, 30);
		btnara.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnara);
		
		JButton btnCariHareketleri = new JButton("Cari Hareket");
		btnCariHareketleri.setBounds(160, 453, 156, 78);
		btnCariHareketleri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
	
				if (table.getRowCount()>0) {
				id2=table.getValueAt(table.getSelectedRow(),0).toString();
				if (id2.equals(null)){System.out.println("Secim yapmadiniz");} else {
				hukukMuvekkilcarihareketler frame = new hukukMuvekkilcarihareketler();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				}}
				}catch(Exception hata)
				{
					 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						System.err.println(hata);
					}
			}
		});
		btnCariHareketleri.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnCariHareketleri);
		
		JButton btnduzenle_1_1 = new JButton("Dava Hareket");
		btnduzenle_1_1.setBounds(323, 453, 156, 78);
		btnduzenle_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
				if (table.getRowCount()>0) {
				id2=table.getValueAt(table.getSelectedRow(),0).toString();
				if (id2.equals(null)){System.out.println("Secim yapmadiniz");} else {
				hukukMuvekkildavahareketleri frame = new hukukMuvekkildavahareketleri();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}}}catch(Exception hata)
			{
				 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
					System.err.println(hata);
				}}
		});
		btnduzenle_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnduzenle_1_1);
		
		JButton btnduzenle_1_2 = new JButton("Hukuki Hareket");
		btnduzenle_1_2.setBounds(489, 453, 156, 78);
		btnduzenle_1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				if (table.getRowCount()>0) {
				id2=table.getValueAt(table.getSelectedRow(),0).toString();
				if (id2.equals(null)){System.out.println("Secim yapmadiniz");} else {
				hukukMuvekkilhukukihareketler frame = new hukukMuvekkilhukukihareketler();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				}
			}
				}catch(Exception hata)
				{
					 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						System.err.println(hata);
					}
			}
		});
		btnduzenle_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnduzenle_1_2);
		
		JButton btnduzenle_1_3 = new JButton("Ozel Hareket");
		btnduzenle_1_3.setBounds(656, 453, 156, 78);
		btnduzenle_1_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				if (table.getRowCount()>0) {
				id2=table.getValueAt(table.getSelectedRow(),0).toString();
				if (id2.equals(null)){System.out.println("Secim yapmadiniz");} else {
				hukukMuvekkilozelhareketler frame = new hukukMuvekkilozelhareketler();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}}
				}catch(Exception hata)
				{
					 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						System.err.println(hata);
					}
				}
		});
		btnduzenle_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnduzenle_1_3);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RAPOR ALMA ISLEMI
				hukukMuvekkilbilgirapor_cagir rapor = new hukukMuvekkilbilgirapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),0).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setBounds(656, 412, 156, 30);
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 14));
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
		btnYardim.setBounds(822, 412, 156, 30);
		Image  img5=new ImageIcon(this.getClass().getResource("/yardim12pix.png")).getImage();
		btnYardim.setIcon(new ImageIcon(img5));
		btnYardim.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnYardim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 58, 993, 304);
		contentPane.add(scrollPane);
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		
		
		JButton btnduzenle_1_3_1 = new JButton("Davali Bilgisi");
		btnduzenle_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if (table.getRowCount()>0) {
				id1=table.getValueAt(table.getSelectedRow(),0).toString();
				if (id1.equals(null)){System.out.println("Secim yapmadiniz");} else {
				hukukMuvekkildavalilistesi frame = new hukukMuvekkildavalilistesi();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				
			}}}catch(Exception hata)
				{
				 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
					System.err.println(hata);
				}
				}
		});
		btnduzenle_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle_1_3_1.setBounds(822, 453, 156, 78);
		contentPane.add(btnduzenle_1_3_1);
		modelim.setColumnIdentifiers(kolonlar);
	}
}

