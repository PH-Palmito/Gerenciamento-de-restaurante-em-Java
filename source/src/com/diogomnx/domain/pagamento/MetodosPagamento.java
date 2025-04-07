package com.diogomnx.domain.pagamento;

import java.util.Scanner;

public interface MetodosPagamento {
    // Método para pagamento em dinheiro
    void pagarComDinheiro(Scanner input);

    // Método para pagamento com cartão
    void pagarComCartao(Scanner input);

    // Método para pagamento via Pix
    void pagarComPix(Scanner input);
}
