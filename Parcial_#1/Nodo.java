import java.util.*;

public class Nodo{

  private String nombre;
  private double tiempoCola;

  public Nodo(String nombre, double tiempoCola){

    this.nombre = nombre;
    this.tiempoCola = tiempoCola;
  }

  public String getNombre(){
    return nombre;
  }

  public double getTiempoCola(){
    return tiempoCola;
  }

}
