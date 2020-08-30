package test;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Year;

import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class hukukAnaMenu extends JFrame {

	public JPanel contentPane;
	private JLabel versiyonlabel;
	private Label now;
	
	static Timer timer;//PROGRESS ICIN
	static Timer timer2;//YEDEK
	
	JDialog dialog = new JDialog();//YARDIM SAYFASI SHOWMODAL ICIN
	private JLabel online;

	private JTable table;//KULLANICI LOG TABLOSU ICIN
	static Connection myconn1;//KULLANICI LOG TABLOSU ICIN
	static Statement mystat1;//KULLANICI LOG TABLOSU ICIN
	
	public static JButton avukatanabuton;
	 public static JButton yardimanabuton;
	 public static JButton muvekkilanabuton;
	 public static JButton kullanicianabuton;
	 public static JButton personelanabuton;
	 public static JButton burobilgianabuton;
	 public static JButton cikisbuton;
	 public static JButton yardimbtn;
	 public static JButton loganabuton;
	 public static JButton hatirlatmabuton;
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	
	Object [] kolonlar = {"logislemid","logdatetime","logkullaniciadi","logkullaniciyetkisi","Aciklama"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[5]; //SATIR TANIMLAMA

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					hukukAnaMenu frame = new hukukAnaMenu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR 
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	

	
	

	//SAAT TARIH ve HATIRLATILACAKLAR FONKSIYONU//////////////////
	
	//SAAT TARIH ve HATIRLATILACAKLAR FONKSIYONU ///////////////////////7
	public void clock()
	{
		
		Label now = new Label("Tarih ve Saat");
		now.setAlignment(Label.CENTER);
		now.setBackground(Color.WHITE);
		now.setFont(new Font("Tahoma", Font.BOLD, 16));
		now.setBounds(13, 491, 1179, 24);
		contentPane.add(now);
		
//		List list = new List(); // AKAN LISTE ISTENIRSE EKLENEBILIR
//		list.setBackground(SystemColor.control);/ AKAN LISTE ISTENIRSE EKLENEBILIR
//		list.setForeground(new Color(0, 0, 0));/ AKAN LISTE ISTENIRSE EKLENEBILIR
//		list.setMultipleSelections(false);/ AKAN LISTE ISTENIRSE EKLENEBILIR
//		list.setFont(new Font("Arial", Font.PLAIN, 16));/ AKAN LISTE ISTENIRSE EKLENEBILIR
//		list.setBounds(10, 495, 1182, 94);/ AKAN LISTE ISTENIRSE EKLENEBILIR
//		contentPane.add(list);/ AKAN LISTE ISTENIRSE EKLENEBILIR
	
		Thread clock=new Thread() {
			
			public void run () {
				
				try {
					for(;;) {
						
					LocalDate now1 = LocalDate.now(); // 2014-04-05
					Calendar cal=new GregorianCalendar();
					
					int day1=now1.getDayOfMonth();
					int month1=now1.getMonthValue();
					int year1=now1.getYear();
					
					//int day=cal.get(Calendar.DAY_OF_MONTH);
					//int month=cal.get(Calendar.MONTH);
					//int year=cal.get(Calendar.YEAR);
										
					int second=cal.get(Calendar.SECOND);
					int minute=cal.get(Calendar.MINUTE);
					int hour=cal.get(Calendar.HOUR_OF_DAY);
					
					now.setText(day1+"-"+month1+"-"+year1+" "+hour+":"+minute+":"+second+"    "+"Anlik Kullanici Log Kayitlari");
				sleep(1000);
				
				///HATIRLATILACAKLAR PANOSU
	
				///HATIRLATILACAKLAR PANOSU

				}} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}
	
	//SAAT TARIH ve HATIRLATILACAKLAR FONKSIYONU//////////////////
	/////
	
	
	public hukukAnaMenu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				
				//LOGLAR GUNCELLENIYOR
				modelim.setRowCount(0);//TABLOYU TEMIZLIYOR
				//
		 		ResultSet rs1 = null;
				try {
					System.out.println(hukukBaglanti.sunucuparametresi);
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					System.out.println("Baðlantý Saðlandý");

					String query1="Select * From hukuklogislem order by islemid DESC ";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(query1);
					System.out.println("Listeleme Basarili");
				}catch(Exception hata)
				{
				System.err.println(hata);
				}
				//
				
				try {
				while(rs1.next()) {
					satirlar[0]=rs1.getString("islemid");
					satirlar[1]=rs1.getString("islemzamani");
					satirlar[2]=rs1.getString("kullaniciadi");
					satirlar[3]=rs1.getString("kullaniciyetki");
					satirlar[4]=rs1.getString("Aciklama");
					modelim.addRow(satirlar);
				}		
				}catch(SQLException hata)
				{
					System.err.println(hata);
					}
				table.setModel(modelim);
				table.updateUI();
				System.out.println("TOPLAM KAYIT: "+table.getRowCount());
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				
				//LOGLAR GUNCELLENIYOR
				
				
			}
			@Override
			public void windowClosed(WindowEvent e) {
				
				
			}
			@Override
			public void windowClosing(WindowEvent e) {
				hukukKayitsayitablosu frame = new hukukKayitsayitablosu();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}
		});

		setTitle("Hukuk Burosu Otomasyonu - ONline v. "+hukukBaglanti.versionuygulama+hukukBaglanti.versiondb +"- Ana Menu");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1216, 715);
		setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		clock();//SAATI GOSTERME
		
		
		//KULLANICI LOG TABLOSU EKLEME
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 521, 1179, 100);
		contentPane.add(scrollPane);
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setBackground(Color.BLACK);
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(table);
		
		//KULLANICI LOG TABLOSU EKLEME
		
		//HATIRLATMA EKRANINI YALNIZCA KAYIT OLUP OLMAMASI OPSIYONUNA CEVIREBILIRIZ
		hukukHatirlatmapopup frame = new hukukHatirlatmapopup();
		frame.show();
		frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
		//
		//HATIRLATMA EKRANINI YALNIZCA KAYIT OLUP OLMAMASI OPSIYONUNA CEVIREBILIRIZ
		
		
		
		muvekkilanabuton = new JButton("1-) Muvekkil Islemleri");
		muvekkilanabuton.setHorizontalAlignment(SwingConstants.LEFT);
		muvekkilanabuton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				avukatanabuton.setEnabled(false);
			    yardimanabuton.setEnabled(false);
			    muvekkilanabuton.setEnabled(false);
			    kullanicianabuton.setEnabled(false);
			    personelanabuton.setEnabled(false);
			    burobilgianabuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbtn.setEnabled(false);
			    loganabuton.setEnabled(false);
			    hatirlatmabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1180, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Muvekkil Ana Ekranýna gitti...";
							String sorgu_kaydet="insert into hukuklogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+hukukBaglanti.logkullaniciadi+"','"+hukukBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							hukukBaglanti baglan = new hukukBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							hukukMuvekkilanaform frame = new hukukMuvekkilanaform();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();

				}
		});
		muvekkilanabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		muvekkilanabuton.setBounds(332, 11, 280, 100);
		contentPane.add(muvekkilanabuton);
		
		avukatanabuton = new JButton("4-) Avukat Islemleri");
		avukatanabuton.setHorizontalAlignment(SwingConstants.LEFT);
		avukatanabuton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				avukatanabuton.setEnabled(false);
			    yardimanabuton.setEnabled(false);
			    muvekkilanabuton.setEnabled(false);
			    kullanicianabuton.setEnabled(false);
			    personelanabuton.setEnabled(false);
			    burobilgianabuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbtn.setEnabled(false);
			    loganabuton.setEnabled(false);
			    hatirlatmabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1180, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Avukat Ana Ekranina gitti...";
							String sorgu_kaydet="insert into hukuklogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+hukukBaglanti.logkullaniciadi+"','"+hukukBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							hukukBaglanti baglan = new hukukBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							
							hukukAvukatkayitanamenu frame = new hukukAvukatkayitanamenu();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();

				
			}
		});
		avukatanabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		avukatanabuton.setBounds(332, 348, 280, 100);
		contentPane.add(avukatanabuton);
		
		
		personelanabuton = new JButton("2-) Personel Islemleri");
		personelanabuton.setHorizontalAlignment(SwingConstants.LEFT);
		personelanabuton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				///
				avukatanabuton.setEnabled(false);
			    yardimanabuton.setEnabled(false);
			    muvekkilanabuton.setEnabled(false);
			    kullanicianabuton.setEnabled(false);
			    personelanabuton.setEnabled(false);
			    burobilgianabuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbtn.setEnabled(false);
			    loganabuton.setEnabled(false);
			    hatirlatmabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1180, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Personel Ana Ekranina gitti...";
							String sorgu_kaydet="insert into hukuklogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+hukukBaglanti.logkullaniciadi+"','"+hukukBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							hukukBaglanti baglan = new hukukBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							
							hukukPersonelanaekrani frame = new hukukPersonelanaekrani();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
				
				//


			}
		});
		personelanabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		personelanabuton.setBounds(332, 122, 280, 100);
		contentPane.add(personelanabuton);
		
		kullanicianabuton = new JButton("5-) Kullanici Islemleri");
		kullanicianabuton.setHorizontalAlignment(SwingConstants.LEFT);
		kullanicianabuton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				avukatanabuton.setEnabled(false);
			    yardimanabuton.setEnabled(false);
			    muvekkilanabuton.setEnabled(false);
			    kullanicianabuton.setEnabled(false);
			    personelanabuton.setEnabled(false);
			    burobilgianabuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbtn.setEnabled(false);
			    loganabuton.setEnabled(false);
			    hatirlatmabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1180, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Kullanici Ana Ekranina gitti...";
							String sorgu_kaydet="insert into hukuklogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+hukukBaglanti.logkullaniciadi+"','"+hukukBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							hukukBaglanti baglan = new hukukBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							
							hukukKullanicikayit frame = new hukukKullanicikayit();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();

	
			}
		});
		kullanicianabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		kullanicianabuton.setBounds(622, 11, 280, 100);
		contentPane.add(kullanicianabuton);
		
		yardimanabuton = new JButton("8-) Hakkimizda");
		yardimanabuton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				avukatanabuton.setEnabled(false);
			    yardimanabuton.setEnabled(false);
			    muvekkilanabuton.setEnabled(false);
			    kullanicianabuton.setEnabled(false);
			    personelanabuton.setEnabled(false);
			    burobilgianabuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbtn.setEnabled(false);
			    loganabuton.setEnabled(false);
			    hatirlatmabuton.setEnabled(false);
			    
				///
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1180, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {

						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Raporlama Ana Ekranina gitti...";
							String sorgu_kaydet="insert into hukuklogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+hukukBaglanti.logkullaniciadi+"','"+hukukBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							hukukBaglanti baglan = new hukukBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							hukukProgramhakkinda frame = new hukukProgramhakkinda();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
						progressBar.hide();
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
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
				//

			}
		});
		yardimanabuton.setHorizontalAlignment(SwingConstants.LEFT);
		yardimanabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		yardimanabuton.setBounds(622, 348, 280, 100);
		contentPane.add(yardimanabuton);
		
		
		
		cikisbuton = new JButton("CIKIS");
		Image  img1=new ImageIcon(this.getClass().getResource("/Lawyer-Briefcase-icon.png")).getImage();
		cikisbuton.setIcon(new ImageIcon(img1));
		cikisbuton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object [] noSaveOption = {"Evet","Hayýr"};
				
				int noSave = JOptionPane.showOptionDialog(null,"Çýkýþ yapmak istiyor musunuz?","Hukuk Otomasyonu",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				//int selectedOption = JOptionPane.showConfirmDialog(null,"Çýkýþ yapmak istiyor musunuz?","ÇIKIÞ",JOptionPane.YES_NO_OPTION); 
				if (noSave == JOptionPane.YES_OPTION)
				{
					Connection myconn2=null;
					Statement mystat2;
					//LOG TABLOSUNA EKLEME
					try {
						System.out.println(hukukBaglanti.sunucuparametresi);
						myconn2=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");//LOGIN FORMDAN DIREK SUNUCU PARAMETRESI GELIYOR

						System.out.println("BAGLANTI CLASSINDAN Baðlantý Saðlandý YENI");
					}catch(Exception hata)
					{
					System.err.println(hata);
					}
					
					String sorgulogkayit,logkullaniciadi,logkullaniciyetkisi,logsunucuparametre,logaksiyon;
					logkullaniciadi=hukukBaglanti.logkullaniciadi;
					logkullaniciyetkisi=hukukBaglanti.logkullaniciyetkisi;
					logaksiyon="Sistemden Cikis Yapti";
					logsunucuparametre=hukukBaglanti.sunucuparametresi;
					sorgulogkayit="INSERT INTO hukukburosulog (logkullaniciadi,logkullaniciyetkisi,logsunucuparametre,logaksiyon) VALUES ('"+logkullaniciadi+"','"+logkullaniciyetkisi+"','"+logsunucuparametre+"','"+logaksiyon+"')";

					System.out.println(sorgulogkayit);
					try {
						mystat2=myconn2.createStatement();
						mystat2.executeUpdate(sorgulogkayit);

						System.out.println("Cikis Log Ekleme Basarili");

						}catch(Exception hata)
						{
						System.err.println(hata);
						}

					//LOG TABLOSUNA EKLEME
					///KAPANISA UYARI
					hukukKayitsayitablosu frame = new hukukKayitsayitablosu();
					frame.show();
					frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
					
					///

					
					System.exit(0);
				}
			}
		});
		cikisbuton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cikisbuton.setBounds(912, 233, 280, 215);
		contentPane.add(cikisbuton);
		
	

		
		burobilgianabuton = new JButton("3-) Buro Bilgi Islemleri");
		burobilgianabuton.setHorizontalAlignment(SwingConstants.LEFT);
		burobilgianabuton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				avukatanabuton.setEnabled(false);
			    yardimanabuton.setEnabled(false);
			    muvekkilanabuton.setEnabled(false);
			    kullanicianabuton.setEnabled(false);
			    personelanabuton.setEnabled(false);
			    burobilgianabuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbtn.setEnabled(false);
			    loganabuton.setEnabled(false);
			    hatirlatmabuton.setEnabled(false);
				///
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1180, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Buro Bilgi Ana Ekranina gitti...";
							String sorgu_kaydet="insert into hukuklogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+hukukBaglanti.logkullaniciadi+"','"+hukukBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							hukukBaglanti baglan = new hukukBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							
							hukukBurobilgiana frame = new hukukBurobilgiana();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR	
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
	
			}
		});
		burobilgianabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		burobilgianabuton.setBounds(332, 233, 280, 100);
		contentPane.add(burobilgianabuton);

		
		loganabuton = new JButton("7-) Kullanici Log Yonetimi");
		loganabuton.setHorizontalAlignment(SwingConstants.LEFT);
		loganabuton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				avukatanabuton.setEnabled(false);
			    yardimanabuton.setEnabled(false);
			    muvekkilanabuton.setEnabled(false);
			    kullanicianabuton.setEnabled(false);
			    personelanabuton.setEnabled(false);
			    burobilgianabuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbtn.setEnabled(false);
			    loganabuton.setEnabled(false);
			    hatirlatmabuton.setEnabled(false);
			    
				///
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1180, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Kullanici Log Yonetimi Ana Ekranina gitti...";
							String sorgu_kaydet="insert into hukuklogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+hukukBaglanti.logkullaniciadi+"','"+hukukBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							hukukBaglanti baglan = new hukukBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							hukukLogkayitlari frame = new hukukLogkayitlari();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							progressBar.hide();
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
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
		
			}
			else {
				//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
				Object [] noSaveOption = {"Tamam"};
				int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
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
			}
				///
			}
				
				
		});
		loganabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loganabuton.setBounds(622, 233, 280, 100);
		contentPane.add(loganabuton);
		
		
		
		JLabel labelanafoto = new JLabel("");
		labelanafoto.setOpaque(true);
		labelanafoto.setForeground(SystemColor.WHITE);
		labelanafoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelanafoto.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/justice-balance-icon (1).png")).getImage();
		labelanafoto.setIcon(new ImageIcon(img));
		labelanafoto.setBounds(13, 11, 309, 437);
		contentPane.add(labelanafoto);
		
		Label durumcubugu = new Label("");
		durumcubugu.setFont(new Font("Tahoma", Font.BOLD, 12));
		durumcubugu.setBackground(Color.WHITE);
		durumcubugu.setBounds(8, 637, 889, 27);
		durumcubugu.setText("KULLANICI : "+hukukBaglanti.logkullaniciadi+" "+"YETKI :"+hukukBaglanti.logkullaniciyetkisi+" "+"DURUM :"+hukukBaglanti.sunucuparametresi+" "+" ONLINE");
		contentPane.add(durumcubugu);
		
		Label versiyonlabel = new Label("Version");
		versiyonlabel.setAlignment(Label.RIGHT);
		versiyonlabel.setBackground(Color.WHITE);
		versiyonlabel.setForeground(Color.BLACK);
		versiyonlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		versiyonlabel.setBounds(907, 637, 280, 27);
		versiyonlabel.setText(hukukBaglanti.versionadi+hukukBaglanti.versionuygulama+hukukBaglanti.versiondb);
		contentPane.add(versiyonlabel);
		
		hatirlatmabuton = new JButton("6-) Ajanda ve Hatirlatma");
		hatirlatmabuton.setHorizontalAlignment(SwingConstants.LEFT);
		hatirlatmabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hatirlatmabuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				avukatanabuton.setEnabled(false);
			    yardimanabuton.setEnabled(false);
			    muvekkilanabuton.setEnabled(false);
			    kullanicianabuton.setEnabled(false);
			    personelanabuton.setEnabled(false);
			    burobilgianabuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbtn.setEnabled(false);
			    loganabuton.setEnabled(false);
			    hatirlatmabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1180, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...";
							String sorgu_kaydet="insert into hukuklogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+hukukBaglanti.logkullaniciadi+"','"+hukukBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							hukukBaglanti baglan = new hukukBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							
							hukukAjandaanaekrani frame = new hukukAjandaanaekrani();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR	
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
			

			}
			
		});
		hatirlatmabuton.setBounds(622, 122, 280, 100);
		contentPane.add(hatirlatmabuton);
		
		yardimbtn = new JButton("Yardim");
		yardimbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				///
				avukatanabuton.setEnabled(false);
			    yardimanabuton.setEnabled(false);
			    muvekkilanabuton.setEnabled(false);
			    kullanicianabuton.setEnabled(false);
			    personelanabuton.setEnabled(false);
			    burobilgianabuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbtn.setEnabled(false);
			    loganabuton.setEnabled(false);
			    hatirlatmabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1180, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {

						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Online Kullanim Hukukyardim.pdf Ekranina gitti...";
							String sorgu_kaydet="insert into hukuklogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+hukukBaglanti.logkullaniciadi+"','"+hukukBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							hukukBaglanti baglan = new hukukBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
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
	 						
	 						
	 						
	 						/////
							//hukukProgramhakkinda frame = new hukukProgramhakkinda();
							//frame.show();
							//frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							progressBar.hide();
							
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
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
				///
			}
		});
		yardimbtn.setOpaque(false);
		Image  img2=new ImageIcon(this.getClass().getResource("/Law-icon.png")).getImage();
		yardimbtn.setIcon(new ImageIcon(img2));
		yardimbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		yardimbtn.setBounds(912, 11, 280, 211);
		contentPane.add(yardimbtn);
		
		


	
	}
}


