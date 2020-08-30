package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
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
import java.awt.TextField;
import javax.swing.JDialog;
import javax.swing.JFrame;

//public class hukukBurobilgiekleduzenle extends JFrame {
public class hukukBurobilgiekleduzenle extends JDialog {
	
	static Connection myconn;
	static Statement mystat;

	private JPanel contentPane;
	private JTextField unvan;
	private JTextField sehir;
	private JTextField postakodu;
	private JTextField ilce;
	private JTextField mail;
	private JTextField vergidairesi;
	private JTextField vergino;
	private JTextField b1;
	private JTextField b2;
	private JTextField tel;
	private JTextField gsm;
	private JTextField b3;
	private JTextField b4;
	private JTextField textField;
	private JTextField buroidtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukBurobilgiekleduzenle frame = new hukukBurobilgiekleduzenle();
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
	public hukukBurobilgiekleduzenle() {
		
		setModal(true);
		setResizable(false);
		setTitle("Buro Bilgi Detay Ekrani");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 811, 505);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTextArea aciklama = new JTextArea();
		aciklama.setFont(new Font("Tahoma", Font.PLAIN, 11));
		aciklama.setText("Aciklama");
		contentPane.add(aciklama);
		JScrollPane scroll = new JScrollPane(aciklama);
		scroll.setBounds(637, 271, 142, 99);                     // <-- THIS
	    getContentPane().add(scroll);
	    setLocationRelativeTo ( null );
	    aciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    aciklama.setLineWrap(true); //satir sonu bir alta almak icin
		
		JTextArea adres = new JTextArea();
		adres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					tel.requestFocus();
				}
			}
		});
		adres.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adres.setText("Adres");
		contentPane.add(adres);
		JScrollPane scroll1 = new JScrollPane(adres);
		scroll1.setBounds(344, 208, 144, 101);                     // <-- THIS
	    getContentPane().add(scroll1);
	    setLocationRelativeTo ( null );
		adres.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
		adres.setLineWrap(true); //satir sonu bir alta almak icin
		
		aciklama.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (aciklama.getText().length() >= 100 ) // limit to 3 characters
	                e.consume();
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
				int id_al=hukukBurobilgiana.id;
				ResultSet rs = null;
				try {
					myconn=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					String listele="Select * From burobilgi where BuroID='"+id_al+"'";
					mystat=myconn.createStatement();
					rs=mystat.executeQuery(listele);
					if(rs.next())
					{
						unvan.setText(rs.getString("BuroUnvani"));
						sehir.setText(rs.getString("BuroSehir"));
						postakodu.setText(rs.getString("BuroPostaKodu"));
						ilce.setText(rs.getString("BuroIlce"));
						mail.setText(rs.getString("BuroEPosta"));
						vergidairesi.setText(rs.getString("BuroVergiDairesi"));
						vergino.setText(rs.getString("BuroVergiNo"));
						b1.setText(rs.getString("BuroOrtak1"));
						b2.setText(rs.getString("BuroOrtak2"));
						b3.setText(rs.getString("BuroOrtak3"));
						b4.setText(rs.getString("BuroOrtak4"));
						tel.setText(rs.getString("BuroTelefon"));
						gsm.setText(rs.getString("BuroCepTel"));
						adres.setText(rs.getString("BuroAdresi"));
						aciklama.setText(rs.getString("BuroAciklama"));
						buroidtxt.setText(rs.getString("BuroID"));
						hukukBurobilgiana.id_sakla=hukukBurobilgiana.id;
						hukukBurobilgiana.id=0;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		Image img = new ImageIcon(this.getClass().getResource("/office-women-pink-icon (1).png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 57, 188, 381);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buro Bilgi Detay Ekrani");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 11, 356, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Buro Unvani *:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(223, 88, 111, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Posta Kodu:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(223, 178, 111, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("Buro Ilce:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(223, 148, 95, 14);
		contentPane.add(lblNewLabel_7);
		
		unvan = new JTextField();
		unvan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					sehir.requestFocus();
				}
			}
		});
		unvan.setBounds(344, 88, 144, 20);
		contentPane.add(unvan);
		unvan.setColumns(10);
		
		sehir = new JTextField();
		sehir.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					ilce.requestFocus();
				}
			}
		});
		sehir.setText("Istanbul");
		sehir.setBounds(344, 118, 144, 20);
		contentPane.add(sehir);
		sehir.setColumns(10);
		
		postakodu = new HintTextField("Max Uzunluk=5");
		postakodu.setBounds(344, 178, 144, 20);
		contentPane.add(postakodu);
		postakodu.setColumns(10);
		 

//Yazý sýnýrlandýrma için
		postakodu.addKeyListener(new KeyAdapter() {
		        @Override
		        public void keyTyped(KeyEvent e) {
		            if (postakodu.getText().length() >= 5 ) // limit to 3 characters
		                e.consume();
		        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					adres.requestFocus();
				}
			}
		    });
	 
 		
		JButton btnNewButton_2 = new JButton("Vazgec");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(336, 408, 100, 30);
		contentPane.add(btnNewButton_2);
	 
		
		JButton btnNewButton_3 = new JButton("Kaydet");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String buro_unvan,buro_adres,buro_ilce,buro_sehir,buro_telefon,buro_gsm,buro_mail,buro_vergino,buro_ortak1,buro_ortak2,buro_ortak3,buro_ortak4,buro_aciklama,buro_vergidairesi;
				String buro_postakodu;
				buro_unvan=unvan.getText();
				buro_sehir=sehir.getText();
				buro_postakodu=postakodu.getText();
				buro_ilce=ilce.getText();
				buro_mail=mail.getText();
				buro_vergidairesi=vergidairesi.getText();
				buro_vergino=vergino.getText();
				buro_ortak1=b1.getText();
				buro_ortak2=b2.getText();
				buro_ortak3=b3.getText();
				buro_ortak4=b4.getText();
				buro_telefon=tel.getText();
				buro_gsm=gsm.getText();
				buro_adres=adres.getText();
				buro_aciklama=aciklama.getText();
				if(buro_unvan.equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					//System.out.println(buro_unvan+"\n "+buro_sehir+"  \n"+buro_postakodu+" \n"+buro_ilce+" \n"+buro_mail+"\n "+buro_vergidairesi+"\n "+buro_vergino+"\n "+buro_ortak1+" \n"+buro_ortak2+"\n "+buro_ortak3+"\n "+buro_ortak4+" \n"+buro_telefon+" \n"+buro_gsm+"\n "+buro_adres);
					String sorgu_kaydet="insert into burobilgi(	BuroUnvani,BuroAdresi,BuroIlce,BuroSehir,BuroPostaKodu,BuroTelefon,BuroCepTel,BuroEPosta,BuroVergiNo,BuroOrtak1,BuroOrtak2,BuroOrtak3,BuroOrtak4,BuroAciklama,BuroVergiDairesi)values('"+buro_unvan +"','"+buro_adres +"','"+buro_ilce +"',"+ "'"+buro_sehir+"','"+buro_postakodu+"','"+buro_telefon+"','"+buro_gsm+"',"+ "'"+buro_mail+"','"+buro_vergino+"','"+buro_ortak1+"','"+buro_ortak2+"','"+buro_ortak3+"','"+buro_ortak4+"','"+buro_aciklama+"','"+buro_vergidairesi+"')";
					try 
					{
						myconn=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
						mystat=myconn.createStatement();
						mystat.executeUpdate(sorgu_kaydet);
						JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
						 

						dispose();
						System.out.println("Ekleme Basarili");

	
					}catch(Exception hata)
					{
						System.err.println(hata);
					}
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(224, 408, 100, 30);
		

		JButton btnNewButton_3_1 = new JButton("Guncelle");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buro_unvan,buro_adres,buro_ilce,buro_sehir,buro_telefon,buro_gsm,buro_mail,buro_vergino,buro_ortak1,buro_ortak2,buro_ortak3,buro_ortak4,buro_aciklama,buro_vergidairesi;
				String buro_postakodu;
				buro_unvan=unvan.getText();
				buro_sehir=sehir.getText();
				buro_postakodu=postakodu.getText();
				buro_ilce=ilce.getText();
				buro_mail=mail.getText();
				buro_vergidairesi=vergidairesi.getText();
				buro_vergino=vergino.getText();
				buro_ortak1=b1.getText();
				buro_ortak2=b2.getText();
				buro_ortak3=b3.getText();
				buro_ortak4=b4.getText();
				buro_telefon=tel.getText();
				buro_gsm=gsm.getText();
				buro_adres=adres.getText();
				buro_aciklama=aciklama.getText();
				if(buro_unvan.equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					//System.out.println(buro_unvan+"\n "+buro_sehir+"  \n"+buro_postakodu+" \n"+buro_ilce+" \n"+buro_mail+"\n "+buro_vergidairesi+"\n "+buro_vergino+"\n "+buro_ortak1+" \n"+buro_ortak2+"\n "+buro_ortak3+"\n "+buro_ortak4+" \n"+buro_telefon+" \n"+buro_gsm+"\n "+buro_adres);
					String sorgu_guncelle="update burobilgi set BuroUnvani='"+buro_unvan +"',BuroAdresi='"+buro_adres+"',BuroIlce='"+buro_ilce +"',BuroSehir='"+buro_sehir+"',BuroPostaKodu='"+buro_postakodu+"',BuroTelefon='"+buro_telefon+"',BuroCepTel='"+buro_gsm+"',BuroEPosta='"+buro_mail+"',BuroVergiNo='"+buro_vergino+"',BuroOrtak1='"+buro_ortak1+"',BuroOrtak2='"+buro_ortak2+"',BuroOrtak3='"+buro_ortak3+"',BuroOrtak4='"+buro_ortak4+"',BuroAciklama='"+buro_aciklama+"',BuroVergiDairesi='"+buro_vergidairesi+"' where BuroID='"+hukukBurobilgiana.id_sakla+"'";
					try 
					{
						myconn=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
						mystat=myconn.createStatement();
						mystat.executeUpdate(sorgu_guncelle);
						JOptionPane.showMessageDialog(null,"Güncelleme Baþarýlý");
						 
						
						dispose();
						System.out.println("Ekleme Basarili");

	
					}catch(Exception hata)
					{
						System.err.println(hata);
					}
				}
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1.setBounds(224, 408, 100, 30);
		
		
		if(hukukBurobilgiana.id==0)
		{
			contentPane.add(btnNewButton_3);
		}
		else
		{
			contentPane.add(btnNewButton_3_1);
		}
		
		
		
		JLabel lblNewLabel_4 = new JLabel("BuroTelefon:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(223, 320, 111, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Buro Sehir:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(223, 118, 105, 14);
		contentPane.add(lblNewLabel_6);
		
		ilce = new JTextField();
		ilce.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				postakodu.requestFocus();
				}
			}
		});
		ilce.setText("Merkez");
		ilce.setBounds(344, 148, 144, 20);
		contentPane.add(ilce);
		ilce.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Buro E-Posta:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(510, 57, 115, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Vergi Dairesi *:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(510, 87, 115, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Vergi No:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(510, 117, 115, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Buro Ortak 1:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4.setBounds(510, 147, 115, 14);
		contentPane.add(lblNewLabel_2_4);
		
		mail = new JTextField();
		mail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					vergidairesi.requestFocus();
				}
			}
		});
		mail.setColumns(10);
		mail.setBounds(635, 57, 144, 20);
		contentPane.add(mail);
		
		vergidairesi = new JTextField();
		vergidairesi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					vergino.requestFocus();
				}
			}
		});
		vergidairesi.setColumns(10);
		vergidairesi.setBounds(635, 87, 144, 20);
		contentPane.add(vergidairesi);
		
		vergino = new JTextField();
		vergino.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					b1.requestFocus();
				}
			}
		});
		vergino.setColumns(10);
		vergino.setBounds(635, 117, 144, 20);
		contentPane.add(vergino);
		
		b1 = new JTextField();
		b1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					b2.requestFocus();
				}
			}
		});
		b1.setColumns(10);
		b1.setBounds(635, 147, 144, 20);
		contentPane.add(b1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Buro Ortak 2:");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4_1.setBounds(510, 177, 115, 14);
		contentPane.add(lblNewLabel_2_4_1);
		
		b2 = new JTextField();
		b2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					b3.requestFocus();
				}
			}
		});
		b2.setColumns(10);
		b2.setBounds(635, 177, 144, 20);
		contentPane.add(b2);
		
		JLabel lblNewLabel_4_2 = new JLabel("Adres *:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2.setBounds(225, 208, 109, 14);
		contentPane.add(lblNewLabel_4_2);
		
		
		
		tel = new HintTextField("Max Uzunluk=11");
		tel.setColumns(10);
		tel.setBounds(344, 320, 144, 20);
		contentPane.add(tel);
		tel.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (tel.getText().length() >= 11 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					gsm.requestFocus();
				}
			}
	    });
		
		JLabel lblNewLabel_4_3 = new JLabel("Buro GSM *:");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_3.setBounds(223, 350, 111, 14);
		contentPane.add(lblNewLabel_4_3);
		
		gsm = new HintTextField("Max Uzunluk=11");
		gsm.setColumns(10);
		gsm.setBounds(344, 350, 144, 20);
		contentPane.add(gsm);
		gsm.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (gsm.getText().length() >= 11 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					mail.requestFocus();
				}
			}
	    });
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Buro Ortak 3:");
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4_1_1.setBounds(510, 210, 115, 14);
		contentPane.add(lblNewLabel_2_4_1_1);
		
		JLabel lblNewLabel_2_4_1_2 = new JLabel("Buro Ortak 4:");
		lblNewLabel_2_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4_1_2.setBounds(510, 240, 115, 14);
		contentPane.add(lblNewLabel_2_4_1_2);
		
		b3 = new JTextField();
		b3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					b4.requestFocus();
				}
			}
		});
		b3.setColumns(10);
		b3.setBounds(635, 210, 144, 20);
		contentPane.add(b3);
		
		b4 = new JTextField();
		b4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					aciklama.requestFocus();
				}
			}
		});
		b4.setColumns(10);
		b4.setBounds(635, 240, 144, 20);
		contentPane.add(b4);
		
		JButton temizle = new JButton("Temizle");
		temizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//unvan.setText("");
				sehir.setText("");
				postakodu.setText("");
				ilce.setText("");
				mail.setText("");
				vergidairesi.setText("");
				vergino.setText("");
				b1.setText("");
				b2.setText("");
				b3.setText("");
				b4.setText("");
				tel.setText("");
				gsm.setText("");
				adres.setText("");
				aciklama.setText("");
			}
		});
		temizle.setFont(new Font("Tahoma", Font.BOLD, 13));
		temizle.setBounds(449, 408, 100, 30);
		contentPane.add(temizle);
		
		JLabel lblNewLabel_2_4_1_2_1 = new JLabel("Buro Aciklama:");
		lblNewLabel_2_4_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4_1_2_1.setBounds(510, 273, 115, 14);
		contentPane.add(lblNewLabel_2_4_1_2_1);
		
		JLabel lblNewLabel_2_5 = new JLabel("Buro ID:");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_5.setBounds(223, 57, 111, 14);
		contentPane.add(lblNewLabel_2_5);
		
		buroidtxt = new JTextField();
		buroidtxt.setEnabled(false);
		buroidtxt.setEditable(false);
		buroidtxt.setColumns(10);
		buroidtxt.setBounds(344, 57, 144, 20);
		contentPane.add(buroidtxt);
		
		 
		
		
		
	}
}
