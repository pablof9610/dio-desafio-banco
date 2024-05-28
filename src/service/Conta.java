package service;

import lombok.Getter;
import model.Banco;
import model.Cliente;
import model.Modalidade;
import util.ValorIncorretoException;


public abstract class Conta implements model.Conta {

    private static final int AGENCIA_PADRAO = 1;

    private static int SEQUENCIAL = 1;

    protected @Getter int agencia;

    protected @Getter int numero;

    protected @Getter double saldo;

    protected @Getter Cliente cliente;

    protected @Getter Modalidade modalidade;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        tratarValorInformado(valor);
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new ValorIncorretoException("Não são aceitos valores negativos ou nulos.");
        }

        saldo += valor;
    }

    @Override
    public void transferir(double valor, model.Conta contaDestino) {
        tratarValorInformado(valor);
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", cliente.getNome());
        System.out.printf("Agencia: %d%n", agencia);
        System.out.printf("Numero: %d%n", numero);
        System.out.printf("Saldo: %.2f%n", saldo);
    }

    private void tratarValorInformado(double valor) {

        if (valor <= 0) {
            throw new ValorIncorretoException("Não são aceitos valores negativos ou nulos.");
        }

        if (saldo == 0) {
            throw new ValorIncorretoException("Conta sem saldo.");
        }

        if(valor > saldo) {
            throw new ValorIncorretoException("Valor informado é maior que o saldo em conta.");
        }
    }
}
