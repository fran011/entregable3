package views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestorOlimpiadasView extends JFrame {
	private JButton deportista, pais, disciplina, x1, x2, x3, x4 ,x5, x6, log;
	private JPanel mainPanel;
	
	public GestorOlimpiadasView() {
		
		super("Gestor de olimpiadas");
		this.setSize(600,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(600, 200);
		
		
		//create buttons
		JButton deportista = new JButton("Deportista");JButton pais = new JButton("Pais");
		JButton disciplina = new JButton("Disciplina"); JButton x1 = new JButton("Sin definir");
		JButton x2 = new JButton("Sin definir");JButton x3 = new JButton("Sin definir");
		JButton x4 = new JButton("Sin definir");JButton  x5 = new JButton("Sin definir");
		JButton x6 = new JButton("Sin definir");
		JButton log = new JButton("conf");
		
		//button config
		MouseAdapter list = new Evento();
		deportista.setBounds(70, 40 , 110, 60);
		deportista.addMouseListener(list);
		disciplina.setBounds(230, 40, 110, 60);
		disciplina.addMouseListener(list);
		pais.setBounds(390, 40, 110, 60);
		pais.addMouseListener(list);
		log.setBounds(510, 10, 50, 30);
		log.addMouseListener(list);
		x1.setBounds(70, 150, 110 , 60);
		x2.setBounds(230, 150, 110, 60 );
		x3.setBounds(390, 150, 110, 60 );
		
		x4.setBounds(70, 260, 110, 60 );
		x5.setBounds(230, 260, 110, 60 );
		x6.setBounds(390, 260, 110, 60 );
		
		mainPanel = new JPanel(); 
		mainPanel.setLayout(null);
		//mainPanel.setLayout(new GridLayout(3,3));
	
		// add buttons
		mainPanel.add(deportista); mainPanel.add(disciplina); mainPanel.add(pais);
		mainPanel.add(x1); mainPanel.add(x2); mainPanel.add(x3);
		mainPanel.add(x4); mainPanel.add(x4); mainPanel.add(x5);
		mainPanel.add(x6);
		mainPanel.add(log);
		
		
		
		this.add(mainPanel);
		mainPanel.setVisible(true);
		
		this.setVisible(true);

		
	}
	
	public class Evento extends MouseAdapter{
		public void mouseClicked(MouseEvent arg) {
			JButton button = (JButton) arg.getSource();
			if(button.getText().equals("Deportista")) {
				//Invoco el panel de Deportista
				System.out.println("Entre");
			} else if(button.getText().equals("Disciplina")) {
				//Invoco el panel de Disciplina
				System.out.println("Entre 2");
			} else if(button.getText().equals("Pais")) {
				//Invoco el panel de Pais
				System.out.println("Entre 3");
			} else if(button.getText().equals("conf")) {
				new ConfigView();
			}
			
		}
	}
	
	public static void main(String arg[]){
		new GestorOlimpiadasView();
	}
}

