import java.util.*;

public class Arista{

  private int velocidad;
  private double distancia;
  private Nodo inicio;
  private Nodo fin;

  public Arista(int velocidad, double distancia, Nodo inicio, Nodo fin){

    this.velocidad = velocidad;
    this.distancia = distancia;
    this.inicio = inicio;
    this.fin = fin;
  }

  public int getVelocidad(){
    return velocidad;
  }

  public double getDistancia(){
    return distancia;
  }

  public Nodo getInicio(){
    return inicio;
  }

  public int getFin(){
    return fin;
  }

}
