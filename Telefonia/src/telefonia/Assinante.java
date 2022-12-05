package telefonia;

public abstract class Assinante {
	private long cpf;
	private String nome;
	private long numero;

	protected Chamada[] chamadas;

	protected Integer numChamadas;

	public Assinante(long cpf, String nome, long numero, Integer numChamadas) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;

		this.chamadas = new Chamada[numChamadas];
		this.numChamadas = numChamadas;

	}
	
	public long getCpf() {
		return this.cpf;
	}

	@Override
	public String toString() {
    	return "CPF: " + cpf + " | Nome: " + nome + " | Telefone: " + numero;
	}


}
