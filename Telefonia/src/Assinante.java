import java.util.ArrayList;

//!!!!!!!!ATRIBUTO CHAMADA ESTA INCORRETO!!!!!!!!!!!!!

public class Assinante {
	private long cpf;
	private String nome;
	private int numero; 
//	private int chamadas;
	protected int NumChamdas;
	
	public Assinante(long cpf, String nome, int numero) {
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero; 
	}
	
	public long getCpf() {
		return cpf;
	}

    @Override
	public String toString() {
    	return cpf + nome + numero; 
	}

	public static void main(String[] args) {
		Assinante teste = new Assinante();

	}

}
