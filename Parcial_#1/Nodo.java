import java.util.*;

public class Nodo{

  private String nombre;
  private double tiempoCola;
  private boolean visitado;
  private int index;

  public Nodo(String nombre, double tiempoCola, int index){

    this.nombre = nombre;
    this.tiempoCola = tiempoCola;
    this.index = index;
    this.visitado = false;
  }

  public String getNombre(){
    return nombre;
  }

  public double getTiempoCola(){
    return tiempoCola;
  }

  public int getIndex(){
    return index;
  }

  public boolean getVisitado(){
    return visitado;
  }

}
