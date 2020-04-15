package testes;
import java.util.Scanner;
   class bankAccount{
	   
	   public static void main(String[] args) {
		   Menu inicio = new Menu();
		   inicio.principal(true, null);		   	   
	   }
   }

   class Menu{
	  
	  void principal(boolean menu, Conta destino){
		  if(menu) {
			  System.out.println("Bem vindo!");
			  System.out.println("1 - Selecionar conta\n2 - Sacar \n3 - Depositar");
			  System.out.println("Digite a operação a realizar: ");
			  Scanner digitar = new Scanner(System.in);
			  if(digitar.hasNext("1")) {
				 new Gerenciar().contaNova(true); 
			  }
			  else if(digitar.hasNext("2")) {
				 if(destino == null) {
					 System.out.println("Não há conta.");
				     new Menu().principal(true, null);
				 }else {
					 new Gerenciar().retirar(true, destino); 	 
				 }
			  }
			  else if(digitar.hasNext("3")) {
				  if(destino == null) {
						 System.out.println("Não há conta.");
					     new Menu().principal(true, null);
					 }else {
						 new Gerenciar().depositar(true, destino); 	 
					 }
			  }else {
				 System.out.println("Opção inválida");
				 new Menu().principal(true, destino);
			  }
				 
		  }
	  }
	  
  }
  
	class Gerenciar{
		Conta contaNova(boolean acionar){
			if(acionar) {
				Conta nova = new Conta();
				System.out.println("Nome:");
				Scanner nome = new Scanner(System.in);
				nova.nome = nome.next();
				System.out.println("Valor:");
				Scanner valor = new Scanner(System.in);
				nova.valor = valor.nextDouble();
				new Menu().principal(true, nova);	    
			}
			return null;
		}
		void retirar(boolean acionar, Conta destino) {
			System.out.println("Quanto deseja sacar? ");
			Scanner valor1 = new Scanner(System.in);
			double valor = valor1.nextDouble();	        
			if(destino.saca(valor, destino)) {
				System.out.println("Saque feito com sucesso!");
				System.out.println("Seu saldo é: " + destino.valor);
			}else {
				System.out.println("Não foi possível fazer o saque!");
			}
			new Menu().principal(true, destino);
		}
		void depositar(boolean acionar, Conta destino) {
			System.out.println("Quanto deseja depositar? ");
			Scanner valor1 = new Scanner(System.in);
			double valor = valor1.nextDouble();
			destino.deposita(valor);
			System.out.println("Depósito feito com sucesso!");
			System.out.println("Seu saldo é: " + destino.valor);
			new Menu().principal(true, destino);
		}
		

	}
	
	class Conta{
		String nome;
		double valor;
		
		boolean saca(double quantidade, Conta destino) {
			if(destino.valor < quantidade) {
				return false;
			}else {
				destino.valor -= quantidade;
				return true;
			}
		}
		
		void deposita(double quantidade) {
			this.valor += quantidade;
		}
	}
