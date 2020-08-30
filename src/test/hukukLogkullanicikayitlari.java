package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class hukukLogkullanicikayitlari extends JDialog {

	private JPanel contentPane;
	private JTable table;
	static Connection myconn1;
	static Statement mystat1;
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	
	Object [] kolonlar = {"logislemid","logdatetime","logkullaniciadi","logkullaniciyetkisi","Aciklama"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[5]; //SATIR TANIMLAMA

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukLogkullanicikayitlari frame = new hukukLogkullanicikayitlari();
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
	public hukukLogkullanicikayitlari() {
		setResizable(false);
		setModal(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//LOG LISTELEME
				modelim.setRowCount(0);//TABLOYU TEMIZLIYOR
				//
		 		ResultSet rs1 = null;
				try {
					System.out.println(hukukBaglanti.sunucuparametresi);
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					System.out.println("Baðlantý Saðlandý");

					String query1="Select * From hukuklogislem order by islemid DESC";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(query1);
					System.out.println("Listeleme Basarili");
				}catch(Exception hata)
				{
				System.err.println(hata);
				}
				//
				
				try {
				while(rs1.next()) {
					satirlar[0]=rs1.getString("islemid");
					satirlar[1]=rs1.getString("islemzamani");
					satirlar[2]=rs1.getString("kullaniciadi");
					satirlar[3]=rs1.getString("kullaniciyetki");
					satirlar[4]=rs1.getString("Aciklama");
					modelim.addRow(satirlar);
				}		
				}catch(SQLException hata)
				{
					System.err.println(hata);
					}
				table.setModel(modelim);
				table.updateUI();
				System.out.println("TOPLAM KAYIT: "+table.getRowCount());
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				//LOG LISTELEME
			}
		});
		setTitle("Kullanici Islem Log Kayitlari");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1087, 430);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 56, 893, 255);
		contentPane.add(scrollPane);
		
		//LISTELEME
		
		table = new JTable();
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setEnabled(false);
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(110,112,565,197);
		scrollPane.setViewportView(table);
		//LISTELEME
		
		JButton btnNewButton = new JButton("Kapat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(629, 322, 423, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Yenile");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LOG LISTELEME
				
				modelim.setRowCount(0);//TABLOYU TEMIZLIYOR
				//
		 		ResultSet rs1 = null;
				try {
					System.out.println(hukukBaglanti.sunucuparametresi);
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					System.out.println("Baðlantý Saðlandý");

					String query1="Select * From hukuklogislem order by islemid desc";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(query1);
					System.out.println("Listeleme Basarili");
				}catch(Exception hata)
				{
				System.err.println(hata);
				}
				//
				
				try {
				while(rs1.next()) {
					satirlar[0]=rs1.getString("islemid");
					satirlar[1]=rs1.getString("islemzamani");
					satirlar[2]=rs1.getString("kullaniciadi");
					satirlar[3]=rs1.getString("kullaniciyetki");
					satirlar[4]=rs1.getString("Aciklama");
					modelim.addRow(satirlar);
				}		
				}catch(SQLException hata)
				{
					System.err.println(hata);
					}
				table.setModel(modelim);
				table.updateUI();
				
				System.out.println("TOPLAM KAYIT: "+table.getRowCount());
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				//LOG LISTELEME
				
			}
		});
		btnNewButton_1.setBounds(159, 322, 460, 56);
		contentPane.add(btnNewButton_1);
		
		JLabel lblmuvekkil = new JLabel("");
		lblmuvekkil.setHorizontalAlignment(SwingConstants.CENTER);
		lblmuvekkil.setOpaque(true);
		lblmuvekkil.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/logkayitlari128pix.png")).getImage();
		lblmuvekkil.setIcon(new ImageIcon(img));
		lblmuvekkil.setBounds(10, 56, 143, 322);
		contentPane.add(lblmuvekkil);
		
		JLabel lblLogGirisCikis = new JLabel("Kullanici Islem Log Kayitlari......");
		lblLogGirisCikis.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblLogGirisCikis.setBounds(10, 11, 306, 26);
		contentPane.add(lblLogGirisCikis);
		

	}
}
