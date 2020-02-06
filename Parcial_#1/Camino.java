import java.util.*;

public class Camino{

  private Grafo grafo;
  private String camino;
  private double latenciaTotal;
  private double cantidadPaquetes;
  private double tiempoTransferencia;
  private double tamTransferencia;
  private String inicio;
  private String fin;
  private ArrayList<Arista> aristas;
  private ArrayList<Nodo> caminoNodo;

  public Camino(Grafo grafo, String camino){

    this.camino = camino;
    this.caminoNodo = new ArrayList();
    this.latenciaTotal = 0.0;
    this.cantidadPaquetes = 0.0;
    this.tamTransferencia = 0.0;
    this.tiempoTransferencia = 0.0;
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

  public void setTamTransferencia(double tamTransferencia){

    this.tamTransferencia = tamTransferencia;
  }

  public void setInicio(String inicio){

    this.inicio = inicio;
  }

  public void setFin(String fin){

    this.fin = fin;
  }

  public String getCamino(){

    return camino;
  }

  public double getTamTransferencia(){

    return tamTransferencia;
  }

  public String getInicio(){

    return inicio;
  }

  public String getFin(){

    return fin;
  }

  public Arista getArista(int index){

    if(index != aristas.size())
      return aristas.get(index);
    else
      return null;
  }

  public int getTamanoArista(){

    return aristas.size();
  }

  public void setLatenciaTotal(){

    for(Arista a: aristas)
      latenciaTotal += a.getLatencia();
    System.out.println("Latencia del camino: " + latenciaTotal + " seg");
  }

  public void setCantidadPaquetes(double cantidadPaquetes){

    this.cantidadPaquetes = cantidadPaquetes;
    System.out.println("Cantidad de paquetes del camino: " + cantidadPaquetes);
  }

  public void setTiempoTranferencia(double tiempoTransferencia){

    this.tiempoTransferencia = tiempoTransferencia;
    System.out.println("Tiempo de Transferencia del camino: " + tiempoTransferencia + " seg");
  }

  public double getCantidadPaquetes(){

    return cantidadPaquetes;
  }

  public double getTiempoTranferencia(){

    return tiempoTransferencia;
  }

  public double getLatenciaTotal(){

    return latenciaTotal;
  }

}
