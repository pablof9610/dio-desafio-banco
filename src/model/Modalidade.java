package model;

import lombok.Getter;

@Getter
public enum Modalidade {
    CONTA_CORRENTE ("Conta Corrente"),
    CONTA_POUPANCA ("Conta Poupança");

    private String modalidade;

    Modalidade(String modalidade) {
        this.modalidade = modalidade;
    }
}
