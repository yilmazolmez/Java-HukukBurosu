package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class hukukMuvekkildavahareketekle extends JDialog {

	private JPanel contentPane;
	private JTextField txtdavamahkemesi;
	private JTextField txtdosyano;
	private JTextField txtavukat;
	private JTextField txtdavatipi;
	private JTextField txtkonu;
	private JTextField txtacilistarihi;
	private JTextField txtdurusmatarihi;
	private JTextField txtdurusmasaati;
	private JTextField txtkararneyedair;
	private JTextField txtkarartarihi;
	private JTextField txtkararesasno;
	private JTextField txttebligtarihi;
	private JTextField txttemyiztarihi;
	private JTextField txthatirlat;
	private JTextField txtmuvekkiltc;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JComboBox davadurumu;
	private JComboBox comboBox_avukat;
	
	static Connection myconn,myconna;
	static Statement mystat,mystata,mystata1;
	private JTextField hakedistxt;
	private JTextField davanotxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukMuvekkildavahareketekle frame = new hukukMuvekkildavahareketekle();
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
	public hukukMuvekkildavahareketekle() {
		setResizable(false);
		setModal(true);
		setTitle("Muvekkil Dava Hareketi Ekle / Duzenle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 943, 480);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		Image img = new ImageIcon(this.getClass().getResource("/auction-hammer-icon (1).png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 50, 263, 370);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Muvekkil Dava Hareketi Ekle / Duzenle");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 10, 365, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dava Mahkemesi:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(283, 107, 130, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dosya No:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(283, 137, 79, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("Dava Avukati:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(283, 167, 114, 14);
		contentPane.add(lblNewLabel_7);
		
		txtdavamahkemesi = new JTextField();
		txtdavamahkemesi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtdosyano.requestFocus();
				}
			}
		});
		txtdavamahkemesi.setText("Sulh Ceza");
		txtdavamahkemesi.setBounds(423, 107, 144, 20);
		contentPane.add(txtdavamahkemesi);
		txtdavamahkemesi.setColumns(10);
		
		txtdosyano = new JTextField();
		txtdosyano.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboBox_avukat.requestFocus();
				}
			}
		});
		txtdosyano.setText("00000");
		txtdosyano.setBounds(423, 137, 144, 20);
		contentPane.add(txtdosyano);
		txtdosyano.setColumns(10);
		
	
		JLabel lblNewLabel_4 = new JLabel("Konu:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(283, 197, 90, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Dava Tipi:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(283, 227, 79, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Muvekkil TC:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(283, 77, 89, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Temyiz Karari:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(283, 257, 106, 14);
		contentPane.add(lblNewLabel_8);
		
		txtdavatipi = new JTextField();
		txtdavatipi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textArea.requestFocus();
				}
			}
		});
		txtdavatipi.setBounds(423, 227, 144, 20);
		contentPane.add(txtdavatipi);
		txtdavatipi.setColumns(10);
		
		JLabel lblNewLabel_9_1_1_2_2 = new JLabel("Hakedis :");
		lblNewLabel_9_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_1_1_2_2.setBounds(603, 350, 106, 14);
		contentPane.add(lblNewLabel_9_1_1_2_2);
		
		hakedistxt = new JTextField();
		hakedistxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (hakedistxt.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtdavamahkemesi.requestFocus();
				}
			}
		});
		hakedistxt.setHorizontalAlignment(SwingConstants.RIGHT);
		hakedistxt.setText("0.00");
		hakedistxt.setColumns(10);
		hakedistxt.setBounds(739, 350, 173, 20);
		contentPane.add(hakedistxt);
		
		txtkonu = new JTextField();
		txtkonu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtdavatipi.requestFocus();
				}
			}
		});
		txtkonu.setBounds(423, 197, 144, 20);
		contentPane.add(txtkonu);
		txtkonu.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Acilis Tarihi:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(603, 50, 100, 14);
		contentPane.add(lblNewLabel_9);
		
	    JDateChooser txtacilistarihi = new JDateChooser();
	    txtacilistarihi.setBounds(739, 50, 173, 20);
	    txtacilistarihi.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txtacilistarihi);
		
		
		//txtacilistarihi = new JTextField();
		//txtacilistarihi.setBounds(739, 50, 173, 20);
		//contentPane.add(txtacilistarihi);
		//txtacilistarihi.setColumns(10);
		
		JLabel lblNewLabel_9_1 = new JLabel("Durusma Tarihi:");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_1.setBounds(603, 80, 106, 14);
		contentPane.add(lblNewLabel_9_1);
		
	    JDateChooser txtdurusmatarihi = new JDateChooser();
	    txtdurusmatarihi.setBounds(739, 80, 173, 20);
	    txtdurusmatarihi.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txtdurusmatarihi);
		
		//txtdurusmatarihi = new JTextField();
		//txtdurusmatarihi.setColumns(10);
		//txtdurusmatarihi.setBounds(739, 80, 173, 20);
		//contentPane.add(txtdurusmatarihi);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Karar Neye Dair:");
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_1_1.setBounds(603, 140, 106, 14);
		contentPane.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_1_2 = new JLabel("Durusma Saati:");
		lblNewLabel_9_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_1_2.setBounds(603, 110, 106, 14);
		contentPane.add(lblNewLabel_9_1_2);
		
		txtdurusmasaati = new JTextField();
		txtdurusmasaati.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtkararneyedair.requestFocus();
				}
			}
		});
		txtdurusmasaati.setText("00:00");
		txtdurusmasaati.setColumns(10);
		txtdurusmasaati.setBounds(739, 110, 173, 20);
		contentPane.add(txtdurusmasaati);
		
		txtkararneyedair = new JTextField();
		txtkararneyedair.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtkararesasno.requestFocus();
				}
			}
		});
		txtkararneyedair.setColumns(10);
		txtkararneyedair.setBounds(739, 140, 173, 20);
		contentPane.add(txtkararneyedair);
		
	    JDateChooser txtkarartarihi = new JDateChooser();
	    txtkarartarihi.setBounds(739, 170, 173, 20);
	    txtkarartarihi.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txtkarartarihi);
		
		//txtkarartarihi = new JTextField();
		//txtkarartarihi.setColumns(10);
		//txtkarartarihi.setBounds(739, 170, 173, 20);
		//contentPane.add(txtkarartarihi);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("Karar Tarihi:");
		lblNewLabel_9_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_1_1_1.setBounds(603, 170, 106, 14);
		contentPane.add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_9_1_1_2 = new JLabel("Karar Esas No:");
		lblNewLabel_9_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_1_1_2.setBounds(603, 200, 106, 14);
		contentPane.add(lblNewLabel_9_1_1_2);
		
		txtkararesasno = new JTextField();
		txtkararesasno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					davadurumu.requestFocus();
				}
			}
		});
		txtkararesasno.setText("00000");
		txtkararesasno.setColumns(10);
		txtkararesasno.setBounds(739, 200, 173, 20);
		contentPane.add(txtkararesasno);
		
		JLabel lblNewLabel_9_1_1_2_1 = new JLabel("Teblig Tarihi:");
		lblNewLabel_9_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_1_1_2_1.setBounds(603, 230, 114, 14);
		contentPane.add(lblNewLabel_9_1_1_2_1);
		
	    JDateChooser txttebligtarihi = new JDateChooser();
	    txttebligtarihi.setBounds(739, 230, 173, 20);
	    txttebligtarihi.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txttebligtarihi);
		
		//txttebligtarihi = new JTextField();
		//txttebligtarihi.setBounds(739, 230, 173, 20);
		//contentPane.add(txttebligtarihi);
		//txttebligtarihi.setColumns(10);
		
		JLabel lblNewLabel_9_1_1_2_1_1 = new JLabel("Temyiz Tarihi:");
		lblNewLabel_9_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_1_1_2_1_1.setBounds(603, 260, 90, 14);
		contentPane.add(lblNewLabel_9_1_1_2_1_1);
		
	    JDateChooser txttemyiztarihi = new JDateChooser();
	    txttemyiztarihi.setBounds(739, 260, 173, 20);
	    txttemyiztarihi.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txttemyiztarihi);
		
		//txttemyiztarihi = new JTextField();
		//txttemyiztarihi.setColumns(10);
		//txttemyiztarihi.setBounds(739, 260, 173, 20);
		//contentPane.add(txttemyiztarihi);
		
		JLabel lblNewLabel_8_1 = new JLabel("Aciklama:");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8_1.setBounds(283, 315, 106, 14);
		contentPane.add(lblNewLabel_8_1);
		
		/*JTextArea textArea_davaaciklama = new JTextArea();
		textArea_davaaciklama.setBounds(423, 288, 144, 47);
		contentPane.add(textArea_davaaciklama);*/
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Dava Son Durumu:");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8_1_1.setBounds(603, 290, 126, 14);
		contentPane.add(lblNewLabel_8_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Hatirlat:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1.setBounds(603, 320, 79, 14);
		contentPane.add(lblNewLabel_7_1);
		
	    JDateChooser txthatirlat = new JDateChooser();
	    txthatirlat.setBounds(739, 320, 173, 20);
	    txthatirlat.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txthatirlat);
		
		//txthatirlat = new JTextField();
		//txthatirlat.setColumns(10);
		//txthatirlat.setBounds(739, 324, 173, 20);
		//contentPane.add(txthatirlat);
		
		txtmuvekkiltc = new JTextField();
		txtmuvekkiltc.setEnabled(false);
		txtmuvekkiltc.setEditable(false);
		txtmuvekkiltc.setBounds(423, 76, 144, 20);
		contentPane.add(txtmuvekkiltc);
		txtmuvekkiltc.setColumns(10);
		
		JComboBox davadurumu = new JComboBox();
		davadurumu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hakedistxt.requestFocus();
				}
			}
		});
		davadurumu.setModel(new DefaultComboBoxModel(new String[] {"ARA KARAR VERILDI", "KARAR VERILDI", "ERTELENDI", "DAVA DUSTU", "TEMYIZE GONDERILDI"}));
		davadurumu.setSelectedIndex(0);
		davadurumu.setBounds(739, 290, 173, 22);
		contentPane.add(davadurumu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(423, 257, 144, 49);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textArea_1.requestFocus();
				}
			}
		});
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(423, 315, 144, 49);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtdurusmasaati.requestFocus();
				}
			}
		});
		scrollPane_1.setViewportView(textArea_1);
	
		
		//txtavukat = new JTextField();
		//txtavukat.setBounds(423, 140, 144, 20);
		//contentPane.add(txtavukat);
		//txtavukat.setColumns(10);
		
	     //AVUKATI COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
	      comboBox_avukat = new JComboBox();
	      comboBox_avukat.addKeyListener(new KeyAdapter() {
	      	@Override
	      	public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtkonu.requestFocus();
				}
	      	}
	      });
	      comboBox_avukat.setBounds(423, 167, 144, 20);
	      contentPane.add(comboBox_avukat);
		  //AVUKATI COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement mystata eklemeyi unutma
				ResultSet rsa = null;
				ResultSet rsa1 = null;
				comboBox_avukat.removeAllItems();//bunu yapmazsam her hata mesajýndan sonra tekrar
				                                  //avukatlarý üst üste ekliyor
				
				String tcal=hukukMuvekkildavahareketleri.id_al;
				txtmuvekkiltc.setText(tcal);
				System.out.println(tcal);
				
				int id_al=hukukMuvekkildavahareketleri.id;
				//hukukMuvekkildavahareketleri.id=0;
				ResultSet rs = null;
				//hukukBaglanti baglanti = null;
				try {
					
					myconna=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					String listele_avukat="Select * From avukatbilgi";
					mystata=myconna.createStatement();
					mystata1=myconna.createStatement();

					rsa=mystata.executeQuery(listele_avukat);
					rsa1=mystata1.executeQuery(listele_avukat);

					while(rsa.next())
					{  //veritabanýndaki avukat ad ve soyadlar otomatik combobox'a geliyor. //Ve öyle ekletiyoruz veritabanýna
						comboBox_avukat.addItem(rsa.getString("AvukatAd")+" "+rsa.getString("AvukatSoyad"));
						
					}
					//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement mystata eklemeyi unutma
					
					
					myconn=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					String listele="Select * From muvekkildavahareket where DavaNo='"+id_al+"'";
					//System.out.println("String listele=\"Select * From burobilgi where BuroID='\"+id_al+\"'\";");
					mystat=myconn.createStatement();
					rs=mystat.executeQuery(listele);
					if(rs.next())
					{
						txtmuvekkiltc.setText(rs.getString("MuvekkilTC"));
						txtdavamahkemesi.setText(rs.getString("DavaMahkemesi"));
						txtdosyano.setText(rs.getString("DosyaNo"));
						//txtavukat.setText(rs.getString("DavaAvukati"));
						comboBox_avukat.setSelectedItem(rs.getString("DavaAvukati"));
						txtkonu.setText(rs.getString("DavaKonusu"));
						txtdavatipi.setText(rs.getString("DavaTipi"));
						davanotxt.setText(rs.getString("DavaNo"));
						txtacilistarihi.setDate(rs.getDate("DavaninAcilisTarihi"));
						txtdurusmatarihi.setDate(rs.getDate("DurusmaTarihi"));
						txtdurusmasaati.setText(rs.getString("DurusmaSaati"));
						txtkararneyedair.setText(rs.getString("KararNeyeDair"));
						txtkarartarihi.setDate(rs.getDate("KararTarihi"));
						txtkararesasno.setText(rs.getString("KararEsasNo"));
						txttebligtarihi.setDate(rs.getDate("KararTebligTarihi"));
						txttemyiztarihi.setDate(rs.getDate("TemyizTarihi"));
						davadurumu.setSelectedItem(rs.getString("Davasondurum")); //POTANSÝYEL HATA
						txthatirlat.setDate(rs.getDate("hatirlat"));
						textArea.setText(rs.getString("TemyizSonucu"));
						textArea_1.setText(rs.getString("Aciklama"));
						hakedistxt.setText(rs.getString("hakedis"));
						hukukMuvekkildavahareketleri.id_sakla=hukukMuvekkildavahareketleri.id;
						hukukMuvekkildavahareketleri.id=0;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		

		
		JButton btnNewButton_2 = new JButton("Vazgec");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
		
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						//hukukMuvekkildavahareketleri ornek= new hukukMuvekkildavahareketleri();
						//ornek.setVisible(true);
						
				}
		});
	
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(812, 390, 100, 30);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_6_1 = new JLabel("Dava No:");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(283, 51, 89, 14);
		contentPane.add(lblNewLabel_6_1);
		
		davanotxt = new JTextField();
		davanotxt.setEnabled(false);
		davanotxt.setEditable(false);
		davanotxt.setColumns(10);
		davanotxt.setBounds(423, 50, 144, 20);
		contentPane.add(davanotxt);
		

		

		
		JButton btnNewButton_kaydet = new JButton("Kaydet");
		btnNewButton_kaydet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tcal=hukukMuvekkildavahareketleri.id_al,tarih1,tarih2,tarih3,tarih4,tarih5,tarih6,davamahkemesi,dosyano,avukat,konu,tipi,durusmasaati, kararneyedair, kararesasno, temyizsonucu, muvekkiltc, davasondurum, davaaciklama, hatirlat;//TCNUMARASINI ALIYOR
				txtmuvekkiltc.setText(tcal);
				
				//String davamahkemesi,dosyano,avukat,konu,tipi,durusmasaati, kararneyedair,  kararesasno, tebligtarihi, temyiztarihi, temyizsonucu, muvekkiltc, davasondurum, davaaciklama, hatirlat;
				Date date =new Date();
				if (txtacilistarihi.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih1=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih1=sdf.format(txtacilistarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih1);}


				if (txtdurusmatarihi.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(date);} 
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(txtdurusmatarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih2);}
				
				if (txtkarartarihi.getDate()==null){
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih3=sdf2.format(date);} 
				else {
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih3=sdf2.format(txtkarartarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih3);}
				
				if (txttebligtarihi.getDate()==null){
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih4=sdf3.format(date);} 
				else {
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih4=sdf3.format(txttebligtarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih4);}
				
				if (txttemyiztarihi.getDate()==null){
					SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih5=sdf4.format(date);} 
				else {
					SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih5=sdf4.format(txttemyiztarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih5);}
				
				if (txthatirlat.getDate()==null){
					SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih6=sdf5.format(date);} 
				else {
					SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih6=sdf5.format(txthatirlat.getDate());//TARIH FORMATLAMA
					System.out.println(tarih6);}
				
				
				davamahkemesi= txtdavamahkemesi.getText();
				dosyano= txtdosyano.getText();
				muvekkiltc= txtmuvekkiltc.getText();
				avukat= comboBox_avukat.getSelectedItem().toString();
				kararneyedair= txtkararneyedair.getText();
				konu= txtkonu.getText();
				tipi= txtdavatipi.getText();
				durusmasaati= txtdurusmasaati.getText();
				kararesasno= txtkararesasno.getText();
				temyizsonucu= textArea.getText();
				davaaciklama= textArea_1.getText();
				davasondurum=davadurumu.getSelectedItem().toString();
			
				if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
				//PreparedStatement st;
			
				String query="INSERT INTO muvekkildavahareket(DavaMahkemesi,DosyaNo,DavaAvukati,DavaKonusu,DavaTipi,DavaninAcilisTarihi,DurusmaTarihi,DurusmaSaati,KararNeyeDair,KararTarihi,KararEsasNo,KararTebligTarihi,TemyizTarihi,TemyizSonucu,MuvekkilTC,Davasondurum,Aciklama,hatirlat,hakedis)VALUES('"
					+ davamahkemesi + "', '"+ dosyano+ "','"+ avukat + "', '" + konu +"','" +tipi + "','" +tarih1 + "','" +tarih2  + "','" +durusmasaati+ "','" +kararneyedair+ "','" +tarih3+"','"+kararesasno +"','"+tarih4 +"','"+tarih5 +"','"+temyizsonucu +"','"+muvekkiltc +"','"+davasondurum +"','"+davaaciklama +"','"+tarih6 + "','"+hakedistxt.getText() + "')";
				try {
					myconn=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					mystat=myconn.createStatement();
					mystat.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Hakedis var ise Cari Hareketlere ayrýca iþleyiniz.. Islem Basarýlý");
					dispose();
					System.out.println("Ekleme Basarili");

					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton_kaydet.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_kaydet.setBounds(565, 390, 100, 30);
		//contentPane.add(btnNewButton_kaydet);
		
		
		JButton btnNewButton_2_1 = new JButton("Guncelle");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//String muvekkiltc,davamahkemesi, dosyano, avukat, konu, davatipi, temyizkarari, davaaciklama, acilistarihi, durusmatarihi, durusmasaati, kararneyedair, karartarihi, kararesasno, tebligtarihi,temyiztarihi,davasondurum, hatirlat;
				String tcal=hukukMuvekkildavahareketleri.id_al,tarih1,tarih2,tarih3,tarih4,tarih5,tarih6,davamahkemesi,dosyano,avukat,konu,tipi,durusmasaati, kararneyedair, kararesasno, temyizsonucu, muvekkiltc, davasondurum, davaaciklama, hatirlat;;//TCNUMARASINI ALIYOR
				txtmuvekkiltc.setText(tcal);
							
				muvekkiltc=txtmuvekkiltc.getText();
				davamahkemesi=txtdavamahkemesi.getText();
				dosyano=txtdosyano.getText();
				avukat= comboBox_avukat.getSelectedItem().toString();
				konu=txtkonu.getText();
				tipi=txtdavatipi.getText();
				temyizsonucu=textArea.getText();
				davaaciklama=textArea_1.getText();
				durusmasaati=txtdurusmasaati.getText();
				kararneyedair=txtkararneyedair.getText();
				kararesasno=txtkararesasno.getText();
				davasondurum=davadurumu.getSelectedItem().toString();
				Date date =new Date();
				if (txtacilistarihi.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih1=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih1=sdf.format(txtacilistarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih1);}


				if (txtdurusmatarihi.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(date);} 
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(txtdurusmatarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih2);}
				
				if (txtkarartarihi.getDate()==null){
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih3=sdf2.format(date);} 
				else {
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih3=sdf2.format(txtkarartarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih3);}
				
				if (txttebligtarihi.getDate()==null){
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih4=sdf3.format(date);} 
				else {
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih4=sdf3.format(txttebligtarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih4);}
				
				if (txttemyiztarihi.getDate()==null){
					SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih5=sdf4.format(date);} 
				else {
					SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih5=sdf4.format(txttemyiztarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih5);}
				
				if (txthatirlat.getDate()==null){
					SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih6=sdf5.format(date);} 
				else {
					SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih6=sdf5.format(txthatirlat.getDate());//TARIH FORMATLAMA
					System.out.println(tarih6);}
				
				if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
				
				if(davamahkemesi.equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					//System.out.println(buro_unvan+"\n "+buro_sehir+"  \n"+buro_postakodu+" \n"+buro_ilce+" \n"+buro_mail+"\n "+buro_vergidairesi+"\n "+buro_vergino+"\n "+buro_ortak1+" \n"+buro_ortak2+"\n "+buro_ortak3+"\n "+buro_ortak4+" \n"+buro_telefon+" \n"+buro_gsm+"\n "+buro_adres);
					//String sorgu_guncelle="update muvekkildavahareket set MuvekkilTC='"+muvekkiltc +"',DavaMahkemesi='"+davamahkemesi+"',DosyaNo='"+dosyano +"',DavaAvukati='"+avukat+"',DavaKonusu='"+konu+"',DavaTipi='"+tipi+"',TemyizSonuc='"+temyizsonucu+"',Davaaciklama='"+davaaciklama+"',DavaninAcilisTarihi='"+tarih1+"',DurusmaTarihi='"+tarih2+"',DurusmaSaati='"+durusmasaati+"',KararNeyeDair='"+kararneyedair+"',KararTarihi='"+tarih3+"',KararEsasNo='"+kararesasno+"',KararTebligTarihi='"+tarih4+"' ,Davasondurum='"+davasondurum+"',hatirlat='"+hatirlat+"' where DavaNo='"+hukukMuvekkildavahareketleri.id_sakla+"'";
					String sorgu_guncelle="update muvekkildavahareket set MuvekkilTC='"+muvekkiltc +"',DavaMahkemesi='"+davamahkemesi+"',DosyaNo='"+dosyano +"',DavaAvukati='"+avukat+"',DavaKonusu='"+konu+"',DavaTipi='"+tipi+"',TemyizSonucu='"+temyizsonucu+"',Aciklama='"+davaaciklama+"',DavaninAcilisTarihi='"+tarih1+"',DurusmaTarihi='"+tarih2+"',DurusmaSaati='"+durusmasaati+"',KararNeyeDair='"+kararneyedair+"',KararTarihi='"+tarih3+"',KararEsasNo='"+kararesasno+"',KararTebligTarihi='"+tarih4+"',TemyizTarihi='"+tarih5+"' ,Davasondurum='"+davasondurum+"',hakedis='"+hakedistxt.getText()+"',hatirlat='"+tarih6+"' where DavaNo='"+hukukMuvekkildavahareketleri.id_sakla+"'";
					try 
					{
						myconn = DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
						mystat=myconn.createStatement();
						mystat.executeUpdate(sorgu_guncelle);
						JOptionPane.showMessageDialog(null,"Hakedis var ise Cari Hareketlere ayrýca iþleyiniz..Guncelleme Basarili");
						 
						
						//hukukMuvekkildavahareketleri buro = new hukukMuvekkildavahareketleri();
						//buro.setVisible(true);
						//buro.setLocationRelativeTo(null);
						dispose();
						System.out.println("Duzenleme basarili.");

	
					}catch(Exception hata)
					{
						System.err.println(hata);
					}
				}
			}
			
		});
		
		
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2_1.setBounds(687, 390, 100, 30);
		//contentPane.add(btnNewButton_2_1);
		if(hukukMuvekkildavahareketleri.id==0)
		{
			contentPane.add(btnNewButton_kaydet);
		}
		else
		{
			contentPane.add(btnNewButton_2_1);
		}
		

		
	}
}
