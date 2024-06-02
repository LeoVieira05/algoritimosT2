public class Main {
    public static void main(String[] args) {
        Pilha estacionamento = new Pilha(5);

        estacionamento.push(new Carro("AAA-1234"));
        estacionamento.push(new Carro("BBB-5678"));
        estacionamento.push(new Carro("CCC-9101"));

        estacionamento.consulta("BBB-5678");

        estacionamento.relatorioOcupacao();

        estacionamento.sair("BBB-5678");
        estacionamento.consulta("BBB-5678");

        estacionamento.relatorioOcupacao();

        System.out.println("Total de manobras realizadas: " + estacionamento.getTotalManobras());
    }
}
