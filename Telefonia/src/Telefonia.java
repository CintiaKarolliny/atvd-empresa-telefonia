package Projeto;

import java.util.GregorianCalendar;
import java.util.*;

public class Telefonia {
	private PrePago[] prePagos = new PrePago[5];
	int numPrePagos = 0;
	
	private PosPago[] posPagos = new PosPago[5];
	int numPosPagos = 0;
	
	//Método cadastrarAssinante
	
    public void cadastrarAssinante( ) {
    	long cpf;
    	String nome;
    	int numero;
    	
        System.out.println("+==================================+");
        System.out.println("|01 - Pré-pago                     |");
        System.out.println("|02 - Pós-pago                     |");
        System.out.println("+==================================+");
        
        System.out.println("Olá, por favor escolha a assinatura que desejar!");
        Scanner assinatura = new Scanner(System.in);
        int tipoAssinatura = assinatura.nextInt();

        switch(tipoAssinatura){
            case 01:
            	if(numPrePagos >= prePagos.length) {
                	System.out.println("Atenção! Número de assinantes atingido.");
                	break;
            	}
            	
                System.out.println("Cadastro de pré-pago selecionado ");
                System.out.println("Entre com cpf do assinante: ");
                cpf = assinatura.nextLong();

                System.out.println("Entre com nome do assinante: ");
                nome = assinatura.next();

                System.out.println("Entre com número do assinante: ");
                numero = assinatura.nextInt();

                PrePago novoAssinantePre = new PrePago(cpf, nome, numero, 0, 0);
                
                
                prePagos[numPrePagos] = novoAssinantePre;
                numPrePagos += 1;
                System.out.println("Novo Assinante cadastrado: ");
                System.out.println(novoAssinantePre.toString());
                break;
                
            case 02:
            	if(numPosPagos >= posPagos.length) {
                	System.out.println("Atenção! Número de assinantes atingido.");
                	System.exit(0);
                }
            	
                System.out.println("Cadastro de pós-pago selecionado ");
                System.out.println("Entre com cpf do assinante: ");
                cpf = assinatura.nextLong();

                System.out.println("Entre com nome do assinante: ");
                nome = assinatura.next();

                System.out.println("Entre com número do assinante: ");
                numero = assinatura.nextInt();

                PosPago novoAssinantePos = new PosPago(cpf, nome, numero, 0, 0);
                posPagos[numPosPagos] = novoAssinantePos;
                numPosPagos += 1;
                System.out.println("Novo Assinante cadastrado: ");
                System.out.println(novoAssinantePos.toString());
                break;
                
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
	
    public void listarAssinantes( ) {
    	System.out.println("Listando assinantes");
    	System.out.println("Assinantes pré-pagos: ");
    	for(int i = 0; i < prePagos.length; i++) {
    		if(prePagos[i] == null) {
    			continue;
    		}
    		System.out.println(prePagos[i].toString());
    	}
    	System.out.println("Assinantes pós-pagos: ");
    	for(int i = 0; i < posPagos.length; i++) {
    		if(posPagos[i] == null) {
    			continue;
    		}
    		System.out.println(posPagos[i].toString());
    	}
    }
    
    public void fazerChamada ( ) {
    	long cpf;
    	
    	   System.out.println("+==================================+");
           System.out.println("|01 - Pré-pago                     |");
           System.out.println("|02 - Pós-pago                     |");
           System.out.println("+==================================+");
           
           System.out.println("Olá, por favor selecione a sua assinatura!");
           
    	Scanner indicar = new Scanner(System.in);
    	int tipoAssinatura = indicar.nextInt();
    	
    	switch(tipoAssinatura){
        case 1:
        	System.out.println("Cadastro de pré-pago selecionado ");
        	System.out.println("Por favor, insira seu CPF");
        	cpf = indicar.nextLong();
        break;
        	
        case 2:
        	System.out.println("Cadastro de pós-pago selecionado ");
        	System.out.println("Por favor, insira seu CPF");
        	cpf = indicar.nextLong();
        	
        break;
    	}	
    }
    
    public static void main(String[] args) {
        //Menu
        System.out.println("Por favor, selecione uma opção abaixo.");
        System.out.println("+==================================+");
        System.out.println("|               MENU               |");
        System.out.println("+==================================+");
        System.out.println("|01 - Cadastrar Assinante          |");
        System.out.println("|02 - Listar Assinantes            |");
        System.out.println("|03 - Fazer chamada                |");
        System.out.println("|04 - Fazer recarga                |");
        System.out.println("|05 - Imprimir faturas             |");
        System.out.println("|06 - Sair do programa             |");
        System.out.println("+==================================+");
        
    }
}