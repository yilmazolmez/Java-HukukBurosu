package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

//import jdk.internal.org.jline.reader.Parser.ParseContext;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JDialog;

public class hukukMuvekkilozelhareketekle extends JDialog {

	private JPanel contentPane;
	private JTextField txtgorusmetarihi;
	private JTextField txtmuvekkiladi;
	private JTextField txtavukatadi;
	private JTextField txtmuvekkiltc;
	private JTextField txthatirlat;
	private JTextArea textAreanotlar_1;
	private JButton btnNewButton_3;
	
	static Connection myconn, myconn1,myconn2,myconna;
	static Statement mystat, mystat1,mystat2,mystata,mystata1;
	private JTextField hakedistxt;
	private JTextField gorusmenotxt;
	private JComboBox comboBox_avukat;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukMuvekkilozelhareketekle frame = new hukukMuvekkilozelhareketekle();
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
	public hukukMuvekkilozelhareketekle() {
		
		setResizable(false);
		setModal(true);
		setTitle("Muvekkil Ozel Gorusme Ekle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 637, 449);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textAreanotlar_1 = new JTextArea();
		//textAreanotlar_1.setLocation(0, 165);
		textAreanotlar_1.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (textAreanotlar_1.getText().length() >= 200 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hakedistxt.requestFocus();
				}
			}
	    });
		contentPane.add(textAreanotlar_1);
		JScrollPane scrollPane = new JScrollPane(textAreanotlar_1);
		scrollPane.setBounds(397, 193, 144, 47);                     // <-- THIS
	    getContentPane().add(scrollPane);
	    setLocationRelativeTo ( null );
		textAreanotlar_1.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
		textAreanotlar_1.setLineWrap(true); //satir sonu bir alta almak icin
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		Image img = new ImageIcon(this.getClass().getResource("/Groups-Meeting-Dark-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 45, 256, 320);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Muvekkil Ozel Gorusme Ekle");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 5, 356, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gorusme Tarihi:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(276, 103, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gorusulen Sahis:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(276, 133, 111, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("Avukat :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(276, 163, 79, 14);
		contentPane.add(lblNewLabel_7);
		
	    JDateChooser txtgorusmetarihi = new JDateChooser();
	    txtgorusmetarihi.setBounds(397, 103, 144, 20);
	    txtgorusmetarihi.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txtgorusmetarihi);
	    
		txtmuvekkiladi = new JTextField();
		txtmuvekkiladi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboBox_avukat.requestFocus();
				}
			}
		});
		txtmuvekkiladi.setBounds(397, 133, 144, 20);
		contentPane.add(txtmuvekkiladi);
		txtmuvekkiladi.setColumns(10);
		
		//txtavukatadi = new JTextField();
		//txtavukatadi.setBounds(397, 163, 144, 20);
		//contentPane.add(txtavukatadi);
		//txtavukatadi.setColumns(10);
		
	     //AVUKATI COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
	      comboBox_avukat = new JComboBox();
	      comboBox_avukat.addKeyListener(new KeyAdapter() {
	      	@Override
	      	public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textAreanotlar_1.requestFocus();
				}
	      	}
	      });
	      comboBox_avukat.setBounds(397, 163, 144, 20);
	      contentPane.add(comboBox_avukat);
		  //AVUKATI COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		
		JLabel lblNewLabel_4 = new JLabel("Aciklama:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(276, 193, 90, 14);
		contentPane.add(lblNewLabel_4);
		

		JLabel lblNewLabel_6 = new JLabel("Muvekkil TC:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(276, 73, 89, 14);
		contentPane.add(lblNewLabel_6);
		
		txtmuvekkiltc = new JTextField();
		txtmuvekkiltc.setEditable(false);
		txtmuvekkiltc.setEnabled(false);
		txtmuvekkiltc.setBounds(397, 73, 144, 20);
		contentPane.add(txtmuvekkiltc);
		txtmuvekkiltc.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("Hatirlat:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1.setBounds(276, 248, 79, 14);
		contentPane.add(lblNewLabel_7_1);
	    
		
	    JDateChooser txthatirlat = new JDateChooser();
	    txthatirlat.setBounds(397, 248, 144, 20);
	    txthatirlat.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txthatirlat);
		
	    hakedistxt = new JTextField();
	    hakedistxt.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtmuvekkiladi.requestFocus();
				}
	    	}
	    	@Override
	    	public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (hakedistxt.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
	    	}
	    });
	    hakedistxt.setHorizontalAlignment(SwingConstants.RIGHT);
		hakedistxt.setText("0.00");
		hakedistxt.setColumns(10);
		hakedistxt.setBounds(397, 278, 144, 20);
		contentPane.add(hakedistxt);
		
		JLabel lblNewLabel_6_1 = new JLabel("Gorusme No:");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(276, 45, 89, 14);
		contentPane.add(lblNewLabel_6_1);
		
		gorusmenotxt = new JTextField();
		gorusmenotxt.setEnabled(false);
		gorusmenotxt.setEditable(false);
		gorusmenotxt.setColumns(10);
		gorusmenotxt.setBounds(397, 45, 144, 20);
		contentPane.add(gorusmenotxt);
	    
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement mystata eklemeyi unutma
				ResultSet rsa = null;
				ResultSet rsa1 = null;
				comboBox_avukat.removeAllItems();//bunu yapmazsam her hata mesajýndan sonra tekrar
				                                  //avukatlarý üst üste ekliyor
				
				String tcal=hukukMuvekkilozelhareketler.id_al;
				txtmuvekkiltc.setText(tcal);
				System.out.println(tcal);
				
				System.out.println("BURADA 3");
				
				int id_al=hukukMuvekkilozelhareketler.id;
				ResultSet rs = null;
				//hukukBaglanti baglanti = null;
				try {
					
					System.out.println("BURADA 4");
					
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
					System.out.println("BURADA 5");
					//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement mystata eklemeyi unutma
					
					myconn=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					String listele="Select * From muvekkilozelhareket where OzelHareketID='"+id_al+"'";
					System.out.println("Select * From muvekkilozelhareket where OzelHareketID='"+id_al+"'");
					mystat=myconn.createStatement();
					rs=mystat.executeQuery(listele);
					if(rs.next())
					{
						txtgorusmetarihi.setDate(rs.getDate("Ozelharekettarihi"));
						txtmuvekkiladi.setText(rs.getString("KonusulanKisi"));
						txtmuvekkiltc.setText(rs.getString("MuvekkilTC"));
						//txtavukatadi.setText(rs.getString("KonusanAvukat"));
						comboBox_avukat.setSelectedItem(rs.getString("KonusanAvukat"));
						textAreanotlar_1.setText(rs.getString("Aciklama"));
						txthatirlat.setDate(rs.getDate("hatirlat"));
						hakedistxt.setText(rs.getString("hakedis"));
						gorusmenotxt.setText(rs.getString("OzelHareketID"));
						
						System.out.println("BURADA 6");
						hukukMuvekkilozelhareketler.id_sakla=hukukMuvekkilozelhareketler.id;
						hukukMuvekkilozelhareketler.id=0;
						System.out.println("BURADA 7");
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
				//hukukMuvekkilozelhareketler ornek= new hukukMuvekkilozelhareketler();
				//ornek.setVisible(true);
			}
		});
	
		
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(500, 335, 90, 30);
		contentPane.add(btnNewButton_2);
		
		JLabel hakedislbl = new JLabel("Hakedis:");
		hakedislbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		hakedislbl.setBounds(276, 278, 79, 14);
		contentPane.add(hakedislbl);
		
		hakedistxt = new JTextField();
		hakedistxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (hakedistxt.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
		});

		
		

		JButton btnNewButton_3 = new JButton("Kaydet");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String tcal=hukukMuvekkilozelhareketler.id_al,tarih1,tarih2, muvekkiladi, muvekkiltc, avukatadi, notlar;//TCNUMARASINI ALIYOR
				txtmuvekkiltc.setText(tcal);
				//float hakedis;
				
				Date date =new Date();
				if (txtgorusmetarihi.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih1=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih1=sdf.format(txtgorusmetarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih1);}


				if (txthatirlat.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(date);} 
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(txthatirlat.getDate());//TARIH FORMATLAMA
					System.out.println(tarih2);}
				
				muvekkiladi= txtmuvekkiladi.getText();
				muvekkiltc= txtmuvekkiltc.getText();
				avukatadi= comboBox_avukat.getSelectedItem().toString();
				notlar= textAreanotlar_1.getText();
				
				if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
				
				
				//PreparedStatement st;
				//ResultSet rs1=null;
				//String muvekkil_kontrol="select * from muvekkilbilgi where MuvekkilTC='"+muvekkiltc+"' ";
				String query="INSERT INTO muvekkilozelhareket (Ozelharekettarihi,KonusulanKisi,KonusanAvukat,Aciklama,MuvekkilTC,hatirlat,hakedis) VALUES ('"+tarih1+"','"+ muvekkiladi+"','"+ avukatadi+"','"+ notlar+"','"+muvekkiltc+"','"+ tarih2+"','"+hakedistxt.getText()+"')";
				try {
					
					myconn2=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					mystat2=myconn2.createStatement();
					mystat2.executeUpdate(query);
				
					JOptionPane.showMessageDialog(null,"Islem Basarýlý");
					dispose();
					System.out.println("Ekleme Basarili");

					} catch (Exception hata) {
						System.err.println(hata);
					}
					
			}
		});
	
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(400, 335, 90, 30);
		//contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Guncelle");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tcal=hukukMuvekkilozelhareketler.id_al,tarih1,tarih2, muvekkiladi, muvekkiltc, avukatadi, notlar,hakedis;//TCNUMARASINI ALIYOR
				txtmuvekkiltc.setText(tcal);
				
				
				Date date =new Date();
				if (txtgorusmetarihi.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih1=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih1=sdf.format(txtgorusmetarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih1);}


				if (txthatirlat.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(date);} 
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(txthatirlat.getDate());//TARIH FORMATLAMA
					System.out.println(tarih2);}
				
				muvekkiladi= txtmuvekkiladi.getText();
				muvekkiltc= txtmuvekkiltc.getText();
				avukatadi= comboBox_avukat.getSelectedItem().toString();
				notlar= textAreanotlar_1.getText();
				hakedis=hakedistxt.getText();
				
				if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
				
				if(tarih1.equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					ResultSet rs1=null;
					//System.out.println(buro_unvan+"\n "+buro_sehir+"  \n"+buro_postakodu+" \n"+buro_ilce+" \n"+buro_mail+"\n "+buro_vergidairesi+"\n "+buro_vergino+"\n "+buro_ortak1+" \n"+buro_ortak2+"\n "+buro_ortak3+"\n "+buro_ortak4+" \n"+buro_telefon+" \n"+buro_gsm+"\n "+buro_adres);
					System.out.println(hukukMuvekkilozelhareketler.id_sakla+ "  ozel hareket id BURADA BURADA EN BURADA");
					String sorgu_guncelle="update muvekkilozelhareket set Ozelharekettarihi='"+tarih1 +"',KonusulanKisi='"+muvekkiladi+"',KonusanAvukat='"+avukatadi +"',Aciklama='"+notlar+"',MuvekkilTC='"+muvekkiltc+"',hatirlat='"+tarih2+"',hakedis='"+hakedis+"' where OzelHareketID='"+hukukMuvekkilozelhareketler.id_sakla+"'";
					try 
					{
						myconn = DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
						mystat=myconn.createStatement();
						mystat.executeUpdate(sorgu_guncelle);
						JOptionPane.showMessageDialog(null,"Guncelleme Basarili");
						 
						
						//hukukMuvekkilozelhareketler form = new hukukMuvekkilozelhareketler();
						//form.setVisible(true);
						//form.setLocationRelativeTo(null);
						dispose();
						System.out.println("Ekleme Basarili");

	
					}catch(Exception hata)
					{
						System.err.println(hata);
					}
				}
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1.setBounds(400, 335, 90, 30);
		//contentPane.add(btnNewButton_3_1);
		
		if(hukukMuvekkilozelhareketler.id==0)
		{
			contentPane.add(btnNewButton_3);
		}
		else
		{
			contentPane.add(btnNewButton_3_1);
		}
		
	
		
		
	}
}
