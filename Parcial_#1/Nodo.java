import java.util.*;

public class Nodo{

  private String nombre;
  private int datosControl;
  private int datosUsuario;
  private double tiempoCola;

  public Nodo(String nombre, int datosControl, int datosUsuario, double tiempoCola){

    this.nombre = nombre;
    this.datosControl = datosControl;
    this.datosUsuario = datosUsuario;
    this.tiempoCola = tiempoCola;
  }

  public String getNombre(){
    return nombre;
  }

  public int getDatosControl(){
    return datosControl;
  }

  public int getDatosUsuario(){
    return datosUsuario;
  }

  public double getTiempoCola(){
    return tiempoCola;
  }

}
