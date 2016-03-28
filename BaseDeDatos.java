package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public final class BaseDeDatos 
	{
		public static Connection conectarA(String ruta)
			{
				try {Class.forName("org.sqlite.JDBC");}//Aquí cargamos el driver de SQLITE.
				catch (ClassNotFoundException e) 
					{
						e.printStackTrace();//Esto se ejecuta si hay un error con el driver de la base de datos.
						JOptionPane.showMessageDialog(null, "Se produjo un error con el driver, revisar La  BaseDeDatos.class");
					}
				Connection conn = null;//Declaramos la conexión:
				try {conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);}//Aquí se obtiene la conexión:
				catch (SQLException e) 
					{
						e.printStackTrace();//Esto se ejecuta si hay un error en la base de datos:
						JOptionPane.showMessageDialog(null, "Se produjo un error al intentar conectar a la Base de datos, revise la clase BaseDeDatosen el package model,");
					}
				return conn;//Devolvemos la conexión:
			}//Fin del metodo conectarA
	}

