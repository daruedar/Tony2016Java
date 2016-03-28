package controler;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

import model.Precio;
import model.Querys;
import model.Bunker;

public class Logica 
	{
		private static ArrayList<Precio> precios;
		private static Logica instance;
		private Querys consultas;
		private Bunker reportes;
		
 		public static Logica getInstance() {
			if(instance==null){instance= new Logica();}
			return instance;
		}
		public ArrayList<Precio> getPrecios() {precios=null;this.precios=consultas.getPrecios();return precios;}

		public Logica() {
			precios= new ArrayList<Precio>();
			consultas= new Querys();
			reportes= new Bunker();
		}
		
	
		public static void main(String[] args) throws DocumentException, IOException 
		{
			Logica app= new Logica();
			app.getPrecios();
			app.reportes.reportPrice(precios);
			
			
			

		}

	}
