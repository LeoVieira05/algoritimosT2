import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Stack;

public class Pilha {
    private No topo;
    private int capacidade;
    private int totalManobras;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.totalManobras = 0;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public boolean estaCheia() {
        int count = 0;
        No aux = topo;
        while (aux != null) {
            count++;
            aux = aux.getProximo();
        }
        return count >= capacidade;
    }

    public void push(Carro carro) {
        if (estaCheia()) {
            System.out.println("O estacionamento está cheio!");
            return;
        }
        No novo = new No(carro);
        if (!estaVazia()) {
            novo.setProximo(topo);
        }
        topo = novo;
        System.out.println("O carro de placa " + carro.getPlaca() + " entrou às " + carro.getHorarioEntrada());
    }

    public Carro pop() {
        if (estaVazia()) {
            return null;
        }
        Carro temp = topo.getInfo();
        topo = topo.getProximo();
        return temp;
    }

    public Carro peek() {
        if (estaVazia()) {
            return null;
        }
        return topo.getInfo();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Pilha: ");
        if (estaVazia()) {
            s.append("vazia");
        } else {
            No aux = topo;
            while (aux != null) {
                s.append(aux).append("\n");
                aux = aux.getProximo();
            }
            s.append("\\\\");
        }
        return s.toString();
    }

    public void sair(String placa) {
        Stack<No> tempStack = new Stack<>();
        int manobras = 0;

        while (!estaVazia() && !peek().getPlaca().equals(placa)) {
            tempStack.push(topo);
            pop();
            manobras++;
        }

        if (!estaVazia() && peek().getPlaca().equals(placa)) {
            Carro carro = pop();
            LocalDateTime horarioSaida = LocalDateTime.now();
            Duration permanencia = Duration.between(carro.getHorarioEntrada(), horarioSaida);
            System.out.println("O carro de placa " + placa + " saiu às " + horarioSaida + ". Tempo de permanência foi de: " + permanencia.toMinutes() + " minutos. Número de manobras: " + manobras + ".");
            totalManobras += manobras;
        } else {
            System.out.println("Carro não encontrado.");
        }

        while (!tempStack.isEmpty()) {
            push(tempStack.pop().getInfo());
        }
    }

    public void consulta(String placa) {
        int posicao = 1;
        No aux = topo;
        while (aux != null) {
            if (aux.getInfo().getPlaca().equals(placa)) {
                System.out.println("O carro de placa " + placa + " está na posição " + posicao + " da pilha. Entrou às " + aux.getInfo().getHorarioEntrada() + ".");
                return;
            }
            aux = aux.getProximo();
            posicao++;
        }
        System.out.println("Carro não encontrado.");
    }

    public void relatorioOcupacao() {
        System.out.println("Relatório de Ocupação Atual do Estacionamento:");
        if (estaVazia()) {
            System.out.println("Estacionamento esta vazio.");
        } else {
            No aux = topo;
            int posicao = 1;
            while (aux != null) {
                System.out.println("Posição " + posicao + ": " + aux.getInfo().getPlaca() + " entrou às " + aux.getInfo().getHorarioEntrada());
                aux = aux.getProximo();
                posicao++;
            }
        }
    }

    public int getTotalManobras() {
        return totalManobras;
    }
}
