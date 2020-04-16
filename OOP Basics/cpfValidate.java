import java.util.Scanner;
public class validateCPF{
	
	public static void main(String[] args) {
		new teste().Menu();
	}
	
	void Menu() {
		CPF cpf = new CPF();
		System.out.println("Digite seu nome: ");
		Scanner nome = new Scanner(System.in);
		cpf.setTitular(nome.next());
		System.out.println("Digite seu endereço: ");
		Scanner endereco = new Scanner(System.in);
		cpf.setEndereco(endereco.next());
		System.out.println("Digite seu cpf: ");
		Scanner numCPF = new Scanner(System.in);
		cpf.setCPF(numCPF.next());
		System.out.println("Digite sua idade: ");
		Scanner idade = new Scanner(System.in);
		cpf.setIdade(idade.nextInt());
		if(cpf.validaCPF()) {
			System.out.println("Seu cpf foi validado!");
		}else {
			System.out.println("Seu cpf não foi validado! Tente novamente.");
			new teste().Menu();
		}
	}
}

class CPF {
	private String titular, endereco, cpf;
	private int idade;
	private boolean validade;
	
	boolean validaCPF() {
		if(this.cpf == "00000000000" || this.cpf == "11111111111" || this.cpf == "22222222222" || 
			this.cpf == "33333333333" || this.cpf == "44444444444" || this.cpf == "55555555555" ||
			this.cpf == "66666666666" || this.cpf == "77777777777" || this.cpf == "88888888888" || 
			this.cpf == "99999999999" || this.cpf == "" || this.cpf.length() < 11 || this.titular == ""
			|| this.idade < 8 || this.endereco == "") {
			return false;
		}else {
			return true;
		}
	}
	
	String getTitular() {
		return this.titular;
	}
	
	void setTitular(String titular) {
		this.titular = titular;
	}
	
	String getEndereco() {
		return this.endereco;
	}
	
	void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	String getCPF() {
		return this.cpf;
	}
	
	void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	int getIdade() {
		return this.idade;
	}
	
	void setIdade(int idade) {
		this.idade = idade;
	}
	
}