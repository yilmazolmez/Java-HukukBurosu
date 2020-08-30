package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import com.mysql.cj.xdevapi.Statement;

//import hukukcmftasarým.burobilgiana;

//import hukukcmftasarým.burobilgiana;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.JDialog;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

//public class hukukAvukatekleduzenle extends JFrame {
public class hukukAvukatekleduzenle extends JDialog {

	static Connection myconn1;
	static java.sql.Statement mystat1;
	
	private JPanel contentPane;
	private JTextField txtTC;
	private JTextField txtadi;
	private JTextField txtsoyadi;
	private JTextField txtbabaadi;
	private JTextField txtanaadi;
	private JTextField txtbaro;
	private JTextField txtsicilno;
	private JTextField txteposta;
	private JTextField txtdogumyeri;
	private JTextField txttelefon;
    private ComboBoxEditor comboBox;
    private JTextField avukatidtxt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukAvukatekleduzenle frame = new hukukAvukatekleduzenle();
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
	public hukukAvukatekleduzenle() {
		setModal(true);
		setResizable(false);
		setTitle("Avukat Ekle / Duzenle Ekrani");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 798, 431);
	    setLocationRelativeTo(null);
	    
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel10 = new JLabel("");
		lblNewLabel10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel10.setBackground(Color.WHITE);
		lblNewLabel10.setOpaque(true);
		Image img = new ImageIcon(this.getClass().getResource("/Law-icon.png")).getImage();
		lblNewLabel10.setIcon(new ImageIcon(img));
		lblNewLabel10.setBounds(10, 60, 138, 318);
		contentPane.add(lblNewLabel10);
		
		JTextArea txtrAdres = new JTextArea();
		contentPane.add(txtrAdres);
		txtrAdres.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrAdres.setText("Adres");
		//txtrAdres.setBounds(263,210,144,65);
		contentPane.add(txtrAdres);
		txtrAdres.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtrAdres.getText().length() >= 100 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtdogumyeri.requestFocus();
				}
			}
	    });
		JScrollPane scroll = new JScrollPane(txtrAdres);
		scroll.setBounds(263,210,144,65);                     // <-- THIS
	    getContentPane().add(scroll);
	    setLocationRelativeTo ( null );
	    txtrAdres.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    txtrAdres.setLineWrap(true); //satir sonu bir alta almak icin
		
	    
		JDateChooser txtdogumtarihi = new JDateChooser();
		txtdogumtarihi.setBounds(551, 60, 148, 20);
		txtdogumtarihi.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtdogumtarihi);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txttelefon.requestFocus();
				}
			}

		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "BAYAN", "BAY"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(551, 120, 148, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Avukat Ekle / Duzenle Ekrani");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 11, 309, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TC No *:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(158, 60, 55, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adi:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(158, 90, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Soyadi:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(158, 120, 55, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Dogum Tarihi:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(430, 60, 91, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Dogum Yeri: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(430, 90, 91, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Telefon:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(430, 150, 79, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Baba Adi:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(158, 150, 79, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Ana Adi:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(158, 180, 79, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("Cinsiyet:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(430, 120, 79, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Sicil No *:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12.setBounds(430, 180, 79, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Baro:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_13.setBounds(430, 240, 79, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("E-Posta:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_14.setBounds(430, 210, 79, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Adres:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_15.setBounds(158, 210, 79, 14);
		contentPane.add(lblNewLabel_15);
		
		txtTC = new JTextField();
		txtTC.setBounds(263, 60, 144, 20);
		contentPane.add(txtTC);
		txtTC.setColumns(10);
		//Yazý sýnýrlandýrma için
		txtTC.addKeyListener(new KeyAdapter() {
				        @Override
				        public void keyTyped(KeyEvent e) {
				            if (txtTC.getText().length() >= 11 ) // limit to 3 characters
				                e.consume();
				        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtadi.requestFocus();
				}
			}
				    });
			 
		txtadi = new JTextField();
		txtadi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtsoyadi.requestFocus();
				}
			}
		});
		txtadi.setText("Av. ");
		txtadi.setBounds(263, 90, 144, 20);
		contentPane.add(txtadi);
		txtadi.setColumns(10);
		
		txtsoyadi = new JTextField();
		txtsoyadi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtbabaadi.requestFocus();
				}
			}
		});
		txtsoyadi.setBounds(263, 120, 144, 20);
		contentPane.add(txtsoyadi);
		txtsoyadi.setColumns(10);
		
		txtbabaadi = new JTextField();
		txtbabaadi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtanaadi.requestFocus();
				}
			}
		});
		txtbabaadi.setText("Baba Adi");
		txtbabaadi.setBounds(263, 150, 144, 20);
		contentPane.add(txtbabaadi);
		txtbabaadi.setColumns(10);
		
		txtanaadi = new JTextField();
		txtanaadi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtrAdres.requestFocus();
				}
			}
		});
		txtanaadi.setText("Ana Adi");
		txtanaadi.setBounds(263, 180, 144, 20);
		contentPane.add(txtanaadi);
		txtanaadi.setColumns(10);
		
		txtbaro = new JTextField();
		txtbaro.setBounds(551, 240, 148, 20);
		contentPane.add(txtbaro);
		txtbaro.setColumns(10);
		
		txtsicilno = new JTextField();
		txtsicilno.setText("00000");
		txtsicilno.setBounds(551, 180, 148, 20);
		contentPane.add(txtsicilno);
		txtsicilno.setColumns(10);
		//Yazý sýnýrlandýrma için
		txtsicilno.addKeyListener(new KeyAdapter() {
				        @Override
				        public void keyTyped(KeyEvent e) {
				            if (txtsicilno.getText().length() >= 15 ) // limit to 3 characters
				                e.consume();
				        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txteposta.requestFocus();
				}
			}
				    });
			 
		txteposta = new JTextField();
		txteposta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtbaro.requestFocus();
				}
			}
		});
		txteposta.setBounds(551, 210, 148, 20);
		contentPane.add(txteposta);
		txteposta.setColumns(10);
		
		txtdogumyeri = new JTextField();
		txtdogumyeri.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboBox.requestFocus();
				}
			}
		});
		txtdogumyeri.setText("Dogum Yeri");
		txtdogumyeri.setBounds(551, 90, 148, 20);
		contentPane.add(txtdogumyeri);
		txtdogumyeri.setColumns(10);
		 
		
		txttelefon = new JTextField();
		txttelefon.setText("5320000000");
		txttelefon.setBounds(551, 150, 148, 20);
		contentPane.add(txttelefon);
		txttelefon.setColumns(10);
		//Yazý sýnýrlandýrma için
		txttelefon.addKeyListener(new KeyAdapter() {
				        @Override
				        public void keyTyped(KeyEvent e) {
				            if (txttelefon.getText().length() >= 11 ) // limit to 3 characters
				                e.consume();
				        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtsicilno.requestFocus();
				}
			}
				    });
			 
		
		
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("Pencere Acildi");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("Pencere kapandi");
			}
			@Override
			public void windowActivated(WindowEvent e) {
				String id_al=hukukAvukatkayitanamenu.tc;
				ResultSet rs = null;
				try {
					
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					String listele="Select * From avukatbilgi where AvukatTC='"+id_al+"'";
					mystat1=myconn1.createStatement();
					rs=mystat1.executeQuery(listele);
					if(rs.next())
					{	hukukAvukatkayitanamenu.tc_sakla=hukukAvukatkayitanamenu.tc;
						hukukAvukatkayitanamenu.tc="0";	
						
						txtTC.setText(rs.getString("AvukatTC"));
						txtadi.setText(rs.getString("AvukatAd"));
						txtsoyadi.setText(rs.getString("AvukatSoyad"));
						txtbabaadi.setText(rs.getString("AvukatBabaAdi"));
						txtanaadi.setText(rs.getString("AvukatAnaAdi"));
						txtdogumtarihi.setDate(rs.getDate("AvukatDogumTarihi"));
						txtdogumyeri.setText(rs.getString("AvukatDogumYeri"));
						txttelefon.setText(rs.getString("AvukatTelefon"));
						txtsicilno.setText(rs.getString("AvukatSicilNo"));
						txteposta.setText(rs.getString("Avukateposta"));
						txtbaro.setText(rs.getString("AvukatBaro"));
						txtrAdres.setText(rs.getString("AvukatAdres"));
						String cins=rs.getString("AvukatCinsiyet");
						if(cins.equals("BAYAN"))
						{
							comboBox.setSelectedIndex(0);
						}
						else
						{
							comboBox.setSelectedIndex(1);
						}
					
						/**/
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		
		
	
		

	
		
		 
		
		JButton btnNewButton_2 = new JButton("Vazgec");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hukukAvukatkayitanamenu avukat = new hukukAvukatkayitanamenu();
				//avukat.setVisible(true);
				//avukat.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(455,348, 100, 30);
		contentPane.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("Kaydet");
		btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String tarih1;//
			
			Date date =new Date();

			if (txtdogumtarihi.getDate()==null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				tarih1=sdf.format(date);}
			else {
		      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
				tarih1=sdf.format(txtdogumtarihi.getDate());//TARIH FORMATLAMA
				System.out.println(tarih1);}
			
					String cinsiyet=comboBox.getSelectedItem().toString();
					String tc,ad,soyad,baba_adi,ana_adi,adres,dogumyeri,tel,mail,baro;
					//dogtar=txtdogumtarihi.toString();
					String sicilno;
					tc=txtTC.getText();
					soyad=txtsoyadi.getText();
					ad=txtadi.getText();
					baba_adi=txtbabaadi.getText();
					ana_adi=txtanaadi.getText();
					adres=txtrAdres.getText();
					dogumyeri=txtdogumyeri.getText();
					tel=txttelefon.getText();
					sicilno=txtsicilno.getText();
					mail=txteposta.getText();
					baro=txtbaro.getText();
					
					if(tc.equals("") || sicilno.equals("")) 
					{
						JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

					}
					else
					{
						ResultSet rs1=null;
						try
						{
							
							String avukat_kontrol="select * from avukatbilgi where AvukatTC='"+txtTC.getText()+"'";
							myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
	 						mystat1=myconn1.createStatement();
							rs1=mystat1.executeQuery(avukat_kontrol);
							if(rs1.next())
							{
		    			
								JOptionPane.showMessageDialog(null,"Avukat TC mevcuttur. Önceden kayýt edilmiþtir.!!");
					    			
							}
							else
							{
								
									String sorgu_ekle="insert into avukatbilgi(AvukatTC,AvukatAd,AvukatSoyad,AvukatBabaAdi,AvukatAnaAdi,AvukatAdres,AvukatDogumTarihi,AvukatDogumYeri,AvukatCinsiyet,AvukatTelefon,AvukatSicilNo,Avukateposta,AvukatBaro)values('"+tc+"','"+ad+"','"+soyad+"','"+baba_adi+"','"+ana_adi+"','"+adres+"','"+tarih1+"','"+dogumyeri+"','"+cinsiyet+"','"+tel+"','"+sicilno+"','"+mail+"','"+baro+"')";	
									try {
										myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
										mystat1=myconn1.createStatement();
										mystat1.executeUpdate(sorgu_ekle);
										JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
										//hukukAvukatkayitanamenu avukat = new hukukAvukatkayitanamenu();
										//avukat.setVisible(true);
										//avukat.setLocationRelativeTo(null);
										dispose();
									
									}catch(Exception hata)
									{
										System.err.println(hata);
									} 
							}
						}catch(Exception hata)
						{
							System.err.println(hata);
						}	
					}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(224, 348, 100, 30);
		
		
		
		
		JButton btnNewButton_3_1 = new JButton("Guncelle");
		if(hukukAvukatkayitanamenu.tc.equals("0"))
		{
			System.out.println(hukukAvukatkayitanamenu.tc);
			contentPane.add(btnNewButton_3);
		}
		else
		{
			System.out.println(hukukAvukatkayitanamenu.tc);
			txtTC.enable(false);
			contentPane.add(btnNewButton_3_1);
		}
		
		
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tarih1;//
				
				Date date =new Date();

				if (txtdogumtarihi.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih1=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih1=sdf.format(txtdogumtarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih1);}
				
				String cinsiyet=comboBox.getSelectedItem().toString();
				String tc,ad,soyad,baba_adi,ana_adi,adres,dogumyeri,tel,mail,baro,dogtar;
//				dogtar=txtdogumtarihi1.getText();
				String sicilno;
				tc=txtTC.getText();
				soyad=txtsoyadi.getText();
				ad=txtadi.getText();
				baba_adi=txtbabaadi.getText();
				ana_adi=txtanaadi.getText();
				adres=txtrAdres.getText();
				dogumyeri=txtdogumyeri.getText();
				tel=txttelefon.getText();
				sicilno=txtsicilno.getText();
				mail=txteposta.getText();
				baro=txtbaro.getText();
				

				String guncelle="update avukatbilgi set AvukatTC='"+tc+"',Avukatad='"+ad+"',AvukatSoyad='"+soyad+"',AvukatBabaAdi='"+baba_adi +"',AvukatAnaAdi='"+ana_adi+"',AvukatAdres='"+adres+"',AvukatDogumTarihi='"+tarih1+"',AvukatDogumYeri='"+dogumyeri+"',AvukatCinsiyet='"+cinsiyet+"',AvukatTelefon='"+tel+"',AvukatSicilNo='"+sicilno+"',Avukateposta='"+mail+"',AvukatBaro='"+baro+"' where AvukatTC='"+hukukAvukatkayitanamenu.tc_sakla+"'";
				try 
				{
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					mystat1=myconn1.createStatement();
					mystat1.executeUpdate(guncelle);
					JOptionPane.showMessageDialog(null,"Güncelleme Baþarýlý");
					 
					
					//hukukAvukatkayitanamenu avukat=new hukukAvukatkayitanamenu();
					//avukat.setVisible(true);
					//avukat.setLocationRelativeTo(null);
					dispose();
					 
				

				}catch(Exception hata)
				{
					System.err.println(hata);
				}
			
			}
		
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1.setBounds(224, 348, 100, 30);
		
	
		
		
		
		JButton btnNewButton_4 = new JButton("Temizle");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTC.setText("");
				txtadi.setText("");
				txtsoyadi.setText("");
				txtsicilno.setText("");
				txteposta.setText("");
				txtTC.setText("");
				txtadi.setText("");
				txtsoyadi.setText("");
				txtsicilno.setText("");
				txteposta.setText("");
				txtrAdres.setText("");
				txtanaadi.setText("");
				txttelefon.setText("");

				
			}
		});
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(345, 348, 100, 30);
		contentPane.add(btnNewButton_4);
		

		

		
		}
	}

		
		
