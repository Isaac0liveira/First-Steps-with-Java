import java.util.Scanner;
public class schoolSystem{
	public static void main(String []args) {
		diretor diretor = new diretor();
		aluno aluno01 = new aluno();
		alunoLider aluno02 = new alunoLider();
		coordenador coordenador = new coordenador();
		professor professor = new professor();
		
		diretor.setSenha("14140500");
		diretor.setNome("Isaac");
		
		aluno01.setNota(7.6, 5.2, 8.0, 8.2);
		aluno01.setFrequencia(195);
		aluno01.setNome("Fernando");
		aluno01.setTurma("3°A");
		
		aluno02.setNota(7.0, 5.0, 7.6, 8.0);
		aluno02.setFrequencia(192);
		aluno02.setNome("Davi");
		aluno02.setTurma("3°D");
		aluno02.setAprovacao(21);
		
		professor.setFrequencia(198);
		professor.setNome("Brisolara");
		professor.setTurma(8);
		
		coordenador.setFrequencia(199);
		coordenador.setNome("Lucio");
		coordenador.setTurma(12);
		coordenador.setRendimento(true);
		
		System.out.println("Digite sua senha diretor: ");
		Scanner senha = new Scanner(System.in);
		if(senha.hasNext(diretor.getSenha())) {
			
			System.out.println("Bem vindo diretor " + diretor.getNome() + "!\n" + "\n---Alunos---");
			System.out.print("Aluno: " + aluno01.getNome() + " | Turma: " + aluno01.getTurma() + "\nSituação: ");
			diretor.setAprovado(aluno01);
			System.out.print("Aluno: " + aluno02.getNome() + " | Turma: " + aluno02.getTurma() + "\nSituação: ");
			diretor.setAprovado(aluno02);
			diretor.setAbono(professor);
			diretor.setRendimento(coordenador);
			diretor.setAbono(coordenador);
			
			System.out.println("\n---Funcionários---");
			System.out.println("Professor: " + professor.getNome() + "| Turmas: " + professor.getTurma()
			+ "| Salário: " + professor.getSalary());
			System.out.println("Coordenador: " + coordenador.getNome() + "| Turmas: " + coordenador.getTurma()
			+ "| Salário: " + coordenador.getSalary());
			
		}
		
	}
}

class aluno {
	private double nota1, nota2, nota3, nota4;
	protected double mediaFinal;
	private String nome, turma;
	private int frequencia;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	public String getTurma() {
		return this.turma;
	}
	
	public void setNota(double nota1, double nota2, double nota3, double nota4) {
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
	}
	
	public double getNota1() {
		return this.nota1;
	}
	
	public double getNota2() {
		return this.nota2;
	}
	
	public double getNota3() {
		return this.nota3;
	}
	
	public double getNota4() {
		return this.nota4;
	}
	
	public double getMedia(float media) {
		this.mediaFinal = ((this.getNota1() + this.getNota2() + this.getNota3() + this.getNota4()) / 4) + 1;
		return this.mediaFinal;
	}
	
	
	public double getMedia() {
		return (this.nota1 + this.nota2 + this.nota3 + this.nota4) / 4;
	}
	
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	
	public int getFrequencia() {
		return this.frequencia;
	}
}

class alunoLider extends aluno{
	private float aprovacaoTurma;
	
	void setAprovacao(float aprovacao) {
		this.aprovacaoTurma = aprovacao;
	}
	
	float getAprovacao() {
		return this.aprovacaoTurma;
	}
		
	@Override
	public double getMedia() {
		this.mediaFinal = ((this.getNota1() + this.getNota2() + this.getNota3() + this.getNota4()) / 4) + 1;
			if(this.aprovacaoTurma >= 30*0.70 && this.getFrequencia() >= 200*0.92) {
				this.mediaFinal += 1;
				return this.mediaFinal;
			}else {
				return this.mediaFinal;
			}
	}
}
class professor{
	protected int frequencia, turmas;
	protected double salario;
	protected String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getSalary() {
		this.salario = ((16 * turmas) * frequencia / 12);
		return this.salario;
	}
	
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	
	public int getFrequencia() {
		return this.frequencia;
	}
	
	public void setTurma(int turmas) {
		this.turmas = turmas;
	}
	
	public int getTurma() {
		return this.turmas;
	}
}

class coordenador extends professor{
	protected boolean bomRendimento;
	
	
	public void setRendimento(boolean rendimento) {
		this.bomRendimento = rendimento;
	}
	
	public boolean getRendimento() {
		return this.bomRendimento;
	}
	public double getSalary() {
		this.salario = ((16 * turmas) * frequencia / 12);
		if(this.getRendimento()) {
			this.salario += (this.salario * 0.05);
			return this.salario;
		}else {
			return this.salario;
		}
	}
}

class diretor{
	private String nome, senha;
	private boolean aprovado, rendimento;
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setAprovado(aluno aluno) {
		if(aluno.getMedia() >= 7 && aluno.getFrequencia() >= 200*0.70) {
			System.out.println("Aprovado");
			this.aprovado = true;
		}else if(aluno.getMedia() > 3 && aluno.getFrequencia() >= 200*0.70){
			System.out.println("Recuperação");
			this.aprovado = false;
		}else {
			System.out.println("Reprovado");
			this.aprovado = false;
		}
	}
	
	public void setRendimento(coordenador coordenador) {
		if(coordenador.getFrequencia() >= 200*0.95) {
			coordenador.setRendimento(true);
		}
	}
	
	public void setAbono(professor professor) {
		if(professor.getFrequencia() >= 200 * 0.98) {
			professor.salario = professor.getSalary() + (professor.getSalary() * 0.05);
		}
	}
}
