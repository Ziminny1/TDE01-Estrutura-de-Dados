public class Node {

  private Integer informacao;
  private Node anterior;

  public Node() {
    informacao = null;
    anterior = null;
  }

  public Integer getInformacao() {
    return informacao;
  }

  public void setInformacao(Integer informacao) {
    this.informacao = informacao;
  }

  public Node getAnterior() {
    return anterior;
  }

  public void setAnterior(Node anterior) {
    this.anterior = anterior;
  }
}
