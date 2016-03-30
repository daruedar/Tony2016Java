package vista;
import java.awt.BorderLayout;import java.awt.Color;import java.awt.GridLayout;import java.awt.LayoutManager;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;
import java.util.ArrayList;import javax.swing.DefaultListModel;import javax.swing.JButton;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JPanel;
import javax.swing.JScrollBar;import javax.swing.JScrollPane;import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Plato;import modelo.Query2;import javax.swing.JList;import javax.swing.JOptionPane;
import modelo.Ingrediente;
/**Esta clase muestra todos los componentes de la aplicacion para el Comedor*/
public class FisionNuclear extends JPanel implements ActionListener,ListSelectionListener
	{
		private JButton[]botones;
		private DefaultListModel modeloPlatos,modeloIngredientes,modeloInsumos;
		private ArrayList<Plato> platos;private ArrayList<Ingrediente> insumos;private ArrayList<Integer>idIngredientes;
		public Query2 consulta;
		private JList listaPlatos, listaInsumos;
		private int indexPlatoSelected,indexInsumoSelected;
		
		public FisionNuclear()
			{
				int noElementos01=5;
				int noElementos02=5;
				int noElementos04=5;	
				indexPlatoSelected=0;
				indexInsumoSelected=0;
				
				GridLayout   layoutPanel5= new GridLayout(7,1,2,2);
				BorderLayout layoutPanel4= new BorderLayout();
				BorderLayout layoutPanel1= new BorderLayout();
				BorderLayout layoutPanel2= new BorderLayout();
				BorderLayout layoutPanel3= new BorderLayout();
				
				consulta     =  new Query2();
				modeloPlatos =  new DefaultListModel();
				modeloInsumos=  new DefaultListModel();
				this.setModelos();
				
				JPanel panel01= new JPanel();
				panel01.setBackground(Color.BLUE);
				listaPlatos= new JList(modeloPlatos);
				listaPlatos.setSelectedIndex(0);
				listaPlatos.addListSelectionListener(this);
				String nomEtiqueta="Platos";
				JLabel etiqPlatos= new JLabel();
				etiqPlatos.setText(nomEtiqueta);
				listaPlatos.setVisibleRowCount( noElementos01);
				panel01.setLayout(layoutPanel1);
				panel01.add(etiqPlatos,BorderLayout.NORTH);
				panel01.add(new JScrollPane(listaPlatos),BorderLayout.CENTER);
		
				JPanel panel02= new JPanel();
				panel02.setBackground(Color.MAGENTA);
				modeloIngredientes= new DefaultListModel();
				JList listaPlatos2= new JList(modeloIngredientes);
				String nomIngredientes="Ingredientes";
				JLabel etiqIngredientes= new JLabel();
				etiqIngredientes.setText(nomIngredientes);
				listaPlatos2.setVisibleRowCount( noElementos02);
				panel02.setLayout(layoutPanel2);
				panel02.add(etiqIngredientes,BorderLayout.NORTH);
				panel02.add(new JScrollPane(listaPlatos2),BorderLayout.CENTER);
				
				JPanel panel03= new JPanel();
				JPanel p3superio= new JPanel();
				JPanel p3infe= new JPanel();
				p3superio.setLayout(new BorderLayout());
				p3infe.setLayout(new BorderLayout());
				panel03.setLayout(layoutPanel3);;
				JButton labcostoIngredientes= new JButton("Costo Ingredientes");
				JTextField costoIngredientes= new JTextField(8);
				p3superio.add(labcostoIngredientes,BorderLayout.NORTH);
				p3superio.add(costoIngredientes,BorderLayout.SOUTH);
				
				JButton labcondimentos = new JButton("Condimentos");
				JTextField condimentos= new JTextField(8);
				p3infe.add(labcondimentos,BorderLayout.NORTH);
				p3infe.add(condimentos,BorderLayout.SOUTH);
				
				panel03.add(p3superio,BorderLayout.NORTH);
				panel03.add(p3infe,BorderLayout.SOUTH);
				
				JPanel panel04= new JPanel();
				panel04.setBackground(Color.gray);
				listaInsumos= new JList(modeloInsumos);
				listaInsumos.addListSelectionListener(this);
				String nomInsumos="Insumos";
				JLabel etiqInsumos= new JLabel();
				etiqInsumos.setHorizontalTextPosition(JLabel.CENTER);
				etiqInsumos.setText("Insumos");
				listaInsumos.setVisibleRowCount( noElementos04);
				panel04.setLayout(layoutPanel4);
				panel04.add(etiqInsumos,BorderLayout.NORTH);
				panel04.add(new JScrollPane(listaInsumos),BorderLayout.CENTER);
				
				JPanel panel05= new JPanel();
				panel05.setLayout(layoutPanel5);
				botones= new JButton[7];
				for(int i=0;i<botones.length;i++){botones[i]= new JButton();botones[i].addActionListener(this);panel05.add(botones[i]);}
				botones[0].setText("AddPlato");botones[1].setText("AddIngrediente");botones[2].setText("AddInsumo");botones[3].setText("AddPrecio");botones[4].setText("EditPrecio");botones[5].setText("BorrarPrecio");botones[6].setText("printPrecio");

				JPanel panel06= new JPanel();
				DefaultListModel modeloPlatos6= new DefaultListModel();
				JList listaPlatos6= new JList(modeloPlatos6);
				panel06.add(listaPlatos6);
				modeloPlatos6.addElement("Sopa de Bagre");
				
				setLayout(new GridLayout(2,3,20,20));
				add(panel01);
				add(panel02);
				add(panel03);
				add(panel04);
				add(panel05);
				add(panel06);
			}//Fin del constructor
		private void setModelos() 
			{
				platos=consulta.getPlatos();
				for(int i=0;i<this.platos.size();i++){addPlato(platos.get(i).getNombre());}
				insumos=consulta.getInsumos();
				for(int i=0;i<insumos.size();i++)
					{
						String aux="";
						String aux2="";
						String conca="";
						aux2=this.insumos.get(i).getCantidad()+" gramos de ";
						aux=this.insumos.get(i).getNombre();
						conca=aux2+aux;
						addInsumo(conca);
					}
			}//Fin del metodo setModelos()
		private void addInsumo(String aux) {modeloInsumos.addElement(aux);}
		public  static void main(String[] args) 
			{
				JFrame ve= new JFrame("Costos de Operacion");FisionNuclear num01= new FisionNuclear();ve.add(num01);ve.setSize(750,500);
				ve.setVisible(true);ve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		public  void actionPerformed(ActionEvent e)
			{/*
				if(e.getSource()==boton1){String aux= JOptionPane.showInputDialog("Ingrese el nombre del Plato");addPlato(aux);}
				if(e.getSource()==boton2){addIngrediente();}if(e.getSource()==boton3){addInsumo();}
				if(e.getSource()==boton3){addInsumo();}*/
				if(e.getSource()==botones[0]){String aux= JOptionPane.showInputDialog("Ingrese el nombre del Plato");addPlato(aux);}
				if(e.getSource()==botones[1]){addIngrediente();}if(e.getSource()==botones[2]){addInsumo();}
				
			}
		private void addInsumo() {modeloInsumos.addElement("nombredel insumo");}
		private void addIngrediente() 
			{
				modeloIngredientes.addElement(listaInsumos.getSelectedValue());
				int idPlato=platos.get(this.indexPlatoSelected).getId();
				int idIngrediente=insumos.get(this.indexInsumoSelected).getId();
				this.consulta.addRelacionPlatoIngredientes(idPlato, idIngrediente);
			}
		private void addPlato(String p){String nombrePlato="8 gramos de uranio";modeloPlatos.addElement(p);}
		public void valueChanged(ListSelectionEvent e) 
			{	if(e.getSource()==listaPlatos){setIngredientes(platos.get(listaPlatos.getSelectedIndex()).getId());this.indexPlatoSelected=listaPlatos.getSelectedIndex();}
				else{setIngredientes(platos.get(listaPlatos.getFirstVisibleIndex()).getId());}
				if(e.getSource()==listaInsumos){this.indexInsumoSelected=listaInsumos.getSelectedIndex();}
			}
		private void setIngredientes(int idPlatoSelected) 
			{
				modeloIngredientes.clear();
				idIngredientes=consulta.getIngredientes(idPlatoSelected);
				for(int x=0;x<idIngredientes.size();x++)
					{
						for(int k=0;k<insumos.size();k++)
							{ 
								if((idIngredientes.get(x)==insumos.get(k).getId()))
									{	String cad="";cad=insumos.get(k).getCantidad()+" gramos de "+insumos.get(k).getNombre();
										modeloIngredientes.addElement(cad);	
									}			
							}
					}
			}//Fin del metodo setIngrediente
	}
