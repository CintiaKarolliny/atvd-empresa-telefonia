package telefonia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.exit;

public class Telefonia {

    private int numPrePagos;
    private int numPosPagos;
    private PrePago[] prePagos;
    private PosPago[] posPagos;

    public Telefonia(int numPosPagos, int numPrepagos) {

        this.numPrePagos = numPrepagos;
        this.numPosPagos = numPosPagos;

        this.prePagos = new PrePago[numPrePagos];
        this.posPagos = new PosPago[numPosPagos];

    }

    // iterando e retornando os índices de prePagos
    private PrePago localizarPrePago(long cpf) {

        int contPre = 0;

        while (contPre < prePagos.length) {

            if (this.prePagos[contPre] != null && cpf == this.prePagos[contPre].getCpf()) {
                return this.prePagos[contPre];
            }
            contPre++;
        }
        return null;

    }

    // iterando e retornando os índices de posPagos

    private PosPago localizarPosPago(long cpf) {

        int contPos = 0;

        while (contPos < posPagos.length) {

            if (this.posPagos[contPos] != null && cpf == this.posPagos[contPos].getCpf()) {
                return this.posPagos[contPos];
            }
            contPos++;
        }
        return null;

    }

    //Método cadastrarAssinante

    public void cadastrarAssinante() {


        System.out.println("\n+==================================+");
        System.out.println("|01 - Pré-pago                     |");
        System.out.println("|02 - Pós-pago                     |");
        System.out.println("+==================================+");

        System.out.print("\nDigite uma das opções acima: ");

        Scanner entrada = new Scanner(System.in);

        int tipoAssinatura = entrada.nextInt();

        switch (tipoAssinatura) {
            case 1:

                //o cadastro só funciona se não for atingido o limite inserido pelo usuário

                if (numPrePagos > 0) {

                    System.out.println("\nCADASTRO PRÉ-PAGO SELECIONADO");
                    System.out.print("\nDigite o CPF: ");
                    long cpfPre = entrada.nextLong();

                    //verificando se o cpf já está cadastrado

                    if (localizarPrePago(cpfPre) == null) {

                        entrada.nextLine();
                        System.out.print("Digite o nome: ");
                        String nomePre = entrada.nextLine();

                        System.out.print("Digite o telefone: ");
                        long numeroPre = entrada.nextLong();

                        System.out.print("Digite a quantidade de recargas que poderão ser feitas: ");
                        int numRecargas = entrada.nextInt();

                        System.out.print("Digite a quantidade de créditos existentes: ");
                        int creditos = entrada.nextInt();

                        System.out.print("Digite a quantidade de chamadas possíveis: ");
                        int numChamadas = entrada.nextInt();

                        //objeto do tipo PrePago criado com as informações inseridas acima

                        PrePago assPre = new PrePago(cpfPre, nomePre, numeroPre, numRecargas, creditos);

                        //inserindo os assinantes de trás p frente no vetor

                        this.prePagos[this.numPrePagos - 1] = assPre;

                        this.numPrePagos = this.numPrePagos - 1;

                        System.out.println("\nAssinante Cadastrado!\n");
                    } else {
                        System.out.println("Cpf já cadastrado");
                    }
                } else {
                    System.out.println("\nNão há como cadastrar mais assinantes pré-pago!");
                }

                break;

            case 2:

                //o cadastro só funciona se não for atingido o limite inserido pelo usuário

                if (numPosPagos > 0) {
                    System.out.println("\nCADASTRO PÓS-PAGO SELECIONADO");
                    System.out.print("\nDigite o CPF: ");
                    long cpfPos = entrada.nextLong();

                    //verificando se o cpf já está cadastrado

                    if (localizarPrePago(cpfPos) == null) {

                        entrada.nextLine();
                        System.out.print("Digite o nome: ");
                        String nomePos = entrada.next();

                        System.out.print("Digite o telefone: ");
                        long numeroPos = entrada.nextLong();

                        System.out.print("Digite a quantidade de chamadas que poderão ser feitas: ");
                        int numChamadas = entrada.nextInt();

                        System.out.print("Digite o valor atual da fatura total: ");
                        int assinatura = entrada.nextInt();

                        //objeto do tipo PosPago criado com as informações inseridas acima

                        PosPago assPos = new PosPago(cpfPos, nomePos, numeroPos, numChamadas, assinatura);

                        //inserindo os assinantes de trás p frente no vetor

                        this.posPagos[this.numPosPagos - 1] = assPos;
                        this.numPosPagos = this.numPosPagos - 1;

                        System.out.println("\nAssinante cadastrado!\n");
                    } else {
                        System.out.println("Cpf já cadastrado");
                    }
                } else {
                    System.out.println("\nNão há como cadastrar mais assinantes pós-pago!");
                }
                break;

            default:
                System.out.println("\nOpção inválida! Tente novamente...");

                break;
        }
    }

    public void listarAssinantes() {

        //variáveis que listam os assinantes

        int contPre = 0;
        int contPos = 0;

        //variáveis que recebem a quantidade de usuários cadastrados

        int preCad = 0;
        int posCad = 0;

        System.out.println("\nAssinantes pré-pagos: \n");

        //loop que itera o vetor de assinantes pré-pagos e o lista

        while (contPre < prePagos.length) {

            if (prePagos[contPre] == null) {

                contPre++;

            } else {
                System.out.println("* Assinante = " + this.prePagos[contPre].toString());
                contPre++;
                preCad++;

            }
        }

        if (preCad == 0) {
            System.out.println("Não há cadastrados");
        }

        System.out.println("\nAssinantes pós-pagos: \n");

//loop que itera o vetor de assinantes pós-pagos e o lista

        while (contPos < posPagos.length) {

            if (posPagos[contPos] == null) {

                contPos++;

            } else {

                System.out.println("* Assinante = " + this.posPagos[contPos].toString());
                contPos++;
                posCad++;
            }
        }

        if (posCad == 0) {
            System.out.println("Não há cadastrados");
        }
    }

    public void fazerChamada() throws ParseException {

        System.out.println("\n+==================================+");
        System.out.println("|01 - Pré-pago                     |");
        System.out.println("|02 - Pós-pago                     |");
        System.out.println("+==================================+");

        System.out.print("\nDigite uma das opções acima: ");

        Scanner entrada = new Scanner(System.in);
        int tipoAssinatura = entrada.nextInt();

        switch (tipoAssinatura) {
            case 1:

                System.out.println("\nPLANO PRÉ-PAGO SELECIONADO");

                //tamanho do vetor = assinantes cadastrados

                if (prePagos.length == 0) {
                    System.out.println("\nNão há assinantes pré-pago cadastrados");
                } else {

                    System.out.print("\nDigite o CPF: ");

                    long cpfPre = entrada.nextLong();

                    //verificando se o cpf já está cadastrado

                    if (this.localizarPrePago(cpfPre) != null) {

                        PrePago pre = this.localizarPrePago(cpfPre);

                        System.out.println(this.localizarPrePago(cpfPre));
                        System.out.print("\nDigite a data da chamada: (dia/mes/ano) ");
                        String datastr = entrada.next();

                        //formatando a data no estilo dia/mês/ano

                        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
                        Date data = formatar.parse(datastr);

                        System.out.print("Agora a duração: ");
                        int duracao = entrada.nextInt();

                        //acessando métodos da classe PrePago

                        pre.fazerChamada(data, duracao);

                        pre.mostrarChamadas();

                    } else {
                        System.out.println("\nNão há assinantes cadastrados com esse cpf.\n");

                    }
                }

                break;

            case 2:
                System.out.println("\nPLANO PÓS-PAGO SELECIONADO");

                //tamanho do vetor = assinantes cadastrados

                if (posPagos.length == 0) {
                    System.out.println("\nNão há assinantes pré-pago cadastrados");
                } else {


                    System.out.print("\nDigite o CPF: ");
                    long cpf = entrada.nextLong();

                    //verificando se o cpf já está cadastrado

                    if (this.localizarPosPago(cpf) != null) {

                        PosPago pos = this.localizarPosPago(cpf);
                        System.out.println(pos);
                        System.out.print("\nDigite a data da chamada: (dia/mes/ano) ");
                        String datas = entrada.next();

                        //formatando a data no estilo dia/mês/ano

                        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataPos = formatar.parse(datas);

                        System.out.print("Agora a duração: ");
                        int duracaoPos = entrada.nextInt();

                        //acessando métodos da classe PosPago

                        pos.fazerChamada(dataPos, duracaoPos);

                        pos.mostrarChamadas();

                    } else {
                        System.out.println("\nNão há assinantes cadastrados com esse cpf.\n");
                    }
                }
                break;


            default:
                System.out.println("\nOpção Inválida!. Tente novamente");
                break;
        }
    }

    public void fazerRecarga() throws ParseException {

        //tamanho do vetor = assinantes cadastrados

        if (prePagos.length == 0) {
            System.out.println("\nNão há assinantes pré-pago cadastrados");
        } else {

            System.out.print("\nDigite o CPF: ");
            Scanner entrada = new Scanner(System.in);
            long cpfPre = entrada.nextLong();

            //verificando se o cpf já está cadastrado

            if (this.localizarPrePago(cpfPre) != null) {

                PrePago pre = this.localizarPrePago(cpfPre);
                System.out.println(pre);

                System.out.print("\nDigite a data da recarga: (dia/mes/ano) ");
                String datas = entrada.next();

                //formatando a data no estilo dia/mês/ano

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dataRec = format.parse(datas);

                System.out.print("Agora a quantidade de créditos para recarregar: ");
                int quantidadeRec = entrada.nextInt();

                //acessando métodos da classe PrePago

                pre.recarregar(dataRec, quantidadeRec);

                pre.mostrarRecargas();

            } else {
                System.out.println("\nNão há assinantes cadastrados com esse cpf");
            }
        }
    }

    public void imprimirFaturas() {

        //variáveis que listam os assinantes cadstrados

        int contPre = 0;
        int contPos = 0;

        //tamanho do vetor = assinantes cadastrados

        if (prePagos.length == 0) {
            System.out.println("\nConsidere cadastrar um assinante pré-pago antes");
        }

        if (posPagos.length == 0) {
            System.out.println("\nConsidere cadastrar um assinante pós-pago antes");
        } else {
            System.out.println("\nPara ver as faturas de um determinando mês,");

            System.out.print("digite o mês: ");
            Scanner entrada = new Scanner(System.in);

            //entrando com mês para ver suas respectivas faturas

            int mes = entrada.nextInt();

            System.out.println();

            // iterando o vetor de assinantes pré-pagos cadastrados

            while (contPre < this.prePagos.length) {

                if (this.prePagos[contPre] != null) {

                    if (this.prePagos[contPre].numChamadas < 0) {
                        System.out.println("\nEsse assinante não realizou chamadas!");
                        contPre++;
                    } else {

                        System.out.println("\nAssinantes pré-pago: \n");

                        //printando as informações do assinante, suas chamadas e recargas com seus dados

                        System.out.println(this.prePagos[contPre].toString() + "\n");
                        this.prePagos[contPre].imprimirFatura(mes);

                        contPre++;
                    }
                } else {
                    System.out.println("Não há faturas pré-pago para este mês");
                    contPre++;
                }
            }

            // iterando o vetor de assinantes pós-pagos cadastrados

            while (contPos < this.posPagos.length) {

                if (this.posPagos[contPos] != null) {

                    if (this.posPagos[contPos].numChamadas < 0) {
                        System.out.println("\nEsse assinante não realizou chamadas!");
                        contPos++;
                    } else {

                        System.out.println("\nAssinantes pós-pago: \n");

                        //printando as informações do assinante, suas chamadas com seus dados

                        System.out.println(this.posPagos[contPos].toString() + "\n");
                        this.posPagos[contPos].imprimirFatura(mes);
                        contPos++;
                    }
                } else {
                    System.out.println("\nNão há faturas pós-pago para este mês");
                    contPos++;
                }
            }
        }
    }


    public static void main(String[] args) throws ParseException {
        //Menu

        //variáveis que garantem o funcionamento dos loops

        boolean continuar = true;
        boolean voltar = true;

        //variáveis que recebem o limite de assinantes cadastráveis

        int numPre = 0;
        int numPos = 0;

        while (voltar) {
            System.out.print("\nQual o limite de assinantes pré-pagos cadastrados? ");
            Scanner entrada = new Scanner(System.in);
            numPre = entrada.nextInt();

            System.out.print("Qual o limite de assinantes pós-pagos cadastrados? ");
            numPos = entrada.nextInt();

            //validando a quantidade de assinantes

            if (numPre < 0 || numPos < 0) {
                System.out.println("\nNúmero negativo não é aceito!");
                voltar = true;
            } else {
                voltar = false;
            }

        }

        //objeto do tipo Telefonia criado e instanciado com os dados recebidos acima

        Telefonia tel = new Telefonia(numPos, numPre);

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

            System.out.print("\nDigite uma opção acima: ");

            Scanner entrada2 = new Scanner(System.in);
            int opcao = entrada2.nextInt();

            switch (opcao) {

                case 1:
                    tel.cadastrarAssinante();
//
                    break;

                case 2:
                    tel.listarAssinantes();
                    break;

                case 3:
                    tel.fazerChamada();

                    break;

                case 4:
                    tel.fazerRecarga();

                    break;

                case 5:
                    tel.imprimirFaturas();

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
