package com.diogomnx.application;

import com.diogomnx.domain.pessoa.Cliente;
import com.diogomnx.domain.pessoa.Funcionario;
import com.diogomnx.domain.restaurante.Mesa;
import com.diogomnx.domain.restaurante.Reserva;
import com.diogomnx.domain.restaurante.Restaurante;
import com.diogomnx.domain.restaurante.SistemaRestaurante;

import java.util.Scanner;

public class Programa {
    // Método principal que inicializa o sistema e controla a execução
    public static void main(String[] args) {
        // Criação do objeto Scanner para capturar a entrada do usuário
        Scanner input = new Scanner(System.in);

        // Inicializando o restaurante com nome e endereço
        Restaurante restaurante = new Restaurante("Snoop Burguer", "Rua 09, 27");

        // SistemaRestaurante é responsável por gerenciar as operações do restaurante
        SistemaRestaurante sistema = new SistemaRestaurante(restaurante);

        // Mensagem de boas-vindas
        System.out.println("Bem-vindo ao sistema geral do Snoop Burguer!");

        int opcao;

        // Menu principal do sistema, onde o usuário escolhe opções de interação
        do {
            // Exibição das opções do menu
            System.out.println("\n=== Sistema Snoop Burguer ===");
            System.out.println("1. Adicionar mesa");
            System.out.println("2. Listar mesas");
            System.out.println("3. Listar mesas ordenadas por capacidade");
            System.out.println("4. Buscar mesa por capacidade");
            System.out.println("5. Adicionar item ao cardápio");
            System.out.println("6. Listar Cardápio");
            System.out.println("7. Adicionar funcionário");
            System.out.println("8. Listar funcionários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt(); // Captura a opção escolhida pelo usuário

            // Executa a ação conforme a escolha do usuário
            switch (opcao) {
                case 1 -> sistema.adicionarMesa(input); // Adiciona uma mesa ao restaurante
                case 2 -> sistema.listarMesas(); // Lista todas as mesas cadastradas
                case 3 -> sistema.listarMesasOrdenadas(); // Lista as mesas ordenadas por capacidade
                case 4 -> sistema.buscarMesaPorCapacidade(input); // Busca mesas por capacidade
                case 5 -> sistema.adicionarItemCardapio(restaurante, input); // Adiciona um item ao cardápio
                case 6 -> sistema.listarCardapio(restaurante); // Exibe o cardápio do restaurante
                case 7 -> sistema.adicionarFuncionario(input); // Adiciona um novo funcionário
                case 8 -> sistema.listarFuncionarios(); // Lista todos os funcionários registrados
                case 0 -> System.out.println("Saindo..."); // Sai do programa
                default -> System.out.println("Opção inválida. Tente novamente."); // Mensagem de erro para opção inválida
            }
        } while (opcao != 0); // O laço continua até que o usuário escolha a opção "0" (Sair)

        System.out.println("=================");

        // Inicializa o sistema do restaurante (configurações iniciais, se houver)
        restaurante.inicializarSistema();

        System.out.println("\nExecutando tarefas dos funcionários:");
        for (Funcionario funcionario : restaurante.getFuncionarios()) {
            funcionario.executarTarefa();
        }

        System.out.println("==================");

        boolean maisClientes = true;
        while (maisClientes) {
            // Registra um novo cliente
            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = input.next();
            Cliente cliente = new Cliente(nomeCliente); // Cria o objeto Cliente com o nome fornecido

            boolean continuar = true;
            while (continuar) {
                // Pergunta sobre a capacidade da mesa necessária para o cliente
                System.out.println("\nDigite a capacidade necessária para a mesa:");
                int capacidadeNecessaria = input.nextInt();
                Mesa mesaDisponivel = restaurante.buscarMesaDisponivel(capacidadeNecessaria); // Busca uma mesa disponível com a capacidade desejada

                if (mesaDisponivel != null) {
                    // Se a mesa for encontrada, realiza a reserva
                    System.out.println("Mesa " + mesaDisponivel.getNumeroMesa() + " está disponível. Reservando...");
                    System.out.print("Digite o horário da reserva: ");
                    String horarioReserva = input.next(); // Recebe o horário da reserva

                    Reserva reserva = new Reserva(cliente, horarioReserva); // Cria a reserva com o cliente e o horário
                    mesaDisponivel.reservar(reserva); // Reserva a mesa
                    reserva.confirmar(); // Confirma a reserva da mesa
                    continuar = false; // Interrompe o loop de reservas, pois a mesa foi reservada
                } else {
                    // Se não houver mesa disponível, oferece a opção de tentar novamente
                    System.out.println("Desculpe, não há mesas disponíveis para esse número de pessoas.");
                    System.out.println("Deseja tentar novamente? (s/n)");
                    char respostaReserva = input.next().charAt(0);
                    if (respostaReserva == 'n') {
                        System.out.println("Finalizando programa.");
                        continuar = false; // Interrompe o loop de reserva
                    }
                }

                // O cliente faz o pedido
                cliente.fazerPedido(restaurante.getCardapio(), input);

                System.out.println("================");

                // Pergunta sobre o método de pagamento
                System.out.println("\nEscolha uma forma de pagamento:");
                System.out.println("1. Dinheiro\n2. Cartão\n3. Pix");
                System.out.println("(Digite o numero referente ao método de pagamento)");
                int escolhaPagamento = input.nextInt(); // Captura a escolha do pagamento

                // Processa o pagamento conforme a escolha
                switch (escolhaPagamento) {
                    case 1 -> cliente.pagarComDinheiro(input); // Pagamento em dinheiro
                    case 2 -> cliente.pagarComCartao(input); // Pagamento com cartão
                    case 3 -> cliente.pagarComPix(input); // Pagamento via Pix
                    default -> System.out.println("Forma de pagamento inválida."); // Caso o pagamento seja inválido
                }

                // Após o pagamento, libera a mesa para outro cliente
                mesaDisponivel.liberar();
                System.out.println("==================");
                System.out.println("Mesa " + mesaDisponivel.getNumeroMesa() + " está agora disponível.");

                // Pergunta se há mais clientes para serem registrados
                System.out.println("Mais algum cliente? (s/n)");
                char respostaCliente = input.next().charAt(0);
                if (respostaCliente == 'n') {
                    maisClientes = false; // Se o usuário não quiser mais clientes, o loop é interrompido
                }
            }
        }

        System.out.println("==============");

        // Mensagem final agradecendo o cliente
        System.out.println("Obrigado por visitar o Snoop Burguer e volte sempre!");
    }
}
