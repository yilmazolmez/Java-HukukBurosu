package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultEditorKit.BeepAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hukukHatirlatmapopup extends JDialog {
	static Connection myconn1;
	static java.sql.Statement mystat1;
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"Ilgili","Aciklama","hatirlat","hakedis"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[4]; //SATIR TANIMLAMA
	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukHatirlatmapopup frame = new hukukHatirlatmapopup();
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
	
		JLabel lblNewLabel = new JLabel("***** Bugun ve Sonraki tarihli Hatirlatilacaklar *****");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(13, 11, 1155, 37);
		contentPane.add(lblNewLabel);

		Thread clock=new Thread() {
			
			public void run () {
				
				try {
					ResultSet rs = null;

					for(;;) {
						
						LocalDate now1 = LocalDate.now(); // 2014-04-05
						Calendar cal=new GregorianCalendar();
						
						int day1=now1.getDayOfMonth();
						int month1=now1.getMonthValue();
						int year1=now1.getYear();
						
						//int day=cal.get(Calendar.DAY_OF_MONTH);
						//int month=cal.get(Calendar.MONTH);
						//int year=cal.get(Calendar.YEAR);
											
						int second=cal.get(Calendar.SECOND);
						int minute=cal.get(Calendar.MINUTE);
						int hour=cal.get(Calendar.HOUR_OF_DAY);
						
						now.setText(day1+"-"+month1+"-"+year1+" "+hour+":"+minute);
						
					

					
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
	

	public hukukHatirlatmapopup() {
		setResizable(false);
		setTitle("Hukuk Otomasyonu - POP UP Hatirlatma Ekrani");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1202, 558);
		setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 91, 1155, 353);
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
					System.out.println("Baðlantý Saðlandý");
					//String listele="Select A.Aciklama,A.hatirlat,A.hakedis,B.MuvekkilAdi From muvekkildavahareket A,muvekkilbilgi B where A.MuvekkilTC=B.MuvekkilTC and A.hatirlat>=DATE(NOW()) order by A.hatirlat asc";
					String listele="Select A.DavaAvukati,A.Aciklama,A.hatirlat,A.hakedis From muvekkildavahareket A where A.hatirlat>=DATE(NOW())  UNION ALL Select C.HareketAvukati,C.Aciklama,C.hatirlat,C.hakedis From muvekkilhukukihareket C where C.hatirlat>=DATE(NOW()) UNION ALL Select E.KonusanAvukat,E.Aciklama,E.hatirlat,E.hakedis From muvekkilozelhareket E where E.hatirlat>=DATE(NOW()) UNION ALL Select H.MuvekkilAdi,G.Aciklama,G.hatirlat,G.hakedis From muvekkilcarihareket G,muvekkilbilgi H where G.MuvekkilTC=H.MuvekkilTC and G.hatirlat>=DATE(NOW()) UNION ALL Select J.personeladisoyadi,J.Aciklama,J.hatirlat,J.hakedis From hukukajanda J where J.hatirlat>=DATE(NOW()) order by hatirlat asc ";
					//String listele="Select A.Aciklama,A.hatirlat,A.hakedis,B.MuvekkilAdi From muvekkildavahareket A,muvekkilbilgi B where A.MuvekkilTC=B.MuvekkilTC and A.hatirlat>=DATE(NOW())  UNION ALL Select C.Aciklama,C.hatirlat,C.hakedis,D.MuvekkilAdi From muvekkilhukukihareket C,muvekkilbilgi D where C.MuvekkilTC=D.MuvekkilTC and C.hatirlat>=DATE(NOW()) UNION ALL Select E.Aciklama,E.hatirlat,E.hakedis,F.MuvekkilAdi From muvekkilozelhareket E,muvekkilbilgi F where E.MuvekkilTC=F.MuvekkilTC and E.hatirlat>=DATE(NOW()) UNION ALL Select G.Aciklama,G.hatirlat,G.hakedis,H.MuvekkilAdi From muvekkilcarihareket G,muvekkilbilgi H where G.MuvekkilTC=H.MuvekkilTC and G.hatirlat>=DATE(NOW()) order by hatirlat asc ";
//					String listele="Select * From burobilgi";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					System.out.println("Listeleme Basarili");
					while(rs1.next())
					{
						satirlar[0]=rs1.getString("DavaAvukati");
						satirlar[1]=rs1.getString("Aciklama");
						satirlar[2]=rs1.getString("Hatirlat");
						satirlar[3]=rs1.getString("hakedis");
						modelim.addRow(satirlar);
						
					}
					table.setModel(modelim);
					table.updateUI();
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				}catch(Exception hata)
				{
					System.err.println(hata);
				}

			}
		});
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("Hatirlatmalari Gordum Kabul Ediyorum !");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(13, 455, 1155, 53);
		contentPane.add(btnNewButton);
	modelim.setColumnIdentifiers(kolonlar);
		
		
	}
}
