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

public class hukukMuvekkilhukukihareketrapor_cagir {
	
	static Connection myconn1;
	static Statement mystat1;
	
	public void rapor(String sayi) {
		
		ResultSet rs1 = null;
		
		try 
		{
	 
			myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
			String listele="Select A.MuvekkilTC,A.HareketNo,A.IcraTakipTarihi,A.HareketTarihi,A.IcraDairesi,A.IcraMemuru,A.HareketAciklamasi,A.HareketAvukati,A.HareketNotlari,A.HareketTipi,A.IcraTalepTutari,A.IcraTahsiledilentutar,A.hatirlat,A.hakedis,A.Aciklama,B.MuvekkilAdi,B.MuvekkilSoyadi From muvekkilhukukihareket A,muvekkilbilgi B where A.MuvekkilTC=B.MuvekkilTC and A.HareketNo='"+sayi+"'"; 
			//String listele="Select * From muvekkilcarihareket where Muvekkilcarihareketno='"+sayi+"'";
			mystat1=myconn1.createStatement();
			rs1=mystat1.executeQuery(listele);
				if(rs1.next())
				{	
					String path;
					path=System.getProperty("user.home") + "/Desktop"; //DESKTOP YOLUNU BULMA
					Document document = new Document();
					PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path+"\\muvekkilhukukihareket.pdf"));
					document.open();
					//ekrana yazýlar basýlýyor
					document.add(new Paragraph("SECILEN HUKUKI HAREKET DETAY BILGILERI :"));
					
				
				
				
				
			         //Liste yöntemiyle veri ekleme
			         List list = new List(List.UNORDERED);
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Hareket No"+rs1.getString("HareketNo")));
			            list.add(new ListItem("Muvekkil TC="+rs1.getString("MuvekkilTC")));
			            list.add(new ListItem("Muvekkil Adi="+rs1.getString("MuvekkilAdi")));
			            list.add(new ListItem("Muvekkil Soyadi="+rs1.getString("MuvekkilSoyadi")));
			            list.add(new ListItem("Hareket Tarihi="+rs1.getString("HareketTarihi")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Icra Takip Tarihi="+rs1.getString("IcraTakipTarihi")));
			            list.add(new ListItem("Icra Dairesi="+rs1.getString("IcraDairesi")));
			            list.add(new ListItem("Hareket Avukati="+rs1.getString("HareketAvukati")));
			            list.add(new ListItem("Hareket Notlari="+rs1.getString("HareketNotlari")));
			            list.add(new ListItem("Hareket Aciklamasi="+rs1.getString("HareketAciklamasi")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Hatirlatma Tarihi="+rs1.getString("hatirlat")));
			            list.add(new ListItem("Hareket Tipi="+rs1.getString("HareketTipi")));
			            list.add(new ListItem("Icra Talep Tutari="+rs1.getString("IcraTalepTutari")));
			            list.add(new ListItem("Icra Tahsil Edilen Tutar="+rs1.getString("IcraTahsiledilentutar")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
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
			        String FILE = path+"\\muvekkilhukukihareket.pdf";
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
