package service;

import lombok.ToString;
import model.Cliente;
import model.Modalidade;

@ToString
public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        modalidade = Modalidade.CONTA_POUPANCA;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}
