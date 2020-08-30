package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.NotLinkException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JDialog;

//public class hukukMuvekkilhukukihareketekle extends JFrame {
public class hukukMuvekkilhukukihareketekle extends JDialog {
	 static Connection myconn1,myconn2,myconna;
	    static Statement mystat1,mystat2,mystata,mystata1;


	private JPanel contentPane;
	private JTextField txtTC;
	private JTextField txtadi;
	private JTextField txttipi;
	private JTextField txttarih;
	private JTextField txttakiptarihi;
	private JTextField txtdairesi;
	private JTextField txtmemur;
	private JTextField txttalep;
	private JTextField txttahsil;
	private JTextField txthatirlat;
	private JTextArea txtnotlar;
	private JTextArea txticra;
	private JTextArea txthareket;
	private JTextField hakedis;
	private JTextField hareketnotxt;
	private JComboBox comboBox_avukat;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukMuvekkilhukukihareketekle frame = new hukukMuvekkilhukukihareketekle();
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
	public hukukMuvekkilhukukihareketekle() {
		
		
		setModal(true);
		setResizable(false);
		setTitle("Muvekkil Hukuki Hareket Ekle / Duzenle");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 840, 420);
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
		Image img = new ImageIcon(this.getClass().getResource("/Notary-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 51, 200, 318);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Muvekkil Hukuki Hareket Ekle /Duzenle");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 11, 429, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hareket Tarihi:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(220, 147, 111, 14);
		contentPane.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Hareket Aciklamasi:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(220, 207, 126, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextArea txticra = new JTextArea();
		txticra.setText("Icra");
		txticra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txticra.setLocation(362, 0);
//		txticra.setBounds(352, 229, 144, 47);
		contentPane.add(txticra);
		txticra.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txticra.getText().length() >= 100 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtdairesi.requestFocus();
				}
			}
	    });
		JScrollPane scroll = new JScrollPane(txticra);
		scroll.setBounds(352, 261, 144, 47);                     // <-- THIS
	    getContentPane().add(scroll);
	    setLocationRelativeTo ( null );
	    txticra.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    txticra.setLineWrap(true);
		
		JLabel lblNewLabel_6 = new JLabel("Muvekkil TC *:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(220, 87, 105, 14);
		contentPane.add(lblNewLabel_6);
		
		
		JLabel lblNewLabel_4_1 = new JLabel("Aciklama:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(522, 206, 79, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JTextArea txtnotlar = new JTextArea();
		//txtnotlar.setBounds(665, 205, 144, 47);
		contentPane.add(txtnotlar);
		txtnotlar.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtnotlar.getText().length() >= 100 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hakedis.requestFocus();
				}
			}
	    });
		JScrollPane scroll1 = new JScrollPane(txtnotlar);
		scroll1.setBounds(665, 205, 144, 47);                     // <-- THIS
	    getContentPane().add(scroll1);
	    setLocationRelativeTo ( null );
	    txtnotlar.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    txtnotlar.setLineWrap(true);
		
		JLabel lblNewLabel_2_1 = new JLabel("Icra Takip Tarihi:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(522, 55, 115, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Icra Dairesi:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(522, 85, 115, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Icra Memuru:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(522, 115, 115, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Icra Talep Tutari *:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4.setBounds(522, 145, 115, 14);
		contentPane.add(lblNewLabel_2_4);
		
		
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Icra Tahsil Tutari *:");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4_1.setBounds(522, 175, 133, 14);
		contentPane.add(lblNewLabel_2_4_1);
		
		JLabel lblNewLabel_3 = new JLabel("Avukat Adi:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(220, 117, 111, 14);
		contentPane.add(lblNewLabel_3);
	
		JLabel lblNewLabel_4_2 = new JLabel("Icra Aciklamasi:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2.setBounds(220, 261, 109, 14);
		contentPane.add(lblNewLabel_4_2);
		
		JTextArea txtaciklama = new JTextArea();
		txtaciklama.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtaciklama.setText("Talep");
//		txtaciklama.setBounds(352, 175, 144, 47);
		contentPane.add(txtaciklama);
		txtaciklama.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtaciklama.getText().length() >= 100 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txticra.requestFocus();
				}
			}
	    });
		JScrollPane scroll2 = new JScrollPane(txtaciklama);
		scroll2.setBounds(352, 207, 144, 47);                     // <-- THIS
	    getContentPane().add(scroll2);
	    setLocationRelativeTo ( null );
	    txtaciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    txtaciklama.setLineWrap(true);
		
		JLabel lblNewLabel_7 = new JLabel("Hareket Tipi:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(220, 177, 95, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Hatirlat:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1.setBounds(522, 263, 79, 14);
		contentPane.add(lblNewLabel_7_1);
		
		txtTC = new JTextField();
		txtTC.setEditable(false);
		txtTC.setEnabled(false);
		txtTC.setBounds(352, 87, 144, 20);
		contentPane.add(txtTC);
		txtTC.setColumns(10);
		txtTC.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtTC.getText().length() >= 11 ) // limit to 3 characters
	                e.consume();
	        }
	    });
		
		//txtadi = new JTextField();
		//txtadi.setBounds(352, 117, 144, 20);
		//contentPane.add(txtadi);
		//txtadi.setColumns(10);
		
	     //AVUKATI COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
	      comboBox_avukat = new JComboBox();
	      comboBox_avukat.addKeyListener(new KeyAdapter() {
	      	@Override
	      	public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txttipi.requestFocus();
				}
	      	}
	      });
	      comboBox_avukat.setBounds(352, 117, 144, 20);
	      contentPane.add(comboBox_avukat);
		  //AVUKATI COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		
	    JDateChooser txttarih = new JDateChooser();
	    txttarih.setBounds(352, 147, 144, 20);
	    txttarih.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txttarih);
		
		//txttarih = new HintTextField("Example=2020-03-03");
		//txttarih.setBounds(352, 115, 144, 20);
		//contentPane.add(txttarih);
		//txttarih.setColumns(10);
		
		
		txttipi = new JTextField();
		txttipi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtaciklama.requestFocus();
				}
			}
		});
		txttipi.setText("Icra , Dilekce , Talep vs");
		txttipi.setBounds(352, 177, 144, 20);
		contentPane.add(txttipi);
		txttipi.setColumns(10);
		
	    JDateChooser txttakiptarihi = new JDateChooser();
	    txttakiptarihi.setBounds(665, 55, 144, 20);
	    txttakiptarihi.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txttakiptarihi);
		
		//txttakiptarihi = new HintTextField("Example=2020-03-03");
		//txttakiptarihi.setColumns(10);
		//txttakiptarihi.setBounds(665, 55, 144, 20);
		//contentPane.add(txttakiptarihi);
		
		txtdairesi = new JTextField();
		txtdairesi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtmemur.requestFocus();
				}
			}
		});
		txtdairesi.setText("Icra Dairesi");
		txtdairesi.setColumns(10);
		txtdairesi.setBounds(665, 85, 144, 20);
		contentPane.add(txtdairesi);
		
		txtmemur = new JTextField();
		txtmemur.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txttalep.requestFocus();
				}
			}
		});
		txtmemur.setColumns(10);
		txtmemur.setBounds(665, 115, 144, 20);
		contentPane.add(txtmemur);
		
		txttalep = new JTextField();
		txttalep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (txttalep.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txttahsil.requestFocus();
				}
			}
		});
		
		txttalep.setHorizontalAlignment(SwingConstants.RIGHT);
		txttalep.setText("0.00");
		txttalep.setColumns(10);
		txttalep.setBounds(665, 145, 144, 20);
		contentPane.add(txttalep);
		
		txttahsil = new JTextField();
		txttahsil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (txttahsil.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtnotlar.requestFocus();
				}
			}
		});
		txttahsil.setHorizontalAlignment(SwingConstants.RIGHT);
		txttahsil.setText("0.00");
		txttahsil.setColumns(10);
		txttahsil.setBounds(665, 175, 144, 20);
		contentPane.add(txttahsil);
		
	    JDateChooser txthatirlat = new JDateChooser();
	    txthatirlat.setBounds(665, 263, 144, 20);
	    txthatirlat.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txthatirlat);
		
		//txthatirlat = new HintTextField("Example=2020-03-03");
		//txthatirlat.setColumns(10);
		//txthatirlat.setBounds(665, 263, 144, 20);
		//contentPane.add(txthatirlat);
		
		JButton btnNewButton_2 = new JButton("Vazgec");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hukukMuvekkilhukukihareketler hukuki = new hukukMuvekkilhukukihareketler();
				//hukuki.setVisible(true);
				//hukuki.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(542, 339, 100, 30);
		contentPane.add(btnNewButton_2);
		
	
		
		JButton btnNewButton_4 = new JButton("Temizle");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtTC.setText("");
				//txtadi.setText("");
				//txttarih.setText("");
				txttipi.setText("");
				txtaciklama.setText("");
				txticra.setText("");
				//txttakiptarihi.setText("");
				txtdairesi.setText("");
				txtmemur.setText("");
				txttalep.setText("0");
				txttahsil.setText("0");
				txtnotlar.setText("");
				hakedis.setText("0");
				//txthatirlat.setText("");
			
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(432, 339, 100, 30);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Hakedis Tutari :");
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4_1_1.setBounds(522, 294, 111, 14);
		contentPane.add(lblNewLabel_2_4_1_1);
		
		hakedis = new JTextField();
		hakedis.setHorizontalAlignment(SwingConstants.RIGHT);
		hakedis.setText("0.00");
		hakedis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (hakedis.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboBox_avukat.requestFocus();
				}
			}
		});
		hakedis.setColumns(10);
		hakedis.setBounds(665, 294, 144, 20);
		contentPane.add(hakedis);
		
		JLabel lblNewLabel_6_1 = new JLabel("Hareket No:");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(220, 56, 105, 14);
		contentPane.add(lblNewLabel_6_1);
		
		hareketnotxt = new JTextField();
		hareketnotxt.setEnabled(false);
		hareketnotxt.setEditable(false);
		hareketnotxt.setColumns(10);
		hareketnotxt.setBounds(352, 56, 144, 20);
		contentPane.add(hareketnotxt);
		
		JButton btnNewButton_2_1 = new JButton("Kaydet");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				String tcal=hukukMuvekkilhukukihareketler.id_al,tarih1,tarih2,tarih3;//TCNUMARASINI ALIYOR
				txtTC.setText(tcal);
				
				Date date =new Date();

				if (txttarih.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih1=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih1=sdf.format(txttarih.getDate());//TARIH FORMATLAMA
					System.out.println(tarih1);}


				if (txttakiptarihi.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(date);} 
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(txttakiptarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih2);}
				
				
				if (txthatirlat.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih3=sdf1.format(date);} 
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih3=sdf1.format(txthatirlat.getDate());//TARIH FORMATLAMA
					System.out.println(tarih3);}
				

				if ((txttalep.getText()).equals("")){txttalep.setText("0");} 
				if ((txttahsil.getText()).equals("")){txttahsil.setText("0");}
				if ((hakedis.getText()).equals("")){hakedis.setText("0");}
				 
			 	if( txtTC.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");
				}
			 		else
				{
					ResultSet rs1=null;
					
					try
					{

						String muvekkil_kontrol="select * from muvekkilbilgi where MuvekkilTC='"+txtTC.getText()+"' ";
						myconn2=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
 						mystat2=myconn2.createStatement();
						rs1=mystat2.executeQuery(muvekkil_kontrol);
						if(rs1.next())
						{
								String sorgu_ekle="insert into muvekkilhukukihareket(HareketTarihi,HareketNotlari,HareketAciklamasi,IcraTakipTarihi,HareketAvukati,HareketTipi,MuvekkilTC,IcraDairesi,IcraMemuru,IcraTalepTutari,IcraTahsiledilentutar,Aciklama,hatirlat,hakedis)"
										+ "values('"+tarih1+"','"+ txtnotlar.getText()+"','"+ txtaciklama.getText()+"','"+ tarih2+"','"+comboBox_avukat.getSelectedItem().toString()+"','"+ txttipi.getText()+"','"+tcal+"','"+txtdairesi.getText()+"','"+ txtmemur.getText()+"','"+txttalep.getText()+"','"+txttahsil.getText()+"','"+ txticra.getText()+"','"+tarih3+"','"+hakedis.getText()+"')";
								
								try {
									myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
									mystat1=myconn1.createStatement();
									mystat1.executeUpdate(sorgu_ekle);
									JOptionPane.showMessageDialog(null,"Hakedis var ise Cari Hareketlere ayrýca iþleyiniz..Islem Basarýlý");
									//hukukMuvekkilhukukihareketler hukuki = new hukukMuvekkilhukukihareketler();
									//hukuki.setVisible(true);
									//hukuki.setLocationRelativeTo(null);
									dispose();
								
								}catch(Exception hata)
								{
									System.err.println(hata);
								} 
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Muvekkil TC kontrol ediniz. Boyle bir TC yoktur.");

						}					
					}catch(Exception hata)
					{
						System.err.println(hata);
					} 
				}  
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2_1.setBounds(317, 339, 100, 30);
	
		if(hukukMuvekkilhukukihareketler.id==0) contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Guncelle");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih4,tarih5,tarih6;//TCNUMARASINI ALIYOR
				Date date =new Date();
				
				if (txttarih.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih4=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih4=sdf.format(txttarih.getDate());//TARIH FORMATLAMA
					System.out.println(tarih4);}


				if (txttakiptarihi.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih5=sdf1.format(date);} 
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih5=sdf1.format(txttakiptarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih5);}
				
				
				if (txthatirlat.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih6=sdf1.format(date);} 
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih6=sdf1.format(txthatirlat.getDate());//TARIH FORMATLAMA
					System.out.println(tarih6);}
				

				if ((txttalep.getText()).equals("")){txttalep.setText("0");} 
				if ((txttahsil.getText()).equals("")){txttahsil.setText("0");}
				if ((hakedis.getText()).equals("")){hakedis.setText("0");}
				 
				String tcal=hukukMuvekkilhukukihareketler.id_al;//TCNUMARASINI ALIYOR
				txtTC.setText(tcal);
				
				if(  txtTC.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{ //müvekkil kontrolü için
					
					ResultSet rs1=null;
						
					try
					{
						String muvekkil_kontrol="select * from muvekkilbilgi where MuvekkilTC='"+txtTC.getText()+"' ";
						myconn2=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
 						mystat2=myconn2.createStatement();
						rs1=mystat2.executeQuery(muvekkil_kontrol);
						if(rs1.next())
						{
							String guncelle="update muvekkilhukukihareket set HareketTarihi='"+ tarih4+"',HareketNotlari='"+ txtnotlar.getText()+"',HareketAciklamasi='"+txtaciklama.getText()+"',IcraTakipTarihi='"+tarih5+"',HareketAvukati='"+comboBox_avukat.getSelectedItem().toString()+"',HareketTipi='"+ txttipi.getText()+"',MuvekkilTC='"+ txtTC.getText()+"',IcraDairesi='"+txtdairesi.getText()+"',IcraMemuru='"+txtmemur.getText()+"',IcraTalepTutari='"+txttalep.getText()+"',IcraTahsiledilentutar='"+ txttahsil.getText()+"',Aciklama='"+txticra.getText()+"',hatirlat='"+tarih6+"',hakedis='"+hakedis.getText()+"' where HareketNo='"+hukukMuvekkilhukukihareketler.sakla_id+"'";
							try 
							{
								myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
								mystat1=myconn1.createStatement();
								mystat1.executeUpdate(guncelle);
								JOptionPane.showMessageDialog(null,"Hakedis var ise Cari Hareketlere ayrýca iþleyiniz..Güncelleme Baþarýlý");
								
								//hukukMuvekkilhukukihareketler hukuki=new hukukMuvekkilhukukihareketler();
								//hukuki.setVisible(true);
								//hukuki.setLocationRelativeTo(null);
								dispose();
							}catch(Exception hata)
							{
								System.err.println(hata);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Müvekkil TC kontrol ediniz. Böyle bir TC yoktur.");

						}					
					}catch(Exception hata)
					{
						System.err.println(hata);
					}
						
				}
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2_1_1.setBounds(317, 339, 100, 30);
		
		if(hukukMuvekkilhukukihareketler.id!=0) contentPane.add(btnNewButton_2_1_1);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("Pencere Acildi");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("Pencere kapandi");
			}
			@Override
			public void windowActivated(WindowEvent e) {
				
				//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement mystata eklemeyi unutma
				ResultSet rsa = null;
				ResultSet rsa1 = null;
				comboBox_avukat.removeAllItems();//bunu yapmazsam her hata mesajýndan sonra tekrar
				                                  //avukatlarý üst üste ekliyor

				
				 System.out.println(hukukMuvekkilhukukihareketler.id);
				 hukukMuvekkilhukukihareketler.sakla_id=hukukMuvekkilhukukihareketler.id;
				 hukukMuvekkilhukukihareketler.id=0;
				 
				 String tcal=hukukMuvekkilhukukihareketler.id_al;//TCNUMARASINI ALIYOR
				 txtTC.setText(tcal);
					
				 ResultSet rs=null;
				  try 
					{
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
						
					  
					  
						myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
						String listele="select * from muvekkilhukukihareket where HareketNo='"+hukukMuvekkilhukukihareketler.sakla_id+"'";
						mystat1=myconn1.createStatement();
						rs=mystat1.executeQuery(listele);
						if(rs.next())
						{
							 
							txttarih.setDate(rs.getDate("HareketTarihi"));
							txtnotlar.setText(rs.getString("HareketNotlari"));
							txtaciklama.setText(rs.getString("HareketAciklamasi"));
							txttakiptarihi.setDate(rs.getDate("IcraTakipTarihi"));
							comboBox_avukat.setSelectedItem(rs.getString("HareketAvukati"));
							txttipi.setText(rs.getString("HareketTipi"));
							txtTC.setText(rs.getString("MuvekkilTC"));
							txtdairesi.setText(rs.getString("IcraDairesi"));
							txtmemur.setText(rs.getString("IcraMemuru"));
							txttalep.setText(rs.getString("IcraTalepTutari"));
							txttahsil.setText(rs.getString("IcraTahsiledilentutar"));
							txticra.setText(rs.getString("Aciklama"));
							txthatirlat.setDate(rs.getDate("hatirlat"));
							hakedis.setText(rs.getString("hakedis"));
							hareketnotxt.setText(rs.getString("HareketNo"));
						}
						
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				 
			}
		});
	
		
		
	}
}
