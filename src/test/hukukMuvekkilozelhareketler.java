package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

//import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

public class hukukMuvekkilozelhareketler extends JDialog {
	
	

	private JPanel contentPane;
	
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	
	static Connection myconn1;
	static Statement mystat1;
	
	private JTable table;
	
	
	
	public static int id=0;
	public static int id_sakla=0;
	
	public static String id_al;
	
	DefaultTableModel modelim = new DefaultTableModel();
	Object [] kolonlar = {"Gorusme Tarihi","Muvekkil TC No","Muvekkil Adý","Avukat Adi","Hatirlatma","Ozel Hareket ID"};
	Object [] satirlar = new Object[6]; //SATIR TANIMLAMA
	private JTextField textField_anahtarkelime;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukMuvekkilozelhareketler frame = new hukukMuvekkilozelhareketler();
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
	public hukukMuvekkilozelhareketler() {
		
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
				try 
				{
					
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					System.out.println("Baðlantý Saðlandý");
					String listele="SELECT * FROM muvekkilozelhareket where MuvekkilTC='"+id_al+"'";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					while(rs1.next())
					{
						satirlar[0]=rs1.getString("Ozelharekettarihi");
						satirlar[1]=rs1.getString("MuvekkilTC");
						satirlar[2]=rs1.getString("KonusulanKisi");
						satirlar[3]=rs1.getString("KonusanAvukat");
						satirlar[4]=rs1.getString("hatirlat");
						satirlar[5]=rs1.getString("OzelHareketID");
						modelim.addRow(satirlar);
						
					}
					table.setModel(modelim);
					table.updateUI();
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					
				
				}catch(SQLException e1)
				{
					e1.printStackTrace();
				}

			}
		});
		
		
	
		
		setModal(true);
		setResizable(false);
		setTitle("Muvekkil Ozel Gorusme Hareketleri");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1087, 460);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmuvekkil = new JLabel("");
		lblmuvekkil.setOpaque(true);
		lblmuvekkil.setHorizontalAlignment(SwingConstants.CENTER);
		lblmuvekkil.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/Groups-Meeting-Dark-icon.png")).getImage();
		lblmuvekkil.setIcon(new ImageIcon(img));
		lblmuvekkil.setBounds(10, 48, 256, 361);
		contentPane.add(lblmuvekkil);
		
		JLabel lblmuvekkilislemleri = new JLabel("Muvekkil Ozel Gorusme Hareketleri");
		lblmuvekkilislemleri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblmuvekkilislemleri.setBounds(10, 11, 414, 26);
		contentPane.add(lblmuvekkilislemleri);
		

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"OzelHareketID", "Ozelharekettarihi", "KonusulanKisi", "KonusanAvukat", "MuvekkilTC", "hatirlat"}));
		comboBox.setBounds(386, 343, 210, 30);
		contentPane.add(comboBox);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvazgec.setBounds(950, 379, 100, 30);
		contentPane.add(btnvazgec);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (hukukBaglanti.logkullaniciyetkisi.equals("AVUKAT"))) {//KULLANICI YETKI KONTROLU		
				id_al=hukukMuvekkilanaform.id2;
				System.out.println(id_al);
				hukukMuvekkilozelhareketekle frame = new hukukMuvekkilozelhareketekle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}
				else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI ve AVUKAT yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}}

		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnekle.setBounds(276, 379, 100, 30);
		contentPane.add(btnekle);
		
		JButton btnsil = new JButton("Sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					String tut_id = table.getValueAt(table.getSelectedRow(),5).toString();
					
					int selectedOption = JOptionPane.showConfirmDialog(null," Bu görüþme bilgisini silmek istiyor musunuz?","SÝL",JOptionPane.YES_NO_OPTION); 
					if (selectedOption == JOptionPane.YES_OPTION)
					{
						try {
							myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
							Statement statement = myconn1.createStatement();
							String sorgu_sil="Delete from muvekkilozelhareket where OzelHareketID='"+tut_id+"'";
							statement.executeUpdate(sorgu_sil);
							JOptionPane.showMessageDialog(null,"Dava hareketi silindi.");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}
					}
					
				 }
				 catch(Exception hata)
					{
					 JOptionPane.showMessageDialog(null,"1 satýr seciniz");
						System.err.println(hata);
					}
			}
				else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}}
		});
		btnsil.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsil.setBounds(496, 379, 100, 30);
		contentPane.add(btnsil);

		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (hukukBaglanti.logkullaniciyetkisi.equals("AVUKAT"))) {//KULLANICI YETKI KONTROLU
				 try {
					
					 id = Integer.parseInt(table.getValueAt(table.getSelectedRow(),5).toString());
						System.out.println(id);
						hukukMuvekkilozelhareketekle form = new hukukMuvekkilozelhareketekle();
						form.setVisible(true);
						form.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
						//dispose();
						 
				 }
				 catch(Exception hata)
					{
					 JOptionPane.showMessageDialog(null,"Lutfen bir satýr seciniz");
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
		
		
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnduzenle.setBounds(386, 379, 100, 30);
		contentPane.add(btnduzenle);
		

		
		
		/*jtfFilter = new JTextField();
		jtfFilter.setBounds(276, 239, 545, 30);
		contentPane.add(jtfFilter);
		jtfFilter.setColumns(10);*/
		
		JButton btnara = new JButton("Ara");
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id_al=hukukMuvekkilanaform.id2;
				modelim.setRowCount(0);
				ResultSet rs1 = null;
				
				try {
					String secenek = (String)comboBox.getSelectedItem();
					String query = "select * from muvekkilozelhareket where MuvekkilTC='"+id_al+"' and "+secenek+" like ?";
					String ara = textField_anahtarkelime.getText();
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					preparedStatement = myconn1.prepareStatement(query);
					preparedStatement.setString(1,"%"+ara+"%");			
					rs1=preparedStatement.executeQuery();
					System.out.println("Listeleme Basarili");
					
					//PreparedStatement pst = hukukBaglanti.getConnection().prepareStatement(query);
					//pst.setString(1, textField_anahtarkelime.getText());
					//ResultSet rs= pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					//table.setModel(modelim);
					while(rs1.next())
					{
						satirlar[0]=rs1.getString("Ozelharekettarihi");
						satirlar[1]=rs1.getString("MuvekkilTC");
						satirlar[2]=rs1.getString("KonusulanKisi");
						satirlar[3]=rs1.getString("KonusanAvukat");
						satirlar[4]=rs1.getString("hatirlat");
						satirlar[5]=rs1.getString("OzelHareketID");
						modelim.addRow(satirlar);
						
					}
					table.setModel(modelim);
					textField_anahtarkelime.setText("");
					//pst.close();
					
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}

			
		});
		
		btnara.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnara.setBounds(950, 343, 100, 30);
		contentPane.add(btnara);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RAPOR ALMA ISLEMI
				hukukMuvekkilozelhareketrapor_cagir rapor = new hukukMuvekkilozelhareketrapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),5).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRapor.setBounds(606, 379, 100, 30);
		contentPane.add(btnRapor);
		
		JButton btnYardim = new JButton("Yardim");
		btnYardim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnYardim.setBounds(721, 379, 100, 30);
		contentPane.add(btnYardim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setBounds(276, 48, 774, 284);
		contentPane.add(scrollPane);
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		modelim.setColumnIdentifiers(kolonlar);
		
		textField_anahtarkelime = new JTextField();
		textField_anahtarkelime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_anahtarkelime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
		});
		textField_anahtarkelime.setBounds(606, 343, 215, 30);
		contentPane.add(textField_anahtarkelime);
		//textField_anahtarkelime.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Arama Kriteri:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(276, 343, 100, 30);
		contentPane.add(lblNewLabel);
		

	}
}