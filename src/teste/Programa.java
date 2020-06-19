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
			System.out.println("4-Deseja fazer reclamações ou sugestões");
			System.out.println("5-Ver sugestões e reclamação");
			System.out.println("6-Sair");
			altern = teclado.nextInt();
			switch (altern) {
			case 1: {
				String fin = escolhaPedido();
				filaPedido.enfileira(fin);
				System.out.println(filaPedido.toString());
			}
				break;
			case 2:
				if (!filaPedido.estaVazia()) {
					if (!pilhaEntregador.estaVazia()) {
						filaPedido.desenfileira();
						pilhaEntregador.desempilha();
					} else {
						System.out.println("Não a entregadores para fazer a entrega");
					}
				} else {
					System.out.println("Não a pedidos para serem entregues");
				}
				break;
			case 3:
				pilhaEntregador.empilha("Entregador");
				break;
			case 4:
				System.out.println("Informe seu nome");
				teclado.nextLine();
				String nomeSR = teclado.nextLine();
				System.out.println("Informe sua reclamação ou sujestões");
				String reclamaSujestao = teclado.nextLine();
				String melhoria = nomeSR + ": " + reclamaSujestao;
				pilhaReclamacao.empilha(melhoria);
				break;
			case 5:
				System.out.println(pilhaReclamacao.toString());
				break;
			}
		} while (altern != 6);
		teclado.close();
	}

	public static String escolhaPedido() {
		int resposta;
		int valor = 0;
		String pedido = null;
		do {
			System.out.println("       Informe seu pedido  ");
			System.out.println("1-Xis Salada                 R$15,00");
			System.out.println("2-Cachorro Quente Pequeno    R$6,00");
			System.out.println("3-Cachorro Quente Grande     R$10,00");
			System.out.println("4-Refrigerante 1,5L          R$8,00");
			System.out.println("OBS: Será cobrado R$7,00 de entrega");
			resposta = teclado.nextInt();
		} while ((resposta >= 5) || (resposta <= 0));
		switch (resposta) {
		case 1:
			pedido = "Xis Salada";
			valor = 15 + 7;
			break;
		case 2:
			pedido = "Cachorro Quente Pequeno";
			valor = 6 + 7;
			break;
		case 3:
			pedido = "Cachorro Quente Grande";
			valor = 10 + 7;
			break;
		case 4:
			pedido = "Refrigerante";
			valor = 8 + 7;
			break;
		}
		System.out.println("Informe seu nome");
		teclado.nextLine();
		String nomePedido = teclado.nextLine();

		System.out.println("Informe seu endereço");
		String enderecoPedido = teclado.nextLine();

		return pedido + "," + "R$" + valor + " reais ," + nomePedido + "," + enderecoPedido;
	}
}