package model;

import lombok.Getter;
import service.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Getter
public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<String> getClientes() {
        return contas.stream()
                .map(conta -> conta.getCliente().getNome())
                .toList();
    }

    public List<String> getClientesOrdenadosPorNome() {
        Set<String> clientesOrdenadosPorNome = new TreeSet<>(getClientes());
        return clientesOrdenadosPorNome.stream().toList();
    }

    public Conta getConta(String nome) {
        return contas.stream()
                .filter(conta -> conta.getCliente().getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<Conta> getContas(Modalidade modalidade) {
            return contas.stream()
                    .filter(c -> c.getModalidade() == modalidade)
                    .toList();
    }

}
