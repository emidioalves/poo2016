package label_swing;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {
	
	private JLabel label1;	//jlabel apenas com texto
	private JLabel label2;	//jlabel construido com texto e icone
	private JLabel label3;	//JLabel com texto e icone adicionado
	
	//construtor LabelFrame adiciona JLabels a JFrame
	public LabelFrame(){
		super("Testando JLabel");
		setLayout(new FlowLayout());		//configura o layout de frame
		
		//construtor JLAbel com argumento de string
		label1 = new JLabel("Rotulo com texto");
		label1.setToolTipText("Isto é o rotulo 1");
		add(label1);						//adiciona o rotulo ao JFrame
		
		//construtor JLAbel com string. Icone e argumentos de alinhamento
		Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
		//ImageIcon bug = new ImageIcon("bug1.gif");
		label2 = new JLabel("Rotulo com texto e icone", bug, SwingConstants.LEFT );
		label1.setToolTipText("Isto é um rotulo 2");
		add(label2);					//adiciona o rotulo ao JFrame
		
		//construtor JLabel sem argumentos
		label3 = new JLabel();
		label3.setText("Rotulo com texto e icone no rodapé");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("Este é o rotulo 3");
		add (label3);
	}			//fim do construtor LabelFrame
}				//fim da classe LabelFrame
