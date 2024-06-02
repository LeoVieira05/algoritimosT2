public class No {
    private Carro info;
    private No proximo;

    public No(Carro info) {
        this.info = info;
    }

    public Carro getInfo() {
        return info;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
