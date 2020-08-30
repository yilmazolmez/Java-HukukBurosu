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

public class hukukAvukatrapor_cagir {
	
	static Connection myconn1;
	static Statement mystat1;
	
	public void rapor(String sayi) {
		
		ResultSet rs1 = null;
		
		try 
		{
	 
			myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
			String listele="Select * From avukatbilgi where AvukatTc='"+sayi+"'";
			mystat1=myconn1.createStatement();
			rs1=mystat1.executeQuery(listele);
				if(rs1.next())
				{	
					String path;
					path=System.getProperty("user.home") + "/Desktop"; //DESKTOP YOLUNU BULMA
					Document document = new Document();
					PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path+"\\avukatbilgi.pdf"));
					document.open();
					//ekrana yazýlar basýlýyor
					document.add(new Paragraph("SECILEN AVUKAT BILGILERI :"));
					
				
				
				
				
			         //Liste yöntemiyle veri ekleme
			         List list = new List(List.UNORDERED);
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Avukat Tc="+rs1.getString("AvukatTC")));
			            list.add(new ListItem("Avukat Ad="+rs1.getString("AvukatAd")));
			            list.add(new ListItem("Avukat Soyad="+rs1.getString("AvukatSoyad")));
			            list.add(new ListItem("Avukat Baba Ado="+rs1.getString("AvukatBabaAdi")));
			            list.add(new ListItem("Avukat Anne Adý="+rs1.getString("AvukatAnaAdi")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Avukat Adres="+rs1.getString("AvukatAdres")));
			            list.add(new ListItem("Avukat Doðum Tarihi="+rs1.getString("AvukatDogumTarihi")));
			            list.add(new ListItem("Avukat Doðum Yeri="+rs1.getString("AvukatDogumYeri")));
			            list.add(new ListItem("Avukat AvukatCinsiyet="+rs1.getString("AvukatCinsiyet")));
			            list.add(new ListItem("Avukat Telefon="+rs1.getString("AvukatTelefon")));
			            list.add(new ListItem("Avukat SicilNo="+rs1.getString("AvukatSicilNo")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Avukat Mail="+rs1.getString("Avukateposta")));
			            list.add(new ListItem("Avukat Baro="+rs1.getString("AvukatBaro")));
			            list.add(new ListItem("Avukat Hatirlatma="+rs1.getString("hatirlat")));
			            list.add(new ListItem("Avukat Açýklamasý="+rs1.getString("Aciklama")));
			            list.add(new ListItem("Avukat Hakediþ="+rs1.getString("hakedis")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Bu Rapor :"+ hukukBaglanti.versionadi+" Uygulamasi ile talebiniz uzere olusturulmustur..."));
			         document.add(list);
		         
			         
					document.add(new Paragraph("\r SECILEN AVUKAT BILGILERI Tablo Yöntemi"));
			       //tablo ile veri ekleniyor
					 PdfPTable table = new PdfPTable(4); //sütun sayýsýný belirtiyoruz
			         table.setWidthPercentage(100);
			         table.setSpacingBefore(10f);
			         table.setSpacingAfter(10f);
			         
			         PdfPCell cell1 = new PdfPCell(new Paragraph("Avukat Tc \n "+rs1.getString("AvukatTC")));
			         cell1.setPadding(10f);
			         table.addCell(cell1);
			         
			         PdfPCell cell2 = new PdfPCell(new Paragraph("Avukat Adý \n"+rs1.getString("AvukatAd")));
			         cell2.setPadding(10f);
			         table.addCell(cell2);
			         
			         PdfPCell cell3 = new PdfPCell(new Paragraph("Avukat Soyadý \n"+rs1.getString("AvukatSoyad")));
			         cell3.setPadding(10f);
			         table.addCell(cell3);
			         
			         PdfPCell cell4 = new PdfPCell(new Paragraph("Avukat Baba Adý \n"+rs1.getString("AvukatBabaAdi")));
			         cell4.setPadding(10f);
			         table.addCell(cell4);
			         
			         PdfPCell cell5 = new PdfPCell(new Paragraph("Avukat Anne Adý \n"+rs1.getString("AvukatAnaAdi")));
			         cell5.setPadding(10f);
			         table.addCell(cell5);
			         
			         PdfPCell cell6 = new PdfPCell(new Paragraph("Avukat Adres \n"+rs1.getString("AvukatAdres")));
			         cell6.setPadding(10f);
			         table.addCell(cell6);
			         
			         PdfPCell cell7 = new PdfPCell(new Paragraph("Avukat Doðum Tarihi \n"+rs1.getString("AvukatDogumTarihi")));
			         cell7.setPadding(10f);
			         table.addCell(cell7);
			         
			         PdfPCell cell8 = new PdfPCell(new Paragraph("Avukat Doðum Yeri \n"+rs1.getString("AvukatDogumYeri")));
			         cell8.setPadding(10f);
			         table.addCell(cell8);
			         
			         PdfPCell cell9 = new PdfPCell(new Paragraph("Avukat Cinsiyet \n"+rs1.getString("AvukatCinsiyet")));
			         cell9.setPadding(10f);
			         table.addCell(cell9);
			         
			         PdfPCell cell10 = new PdfPCell(new Paragraph("Avukat Telefon \n"+rs1.getString("AvukatTelefon")));
			         cell10.setPadding(10f);
			         table.addCell(cell10);

			         PdfPCell cell11 = new PdfPCell(new Paragraph("Avukat Sicil No \n"+rs1.getString("AvukatSicilNo")));
			         cell11.setPadding(10f);
			         table.addCell(cell11);

			         PdfPCell cell12 = new PdfPCell(new Paragraph("Avukat Mail \n"+rs1.getString("Avukateposta")));
			         cell12.setPadding(10f);
			         table.addCell(cell12);
			         
			         PdfPCell cell13 = new PdfPCell(new Paragraph("Avukat Baro \n"+rs1.getString("AvukatBaro")));
			         cell13.setPadding(10f);
			         table.addCell(cell13);
			         
			         PdfPCell cell14 = new PdfPCell(new Paragraph("Avukat Hatýrlatma \n"+rs1.getString("hatirlat")));
			         cell14.setPadding(10f);
			         table.addCell(cell14);
			         
			         PdfPCell cell15 = new PdfPCell(new Paragraph("Avukat Açýklamasý \n"+rs1.getString("Aciklama")));
			         cell15.setPadding(10f);
			         table.addCell(cell15);
			         
			         PdfPCell cell16 = new PdfPCell(new Paragraph("Avukat Hakedis \n"+rs1.getString("hakedis")));
			         cell16.setPadding(10f);
			         table.addCell(cell16);
			         //sütunlarý tablomuza ekleriz
			         document.add(table);
			         
			         
					//Dökümaný kapatýyoruz
					document.close();
			        pdfWriter.close();
				
			        
			        
			        //Eklenen pdf'i direk olarak açma
			       // String FILE = "C:\\Users\\yýlmaz\\eclipse-workspace\\Deneme\\avukatbilgi.pdf";
			        String FILE = path+"\\avukatbilgi.pdf";
					try 
					{
						if ((new File(FILE)).exists()) {
							Object [] noSaveOption = {"Tamam"};
							int noSave = JOptionPane.showOptionDialog(null,FILE+" isimli 1 Adet Rapor Masaustunde Olusturuldu...","Hukuk Burosu Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,null,noSaveOption, null);
							
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
			 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
				e1.printStackTrace();
		}
		
 
	}
	
	
}
