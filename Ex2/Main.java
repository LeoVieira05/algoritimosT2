public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento(5);

        estacionamento.entrada("AAA-1234");
        estacionamento.entrada("BBB-5678");
        estacionamento.entrada("CCC-9101");

        estacionamento.consulta("BBB-5678");

        estacionamento.relatorioOcupacao();

        estacionamento.saida("BBB-5678");
        estacionamento.consulta("AAA-1234");

        estacionamento.relatorioOcupacao();

        estacionamento.saida("AAA-1234");
        estacionamento.saida("CCC-9101");
    }
}
