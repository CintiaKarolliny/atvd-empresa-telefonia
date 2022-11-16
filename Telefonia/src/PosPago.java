import java.util.*;

public class PosPago extends Assinante{

    private float assinatura;

    public PosPago(long cpf, String nome, Integer numero, float assinatura){
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }

    public void fazerChamada(Date data, Integer duracao){

        this.assinatura = duracao * 1.04f;

        this.chamadas[this.numChamadas -1] = new Chamada(data, duracao);

        this.numChamadas = this.numChamadas - 1;

        /*@Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            Chamada other = (Chamada) obj;
            return Objects.equals(data, other.data) && Objects.equals(duracao, other.duracao);
        }*/

    }

    public String imprimirFatura(int mes){

        //  este método deve ser utilizado para imprimir a fatura de
        //um assinante pós-pago em um mês dado por seu argumento. O método deve imprimir os
        //dados do assinante (CPF, nome e número do telefone), a data, duração e valor de suas
        //chamadas feitas no mês.Deve imprimirtambém o valortotal da fatura, que é a soma da
        //assinatura (atributo assinatura) com o custo de todas as ligações do mês.
        return "CPF: " + cpf + "\nNome: "+ nome + "\nNúmero de Telefone: " + numero;

    }
}
