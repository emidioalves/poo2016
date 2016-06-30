package classeTestes;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import classeTestes.exception.ContaNaoEncontradaException;
import classeTestes.exception.CpfExistenteException;
import classeTestes.tiposConta.ContaCorrenteTeste;
import classeTestes.tiposConta.ContaSalarioTeste;

/**
 * 
 * Classe para definir Agencias
 * Cada agencia possui um numero N de contas
 *
 */

public class AgenciaTeste {
	
	private ArrayList<ContaGenTeste> contas = new ArrayList<ContaGenTeste>();
	
	private InfoAgencias infoAge;
	
	public InfoAgencias getInfoAge() {
		return infoAge;
	}
	
	public AgenciaTeste(InfoAgencias infoAge) {
		this.infoAge = infoAge;
	}

	/**
	 * Metodo que le o arquivo TXT
	 * @return ArrayList de String, onde cada string contem as informacoes de agencias retiradas de agencias.txt
	 */
	public static ArrayList<String> lerAqr(){

		ArrayList<String> listAge = new ArrayList<String>();
		
		try {
			//O txt TEM que estar na mesma pasta do programa para usar so "nome.txt"
			//Fora isso, eh NECESSARIO especificar o caminho, com "/"
			
			FileReader arq = new FileReader("agencias.txt");	
			BufferedReader lerArq = new BufferedReader(arq);
			StringTokenizer st1 = null;
			
			String linha = null;
			String infoAgencia = null;
			
			while((linha = lerArq.readLine()) != null){
				
				st1 = new StringTokenizer(linha, "*");
				String dados = null;
				
				while(st1.hasMoreTokens()){
					
					dados = st1.nextToken();
					infoAgencia = dados;
					
					listAge.add(infoAgencia);
					
						
					}
					
				}
				
				arq.close();
				lerArq.close();
				
			} catch (FileNotFoundException e) {
				System.err.printf("Erro no caminho do arquivo: %s.\n", e.getMessage());
			} catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			}
	
		return listAge;
		
	}
	
	/**
	 * Metodo que cria as agencias
	 * @param listAge ArraysList de String com informacoes sobre as agencias
 	 * @return Retorna um Array de agencias
	 */
	public static AgenciaTeste[] preencheDados(ArrayList<String> listAge) {
		
			AgenciaTeste[] agencias = new AgenciaTeste[listAge.size()];
		
			StringTokenizer st = null; 
			
			for(int i = 0; i < listAge.size(); i++){
				
				try {
					String linha = listAge.get(i);
					
					st = new StringTokenizer(linha, ";");
					ArrayList<String> tokens = new ArrayList<String>();
					
					while(st.hasMoreTokens()){
						tokens.add(st.nextToken());
					}
					
					String[] pegaDados = new String[8]; //numero de informacoes da Agencia
					int contador = 0;
					
					for(String t : tokens){	
						pegaDados[contador] = t;
						contador++;						
					}
						
					String nomeAgencia = pegaDados[0];
					String ruaEndAgencia = pegaDados[1];
					int numeroEndAgencia = Integer.parseInt(pegaDados[2]);
					String complementoEndAgencia = pegaDados[3];
					String bairroEndAgencia = pegaDados[4];
					String cepAgencia = pegaDados[5];
					String telAgencia = pegaDados[6];
					String codigoAgencia = pegaDados[7];
						
					InfoAgencias info = new InfoAgencias(nomeAgencia, ruaEndAgencia, numeroEndAgencia, complementoEndAgencia, bairroEndAgencia, cepAgencia, telAgencia, codigoAgencia);
					agencias[i] = new AgenciaTeste(info);	
					
				} catch (NumberFormatException e) {
					System.out.println("Erro: " + e.getMessage());
				}
				
			}
			
			return agencias;
			
	}
	
	/**
	 * Metodo que adiciona uma conta dentro do arrayList de contas que a entidade possui
	 * @param ContaGenTeste Conta a ser inserida no array
	 * @throws CpfExistenteException Execao levantada caso ja exista um CPF cadastrado
	 */
	public void adicionarConta(ContaGenTeste conta) throws CpfExistenteException{
		for(int i = 0; i < contas.size(); i++){
			if(conta.getCliente().getCpf().equals(contas.get(i).getCliente().getCpf()))
				throw new CpfExistenteException("CPF ja cadastrado na agencia!");	
		}
		
		contas.add(conta);
	}
	
	/**
	 * Metodo que consulta a conta pertencente a agencia
	 * @param numeroConta Numero da conta a ser consultada
	 * @return Retorna a entidade conta referente ao numero da conta bancaria informada
	 * @throws ContaNaoEncontradaException Excecao levantada caso a conta consultada nao seja encontrada nesta agencia
	 */
	public ContaGenTeste consultarConta(int numeroConta) throws ContaNaoEncontradaException{

		for (int i = 0; i < contas.size(); i++) {
			ContaGenTeste contaUnit = contas.get(i);
						
			if(contaUnit != null && contaUnit.getNumConta() == numeroConta)
				return contaUnit;
		}		
		
		throw new ContaNaoEncontradaException("Conta nao encontrada!");
	}
	
	@Override
	public String toString(){
		return "\nAgencia Banco do Brasil - " + getInfoAge().getNomeAgencia() + "\nRua/avenida: " + getInfoAge().getRuaEndAgencia() + " - Numero: " + getInfoAge().getNumeroEndAgencia() + "\nComplemento: " + getInfoAge().getComplementoEndAgencia() + "\nBairro: " + getInfoAge().getBairroEndAgencia() + " - CEP: " + getInfoAge().getCepAgencia() + "\nTelefone: " + getInfoAge().getTelAgencia();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof AgenciaTeste)) return false;
		return this.infoAge.getCodigoAgencia() == ((AgenciaTeste)obj).infoAge.getCodigoAgencia();
	}

	/**
	 * Metodo que lista as conta pertencente a agencia
	 * @return Retorna true caso exista alguma conta na agencia
	 */
	public boolean listarContas() {
		int cnt = 0;
		
		boolean state1=false; 
		boolean state2=false;
		 
		System.out.println(">>>> Ficha de Clientes <<< \n");
		System.out.println("--------------------------");
		System.out.println("         Conta Corrente       ");
		System.out.println("--------------------------\n");
		
		for(int j=0;j<contas.size();j++){
			
		    if(contas.get(j) instanceof ContaCorrenteTeste){
		    	
		    	System.out.println(contas.get(j).toString());
				state1=true;}
		
		
		}
		if(!state1){
			// caso nao mude, eh porque n existe objeto do tipo Gerente no array estanciado
			System.out.println("A agencia nao possui Contas Corrente \n");
			cnt++;
		}
		
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("         Conta Salario"           );
		System.out.println("--------------------------\n");
		
		for(int j=0;j<contas.size();j++){
		    if(contas.get(j) instanceof ContaSalarioTeste)
		    	
		    	System.out.println(contas.get(j).toString());
				state2=true;}
		if(!state2){
			// caso nao mude, eh porque n existe objeto do tipo Gerente no array estanciado
			System.out.println("A agencia nao possui Contas Salario \n");
			cnt++;
		}
		
		if(cnt != 2)
			return true;
		
		return false;
	}

	/**
	 * Metodo que deleta a conta pertencente a agencia
	 * @param numConta Numero da conta a ser deletada
	 * @return Retorna true se a conta for deletada
	 */
	public boolean deletarConta(int numConta) {
		for(int j=0;j<contas.size();j++){
			if(contas.get(j).getNumConta() == numConta){
				contas.remove(contas.get(j));
				return true;
			}
		}
		
		return false;
		
	}

	/**
	 * Metodo que edita a conta pertencente a agencia
	 * @param numConta Numero da conta a ser consultada
	 * @return Retorna true se a conta for editada com sucesso
	 */
	public boolean editarConta(int numConta) {
		for(int i=0;i<contas.size();i++){
			if(contas.get(i).getNumConta() == numConta){	
				Scanner scanner = new Scanner(System.in);
				
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
				
				if(contas.get(i) instanceof ContaCorrenteTeste){
					contas.set(i, new ContaCorrenteTeste(contas.get(i).getNumConta(), cliente));					
				}else if(contas.get(i) instanceof ContaSalarioTeste){
					contas.set(i, new ContaSalarioTeste(contas.get(i).getNumConta(), cliente));					
				}
				
				return true;
			}
		}
		
		return false;
				
	}
	
	/**
	 * Metodo que lista as conta pertencente a agencia
	 * @return Retorna uma string com todos os dados das contas da agencia, caso exista.
	 */
	public String listarContasFrame() {
		int cnt = 0;
		
		String strContas = null;
		
		boolean state1=false; 
		boolean state2=false;
		 
		strContas = "         Conta(s) Corrente\n";
		
		for(int j=0;j<contas.size();j++){
			
		    if(contas.get(j) instanceof ContaCorrenteTeste){
		    	
		    	strContas += "\nNome: " + contas.get(j).getCliente().getNome() + " " + contas.get(j).getCliente().getSobrenome() + " - Numero da conta: " + contas.get(j).getNumConta()+"\n";
				state1=true;
				
		    }
		
		}
		
		if(!state1){
			strContas += "A agencia nao possui Contas Corrente \n";
			cnt++;
		}
		
		strContas += "\n         Conta(s) Salario\n";
		
		for(int j=0;j<contas.size();j++){
		
			if(contas.get(j) instanceof ContaSalarioTeste){
		
		    	strContas += "\nNome: " + contas.get(j).getCliente().getNome() + " " + contas.get(j).getCliente().getSobrenome() + " - Numero da conta: " + contas.get(j).getNumConta()+"\n";
		    	state2=true;
		    			    	
		    }
		    	
		}
		
		if(!state2){
			strContas += "A agencia nao possui Contas Salario \n";
			cnt++;
		}
		
		if(cnt != 2)
			return strContas;
		
		return null;
	}

	public boolean editarContaFrame(int numConta) {
		for(int i=0;i<contas.size();i++){
			if(contas.get(i).getNumConta() == numConta){	
				try {
					String nome = (String) JOptionPane.showInputDialog(null, "Nome:", "Cadastro de usu�rio",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o seu nome");
					String sobrenome = (String) JOptionPane.showInputDialog(null, "Sobrenome:", "Cadastro de usu�rio",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o seu sobrenome");
					String cpfStr = (String) JOptionPane.showInputDialog(null, "CPF", "Cadastro de usu�rio",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o seu CPF - Ex: 12345678");
					String cpf = cpfStr.replaceAll("[^0-9]", "");
					String ruaAvenidaCliente = (String) JOptionPane.showInputDialog(null, "Logradouro", "Cadastro de usu�rio",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o nome da sua Avenida/Rua");
					String numEndStr = (String) JOptionPane.showInputDialog(null, "Numero", "Cadastro de usu�rio",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o numero");
					String numEndCliente = numEndStr.replaceAll("[^0-9]", "");
					String complementoEndCliente = (String) JOptionPane.showInputDialog(null, "Complemento", "Cadastro de usu�rio",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o complemento");
					String bairroCliente = (String) JOptionPane.showInputDialog(null, "Bairro", "Cadastro de usu�rio",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o seu bairro");
					String cepStr = (String) JOptionPane.showInputDialog(null, "CEP", "Cadastro de usu�rio",JOptionPane.PLAIN_MESSAGE, null, null, "Digite o seu CEP - Ex: 1234567");
					String cepCliente = cepStr.replaceAll("[^0-9]", "");
					
					EnderecoTeste endereco = new EnderecoTeste(ruaAvenidaCliente,numEndCliente,complementoEndCliente,bairroCliente,cepCliente);
					ClienteTeste cliente = new ClienteTeste(nome,sobrenome,cpf, endereco);
					
					if(contas.get(i) instanceof ContaCorrenteTeste){
						contas.set(i, new ContaCorrenteTeste(contas.get(i).getNumConta(), cliente));					
					}else if(contas.get(i) instanceof ContaSalarioTeste){
						contas.set(i, new ContaSalarioTeste(contas.get(i).getNumConta(), cliente));					
					}
					
					return true;
					
				} catch (HeadlessException e) {
					throw new HeadlessException("Erro: " + e.getMessage());
				} catch (NumberFormatException e) {
					throw new NumberFormatException("Erro: " + e.getMessage());
				} catch (NullPointerException e) {
					throw new NullPointerException("Erro: " + e.getMessage());
				}
			}
		}
		
		return false;
				
	}

	
}
