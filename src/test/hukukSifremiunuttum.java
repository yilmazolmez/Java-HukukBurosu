package test;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

//public class hukukSifremiunuttum extends JFrame {
public class hukukSifremiunuttum extends JDialog {
	
	private JPanel contentPane;
	private JTextField txtkullaniciadi;
	private JTextField txtgizlisoru;
	private JTextField txtcevap;
	private JTextField txtsifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					hukukSifremiunuttum frame = new hukukSifremiunuttum();
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
	public hukukSifremiunuttum() {
		setModal(true);
		setResizable(false);
		setTitle("Sifre Hatirlatma Ekrani");
		setBounds(100, 100, 578, 322);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmuvekkil = new JLabel("");
		lblmuvekkil.setHorizontalAlignment(SwingConstants.CENTER);
		lblmuvekkil.setOpaque(true);
		lblmuvekkil.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/office-women-pink-icon (1).png")).getImage();
		lblmuvekkil.setIcon(new ImageIcon(img));
		lblmuvekkil.setBounds(10, 45, 156, 232);
		contentPane.add(lblmuvekkil);
		
		JLabel lblSifremiUnuttum = new JLabel("Sifre Hatirlatma Ekrani");
		lblSifremiUnuttum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblSifremiUnuttum.setBounds(10, 11, 306, 26);
		contentPane.add(lblSifremiUnuttum);
		
		txtkullaniciadi = new JTextField();
		txtkullaniciadi.setBounds(297, 45, 244, 20);
		contentPane.add(txtkullaniciadi);
		txtkullaniciadi.setColumns(10);
		
		txtgizlisoru = new JTextField();
		txtgizlisoru.setEditable(false);
		txtgizlisoru.setBackground(Color.YELLOW);
		txtgizlisoru.setBounds(297, 110, 242, 20);
		contentPane.add(txtgizlisoru);
		txtgizlisoru.setColumns(10);
		
		txtcevap = new JTextField();
		txtcevap.setBounds(297, 141, 242, 20);
		contentPane.add(txtcevap);
		txtcevap.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kullanici Adiniz :");
		lblNewLabel.setBounds(176, 45, 117, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGizliSorunuz = new JLabel("Gizli Sorunuz :");
		lblGizliSorunuz.setBounds(176, 110, 111, 14);
		contentPane.add(lblGizliSorunuz);
		
		JLabel lblCevabiniz = new JLabel("Cevabiniz :");
		lblCevabiniz.setBounds(176, 141, 111, 14);
		contentPane.add(lblCevabiniz);
		
		JButton soruyubul = new JButton("Gizli Soruyu Bul");
		soruyubul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/////
				try
					{
				//Connection myconn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC","root","");
				Connection myconn=DriverManager.getConnection ("jdbc:mysql://"+hukukLoginForm.loginsunucu+"/hukukburosu?useTimezone=true&serverTimezone=UTC","root","");
				System.out.println("Baðlantý Saðlandý");
				
				String kullaniciadi = txtkullaniciadi.getText();

		        
				String query1="Select * From kullanicibilgi where kadi='"+kullaniciadi+"'";
				Statement stmt1=myconn.createStatement();
				ResultSet rs1=stmt1.executeQuery(query1);
				int a=0;
				String b="";
				String c="";
				String d="sifresi";
				while(rs1.next())
				{
				b=rs1.getString("sifrehatirlatmasoru");
				c=rs1.getString("sifrehatirlatmacevap");
				d=rs1.getString("sifresi");
				
			    System.out.println("Sisteme Baþarý ile Login Olundu..");
				System.out.println("kadi:"+rs1.getString("kadi")+"sifresi"+rs1.getString("sifresi")+"Aciklama : " + rs1.getString("kaciklama")+"Yetki : " + rs1.getString("yetki"));

				a=a+1;
				}
				
				if (a>=1) {txtgizlisoru.setText(b);}
			
				else {
						JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					}

				
				}catch(Exception hata)
				{
				System.err.println(hata.getMessage());
				//throw new Exception("Deneme123");
				}
			
				////
			}
		});
		soruyubul.setBounds(176, 76, 365, 23);
		contentPane.add(soruyubul);
		
		JLabel lblSifreniz = new JLabel("Sifreniz :");
		lblSifreniz.setBounds(176, 206, 111, 14);
		contentPane.add(lblSifreniz);
		
		txtsifre = new JTextField();
		txtsifre.setEditable(false);
		txtsifre.setBackground(Color.YELLOW);
		txtsifre.setColumns(10);
		txtsifre.setBounds(297, 206, 242, 20);
		contentPane.add(txtsifre);
		
		JButton btnSifremiGetir = new JButton("Sifremi Getir");
		btnSifremiGetir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/////
				try
					{
				Connection myconn=DriverManager.getConnection ("jdbc:mysql://"+hukukLoginForm.loginsunucu+"/hukukburosu?useTimezone=true&serverTimezone=UTC","root","");
				System.out.println("Baðlantý Saðlandý");
				
				String kullaniciadi = txtkullaniciadi.getText();

		        
				String query1="Select kadi,AES_DECRYPT(sifresi,'abc1234') AS sifresi,sifrehatirlatmasoru,sifrehatirlatmacevap,yetki From kullanicibilgi where kadi='"+kullaniciadi+"'"; //GIZLENMIS SIFREYI GOSTERIR
				Statement stmt1=myconn.createStatement();
				ResultSet rs1=stmt1.executeQuery(query1);
				int a=0;
				String b="";
				String c="";
				String d="";
				while(rs1.next())
				{
				b=rs1.getString("sifrehatirlatmasoru");
				c=rs1.getString("sifrehatirlatmacevap");
				d=rs1.getString("sifresi");
			    System.out.println("Sisteme Baþarý ile Login Olundu..");
				System.out.println("kadi:"+rs1.getString("kadi")+"sifresi"+rs1.getString("sifresi")+"Aciklama : " + rs1.getString("sifrehatirlatmacevap")+"Yetki : " + rs1.getString("yetki"));

				a=a+1;
				}


				if ((a>=1) && (c.equals(txtcevap.getText())))//GIZLI CEVAP DOGRUYSA
					{txtgizlisoru.setText(b);
					txtsifre.setText(d);
					}
			
				else {
						JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					}

				
				}catch(Exception hata)
				{
				System.err.println(hata.getMessage());
				//throw new Exception("Deneme123");
				}
			
				////
				
			}
		});
		btnSifremiGetir.setBounds(176, 172, 365, 23);
		contentPane.add(btnSifremiGetir);
		
		JButton btnNewButton = new JButton("Kapat");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(176, 254, 365, 23);
		contentPane.add(btnNewButton);
		

	}
}
