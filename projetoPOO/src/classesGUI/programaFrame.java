package classesGUI;


import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.poo.programaBanco.ProgramaGen;
import classeTestes.AgenciaTeste;
import classeTestes.Banco;
import classeTestes.ClienteTeste;
import classeTestes.ContaGenTeste;
import classeTestes.EnderecoTeste;
import classeTestes.exception.AgenciaNaoEncontradaException;
import classeTestes.exception.ContaNaoEncontradaException;
import classeTestes.exception.CpfExistenteException;
import classeTestes.exception.LimiteSaqueException;
import classeTestes.exception.SaldoInsuficienteException;
import classeTestes.tiposConta.ContaCorrenteTeste;
import classeTestes.tiposConta.ContaSalarioTeste;

public class programaFrame extends JFrame implements ProgramaGen{

	static Banco bancoSelecionado = new Banco();
	public static AgenciaTeste ageEsc;
	public static ContaGenTeste contaEsc;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					programaFrame frame = new programaFrame();
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
	public programaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cadastrarConta();
				
			}
		});
		btnCadastrar.setBounds(36, 11, 109, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				acessarConta();
				
			}
		});
		btnAcessar.setBounds(181, 11, 89, 23);
		contentPane.add(btnAcessar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				visualizarContas();
				
			}
		});
		btnAtualizar.setBounds(306, 11, 89, 23);
		contentPane.add(btnAtualizar);
	}

	@Override
	public void atualizarConta() {
		try {
			int numConta = contaEsc.getNumConta();
			
			if(ageEsc.editarContaFrame(numConta)){
				JOptionPane.showMessageDialog(this, "Conta atualizada!", null, JOptionPane.PLAIN_MESSAGE);
			}else JOptionPane.showMessageDialog(this, "Conta nao encontrada!", null, JOptionPane.ERROR_MESSAGE);
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Erro!", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void deletarConta() {
		try {
			int numConta = contaEsc.getNumConta();
			
			if(ageEsc.deletarConta(numConta)){
				JOptionPane.showMessageDialog(this, "Conta apagada!", null, JOptionPane.PLAIN_MESSAGE);
			}else JOptionPane.showMessageDialog(this, "Conta nao encontrada!", null, JOptionPane.ERROR_MESSAGE);
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Erro!", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void visualizarContas() {
		try {
			String agencia = (String) JOptionPane.showInputDialog(this, "Agencia:", "Visualizar Contas",JOptionPane.PLAIN_MESSAGE, null, null, "Digite a agencia");
			
			ageEsc = bancoSelecionado.consultarAge(agencia);

			if(ageEsc.listarContasFrame() != null){
				String numContaStr = (String) JOptionPane.showInputDialog(this, ageEsc.listarContasFrame() + "\nNumero da conta:", "Visualizar Contas",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o numero da conta escolhida");
				
				int numeroConta = Integer.parseInt(numContaStr);
				contaEsc = ageEsc.consultarConta(numeroConta);
				
				JOptionPane.showMessageDialog(this, "Conta escolhida:\n" + contaEsc.toString(), "Visualizar Contas",JOptionPane.PLAIN_MESSAGE, null);
				
				menuEditaContas();				
			}else JOptionPane.showMessageDialog(this, "Agencia sem contas!", null, JOptionPane.ERROR_MESSAGE);			
			
		} catch (AgenciaNaoEncontradaException e) {
			JOptionPane.showMessageDialog(this, "Agencia nao encontrada!", null, JOptionPane.ERROR_MESSAGE);

			return;
		}catch (ContaNaoEncontradaException e) {
			JOptionPane.showMessageDialog(this, "Conta nao encontrada!", null, JOptionPane.ERROR_MESSAGE);

			return;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Voce saiu!", null, JOptionPane.WARNING_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Voce saiu!", null, JOptionPane.WARNING_MESSAGE);
		}
		
	}

	private void menuEditaContas() {
		try {
			Object[] opc = { "Editar conta", "Apagar conta" };
			Object resposta;
			
			resposta = JOptionPane.showInputDialog(this, "Digite o tipo de atualizacao:", "Atualizar contas", JOptionPane.PLAIN_MESSAGE, null, opc, null);
			
			if(resposta.equals("Editar conta")){
				atualizarConta();				
			}else if(resposta.equals("Apagar conta")){
				deletarConta();				
			}
			
		} catch (HeadlessException e) {
			System.out.println("Erro: " + e.getMessage());
			
			acessarConta();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Voce saiu!", null, JOptionPane.WARNING_MESSAGE);
		}	
	}

	@Override
	public void acessarConta() {
		try {
			
			String agencia = (String) JOptionPane.showInputDialog(this, "Agencia:", "Acessar Conta",JOptionPane.PLAIN_MESSAGE, null, null, "Digite a agencia");
			
			ageEsc = bancoSelecionado.consultarAge(agencia);

			String numContaStr = (String) JOptionPane.showInputDialog(this, "Numero da conta:", "Acessar Conta",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o numero da conta");
			
			int numeroConta = Integer.parseInt(numContaStr);
			contaEsc = ageEsc.consultarConta(numeroConta);

		} catch (AgenciaNaoEncontradaException e) {
			JOptionPane.showMessageDialog(this, "Agencia nao encontrada!", null, JOptionPane.ERROR_MESSAGE);

			return;
		}catch (ContaNaoEncontradaException e) {
			JOptionPane.showMessageDialog(this, "Conta nao encontrada!", null, JOptionPane.ERROR_MESSAGE);

			return;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Voce saiu!", null, JOptionPane.WARNING_MESSAGE);
		}
		
		menuConta();
		
	}

	@Override
	public void consultarSaldo() {
		try {
			JOptionPane.showMessageDialog(this, "Saldo atual: R$" + contaEsc.consultaSaldo(), "Saldo",JOptionPane.PLAIN_MESSAGE);
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Erro!",null, JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Voce saiu!", null, JOptionPane.WARNING_MESSAGE);
		}
	}

	@Override
	public void efetuarDeposito() {
		
		try {
			String valorStr = (String) JOptionPane.showInputDialog(this, "Valor:", "Desposito",JOptionPane.PLAIN_MESSAGE, null, null, "Digite valor desejado");
			double valor = Double.parseDouble(valorStr);
			
			contaEsc.deposita(valor);
			JOptionPane.showMessageDialog(this, "Deposito de R$ "+valor+" reais efetuado com sucesso.");
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Erro!",null, JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite valores validos!",null, JOptionPane.ERROR_MESSAGE);
			
			return;
		}
		
	}

	@Override
	public void efetuarSaque() {
		
		try {
			String valorStr = (String) JOptionPane.showInputDialog(this, "Valor:", "Saque",JOptionPane.PLAIN_MESSAGE, null, null, "Digite valor desejado");
			double valor = Double.parseDouble(valorStr);
			
			try {
				contaEsc.saca(valor);
				JOptionPane.showMessageDialog(this, "Saque de R$ "+valor+" reais efetuado com sucesso.");
			} catch (SaldoInsuficienteException e) {
				JOptionPane.showMessageDialog(this, "Saque de R$ "+valor+" reais nao realizado\nSaldo insuficiente!",null, JOptionPane.ERROR_MESSAGE);
			} catch (LimiteSaqueException e) {
				JOptionPane.showMessageDialog(this, "Saque de R$ "+valor+" reais nao realizado\nRealize saques abaixo do limite (R$500)",null, JOptionPane.ERROR_MESSAGE);
			}

		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Erro!",null, JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite valores validos!",null, JOptionPane.ERROR_MESSAGE);
			
			return;
		}	
	}

	@Override
	public void efetuarTransferencia() {
		try {
			String agencia = (String) JOptionPane.showInputDialog(this, "Agencia:", "Transferencia",JOptionPane.PLAIN_MESSAGE, null, null, "Digite a agencia para transferencia");
			
			AgenciaTeste agenciaTranferencia = bancoSelecionado.consultarAge(agencia);

			String numContaStr = (String) JOptionPane.showInputDialog(this, "Numero da conta:", "Transferencia",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o numero da conta para transferencia");
			
			int numeroContaTransferencia = Integer.parseInt(numContaStr);
			ContaGenTeste contaTranferencia = agenciaTranferencia.consultarConta(numeroContaTransferencia);
			
			String valorStr = (String) JOptionPane.showInputDialog(this, "Valor:", "Transferencia",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o valor desejado");
			
			double valor = Double.parseDouble(valorStr);
			contaEsc.transfere(contaTranferencia, valor);
			
			JOptionPane.showMessageDialog(this, "Transferencia realizada para " + contaTranferencia.getCliente().getNome() + " " + contaTranferencia.getCliente().getSobrenome() + ", no valor de R$" + valor + ", foi efetuada com sucesso!", "Transferencia",JOptionPane.PLAIN_MESSAGE);

		} catch (AgenciaNaoEncontradaException e) {
			JOptionPane.showMessageDialog(this, "Agencia nao encontrada!", null, JOptionPane.ERROR_MESSAGE);

			return;
		}catch (ContaNaoEncontradaException e) {
			JOptionPane.showMessageDialog(this, "Conta nao encontrada!", null, JOptionPane.ERROR_MESSAGE);

			return;
		} catch (SaldoInsuficienteException e) {
			JOptionPane.showMessageDialog(this, "Nao foi possivel efetuar a transferencia!\nSaldo Insuficiente!", null, JOptionPane.ERROR_MESSAGE);
			
			return;
		} catch (LimiteSaqueException e) {
			JOptionPane.showMessageDialog(this, "Nao foi possivel efetuar a transferencia!\nRealize transferencias abaixo do limite (R$500)", null, JOptionPane.ERROR_MESSAGE);
			
			return;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite valores validos!",null, JOptionPane.ERROR_MESSAGE);
			
			return;
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Erro!",null, JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void cadastrarConta() {
		try {
			String nome = (String) JOptionPane.showInputDialog(this, "Nome:", "Cadastro de usuario",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o seu nome");
			String sobrenome = (String) JOptionPane.showInputDialog(this, "Sobrenome:", "Cadastro de usuario",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o seu sobrenome");
			String cpfStr = (String) JOptionPane.showInputDialog(this, "CPF", "Cadastro de usuario",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o seu CPF - Ex: 12345678");
			String cpf = cpfStr.replaceAll("[^0-9]", "");
			String ruaAvenidaCliente = (String) JOptionPane.showInputDialog(this, "Logradouro", "Cadastro de usuario",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o nome da sua Avenida/Rua");
			String numEndStr = (String) JOptionPane.showInputDialog(this, "Numero", "Cadastro de usuario",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o numero");
			String numEndCliente = numEndStr.replaceAll("[^0-9]", "");
			String complementoEndCliente = (String) JOptionPane.showInputDialog(this, "Complemento", "Cadastro de usuario",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o complemento");
			String bairroCliente = (String) JOptionPane.showInputDialog(this, "Bairro", "Cadastro de usuario",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o seu bairro");
			String cepStr = (String) JOptionPane.showInputDialog(this, "CEP", "Cadastro de usuario",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o seu CEP - Ex: 1234567");
			String cepCliente = cepStr.replaceAll("[^0-9]", "");
			
			EnderecoTeste endereco = new EnderecoTeste(ruaAvenidaCliente,numEndCliente,complementoEndCliente,bairroCliente,cepCliente);
			ClienteTeste cliente = new ClienteTeste(nome,sobrenome,cpf, endereco);
			int numConta = (int)(1000 + (Math.random() * 8999));

			JOptionPane.showMessageDialog(this, cliente.toString() + "\nNumero conta: " + numConta, "Informacao do cliente", JOptionPane.PLAIN_MESSAGE);
			criarConta(numConta, cliente);			
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Erro!", null, JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Erro!", null, JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(this, "Digite valores validos!", null, JOptionPane.ERROR_MESSAGE);
			cadastrarConta();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Digite valores validos!", null, JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void criarConta(int numConta, ClienteTeste cliente) {

		try {
			Object[] opc = { "Conta Salario", "Conta Corrente" };
			Object resposta;
			
			resposta = JOptionPane.showInputDialog(this, "Digite o tipo de conta: ", "Cadastro de usuario", JOptionPane.PLAIN_MESSAGE, null, opc, null);
			
			if(resposta.equals("Conta Salario")){
				
				ContaSalarioTeste conta = new ContaSalarioTeste(numConta, cliente);
				
				boolean opcAge = false;
			
				while(opcAge != true){
				
					try {
						
						String age = (String) JOptionPane.showInputDialog(this, "\nDigite a sua agencia: ", "Cadastro de usuario",JOptionPane.PLAIN_MESSAGE, null, null, "Ex: 1234-5");
						ageEsc = bancoSelecionado.consultarAge(age);
						
						int confirma = JOptionPane.showConfirmDialog(this, "Agencia escolhida:\n" + ageEsc.toString());
						
						if(confirma == JOptionPane.YES_OPTION){
							try {
								ageEsc.adicionarConta(conta);
							} catch (CpfExistenteException e) {
								JOptionPane.showMessageDialog(this, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
								opcAge = true;
							}
							
							JOptionPane.showMessageDialog(this, "Usuario criado:\n" + "Cliente "+ 
															conta.getCliente().getNome() + " " + conta.getCliente().getSobrenome()
															+ "\nSua agencia: " + bancoSelecionado.consultarAge(age).getInfoAge().getCodigoAgencia()
															+ "\nSua conta: " + conta.getNumConta());
													
							contaEsc = conta;
							
							opcAge = true;
							
							menuConta();
							
						}else if(confirma == JOptionPane.NO_OPTION){
							opcAge = false;
						}else opcAge = true;
				
					} catch (AgenciaNaoEncontradaException e) {
						JOptionPane.showMessageDialog(this, "Agencia nao encontrada!", null, JOptionPane.ERROR_MESSAGE);
					} catch (HeadlessException e) {
						JOptionPane.showMessageDialog(this, "Erro!", null, JOptionPane.ERROR_MESSAGE);
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(this, "Voce saiu!", null, JOptionPane.ERROR_MESSAGE);
						opcAge = true;
					}

				}
				
			}else if(resposta.equals("Conta Corrente")){
				
				ContaCorrenteTeste conta = new ContaCorrenteTeste(numConta, cliente);
				
				boolean opcAge = false;
			
				while(opcAge != true){
				
					try {
						
						String age = (String) JOptionPane.showInputDialog(this, "\nDigite a sua agencia: ", "Cadastro de usuario",JOptionPane.PLAIN_MESSAGE, null, null, "Ex: 1234-5");
						ageEsc = bancoSelecionado.consultarAge(age);
						
						int confirma = JOptionPane.showConfirmDialog(this, "Agencia escolhida:\n" + ageEsc.toString());
						
						if(confirma == JOptionPane.YES_OPTION){
							try {
								ageEsc.adicionarConta(conta);
							} catch (CpfExistenteException e) {
								JOptionPane.showMessageDialog(this, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
								opcAge = true;
							}
							
							JOptionPane.showMessageDialog(this, "Usuario criado:\n" + "Cliente "+ 
															conta.getCliente().getNome() + " " + conta.getCliente().getSobrenome()
															+ "\nSua agencia: " + bancoSelecionado.consultarAge(age).getInfoAge().getCodigoAgencia()
															+ "\nSua conta: " + conta.getNumConta());
													
							contaEsc = conta;
							
							opcAge = true;
							
							menuConta();
							
						}else if(confirma == JOptionPane.NO_OPTION){
							opcAge = false;
						}else opcAge = true;
				
					} catch (AgenciaNaoEncontradaException e) {
						JOptionPane.showMessageDialog(this, "Agencia nao encontrada!", null, JOptionPane.ERROR_MESSAGE);
					} catch (HeadlessException e) {
						JOptionPane.showMessageDialog(this, "Erro!", null, JOptionPane.ERROR_MESSAGE);
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(this, "Voce saiu!", null, JOptionPane.ERROR_MESSAGE);
						opcAge = true;
					}

				}
				
			}
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Erro!", null, JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Voce saiu!", null, JOptionPane.WARNING_MESSAGE);
		}
		
	}

	private void menuConta() {
		Object[] opc = { "Saque", "Deposito", "Transferencia", "Saldo" };
		Object resposta;
				
		try {
			resposta = JOptionPane.showInputDialog(this, "Bem vindo " + contaEsc.getCliente().getNome(), "Menu - Usuario", JOptionPane.PLAIN_MESSAGE, null, opc, null);
			
			if(resposta.equals("Saque")){
				efetuarSaque();
			}else if(resposta.equals("Deposito")){
				efetuarDeposito();
			}else if(resposta.equals("Transferencia")){
				efetuarTransferencia();
			}else if(resposta.equals("Saldo")){
				consultarSaldo();
			}
			
			menuConta();
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Erro!", null, JOptionPane.ERROR_MESSAGE);
			
			menuConta();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Voce saiu da conta!", null, JOptionPane.WARNING_MESSAGE);
		}
		
	}
}
