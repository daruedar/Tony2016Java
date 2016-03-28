package model;

public class Precio 
	{
		private int id;
		private String nombre;
		private double precio;
		
		public Precio(int id,String name, double price)
			{
				this.nombre=name;
				this.precio=price;
				this.id=id;
			}

		public int getId() {
			return id;
		}

		public String getNombre() {
			return nombre;
		}

		public double getPrecio() {
			return precio;
		}
	}
