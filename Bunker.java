package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/** Esta clase es la encargada de gestionar los reportes pdf*/
public class Bunker 
	{
		//public static final String ruta="C:\\Documents and Settings\\daruedar\\workspace\\sparta.pdf";
		public static final String ruta2="C:\\Documents and Settings\\daruedar\\Escritorio\\listPrecios.pdf";
		public static void main(String[] args)throws DocumentException, IOException 
			{
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(ruta2));
				document.open();
				PdfPTable myTable= new PdfPTable(3);
				//myTable.setLockedWidth(true);
				//float aux=288/5.23f;
				//myTable.setWidthPercentage(aux);
				myTable.addCell("Luness");
				myTable.addCell("Tuesdar");
				myTable.addCell("Wenddayjkghjgh");
				myTable.addCell("Wenddayjkghjgh");
				myTable.completeRow();
				//System.out.println("El contenido de ese flag es "+myTable.isLockedWidth());
				//document.add(new Paragraph("Hello World!"));
				document.add(myTable);
				document.close();
			}
		public void reportPrice(ArrayList<Precio>precios)throws DocumentException, IOException 
			{
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(ruta2));
				document.open();
				PdfPTable myTable= new PdfPTable(3);
				myTable.completeRow();
				for(int i=0;i<precios.size();i++)
					{
						myTable.addCell(precios.get(i).getNombre()+"  $ " +precios.get(i).getPrecio());
					}
				String titulo="Lista Oficial de Precios";
				Font fuente = new Font(FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE);
				Chunk tit = new Chunk(titulo, fuente);
				Phrase cad = new Phrase();
				cad.add(tit);
				document.add(cad);
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE); 
				document.add(myTable);
				document.close();
			
			}
	}
