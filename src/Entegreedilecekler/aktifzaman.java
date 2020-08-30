package Entegreedilecekler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.*;


import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;


import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.List;

public class aktifzaman {

	private JFrame frame;
	private JLabel now;
	private JLabel renk;
	

	/**
	 * Launch the application. 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aktifzaman window = new aktifzaman();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	

	
	public void clock()//SAAT TARIH FONKSIYONU
	{
		JLabel now = new JLabel("Tarih ve Saat");
		now.setHorizontalAlignment(SwingConstants.LEFT);
		now.setFont(new Font("Tahoma", Font.PLAIN, 12));
		now.setBackground(Color.BLACK);
		now.setForeground(Color.BLACK);
		now.setBounds(10, 11, 397, 103);
		frame.getContentPane().add(now);
		
		List list = new List();
		list.setBounds(10, 185, 572, 126);
		frame.getContentPane().add(list);
	
		Thread clock=new Thread() {
			
			public void run () {

				try {
					for(;;) {
						
					Calendar cal=new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					int second=cal.get(Calendar.SECOND);
					int minute=cal.get(Calendar.MINUTE);
					int hour=cal.get(Calendar.HOUR);
					now.setText("Saat :"+hour+":"+minute+":"+second);
					
					sleep(2000);
					list.add("------ Tarihli Hatirlatilacaklar ----------");
					sleep(2000);
					list.add("--------------------------------------------------");
					sleep(21000);
					list.add("--------------------------------------------------");
					list.add(" 1- Caglayan Adliyesinde Durusmaniz var... ");
					sleep(2000);
					list.add("--------------------------------------------------");
					sleep(2000);
					list.add(" 2- Anadolu  Adliyesinde Durusmaniz var... ");
					sleep(2000);
					list.add("--------------------------------------------------");
					sleep(5000);
					list.clear();
					
					if(second%2 == 5){
						
						now.setVisible(true);
				        }else{
							now.setVisible(false);
				        }
					

				now.setVisible(false);

				}} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}//SAAT TARIH FONKSIYONU

	public aktifzaman() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 608, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clock();
			}
			
		});
		button.setBounds(10, 144, 200, 23);
		frame.getContentPane().add(button);
		
		JLabel renk = new JLabel("New label");
		renk.setBounds(220, 148, 200, 14);
		frame.getContentPane().add(renk);

	}
}

