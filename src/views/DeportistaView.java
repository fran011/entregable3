package views;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Clases.Deportista;
import DAOImplements.DAODeportistaImpl;

public class DeportistaView extends JFrame {
	 private JPanel topPanel, southPanel;
	  private JTable table;
	  private JScrollPane scrollPane;
	  private String[] columns;
	  private Object[][] data;
	  private JButton eliminarBtn = new JButton("Eliminar");
	  private JButton editarBtn = new JButton("Editar");
	  private JButton eCSV, nuevo, volver;
	  
	  public DeportistaView(){
		  
		//config 
		setLayout(new BorderLayout());
	    setTitle("Gestor de Olimpiadas - DEPORTISTA");
	    this.setLocation(200,350);
	    setSize(870,300);
	    setVisible(true);
	    
	    
	    //panel tabla
	    topPanel = new JPanel();
	    southPanel = new JPanel();
	    topPanel.setLayout(new BorderLayout());
	    getContentPane().add(topPanel, BorderLayout.CENTER);
	    getContentPane().add(southPanel, BorderLayout.NORTH);
	   
	    
	    
	    //table config
	    columns = new String[] {"Nombre", "Apellido", "Pais", "Disciplina", "Editar", "Eliminar"};
	    data = new Object[][]{ {"q", "q", "q", "q"}
	    };
	    
	    
	    
	    
	    
	    DefaultTableModel model = new modeloReservas(data, columns);
	    table = new JTable();
	    table.getTableHeader().setReorderingAllowed(false);
	    table.setModel(model);
	    
	    table.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
	    table.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JCheckBox()));
	    table.getColumn("Editar").setCellRenderer(new ButtonRenderer());
	    table.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox()));
	   
  
	    scrollPane = new JScrollPane(table);
	    topPanel.add(scrollPane,BorderLayout.CENTER);  
	    
	    DAODeportistaImpl deportistas = new DAODeportistaImpl();
	    ArrayList<Deportista> toList = new ArrayList<>();
	    
	    model.addRow(data);
	    
	    try {
	    	toList = deportistas.find();
	    	for(int j=0; j<toList.size(); j++){
	    		data[j][0] = toList.get(j).getNombre();
	    		data[j][1] = toList.get(j).getApellido();
	    		data[j][2] = toList.get(j).getId_pais();
	    		data[j][3] = "remo";
	    	}
	    } catch (SQLException e) {
	    	// TODO Auto-generated catch block
	    	System.out.println(e);
	    	e.printStackTrace();
	    }
	    
	    
	    //Eventos
	    MouseAdapter evento = new Back();
	    MouseAdapter evento2 = new New();
	   //Panel botones 
	    volver = new JButton("Volver");
	    volver.addMouseListener(evento);
	    eCSV = new JButton("Exportar CSV");
	    nuevo = new JButton("Nuevo");
	    nuevo.addMouseListener(evento2);
	    southPanel.add(volver);
	    southPanel.add(eCSV);
	    southPanel.add(nuevo);
	    
	    
	    eliminarBtn.addActionListener(
	      new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	          int resp =JOptionPane.showConfirmDialog(null, "Seguro queres eliminar el deportista?");
	          switch (resp) {
	          case 0:
	        	  System.out.println("Pulsaste Si");
	        	  DAODeportistaImpl daoDep = new DAODeportistaImpl();
	        	 // daoDep.delete(resp); // como se cual voy a eliminar?
	        	  break;
	          case 1:
	        	  System.out.println("Pulsaste No");
	        	  break;
	         }	
	        }
	      }
	    );
	    
	  }
	  class ButtonRenderer extends JButton implements TableCellRenderer{
		  private String buttonString;
		  
	    public ButtonRenderer() {
	      setOpaque(true);
	    }
	    
	    
	    
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	      setText((value == null) ? "Eliminar" : value.toString());
	      return this;
	    }	    
	  }
	  class ButtonEditor extends DefaultCellEditor{
	    private String label;
	    
	    public ButtonEditor(JCheckBox checkBox){
	      super(checkBox);
	    }
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	      label = (value == null) ? "Eliminar" : value.toString();
	      eliminarBtn.setText(label);
	      return eliminarBtn;
	    }
	    public Object getCellEditorValue(){
	      return new String(label);
	    }
	  }
	  
	  
	  public class Back extends MouseAdapter{
			public void mouseClicked(MouseEvent arg) {
				setVisible(false);
			}
		}
		
	  public class New extends MouseAdapter{
		  public void mouseClicked(MouseEvent arg) {
				new NewDeportistaView();
			}
	  }
	  
	  public class modeloReservas extends DefaultTableModel{
		  public modeloReservas(final Object[][] datos, final String [] titulos) {
			  super(datos, titulos);
		  }
		  
		  public Class getColumn(final int column) {
			  return this.getValueAt(0, column).getClass();
		  }
	  }
	  
}


