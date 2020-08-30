package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class hukukMuvekkilcarihareketekle extends JDialog {
	static Connection myconn;
	static Statement mystat;
	private JPanel contentPane;
	private JTextField txt_TC;
	private JTextField txt_tarih;
	private JTextField txt_alacak;
	private JTextField txt_boruc;
	private JTextField txt_hatirlat;
	private JTextField txt_aciklama;
	private JTextField islemno;
	private JTextField hakedistxt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukMuvekkilcarihareketekle frame = new hukukMuvekkilcarihareketekle();
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
	public hukukMuvekkilcarihareketekle() {
		setResizable(false);
		setModal(true);
		setTitle("Cari Hareket Detayi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 477);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    JDateChooser txt_hatirlat = new JDateChooser();
	    txt_hatirlat.setBounds(403, 280, 144, 20);
	    txt_hatirlat.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txt_hatirlat);
	    
	    JDateChooser txt_tarih = new JDateChooser();
	    txt_tarih.setBounds(403, 111, 144, 20);
	    txt_tarih.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(txt_tarih);
	    
		// Alacak Tutar lable and textfield
		JLabel lblNewLabel_2 = new JLabel("Alacak Tutari:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(298, 141, 95, 14);
		contentPane.add(lblNewLabel_2);

		txt_boruc = new JTextField();
		txt_boruc.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_boruc.setText("0.00");
		txt_boruc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (txt_boruc.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txt_aciklama.requestFocus();
				}
			}
		});
		txt_boruc.setBounds(403, 171, 144, 20);
		contentPane.add(txt_boruc);
		txt_boruc.setColumns(10);

		// boruc tutar lable and textfield
		JLabel lblNewLabel_7 = new JLabel("Borc Tutari:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(298, 171, 79, 14);
		contentPane.add(lblNewLabel_7);

		txt_TC = new JTextField();
		txt_TC.setEnabled(false);
		txt_TC.setBounds(403, 81, 144, 20);
		contentPane.add(txt_TC);
		txt_TC.setColumns(10);

		// muvekkil tc lable and textfield
		JLabel lblNewLabel_6 = new JLabel("Muvekkil TC:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(298, 81, 81, 14);
		contentPane.add(lblNewLabel_6);

		txt_alacak = new JTextField();
		txt_alacak.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_alacak.setText("0.00");
		txt_alacak.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (txt_alacak.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txt_boruc.requestFocus();
				}
			}
		});
		txt_alacak.setBounds(403, 141, 144, 20);
		contentPane.add(txt_alacak);
		txt_alacak.setColumns(10);

		// tarih lable and textfield
		JLabel lblNewLabel_3 = new JLabel("Islem Tarihi:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(298, 111, 79, 14);
		contentPane.add(lblNewLabel_3);

		//txt_tarih = new HintTextField("Example=2020-03-03");
		//txt_tarih.setBounds(403, 111, 144, 20);
		//contentPane.add(txt_tarih);
		//txt_tarih.setColumns(10);
		


		// aciklama lable and textfield
		
		JTextArea txt_aciklama = new JTextArea();
		txt_aciklama.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hakedistxt.requestFocus();
				}
			}
		});
		contentPane.add(txt_aciklama);
		JScrollPane scroll1 = new JScrollPane(txt_aciklama);
		scroll1.setBounds(403, 201, 144, 70);                     // <-- THIS
	    getContentPane().add(scroll1);
	    setLocationRelativeTo ( null );
	    txt_aciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    txt_aciklama.setLineWrap(true); //satir sonu bir alta almak icin
		
		JLabel lblNewLabel_8 = new JLabel("Aciklama:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(298, 201, 79, 14);
		contentPane.add(lblNewLabel_8);

		//txt_aciklama = new JTextField();
		//txt_aciklama.setColumns(10);
		//txt_aciklama.setBounds(403, 201, 144, 66);
		//contentPane.add(txt_aciklama);

		// JTextArea txt_aciklama = new JTextArea();
		// txt_aciklama.setBounds(403, 171, 144, 66);
		// txt_aciklama.add(txt_aciklama);
		// setLocationRelativeTo ( null );
		// txt_aciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
		// txt_aciklama.setLineWrap(true);

		// Hatirlat lable and textfield

		JLabel lblNewLabel_7_1 = new JLabel("Hatirlat:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1.setBounds(298, 280, 79, 14);
		contentPane.add(lblNewLabel_7_1);

		

		
		//txt_hatirlat = new HintTextField("Example=2020-03-03");
		//txt_hatirlat.setColumns(10);
		//txt_hatirlat.setBounds(403, 280, 144, 20);
		//contentPane.add(txt_hatirlat);
		
		JLabel lblNewLabel_6_1 = new JLabel("Cari Islem No:");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(298, 51, 89, 14);
		contentPane.add(lblNewLabel_6_1);
		
		islemno = new JTextField();
		islemno.setEnabled(false);
		islemno.setColumns(10);
		islemno.setBounds(403, 51, 144, 20);
		contentPane.add(islemno);
		
		JLabel lblNewLabel_7_2 = new JLabel("Hakedis :");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_2.setBounds(298, 311, 79, 14);
		contentPane.add(lblNewLabel_7_2);
		
		hakedistxt = new JTextField();
		hakedistxt.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (hakedistxt.getText().length() >= 11 ) // limit to 3 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txt_alacak.requestFocus();
				}
			}
		});
		hakedistxt.setHorizontalAlignment(SwingConstants.RIGHT);
		hakedistxt.setText("0.00");
		hakedistxt.setColumns(10);
		hakedistxt.setBounds(403, 311, 144, 20);
		contentPane.add(hakedistxt);
	    
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		Image img = new ImageIcon(this.getClass().getResource("/Money-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 51, 264, 355);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cari Hareket Detayi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 11, 296, 29);
		contentPane.add(lblNewLabel_1);

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("Pencere Acildi");
			}

			public void windowClosing(WindowEvent e) {
				System.out.println("Pencere kapandi");
			}

			@Override
			public void windowActivated(WindowEvent e) {
				 String tcal=hukukMuvekkilcarihareketler.id_al;//TCNUMARASINI ALIYOR
				 txt_TC.setText(tcal);
				 
				int id_al = hukukMuvekkilcarihareketler.id;
				ResultSet rs = null;
				try {
					myconn = DriverManager.getConnection(hukukBaglanti.sunucuparametresi, "root", "");
					String listele = "Select * From muvekkilcarihareket where Muvekkilcarihareketno='" + id_al + "'";
					mystat = myconn.createStatement();
					rs = mystat.executeQuery(listele);
					if (rs.next()) {
						
						txt_TC.setText(rs.getString("MuvekkilTC"));
						txt_boruc.setText(rs.getString("Muvekkilborctutar"));
						txt_alacak.setText(rs.getString("Muvekkilalacaktutar"));
						txt_tarih.setDate(rs.getDate("Islemtarihi"));
						txt_hatirlat.setDate(rs.getDate("hatirlat"));
						txt_aciklama.setText(rs.getString("Aciklama"));
						islemno.setText(rs.getString("Muvekkilcarihareketno"));
						hakedistxt.setText(rs.getString("hakedis"));
						hukukMuvekkilcarihareketler.id_sakla = hukukMuvekkilcarihareketler.id;
						hukukMuvekkilcarihareketler.id = 0;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});



		// vazgec Button
		JButton btnNewButton_2 = new JButton("Vazgec");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(403, 376, 100, 30);
		contentPane.add(btnNewButton_2);
		


		// kaydet button
		JButton btnNewButton_3 = new JButton("Kaydet");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String _txt_aciklama,_txt_TC;
				float _txt_alacak, _txt_boruc;
				String _txt_tarih, _txt_hatirlat,tarih1,tarih2;
				
				Date date =new Date();

				if (txt_tarih.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih1=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih1=sdf.format(txt_tarih.getDate());//TARIH FORMATLAMA
					System.out.println(tarih1);}


				if (txt_hatirlat.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(date);} 
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(txt_hatirlat.getDate());//TARIH FORMATLAMA
					System.out.println(tarih2);}
				

				if ((txt_alacak.getText()).equals("")){_txt_alacak =0;} else {_txt_alacak=Float.parseFloat(txt_alacak.getText());}
				if ((txt_boruc.getText()).equals("")){_txt_boruc =0;} else {_txt_boruc=Float.parseFloat(txt_boruc.getText());}
				
				if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
				
				System.out.println(date);
				_txt_TC = (txt_TC.getText());
				_txt_aciklama = txt_aciklama.getText();

				if (_txt_aciklama.equals("")) {
					JOptionPane.showMessageDialog(null, "Gerekli Alanlari Doldurunuz.!");
				} else {
					String sorgu_kaydet = "insert into muvekkilcarihareket(Muvekkilalacaktutar,Islemtarihi,Muvekkilborctutar,Aciklama,MuvekkilTC,hatirlat,hakedis)values('"
							+ _txt_alacak + "', '" + tarih1 + "', '" + _txt_boruc + "', '" + _txt_aciklama + "','"
							+ _txt_TC + "','" + tarih2 + "','"+hakedistxt.getText() + "')";
					try {
						myconn = DriverManager.getConnection(hukukBaglanti.sunucuparametresi,"root","");
						mystat = myconn.createStatement();
						mystat.executeUpdate(sorgu_kaydet);
						JOptionPane.showMessageDialog(null, "Islem Basarili");
						//hukukMuvekkilcarihareketler buro = new hukukMuvekkilcarihareketler();
						//buro.setVisible(true);
						//buro.setLocationRelativeTo(null);
						dispose();
						System.out.println("Ekleme Basarili");
					} catch (Exception hata) {
						System.err.println(hata);
					}
				}

			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(298, 376, 100, 30);
		//contentPane.add(btnNewButton_3);

		// duzenle button
		JButton btnNewButton_3_1 = new JButton("Guncelle");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String _txt_aciklama,_txt_TC;
				float _txt_alacak, _txt_boruc;
				String _txt_tarih, _txt_hatirlat,tarih3,tarih4;
				_txt_TC = (txt_TC.getText());
				
				
				if ((txt_alacak.getText()).equals("")){_txt_alacak =0;} else {_txt_alacak=Float.parseFloat(txt_alacak.getText());}
				if ((txt_boruc.getText()).equals("")){_txt_boruc =0;} else {_txt_boruc=Float.parseFloat(txt_boruc.getText());}
				Date date =new Date();

				if (txt_tarih.getDate()==null) {
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
					tarih3=sdf2.format(date);}
				else {
			      	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih3=sdf2.format(txt_tarih.getDate());//TARIH FORMATLAMA
					System.out.println(tarih3);}


				if (txt_hatirlat.getDate()==null){
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih4=sdf3.format(date);} 
				else {
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih4=sdf3.format(txt_hatirlat.getDate());//TARIH FORMATLAMA
					System.out.println(tarih4);}
				
				if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
				
				System.out.println(date);
				
				_txt_aciklama = txt_aciklama.getText();

				if (_txt_aciklama.equals("")) {
					JOptionPane.showMessageDialog(null, "Gerekli Alanlari Doldurunuz.!");
				} else {
					String sorgu_guncelle ="update muvekkilcarihareket set MuvekkilTC='" + _txt_TC + "',Islemtarihi='" + tarih3
									+ "',Muvekkilborctutar='" + _txt_boruc + "',Muvekkilalacaktutar='" + _txt_alacak
									+ "',Aciklama='" + _txt_aciklama + "',hakedis='" + hakedistxt.getText() +"',hatirlat='" + tarih4 +"' where Muvekkilcarihareketno='"+hukukMuvekkilcarihareketler.id_sakla+"'";
									
					try {
						myconn = DriverManager.getConnection(hukukBaglanti.sunucuparametresi,"root","");
						mystat = myconn.createStatement();
						mystat.executeUpdate(sorgu_guncelle);
						JOptionPane.showMessageDialog(null, "Islem Basarili");
						//hukukMuvekkilcarihareketler buro = new hukukMuvekkilcarihareketler();
						//buro.setVisible(true);
						//buro.setLocationRelativeTo(null);
						dispose();
						System.out.println("Ekleme Basarili");
					} catch (Exception hata) {
						System.err.println(hata);
					}
				}

			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1.setBounds(298, 376, 100, 30);

		if (hukukMuvekkilcarihareketler.id == 0) {
			
			contentPane.add(btnNewButton_3);
		} else {
			
			contentPane.add(btnNewButton_3_1);
		}


	}
}
