package user_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_pizzaria_teste extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_pizzaria_teste frame = new UI_pizzaria_teste();
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
	public UI_pizzaria_teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarProduto = new JButton("Clique Aqui");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarProduto.setBounds(184, 26, 133, 29);
		contentPane.add(btnCadastrarProduto);
		
		JButton btnNewButton = new JButton("Clique Aqui");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(184, 67, 133, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblCadastroDeProduto = new JLabel("Cadastro de Produto");
		lblCadastroDeProduto.setBounds(19, 31, 143, 16);
		contentPane.add(lblCadastroDeProduto);
		
		JLabel lblAbrirAtendimentoDe = new JLabel("Iniciar Atendimento");
		lblAbrirAtendimentoDe.setBounds(19, 72, 143, 16);
		contentPane.add(lblAbrirAtendimentoDe);
		
		JLabel lblConsultarMesas = new JLabel("Consultar Mesas");
		lblConsultarMesas.setBounds(19, 109, 133, 16);
		contentPane.add(lblConsultarMesas);
		
		JButton btnNewButton_1 = new JButton("Clique Aqui");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(184, 104, 133, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnSalvarESair = new JButton("SALVAR E SAIR");
		btnSalvarESair.setBounds(145, 217, 117, 29);
		contentPane.add(btnSalvarESair);
	}
}
