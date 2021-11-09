package views;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class DeportistaView extends JFrame {
	 private JPanel topPanel, southPanel;
	  private JTable table;
	  private JScrollPane scrollPane;
	  private String[] columns = new String[6];
	  private String[][] data = new String[4][2];
	  JButton button = new JButton();
	  private JButton eCSV, nuevo, volver;
	  
	  public DeportistaView(){
		  
		//config 
		setLayout(new BorderLayout());
	    setTitle("Deportista");
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
	    data = new String[][]{
	      {"1","Thomas", "wqsad", "arco"},
	      {"2","Jean", "ARg", "arco"},
	      {"1","Thomas", "wqsad", "arco"},     
	    };
	    DefaultTableModel model = new DefaultTableModel(data,columns);
	    table = new JTable();
	    table.setModel(model);
	    table.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
	    table.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JCheckBox()));
	    table.getColumn("Editar").setCellRenderer(new ButtonRenderer());
	   
  
	    scrollPane = new JScrollPane(table);
	    topPanel.add(scrollPane,BorderLayout.CENTER);  
	    
	    
	    
	    //Eventos
	    MouseAdapter evento = new Back();
	    
	   //Panel botones 
	    volver = new JButton("Volver");
	    volver.addMouseListener(evento);
	    eCSV = new JButton("Exportar CSV");
	    nuevo = new JButton("Nuevo");
	    southPanel.add(volver);
	    southPanel.add(eCSV);
	    southPanel.add(nuevo);
	    
	    
	    button.addActionListener(
	      new ActionListener()
	      {
	        public void actionPerformed(ActionEvent event)
	        {
	          JOptionPane.showMessageDialog(null,"Do you want to modify this line?");
	        }
	      }
	    );
	  }
	  class ButtonRenderer extends JButton implements TableCellRenderer 
	  {
	    public ButtonRenderer() {
	      setOpaque(true);
	    }
	    public Component getTableCellRendererComponent(JTable table, Object value,
	    boolean isSelected, boolean hasFocus, int row, int column) {
	      setText((value == null) ? "Eliminar" : value.toString());
	      return this;
	    }
	  }
	  class ButtonEditor extends DefaultCellEditor 
	  {
	    private String label;
	    
	    public ButtonEditor(JCheckBox checkBox)
	    {
	      super(checkBox);
	    }
	    public Component getTableCellEditorComponent(JTable table, Object value,
	    boolean isSelected, int row, int column) 
	    {
	      label = (value == null) ? "Eliminar" : value.toString();
	      button.setText(label);
	      return button;
	    }
	    public Object getCellEditorValue() 
	    {
	      return new String(label);
	    }
	  }
	  
	  
	  public class Back extends MouseAdapter{
			public void mouseClicked(MouseEvent arg) {
				setVisible(false);
			}
		}
		
	  
	  
	  
}


