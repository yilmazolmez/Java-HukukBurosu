package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TexturePaint;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//////



//////



public class hukukKayitsayitablosu extends JDialog {

	private JPanel contentPane;
	static Connection myconn1;
	static Statement mystat1;
	private JTable table2;
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"Personel Sayýsý","Avukat Sayýsý","Müvekkil Sayýsý","M.CariHareket","M.DavaHareket","M.Davali Hareket","M.HukukiHareket","M.OzelHareket"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[8]; //SATIR TANIMLAMA
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukKayitsayitablosu frame = new hukukKayitsayitablosu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	////
	// Clock fonskiyonu silinebilir. Veri kontrolü yapmak için ekledim
	public void clock()
	{
		
		Label now = new Label("Tarih ve Saat");
		now.setAlignment(Label.RIGHT);
		now.setBackground(SystemColor.control);
		now.setFont(new Font("Tahoma", Font.BOLD, 14));
		now.setBounds(859, 49, 309, 24);
		contentPane.add(now);
		
		//List list = new List();
		//list.setBackground(new Color(250, 250, 210));
		//list.setForeground(new Color(0, 0, 0));
		//list.setMultipleSelections(false);
		//list.setFont(new Font("Arial", Font.PLAIN, 12));
		//list.setBounds(13, 79, 618, 181);
		//contentPane.add(list);
	
		JLabel lblNewLabel = new JLabel("***** Kayit Kapasiteleriniz.... Duzenli Yedeklemeyi Unutmay\u0131n \u0130yi Calismalar!... *****");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 829, 37);
		contentPane.add(lblNewLabel);

		Thread clock=new Thread() {
			
			public void run () {
				
				try {
					ResultSet rs = null;

					for(;;) {
					Calendar cal=new GregorianCalendar();
					
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					int second=cal.get(Calendar.SECOND);
					int minute=cal.get(Calendar.MINUTE);
					int hour=cal.get(Calendar.HOUR_OF_DAY);
					
					now.setText(day+"-"+month+"-"+year+" "+hour+":"+minute);
					
				sleep(1000);
				//java.awt.Toolkit.getDefaultToolkit().beep(); //ISTERSEK BIP SESI ILE KULLANICIYI UYARABILIRIZ
				lblNewLabel.setVisible(false);
				sleep(1000);
				lblNewLabel.setVisible(true);
				sleep(1000);
				lblNewLabel.setVisible(false);
				sleep(1000);
				lblNewLabel.setVisible(true);
				sleep(1000);
				lblNewLabel.setVisible(false);
				sleep(1000);
				lblNewLabel.setVisible(true);

				}} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}
	
	
	
	
	/////
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public hukukKayitsayitablosu() {
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 871, 303);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 829, 119);
		contentPane.add(scrollPane);
		
		clock(); //clock fonksiyonunu silmedim.
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				modelim.setRowCount(0);
				ResultSet rs1 = null;
				try 
				{
					
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					String listele="SELECT  (SELECT COUNT(*)FROM   personelbilgi) AS personel_sayi,(SELECT COUNT(*)FROM   avukatbilgi) AS avukat_sayi,(SELECT COUNT(*)FROM   muvekkilbilgi) AS muvekkil_sayi,(SELECT COUNT(*)FROM   muvekkilcarihareket) AS muvekkil_cari_sayi,(SELECT COUNT(*)FROM   muvekkildavahareket) AS muvekkil_dava_sayi,(SELECT COUNT(*)FROM   muvekkildavalibilgi) AS muvekkil_davali_sayi,(SELECT COUNT(*)FROM   muvekkilhukukihareket) AS muvekkil_hukuki_sayi,(SELECT COUNT(*)FROM   muvekkilozelhareket) AS muvekkil_ozel_sayi from dual ";
 					
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					if(rs1.next())
					{
						satirlar[0]=rs1.getString("personel_sayi")+" kayýt";
						satirlar[1]=rs1.getString("avukat_sayi")+" kayýt";
						satirlar[2]=rs1.getString("muvekkil_sayi")+" kayýt";
						satirlar[3]=rs1.getString("muvekkil_cari_sayi")+" kayýt";
						satirlar[4]=rs1.getString("muvekkil_dava_sayi")+" kayýt";
						satirlar[5]=rs1.getString("muvekkil_davali_sayi")+" kayýt";
						satirlar[6]=rs1.getString("muvekkil_hukuki_sayi")+" kayýt";
						satirlar[7]=rs1.getString("muvekkil_ozel_sayi")+" kayýt";
						 
						modelim.addRow(satirlar);
						
					}
					table2.setModel(modelim);
   				
				}catch(SQLException e1)
				{
					e1.printStackTrace();
				}

			}
		});
		
		
		
		table2 = new JTable();
		//scrollPane.setColumnHeaderView(table);
		//TABLODA SÜTUNLARI TIKLAYINCA ÝÞLEM YAPMASINI ENGELLETÝYORUM
				table2 = new JTable(){
			       // private static final long serialVersionUID = 1L;
			        public boolean isCellEditable(int row, int column) {                
			                return false;               
			        };
			    };
			    //BURAYA KADAR
		scrollPane.setViewportView(table2);
		
		JButton btnNewButton = new JButton("Kabul Ediyorum...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(10, 192, 829, 52);
		contentPane.add(btnNewButton);
		

		modelim.setColumnIdentifiers(kolonlar);
		
	}
}
