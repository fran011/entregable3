package views;


import java.awt.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DeportistaView extends JFrame {
	private JPanel panel;
	private JTable table;
	private String[] titulos = {"Nombre", "Pais", "Disciplina"};
	private DefaultTableModel modelo;
	
	
	public DeportistaView(){
		super("Gestor de olimpiadas - DEPORTISTA");
		this.setVisible(true);
		this.setSize(700,700);
		this.getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();

		
		table = new JTable();
		table.setSize(200,200);
		
		modelo = new DefaultTableModel(titulos,0);
		
		table.setModel(modelo);
		table.setBounds(100,100,300, 300);
		this.add(table);
		
		
	}
	
	
}
