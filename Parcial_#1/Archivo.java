
import java.util.*;
import java.io.*;

public class Archivo{

  private int noNodos;
  private int noEnlaces;
  private int nodos[][];
  private int enlaces[][];
  private int tamPaquetes;
  private int nodoOrigen;
  private int nodoDestino;

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

  public int[][] getNodos(){

    return this.nodos;
  }

  public int[][] getEnlaces(){

    return this.enlaces;
  }

  public int getTamPaquetes(){

    return this.tamPaquetes;
  }

  public int getNodoOrigen(){

    return this.NodoOrigen;
  }

  public int getNodoDestino(){

    return this.nodoDestino;
  }

  public int dividir(BufferedReader bf){

    char car;
    String auxiliar = "";

    car = bf.read();
    while((car != ',') || (car != '\n')){
      auxiliar += car;
      car = bf.read();
    }
    return Integer.parseInt(auxiliar);
  }

  public void leer(){

    BufferedReader bf = new BufferedReader(new FileReader("entrada.txt"));
    String auxiliar = "";
    int fila = 0;

    if(bf.ready() == false){
      System.out.println("El archivo está vacío");
    }

    noNodos = dividir(bf);
    noEnlaces = dividir(bf);
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
    nodoOrigen = dividir(bf);
    nodoDestino = dividir(bf);
  }

}
