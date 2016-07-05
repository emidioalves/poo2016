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
							listarProdutos(); break;
						case 3:
							removeProd(); break;
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
							cadastroPizzaSalgada(); break;
						case 2:
							cadastroPizzaDoce(); break;
						case 3:
							cadastroBebida(); break;
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
	public void cadastroPizzaSalgada(){
		System.out.println("\n\n\t\t*** Cadastro de Pizzas Salgadas***");

		String sabor = null;
		String tamanho = null;
		double preco = 0;

		try{
		System.out.println("Digite o sabor da pizza: ");
		sabor = input.nextLine();
		//sabor.toUpperCase();
		System.out.println("Digite o tamanho da pizza: ");
		tamanho = input.nextLine();
		System.out.println("Digite o preço: ");
		preco = Double.parseDouble(input.nextLine());
		if (preco < 0){
				throw new NegativeNumberException();
			}
		}
		catch (NegativeNumberException negative){
			System.err.println("Digite um valor positivo!");
		}
		catch (InputMismatchException inputError){
			System.err.println("Digite um valor válido");
		}
		finally{
			pizzaria.cadastrarPizzaSalgada(sabor.toUpperCase(), preco, tamanho.toUpperCase());
			System.out.println("Produto cadastrado com sucesso!");
		}
	}
	
	//metodo para cadastrar pizza salgada
	public void cadastroPizzaDoce(){
		System.out.println("\n\n\t\t*** Cadastro de Pizzas Doces***");

		String sabor = null;
		String tamanho = null;
		double preco = 0;

		try{
			System.out.println("Digite o sabor da pizza: ");
			sabor = input.nextLine();
			System.out.println("Digite o tamanho da pizza: ");
			tamanho = input.nextLine();
			System.out.println("Digite o preço: ");
			preco = Double.parseDouble(input.nextLine());
			if (preco < 0){
				throw new NegativeNumberException();
			}
		}
		catch (NegativeNumberException negative){
			System.err.println("Digite um valor positivo!");
		}
		catch (InputMismatchException inputError){
			System.err.println("Digite um valor válido");
		}
		finally{
			pizzaria.cadastrarPizzaDoce(sabor.toUpperCase(), preco, tamanho.toUpperCase());
			System.out.println("Produto cadastrado com sucesso!\n");			
		}
	}
	
	//metodo para cadastrar bebida
	public void cadastroBebida(){
		System.out.println("\n\n\t\t*** Cadastro de Bebidas***");
		String nome = null;
		String tamanho = null;
		double preco = 0;
		try{
			System.out.println("Digite o nome da bebida: ");
			nome = input.nextLine();
			System.out.println("Digite o tamanho: ");
			tamanho = input.nextLine();
			System.out.println("Digite o preço: ");
			preco = Double.parseDouble(input.nextLine());
				if (preco < 0){
					throw new NegativeNumberException();
				}
		}
		catch (NegativeNumberException negative){
			System.out.println("Digite um valor positivo!");
		}
		catch (InputMismatchException inputError){
			System.err.println("Digite um valor válido");
		}
		finally{
			pizzaria.cadastrarBebida(nome.toUpperCase(), preco, tamanho.toUpperCase());
			System.out.println("Produto cadastrado com sucesso!");	

		}
	}
	
	//metodo de listagem de produtos
	public void listarProdutos(){
		input = new Scanner (System.in);
		int option =0;
		do
			{
				try {
					printMenuListarProdutos();
					option = Integer.parseInt(input.nextLine());
					if (option <0 || option > 3){
						throw new NumberOutLimitsException();
					}
					switch (option){
						case 1:
							listarPizzaSalgada(); break;
						case 2:
							listarPizzaDoce(); break;
						case 3:
							listarBebida(); break;
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
	
	//metodo para listar pizza salgada
	public void listarPizzaSalgada(){
		pizzaria.listarPizzasSalgadas();
		}

	//metodo para listar pizza doce
	public void listarPizzaDoce(){
		pizzaria.listarPizzasDoces();
	}
	
	//metodo para listar pizza doce
	public void listarBebida(){
		pizzaria.listarBebidas();
	}
	
	//metodo que remove produtos da lista
	public void removeProd(){
		System.out.println("\n\n\t\t*** REMOÇÃO DE PRODUTO DA LISTA ***\n\n");
		String prodRem;
		System.out.println("Digite o nome do produto que deseja remover: ");
		prodRem = input.nextLine();
		String prodUP = prodRem.toUpperCase();
		Produto prod = pizzaria.buscarProduto(prodUP);
		if (prod == null){
			System.err.println("Produto não encontrado");
		}
		else{
			pizzaria.removerProduto(prod);
		}
	}
	
	//metodo para realizar um pedido
	public void abrirPedidoMesa(){
		
	}
	
	//metodo para consultar os pedidos das mesas
	public void consultarMesas(){
		
	}
}
