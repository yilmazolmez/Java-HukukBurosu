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

public class hukukBurobilgirapor_cagir {
	
	static Connection myconn1;
	static Statement mystat1;
	
	public void rapor(String sayi) {
		
		ResultSet rs1 = null;
		
		try 
		{
	 
			myconn1=DriverManager.getConnection (hukukBaglanti.sunucuparametresi,"root","");
			String listele="Select * From burobilgi where BuroID='"+sayi+"'";
			mystat1=myconn1.createStatement();
			rs1=mystat1.executeQuery(listele);
				if(rs1.next())
				{	
					String path;
					path=System.getProperty("user.home") + "/Desktop"; //DESKTOP YOLUNU BULMA
					Document document = new Document();
					PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path+"\\burobilgi.pdf"));
					document.open();
					//ekrana yazýlar basýlýyor
					document.add(new Paragraph("SECILEN BURO BILGILERI :"));
					
				
				
				
				
			         //Liste yöntemiyle veri ekleme
			         List list = new List(List.UNORDERED);
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Buro BuroID="+rs1.getString("BuroID")));
			            list.add(new ListItem("Buro BuroUnvani="+rs1.getString("BuroUnvani")));
			            list.add(new ListItem("Buro BuroSehir="+rs1.getString("BuroSehir")));
			            list.add(new ListItem("Buro BuroTelefon="+rs1.getString("BuroTelefon")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Buro BuroVergiDairesi="+rs1.getString("BuroVergiDairesi")));
			            list.add(new ListItem("Buro BuroVergiNo="+rs1.getString("BuroVergiNo")));
			            list.add(new ListItem("Buro BuroAdresi="+rs1.getString("BuroAdresi")));
			            list.add(new ListItem("Buro BuroEPosta="+rs1.getString("BuroEPosta")));
			            list.add(new ListItem("Buro BuroCepTel="+rs1.getString("BuroCepTel")));
			            list.add(new ListItem("Buro BuroOrtak1="+rs1.getString("BuroOrtak1")));
			            list.add(new ListItem("Buro BuroOrtak2="+rs1.getString("BuroOrtak2")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Bu Rapor :"+ hukukBaglanti.versionadi+" Uygulamasi ile talebiniz uzere olusturulmustur..."));
			           document.add(list);
			         
					//Dökümaný kapatýyoruz
					document.close();
			        pdfWriter.close();
				
			        
			        
			        //Eklenen pdf'i direk olarak açma
			       // String FILE = "C:\\Users\\yýlmaz\\eclipse-workspace\\Deneme\\avukatbilgi.pdf";
			        String FILE = path+"\\burobilgi.pdf";
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
