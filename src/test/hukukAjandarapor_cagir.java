package test;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.lowagie.text.Document;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class hukukAjandarapor_cagir {
	
	static Connection myconn1;
	static Statement mystat1;
	
	public void rapor(String sayi) {
		
		ResultSet rs1 = null;
		
		try 
		{
	 
			myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
			String listele="Select * From hukukajanda where islemid='"+sayi+"'";
			mystat1=myconn1.createStatement();
			rs1=mystat1.executeQuery(listele);
				if(rs1.next())
				{	
					String path;
					path=System.getProperty("user.home") + "/Desktop"; //DESKTOP YOLUNU BULMA
					Document document = new Document();
					PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path+"\\hukukajanda.pdf"));
					document.open();
					//ekrana yazýlar basýlýyor
					document.add(new Paragraph("SECILEN AJANDA SATIRI BILGILERI :"));
					
				
				
				
				
			         //Liste yöntemiyle veri ekleme
			         List list = new List(List.UNORDERED);
			            list.add(new ListItem("Ajanda islemid="+rs1.getString("islemid")));
			            list.add(new ListItem("Ajanda islemtarihi="+rs1.getString("islemtarihi")));
			            list.add(new ListItem("Ajanda Aciklama="+rs1.getString("Aciklama")));
			            list.add(new ListItem("Ajanda hatirlat="+rs1.getString("hatirlat")));
			            list.add(new ListItem("Ajanda hakedis="+rs1.getString("hakedis")));
			            list.add(new ListItem("Ajanda personeladisoyadi="+rs1.getString("personeladisoyadi")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Bu Rapor :"+ hukukBaglanti.versionadi+" Uygulamasi ile talebiniz uzere olusturulmustur..."));
			           document.add(list);
			         
					//Dökümaný kapatýyoruz
					document.close();
			        pdfWriter.close();
				
			        
			        
			        //Eklenen pdf'i direk olarak açma
			       // String FILE = "C:\\Users\\yýlmaz\\eclipse-workspace\\Deneme\\avukatbilgi.pdf";
			        String FILE = path+"\\hukukajanda.pdf";
					try 
					{
						if ((new File(FILE)).exists()) {
							Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + FILE);
							p.waitFor();
						} else {
							System.out.println("Dosya Bulunamadi");
						}
						System.out.println("Islem Basarili");
					}catch (Exception ex) {
						ex.printStackTrace();
					}
			        
		        
				}	
		}
		catch(Exception e1)
		{
			 JOptionPane.showMessageDialog(null,"1 satýr seçiniz veya");
				e1.printStackTrace();
		}
		
 
	}
	
	
}
