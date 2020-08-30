package test;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.mysql.cj.x.protobuf.MysqlxCrud.Limit;
import com.toedter.calendar.JDateChooser;


import java.awt.ScrollPane;

//public class hukukMuvekkilekleduzenle extends JFrame {
public class hukukMuvekkilekleduzenle extends JDialog {

	static Connection myconn,myconn1,myconna;
	static Statement mystat,mystat1,mystata,mystata1;

	private JPanel contentPane;
	private JTextField text_ticsicno;
	private JTextField text_ad;
	private JTextField text_soyad;
	private JTextField text_dogtar;
	private JTextField text_dogyer;
	private JTextField text_tel_1;
	private JTextField text_babaad;
	private JTextField text_anaad;
	private JTextField text_epsota;
	private JTextField text_verdaire;
	private JTextField text_verno;
	private JTextField text_il;
	private JTextField text_ilce;
	private JTextField text_avukat;
	private  JTextArea text_adres;
	private  JTextArea text_aciklama;
	private JComboBox  comboBox_cinsiyet;
	private JTextField text_turu_unvan;
	private JTextField text_sskisyerino;
	private JComboBox comboBox_avukat;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					hukukMuvekkilekleduzenle frame = new hukukMuvekkilekleduzenle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	 public hukukMuvekkilekleduzenle() throws ParseException {
		setModal(true);
		setResizable(false);
		setTitle("Muvekkil Ekle / Duzenle Ekrani");
		    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		    setBounds(100, 100, 892, 531);
		    setLocationRelativeTo(null);
		    contentPane = new JPanel();
		    contentPane.setBackground(new Color(255, 255, 102));
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setContentPane(contentPane);
		    contentPane.setLayout(null);


		    
	 
		    JLabel lblNewLabel = new JLabel("");
		    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		    Image img = new ImageIcon(this.getClass().getResource("/Jury-Law-icon.png")).getImage();
		    lblNewLabel.setIcon(new ImageIcon(img));
		    lblNewLabel.setOpaque(true);
		    lblNewLabel.setBackground(Color.WHITE);
		    lblNewLabel.setBounds(10, 70, 175, 412);
		    contentPane.add(lblNewLabel);
		    
		    JLabel lblNewLabel_1 = new JLabel("Muvekkil Ekle / Duzenle Ekrani");
		    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		    lblNewLabel_1.setBounds(10, 11, 385, 42);
		    contentPane.add(lblNewLabel_1);
		    
		    JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		    tabbedPane.setBounds(195, 69, 645, 372);
		    contentPane.add(tabbedPane);
		    
		    JPanel panel = new JPanel();
		    panel.setBackground(new Color(255, 255, 102));
		    tabbedPane.addTab("Gerçek Kiþi/Tüzel Kiþilik ", null, panel, null);
		    panel.setLayout(null);
		    

		    
		    
		    JLabel lbl_tcno_ticno = new JLabel("TC No veya Ticaret Sicil No*:");
		    lbl_tcno_ticno.setFont(new Font("Tahoma", Font.BOLD, 12));
		    lbl_tcno_ticno.setBounds(10, 11, 181, 14);
		    panel.add(lbl_tcno_ticno);
		    

		      
		      JLabel lbl_ad = new JLabel("Muvekkil Adi:");
		      lbl_ad.setFont(new Font("Tahoma", Font.BOLD, 12));
		      lbl_ad.setBounds(10, 41, 133, 14);
		      panel.add(lbl_ad);

		      
		      JLabel lbl_soyad = new JLabel("Soyadi:");
		      lbl_soyad.setFont(new Font("Tahoma", Font.BOLD, 13));
		      lbl_soyad.setBounds(10, 71, 55, 14);
		      panel.add(lbl_soyad);
		      

		      
		      JLabel lbl_dogtar = new JLabel("Dogum Tarihi (Yil-Ay-Gun):");
		      lbl_dogtar.setFont(new Font("Tahoma", Font.BOLD, 13));
		      lbl_dogtar.setBounds(10, 101, 181, 14);
		      panel.add(lbl_dogtar);
		      
		  

		      
		      JLabel lbl_dogyer = new JLabel("Sirket Unvani: ");
		      lbl_dogyer.setFont(new Font("Tahoma", Font.BOLD, 13));
		      lbl_dogyer.setBounds(10, 161, 155, 14);
		      panel.add(lbl_dogyer);

		      
		      JLabel lbl_tel = new JLabel("Telefon:");
		      lbl_tel.setFont(new Font("Tahoma", Font.BOLD, 12));
		      lbl_tel.setBounds(10, 191, 79, 14);
		      panel.add(lbl_tel);
		      

	
		      
		      
		      JLabel lbl_babaad = new JLabel("Baba Adi:");
		      lbl_babaad.setFont(new Font("Tahoma", Font.BOLD, 12));
		      lbl_babaad.setBounds(10, 221, 79, 14);
		      panel.add(lbl_babaad);
		      

		      

		      

	
		      

		      
		      JLabel lbl_adres = new JLabel("Adres:");
		      lbl_adres.setFont(new Font("Tahoma", Font.BOLD, 12));
		      lbl_adres.setBounds(355, 161, 79, 14);
	
    


		      
		      JLabel lbl_avukat = new JLabel("Avukat:");
		      lbl_avukat.setFont(new Font("Tahoma", Font.BOLD, 12));
		      lbl_avukat.setBounds(355, 281, 79, 14);
		      panel.add(lbl_avukat);
		      
		      
		      
		      JLabel lbl_aciklama = new JLabel("Aciklama:");
		      lbl_aciklama.setFont(new Font("Tahoma", Font.BOLD, 12));
		      lbl_aciklama.setBounds(355, 221, 79, 14);
		      panel.add(lbl_aciklama);
		      

		      
		      JLabel lbl_verno_1 = new JLabel("SSK Is yeri No:");
		      lbl_verno_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		      lbl_verno_1.setBounds(355, 71, 97, 14);
		      panel.add(lbl_verno_1);
		      
		      JLabel lbl_dogtar_1 = new JLabel("Dogum Yeri:");
		      lbl_dogtar_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		      lbl_dogtar_1.setBounds(10, 131, 133, 14);
		      panel.add(lbl_dogtar_1);
		      

			    
			    JLabel lbl_ilce_1 = new JLabel("Adres:");
			    lbl_ilce_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			    lbl_ilce_1.setBounds(355, 162, 55, 14);
			    panel.add(lbl_ilce_1);
		      
			     //AVUKATI COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
			      comboBox_avukat = new JComboBox();
			      comboBox_avukat.setBounds(457, 281, 148, 20);
			      panel.add(comboBox_avukat);
				  //AVUKATI COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
			      
					JTextArea text_aciklama_1 = new JTextArea();
					text_aciklama_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
					text_aciklama_1.setText("Aciklama");
					//txtrAdres.setBounds(263,210,144,65);
					panel.add(text_aciklama_1);
					text_aciklama_1.addKeyListener(new KeyAdapter() {
				        @Override
				        public void keyTyped(KeyEvent e) {
				            if (text_aciklama_1.getText().length() >= 100 ) // limit to 3 characters
				                e.consume();
				        }
						@Override
						public void keyPressed(KeyEvent e) {
							if (e.getKeyCode()==KeyEvent.VK_ENTER) {
								comboBox_avukat.requestFocus();
							}
						}
				    });
					JScrollPane scrollPane1 = new JScrollPane(text_aciklama_1);
					scrollPane1.setAutoscrolls(true);
					scrollPane1.setBounds(457, 221, 148, 50);                     // <-- THIS
				    //getContentPane().add(scrollPane);
				    panel.add(scrollPane1);
				    setLocationRelativeTo ( null );
				    text_aciklama_1.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
				    text_aciklama_1.setLineWrap(true); //satir sonu bir alta alma	
			      
					JTextArea text_adres = new JTextArea();
					text_adres.setFont(new Font("Tahoma", Font.PLAIN, 11));
					text_adres.setText("Adres");
					//txtrAdres.setBounds(263,210,144,65);
					panel.add(text_adres);
					text_adres.addKeyListener(new KeyAdapter() {
				        @Override
				        public void keyTyped(KeyEvent e) {
				            if (text_adres.getText().length() >= 100 ) // limit to 3 characters
				                e.consume();
				        }
						@Override
						public void keyPressed(KeyEvent e) {
							if (e.getKeyCode()==KeyEvent.VK_ENTER) {
								text_aciklama_1.requestFocus();
							}
						}
				    });
					JScrollPane scrollPane = new JScrollPane(text_adres);
					scrollPane.setAutoscrolls(true);
					scrollPane.setBounds(457, 161, 148, 50);                     // <-- THIS
				    //getContentPane().add(scrollPane);
				    panel.add(scrollPane);
				    setLocationRelativeTo ( null );
				    text_adres.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
				    text_adres.setLineWrap(true); //satir sonu bir alta alma	   
				    
			      
			      JLabel lbl_ilce = new JLabel("Ilce:");
			      lbl_ilce.setFont(new Font("Tahoma", Font.BOLD, 12));
			      lbl_ilce.setBounds(355, 131, 37, 14);
			      panel.add(lbl_ilce);
			      
			      JTextField text_ilce_1 = new JTextField();
			      text_ilce_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_adres.requestFocus();
						}
			      	}
			      });
			      text_ilce_1.setText("MERKEZ");
			      text_ilce_1.setColumns(10);
			      text_ilce_1.setBounds(457, 131, 148, 20);
			      panel.add(text_ilce_1);
			      
			      JLabel lbl_il = new JLabel("Il:");
			      lbl_il.setFont(new Font("Tahoma", Font.BOLD, 12));
			      lbl_il.setBounds(355, 101, 79, 14);
			      panel.add(lbl_il);
			      
			      JTextField text_il_1 = new JTextField();
			      text_il_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_ilce_1.requestFocus();
						}
			      	}
			      });
			      text_il_1.setText("ISTANBUL");
			      text_il_1.setColumns(10);
			      text_il_1.setBounds(457, 101, 148, 20);
			      panel.add(text_il_1);
			      
			      text_sskisyerino = new JTextField();
			      text_sskisyerino.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_il_1.requestFocus();
						}
			      	}
			      });
			      text_sskisyerino.setText("00000");
			      text_sskisyerino.setColumns(10);
			      text_sskisyerino.setBounds(457, 71, 148, 20);
			      panel.add(text_sskisyerino);
			      
			      JLabel lbl_verno = new JLabel("Vergi No:");
			      lbl_verno.setFont(new Font("Tahoma", Font.BOLD, 12));
			      lbl_verno.setBounds(355, 41, 79, 14);
			      panel.add(lbl_verno);
			      
			      JTextField text_verno_1 = new JTextField();
			      text_verno_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_sskisyerino.requestFocus();
						}
			      	}
			      });
			      text_verno_1.setText("00000");
			      text_verno_1.setColumns(10);
			      text_verno_1.setBounds(457, 41, 148, 20);
			      panel.add(text_verno_1);
			      
			      
			      JLabel lbl_verdaire = new JLabel("Vergi Dairesi: ");
			      lbl_verdaire.setFont(new Font("Tahoma", Font.BOLD, 12));
			      lbl_verdaire.setBounds(355, 11, 97, 14);
			      panel.add(lbl_verdaire);
			      
			      JTextField text_verdaire_1 = new JTextField();
			      text_verdaire_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_verno_1.requestFocus();
						}
			      	}
			      });
			      text_verdaire_1.setText("Vergi Dairesi");
			      text_verdaire_1.setColumns(10);
			      text_verdaire_1.setBounds(457, 11, 148, 20);
			      panel.add(text_verdaire_1);
			      
			      JLabel lbl_eposta = new JLabel("E-posta:");
			      lbl_eposta.setFont(new Font("Tahoma", Font.BOLD, 12));
			      lbl_eposta.setBounds(10, 311, 79, 14);
			      panel.add(lbl_eposta);
			      
			      JTextField text_eposta = new JTextField();
			      text_eposta.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_verdaire_1.requestFocus();
						}
			      	}
			      });
			      text_eposta.setColumns(10);
			      text_eposta.setBounds(201, 314, 144, 20);
			      panel.add(text_eposta);
			      
			      JLabel lbl_cinsiyet = new JLabel("Turu: (Bay/Bayan/Isletme)");
			      lbl_cinsiyet.setFont(new Font("Tahoma", Font.BOLD, 12));
			      lbl_cinsiyet.setBounds(10, 281, 181, 14);
			      panel.add(lbl_cinsiyet);
			      
			      JComboBox comboBox_cinsiyet_1 = new JComboBox();
			      comboBox_cinsiyet_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_eposta.requestFocus();
						}
			      	}
			      });
			      comboBox_cinsiyet_1.setModel(new DefaultComboBoxModel(new String[] {"BAYAN", "BAY", "ISLETME"}));
			      comboBox_cinsiyet_1.setSelectedIndex(0);
			      comboBox_cinsiyet_1.setToolTipText("BAYAN\r\nBAY\r\nISLETME");
			      comboBox_cinsiyet_1.setBounds(201, 281, 144, 22);
			      panel.add(comboBox_cinsiyet_1);
			      
			      JLabel lbl_anaad = new JLabel("Ana Adi:");
			      lbl_anaad.setFont(new Font("Tahoma", Font.BOLD, 12));
			      lbl_anaad.setBounds(10, 251, 79, 14);
			      panel.add(lbl_anaad);
			      
			      JTextField text_anaad_1 = new JTextField();
			      text_anaad_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							comboBox_cinsiyet_1.requestFocus();
						}
			      	}
			      });
			      text_anaad_1.setText("Ana Adi");
			      text_anaad_1.setColumns(10);
			      text_anaad_1.setBounds(201, 250, 144, 20);
			      panel.add(text_anaad_1);
			      
			      JTextField text_babaad_1 = new JTextField();
			      text_babaad_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_anaad_1.requestFocus();
						}
			      	}
			      });
			      text_babaad_1.setText("Baba Adi");
			      text_babaad_1.setColumns(10);
			      text_babaad_1.setBounds(201, 221, 144, 20);
			      panel.add(text_babaad_1);
			      
			      text_tel_1 = new HintTextField("Max Uzunluk=11");
			      text_tel_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyTyped(KeyEvent e) {
			            if (text_tel_1.getText().length() >= 11 ) // limit to 3 characters
			                e.consume();
			      	}
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_babaad_1.requestFocus();
						}
			      	}
			      });
			      text_tel_1.setColumns(10);
			      text_tel_1.setBounds(201, 189, 144, 20);
			      panel.add(text_tel_1);
			      
			      text_turu_unvan = new JTextField();
			      text_turu_unvan.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_tel_1.requestFocus();
						}
			      	}
			      });
			      text_turu_unvan.setColumns(10);
			      text_turu_unvan.setBounds(201, 161, 144, 20);
			      panel.add(text_turu_unvan);
			      
			      JTextField text_dogyer_1 = new JTextField();
			      text_dogyer_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_turu_unvan.requestFocus();
						}
			      	}
			      });
			      text_dogyer_1.setText("ISTANBUL");
			      text_dogyer_1.setColumns(10);
			      text_dogyer_1.setBounds(201, 131, 144, 22);
			      panel.add(text_dogyer_1);
			      
			      JDateChooser text_dogtar_1 = new JDateChooser();
			      text_dogtar_1.setBounds(201, 101, 144, 22);
			      text_dogtar_1.setDateFormatString("yyyy-MM-dd");
			      panel.add(text_dogtar_1);
			      
			      JTextField text_soyad_1 = new JTextField();
			      text_soyad_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_dogyer_1.requestFocus();
						}
			      	}
			      });
			      text_soyad_1.setColumns(10);
			      text_soyad_1.setBounds(201, 71, 144, 20);
			      panel.add(text_soyad_1);
			      
			      JTextField text_ad_1 = new JTextField();
			      text_ad_1.addKeyListener(new KeyAdapter() {
			      	@Override
			      	public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==KeyEvent.VK_ENTER) {
							text_soyad_1.requestFocus();
						}
			      	}
			      });
			      text_ad_1.setColumns(10);
			      text_ad_1.setBounds(201, 41, 144, 20);
			      panel.add(text_ad_1);
			      
				    JTextField text_ticsicno_1 = new JTextField();
				    text_ticsicno_1.setText("00000");
				    text_ticsicno_1.setColumns(11);
				    text_ticsicno_1.setBounds(201, 11, 144, 20);
				    panel.add(text_ticsicno_1);
				    //Yazý sýnýrlandýrma için en fazla 11 karakter yazabiliyoruz
				      text_ticsicno_1.addKeyListener(new KeyAdapter() {
					        @Override
					        public void keyTyped(KeyEvent e) {
					            if (text_ticsicno_1.getText().length() >= 11 ) // limit to 3 characters
					                e.consume();
					        }
				      	@Override
				      	public void keyPressed(KeyEvent e) {
							if (e.getKeyCode()==KeyEvent.VK_ENTER) {
								text_ad_1.requestFocus();
							}
				      	}
					    });
				      //text_ticsicno_1.disable();
				      
				      

				      
		    
		    JButton btnGncelle = new JButton("Guncelle");
		    btnGncelle.addActionListener(new ActionListener() {
		    	@Override
				public void actionPerformed(ActionEvent e) {
					String tarih1;//
					
					Date date =new Date();

					if (text_dogtar_1.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih1=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih1=sdf.format(text_dogtar_1.getDate());//TARIH FORMATLAMA
						System.out.println(tarih1);}
		    		
					if((text_ticsicno_1.getText().equals(""))||(text_ad_1.getText().equals("")))
		    		{
						JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

		    		}
		    		else {
		    			ResultSet rs1=null;
						
						    		//String guncelle_sorgu="update muvekkilbilgi set MuvekkilTC='"+text_ticsicno_1.getText()+"', MuvekkilAdi='"+text_ad_1.getText()+"',MuvekkilSoyadi='"+text_soyad_1.getText()+"',MuvekkilDogumTarihi='"+text_dogtar_1.getDate()+"',MuvekkilDogumYeri='"+text_dogyer_1.getText()+"',MuvekkilTelefon='"+text_tel_1.getText()+"',MuvekkilBabaAdi='"+text_babaad_1.getText()+"',MuvekkilAnaAdi='"+text_anaad_1.getText()+"',MuvekkilCinsiyet='"+comboBox_cinsiyet_1.getSelectedItem().toString()+"',	MuvekkilVergiDairesi='"+text_verdaire_1.getText()+"',MuvekkilVergiNo='"+text_verno_1.getText()+"',Muvekkileposta='"+text_eposta.getText()+"',MuvekkilAdres='"+text_adres.getText()+"',Muvekkilaciklama='"+text_aciklama_1.getText()+"',MuvekkilIl='"+text_il_1.getText()+"',Muvekkililce='"+text_ilce_1.getText()+"',MuvekkilAvukat='"+text_avukat_1.getText()+"', SirketSSKIsYeriNo='"+text_sskisyerino.getText()+"',SirketUnvani='"+text_turu_unvan.getText()+"'  where MuvekkilTC='"+muvekkilanaform.id_sakla+"'"; 
						String guncelle_sorgu="update muvekkilbilgi set MuvekkilTC='"+text_ticsicno_1.getText()+"', MuvekkilAdi='"+text_ad_1.getText()+"',MuvekkilSoyadi='"+text_soyad_1.getText()+"',MuvekkilDogumTarihi='"+tarih1+"',MuvekkilDogumYeri='"+text_dogyer_1.getText()+"',MuvekkilTelefon='"+text_tel_1.getText()+"',MuvekkilBabaAdi='"+text_babaad_1.getText()+"',MuvekkilAnaAdi='"+text_anaad_1.getText()+"',MuvekkilCinsiyet='"+comboBox_cinsiyet_1.getSelectedItem().toString()+"',	MuvekkilVergiDairesi='"+text_verdaire_1.getText()+"',MuvekkilVergiNo='"+text_verno_1.getText()+"',Muvekkileposta='"+text_eposta.getText()+"',MuvekkilAdres='"+text_adres.getText()+"',Muvekkilaciklama='"+text_aciklama_1.getText()+"',MuvekkilIl='"+text_il_1.getText()+"',Muvekkililce='"+text_ilce_1.getText()+"',MuvekkilAvukat='"+comboBox_avukat.getSelectedItem().toString()+"', SirketSSKIsYeriNo='"+text_sskisyerino.getText()+"',SirketUnvani='"+text_turu_unvan.getText()+"'  where MuvekkilTC='"+hukukMuvekkilanaform.id_sakla+"'";
									
		    			try {
										System.out.println(hukukBaglanti.sunucuparametresi);
										myconn=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
										mystat=myconn.createStatement();
										mystat.executeUpdate(guncelle_sorgu);
										JOptionPane.showMessageDialog(null,"Güncelleme Baþarýlý");
										
										//hukukMuvekkilanaform form = new hukukMuvekkilanaform();
										//form.setVisible(true);
										//form.setLocationRelativeTo(null);
										dispose();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					
		    		}

		    	}
		    });
		    btnGncelle.setFont(new Font("Tahoma", Font.BOLD, 13));
		    btnGncelle.setBounds(195, 452, 100, 30);
		    
		  
		    
		 
		    
		    JButton btnkaydet = new JButton("Kaydet");
		    btnkaydet.addActionListener(new ActionListener() {
		    	@Override
				public void actionPerformed(ActionEvent e) {
		    		
					String tarih1;//
					
					Date date =new Date();

					if (text_dogtar_1.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih1=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih1=sdf.format(text_dogtar_1.getDate());//TARIH FORMATLAMA
						System.out.println(tarih1);}
					
		    		if((text_ticsicno_1.getText().equals(""))||(text_ad_1.getText().equals("")))
		    		{
						JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

		    		}
		    		else {
			    			ResultSet rs1=null;
							try
							{
								System.out.println(hukukBaglanti.sunucuparametresi);
								String muvekkil_kontrol="select * from muvekkilbilgi where MuvekkilTC='"+text_ticsicno_1.getText()+"'";
								myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
		 						mystat1=myconn1.createStatement();
								rs1=mystat1.executeQuery(muvekkil_kontrol);
								if(rs1.next())
								{
			    			
									JOptionPane.showMessageDialog(null,"Muvekkil TC mevcuttur. Onceden kayit edilmistir.!!");
						    			
								}
								else
								{

	    							//String ekle_sorgu="insert into muvekkilbilgi(MuvekkilTC,MuvekkilAdi,MuvekkilSoyadi,MuvekkilDogumTarihi,MuvekkilDogumYeri,MuvekkilTelefon,MuvekkilBabaAdi,MuvekkilAnaAdi,MuvekkilCinsiyet,MuvekkilVergiDairesi,MuvekkilVergiNo,Muvekkileposta,MuvekkilAdres,Muvekkilaciklama,MuvekkilIl,Muvekkililce,MuvekkilAvukat,SirketSSKIsYeriNo,SirketUnvani)values('"+text_ticsicno_1.getText()+"','"+text_ad_1.getText()+"','"+text_soyad_1.getText()+"','"+text_dogtar_1.getText()+"','"+text_dogyer_1.getText()+"','"+text_tel_1.getText()+"','"+text_babaad_1.getText()+"','"+text_anaad_1.getText()+"','"+comboBox_cinsiyet_1.getSelectedItem().toString()+"','"+text_verdaire_1.getText()+"','"+text_verno_1.getText()+"','"+text_eposta.getText()+"','"+text_adres.getText()+"','"+text_aciklama_1.getText()+"','"+text_il_1.getText()+"','"+text_ilce_1.getText()+"','"+text_avukat_1.getText()+"','"+text_sskisyerino.getText()+"','"+text_turu_unvan.getText()+"')";
									String ekle_sorgu="insert into muvekkilbilgi(MuvekkilTC,MuvekkilAdi,MuvekkilSoyadi,MuvekkilDogumTarihi,MuvekkilDogumYeri,MuvekkilTelefon,MuvekkilBabaAdi,MuvekkilAnaAdi,MuvekkilCinsiyet,MuvekkilVergiDairesi,MuvekkilVergiNo,Muvekkileposta,MuvekkilAdres,Muvekkilaciklama,MuvekkilIl,Muvekkililce,MuvekkilAvukat,SirketSSKIsYeriNo,SirketUnvani)values('"+text_ticsicno_1.getText()+"','"+text_ad_1.getText()+"','"+text_soyad_1.getText()+"','"+tarih1+"','"+text_dogyer_1.getText()+"','"+text_tel_1.getText()+"','"+text_babaad_1.getText()+"','"+text_anaad_1.getText()+"','"+comboBox_cinsiyet_1.getSelectedItem().toString()+"','"+text_verdaire_1.getText()+"','"+text_verno_1.getText()+"','"+text_eposta.getText()+"','"+text_adres.getText()+"','"+text_aciklama_1.getText()+"','"+text_il_1.getText()+"','"+text_ilce_1.getText()+"','"+comboBox_avukat.getSelectedItem().toString()+"','"+text_sskisyerino.getText()+"','"+text_turu_unvan.getText()+"')";
									try {
										System.out.println(hukukBaglanti.sunucuparametresi);
										myconn=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
			 							mystat=myconn.createStatement();
										mystat.executeUpdate(ekle_sorgu);
										JOptionPane.showMessageDialog(null,"Ýslem Basarili");
										
										//hukukMuvekkilanaform form = new hukukMuvekkilanaform();
										//form.setVisible(true);
										//form.setLocationRelativeTo(null);
										dispose();
					    			} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}					
							}catch(Exception hata)
							{
								System.err.println(hata);
							}	
		    		}
						 
				}
			});
		    	
		    		
		    	
             
		    btnkaydet.setFont(new Font("Tahoma", Font.BOLD, 13));
		    btnkaydet.setBounds(195, 452, 100, 30);
		    
		    if(hukukMuvekkilanaform.id=="0")
		    {
		    	 text_ticsicno_1.enable();
		    	 contentPane.add(btnkaydet);
		    }
		    else
		    {
		    	  text_ticsicno_1.disable();
		    	  contentPane.add(btnGncelle);
		    }
		    
		  
		    
		    
		    
		    JButton btn_vazgec = new JButton("Vazgec");
		    btn_vazgec.addActionListener(new ActionListener() {
		    	@Override
				public void actionPerformed(ActionEvent e) {
		    		//hukukMuvekkilanaform muvekkil = new hukukMuvekkilanaform();
					//muvekkil.setVisible(true);
					//muvekkil.setLocationRelativeTo(null);
		    		dispose();
		    	}
		    });
		    btn_vazgec.setFont(new Font("Tahoma", Font.BOLD, 13));
		    btn_vazgec.setBounds(431, 452, 100, 30);
		    contentPane.add(btn_vazgec);
		    
		  
		    
		  JButton btn_vazgec_1 = new JButton("Temizle");
		  btn_vazgec_1.addActionListener(new ActionListener() {
		  	@Override
			public void actionPerformed(ActionEvent e) {
		  		text_ad_1.setText("");
				text_ticsicno_1.setText("");
				text_soyad_1.setText("");
				//text_dogtar_setToolTipTextte(null);
				text_dogyer_1.setText("");
				text_tel_1.setText("");
				text_babaad_1.setText("");
				text_anaad_1.setText("");
				text_eposta.setText("");
				text_verdaire_1.setText("");
				text_verno_1.setText("");
				text_il_1.setText("");
				text_ilce_1.setText("");
				text_adres.setText("");
				text_aciklama_1.setText("");
				//text_avukat_1.setText("");
				text_turu_unvan.setText("");
				text_sskisyerino.setText("");
		  	}
		  });
		    btn_vazgec_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		    btn_vazgec_1.setBounds(321, 452, 100, 30);
		    contentPane.add(btn_vazgec_1);
		    

		    
		      addWindowListener(new WindowAdapter() {
				
				@Override
				public void windowActivated(WindowEvent e) {
					
					//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement mystata eklemeyi unutma
					ResultSet rsa = null;
					ResultSet rsa1 = null;
					comboBox_avukat.removeAllItems();//bunu yapmazsam her hata mesajýndan sonra tekrar
					                                  //avukatlarý üst üste ekliyor

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
						
						hukukMuvekkilanaform.id_sakla=hukukMuvekkilanaform.id;
						hukukMuvekkilanaform.id="0";
						ResultSet rs = null;
						
						System.out.println(hukukBaglanti.sunucuparametresi);
						myconn=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
						String listele="Select * From muvekkilbilgi where MuvekkilTC='"+hukukMuvekkilanaform.id_sakla+"'";
						mystat=myconn.createStatement();
						rs=mystat.executeQuery(listele);
						if(rs.next())
						{
						 
							text_ad_1.setText(rs.getString("MuvekkilAdi"));
							text_ticsicno_1.setText(rs.getString("MuvekkilTC"));
							text_soyad_1.setText(rs.getString("MuvekkilSoyadi"));
							text_dogtar_1.setDate(rs.getDate("MuvekkilDogumTarihi"));
							text_dogyer_1.setText(rs.getString("MuvekkilDogumYeri"));
							text_tel_1.setText(rs.getString("MuvekkilTelefon"));
							text_babaad_1.setText(rs.getString("MuvekkilBabaAdi"));
							text_anaad_1.setText(rs.getString("MuvekkilAnaAdi"));
							//comboBox_cinsiyet.setText(rs.getString("MuvekkilCinsiyet"));
							String cins=rs.getString("MuvekkilCinsiyet");
							if(cins.equals("BAYAN"))
							{
								comboBox_cinsiyet_1.setSelectedIndex(0);
							}
							else
							{
								comboBox_cinsiyet_1.setSelectedIndex(1);
							}
							if(cins.equals("ISLETME"))
							{
								comboBox_cinsiyet_1.setSelectedIndex(2);
							}	
							
							
							text_eposta.setText(rs.getString("Muvekkileposta"));
							text_verdaire_1.setText(rs.getString("MuvekkilVergiDairesi"));
							text_verno_1.setText(rs.getString("MuvekkilVergiNo"));
							text_il_1.setText(rs.getString("MuvekkilIl"));
							text_ilce_1.setText(rs.getString("Muvekkililce"));
							text_adres.setText(rs.getString("MuvekkilAdres"));
							text_aciklama_1.setText(rs.getString("Muvekkilaciklama"));
							comboBox_avukat.setSelectedItem(rs.getString("MuvekkilAvukat"));
							//text_avukat_1.setText(rs.getString("MuvekkilAvukat"));
							text_turu_unvan.setText(rs.getString("SirketUnvani"));
							text_sskisyerino.setText(rs.getString("SirketSSKIsYeriNo"));
							
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
		    
		    
		    
		  }
		}
