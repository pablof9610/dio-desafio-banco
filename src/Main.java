import model.Banco;
import model.Cliente;
import model.Modalidade;
import service.Conta;
import service.ContaCorrente;
import service.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Banco inter = new Banco();
        Cliente pablo = new Cliente();
        Cliente teste = new Cliente();
        teste.setNome("Teste");
        pablo.setNome("Pablo");
        Conta cc = new ContaCorrente(teste);
        inter.adicionarConta(cc);
        cc.depositar(100);
        Conta cp = new ContaPoupanca(pablo);
        inter.adicionarConta(cp);
        cc.transferir(100, cp);

        System.out.println(inter.getClientes());
        System.out.println(inter.getConta("Teste"));
        System.out.println(inter.getClientesOrdenadosPorNome());
        System.out.println(inter.getContas(Modalidade.CONTA_POUPANCA));
    }
}