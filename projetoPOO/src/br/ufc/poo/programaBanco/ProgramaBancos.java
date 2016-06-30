package br.ufc.poo.programaBanco;
import java.util.InputMismatchException;
import java.util.Scanner;

import classeTestes.Banco;
import classeTestes.AgenciaTeste;
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


public class ProgramaBancos implements ProgramaGen{

	static Banco bancoSelecionado = new Banco();
	public static AgenciaTeste ageEsc;
	public static ContaGenTeste contaEsc;
	
	
	void menuInicial() {
		Scanner scanner = new Scanner(System.in);

		try {
			//FALTA IMPLEMENTAR MENU
			System.out.println("\nVoce deseja:");
			System.out.println("1 - Cadastrar uma nova conta:");
			System.out.println("2 - Acessar sua conta:");
			System.out.println("3 - Editar/Apagar contas:");
			System.out.println("4 - Sair:");
			
			int opcao = scanner.nextInt();
			
			switch (opcao) {
			case 1:
				cadastrarConta();
				break;
			case 2:
				acessarConta();
				break;
			case 3:
				visualizarContas();
				break;
			case 4:
				System.exit(0);
			default:
			}
			
			menuInicial();
		} catch (InputMismatchException e) {
			System.out.println("Erro: " + e.getMessage());
			
			menuInicial();
		}
		
	}

	@Override
	public void visualizarContas() {
		Scanner scanner = new Scanner(System.in);

		try {
			//FALTA IMPLEMENTAR
			System.out.println("-- Digite sua agencia: -----------");
			
			String agencia = scanner.nextLine();
			ageEsc = bancoSelecionado.consultarAge(agencia);

			if(ageEsc.listarContas()){
				//FALTA IMPLEMENTAR
				System.out.println("-- Digite numero da conta: ---");
				
				int numeroConta = scanner.nextInt();
				contaEsc = ageEsc.consultarConta(numeroConta);
				
				System.out.println("\nConta escolhida:\n" + contaEsc.toString());
				
				menuEditaContas();				
			}
			
			System.out.println("Agencia sem contas");
			menuInicial();
			

		} catch (AgenciaNaoEncontradaException e) {
			System.out.println(e.getMessage());
			menuInicial();
		} catch (ContaNaoEncontradaException e){
			System.out.println(e.getMessage());
			menuInicial();
		}
		
	}

	private void menuEditaContas() {
		Scanner scanner = new Scanner(System.in);

		try {
			//FALTA IMPLEMENTAR MENU
			System.out.println("Voce deseja:");
			System.out.println("1 - Editar a conta:");
			System.out.println("2 - Apagar a conta:");
			System.out.println("3 - Voltar:");
			
			int opcao = scanner.nextInt();
			
			switch (opcao) {
			case 1:
				atualizarConta();
				break;
			case 2:
				deletarConta();
				break;
			case 3:
				menuInicial();
			default:
			}
			
			menuInicial();
		} catch (InputMismatchException e) {
			System.out.println("Erro: " + e.getMessage());
			
			acessarConta();
		}
		
	}

	@Override
	public void atualizarConta() {
		int numConta = contaEsc.getNumConta();
		
		if(ageEsc.editarConta(numConta)){
			System.out.println("Conta atualizada!");			
		}else System.out.println("Conta nao encontrada!");		
		
		menuInicial();
	}

	@Override
	public void deletarConta() {
		int numConta = contaEsc.getNumConta();
		
		if(ageEsc.deletarConta(numConta)){
			System.out.println("Conta deletada!");			
		}else System.out.println("Conta nao encontrada!");
		
		menuInicial();
		
	}

	@Override
	public void acessarConta() {
		Scanner scanner = new Scanner(System.in);

		try {
			//FALTA IMPLEMENTAR
			System.out.println("-- Digite sua agencia: -----------");
			
			String agencia = scanner.nextLine();
			ageEsc = bancoSelecionado.consultarAge(agencia);

			//FALTA IMPLEMENTAR
			System.out.println("-- Digite numero da conta: ---");

			int numeroConta = scanner.nextInt();
			contaEsc = ageEsc.consultarConta(numeroConta);

		} catch (AgenciaNaoEncontradaException e) {
			System.out.println(e.getMessage());
			menuInicial();
		} catch (ContaNaoEncontradaException e){
			System.out.println(e.getMessage());
			menuInicial();
		}
		
		menuConta();		
	}

	private void menuConta() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			//FALTA IMPLEMENTAR!
			System.out.println("\n------Bem vindo "+contaEsc.getCliente().getNome()+" ----");
			System.out.println("------------------------------------------------------");
			System.out.println("------Selecione uma opcao:-----");
			System.out.println("------1 - Saque:-----");
			System.out.println("------2 - Deposito:-----");
			System.out.println("------3 - Transferencia:-----");
			System.out.println("------4 - Saldo:-----");
			System.out.println("------5 - Voltar ao menu inicial-----");
			
			int opcao = scanner.nextInt();
			
			switch (opcao) {
			case 1:
				efetuarSaque();
				break;
			case 2:
				efetuarDeposito();
				break;
			case 3:
				efetuarTransferencia();
				break;
			case 4:
				consultarSaldo();
				break;
			case 5:
				menuInicial();
				return;
			default:
			}

			menuConta();
		} catch (InputMismatchException e) {
			System.out.println("Erro: " + e.getMessage());
			
			menuConta();
		}		
	}

	@Override
	public void consultarSaldo() {
		
		//FALTA IMPLEMENTAR!
		System.out.println("------Operacao - Saldo selecionada:-----");
		System.out.println("------Seu saldo atual é de:-----");
		
		System.out.println(contaEsc.consultaSaldo());		
	}

	@Override
	public void efetuarDeposito() {
		Scanner scanner = new Scanner(System.in);
		
		//FALTA IMPLEMENTAR!
		System.out.println("------Operacao - Desposito selecionada:-----");
		System.out.println("------Digite o valor do deposito:-----");
		
		int valor = scanner.nextInt();
		contaEsc.deposita(valor);
		
		//FALTA IMPLEMENTAR!
		System.out.println("Deposito de R$ "+valor+" reais efetuado com sucesso.");
		
	}

	@Override
	public void efetuarSaque() {
		Scanner scanner = new Scanner(System.in);
		
		//FALTA IMPLEMENTAR!
		System.out.println("------Operacao - Saque selecionada:-----");
		System.out.println("------Digite o valor do saque:-----");
		
		int valor = scanner.nextInt();
		
		try {
			contaEsc.saca(valor);
			//FALTA IMPLEMENTAR!
			System.out.println("Saque de R$ "+valor+" reais efetuado com sucesso.");

		} catch (Exception e) {
			//FALTA IMPLEMENTAR!
			System.out.println("Saque de R$ "+valor+" reais nao realizado."+e.getMessage());

		}		
	}

	@Override
	public void efetuarTransferencia() {
		Scanner scanner = new Scanner(System.in);
		//FALTA IMPLEMENTAR!
		System.out.println("------Operacao - Transferencia selecionada:-----");

		try {
			//FALTA IMPLEMENTAR!
			System.out.println("------Digite a agencia para transferencia:-----");

			String agencia = scanner.nextLine();
			AgenciaTeste agenciaTranferencia = bancoSelecionado.consultarAge(agencia);

			//FALTA IMPLEMENTAR!
			System.out.println("------Digite o numero da conta para transferencia:-----");

			int numeroContaTransferencia = scanner.nextInt();
			ContaGenTeste contaTranferencia = agenciaTranferencia.consultarConta(numeroContaTransferencia);
			
			//FALTA IMPLEMENTAR!
			System.out.println("------Digite o valor da tranferencia:-----");

			int valor = scanner.nextInt();
			contaEsc.transfere(contaTranferencia, valor);

			//FALTA IMPLEMENTAR!
			System.out.println("Transferencia efetuada com sucesso!");

		} catch (AgenciaNaoEncontradaException e) {
			//FALTA IMPLEMENTAR!
			System.out.println("--Agencia nao encontrada--");

			return;
		}catch (ContaNaoEncontradaException e) {
			//FALTA IMPLEMENTAR!
			System.out.println("--Conta nao encontrada--");

			return;
		} catch (SaldoInsuficienteException e) {
			//FALTA IMPLEMENTAR!
			System.out.println("Nao foi possivel efetuar a transferencia - "+e.getMessage());

		} catch (LimiteSaqueException e) {
			System.out.println("Nao foi possivel efetuar a transferencia - "+e.getMessage());
		}finally{
			//FALTA IMPLEMENTAR!
			System.out.println("Operaco concluida!");
		}		
	}

	@Override
	public void cadastrarConta() {
		Scanner scanner = new Scanner(System.in);

		try {
			//FALTA IMPLEMENTAR!
			System.out.println("Nome:");
			String nome = scanner.nextLine();
			System.out.println("Sobrenome:");
			String sobrenome = scanner.nextLine();
			System.out.println("CPF:");
			String cpfStr = scanner.nextLine();
			String cpf = cpfStr.replaceAll("[^0-9]", "");
			
			//FALTA IMPLEMENTAR!
			System.out.println("ruaAvenidaCliente:");
			String ruaAvenidaCliente = scanner.nextLine();
			System.out.println("bairroCliente:");
			String bairroCliente = scanner.nextLine();
			System.out.println("cepCliente:");
			String cepStr = scanner.nextLine();
			String cepCliente = cepStr.replaceAll("[^0-9]", "");
			System.out.println("Numero:");
			String num = scanner.nextLine();
			String numEndCliente = num.replaceAll("[^0-9]", "");
			System.out.println("Complemento:");
			String complementoEndCliente = scanner.nextLine();
			
			EnderecoTeste endereco = new EnderecoTeste(ruaAvenidaCliente,numEndCliente,complementoEndCliente,bairroCliente,cepCliente);
			ClienteTeste cliente = new ClienteTeste(nome,sobrenome,cpf, endereco);
			
			System.out.println("Cliente\n" + cliente.toString());

			int numConta = (int)(1000 + (Math.random() * 8999));
			System.out.println("Num gerado:" + numConta);
			
			criarConta(numConta, cliente);
			
		} catch (NumberFormatException e) {
			System.out.println("Erro: " + e.getMessage());
			cadastrarConta();
		} catch (InputMismatchException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}

	@Override
	public void criarConta(int numConta, ClienteTeste cliente) {
		Scanner scanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nDigite o tipo de conta que voce quer criar\n1)Corrente\n2)Salario");
		String teste = sc.nextLine();
		int tp = Integer.parseInt(teste);
		switch(tp){
			case 1:{
					ContaCorrenteTeste conta = new ContaCorrenteTeste(numConta, cliente);
															
					boolean opcAge = false;
				
					while(opcAge != true){
					
						try {
							System.out.println("\nDigite a sua agencia: ");
							String str = scanner.nextLine();
							ageEsc = bancoSelecionado.consultarAge(str);
							
							System.out.println("Agencia escolhida:\n" + ageEsc.toString());
							
							System.out.println("\nConfirmar:\n1) Sim\n2) Nao\nOPC: ");
							String opcInt = scanner.nextLine();
							int opc = Integer.parseInt(opcInt);
							
							if(opc == 1){
								ageEsc.adicionarConta(conta);
								
								System.out.println("Usuario criado:\n");
								System.out.println("Cliente "+ conta.getCliente().getNome() + " " + conta.getCliente().getSobrenome());
								System.out.println("Sua agencia: " + bancoSelecionado.consultarAge(str).getInfoAge().getCodigoAgencia());
								System.out.println("Sua conta: " + conta.getNumConta());
								
								contaEsc = conta;
								
								opcAge = true;
								
								menuConta();
							}
					
						} catch (AgenciaNaoEncontradaException e) {
							//FALTA IMPLEMENTAR!
							System.out.println("--Agencia nao encontrada--");
						} catch (NullPointerException e) {
							System.out.println("Erro!");
						} catch (CpfExistenteException e) {
							System.out.println("--CPF ja cadastrado--");
						}

					}
			
			}
			case 2:{
					ContaSalarioTeste conta = new ContaSalarioTeste(numConta, cliente);
					
					boolean opcAge = false;
					
					while(opcAge != true){
						
						try {
							System.out.println("\nDigite a sua agencia: ");
							String str = scanner.nextLine();
							ageEsc = bancoSelecionado.consultarAge(str);
							
							System.out.println("\nAgencia escolhida:\n" + ageEsc.toString());
							
							System.out.println("\nConfirmar:\n1) Sim\n2) Nao\nOPC: ");
							String opcInt = scanner.nextLine();
							int opc = Integer.parseInt(opcInt);
							
							if(opc == 1){
								ageEsc.adicionarConta(conta);
								
								System.out.println("Usuario criado:\n");
								System.out.println("Cliente "+ conta.getCliente().getNome() + " " + conta.getCliente().getSobrenome());
								System.out.println("Sua agencia: " + bancoSelecionado.consultarAge(str).getInfoAge().getCodigoAgencia());
								System.out.println("Sua conta: " + conta.getNumConta());
								
								contaEsc = conta;
								
								opcAge = true;
								
								menuConta();
							}
													
						} catch (AgenciaNaoEncontradaException e) {
							//FALTA IMPLEMENTAR!
							System.out.println("--Agencia nao encontrada--");
						} catch (NullPointerException e) {
							System.out.println("Erro!");
						} catch (CpfExistenteException e) {
							System.out.println("--CPF ja cadastrado--");
						}

					}
					
			}
			default:{
				criarConta(numConta, cliente);
			}
				
		}
		
	}
	
}
