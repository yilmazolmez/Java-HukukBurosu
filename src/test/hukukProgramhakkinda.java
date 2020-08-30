package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//public class hukukProgramhakkinda extends JFrame {
public class hukukProgramhakkinda extends JDialog { //SHOW MODAL YANI BASKA YERE TIKLANAMAZ OZELLIGI GETIRIYOR

	
	private JPanel contentPane;
	private JTextField txtDocDrPnar;
	private JTextField txtHukukBurosuOtomasyonu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					hukukProgramhakkinda frame = new hukukProgramhakkinda();
					//frame.setVisible(true);
					//frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public hukukProgramhakkinda() {
		setModal(true);//SHOW MODAL YANI EN USTTE OZELLIGI GETIRIYOR
		setResizable(false);
		setTitle("Hakkimizda");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 572);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Developer Ekibimiz :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 100, 202, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblUygulamaAdimiz = new JLabel("Proje Adi :");
		lblUygulamaAdimiz.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUygulamaAdimiz.setBounds(10, 60, 202, 26);
		contentPane.add(lblUygulamaAdimiz);
		
		JLabel lblProjeDersi = new JLabel("Proje Akademisyeni :");
		lblProjeDersi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProjeDersi.setBounds(10, 20, 202, 26);
		contentPane.add(lblProjeDersi);
		
		txtDocDrPnar = new JTextField();
		txtDocDrPnar.setBackground(Color.WHITE);
		txtDocDrPnar.setEditable(false);
		txtDocDrPnar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDocDrPnar.setText("Doc. Dr. Pinar TUFEKCI");
		txtDocDrPnar.setHorizontalAlignment(SwingConstants.CENTER);
		txtDocDrPnar.setBounds(295, 20, 261, 26);
		contentPane.add(txtDocDrPnar);
		txtDocDrPnar.setColumns(10);
		
		txtHukukBurosuOtomasyonu = new JTextField();
		txtHukukBurosuOtomasyonu.setBackground(Color.WHITE);
		txtHukukBurosuOtomasyonu.setEditable(false);
		txtHukukBurosuOtomasyonu.setHorizontalAlignment(SwingConstants.CENTER);
		txtHukukBurosuOtomasyonu.setText("Hukuk Burosu Otomasyonu");
		txtHukukBurosuOtomasyonu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHukukBurosuOtomasyonu.setColumns(10);
		txtHukukBurosuOtomasyonu.setBounds(295, 60, 261, 26);
		contentPane.add(txtHukukBurosuOtomasyonu);
		
		JList list = new JList();
		list.setVisibleRowCount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBackground(Color.WHITE);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Yilmaz OLMEZ", "Zerrin CERKES", "Sare OZKAN", "Devrim GUNES", "D\u00F6ne ATES", "Muhammed BEYYUD", "Hasan HACISULEYMAN", "Yunus MAZOOGLU", "Mehmet Salih OZTURK", "Mustafa ALTUNDAG"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(295, 137, 261, 292);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Tamam");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(10, 487, 546, 36);
		contentPane.add(btnNewButton);
		
		JLabel labelanafoto = new JLabel("");
		labelanafoto.setOpaque(true);
		labelanafoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelanafoto.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/justice-balance-icon (1).png")).getImage();
		labelanafoto.setIcon(new ImageIcon(img));
		labelanafoto.setBounds(10, 137, 277, 292);
		contentPane.add(labelanafoto);
		
		JButton btnNewButton_1 = new JButton("Kullanim Kilavuzu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///// YARDIM KILAVUZU ONLINE			
				//String FILE = "D:/Hukukyardim.pdf";
				String FILE = "https://drive.google.com/open?id=10c5xaWMYREhapEDdghG5vQ1Q2DVc9rHy"; //Online Kullanim Kilavuzumuz
				
				try {
					if (new URL(FILE) != null) {
						Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + FILE);
						p.waitFor();
					} else {
						System.out.println("Dosya Bulunamadi");
					}
					System.out.println("Basarili");
				} catch (Exception ex) {
					ex.printStackTrace();
				}


				//YARDIM KILAVUZU ONLINE
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Image  img5=new ImageIcon(this.getClass().getResource("/yardim12pix.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img5));
		btnNewButton_1.setBounds(10, 440, 546, 36);
		contentPane.add(btnNewButton_1);
	}
}
