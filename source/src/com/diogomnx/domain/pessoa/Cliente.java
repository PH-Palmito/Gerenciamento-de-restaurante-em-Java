package com.diogomnx.domain.pessoa;

import com.diogomnx.domain.compras.Cardapio;
import com.diogomnx.domain.compras.ItemCardapio;
import com.diogomnx.domain.compras.Pedido;
import com.diogomnx.domain.pagamento.MetodosPagamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa implements MetodosPagamento {

    private List<Pedido> pedidos = new ArrayList<>(); // Lista de pedidos feitos pelo cliente

    // Construtor da classe Cliente, inicializa o nome e a lista de pedidos
    public Cliente(String nome) {
        super(nome);  // Chama o construtor da classe pai (Pessoa) para inicializar o nome
        this.pedidos = new ArrayList<>();  // Inicializa a lista de pedidos
    }

    // Método que permite ao cliente fazer um pedido com base no cardápio
    public void fazerPedido(Cardapio cardapio, Scanner input) {
        Pedido pedido = new Pedido();  // Cria um novo pedido
        System.out.println("\nCardápio:");  // Exibe o cardápio
        int i = 1;
        for (ItemCardapio item : cardapio.getItens()) {
            System.out.println(i++ + ". " + item.getNome() + " - R$ " + item.getPreco()); // Exibe os itens do cardápio
        }
        System.out.println("Digite o número do item para adicionar ao pedido (ou 0 para finalizar):");

        // Laço para permitir ao cliente escolher os itens do pedido
        while (true) {
            int escolha = input.nextInt();  // Captura a escolha do cliente
            if (escolha == 0) break;  // Se o cliente digitar 0, finaliza o pedido
            if (escolha > 0 && escolha <= cardapio.getItens().size()) {
                pedido.addItem(cardapio.getItens().get(escolha - 1));  // Adiciona o item ao pedido
                System.out.println(cardapio.getItens().get(escolha - 1).getNome() + " adicionado ao pedido.");
            } else {
                System.out.println("Escolha inválida. Tente novamente.");  // Se a escolha for inválida
            }
        }
        pedidos.add(pedido);  // Adiciona o pedido à lista de pedidos do cliente

        System.out.println("Pedido finalizado. Total: R$ " + pedido.calcularTotal());  // Exibe o total do pedido
    }

    // Implementação do método de pagamento com dinheiro
    public void pagarComDinheiro(Scanner input) {
        System.out.println("Insira o valor em dinheiro:");
        double dinheiro = input.nextDouble();  // Captura o valor em dinheiro inserido
        System.out.println("Pagamento de R$" + dinheiro + " recebido em dinheiro. Obrigado!");  // Exibe a confirmação do pagamento
    }

    // Implementação do método de pagamento com cartão
    public void pagarComCartao(Scanner input) {
        System.out.println("Insira o numero do cartao:");
        String numeroCartao = input.next();  // Captura o número do cartão
        System.out.println("Pagamento processado com cartao de final " + numeroCartao.substring(numeroCartao.length() - 4) + ". Obrigado!");  // Exibe a confirmação com os 4 últimos dígitos do cartão
    }

    // Implementação do método de pagamento com Pix
    public void pagarComPix(Scanner input) {
        System.out.println("Gerando chave aleatória...");
        input.nextLine();  // Limpa o buffer do scanner
        System.out.println("Pagamento processado via Pix. Obrigado!");  // Exibe a confirmação do pagamento via Pix
    }
}
