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

public class hukukMuvekkilozelhareketrapor_cagir {
	
	static Connection myconn1;
	static Statement mystat1;
	
	public void rapor(String sayi) {
		
		ResultSet rs1 = null;
		
		try 
		{
	 
			myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
			String listele="Select A.MuvekkilTC,A.OzelHareketID,A.Ozelharekettarihi,A.KonusanAvukat,A.KonusulanKisi,A.hatirlat,A.hakedis,A.Aciklama,B.MuvekkilAdi,B.MuvekkilSoyadi From muvekkilozelhareket A,muvekkilbilgi B where A.MuvekkilTC=B.MuvekkilTC and A.OzelHareketID='"+sayi+"'"; 
			//String listele="Select * From muvekkilcarihareket where Muvekkilcarihareketno='"+sayi+"'";
			mystat1=myconn1.createStatement();
			rs1=mystat1.executeQuery(listele);
				if(rs1.next())
				{	
					String path;
					path=System.getProperty("user.home") + "/Desktop"; //DESKTOP YOLUNU BULMA
					Document document = new Document();
					PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path+"\\muvekkilozelhareket.pdf"));
					document.open();
					//ekrana yazýlar basýlýyor
					document.add(new Paragraph("SECILEN OZEL HAREKET DETAY BILGILERI :"));
					
				
				
				
				
			         //Liste yöntemiyle veri ekleme
			         List list = new List(List.UNORDERED);
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Ozel Hareket No="+rs1.getString("OzelHareketID")));
			            list.add(new ListItem("Muvekkil TC="+rs1.getString("MuvekkilTC")));
			            list.add(new ListItem("Muvekkil Adi="+rs1.getString("MuvekkilAdi")));
			            list.add(new ListItem("Muvekkil Soyadi="+rs1.getString("MuvekkilSoyadi")));
			            list.add(new ListItem("Hareket Tarihi="+rs1.getString("Ozelharekettarihi")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Konusulan Kisi="+rs1.getString("KonusulanKisi")));
			            list.add(new ListItem("Hareket Avukati="+rs1.getString("KonusanAvukat")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Hatirlatma Tarihi="+rs1.getString("hatirlat")));
			            list.add(new ListItem("Aciklama="+rs1.getString("Aciklama")));
			            list.add(new ListItem("Islem Hakedisi="+rs1.getString("hakedis")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Bu Rapor :"+ hukukBaglanti.versionadi+" Uygulamasi ile talebiniz uzere olusturulmustur..."));
			           document.add(list);
			         
					//Dökümaný kapatýyoruz
					document.close();
			        pdfWriter.close();
				
			        
			        
			        //Eklenen pdf'i direk olarak açma
			       // String FILE = "C:\\Users\\yýlmaz\\eclipse-workspace\\Deneme\\avukatbilgi.pdf";
			        String FILE = path+"\\muvekkilozelhareket.pdf";
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
