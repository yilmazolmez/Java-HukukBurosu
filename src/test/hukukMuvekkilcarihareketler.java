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
import javax.swing.table.TableRowSorter;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class hukukMuvekkilcarihareketler extends JDialog {

	private JPanel contentPane;
	private JTextField txtisim;
	private JTable table;

	// **************************************/

	// Muvekkilcarihareketno

	// MuvekkilTC
	// Islemtarihi
	// Muvekkilalacaktutar
	// Muvekkilborctutar
	// Aciklamalar
	// hatirlat

	static Connection myconn1;
	static Statement mystat1;
	private PreparedStatement preparedStatement = null;
	public static int id = 0;
	public static int id_sakla = 0;
	
	public static String tc;
	
	public static String id_al;
	
	DefaultTableModel modelim = new DefaultTableModel();// TABLO MODELINI TANIMLIYORUZ
	Object[] kolonlar = { "MuvekkilTC", "Islemtarihi", "Muvekkilalacaktutar", "Muvekkilborctutar", "Aciklama",
			"Hatirlat", "Muvekkilcarihareketno" }; // KOLON TANIMLAMA
	Object[] satirlar = new Object[7]; // SATIR TANIMLAMA

	// *******************************************/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukMuvekkilcarihareketler frame = new hukukMuvekkilcarihareketler();
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
	public hukukMuvekkilcarihareketler() {
		setResizable(false);
		setModal(true);
		setTitle("Muvekkil Cari Hareketler");
		setBounds(100, 100, 997, 370);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// **********************************************/
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("Pencere Acildi");
			}

			public void windowClosing(WindowEvent e) {
				System.out.println("Pencere kapandi");
			}

			@Override
			public void windowActivated(WindowEvent e) {

				modelim.setRowCount(0);
				id_al=hukukMuvekkilanaform.id2;
				ResultSet rs1 = null;
				try {

					myconn1 = DriverManager.getConnection(hukukBaglanti.sunucuparametresi, "root","");
					System.out.println("Baglanti Saglandi");
					String listele = "Select * From muvekkilcarihareket where MuvekkilTC='"+id_al+"'";
					
					mystat1 = myconn1.createStatement();
					rs1 = mystat1.executeQuery(listele);
					System.out.println(rs1);

					System.out.println("Listeleme Basarili");
					while (rs1.next()) {

						// Muvekkilcarihareketno
						// MuvekkilTC
						// Islemtarihi
						// Muvekkilalacaktutar
						// Muvekkilborctutar
						// Aciklamalar
						// hatirlat

						satirlar[0] = rs1.getString("MuvekkilTC");
						satirlar[1] = rs1.getString("Islemtarihi");
						satirlar[2] = rs1.getString("Muvekkilalacaktutar");
						satirlar[3] = rs1.getString("Muvekkilborctutar");
						satirlar[4] = rs1.getString("Aciklama");
						satirlar[5] = rs1.getString("hatirlat");
						satirlar[6] = rs1.getString("Muvekkilcarihareketno");
						modelim.addRow(satirlar);

					}
					table.setModel(modelim);
					table.updateUI();
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					// Id'yi sakl�yorum ama t�klay�nca de�i�kende tutabiliyorum.

					//final TableColumn column = table.getColumnModel().getColumn(6);
					//column.setMinWidth(0);
					//column.setMaxWidth(0);
					//column.setWidth(0);
					//column.setPreferredWidth(0);
					//column.setResizable(false);

				} catch (Exception hata) {
					System.err.println(hata);
					System.out.println("hata");
				}

			}
		});
		// ******************************************************/

		JLabel lblmuvekkil = new JLabel("");
		lblmuvekkil.setHorizontalAlignment(SwingConstants.CENTER);
		lblmuvekkil.setOpaque(true);
		lblmuvekkil.setBackground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/Money-icon.png")).getImage();
		lblmuvekkil.setIcon(new ImageIcon(img));
		lblmuvekkil.setBounds(10, 43, 276, 274);
		contentPane.add(lblmuvekkil);

		JLabel lblmuvekkilislemleri = new JLabel("Muvekkil Cari Hareketler");
		lblmuvekkilislemleri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblmuvekkilislemleri.setBounds(10, 11, 276, 26);
		contentPane.add(lblmuvekkilislemleri);

		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvazgec.setBounds(871, 287, 100, 30);
		contentPane.add(btnvazgec);

		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (hukukBaglanti.logkullaniciyetkisi.equals("AVUKAT"))) {//KULLANICI YETKI KONTROLU

				System.out.println("BURADA1");
				tc = hukukMuvekkilanaform.id1;//Anaformdaki TC numarasini aliyor
				hukukMuvekkilcarihareketekle frame = new hukukMuvekkilcarihareketekle();
				System.out.println("BURADA2");
				frame.show();
				System.out.println("BURADA3");
				frame.setLocationRelativeTo(null); // FORMU MERKEZE ALIYOR
			}
				else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI ve AVUKAT yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnekle.setBounds(296, 287, 100, 30);
		contentPane.add(btnekle);

		JButton btnsil = new JButton("Sil");
		btnsil.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsil.setBounds(406, 287, 100, 30);
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					String tut_id = table.getValueAt(table.getSelectedRow(), 6).toString();
					String tut_ad = table.getValueAt(table.getSelectedRow(), 0).toString();
					int selectedOption = JOptionPane.showConfirmDialog(null, tut_ad + " Silmek istiyor musunuz?", "Sil",
							JOptionPane.YES_NO_OPTION);
					if (selectedOption == JOptionPane.YES_OPTION) {

						try {
							myconn1 = DriverManager.getConnection(hukukBaglanti.sunucuparametresi,"root","");
							Statement statement = myconn1.createStatement();
							String sorgu_sil = "Delete from muvekkilcarihareket where Muvekkilcarihareketno='" + tut_id	+ "'";
							statement.executeUpdate(sorgu_sil);
							JOptionPane.showMessageDialog(null, tut_ad + " silindi");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();

						}
					}

				} catch (Exception hata) {
					JOptionPane.showMessageDialog(null, "1 satir seciniz");
					System.err.println(hata);
				}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}
			}
		});
		contentPane.add(btnsil);

		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnduzenle.setBounds(516, 287, 100, 30);
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (hukukBaglanti.logkullaniciyetkisi.equals("AVUKAT"))) {//KULLANICI YETKI KONTROLU
				try {
					id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 6).toString());
					System.out.println(id);
					hukukMuvekkilcarihareketekle form = new hukukMuvekkilcarihareketekle();
					form.setVisible(true);
					form.setLocationRelativeTo(null);
					//dispose();

				} catch (Exception hata) {
					JOptionPane.showMessageDialog(null, "1 satir seciniz");
					System.err.println(hata);
				}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI ve AVUKAT yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}

			}
		});
		contentPane.add(btnduzenle);

		txtisim = new JTextField();
		txtisim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					///HER KELIMEYLE ARAMA
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelim);
				    table.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(txtisim.getText()));
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					///
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		txtisim.setBounds(296, 242, 538, 30);
		contentPane.add(txtisim);
		txtisim.setColumns(10);

		JButton btnara = new JButton("Ara");
		btnara.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnara.setBounds(871, 242, 100, 30);
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtisim.setText("");
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					txtisim.requestFocus();
				} catch (Exception e2) {
					System.out.println(e2);
					// TODO: handle exception
				}

			}
		});
		contentPane.add(btnara);

		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RAPOR ALMA ISLEMI
				hukukMuvekkilcarihareketrapor_cagir rapor = new hukukMuvekkilcarihareketrapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),6).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRapor.setBounds(626, 287, 100, 30);
		contentPane.add(btnRapor);

		JButton btnduzenle_1_1 = new JButton("Yardim");
		btnduzenle_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnduzenle_1_1.setBounds(736, 287, 100, 30);
		contentPane.add(btnduzenle_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(296, 43, 675, 187);
		contentPane.add(scrollPane);

		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		modelim.setColumnIdentifiers(kolonlar);
	}
}
