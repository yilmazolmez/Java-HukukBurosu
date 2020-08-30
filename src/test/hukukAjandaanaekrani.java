package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class hukukAjandaanaekrani extends JDialog{

	private JPanel contentPane;
	private JTextField textkonu;
	private JTable table;
	public static int id=0;
	public static int id_sakla=0;
	
	private PreparedStatement preparedStatement = null;

	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"Aciklama","hatirlat","hakedis","islemid","personel"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[5]; //SATIR TANIMLAMA
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukAjandaanaekrani frame = new hukukAjandaanaekrani();
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
	public hukukAjandaanaekrani() {
		setModal(true);
		setResizable(false);
		setTitle("Hukuk Ajanda Kayitlari");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1201, 475);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//HATIRLATMA EKRANINI YALNIZCA KAYIT OLUP OLMAMASI OPSIYONUNA CEVIREBILIRIZ
		hukukHatirlatmapopup frame = new hukukHatirlatmapopup();
		frame.show();
		frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
		//
		//HATIRLATMA EKRANINI YALNIZCA KAYIT OLUP OLMAMASI OPSIYONUNA CEVIREBILIRIZ
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 47, 231, 370);
		Image  img=new ImageIcon(this.getClass().getResource("/folder-documents-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hukuk Ajanda ve Hatirlatma Ekrani");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 366, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnara = new JButton("Ara");
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					textkonu.setText("");
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					textkonu.requestFocus();
				} catch (Exception e2) {
					System.out.println(e2);
					// TODO: handle exception
				}
				
				
			}
		});
		btnara.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnara.setBounds(1071, 309, 100, 30);
		contentPane.add(btnara);
		
		textkonu = new JTextField();
		textkonu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				///HER KELIMEYLE ARAMA
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelim);
			    table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textkonu.getText()));
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				///
			}
		});
		textkonu.setBounds(251, 309, 594, 30);
		contentPane.add(textkonu);
		textkonu.setColumns(10);
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 3).toString());
						hukukAjandakaydiekle frame = new hukukAjandakaydiekle();
						frame.show();
						frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
						//dispose();
				}catch(Exception hata)
				{
				 	JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
					System.err.println(hata);
				}
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(374, 346, 110, 30);
		contentPane.add(btnduzenle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
					
						int id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 3).toString());
						String ad=table.getValueAt(table.getSelectedRow(),0).toString();
		
						hukukBaglanti baglan = new hukukBaglanti();
						baglan.yap();
						String sorgu="delete from hukukajanda where islemid='"+id+"'";
						int selectedOption = JOptionPane.showConfirmDialog(null,ad+" Silmek istiyor musunuz?","SIL",JOptionPane.YES_NO_OPTION); 
						if (selectedOption == JOptionPane.YES_OPTION)
						{
							
							try {
 								Statement statement = baglan.myconn1.createStatement();
 								statement.executeUpdate(sorgu);
								JOptionPane.showMessageDialog(null,ad+" silindi");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								
							}
						}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}}
				 catch(Exception hata)
					{
					 	JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						System.err.println(hata);
					}
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSil.setBounds(494, 346, 110, 30);
		contentPane.add(btnSil);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hukukAjandakaydiekle frame = new hukukAjandakaydiekle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				//dispose();
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(251, 346, 110, 30);
		contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(1071, 387, 100, 30);
		contentPane.add(btnvazgec);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 47, 920, 246);
		contentPane.add(scrollPane);
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RAPOR ALMA ISLEMI
				hukukAjandarapor_cagir rapor = new hukukAjandarapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),3).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRapor.setBounds(614, 346, 110, 30);
		contentPane.add(btnRapor);
		
		JButton btnSil_1_1 = new JButton("Yardim");
		btnSil_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSil_1_1.setBounds(735, 346, 110, 30);
		contentPane.add(btnSil_1_1);
		
		JButton btnHatirlatmaPopupEkrani = new JButton("Hatirlatma Popup Ekrani");
		btnHatirlatmaPopupEkrani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//HATIRLATMA EKRANINI YALNIZCA KAYIT OLUP OLMAMASI OPSIYONUNA CEVIREBILIRIZ
				hukukHatirlatmapopup frame = new hukukHatirlatmapopup();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				//
				//HATIRLATMA EKRANINI YALNIZCA KAYIT OLUP OLMAMASI OPSIYONUNA CEVIREBILIRIZ
			}
		});
		btnHatirlatmaPopupEkrani.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHatirlatmaPopupEkrani.setBounds(251, 387, 594, 30);
		contentPane.add(btnHatirlatmaPopupEkrani);
		modelim.setColumnIdentifiers(kolonlar);
		
		
		
		addWindowListener(new WindowAdapter() {
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
			    
				hukukBaglanti baglan = new hukukBaglanti();
				baglan.yap();
				modelim.setRowCount(0);
				String listele = "select * from hukukajanda order by hatirlat asc ";
				ResultSet rs1=null;
				try {
					baglan.mystat1=baglan.myconn1.createStatement();
					rs1=baglan.mystat1.executeQuery(listele);
					while(rs1.next())
					{
						satirlar[0]=rs1.getString("aciklama");
						satirlar[1]=rs1.getString("hatirlat");
						satirlar[2]=rs1.getString("hakedis");
						satirlar[3]=rs1.getString("islemid");
						satirlar[4]=rs1.getString("personeladisoyadi");
						modelim.addRow(satirlar);
						
					}
					table.setModel(modelim);
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					//final TableColumn column = table.getColumnModel().getColumn(5);
					 //column.setMinWidth(0);
	                 //column.setMaxWidth(0);
	                 //column.setWidth(0);
	                 //column.setPreferredWidth(0);
	                 //column.setResizable(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
