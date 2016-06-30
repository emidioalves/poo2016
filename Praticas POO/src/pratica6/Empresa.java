package pratica6;

import java.util.ArrayList;

public class Empresa {
	private String nomeEmpresa;
	private ArrayList<Empregado> emp;
	
	// construtor para nomear a empresa alem de instanciar a lista de Empregados
	public Empresa(String nomeEmpresa){
		this.nomeEmpresa=nomeEmpresa;
		emp=new ArrayList<Empregado>();
	}
	// metodo para adicionar Gerentes ao arrayList de empregados da Empresa
	public void adcGerente(String nome,double salario){
		try {
		   
		    if(salario>0) {
		        emp.add(new Gerente(nome, salario));
		    }
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		    
		}
		
	}
	// metodo para adicionar Tecnicos ao arrayList de empregados da Empresa
		public void adcDesenvolvedor(String nome,double salario){
			try {
				   
			    if(salario>0) {
			        emp.add(new Tecnico(nome, salario));
			    }
			} catch (Exception e) {
			    System.out.println(e.getMessage());
			    
			}
		}
    // numero de Gerentes na Empresa
		public int numeroGerentes(){
			int number=0;
			     
			    for(int i=0;i<emp.size();i++){
			    	if(emp.get(i) instanceof Gerente )
			    		number++;
			    }
		
			    	
	    return number;}
		
	// numero de Tecnicos na Empresa
		public int numeroDesenvolvedores(){
			int number=0;
			     
			    for(int i=0;i<emp.size();i++){
			    	if(emp.get(i) instanceof Tecnico )
			    		number++;
			    }
		
			    	
	    return number;}
		
	// listando empregados da empresa em ordem Gerentes -> Desenvolvedores
		
		public void listaEmpregados(){
		 boolean state1=false; 
		 boolean state2=false;
		 
			System.out.println(">>>> Ficha de Empregados - Empresa "+ this.nomeEmpresa+" <<< \n");
			System.out.println("--------------------------");
			System.out.println("         Gerente(s)       ");
			System.out.println("--------------------------\n");
			
			for(int i=0;i<emp.size();i++){
				
			    if(emp.get(i) instanceof Gerente){
			    	
			    	System.out.println("Nome: "+emp.get(i).nome+" / Salario: "+emp.get(i).salario+"/ SalarioAumento: "+ emp.get(i).aumentaSalario());

				state1=true;}
			
			
			}
			if(!state1)// caso nao mude, eh porque n existe objeto do tipo Gerente no array estanciado
				System.out.println("A empresa ainda nao possui Gerente(s) \n");
			
			System.out.println();
			System.out.println("--------------------------");
			System.out.println("         Tecnico(s)"           );
			System.out.println("--------------------------\n");
			
			for(int i=0;i<emp.size();i++){
			    if(emp.get(i) instanceof Tecnico)
			    	
			    	System.out.println("Nome: "+emp.get(i).nome+" / Salario: "+emp.get(i).salario+"/ SalarioAumento: "+ emp.get(i).aumentaSalario());

				state2=true;}
			if(!state2)// caso nao mude, eh porque n existe objeto do tipo Gerente no array estanciado

				System.out.println("A empresa ainda nao possui Tecnico(s) \n");
		}
			
	

}
