package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//public class hukukMuvekkildavalilistesi extends JFrame {
public class hukukMuvekkildavalilistesi extends JDialog {

	private JPanel contentPane;
	private JTextField txtisim;
	private JTable table;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	
	public static int tc=0;
	public static int tc_sakla=0;
	public static String id_al;
	
	static Connection myconn1;
	static Statement mystat1;
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"DavaliTC","AdýSoyadi","Telefon","MuvekkilTC","Davalý Vekili","Davaliid"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[6]; //SATIR TANIMLAMA
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hukukMuvekkildavalilistesi frame = new hukukMuvekkildavalilistesi();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public hukukMuvekkildavalilistesi() {
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Muvekkil Davali Listesi Ekrani");
		setBounds(100, 100, 914, 355);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				id_al=hukukMuvekkilanaform.id1;
				ResultSet rs1 = null;
				try 
				{

					myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
					System.out.println("Baðlantý Saðlandý");
					String listele="Select * From muvekkildavalibilgi where MuvekkilTC='"+id_al+"'";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					System.out.println("Listeleme Basarili");
					while(rs1.next())
					{
						satirlar[0]=rs1.getString("DavaliTC");
						satirlar[1]=rs1.getString("DavaliAdSoyad");
						satirlar[2]=rs1.getString("DavaliTelefon");
						satirlar[3]=rs1.getString("MuvekkilTC");
						satirlar[4]=rs1.getString("DavaliVekili");
						satirlar[5]=rs1.getString("Davaliid");
						
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
		
		JLabel lblmuvekkil = new JLabel("");
		lblmuvekkil.setHorizontalAlignment(SwingConstants.CENTER);
		lblmuvekkil.setOpaque(true);
		lblmuvekkil.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/Jury-Law-icon.png")).getImage();
		lblmuvekkil.setIcon(new ImageIcon(img));
		lblmuvekkil.setBounds(10, 48, 161, 261);
		contentPane.add(lblmuvekkil);
		
		JLabel lblmuvekkilislemleri = new JLabel("Muvekkil Davali Listesi Ekrani");
		lblmuvekkilislemleri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblmuvekkilislemleri.setBounds(10, 11, 313, 26);
		contentPane.add(lblmuvekkilislemleri);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvazgec.setBounds(788, 279, 100, 30);
		contentPane.add(btnvazgec);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_al=hukukMuvekkilanaform.id1;
				hukukMuvekkildavaliekle frame = new hukukMuvekkildavaliekle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				//dispose();
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnekle.setBounds(181, 279, 100, 30);
		contentPane.add(btnekle);
		
		JButton btnsil = new JButton("Sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hukukBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					
					String davaliad = table.getValueAt(table.getSelectedRow(),1).toString();
					String davaliid = table.getValueAt(table.getSelectedRow(),5).toString();
					int selectedOption = JOptionPane.showConfirmDialog(null,davaliad+" Silmek istiyor musunuz?","SIL",JOptionPane.YES_NO_OPTION); 
					if (selectedOption == JOptionPane.YES_OPTION)
					{
						
						try {
							myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
							Statement statement = myconn1.createStatement();
							String sil="Delete from muvekkildavalibilgi where Davaliid='"+davaliid+"'";
							statement.executeUpdate(sil);
							JOptionPane.showMessageDialog(null,davaliad+" silindi");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}
					}
					
				 }
				 catch(Exception hata)
					{
					 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
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
		btnsil.setBounds(408, 279, 100, 30);
		contentPane.add(btnsil);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(181, 48, 707, 179);
		contentPane.add(scrollPane);
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		modelim.setColumnIdentifiers(kolonlar);
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						tc  = Integer.parseInt(table.getValueAt(table.getSelectedRow(),5).toString());
					 
						hukukMuvekkildavaliekle form = new hukukMuvekkildavaliekle();
						form.setVisible(true);
						form.setLocationRelativeTo(null);
						//dispose();
					}
					catch(Exception e1)
					{
					 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						e1.printStackTrace();
					}
					
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnduzenle.setBounds(298, 279, 100, 30);
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
		txtisim.setBounds(181, 238, 551, 30);
		contentPane.add(txtisim);
		txtisim.setColumns(10);
		
		JButton btnara = new JButton("Ara");
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	

			}
		});
		btnara.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnara.setBounds(788, 238, 100, 30);
		contentPane.add(btnara);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//RAPOR ALMA ISLEMI
				hukukMuvekkildavalibilgirapor_cagir rapor = new hukukMuvekkildavalibilgirapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),5).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRapor.setBounds(518, 279, 100, 30);
		contentPane.add(btnRapor);
		
		JButton btnYardim = new JButton("Yardim");
		btnYardim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnYardim.setBounds(632, 279, 100, 30);
		contentPane.add(btnYardim);
		
		
	
	}
}

