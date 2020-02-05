import java.util.*;

public class Camino{

  private ArrayList<Nodo> caminoNodo;
  private String camino;
  private int latenciaTotal;
  private ArrayList<Arista> aristas;
  private Grafo grafo;

  public Camino(Grafo grafo, String camino){

    this.camino = camino;
    this.caminoNodo = new ArrayList();
    this.latenciaTotal = 0;
    this.aristas = new ArrayList();
    this.grafo = grafo;
  }

  public void setCamino(){

    String tem[] = camino.split("-");

    for(int i = 0; i < tem.length; i++)
      caminoNodo.add(grafo.buscarNodo(tem[i]));
  }

  public void setAristas(){

    this.aristas.addAll(grafo.buscarAristas(caminoNodo));
  }

  public void setLatenciaTotal(ArrayList<Nodo> nodos){

    for(Arista a: aristas)
      latenciaTotal += a.getLatencia();
  }

}
