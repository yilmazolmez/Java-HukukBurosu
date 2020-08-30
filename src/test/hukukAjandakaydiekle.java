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

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

public class hukukAjandakaydiekle extends JDialog {

	private JPanel contentPane;
	private JComboBox sikayetialan;
	JTextArea aciklama;
	private JTextField islemnotxt;
//	private JTextField textField;
	static Connection myconn,myconna;
	static Statement mystat,mystata,mystata1;

	
	private JComboBox hatirlattxt;
	private JComboBox zaman;
	private JTextField hakedistxt;
	private JTextField islemtarihitxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukAjandakaydiekle frame = new hukukAjandakaydiekle();
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
	public hukukAjandakaydiekle() {
		setModal(true);
		setResizable(false);
		setTitle("Ajanda Kayit Ekle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 721, 400);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(10, 52, 267, 296);
		Image  img=new ImageIcon(this.getClass().getResource("/folder-documents-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Ajanda Kayit Ekle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 294, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblTelefon = new JLabel("Notu tutan : *");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(311, 110, 108, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblifre_1 = new JLabel("Ajanda Notu : *");
		lblifre_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre_1.setBounds(311, 140, 153, 14);
		contentPane.add(lblifre_1);
		  // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		
		//sikayetialan = new JTextField();
		//sikayetialan.setColumns(10);
		//sikayetialan.setBounds(388, 175, 156, 20);
		//contentPane.add(sikayetialan);
		
	     // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		sikayetialan = new JComboBox();
		sikayetialan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					aciklama.requestFocus();
				}
			}
		});
		sikayetialan.setBounds(474, 110, 156, 20);
		contentPane.add(sikayetialan);
		  // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		
		aciklama = new JTextArea();
		aciklama.setFont(new Font("Tahoma", Font.PLAIN, 11));
		aciklama.setText("Ajanda Kaydi Hareketi");
		contentPane.add(aciklama);
		aciklama.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (aciklama.getText().length() >= 100 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hakedistxt.requestFocus();
				}
			}
	    });
		JScrollPane scroll = new JScrollPane(aciklama);
		scroll.setBounds(474, 140, 156, 77);                     // <-- THIS
	    getContentPane().add(scroll);
	    setLocationRelativeTo ( null );
	    aciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    aciklama.setLineWrap(true);
		
		JLabel lblNewLabel_1_1 = new JLabel("Islem No: *");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(311, 52, 108, 14);
		contentPane.add(lblNewLabel_1_1);
		
		islemnotxt = new JTextField();
		islemnotxt.setEnabled(false);
		islemnotxt.setEditable(false);
		islemnotxt.setColumns(10);
		islemnotxt.setBounds(474, 52, 156, 20);
		contentPane.add(islemnotxt);
		
		
		
		JDateChooser hatirlattxt = new JDateChooser();
		hatirlattxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hakedistxt.requestFocus();
				}
			}
		});
	    hatirlattxt.setBounds(474, 228, 156, 20);
	    hatirlattxt.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(hatirlattxt);
	    
	    
		JLabel lblHatirlat = new JLabel("Hatirlat: *");
		lblHatirlat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHatirlat.setBounds(311, 228, 139, 14);
		contentPane.add(lblHatirlat);
		
		JLabel Hakedislbl = new JLabel("Hakedis:");
		Hakedislbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		Hakedislbl.setBounds(311, 258, 139, 14);
		contentPane.add(Hakedislbl);
		
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
					sikayetialan.requestFocus();
				}
			}
		});
		hakedistxt.setHorizontalAlignment(SwingConstants.RIGHT);
		hakedistxt.setText("0.00");
		hakedistxt.setColumns(10);
		hakedistxt.setBounds(474, 258, 156, 20);
		contentPane.add(hakedistxt);
		
		//hatirlattxt = new JTextField();
		//hatirlattxt.setColumns(10);
		//hatirlattxt.setBounds(474, 395, 156, 20);
		//contentPane.add(hatirlattxt);

		
		JButton btnkaydet = new JButton("Kaydet");
		btnkaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1;
				if((sikayetialan.getSelectedItem().equals("")) || (aciklama.getText().equals(""))) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					Date date =new Date();
					if (hatirlattxt.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih1=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih1=sdf.format(hatirlattxt.getDate());//TARIH FORMATLAMA
						System.out.println(tarih1);}


					
					if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
					
					
					String sorgu_kaydet="insert into hukukajanda(Aciklama,hatirlat,hakedis,personeladisoyadi)values('"+aciklama.getText() +"','"+tarih1 +"','"+hakedistxt.getText() +"','"+sikayetialan.getSelectedItem().toString() +"')";
					 
 						try {
 							hukukBaglanti baglan = new hukukBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
							 
							
							
							//siteSikayetanaekrani frame = new siteSikayetanaekrani();
							//frame.show();
							//frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							dispose(); 
						 
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 						
						
				 
				 
				}
			
			}
		});
		btnkaydet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnkaydet.setBounds(311, 318, 100, 30);
		
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//siteSikayetanaekrani frame = new siteSikayetanaekrani();
				//frame.show();
				//frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(530, 318, 100, 30);
		contentPane.add(btnvazgec);
		

		
		JButton btnNewButton = new JButton("Temizle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//blokno.setText("");
				//adsoyad.setText("");
				//sikayetialan.setText("");
				//zaman.setText("");
				aciklama.setText("");
				hakedistxt.setText("");
			}
		});
		btnNewButton.setBounds(423, 318, 100, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Islem Tarihi :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(311, 82, 108, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		islemtarihitxt = new JTextField();
		islemtarihitxt.setEnabled(false);
		islemtarihitxt.setEditable(false);
		islemtarihitxt.setColumns(10);
		islemtarihitxt.setBounds(474, 82, 156, 20);
		contentPane.add(islemtarihitxt);
		


		
		JButton btnDuzenle = new JButton("Guncelle");
		btnDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1;
				if((sikayetialan.getSelectedItem().equals("")) || (aciklama.getText().equals(""))) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					
					Date date =new Date();
					if (hatirlattxt.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih1=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih1=sdf.format(hatirlattxt.getDate());//TARIH FORMATLAMA
						System.out.println(tarih1);}

					
					if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
					 
				
					String sorgu_kaydet="update hukukajanda set hatirlat='"+tarih1+"',hakedis='"+hakedistxt.getText()+"',personeladisoyadi='"+sikayetialan.getSelectedItem().toString()+"',Aciklama='"+aciklama.getText() +"' where islemid='"+hukukAjandaanaekrani.id_sakla+"'";
					 
 						try {
 							hukukBaglanti baglan = new hukukBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Islem Basarili");
							 
							
							
							//siteSikayetanaekrani frame = new siteSikayetanaekrani();
							//frame.show();
							//frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							dispose(); 
						 
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 						
						
				 
				 
				}
			}
		});
		btnDuzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDuzenle.setBounds(311, 318, 100, 30);
		
		if(hukukAjandaanaekrani.id==0)
		{
			contentPane.add(btnkaydet);
		}
		else
		{
			contentPane.add(btnDuzenle);

		}
		
	
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			 
				hukukAjandaanaekrani.id_sakla=hukukAjandaanaekrani.id;
				hukukAjandaanaekrani.id=0;
				hukukBaglanti baglan = new hukukBaglanti();
				baglan.yap();
				
				
				ResultSet rsa1 = null;
				sikayetialan.removeAllItems();                                 //avukatlarý üst üste ekliyor
				
				
				ResultSet rs = null;
				try {
					
					myconna=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					String listele_personel="Select * From personelbilgi";
					mystata1=myconna.createStatement();

					rsa1=mystata1.executeQuery(listele_personel);
					
					
					while(rsa1.next())
					{  //veritabanýndaki avukat ad ve soyadlar otomatik combobox'a geliyor. //Ve öyle ekletiyoruz veritabanýna
						sikayetialan.addItem(rsa1.getString("PersonelAdSoyad"));
						
					}
					//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement
					
					
					
					String listele="Select * From hukukajanda where islemid='"+hukukAjandaanaekrani.id_sakla+"'";
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					if(rs.next())
					{ 
						sikayetialan.setSelectedItem(rs.getString("personeladisoyadi"));
						aciklama.setText(rs.getString("Aciklama"));
						hatirlattxt.setDate(rs.getDate("hatirlat"));
						hakedistxt.setText(rs.getString("hakedis"));
						islemnotxt.setText(rs.getString("islemid"));
						islemtarihitxt.setText(rs.getString("islemtarihi"));
					
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
		
	}
}
