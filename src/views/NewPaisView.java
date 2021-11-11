package views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.*;import javax.swing.border.Border;

import Clases.Pais;
import DAOImplements.DAODBConnectionImpl;
import DAOImplements.DAOPaisImpl;

public class NewPaisView  extends JFrame{

	private JPanel centerPanel;
	private JPanel southPanel;
	private JTextField text, error;
	private JLabel label;
	private JButton button;
	
	public NewPaisView() {
		super("Gestor de Olimpiadas - NUEVO PAIS");
		this.setVisible(true);
		this.setLocation(1200,300);
		this.setSize(500,500);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(null);

		error = new JTextField("Nombre incorrecto, Minimo una mayuscula");
		error.setVisible(false);
		error.setBounds(150, 105, 200, 20);
		error.setEditable(false);
		
		MouseAdapter event = new Validate();
		
		text = new JTextField();
		text.setBounds(160, 200, 200, 20);
		label = new JLabel("NOMBRE");
		label.setBounds(100, 165, 80,90);
		button = new JButton("Guardar");
		button.setBounds(200, 240, 90, 40);
		button.addMouseListener(event);
		centerPanel.add(label);
		centerPanel.add(text);
		centerPanel.add(button);
		centerPanel.add(error);
		this.add(centerPanel, BorderLayout.CENTER);		
		
	}
	
	 public class Validate extends MouseAdapter{
			public void mouseClicked(MouseEvent arg) {
				if(!text.getText().matches( "^(?!.* $)[A-Z][a-z ]+$" ) || (text.getText().equals("")) ){
					error.setVisible(true);
				} else {
					error.setVisible(false);
					Pais pais = new Pais(text.getText());
					DAOPaisImpl agg = new DAOPaisImpl();
					try {
						agg.create(pais);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	 }
	
	
}
