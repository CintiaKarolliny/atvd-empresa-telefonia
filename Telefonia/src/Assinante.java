import java.util.Arrays;

public abstract class Assinante {
	protected long cpf;
	protected String nome;
	protected Integer numero;

	protected Chamada[] chamadas;

	protected Integer numChamadas;
	
	public Assinante(long cpf, String nome, Integer numero, Integer numChamadas) {
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;

		this.numChamadas = numero;
		this.chamadas = new Chamada[numero];

		Chamada[] chamadas = new Chamada[numChamadas];

/*		for (int i = 0; i < chamadas.length; i++) {
			chamadas[i] = new Chamada();
			System.out.println(chamadas[i]);
		} */
	}
	
	public long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public Chamada[] getChamadas() {
		return chamadas;
	}

	public Integer getNumChamadas() {
		return numChamadas;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setChamadas(Chamada[] chamadas) {
		this.chamadas = chamadas;
	}

	public void setNumChamadas(Integer numChamadas) {
		this.numChamadas = numChamadas;
	}

	@Override
	public String toString() {
    	return "CPF: " cpf + "/nNome: " + nome + "/nNúmero: " + numero + "/nNúmero de chamadas: " + numChamadas + Arrays.toString(chamadas);
	}

	/* public static void main(String[] args) {
		Assinante teste = new Assinante(481545058,"Cíntia", 2);

	}*/

}
