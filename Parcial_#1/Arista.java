import java.util.*;

public class Arista{

  private char nombre;
  private double velocidad;
  private double distancia;
  private double datosControl;
  private double datosUsuario;
  private Nodo inicio;
  private Nodo fin;
  private int peso;
  private double bits;

  public Arista(char nombre, double velocidad, double distancia, double datosControl, double datosUsuario, Nodo inicio, Nodo fin){

    this.nombre = nombre;
    this.velocidad = velocidad;
    this.distancia = distancia;
    this.datosControl = datosControl;
    this.datosUsuario = datosUsuario;
    this.inicio = inicio;
    this.fin = fin;
    this.peso = 1;
    this.bits = 0;
  }

  public void setVelocidad(double velocidad){
    this.velocidad = velocidad;
  }

  public void setDistancia(double distancia){
    this.distancia = distancia;
  }

  public void setBits(double bits){
    this.bits = bits;
  }

  public void getBits(){
    return this.bits;
  }

  public int getVelocidad(){
    return velocidad;
  }

  public double getDistancia(){
    return distancia;
  }

  public double getDatosControl(){
    return datosControl;
  }

  public double getDatosUsuario(){
    return datosUsuario;
  }

  public Nodo getInicio(){
    return inicio;
  }

  public int getFin(){
    return fin;
  }

}
