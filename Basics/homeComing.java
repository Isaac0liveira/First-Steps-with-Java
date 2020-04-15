package testes;
import java.util.Scanner;
public class homeComing{
	
	public static void main(String[] args) {
		new Casa().chegada(null);
	}
	
}

class Porta{
	String cor;
	boolean aberta = true, trancada = false;
	
	void criaPorta() {
		Porta novaPorta = new Porta();
		System.out.println("Cor da sua porta nova: ");
		Scanner cor = new Scanner(System.in);
		novaPorta.cor = cor.next();
		new Casa().chegada(novaPorta);
	}
	
	void abrePorta(Porta entra) {
		if(entra.aberta) {
			System.out.println("A porta já está aberta!");
		}else if(entra.trancada) {
			System.out.println("A porta está trancada!");
		}else {
			entra.aberta = true;
			System.out.println("Você abriu a porta!");
		}
		new Casa().chegada(entra);
	}
	
	void fechaPorta(Porta entra) {
		if(entra.aberta) {
			entra.aberta = false;
			System.out.println("Você fechou a porta!");
		}else {
			System.out.println("A porta já está fechada.");
		}
		new Casa().chegada(entra);
	}
	
	void trancaPorta(Porta entra) {
		if(entra.trancada) {
			System.out.println("A porta já está trancada!");
		}else if(entra.trancada == false && entra.aberta){
			System.out.println("Você precisa fechar a porta para tranca-la!");
		}else {
			entra.trancada = true;
			System.out.println("Você trancou a porta!");
		}
		new Casa().chegada(entra);
	}
	
	void destrancaPorta(Porta entra) {
		if(entra.trancada) {
			entra.trancada = false;
			System.out.println("Você destrancou a porta!");
		}else if(entra.aberta){
			System.out.println("A porta está aberta, portanto, não está trancada!");
		}else {
			System.out.println("A porta já está destrancada!");
		}
		new Casa().chegada(entra);
	}
	
	void pintaPorta(Porta entra) {
		System.out.println("A cor atual da porta é " + entra.cor + ". Deseja pinta-la de qual cor?");
		Scanner corNova = new Scanner(System.in);
		entra.cor = corNova.next();
		System.out.println("Sua porta agora é " + entra.cor + "!");
		new Casa().chegada(entra);
	}
}

class Casa{
	void chegada(Porta entra) {
		if(entra == null) {
			System.out.println("Você não tem uma porta, crie uma!");
			new Porta().criaPorta();
		}else {
			System.out.println("Você chegou em sua casa e avistou sua porta, o que fazer?");
			System.out.println("1 - Abrir a porta \n2 - Fechar a porta \n3 - Trancar a porta \n4 - Destrancar a porta \n5 - Pintar a porta \n6 - Entrar em casa");
			Scanner escolha = new Scanner(System.in);
			if(escolha.hasNext("1")) {
				new Porta().abrePorta(entra);
			}else if(escolha.hasNext("2")) {
				new Porta().fechaPorta(entra);
			}else if(escolha.hasNext("3")) {
				new Porta().trancaPorta(entra);
			}else if(escolha.hasNext("4")) {
				new Porta().destrancaPorta(entra);
			}else if(escolha.hasNext("5")) {
				new Porta().pintaPorta(entra);
			}else if(escolha.hasNext("6")) {
				new Casa().entrar(entra);
			}else {
				System.out.println("Opção inválida!");
				new Casa().chegada(entra);
			}
		}	
	}
	
	void entrar(Porta entra) {
		if(entra.aberta) {
			System.out.println("Você entrou! Bem vindo de volta ao seu lar!");
		}else {
			System.out.println("Você não abriu a porta!");
			new Casa().chegada(entra);
		}
	}
}