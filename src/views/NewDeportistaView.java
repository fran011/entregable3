package views;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class NewDeportistaView extends JFrame {

	private JLabel lblUser, lblApellido, lblEmail, lblTel, lblPais, lblDisciplina;
	private JPanel centerPanel, southPanel;
	private JTextField textUser, textApellido, textEmail, textTel, textPais, textDisciplina;
	private JButton guardar;
	private String[] errores;
	
	public NewDeportistaView() {
		super("Gestor de Olimpiadas - NUEVO DEPORTISTA");
		this.setVisible(true);
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		MouseAdapter event = new add();
		
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		
		lblUser = new JLabel("Nombre");
		textUser = new JTextField();
		lblUser.setBounds(150, 40, 50,22);
		textUser.setBounds(210, 40, 150, 22);
		
		lblApellido = new JLabel("Apellido");
		textApellido = new JTextField();
		lblApellido.setBounds(150, 80, 50,22);
		textApellido.setBounds(210, 80, 150, 22);
		
		lblEmail = new JLabel("Email");
		textEmail = new JTextField();
		lblEmail.setBounds(150, 120, 50,22);
		textEmail.setBounds(210, 120, 150, 22);
		
		lblTel = new JLabel("Telefono");
		textTel = new JTextField();
		lblTel.setBounds(150, 160, 50,22);
		textTel.setBounds(210, 160, 150, 22);
		
		lblPais = new JLabel("Pais");
		textPais = new JTextField();
		lblPais.setBounds(150, 200, 50,22);
		textPais.setBounds(210, 200, 150, 22);
		
		lblDisciplina = new JLabel("Disciplina");
		textDisciplina = new JTextField();
		lblDisciplina.setBounds(150, 240, 70,22);
		textDisciplina.setBounds(210, 240, 150, 22);
		
		
		centerPanel.add(lblUser);
		centerPanel.add(textUser);
		
		centerPanel.add(lblApellido);
		centerPanel.add(textApellido);
		
		centerPanel.add(lblEmail);
		centerPanel.add(textEmail);
		
		centerPanel.add(lblTel);
		centerPanel.add(textTel);
		
		centerPanel.add(lblPais);
		centerPanel.add(textPais);
		
		centerPanel.add(lblDisciplina);
		centerPanel.add(textDisciplina);
		
		guardar = new JButton("Guardar");
		guardar.setBounds(240, 290, 80, 20);
		guardar.addMouseListener(event);
		centerPanel.add(guardar);
		this.add(centerPanel);
		
		errores = new String[4];
		
		
	}
	 public class add extends MouseAdapter{
		 private String nombre,apellido,pais,disciplina;
			public void mouseClicked(MouseEvent arg) {
				if(!textUser.getText().matches( "^(?!.* $)[A-Z][a-z ]+$" )){
					errores[0] = "Inserte nombre correcto";
				}
				if(!textApellido.getText().matches( "^(?!.* $)[A-Z][a-z ]+$" )) {
					errores[1] = "Inserte apellido correcto";
				}
				if(!textTel.getText().matches("^[0-9]*$")) {
					errores[3]= "Inserte un numero de telefono valido";
				}
				
				if(!(errores.length == 0)) {
					
				}
				
			}
		}
	
	
	
}
