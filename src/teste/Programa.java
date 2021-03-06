package teste;

import java.util.Scanner;

import estruturas.FilaPedidos;
import estruturas.PilhaEntregador;
import estruturas.PilhaReclamacao;

public class Programa {

	private static final Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		PilhaReclamacao<String> pilhaReclamacao = new PilhaReclamacao<>(1);
		FilaPedidos<String> filaPedido = new FilaPedidos<>(1);
		PilhaEntregador<String> pilhaEntregador = new PilhaEntregador<>(1);

		int altern = 0;

		System.out.println("Informe quantos entregadores a no restaurante");
		int entregador = teclado.nextInt();
		for (int cont = 0; cont < entregador; cont++) {
			pilhaEntregador.empilha("Entregador");
		}
		
		do {
			System.out.println("1-Escolher o pedido");
			System.out.println("2-Sair para a entrega");
			System.out.println("3-Voltou entregador");
			System.out.println("4-Deseja fazer reclama��es ou sugest�es");
			System.out.println("5-Ver sugest�es e reclama��o");
			System.out.println("6-Ver lista de pedidos");
			System.out.println("7-Sair");
			altern = teclado.nextInt();
			switch (altern) {
			case 1: {
				String finalPedido = escolhaPedido();
				filaPedido.enfileira(finalPedido);
			}
				break;
			case 2:
				if (!filaPedido.estaVazia()) {
					if (!pilhaEntregador.estaVazia()) {
						filaPedido.desenfileira();
						pilhaEntregador.desempilha();
					} else {
						System.out.println("N�o a entregadores para fazer a entrega");
					}
				} else {
					System.out.println("N�o a pedidos para serem entregues");
				}
				break;
			case 3:
				pilhaEntregador.empilha("Entregador");
				break;
			case 4:
				System.out.println("Informe seu nome");
				teclado.nextLine();
				String nomeSR = teclado.nextLine();
				System.out.println("Informe sua reclama��o ou sujest�es");
				String reclamaSujestao = teclado.nextLine();
				String melhoria = nomeSR + ": " + reclamaSujestao;
				pilhaReclamacao.empilha(melhoria);
				break;
			case 5:
				System.out.println(pilhaReclamacao.toString());
				break;
			case 6:
				System.out.println(filaPedido.toString());
			}
		} while (altern != 7);
		teclado.close();
	}

	public static String escolhaPedido() {
		int resposta;
		int valor = 0;
		String pedido = "Pedido= ";
		String altern;
		do {
			do {
			    System.out.println("       Informe seu pedido  ");
			    System.out.println("1-Xis Salada                 R$12,00");
			    System.out.println("2-Xis Tudo                   R$16,00");
			    System.out.println("3-Xis Calabresa              R$15,00");
			    System.out.println("4-Xis Egg                    R$14,00");
			    System.out.println("5-Cachorro Quente Pequeno    R$6,00");
			    System.out.println("6-Cachorro Quente Grande     R$10,00");
			    System.out.println("7-Refrigerante 1,5L          R$8,00");
			    System.out.println("OBS: Ser� cobrado R$7,00 de entrega");
			    resposta = teclado.nextInt();
		      }while ((resposta >= 8) || (resposta <= 0));		
			  switch (resposta) {
			  case 1:
				 pedido = pedido +"Xis Salada, ";
				 valor = 12+valor;
				 break;
			  case 2:
					 pedido = pedido +"Xis Tudo, ";
					 valor = 16 + valor;
					 break;
			  case 3:
					 pedido = pedido +"Xis Calabresa, ";
					 valor = 15 + valor;
					 break;
			  case 4:
					 pedido = pedido +"Xis Egg, ";
					 valor = 14 + valor;
					 break;	 
			  case 5:
				 pedido = pedido +"Cachorro Quente Pequeno, ";
				 valor = 6 + valor;
				 break;
			  case 6:
				 pedido = pedido +"Cachorro Quente Grande, ";
				 valor = 10 + valor;
				 break;
			  case 7:
				 pedido =  pedido +"Refrigerante, ";
				 valor = 8 + valor;
				 break;
			  }
			  teclado.nextLine();
			  do {
			     System.out.println("Deseja adicionar mais algum item?    S/N");
			     altern=teclado.nextLine();
			     if((!altern.equalsIgnoreCase("S")) && (!altern.equalsIgnoreCase("N"))) {
			    	 System.out.println("A alternativa selecionada est� errada");
			    	 continue;
			     }
			     break;
			  }while(true);  
		} while (altern.equalsIgnoreCase("S"));
		System.out.println("Informe seu nome");
		String nomePedido = teclado.nextLine();
		System.out.println("Informe seu endere�o");
		String enderecoPedido = teclado.nextLine();

		return  pedido + "Valor= R$" + (valor+7) + " reais , Nome do comprador= " + nomePedido + ", Endere�o= " + enderecoPedido;
	}
}