package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;

//public class hukukMuvekkildavaliekle extends JFrame {
public class hukukMuvekkildavaliekle extends JDialog {

    static Connection myconn1;
    static Statement mystat1;
    static Connection myconn2;
    static Statement mystat2;
    
	private JPanel contentPane;
	private JTextField txtTC;
	private JTextField txtadisoyadi;
	private JTextField txttelefon;
	private JTextField txtvekil;
	private JTextField txtmuvekkil;
	private JTextArea txtadres;
	private JTextArea txtaciklama;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukMuvekkildavaliekle frame = new hukukMuvekkildavaliekle();
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
	public hukukMuvekkildavaliekle() {
		setModal(true);
		setResizable(false);
		setTitle("Muvekkil Davali Ekle / Duzenle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 432);
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
		Image img = new ImageIcon(this.getClass().getResource("/Jury-Law-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 51, 162, 334);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Muvekkil Davali Ekle / Duzenle");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 11, 456, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TC No *:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(182, 81 , 55, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adi Soyadi *:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(182, 111, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Adres:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(182, 171, 55, 14);
		contentPane.add(lblNewLabel_4);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Davali Vekili *:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(182, 231, 100, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Muvekkil TC *:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(182, 51, 89, 14);
		contentPane.add(lblNewLabel_6);
	
		JLabel lblNewLabel_7 = new JLabel("Telefon:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(182, 141, 79, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Aciklama:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(182, 261, 79, 14);
		contentPane.add(lblNewLabel_8);
		
		txtTC = new JTextField();
		txtTC.setBounds(287, 81, 144, 20);
		contentPane.add(txtTC);
		txtTC.setColumns(10);
		txtTC.addKeyListener(new KeyAdapter() {
				        @Override
				        public void keyTyped(KeyEvent e) {
				            if (txtTC.getText().length() >= 11 ) // limit to 3 characters
				                e.consume();
				        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtadisoyadi.requestFocus();
				}

			}
				    });
		
		txtadisoyadi = new JTextField();
		txtadisoyadi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txttelefon.requestFocus();
				}
			}
		});
		txtadisoyadi.setBounds(287, 111, 144, 20);
		contentPane.add(txtadisoyadi);
		txtadisoyadi.setColumns(10);
		
		txttelefon = new JTextField();
		txttelefon.setBounds(287, 141, 144, 20);
		contentPane.add(txttelefon);
		txttelefon.setColumns(10);
		txttelefon.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txttelefon.getText().length() >= 11 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtadres.requestFocus();
				}
			}
	    });
 
		
		JTextArea txtadres = new JTextArea();
		//txtadres.setBounds(287, 171, 144, 47);
		contentPane.add(txtadres);
		txtadres.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtadres.getText().length() >= 100 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtvekil.requestFocus();
				}
			}
	    });
		JScrollPane scroll = new JScrollPane(txtadres);
		scroll.setBounds(287, 171, 144, 47);                     // <-- THIS
	    getContentPane().add(scroll);
	    setLocationRelativeTo ( null );
	    txtadres.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    txtadres.setLineWrap(true);
	    
		txtvekil = new JTextField();
		txtvekil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtaciklama.requestFocus();
				}
			}
		});
		txtvekil.setBounds(287, 231, 144, 20);
		contentPane.add(txtvekil);
		txtvekil.setColumns(10);
		
		txtmuvekkil = new JTextField();
		txtmuvekkil.setEditable(false);
		txtmuvekkil.setEnabled(false);
		txtmuvekkil.setBounds(287, 51, 144, 20);
		contentPane.add(txtmuvekkil);
		txtmuvekkil.setColumns(10);
		txtmuvekkil.addKeyListener(new KeyAdapter() {
				        @Override
				        public void keyTyped(KeyEvent e) {
				            if (txtmuvekkil.getText().length() >= 11 ) // limit to 3 characters
				                e.consume();
				        }
				    });
		
		JTextArea txtaciklama = new JTextArea();
		//txtaciklama.setBounds(287, 261, 144, 47);
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
					txtadisoyadi.requestFocus();
				}
			}
	    });
		JScrollPane scroll1 = new JScrollPane(txtaciklama);
		scroll1.setBounds(287, 261, 144, 47);                     // <-- THIS
	    getContentPane().add(scroll1);
	    setLocationRelativeTo ( null );
	    txtaciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    txtaciklama.setLineWrap(true);
		
		JButton btnNewButton_2 = new JButton("Vazgec");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(312, 355, 100, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Kaydet");
		btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
					String tcal=hukukMuvekkildavalilistesi.id_al;
					String tc,adisoyadi,telefon ,adres,aciklama,vekil;
					String muvekkiltc;
					adisoyadi=txtadisoyadi.getText();
					telefon=txttelefon.getText();
					adres=txtadres.getText();
					vekil=txtvekil.getText();
					//muvekkiltc=txtmuvekkil.getText();
					muvekkiltc=tcal;
					tc=txtTC.getText();
					aciklama=txtaciklama.getText();
					if(tc.equals("") || muvekkiltc.equals("")) 
					{
						JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

					}
					else
					{

						ResultSet rs1=null;
						try
						{

							String muvekkil_kontrol="select * from muvekkilbilgi where MuvekkilTC='"+muvekkiltc+"' ";
							myconn2=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
	 						mystat2=myconn2.createStatement();
							rs1=mystat2.executeQuery(muvekkil_kontrol);
							if(rs1.next())
							{
									String sorgu_ekle="insert into muvekkildavalibilgi(DavaliAdSoyad,DavaliTelefon,DavaliAdres,DavaliVekili,MuvekkilTC,DavaliTC,Davaliaciklama)values('"+adisoyadi+"','"+telefon+"','"+adres+"','"+vekil+"','"+muvekkiltc+"','"+tc+"','"+aciklama+"')";
									
									try {
										myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
										mystat1=myconn1.createStatement();
										mystat1.executeUpdate(sorgu_ekle);
										JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
										//hukukMuvekkildavalilistesi davali = new hukukMuvekkildavalilistesi();
										//davali.setVisible(true);
										//davali.setLocationRelativeTo(null);
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
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(210, 355, 100, 30);
		
		JButton btnNewButton_3_1 = new JButton("Guncelle");
		if(hukukMuvekkildavalilistesi.tc==0)
		{
			
			contentPane.add(btnNewButton_3);
		}
		else
		{
			txtTC.enable(false);
			txtmuvekkil.enable(false);
			contentPane.add(btnNewButton_3_1);
		}
		
		
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tcal=hukukMuvekkildavalilistesi.id_al;
				String tc,adisoyadi,telefon,adres,aciklama,vekil;
				String muvekkiltc;
				adisoyadi=txtadisoyadi.getText();
				telefon=txttelefon.getText();
				adres=txtadres.getText();
				vekil=txtvekil.getText();
				muvekkiltc=tcal;
				tc=txtTC.getText();
				aciklama=txtaciklama.getText();
				if(tc.equals("") || muvekkiltc.equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{ //müvekkil kontrolü için
					
					ResultSet rs1=null;
					try
					{
						String muvekkil_kontrol="select * from muvekkilbilgi where MuvekkilTC='"+muvekkiltc+"' ";
						myconn2=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
 						mystat2=myconn2.createStatement();
						rs1=mystat2.executeQuery(muvekkil_kontrol);
						if(rs1.next())
						{
							String guncelle="update muvekkildavalibilgi set DavaliTC='"+tc+"',DavaliAdSoyad='"+adisoyadi+"',DavaliTelefon='"+telefon+"',DavaliAdres='"+adres+"',DavaliVekili='"+vekil +"',MuvekkilTC='"+muvekkiltc+"',DavaliTC='"+tc+"',Davaliaciklama='"+aciklama+"' where Davaliid='"+hukukMuvekkildavalilistesi.tc_sakla+"'";
							try 
							{
								myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
								mystat1=myconn1.createStatement();
								mystat1.executeUpdate(guncelle);
								JOptionPane.showMessageDialog(null,"Güncelleme Baþarýlý");
								 
								
								//hukukMuvekkildavalilistesi davali=new hukukMuvekkildavalilistesi();
								//davali.setVisible(true);
								//davali.setLocationRelativeTo(null);
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
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1.setBounds(210, 355, 100, 30);
		
		JButton btnNewButton_4 = new JButton("Temizle");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtadisoyadi.setText("");
				txtadres.setText("");
				txtvekil.setText("");
				txtmuvekkil.setText("");
				txtTC.setText("");
				txtaciklama.setText("");
				txttelefon.setText("");
			}
		});
		
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(422, 355, 100, 30);
		contentPane.add(btnNewButton_4);
		
		

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("Pencere Acildi");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("Pencere kapandi");
			}
			@Override
			public void windowActivated(WindowEvent e) {
				
				  hukukMuvekkildavalilistesi.tc_sakla=hukukMuvekkildavalilistesi.tc;
				  hukukMuvekkildavalilistesi.tc=0;
				  
					 String tcal=hukukMuvekkildavalilistesi.id_al;//TCNUMARASINI ALIYOR
					 txtmuvekkil.setText(tcal);
					 
				  ResultSet rs=null;
				  try 
					{
						myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
						String listele="select * from muvekkildavalibilgi where Davaliid='"+hukukMuvekkildavalilistesi.tc_sakla+"'";
						mystat1=myconn1.createStatement();
						rs=mystat1.executeQuery(listele);
						if(rs.next())
						{
							 
							txtadisoyadi.setText(rs.getString("DavaliAdSoyad"));
							txttelefon.setText(rs.getString("DavaliTelefon"));
							txtvekil.setText(rs.getString("DavaliVekili"));
							txtadres.setText(rs.getString("DavaliAdres"));
							txtmuvekkil.setText(String.valueOf(rs.getInt("MuvekkilTC")));
							txtTC.setText(String.valueOf(rs.getInt("DavaliTC")));
							txtaciklama.setText(String.valueOf(rs.getString("Davaliaciklama")));
						}
						
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}
			}
		});
		
		
		
		
	}
}
