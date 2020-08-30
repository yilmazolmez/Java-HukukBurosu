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

public class hukukMuvekkilbilgirapor_cagir {
	
	static Connection myconn1;
	static Statement mystat1;
	
	public void rapor(String sayi) {
		
		ResultSet rs1 = null;
		
		try 
		{
	 
			myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
			String listele="Select * From muvekkilbilgi where MuvekkilTC='"+sayi+"'";
			mystat1=myconn1.createStatement();
			rs1=mystat1.executeQuery(listele);
				if(rs1.next())
				{	
					String path;
					path=System.getProperty("user.home") + "/Desktop"; //DESKTOP YOLUNU BULMA
					Document document = new Document();
					PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path+"\\muvekkilbilgi.pdf"));
					document.open();
					//ekrana yazýlar basýlýyor
					document.add(new Paragraph("SECILEN MUVEKKIL DETAY BILGILERI :"));
					
				
				
				
				
			         //Liste yöntemiyle veri ekleme
			         List list = new List(List.UNORDERED);
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Muvekkil TC="+rs1.getString("MuvekkilTC")));
			            list.add(new ListItem("Muvekkil Adi="+rs1.getString("MuvekkilAdi")));
			            list.add(new ListItem("Muvekkil Soyadi="+rs1.getString("MuvekkilSoyadi")));
			            list.add(new ListItem("Muvekkil Avukat="+rs1.getString("MuvekkilAvukat")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Muvekkil Adres="+rs1.getString("MuvekkilAdres")));
			            list.add(new ListItem("Muvekkil Cinsiyet="+rs1.getString("MuvekkilCinsiyet")));
			            list.add(new ListItem("Muvekkil DogumTarihi="+rs1.getString("MuvekkilDogumTarihi")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Muvekkil DogumYeri="+rs1.getString("MuvekkilDogumYeri")));
			            list.add(new ListItem("Muvekkil Telefon="+rs1.getString("MuvekkilTelefon")));
			            list.add(new ListItem("Muvekkil Vergi Dairesi="+rs1.getString("MuvekkilVergiDairesi")));
			            list.add(new ListItem("Muvekkil Vergi No="+rs1.getString("MuvekkilVergiNo")));
			            list.add(new ListItem("Sirket SSK Is Yeri No="+rs1.getString("SirketSSKIsYeriNo")));
			            list.add(new ListItem("Sirket Unvani="+rs1.getString("SirketUnvani")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Bu Rapor :"+ hukukBaglanti.versionadi+" Uygulamasi ile talebiniz uzere olusturulmustur..."));
			           document.add(list);
			         
					//Dökümaný kapatýyoruz
					document.close();
			        pdfWriter.close();
				
			        
			        
			        //Eklenen pdf'i direk olarak açma
			       // String FILE = "C:\\Users\\yýlmaz\\eclipse-workspace\\Deneme\\avukatbilgi.pdf";
			        String FILE = path+"\\muvekkilbilgi.pdf";
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
			 JOptionPane.showMessageDialog(null,"1 satýr seçiniz veya");
				e1.printStackTrace();
		}
		
 
	}
	
	
}
