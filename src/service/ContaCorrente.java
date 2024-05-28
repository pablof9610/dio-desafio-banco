package service;

import lombok.ToString;
import model.Banco;
import model.Cliente;
import model.Modalidade;

@ToString
public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        modalidade = Modalidade.CONTA_CORRENTE;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}
