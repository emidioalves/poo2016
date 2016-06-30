package password;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;


public class TextFieldFrame  extends JFrame{
	private JTextField textField1;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JPasswordField passwordField;
	
	public TextFieldFrame ()
	{
		super("Acesso ao sistema");
		setLayout(new FlowLayout());
		
		label1 = new JLabel("USUÁRIO");
		add(label1);
		textField1 = new JTextField(15);
		add(textField1);
		
		label2 = new JLabel("SENHA");
		label2.setHorizontalTextPosition (SwingConstants.LEFT);
		label2.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(label2);
		passwordField = new JPasswordField(15);
		add( passwordField );
		
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		passwordField.addActionListener(handler);
		
	}
	//classe interna private para tratamento de evento
	private class TextFieldHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event){
		 String string = "";
		 if (event.getSource()==textField1){
			string = String.format("TextField 1:  %s",
				event.getActionCommand());}
			else if (event.getSource()== passwordField){
				string = String.format(" Password FIeld: %s",event.getActionCommand());}
		 
		 JOptionPane.showMessageDialog(null, string);

	}
	}
}
	
