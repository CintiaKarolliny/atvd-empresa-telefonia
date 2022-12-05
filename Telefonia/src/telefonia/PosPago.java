package telefonia;

import java.util.*;

public class PosPago extends Assinante {

    protected float assinatura;

    public PosPago(long cpf, String nome, long numero, Integer numChamadas, float assinatura) {
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
        int i = 0;

        while (i < chamadas.length) {
            if (chamadas[i] == null) {
                i++;
            } else {
                System.out.println("\n" + this.chamadas[i].toString());
                i++;
            }
        }
    }

    public void imprimirFatura(int mes) {

        GregorianCalendar dataCal = new GregorianCalendar();

        int i = 0;
        float totalChamada = 0;

        System.out.println("\nChamadas pós-pago: ");

        while (i < this.chamadas.length) {

            if (this.chamadas[i] != null) {
                dataCal.setTime(this.chamadas[i].getData());

                int mesCal = dataCal.get(Calendar.MONTH);

                if (mes == mesCal + 1) {

                    int duracao = this.chamadas[i].getDuracao();

                    totalChamada += Math.round((duracao * 1.04f)*100.0)/100.0;

                    System.out.println(this.chamadas[i].toString() + "\nValor da chamada: R$" + Math.round((duracao * 1.04f)*100.0)/100.0);

                    i++;
                } else {
                    i++;
                }
            } else {
                System.out.println("\nNão há chamadas para este mês");
                i++;
            }
        }

        System.out.println("\nTotal da assinatura: R$" + this.assinatura + "\nFatura total: R$" + totalChamada + "\n");
    }
}
