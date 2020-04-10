package testes;
import java.util.Scanner;
public class SignUpSignIn{
	
	public static void main(String[] args) {
		new Menu().iniciar(true, null);
		
	}
	
}


class Menu{
	void iniciar(boolean ativar, Conta nova) {
		System.out.println("1 - Login \n2 - Cadastrar\n3 - Sair");
		Scanner selecao = new Scanner(System.in);
		if(selecao.hasNext("1")){
			if(nova == null) {
				System.out.println("Você não tem conta, crie uma!");
				new Menu().iniciar(true, null);
			}else {
				new Conta().Login(nova, true);
			}
		}else if(selecao.hasNext("2")) {
				new Conta().Cadastro(true);
		}else if(selecao.hasNext("3")) {
			    new Conta().Sair(true);
		}
		
	}
	
	
}

class Conta{
	String nome, senha;
	void Login(Conta nova, boolean ativador) {
			String Log, Pass;
			System.out.println("Login: ");
			Scanner login = new Scanner(System.in);
			Log = login.next();;
			System.out.println("Senha: ");
			Scanner pass = new Scanner(System.in);
			Pass = pass.next();
			if(Log.matches(nova.nome) && Pass.matches(nova.senha)) {
				System.out.println("Bem Vindo!");
			}else {
				System.out.println("Login ou Senha incorretos! Tente Novamente.");
				new Conta().Login(nova, true);
			}
	}
	void Cadastro(boolean ativador) {
			Conta nova = new Conta();
			System.out.println("Login: ");
			Scanner login = new Scanner(System.in);
			nova.nome = login.next();
			System.out.println("Senha: ");
			Scanner pass = new Scanner(System.in);
			nova.senha = pass.next();
			System.out.println("Conta cadastrada com sucesso!");
			new Menu().iniciar(true, nova);
			}
	void Sair(boolean ativar) {
		System.out.println("Muito Obrigado! Espero que volte logo.");
	}
}
