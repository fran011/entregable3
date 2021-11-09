package views;

import java.awt.*;

import javax.swing.*;import javax.swing.border.Border;

public class NewPaisView  extends JFrame{

	private JPanel centerPanel;
	private JPanel southPanel;
	private JTextField text;
	private JLabel label;
	private JButton button;
	
	public NewPaisView() {
		this.setVisible(true);
		this.setLocation(1200,300);
		this.setSize(500,500);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(null);

		text = new JTextField();
		text.setBounds(160, 200, 200, 20);
		label = new JLabel("NOMBRE");
		label.setBounds(100, 165, 80,90);
		button = new JButton("Guardar");
		button.setBounds(200, 240, 90, 40);
		centerPanel.add(label);
		centerPanel.add(text);
		centerPanel.add(button);
		this.add(centerPanel, BorderLayout.CENTER);		
		
	}
	
	
}
