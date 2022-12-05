package telefonia;

import java.util.Calendar;
import java.util.Date;
import java.lang.Math;
import java.util.GregorianCalendar;

public class PrePago extends Assinante {
    protected float creditos;
    private int numRecargas;

    private Recarga[] recargas;


    public PrePago(long cpf, String nome, long numero, int numRecargas, float creditos) {
        super(cpf, nome, numero, numRecargas);
        this.creditos = creditos;

        this.recargas = new Recarga[numRecargas];
        this.numRecargas = numRecargas;
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
                System.out.println("\nCréditos insuficientes!\nVocê possui R$" + creditos + ", enquanto esta chamada usaria R$" + duracao*1.45f);
            }
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

    public void mostrarRecargas() {
        int i = 0;

        while (i < recargas.length) {
            if (recargas[i] == null) {
                i++;
            } else {
                System.out.println("\n" + this.recargas[i].toString());
                i++;
            }
        }
    }

    public void imprimirFatura(int mes) {

        GregorianCalendar dataCal = new GregorianCalendar();

        int i = 0;
        int cont = 0;

        float totalChamada = 0;
        float totalRecarga = 0;

        while (i < this.chamadas.length) {

            if (this.chamadas[i] != null) {
                dataCal.setTime(this.chamadas[i].getData());

                int mesCal = dataCal.get(Calendar.MONTH);

                if (mes == mesCal + 1) {

                    int duracao = this.chamadas[i].getDuracao();

                    totalChamada += ((duracao * 1.45f)*100.0)/100.0;

                    System.out.println(this.chamadas[i].toString() + "\nValor da chamada: R$" + Math.round((duracao * 1.45f)*100.0)/100.0);

                    i++;
                } else {
                    i++;
                }

            } else {
                System.out.println("\nNão há chamadas para este mês!");
                i++;
            }
        }

        System.out.println("\nFatura total das chamadas: R$" + totalChamada);

        System.out.println("\n");

        while (cont < this.recargas.length) {

        if (this.recargas[cont] == null) {
            cont++;
        } else {
                int mesCal = dataCal.get(Calendar.MONTH);

                if (mes == mesCal + 1) {

                    totalRecarga += this.recargas[cont].getValor();

                    System.out.println(this.recargas[cont].toString());
                    cont++;
                } else {
                    System.out.println("\nNão há recargas para este mês");
                    cont++;
                }

            }

        }

        System.out.println("\nValor total das recargas: R$" + Math.round((totalRecarga*100.0)/100.0) + "\nTotal de Créditos: R$" + Math.round(this.creditos*100.0)/100.0);

    }

}
