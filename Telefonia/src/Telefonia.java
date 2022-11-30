import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.exit;

public class Telefonia {

    private static int numPrePagos;
    private int numPosPagos;
    private static PrePago[] prePagos = new PrePago[numPrePagos];
    private PosPago[] posPagos = new PosPago[numPosPagos];;

    public Telefonia(){

    }


	//Método cadastrarAssinante
	
    public void cadastrarAssinante() {

        boolean repetir = true;

        System.out.println("Digite a quantidade de assinantes pré-pagos a serem adicionados: ");
        Scanner entrada = new Scanner(System.in);
        int numPrePagos = entrada.nextInt();

        System.out.println("Digite a quantidade de assinantes pós-pagos a serem adicionados: ");
        int numPosPagos = entrada.nextInt();


        while (repetir) {

            System.out.println("\n+==================================+");
        System.out.println("|01 - Pré-pago                     |");
        System.out.println("|02 - Pós-pago                     |");
        System.out.println("+==================================+");
        
        System.out.print("\nDigite uma das opções acima: ");


            int tipoAssinatura = entrada.nextInt();

            switch (tipoAssinatura) {
                case 1:

                    System.out.println("\nCADASTRO PRÉ-PAGO SELECIONADO");
                    System.out.println("\nDigite o CPF: ");
                    long cpfPre = entrada.nextLong();

                    System.out.println("Digite o nome: ");
                    String nomePre = entrada.next();

                    System.out.println("Digite o telefone: ");
                    int numeroPre = entrada.nextInt();

                    System.out.println("Digite a quantidade de recargas que poderão ser feitas: ");
                    int numRecargas = entrada.nextInt();

                    System.out.println("Digite a quantidade de créditos existentes: ");
                    int creditos = entrada.nextInt();

                    this.prePagos[this.numPrePagos - 1] = new PrePago(cpfPre, nomePre, numeroPre, numRecargas, creditos);

                    this.numPrePagos--;

                    System.out.println("Assinante Cadastrado!\n");

                    repetir = false;

                    break;

                case 2:

                    System.out.println("\nCADASTRO PÓS-PAGO SELECIONADO");
                    System.out.println("\nDigite o CPF: ");
                    long cpfPos = entrada.nextLong();

                    System.out.println("\nDigite o nome: ");
                    String nomePos = entrada.next();

                    System.out.println("\nDigite o telefone: ");
                    int numeroPos = entrada.nextInt();

                    System.out.println("\nDigite a quantidade de chamadas que poderão ser feitas: ");
                    int numChamadas = entrada.nextInt();

                    System.out.println("\nDigite o valor do contrato: ");
                    int assinatura = entrada.nextInt();

                    this.posPagos[this.numPosPagos - 1] = new PosPago(cpfPos, nomePos, numeroPos, numChamadas, assinatura);
                    this.numPosPagos--;

                    System.out.println("\nAssinante cadastrado!\n");

                    repetir = false;

                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente...");

                    break;
            }
        }
    }
	
    public void listarAssinantes() {
    	System.out.println("\nOpção Selecionada: Listar Assinantes");

        int contPre = 0;
        int contPos = 0;

        System.out.println("\nAssinantes pré-pagos: \n");

        while (contPre < prePagos.length) {

            System.out.println(contPre + "º assinante: " + this.prePagos[contPre]);

            }

    	System.out.println("\nAssinantes pós-pagos: ");

    	 while (contPos < posPagos.length) {
             System.out.println(contPos + "º assinante: " + this.posPagos[contPos]);
    	}
    }
    
    public static void fazerChamada() throws ParseException {

        boolean voltar = true;

        while (voltar) {
    	   System.out.println("+==================================+");
           System.out.println("|01 - Pré-pago                     |");
           System.out.println("|02 - Pós-pago                     |");
           System.out.println("+==================================+");
           
           System.out.println("Olá, por favor selecione a sua assinatura!");
           
    	Scanner entrada = new Scanner(System.in);
    	int tipoAssinatura = entrada.nextInt();
    	
    	switch(tipoAssinatura) {
            case 1:
                System.out.println("\nPLANO PRÉ-PAGO SELECIONADO");
                System.out.print("\nDigite o CPF: ");
                long cpfPre = entrada.nextLong();

                for (PrePago assinante : prePagos) {
                    if (assinante.getCpf() == cpfPre) {
                        System.out.println("\nDigite a data da chamada: ");
                        String datastr = entrada.next();

                        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
                        Date data = formatar.parse(datastr);
                        System.out.println(formatar.format(data));

                        System.out.print("Agora a duração: ");
                        int duracao = entrada.nextInt();

                        assinante.fazerChamada(data, duracao);

                        assinante.mostrarChamadas();

                        voltar = false;
                    }
                }
                break;

            case 2:
                System.out.println("\nPLANO PÓS-PAGO SELECIONADO");
                System.out.print("\nDigite o CPF: ");
                long cpfPos = entrada.nextLong();

                for (PosPago item : posPagos) {
                    if (item.getCpf() == cpfPos) {
                        System.out.println("\nDigite a data da chamada: ");
                        String datastr = entrada.next();

                        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
                        Date data = formatar.parse(datastr);
                        System.out.println(formatar.format(data));

                        System.out.print("Agora a duração: ");
                        int duracao = entrada.nextInt();

                        item.fazerChamada(data, duracao);
                        voltar = false;
                    }
                }
            default:
                System.out.println("Opção Inválida!. Tente novamente");
                break;
        }
    	}	
    }

    public static PrePago localizarPrePago(long cpf) {

        System.out.print("\nDigite o CPF: ");
        Scanner entrada = new Scanner(System.in);
        cpf = entrada.nextLong();

        for (PrePago assinante : prePagos) {
            if (assinante.getCpf() == cpf) {

                System.out.println("teste");

            }
        }

        return
            }

    public static void fazerRecarga() throws ParseException{

        boolean voltar = true;

        while (voltar) {
            System.out.println("+==================================+");
            System.out.println("|01 - Pré-pago                     |");
            System.out.println("|02 - Pós-pago                     |");
            System.out.println("+==================================+");

            System.out.println("Olá, por favor selecione a sua assinatura!");

            Scanner entrada = new Scanner(System.in);
            int tipoAssinatura = entrada.nextInt();

            switch(tipoAssinatura) {
                case 1:

    }
    
    public static void main(String[] args) throws ParseException {
        //Menu

        boolean continuar = true;

        while (continuar) {

            System.out.println("\n+==================================+");
            System.out.println("|               MENU               |");
            System.out.println("+==================================+");
            System.out.println("|01 - Cadastrar Assinante          |");
            System.out.println("|02 - Listar Assinantes            |");
            System.out.println("|03 - Fazer chamada                |");
            System.out.println("|04 - Fazer recarga                |");
            System.out.println("|05 - Imprimir faturas             |");
            System.out.println("|06 - Sair do programa             |");
            System.out.println("+==================================+");

            System.out.print("\nPor favor, selecione uma opção acima: ");

            Scanner entrada2 = new Scanner(System.in);
            int opcao = entrada2.nextInt();

            switch (opcao) {

                case 1:
                    cadastrarAssinante();
                    break;

                case 2:
                    listarAssinantes();
                    break;

                case 3:
                    fazerChamada();
                    break;

                case 4:
                    //fazerRecarga();
                    break;

                case 5:
                    //imprimirFatura();
                    break;

                case 6:
                    System.out.println("Finalizando programa...");
                    exit(0);

                default:
                    System.out.println("Opção Inválida! Tente novamente...");
                    break;
            }
        }
    }
}