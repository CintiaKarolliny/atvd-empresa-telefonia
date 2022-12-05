import java.util.Date;
import java.lang.Math;

public class PrePago extends Assinante {
    private float creditos;
    private int numRecargas;

    private Recarga[] recargas;


    public PrePago(long cpf, String nome, int numero, int numRecargas, float creditos) {
        super(cpf, nome, numero, numRecargas);
        this.creditos = creditos;
        this.recargas = new Recarga[numRecargas];
        this.numRecargas = numRecargas;

        Recarga[] recargas = new Recarga[numRecargas];
    }

    public void recarregar(Date data, float valor) {
        if (numRecargas > 0) {
            this.recargas[this.numRecargas - 1] = new Recarga(data, valor);

            this.numRecargas = this.numRecargas - 1;
            this.creditos += valor;

            System.out.println("\nRecarga realizada! Valor atual: R$" + Math.round(this.creditos * 100.0) / 100.0);
        } else {
            System.out.println("\nNão é possível fazer mais recargas! ");
        }
    }

    public void fazerChamada(Date data, int duracao) {
        if (numChamadas > 0) {
            float creditosAtt = creditos - (duracao * 1.45f);

            if (creditosAtt > 0) {
                this.creditos = creditosAtt;
                this.chamadas[this.numChamadas - 1] = new Chamada(data, duracao);
                this.numChamadas = this.numChamadas - 1;

                System.out.println("\nChamada realizada!\nQuantidade de chamadas restantes: " + this.numChamadas + "\nQuantidade de créditos restantes: R$" + Math.round(this.creditos * 100.0) / 100.0);
            } else {
                System.out.println("\nCréditos insuficientes!");
            }
        } else {
            System.out.println("\nNão é possível fazer mais chamadas!");
        }
    }

    public void mostrarChamadas() {
        int i = 0;
        int cont = chamadas.length;

        while (i < chamadas.length) {
            System.out.println("\n" + cont + "ª chamada: " + this.chamadas[i]);
            i++;
            cont--;
        }
    }

    public void mostrarRecargas() {
        int i = 0;
        int cont = recargas.length;

        while (i < recargas.length) {
            System.out.println("\n" + cont + "ª recarga: " + this.recargas[i]);
            i++;
            cont--;
        }
    }

	/* public void imprimirFatura(int mes) {

		if (mes == getmesDataFormatada() + 1) {
			System.out.println("CPF: " + cpf + "\nNome: " + nome + "\nNúmero de Telefone: " + numero + "Chamadas: " + chamadas + "Crédito restante: " + creditos + "Quantidade de recargas feitas: " + numRecargas);
		}
		System.out.println("Não há faturas correspondentes a este mês!");

	} */
}
