import java.util.*;

public class PosPago extends Assinante {

    private float assinatura;

    public PosPago(long cpf, String nome, Integer numero, Integer numChamadas, float assinatura) {
        super(cpf, nome, numero, numChamadas);
        this.assinatura = assinatura;
    }

    public void fazerChamada(Date data, Integer duracao) {

        if (numChamadas > 0) {

            this.assinatura += duracao * 1.04f;

            this.chamadas[this.numChamadas - 1] = new Chamada(data, duracao);

            this.numChamadas = this.numChamadas - 1;

            System.out.println("\nChamada realizada!\nQuantidade de chamadas restantes: " + this.numChamadas);
        } else {
            System.out.println("\nNão é possível fazer mais chamadas!");
        }
    }

    public void mostrarChamadas() {
        Integer i = 0;
        Integer cont = 1;

        while (i < chamadas.length) {
            System.out.println("\n" + cont + "ª chamada: " + this.chamadas[i]);
            i++;
            cont++;
        }
    }

    /*public String imprimirFatura(int mes) {

        if (mes == getmesDataFormatada() + 1) {
            return "CPF: " + cpf + "\nNome: " + nome + "\nNúmero de Telefone: " + numero + "Chamadas: " + chamadas + "Total pago: " + assinatura;
        }
        return "Não há faturas correspondentes a este mês!";
    }*/
}
