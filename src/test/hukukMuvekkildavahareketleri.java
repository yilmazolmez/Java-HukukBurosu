package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
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
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;

public class hukukMuvekkildavahareketleri extends JDialog {
	
	static Connection myconn1;
	static Statement mystat1;
	
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	
	public static int id=0;
	
	public static int id_sakla=0;
	
	public static String id_al;
	
	DefaultTableModel modelim = new DefaultTableModel();
	Object [] kolonlar = {"Dosya No","Muvekkil TC","Avukat","Dava Konusu","Durusma Tarihi","Hatirlat", "Dava No"};
	Object [] satirlar = new Object[7]; //SATIR TANIMLAMA

	private JPanel contentPane;
	private JTextField txtisim;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukMuvekkildavahareketleri frame = new hukukMuvekkildavahareketleri();
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
	public hukukMuvekkildavahareketleri() {
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
					String listele="SELECT * FROM muvekkildavahareket where MuvekkilTC='"+id_al+"'";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					System.out.println("Listeleme Basarili");
					while(rs1.next())
					{
						satirlar[0]=rs1.getString("DosyaNo");
						satirlar[1]=rs1.getString("MuvekkilTC");
						satirlar[2]=rs1.getString("DavaAvukati");
						satirlar[3]=rs1.getString("DavaKonusu");
						satirlar[4]=rs1.getString("DurusmaTarihi");
						satirlar[5]=rs1.getString("hatirlat");
						satirlar[6]=rs1.getString("DavaNo");
						

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
		setTitle("Muvekkil Dava Hareketleri Ekrani");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1150, 380);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmuvekkil = new JLabel("");
		lblmuvekkil.setHorizontalAlignment(SwingConstants.CENTER);
		lblmuvekkil.setOpaque(true);
		lblmuvekkil.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/Gavel-Law-icon.png")).getImage();
		lblmuvekkil.setIcon(new ImageIcon(img));
		lblmuvekkil.setBounds(10, 51, 173, 269);
		contentPane.add(lblmuvekkil);
		
		JLabel lblmuvekkilislemleri = new JLabel("Muvekkil Dava Hareketleri Ekrani");
		lblmuvekkilislemleri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblmuvekkilislemleri.setBounds(10, 11, 391, 26);
		contentPane.add(lblmuvekkilislemleri);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvazgec.setBounds(997, 290, 100, 30);
		contentPane.add(btnvazgec);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_al=hukukMuvekkilanaform.id2;
				System.out.println(id_al);
				hukukMuvekkildavahareketekle frame = new hukukMuvekkildavahareketekle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnekle.setBounds(193, 290, 100, 30);
		contentPane.add(btnekle);
		
		JButton btnsil = new JButton("Sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					String tut_id = table.getValueAt(table.getSelectedRow(),6).toString();
					
					int selectedOption = JOptionPane.showConfirmDialog(null," Bu dava hareketini silmek istiyor musunuz?","SÝL",JOptionPane.YES_NO_OPTION); 
					if (selectedOption == JOptionPane.YES_OPTION)
					{
						
						try {
							myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
							Statement statement = myconn1.createStatement();
							String sorgu_sil="Delete from muvekkildavahareket where DavaNo='"+tut_id+"'";
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
				}		else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}
			}
		});
		btnsil.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsil.setBounds(413, 290, 100, 30);
		contentPane.add(btnsil);
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 id = Integer.parseInt(table.getValueAt(table.getSelectedRow(),6).toString());
						System.out.println(id);
						hukukMuvekkildavahareketekle form = new hukukMuvekkildavahareketekle();
						form.setVisible(true);
						form.setLocationRelativeTo(null);
						//dispose();
						 
				 }
				 catch(Exception hata)
					{
					 JOptionPane.showMessageDialog(null,"Lütfen bir satýr seciniz");
						System.err.println(hata);
					}
			}
		});
		
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnduzenle.setBounds(303, 290, 100, 30);
		contentPane.add(btnduzenle);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DosyaNo", "MuvekkilTC", "DavaAvukati", "DavaKonusu", "DurusmaTarihi", "hatirlat"}));
		comboBox.setBounds(303, 249, 210, 26);
		contentPane.add(comboBox);
		
		txtisim = new JTextField();
		txtisim.setBounds(523, 249, 448, 26);
		contentPane.add(txtisim);
		//txtisim.setColumns(10);
		
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
					String query = "select * from muvekkildavahareket where MuvekkilTC='"+id_al+"' and "+secenek+" like ?";
					String ara = txtisim.getText();
					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					preparedStatement= myconn1.prepareStatement(query);
					preparedStatement.setString(1,"%"+ara+"%");	
					rs1=preparedStatement.executeQuery();
					System.out.println("Listeleme Basarili");
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					//table.setModel(modelim);
					while(rs1.next())
					{
						satirlar[0]=rs1.getString("DosyaNo");
						satirlar[1]=rs1.getString("MuvekkilTC");
						satirlar[2]=rs1.getString("DavaAvukati");
						satirlar[3]=rs1.getString("DavaKonusu");
						satirlar[4]=rs1.getString("DurusmaTarihi");
						satirlar[5]=rs1.getString("hatirlat");
						satirlar[6]=rs1.getString("DavaNo");
						

						modelim.addRow(satirlar);
						
					}
					table.setModel(modelim);
					txtisim.setText("");
					//pst.close();
					
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnara.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnara.setBounds(997, 249, 100, 30);
		contentPane.add(btnara);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RAPOR ALMA ISLEMI
				hukukMuvekkildavahareketrapor_cagir rapor = new hukukMuvekkildavahareketrapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),6).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRapor.setBounds(523, 290, 100, 30);
		contentPane.add(btnRapor);
		
		JButton btnYardim = new JButton("Yardim");
		btnYardim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnYardim.setBounds(633, 290, 100, 30);
		contentPane.add(btnYardim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(193, 51, 917, 172);
		contentPane.add(scrollPane);
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		modelim.setColumnIdentifiers(kolonlar);
	
		
		JLabel lblNewLabel = new JLabel("Arama Kriteri:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(193, 249, 100, 14);
		contentPane.add(lblNewLabel);

	}
}
