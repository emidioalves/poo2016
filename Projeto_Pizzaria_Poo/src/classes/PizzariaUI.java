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
		System.out.println("Digite uma opção:  ");
		System.out.println("\t 0 - voltar ao menu anterior ");
		System.out.println("\t 1 - Menu Cadastrar Produto  ");
		System.out.println("\t 2 - Menu Listar Produtos Cadastrados  ");
		System.out.println("\t 3 - Excluir Produto Cadastrado  ");
		System.out.println("Digite uma opção:  ");
 }

	//criação da interface
	public void run(){
		input = new Scanner (System.in);
		int option;
		try
			{
				do {
					printMenuInicial();
					option = Integer.parseInt(input.nextLine());
					if (option <0){
						throw new NegativeNumberException();
					}
					if (option > 3){
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
				}while (option !=0);
		
		}
		catch (InputMismatchException inputMismatchException){
			System.err.println("Necessario entrar com um valor válido. Tente novamente\n");
			input.nextLine();	
		}
		catch(NegativeNumberException negative){
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
	
	
	//metodo de cadastro de produto
	public void cadastroDeProduto(){
		input = new Scanner (System.in);
		int option;
		try
			{
				do {
					printMenuCadastro();
					option = Integer.parseInt(input.nextLine());
					if (option <0){
						throw new NegativeNumberException();
					}
					switch (option){
						case 1:
							cadastroDeProduto(); break;
						case 2:
							abrirPedidoMesa(); break;
						case 3:
							consultarMesas(); break;
					}
				}while (option !=0);
		
		}
		catch (InputMismatchException inputMismatchException){
			System.err.println("Necessario entrar com um valor válido. Tente novamente\n");
			input.nextLine();	
		}
		catch (NumberFormatException number ){
			System.err.println("Necessário entrar com um valor válido. Tente novamente\n");
			input.nextLine();
		}
		catch(NegativeNumberException negative){
			System.err.println("Necessario entrar com um valor válido. Tente novamente\n");
			input.nextLine();
		}
		
		
	}
	
	//metodo para realizar um pedido
	public void abrirPedidoMesa(){
		
	}
	
	//metodo para consultar os pedidos das mesas
	public void consultarMesas(){
		
	}
}
