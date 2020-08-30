package test;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

//public class hukukPersonelekleduzenle extends JFrame {
public class hukukPersonelekleduzenle extends JDialog {

	private JPanel contentPane;
	private JTextField txtTC;
	private JTextField txtadi;
	private JTextField txtmaas;
	private JTextField txttelefon;
	private JTextField txtemail;
	private JComboBox txtpersoneltipi;
	private JTextField PersonelKayittarihi;
	static Connection myconn1;
	static Statement mystat1;
	static Connection myconn;
	static Statement mystat;
	private JTextField personelidtxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukPersonelekleduzenle frame = new hukukPersonelekleduzenle();
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
	public hukukPersonelekleduzenle() {
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Personel Kayit Detay");
		setBounds(100, 100, 626, 447);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		Image img = new ImageIcon(this.getClass().getResource("/Groups-Meeting-Dark-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 55, 248, 327);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Personel Ekle/Duzenle Ekrani");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 338, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel tcno = new JLabel("TC No:");
		tcno.setFont(new Font("Tahoma", Font.BOLD, 12));
		tcno.setBounds(268, 83, 55, 14);
		contentPane.add(tcno);
		
		JLabel adsoyad = new JLabel("Adi Soyadi:");
		adsoyad.setFont(new Font("Tahoma", Font.BOLD, 12));
		adsoyad.setBounds(268, 113, 91, 14);
		contentPane.add(adsoyad);
		
		JLabel maas = new JLabel("Net Maas:");
		maas.setFont(new Font("Tahoma", Font.BOLD, 13));
		maas.setBounds(268, 143, 91, 14);
		contentPane.add(maas);
		
		JLabel telefon = new JLabel("Telefon:");
		telefon.setFont(new Font("Tahoma", Font.BOLD, 13));
		telefon.setBounds(268, 173, 91, 14);
		contentPane.add(telefon);
		
		JLabel personeltipi = new JLabel("Personel tipi:");
		personeltipi.setFont(new Font("Tahoma", Font.BOLD, 13));
		personeltipi.setBounds(268, 203, 91, 14);
		contentPane.add(personeltipi);
		
		JLabel email = new JLabel("e-posta:");
		email.setFont(new Font("Tahoma", Font.BOLD, 13));
		email.setBounds(268, 233, 79, 14);
		contentPane.add(email);
		
		JLabel kayittarihi = new JLabel("Kayit Tarihi:");
		kayittarihi.setFont(new Font("Tahoma", Font.BOLD, 13));
		kayittarihi.setBounds(268, 263, 79, 14);
		contentPane.add(kayittarihi);
		
		JDateChooser PersonelKayittarihi = new JDateChooser();
		PersonelKayittarihi.setBounds(415, 263, 144, 20);
		PersonelKayittarihi.setDateFormatString("yyyy-MM-dd");
		contentPane.add(PersonelKayittarihi);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("Pencere Acildi");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("Pencere kapandi");
			}
			@Override
			public void windowActivated(WindowEvent e) {
				String id_al=hukukPersonelanaekrani.tc;
				ResultSet rs = null;
				try {
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					String listele="Select * From personelbilgi where PersonelTC='"+id_al+"'";
					mystat1=myconn1.createStatement();
					rs=mystat1.executeQuery(listele);
					if(rs.next())
					{	hukukPersonelanaekrani.tc_sakla = hukukPersonelanaekrani.tc;
					   hukukPersonelanaekrani.tc="0";	
						
						txtTC.setText(rs.getString("PersonelTC"));
						txtadi.setText(rs.getString("PersonelAdSoyad"));
						txtmaas.setText(rs.getString("PersonelMaasNET"));
						txttelefon.setText(rs.getString("PersonelTelefon"));
						String personeltip = rs.getString("PersonelTipi");
						personelidtxt.setText(rs.getString("Personelid"));
						if(personeltip.equals("AVUKAT"))
						{
							txtpersoneltipi.setSelectedIndex(0);
						}
						if(personeltip.equals("YONETICI"))
						{
							txtpersoneltipi.setSelectedIndex(1);
						}
						if(personeltip.equals("SEKRETER"))
						{
							txtpersoneltipi.setSelectedIndex(2);
						}	
						if(personeltip.equals("DIGER PERSONEL"))
						{
							txtpersoneltipi.setSelectedIndex(3);
						}	
						
						txtemail.setText(rs.getString("PersonelEposta"));
						
						PersonelKayittarihi.setDate(rs.getDate("PersonelKayittarihi"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		
		txtTC = new JTextField("");
		txtTC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (txtTC.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtadi.requestFocus();
				}
			}
			    });  // tc numarasinin yanliz rakam girilebilmesi
		
		txtTC.setBounds(415, 83, 144, 20);
		contentPane.add(txtTC);
		txtTC.setColumns(10);
		
		txtadi = new JTextField();
		txtadi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtmaas.requestFocus();
				}
			}
		});
		txtadi.setBounds(415, 113, 144, 20);
		contentPane.add(txtadi);
		txtadi.setColumns(10);
		
		txtmaas = new JTextField();
		txtmaas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txttelefon.requestFocus();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (txtmaas.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
		});
		txtmaas.setHorizontalAlignment(SwingConstants.RIGHT);
		txtmaas.setText("0.00");
		txtmaas.setBounds(415, 143, 144, 20);
		contentPane.add(txtmaas);
		txtmaas.setColumns(10);
		
		txttelefon = new JTextField();
		txttelefon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtpersoneltipi.requestFocus();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (txttelefon.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
		});
	    txttelefon.setBounds(415, 173, 144, 20);
		contentPane.add(txttelefon);
		txttelefon.setColumns(10);
		
		txtpersoneltipi = new JComboBox();
		txtpersoneltipi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtemail.requestFocus();
				}
			}
		});
		txtpersoneltipi.setModel(new DefaultComboBoxModel(new String[] {"AVUKAT", "YONETICI", "SEKRETER", "DIGER PERSONEL"}));
		txtpersoneltipi.setSelectedIndex(0);
		txtpersoneltipi.setBounds(415, 203, 144, 22);
		contentPane.add(txtpersoneltipi);
		
		txtemail = new JTextField();
		txtemail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtadi.requestFocus();
				}
			}
		});
		txtemail.setBounds(415, 233, 144, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		

		
		JButton btnkayitekle = new JButton("Kaydet");
		
		btnkayitekle.addActionListener(new ActionListener() {
			
			private String personelkayit;
			
			public void actionPerformed(ActionEvent e) {
				
				String tarih1;//
				
				Date date =new Date();

				if (PersonelKayittarihi.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih1=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih1=sdf.format(PersonelKayittarihi.getDate());//TARIH FORMATLAMA
					System.out.println(tarih1);}
				if ((txtmaas.getText()).equals("")){txtmaas.setText("0");}
	
				
				String PersonelTC = txtTC.getText();
				String PersonelAdSoyad = txtadi.getText();
				String PersonelMaasNET = txtmaas.getText();     // textbox lara girilen verilerin alinmasi
				String PersonelTelefon = txttelefon.getText();
				String PersonelTipi = txtpersoneltipi.getSelectedItem().toString();
				String PersonelEposta = txtemail.getText();
				String PersonelKayitTarihi = tarih1;
				String message;
				if ((PersonelTC.equals("")) || (PersonelAdSoyad.equals("")))
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlari Doldurunuz.!");
					
				}
				else
				{

				 String personelkayit="INSERT INTO personelbilgi (PersonelTC,PersonelAdSoyad,PersonelMaasNET,PersonelTelefon,PersonelTipi,PersonelEposta,PersonelKayitTarihi) VALUES("+
				 "'"+PersonelTC+"',"+"'"+ PersonelAdSoyad +"'," +"'"+ PersonelMaasNET+"',"+"'"+ PersonelTelefon+"'," +"'"+ PersonelTipi+"'," +"'"+ PersonelEposta+"',"+"'"+ PersonelKayitTarihi+"')";
				System.out.println(personelkayit); //SQL veri kaydi
				try {
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					mystat1=myconn1.createStatement();
					mystat1.executeUpdate(personelkayit);
					JOptionPane.showMessageDialog(null,"islem Basarili");
					//hukukPersonelanaekrani personel = new hukukPersonelanaekrani();
					//personel.setVisible(true);
					//personel.setLocationRelativeTo(null);
					dispose();
				
				}catch(Exception hata)
				{
					JOptionPane.showMessageDialog(null,"TC No tekrarli veya Hatali/Eksik Alanlari Doldurunuz.!");
					System.err.println(hata);
				} 
				
				}
	

			}
			
		});
		btnkayitekle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnkayitekle.setBounds(367, 353, 89, 29);
		//contentPane.add(btnkayitekle);
		
		JButton btnNewButton_2 = new JButton("Vazgec");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // vazgec butonu aktiflestirildi.
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(470, 353, 89, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblPersonelId = new JLabel("Personel ID:");
		lblPersonelId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPersonelId.setBounds(268, 55, 91, 14);
		contentPane.add(lblPersonelId);
		
		personelidtxt = new JTextField("");
		personelidtxt.setEditable(false);
		personelidtxt.setEnabled(false);
		personelidtxt.setColumns(10);
		personelidtxt.setBounds(415, 55, 144, 20);
		contentPane.add(personelidtxt);
		
		

		
		//PersonelKayittarihi = new JTextField();
		//PersonelKayittarihi.setBounds(415, 235, 144, 20);
		//contentPane.add(PersonelKayittarihi);
		//PersonelKayittarihi.setColumns(10);
		
		JButton btnGuncelle = new JButton("Guncelle");
		if(hukukPersonelanaekrani.tc.equals("0"))
		{
			contentPane.add(btnkayitekle);
		}
		else
		{
			txtTC.enable(false);
			contentPane.add(btnGuncelle);
		}
		
		
		btnGuncelle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 
			String tarih1;//
			
			Date date =new Date();

			if (PersonelKayittarihi.getDate()==null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				tarih1=sdf.format(date);}
			else {
		      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
				tarih1=sdf.format(PersonelKayittarihi.getDate());//TARIH FORMATLAMA
				System.out.println(tarih1);}
			
			if ((txtmaas.getText().equals(""))){txtmaas.setText("0");}
			
			String PersonelTC = txtTC.getText();
			String PersonelAdSoyad = txtadi.getText();
			String PersonelMaasNET = txtmaas.getText();      // textbox lara girilen verilerin alinmasi
			String PersonelTelefon = txttelefon.getText();
			String PersonelTipi = txtpersoneltipi.getSelectedItem().toString();
			String PersonelEposta = txtemail.getText().toString();
			String PersonelKayitTarihi = tarih1;
			if ((PersonelTC.equals("")) || (PersonelAdSoyad.equals("")))
			{
				JOptionPane.showMessageDialog(null,"Gerekli Alanlari Doldurunuz.!");
				
			}
			else
			{
			
			String guncelle = "UPDATE personelbilgi SET PersonelTC ='"+PersonelTC+"', PersonelAdSoyad = '"+PersonelAdSoyad+"', PersonelMaasNET = '"+PersonelMaasNET+"', PersonelTelefon = '"+PersonelTelefon+"', PersonelTipi = '"+PersonelTipi+"', PersonelEposta = '"+PersonelEposta+"', PersonelKayitTarihi = '"+PersonelKayitTarihi+"' WHERE PersonelTC ='"+hukukPersonelanaekrani.tc_sakla+"'";
		
			try {
				myconn=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
				mystat=myconn.createStatement();
				mystat.executeUpdate(guncelle);
				JOptionPane.showMessageDialog(null,"Güncelleme yapildi.");	
				System.out.println("Guncelleme Basarili");
				
				//hukukPersonelanaekrani form= new hukukPersonelanaekrani();
				//form.setVisible(true);
				//form.setLocationRelativeTo(null);
				dispose();
			}catch(Exception hata)
			{
				JOptionPane.showMessageDialog(null,"TC No tekrarli veya Hatali/Eksik Bilgi var..!");
				System.err.println(hata);
			}
			
		}
			}
		
		});
		
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuncelle.setBounds(367, 353, 89, 29);
		//contentPane.add(btnGuncelle);
		
		

	}
}
