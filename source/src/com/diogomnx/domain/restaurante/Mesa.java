package com.diogomnx.domain.restaurante;

public class Mesa {
    // Atributos da classe Mesa
    private int numeroMesa;  // Número da mesa, usado para identificação
    private int capacidade;   // Capacidade da mesa (quantas pessoas ela pode acomodar)
    private Reserva reserva;  // Objeto Reserva, que representa a reserva feita para essa mesa, ou null se não houver reserva

    // Construtor da classe Mesa, recebe o número da mesa e sua capacidade
    public Mesa(int numeroMesa, int capacidade) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.reserva = null;  // Inicialmente, não há nenhuma reserva
    }

    // Método getter para o número da mesa
    public int getNumeroMesa() {
        return numeroMesa;
    }

    // Método getter para a capacidade da mesa
    public int getCapacidade() {
        return capacidade;
    }

    // Método que verifica se a mesa está disponível para reserva (se não tiver uma reserva ativa)
    public boolean isDisponivel() {
        return reserva == null;  // Se não houver uma reserva, a mesa está disponível
    }

    // Método que faz a reserva da mesa
    public void reservar(Reserva reserva) {
        this.reserva = reserva;  // Associa a reserva à mesa
    }

    // Método que libera a mesa, removendo a reserva
    public void liberar() {
        this.reserva = null;  // Define que a mesa não está mais reservada
    }

    // Método getter para a reserva atual da mesa
    public Reserva getReserva() {
        return reserva;
    }
}
