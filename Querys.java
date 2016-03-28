package model;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import controler.Logica;
public class Querys 
	{	
		private String nameDataBase;
		private BaseDeDatos base= new BaseDeDatos();
		private java.sql.Connection c;
		private java.sql.Statement stmt;
		private java.sql.ResultSet rs;
		private ArrayList<Precio>precios;
		
		public Querys()
			{
				nameDataBase="TonyK6.db";//Nombre de la base de datos
				base= new BaseDeDatos();
				precios=new ArrayList<Precio>();
				c=null;
				stmt=null;
				rs=null;
			}
		public void crearTablaPrecios()
			{
				try{
						c=base.conectarA(nameDataBase);
						stmt = c.createStatement();
						String sql = "CREATE TABLE Precios " +
							"(Id INTEGER PRIMARY KEY  ," +
							" Nombre           TEXT    NOT NULL, " + 
							" Precio         REAL)"; 
						stmt.executeUpdate(sql);
						stmt.close();
						c.close();	
					}
				catch(SQLException e){e.printStackTrace();JOptionPane.showMessageDialog(null, "Error en la creacion de la tabla Precios");}
			}
		public  void addInsumo(String nombre, double prec)
		{
			boolean flag=true;
			try{
					c=base.conectarA(nameDataBase);
					stmt = c.createStatement();	
					rs = stmt.executeQuery( "SELECT Nombre FROM Precios;" );
					while(rs.next())
					{	
						String  nombrep = rs.getString("Nombre");
						if(nombrep.equals(nombre))
							{
								JOptionPane.showMessageDialog(null, "Este producto ya fue ingresado");
								flag=false;break;
							}
					}//Fin del While
					if(flag)
						{
							String sql22 = "INSERT INTO Precios " +
								"VALUES (null,'" +nombre+  "',"  +prec+ ");"; 
								stmt.executeUpdate(sql22);
								JOptionPane.showMessageDialog(null, "Producto Ingresado exitosamente");
						
						}
					stmt.close();
					c.close();
				}//Fin del Try
			catch(SQLException g){
					g.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al ingresar producto a la lista de precios");
				}
		}//Fin del metodo addInsumo
		public  void showTablaPrecios()
		{
			try{	c=base.conectarA(nameDataBase);
					stmt = c.createStatement();
					rs = stmt.executeQuery( "SELECT * FROM Precios;" );
					while(rs.next())
						{
								String  nombre = rs.getString("Nombre");
								int id= rs.getInt("Id");
								double precio= rs.getFloat("Precio");
								System.out.print(id+"\t"+nombre+"\t"+precio+"\n");
						}//Fin del While
					stmt.close();
					c.close();
			
			}//Fin del Try
			catch(SQLException g){g.printStackTrace();}//Fin del catch
		
		}//Fin del metodo showTablaPrecios
		public static void main(String[] args) 
			{
				Querys app=new Querys();
				//app.crearTablaPrecios();
				//app.addInsumo("Avena", 153.0);
				app.showTablaPrecios();

			}
		public ArrayList<Precio> getPrecios() 
			{
				try{	c=base.conectarA(nameDataBase);
					stmt = c.createStatement();
					rs = stmt.executeQuery( "SELECT * FROM Precios;" );
					while(rs.next())
						{
							String  nombre = rs.getString("Nombre");
							int id= rs.getInt("Id");
							double precio= rs.getFloat("Precio");
						precios.add(new Precio(id,nombre,precio));
						}//Fin del While
					stmt.close();
					c.close();
	
				}//Fin del Try
				catch(SQLException g){g.printStackTrace();}//Fin del catch
			
				return this.precios;
			}

}
