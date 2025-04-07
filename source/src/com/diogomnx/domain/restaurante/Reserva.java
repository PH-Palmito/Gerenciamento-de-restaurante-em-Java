package com.diogomnx.domain.restaurante;

import com.diogomnx.domain.pessoa.Cliente;

public class Reserva {
    // Atributos da classe Reserva
    private Cliente cliente;  // O cliente que fez a reserva
    private String horario;   // O horário em que a reserva foi feita

    // Construtor da classe Reserva, que recebe o cliente e o horário
    public Reserva(Cliente cliente, String horario) {
        this.cliente = cliente;
        this.horario = horario;
    }

    // Método getter para obter o cliente que fez a reserva
    public Cliente getCliente() {
        return cliente;
    }

    // Método getter para obter o horário da reserva
    public String getHorario() {
        return horario;
    }

    // Método que confirma a reserva e imprime uma mensagem com o nome do cliente e o horário
    public void confirmar() {
        System.out.println("Reserva confirmada para " + cliente.getNome() + " às " + horario + ".");
    }
}
