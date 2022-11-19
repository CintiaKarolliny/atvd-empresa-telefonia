import java.util.GregorianCalendar;
import java.util.*;

public class Telefonia {

    public static void main(String[] args) {

        // Começo Estruturação Menu

        Scanner entrada = new Scanner(System.in);

        int opcao = entrada.nextInt();

        System.out.println(opcao);

        while (opcao > 0) {

            switch (opcao) {
                case 1:
                    System.out.println("\nNUMERO 1 AQ");
                    break;
                case 2:
                    System.out.println("\nNUMERO 2 AQ");
                    break;
                case 3:
                    System.out.println("\nNUMERO 3 AQ");
                    break;
                default:
                    System.out.println("\nERRO AQ");
                    break;

            }
        }
        System.out.println("Opção Inválida! Tente Novamente");

        Scanner entrada2 = new Scanner(System.in);
        int opcao = entrada2.nextInt();

        // ******** Testes cadastro de assinante PréPago

        System.out.println("\nCadastro de Assinantes: ");

        System.out.println("\nInsira o CPF: ");
        Scanner entradaCPF = new Scanner(System.in);

        long cpf = entradaCPF.nextLong();

        System.out.println("\nInsira o nome: ");
        Scanner entradaNome = new Scanner(System.in);

        String nome = entradaNome.next();

        System.out.println("\nInsira o número: ");
        Scanner entradaNumero = new Scanner(System.in);

        Integer numero = entradaNumero.nextInt();

        PrePago pre1 = new PrePago(cpf, nome, numero);

        System.out.println(pre1.getCpf());

        System.out.println(pre1.getNome());

        System.out.println(pre1.getNumero());

        // ******** Teste fazerChamada PréPago

        System.out.print("\nEntre com a data (ddmmaaaa): ");
        Scanner entradaData1 = new Scanner(System.in);
        Integer data = entradaData1.nextInt();

        System.out.print("\nEntre com a duração em minutos: ");
        Scanner entradaDuracao1 = new Scanner(System.in);
        Integer duracao = entradaData1.nextInt();

        // ******** Testes Chamada

        GregorianCalendar ca = new GregorianCalendar();
        ca.set(2018, GregorianCalendar.DECEMBER, 12);

        GregorianCalendar ca2 = new GregorianCalendar();
        ca2.set(2020, GregorianCalendar.APRIL, 3);

        Chamada chamada1 = new Chamada(ca.getTime(), 50);
        Chamada chamada2 = new Chamada(ca2.getTime(), 30);

        Set<Chamada> chamadas = new HashSet<>();

        chamadas.add(chamada1);
        chamadas.add(chamada2);

        System.out.print(chamadas);
    }
}
