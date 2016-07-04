package classes;

import java.util.InputMismatchException;
import java.util.Scanner;

import excessoes.NegativeNumberException;
import excessoes.NumberOutLimitsException;

public class PizzariaUI {
	
	
	private Pizzaria pizzaria;
	private Scanner input;
	
	//criação do metodo construtor da interface grafica
	public PizzariaUI(String nomePizzaria){
		pizzaria =  new Pizzaria(nomePizzaria);
	}
	
	//menu da aplicação
	private void printMenuInicial(){
			System.out.println("\n\n App Pizzaria: ver. 1.0 ");
			System.out.println("Digite uma opção:  ");
			System.out.println("\t 0 - sair do sistema e salvar produtos ");
			System.out.println("\t 1 - Menu Cadastro de Produtos  ");
			System.out.println("\t 2 - Menu Abrir Pedido Mesa ");
			System.out.println("\t 3 - Menu Consultar mesas em atendimento  ");
			System.out.println("Digite uma opção:  ");
	 }

	//menu cadastro de produtos
	private void printMenuCadastro(){
		System.out.println("\t\t*****MENU CADASTRO DE PRODUTOS*****  ");

		System.out.println("Digite uma opção:  ");
		System.out.println("\t 0 - voltar ao menu anterior ");
		System.out.println("\t 1 - Cadastrar Produtos  ");
		System.out.println("\t 2 - Listar Produtos Cadastrados  ");
		System.out.println("\t 3 - Excluir Produto Cadastrado  ");
		System.out.println("Digite uma opção:  ");
 }

	//menu Cadastrar Produtos
	private void printMenuCadastrarProdutos(){
		System.out.println("\t\t***** CADASTRO DE PRODUTOS*****  ");

		System.out.println("Digite uma opção:  ");
		System.out.println("\t 0 - voltar ao menu anterior ");
		System.out.println("\t 1 - Cadastrar pizza salgada  ");
		System.out.println("\t 2 - Cadastrar pizza doce  ");
		System.out.println("\t 3 - Cadastrar bebida  ");
		System.out.println("Digite uma opção:  ");
 }
	//menu listar produtos cadastrados
	private void printMenuListarProdutos(){
		System.out.println("\t\t***** LISTA DE PRODUTOS*****  ");

		System.out.println("Digite uma opção:  ");
		System.out.println("\t 0 - voltar ao menu anterior ");
		System.out.println("\t 1 - Lista de pizzas salgadas  ");
		System.out.println("\t 2 - Lista de pizzas doces  ");
		System.out.println("\t 3 - Lista de bebidas  ");
		System.out.println("Digite uma opção:  ");
 }
	
	//criação da interface
	public void run(){
		input = new Scanner (System.in);
		int option = 0;
		
		do {
			try{
					printMenuInicial();
					option = Integer.parseInt(input.nextLine());
					if (option <0 || option >4){
						throw new NumberOutLimitsException();
					}
					switch (option){
						case 1:
							cadastroDeProduto(); break;
						case 2:
							abrirPedidoMesa(); break;
						case 3:
							consultarMesas(); break;
					}
		
			}
				catch (InputMismatchException inputMismatchException){
					System.err.println("Necessario entrar com um valor válido. Tente novamente\n");
					input.nextLine();	
				}
				catch (NumberFormatException number ){
					System.err.println("Necessário entrar com um valor válido. Tente novamente\n");
					input.nextLine();
				}
				catch (NumberOutLimitsException bigNumber ){
					System.err.println("Necessário entrar com um valor válido. Tente novamente\n");
					input.nextLine();
				}
		}
		while(option !=0);

	}
	
	
	//metodo de cadastro de produto
	public void cadastroDeProduto(){
		input = new Scanner (System.in);
		int option =0;
		do
			{
				try {
					printMenuCadastro();
					option = Integer.parseInt(input.nextLine());
					if (option <0 || option >3){
						throw new NumberOutLimitsException();
					}
					switch (option){
						case 1:
							entradaProdutos(); break;
						case 2:
							//listarProdutos(); break;
						case 3:
							//removerProdutos(); break;
					}
		
		}
		catch (InputMismatchException inputMismatchException){
			System.err.println("Necessario entrar com um valor válido. Tente novamente\n");
			input.nextLine();	
		}
		catch (NumberFormatException number ){
			System.err.println("Necessário entrar com um valor válido. Tente novamente\n");
			input.nextLine();
		}
		catch(NumberOutLimitsException bigNumber){
			System.err.println("Necessario entrar com um valor válido. Tente novamente\n");
			input.nextLine();
		}
		}
		while (option !=0);

		
	}
	
	//metodo para cadastrar produtos
	public void entradaProdutos(){
		input = new Scanner (System.in);
		int option =0;
		do
			{
				try {
					printMenuCadastrarProdutos();
					option = Integer.parseInt(input.nextLine());
					if (option <0 || option > 3){
						throw new NumberOutLimitsException();
					}
					switch (option){
						case 1:
							cadastrarPizzaSalgada(); break;
						case 2:
							cadastrarPizzaDoce(); break;
						case 3:
							cadastrarBebida(); break;
					}
		
		}
		catch (InputMismatchException inputMismatchException){
			System.err.println("Necessario entrar com um valor válido. Tente novamente\n");
			input.nextLine();	
		}
		catch (NumberFormatException number ){
			System.err.println("Necessário entrar com um valor válido. Tente novamente\n");
			input.nextLine();
		}
		catch(NumberOutLimitsException bigNumber){
			System.err.println("Necessario entrar com um valor válido. Tente novamente\n");
			input.nextLine();
		}
		}
		while (option !=0);

		
	}
		
	//metodo para cadastrar pizza salgada
	public void cadastrarPizzaSalgada(){
		
	}
	
	//metodo para cadastrar pizza salgada
	public void cadastrarPizzaDoce(){
			
	}
	
	//metodo para cadastrar pizza salgada
	public void cadastrarBebida(){
			
	}
	
	
	//metodo para realizar um pedido
	public void abrirPedidoMesa(){
		
	}
	
	//metodo para consultar os pedidos das mesas
	public void consultarMesas(){
		
	}
}
