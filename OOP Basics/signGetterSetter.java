package testes;
import java.util.Scanner;

public class teste{
	
	public static void main(String [] args) {
		new Menu().Principal(null);
	}
}	
	class Menu{
		void Principal(Account conta) {
			System.out.println("1 - Sign in \n2 - Sign up ");
			Scanner option = new Scanner(System.in);
			if(option.hasNext("1")) {
				new Menu().signIn(conta);
			}else if(option.hasNext("2")) {
				new Menu().signUp();
			}else {
				System.out.println("Opção inválida!");
				new Menu().Principal(conta);
			}
		}
		void signIn(Account conta) {
			if(conta == null) {
				System.out.println("Você não possui cadastro, faça um!");
				new Menu().Principal(null);
			}else {	
				System.out.println("Digite seu login e sua senha: ");
				Scanner login = new Scanner(System.in);
				String compLogin = conta.getLogin();
				Scanner pass = new Scanner(System.in);
				String compSenha = conta.getPass();
				if(login.hasNext(compLogin) && pass.hasNext(compSenha)) {
					System.out.println("Seja bem vindo!");
				}else {
					System.out.println("Login ou senha incorretos, tente novamente!");
					new Menu().signIn(conta);
				}
			}			
		}
		
		void signUp() {
			Account conta = new Account();
			System.out.println("Digite um login: ");
			Scanner login = new Scanner(System.in);
			conta.setLogin(login.next());
			System.out.println("Digite uma senha: ");
			Scanner pass = new Scanner(System.in);
			conta.setPass(pass.next());
			System.out.println("Conta registrada com sucesso!");
			new Menu().Principal(conta);
		}
	}

class Account{
	private String login, pass;
	
	void setLogin(String login) {
		this.login = login;
	}
	
	String getLogin() {
		return this.login;
	}
	
	void setPass(String pass) {
		this.pass = pass;
	}
	
	String getPass() {
		return this.pass;
	}
}