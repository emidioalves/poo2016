package minhaJanela;
import javax.swing.*;
public class MinhaJanela extends JFrame {
	public MinhaJanela(String titulo){
		super(titulo);
		JPanel pane = new JPanel();
		JButton botao = new JButton("Texto do botao");
		pane.add(botao);
		setContentPane(pane);
		pack();
		setVisible(true);
	
	}

}
