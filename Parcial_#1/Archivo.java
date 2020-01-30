
import java.util.*;
import java.io.*;

public class Archivo{

  private int noNodos;
  private int noEnlaces;
  private double nodos[][];
  private double enlaces[][];
  private double tamPaquetes;
  private String nodoOrigen;
  private String nodoDestino;

  public Archivo(){

    this.noNodos = 0;
    this.noEnlaces = 0;
    this.tamPaquetes = 0;
    this.nodoOrigen = 0;
    this.nodoDestino = 0;
  }

  public void setNodos(int noNodos){

    this.nodos = new int[noNodos][2];
  }

  public void setEnlaces(int noEnlaces){

    this.enlaces = new int[noEnlaces][6];
  }


  public int getNoNodos(){

     return this.noNodos;
  }

  public int getNoEnlaces(){

    return this.noEnlaces;
  }

  public String getNodos(int j){

    return String.valueOf(this.nodos[j][0]);
  }

  public double getTC(int j){

    return this.nodos[j][1];
  }

  public String getEnlaceOrigen(int j){

    return String.valueOf(this.enlaces[j][0]);
  }

  public String getEnlaceDestino(int j){

    return String.valueOf(this.enlaces[j][1]);
  }

  public double getEnlaceVelocidad(int j){

    return this.enlaces[j][2];
  }

  public double getEnlaceDistancia(int j){

    return this.enlaces[j][3];
  }

  public double getEnlaceDC(int j){

    return this.enlaces[j][4];
  }

  public double getEnlaceDU(int j){

    return this.enlaces[j][5];
  }

  public double getTamPaquetes(){

    return this.tamPaquetes;
  }

  public String getNodoOrigen(){

    return this.NodoOrigen;
  }

  public String getNodoDestino(){

    return this.nodoDestino;
  }

  public double dividir(BufferedReader bf){

    char car;
    String auxiliar = "";

    car = bf.read();
    while((car != ',') || (car != '\n')){
      auxiliar += car;
      car = bf.read();
    }
    return Double.parseDouble(auxiliar);
  }

  public void leer(){

    BufferedReader bf = new BufferedReader(new FileReader("entrada.txt"));
    String auxiliar = "";
    int fila = 0;

    if(bf.ready() == false){
      System.out.println("El archivo está vacío");
    }

    noNodos = (int)dividir(bf);
    noEnlaces = (int)dividir(bf);
    for(int i = 0; i < noNodos; i++){
      nodos[i][0] = dividir(bf);
      nodos[i][1] = dividir(bf);
    }
    for(int i = 0; i < noEnlaces; i++){
      enlaces[i][0] = dividir(bf);
      enlaces[i][1] = dividir(bf);
      enlaces[i][2] = dividir(bf);
      enlaces[i][3] = dividir(bf);
      enlaces[i][4] = dividir(bf);
      enlaces[i][5] = dividir(bf);
    }
    tamPaquetes = dividir(bf);
    nodoOrigen = String.valueOf(dividir(bf));
    nodoDestino = String.valueOf(dividir(bf));
  }

}
