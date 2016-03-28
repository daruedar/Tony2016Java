package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
		/**
		* Conecta a una base de datos en la ruta pasada como argumento.
		* Si el archivo se�alado en la ruta no existe, se crea.
		* @param ruta - La ruta de la DB a conectar.
		* @return La conexi�n a la ruta.
	*/
public final class BaseDeDatos 
	{/**Este metodo se encarga de cargar el driver, obtener la conexion y retornar  el recurso conexion*/
		public static Connection conectarA(String ruta)
			{
				try {Class.forName("org.sqlite.JDBC");}//Aqu� cargamos el driver de SQLITE.
				catch (ClassNotFoundException e) 
					{
						e.printStackTrace();//Esto se ejecuta si hay un error con el driver de la base de datos.
						JOptionPane.showMessageDialog(null, "Se produjo un error con el driver, revisar La  BaseDeDatos.class");
					}
				Connection conn = null;//Declaramos la conexi�n:
				try {conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);}//Aqu� se obtiene la conexi�n:
				catch (SQLException e) 
					{
						e.printStackTrace();//Esto se ejecuta si hay un error en la base de datos:
						JOptionPane.showMessageDialog(null, "Se produjo un error al intentar conectar a la Base de datos, revise la clase BaseDeDatosen el package model,");
					}
				return conn;//Devolvemos la conexi�n:
			}//Fin del metodo conectarA
		public static void main(String[] args) 
			{
				//Pasamos una ruta a la cual conectar:
				Connection conn = BaseDeDatos.conectarA("Tony.db");
				/*
				* Aqu� se supone que hacemos lo que necesitamos en la base de datos
				* ya sea una consulta, creaci�n de una tabla, actualizaci�n de la
				* misma, etc.
				*/
				try {
						//Y para terminar cerramos la conexi�n
						conn.close();
					}
				catch (SQLException e) {
						//Esto se ejecuta si hay alg�n problema al realizar la conexi�n.
						e.printStackTrace();
					}
			}
	}

