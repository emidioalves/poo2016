package classeTestes.lerArqAgencias;

import java.util.ArrayList;

import classeTestes.AgenciaTeste;

/**
 * 
 * Classe em testes
 *
 */

public class LerArqTeste {

	ArrayList<AgenciaTeste> age = new ArrayList<AgenciaTeste>();	
	
	public int numAgencias(){
		return age.size();
	}
	
	/**
	 * Imprime todas as informações de todas as agencias
	 */
	public void listaAgencias(){
		for(int i = 0; i < age.size(); i++){
			
			System.out.println("\nAgencia Banco do Brasil - " + age.get(i).getInfoAge().getNomeAgencia() + " ----------------");
			System.out.println("Rua/avenida: " + age.get(i).getInfoAge().getRuaEndAgencia() + " - Numero: " + age.get(i).getInfoAge().getNumeroEndAgencia());
			System.out.println("Complemento: " + age.get(i).getInfoAge().getComplementoEndAgencia());
			System.out.println("Bairro: " + age.get(i).getInfoAge().getBairroEndAgencia() + " - CEP: " + age.get(i).getInfoAge().getCepAgencia());
			System.out.println("Telefone: " + age.get(i).getInfoAge().getTelAgencia());
			System.out.println("Codigo da Agencia: " + age.get(i).getInfoAge().getCodigoAgencia());
			
		}
		
	}

}
