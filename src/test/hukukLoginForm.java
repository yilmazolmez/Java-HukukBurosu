package test;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class hukukLoginForm {

	private JFrame frmLoginForm;
	private JTextField textField1;
	private JTextField textField2;
	private JPasswordField passwordField;
	private JTextField databasetext;

	public String sunucuparametresilogin;//BAGLANTI ICIN PARAMETRE BILGILERINI TUTUYOR
	static Timer timer;//PROGRESS ICIN
	public static String loginsunucu;//SIFREMI UNUTTUM ICIN SUNUCU BILGISI TUTUYOR
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {  
			@Override
			public void run() {
				try {
					hukukLoginForm window = new hukukLoginForm();
					window.frmLoginForm.setVisible(true);

					
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public hukukLoginForm() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginForm = new JFrame();
		frmLoginForm.setResizable(false);
		frmLoginForm.getContentPane().setBackground(new Color(240, 240, 240));
		frmLoginForm.setTitle("Hukuk Burosu Otomasyonu - Offline - Login Form");
		frmLoginForm.setBounds(100, 100, 776, 420);
		frmLoginForm.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
		
		frmLoginForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		
		textField1 = new JTextField();
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					passwordField.requestFocus();
				}
			}
		});
		textField1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField1.setBounds(498, 42, 241, 20);
		frmLoginForm.getContentPane().add(textField1);
		textField1.setColumns(20);
		
		//textField1 = new HintTextField("admin");
		//textField1.setColumns(20);
		//textField1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		//textField1.setBounds(452, 42, 287, 20);
		//frmLoginForm.getContentPane().add(textField1);

		
		 
		
		JLabel lblNewLabel = new JLabel("Kullanici Adiniz :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(314, 42, 174, 20);
		frmLoginForm.getContentPane().add(lblNewLabel);
		
		JLabel lblSifrenizZ = new JLabel("Sifreniz  :");
		lblSifrenizZ.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSifrenizZ.setBounds(314, 72, 129, 20);
		frmLoginForm.getContentPane().add(lblSifrenizZ);
		
	
		
		
		JLabel Logo = new JLabel("");
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.setOpaque(true);
		Logo.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/justice-balance-icon (1).png")).getImage();//LOGO DOSYASYI CEKILIYOR
		frmLoginForm.getContentPane().add(Logo);
		Logo.setIcon(new ImageIcon(img));
		Logo.setBounds(10, 10, 287, 283);


		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					databasetext.requestFocus();
				}
			}
		});
		passwordField.setBounds(498, 72, 241, 20);
		frmLoginForm.getContentPane().add(passwordField);
		
		JLabel lblDatabaseSeimi = new JLabel("Server Adi / IP :");
		lblDatabaseSeimi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDatabaseSeimi.setBounds(314, 102, 174, 20);
		frmLoginForm.getContentPane().add(lblDatabaseSeimi);
		
		databasetext = new JTextField();
		databasetext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField1.requestFocus();
				}
			}
		});
		databasetext.setHorizontalAlignment(SwingConstants.LEFT);
		databasetext.setText("localhost:3306");
		databasetext.setFont(new Font("Tahoma", Font.BOLD, 14));
		databasetext.setColumns(10);
		databasetext.setBounds(498, 102, 241, 20);
		frmLoginForm.getContentPane().add(databasetext);
		
		JLabel Logo_1 = new JLabel("");
		Logo_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image  img6=new ImageIcon(this.getClass().getResource("/javamysql.png")).getImage();
		Logo_1.setIcon(new ImageIcon(img6));
		Logo_1.setBackground(Color.WHITE);
		Logo_1.setBounds(10, 304, 287, 65);
		frmLoginForm.getContentPane().add(Logo_1);
		
		


		
		JButton btnNewButton = new JButton("Baglan...");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		Image  img2=new ImageIcon(this.getClass().getResource("/loginbuton32pix.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		btnNewButton.setBounds(314, 133, 425, 64);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				///////7
		
			//
				//MY SQL BAGLANTI
				try
				{
					//baglanti.yap();
				
					sunucuparametresilogin="jdbc:mysql://"+databasetext.getText()+"/hukukburosu?useTimezone=true&serverTimezone=UTC";
					Connection myconn=DriverManager.getConnection (sunucuparametresilogin,"root","");
					System.out.println("Baðlantý Saðlandý");
					
					String kullaniciadi = textField1.getText();
			        String sifre = String.valueOf(passwordField.getPassword());
			        
					//LOGIN ISLEMI
			        String query1="Select kadi,AES_DECRYPT(sifresi,'abc1234') AS sifresi,kaciklama,sifrehatirlatmasoru,sifrehatirlatmacevap,yetki From kullanicibilgi where kadi='"+kullaniciadi+"'";
					Statement stmt1=myconn.createStatement();
					ResultSet rs1=stmt1.executeQuery(query1);
					//LOGIN ISLEMI
					
					
					//VERSION BILGI EKRANI
					String query2="Select * from hukukversionbilgi"; //VERSION BILGI EKRANI
					Statement stmt2=myconn.createStatement();//VERSION BILGI EKRANI
					ResultSet rs2=stmt2.executeQuery(query2);//VERSION BILGI EKRANI
					while(rs2.next())
					{
						hukukBaglanti.versionadi=rs2.getString("versionadi");//VERSION BILGI EKRANI
						hukukBaglanti.versiondb=rs2.getString("versiondb");//VERSION BILGI EKRANI
						hukukBaglanti.versionuygulama=rs2.getString("versionuygulama");//VERSION BILGI EKRANI
					}
					//VERSION BILGI EKRANI
					
					//LOG KAYDI EKLEME
					int a=0;
					String b="";
					String c="";
					String d="";
					
					while(rs1.next())
					{
					b=rs1.getString("kaciklama");
				    System.out.println("Sisteme Baþarý ile Login Olundu..");
					System.out.println("kadi:"+rs1.getString("kadi")+"sifresi"+rs1.getString("sifresi")+"Aciklama : " + rs1.getString("kaciklama")+"Yetki : " + rs1.getString("yetki"));
					c=rs1.getString("yetki");
					d=rs1.getString("sifresi");
					a=a+1;
					}
					//if ((a>=1)&&(sifre.equals(d))&&(textField1.getText()!=null)&&(passwordField.getText()!=null)) {
					if ((a>=1)&&(sifre.equals(d))&&(kullaniciadi!=null)&&(sifre!=null)) {
						System.out.println("SUAN BURADA BURADA");
						//LOG TABLOSUNA EKLEME
						btnNewButton.setEnabled(false);//HERSEY DOGRUYSA BAGLAN BUTONU PASIF EDLIYOR
						String sorgulogkayit,logkullaniciadi,logkullaniciyetkisi,logsunucuparametre,logaksiyon;
						logkullaniciadi=kullaniciadi;
						logkullaniciyetkisi=c;
						logaksiyon="Sisteme Giris Yapti";
						logsunucuparametre=sunucuparametresilogin;
						hukukBaglanti.sunucuparametresi=sunucuparametresilogin;
						hukukBaglanti.logkullaniciyetkisi=c;
						hukukBaglanti.logkullaniciadi=kullaniciadi;//BAGLANTI CLASSINA YAZIYOR
						hukukBaglanti.logaksiyon="Sisteme Giris Yapti";// BAGLANTI CLASSINA YAZIYOR
						
						hukukBaglanti.kullanimpdf="https://drive.google.com/open?id=10c5xaWMYREhapEDdghG5vQ1Q2DVc9rHy"; //Online Kullanim Kilavuzumuz
						
						sorgulogkayit="INSERT INTO hukukburosulog (logkullaniciadi,logkullaniciyetkisi,logsunucuparametre,logaksiyon) VALUES ('"+logkullaniciadi+"','"+logkullaniciyetkisi+"','"+logsunucuparametre+"','"+logaksiyon+"')";

						System.out.println(sorgulogkayit);
						try {
							stmt1.executeUpdate(sorgulogkayit);

							System.out.println("Ekleme Basarili");

							}catch(Exception hata)
							{
							System.err.println(hata);
							}

						//LOG TABLOSUNA EKLEME
					
					//PROGRESS EKLEME
					JProgressBar progressBar = new JProgressBar();
					progressBar.setStringPainted(true);
					progressBar.setBounds(314,304, 425,65);
					frmLoginForm.getContentPane().add(progressBar);
					
					timer = new Timer (100, new ActionListener() {
						private int x=0;
						public void actionPerformed(ActionEvent arg0) {
							
							progressBar.setValue(x+=10);
							if (x==100) {
								timer.stop();
								x=0;
								hukukAnaMenu frame = new hukukAnaMenu();
								frame.setVisible(true);
								
								System.out.println("BAGLANTIYA SUNUCU PARAMETRESI YAZILDI"+hukukBaglanti.sunucuparametresi);
								frmLoginForm.setVisible(false);
							}
							}
					});
					
					//PROGRESS EKLEME
					timer.start();
					
					}
					else  {
						//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
						Object [] noSaveOption = {"Tamam"};
						int noSave = JOptionPane.showOptionDialog(null,"Hatali Giris yaptiniz!","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}

					//btnNewButton.setEnabled(true);
				}catch(Exception hata)
				{
				System.err.println(hata.getMessage());
				//throw new Exception("Deneme123");
				}
				//
				//////7

			}
		});
		frmLoginForm.getContentPane().setLayout(null);
		frmLoginForm.getContentPane().add(btnNewButton);
		

		
		JButton btnNewButton_1 = new JButton("Sifremi Unuttum ?");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginsunucu=databasetext.getText();
				hukukSifremiunuttum frame = new hukukSifremiunuttum();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR	
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image  img3=new ImageIcon(this.getClass().getResource("/sifremiunuttum22pix.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img3));
		btnNewButton_1.setBounds(314, 249, 190, 45);
		frmLoginForm.getContentPane().add(btnNewButton_1);
		
		

		
		JButton btnNewButton_1_1 = new JButton("Hakkimizda !");
		Image  img4=new ImageIcon(this.getClass().getResource("/hakkimizda24pix.png")).getImage();
		btnNewButton_1_1.setIcon(new ImageIcon(img4));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hukukProgramhakkinda frame = new hukukProgramhakkinda();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}
		});
		btnNewButton_1_1.setBounds(549, 249, 190, 45);
		
		frmLoginForm.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Online Kullanim Kilavuzu");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image  img5=new ImageIcon(this.getClass().getResource("/yardim12pix.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img5));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///// YARDIM KILAVUZU ONLINE			
				//String FILE = "D:/Hukukyardim.pdf";
				String FILE = "https://drive.google.com/open?id=10c5xaWMYREhapEDdghG5vQ1Q2DVc9rHy"; //Online Kullanim Kilavuzumuz
				
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
		btnNewButton_2.setBounds(314, 208, 425, 30);
		frmLoginForm.getContentPane().add(btnNewButton_2);
		

		

		
	}
}
