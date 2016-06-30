package teste_windowbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Window_Builder extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_Builder frame = new Window_Builder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window_Builder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCliqueAqui = new JButton("CLIQUE AQUI");
		btnCliqueAqui.setBounds(213, 48, 126, 29);
		contentPane.add(btnCliqueAqui);
		
		JButton btnCliqueAqui_1 = new JButton("CLIQUE AQUI");
		btnCliqueAqui_1.setBounds(213, 10, 126, 29);
		contentPane.add(btnCliqueAqui_1);
		
		JLabel lblAtendimento = new JLabel("ATENDIMENTO");
		lblAtendimento.setBounds(47, 48, 133, 29);
		contentPane.add(lblAtendimento);
		
		JLabel lblCadastrarProduto = new JLabel("CADASTRAR PRODUTO");
		lblCadastrarProduto.setBounds(27, 15, 153, 16);
		contentPane.add(lblCadastrarProduto);
	}
}
