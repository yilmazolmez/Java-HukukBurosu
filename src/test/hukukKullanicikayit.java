package test;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Font;

//public class hukukKullanicikayit extends JFrame {
public class hukukKullanicikayit extends JDialog {

	private JPanel contentPane;
	private JTable table1;
	public static int id=0;
	public static int id_sakla=0;
	public static String secilenkullanici;
	
//1- JFRAME AC 2- SCROOL PANE CIZ 3- JTABLE CIZ 4- DEFAULTTABLEMODEL TANIMLA 5- KOLON VE SATIRLARI TANIMLA
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	
	Object [] kolonlar = {"Kullanici Adi","Aciklama","Yetkisi","kullaniciid"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[4]; //SATIR TANIMLAMA
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					hukukKullanicikayit frame = new hukukKullanicikayit();
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
	public hukukKullanicikayit() {
		setModal(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("Pencere Acildi");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Pencere kapandi");
			}
			@Override
			public void windowActivated(WindowEvent e) {
				
				hukukAnaMenu.avukatanabuton.setEnabled(true);
			    hukukAnaMenu.yardimanabuton.setEnabled(true);
			    hukukAnaMenu.muvekkilanabuton.setEnabled(true);
			    hukukAnaMenu.kullanicianabuton.setEnabled(true);
			    hukukAnaMenu.personelanabuton.setEnabled(true);
			    hukukAnaMenu.burobilgianabuton.setEnabled(true);
			    hukukAnaMenu.cikisbuton.setEnabled(true);
			    hukukAnaMenu.yardimbtn.setEnabled(true);
			    hukukAnaMenu.loganabuton.setEnabled(true);
			    hukukAnaMenu.hatirlatmabuton.setEnabled(true);
				
				modelim.setRowCount(0);//TABLOYU TEMIZLIYOR
				ResultSet rs1=hukukBaglanti.kullanicilistele(); //BAGLANTI CLASINDAN KULLANICILISTELE CALISIYOR
				try {
				while(rs1.next()) {
					satirlar[0]=rs1.getString("kadi");
					satirlar[1]=rs1.getString("kaciklama");
					satirlar[2]=rs1.getString("yetki");
					satirlar[3]=rs1.getString("kullaniciid");
					modelim.addRow(satirlar);
				}		
				}catch(SQLException hata)
				{
					System.err.println(hata);
					}
				table1.setModel(modelim);
				table1.updateUI();
				System.out.println("TOPLAM KAYIT: "+table1.getRowCount());
				if (table1.getRowCount()>0) {table1.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				
			}
		});
		setTitle("Kullanici Kayitlari Ekrani");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1020, 454);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 52, 716, 285);
		contentPane.add(scrollPane);
		

		table1 = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table1);
		modelim.setColumnIdentifiers(kolonlar);
		table1.setBounds(110, 112, 565, 197);
		scrollPane.setViewportView(table1);
		
		JButton btnNewButton = new JButton("Guncelle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			modelim.setRowCount(0);//TABLOYU TEMIZLIYOR
				ResultSet rs1=hukukBaglanti.kullanicilistele(); //BAGLANTI CLASINDAN KULLANICILISTELE CALISIYOR
				try {
				while(rs1.next()) {
					satirlar[0]=rs1.getString("kadi");
					satirlar[1]=rs1.getString("kaciklama");
					satirlar[2]=rs1.getString("yetki");
					satirlar[3]=rs1.getString("kullaniciid");
					modelim.addRow(satirlar);
				}		
				}catch(SQLException hata)
				{
					System.err.println(hata);
					}
				table1.setModel(modelim);

			}
		});
		btnNewButton.setBounds(635, 348, 162, 54);
		contentPane.add(btnNewButton);
		
		JButton btnYeniKayit = new JButton("Yeni Kayit");
		btnYeniKayit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnYeniKayit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				hukukKullanicikayitdetay frame = new hukukKullanicikayitdetay();
				frame.show();
				frame.setLocationRelativeTo(null);}	//FORMU MERKEZE ALIYOR
				else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}
			}
		});
		btnYeniKayit.setBounds(270, 348, 162, 54);
		contentPane.add(btnYeniKayit);
		
		JButton btnKapat = new JButton("Kapat");
		btnKapat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnKapat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnKapat.setBounds(824, 348, 162, 54);
		contentPane.add(btnKapat);
	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/User-Group-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(10, 52, 250, 350);
		contentPane.add(lblNewLabel);
		
		JLabel lblKullaniciListesi = new JLabel("Kullanici Kayitlari Ekrani");
		lblKullaniciListesi.setHorizontalAlignment(SwingConstants.LEFT);
		lblKullaniciListesi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblKullaniciListesi.setBounds(10, 11, 392, 26);
		contentPane.add(lblKullaniciListesi);
		
		JButton btnDegistir = new JButton("Degistir");
		btnDegistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secilenkullanici=table1.getValueAt(table1.getSelectedRow(),0).toString();
				if (secilenkullanici.equals(hukukBaglanti.logkullaniciadi)) {
				 try {
					 id = Integer.parseInt(table1.getValueAt(table1.getSelectedRow(),3).toString());
					 
						System.out.println(id);
						hukukKullanicikayitdetay frame = new hukukKullanicikayitdetay();
						frame.show();
						frame.setLocationRelativeTo(null);}	//FORMU MERKEZE ALIYOR
						//dispose();
						 
				 catch(Exception hata)
					{
					 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						System.err.println(hata);
					}}		else {
						//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
						Object [] noSaveOption = {"Tamam"};
						int noSave = JOptionPane.showOptionDialog(null,"Yalnizca Kendi Kullanicinizi degistirebilirsiniz!..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}

					
		}
		});
		btnDegistir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDegistir.setBounds(449, 348, 162, 54);
		contentPane.add(btnDegistir);
	}
}
