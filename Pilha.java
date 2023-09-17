public class Pilha {

    private Node topo;

    public Pilha() {
        topo = null;
    }

    public void Inserir(int informacao) {
        Node node = new Node();
        node.setInformacao(informacao);
        if (topo == null) {
            topo = node;
        } else {
            node.setAnterior(topo);
            topo = node;
        }
    }

    public void Remove() {
        int removido = 0;
        if (topo != null) {
            removido = topo.getInformacao();
            topo = topo.getAnterior();
        }
    }

    public void Imprime() {
        Node nextNode = topo;
        String pilha = "";
        while (nextNode != null) {
            pilha = nextNode.getInformacao() + " " + pilha;

            nextNode = nextNode.getAnterior();
        }
        System.out.println(pilha);
    }

    public boolean checarOrdenacaoCrescente() {
        Node nextNode = topo;
        int valor = 101;
        if (nextNode != null) {
            valor = nextNode.getInformacao();
        }
        while (nextNode != null) {
            if (nextNode.getInformacao() >= valor) {
                valor = nextNode.getInformacao();
            } else {
                return false;
            }
            nextNode = nextNode.getAnterior();
        }
        return true;
    }
    
        public boolean checarOrdenacaoDecrescente() {
        Node nextNode = topo;
        int valor = 0;
        if (nextNode != null) {
            valor = nextNode.getInformacao();
        }
        while (nextNode != null) {
            if (nextNode.getInformacao() <= valor) {
                valor = nextNode.getInformacao();
            } else {
                return false;
            }
            nextNode = nextNode.getAnterior();
        }
        return true;
    }

    public int Tamanho() {
        Node nextNode = topo;
        int tamanho = 0;
        while (nextNode != null) {
            tamanho++;

            nextNode = nextNode.getAnterior();
        }
        return tamanho;
    }

    public int getTopo() {
        if (topo != null) {
            return topo.getInformacao();
        }
        return 0;
    }

    public int getAnterior() {
        if (topo != null) {
            if (topo.getAnterior() != null) {
                return topo.getAnterior().getInformacao();
            } else {
                return 0;
            }
        }
        return 0;
    }
}
