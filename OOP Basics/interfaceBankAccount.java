public class interfaceBankAccount{
	
	public static void main(String[] args) {
		ClienteCorrente cliente01 = new ClienteCorrente();
		ClientePoupanca cliente02 = new ClientePoupanca();
		Gerente gerente = new Gerente();
		Banqueiro dono = new Banqueiro();
		dono.concedeAutoriza(gerente);
		
		gerente.setNome("Carlos", cliente01, gerente.autoriza);
		gerente.setNome("Maria", cliente02, gerente.autoriza);
		gerente.setCPF("62403308586", cliente01, gerente.autoriza);
		gerente.setCPF("03662503345", cliente02, gerente.autoriza);
		
		cliente01.deposita(500);
		cliente02.deposita(1200);
		cliente01.saca(300);
		cliente02.saca(500);
	}
	
}

interface Cliente{
	
	public void saca(double quantia);
	public void deposita(double quantia);
	public boolean disponivel(double quantia);
	
}

interface Gerencia{
	public void setNome(String nome, ClienteComum cliente, boolean autoriza);
	public String getNome(ClienteComum cliente, boolean autoriza);
	public void setCPF(String cpf, ClienteComum cliente, boolean autoriza);
	public String getCPF(ClienteComum cliente, boolean autoriza);
}

abstract class ClienteComum{
	protected String nome, cpf;
	protected double saldo;
}

abstract class Funcionario extends ClienteComum{
	protected boolean autoriza;
}

class ClientePoupanca extends ClienteComum implements Cliente{
	
	public void saca(double quantia) {
		if(this.disponivel(quantia)){
			System.out.println(this.nome + ", sua poupança lhe rendeu " + (this.saldo * 0.0010) + " reais.");
			this.saldo = (this.saldo * 1.0010) - quantia;
			System.out.println(this.nome + ", seu saque foi realizado com sucesso! Seu saldo atual é de " + this.saldo);
		}else {
			System.out.println("Saque não realizado!");
		}
	}
	
	public void deposita(double quantia) {
		if(quantia > 3000) {
			System.out.println("O limite de depósito é de 3000!");
		}else {
			this.saldo += quantia;
			System.out.println(this.nome + "| CPF: " + this.cpf + " | Depósito feito com sucesso!");
		}
	}
	
	public boolean disponivel(double quantia) {
		if((this.saldo - quantia) < 0) {
			return false;
		}else {
			return true;
		}
	}
}

class ClienteCorrente extends ClienteComum implements Cliente{
	
	public void saca(double quantia) {
		if(this.disponivel(quantia)) {
			this.saldo -= quantia;
			System.out.println(this.nome + ", seu saque foi realizado com sucesso! Seu saldo atual é de " + this.saldo);
		}else {
			System.out.println("Saque não realizado!");
		}
	}
	
	public void deposita(double quantia) {
		if(quantia >= 5000) {
			System.out.println("O limite de depósito é de 5000!");
		}else {
			this.saldo += quantia;
			System.out.println(this.nome + "| CPF: " + this.cpf + " | Depósito feito com sucesso!");
		}
	}
	
	public boolean disponivel(double quantia) {
		if((this.saldo - quantia) < 0 || quantia > 5000){
			return false;
		}else {
			return true;
		}
	}	
}

class Gerente extends Funcionario implements Gerencia{
	
	public void setNome(String nome, ClienteComum cliente, boolean autoriza) {
		if(autoriza) {
			cliente.nome = nome;
		}else {
			System.out.println("Você não tem autorização para esta operação!");
		}
	}
	
	public String getNome(ClienteComum cliente, boolean autoriza) {
		if(autoriza) {
			return cliente.nome;
		}else {
			return("Você não tem autorização para esta operação!");
		}
	}
	
	public void setCPF(String cpf, ClienteComum cliente, boolean autoriza) {
		if(autoriza) {
			cliente.cpf = cpf;
		}else {
			System.out.println("Você não tem autorização para esta operação!");
		}
	}
	
	public String getCPF(ClienteComum cliente, boolean autoriza) {
		if(autoriza) {
			return cliente.cpf;
		}else {
			return("Você não tem autorização para esta operação!");
		}
	}
}

class Banqueiro extends Gerente{
	public void concedeAutoriza(Funcionario funcionario) {
		funcionario.autoriza = true;
	}
}