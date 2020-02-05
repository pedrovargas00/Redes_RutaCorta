
import java.util.*;
import java.io.*;

public class Archivo{

  private int noNodos;
  private int noEnlaces;
  private ArrayList<String> nodos;
  private double tc[];
  private ArrayList<String> nodosOrigen;
  private ArrayList<String> nodosDestino;
  private double enlaces[][];
  private double tamPaquetes;
  private String nodoOrigen;
  private String nodoDestino;

  public Archivo(){

    this.noNodos = 0;
    this.noEnlaces = 0;
    this.nodos = new ArrayList();
    this.nodosOrigen = new ArrayList();
    this.nodosDestino = new ArrayList();
    this.tamPaquetes = 0;
    this.nodoOrigen = "";
    this.nodoDestino = "";
  }

  public void setTC(int noNodos){

    this.tc = new double[noNodos];
  }

  public void setEnlaces(int noEnlaces){

    this.enlaces = new double[noEnlaces][4];
  }

  public int getNoNodos(){

     return noNodos;
  }

  public int getNoEnlaces(){

    return noEnlaces;
  }

  public String getNodos(int j){

    return nodos.get(j);
  }

  public double getTC(int j){

    return tc[j];
  }

  public String getEnlaceOrigen(int j){

    return nodosOrigen.get(j);
  }

  public String getEnlaceDestino(int j){

    return nodosDestino.get(j);
  }

  public double getEnlaceVelocidad(int j){

    return enlaces[j][0];
  }

  public double getEnlaceDistancia(int j){

    return enlaces[j][1];
  }

  public double getEnlaceDC(int j){

    return enlaces[j][2];
  }

  public double getEnlaceDU(int j){

    return enlaces[j][3];
  }

  public double getTamPaquetes(){

    return tamPaquetes;
  }

  public String getNodoOrigen(){

    return nodoOrigen;
  }

  public String getNodoDestino(){

    return nodoDestino;
  }

  public ArrayList<String> dividir(BufferedReader bf)throws IOException {

    ArrayList<String> entrada = new ArrayList();
    String[] in;
    String auxiliar;

    while((auxiliar = bf.readLine()) != null){
      in = auxiliar.split(",");
      for(int i = 0; i < in.length; i++)
        entrada.add(in[i]);
    }

    return entrada;
  }

  public void leer(String nombre)throws IOException, FileNotFoundException {

    BufferedReader bf = new BufferedReader(new FileReader(nombre));
    ArrayList<String> entrada = new ArrayList();
    int j = 0;

    if(bf.ready() == false){
      System.out.println("El archivo está vacío");
    }

    entrada.addAll(dividir(bf));
    noNodos = Integer.parseInt(entrada.get(j));
    j++;
    noEnlaces = Integer.parseInt(entrada.get(j));
    j++;
    setTC(noNodos);
    setEnlaces(noEnlaces);
    for(int i = 0; i < noNodos; i++){
      nodos.add(entrada.get(j));
      j++;
      tc[i] = Double.parseDouble(entrada.get(j));
      j++;
    }
    for(int i = 0; i < noEnlaces; i++){
      nodosOrigen.add(entrada.get(j));
      j++;
      nodosDestino.add(entrada.get(j));
      j++;
      enlaces[i][0] = Double.parseDouble(entrada.get(j));
      j++;
      enlaces[i][1] = Double.parseDouble(entrada.get(j));
      j++;
      enlaces[i][2] = Double.parseDouble(entrada.get(j));
      j++;
      enlaces[i][3] = Double.parseDouble(entrada.get(j));
      j++;
    }
    tamPaquetes = Double.parseDouble(entrada.get(j));
    j++;
    nodoOrigen = entrada.get(j);
    j++;
    nodoDestino = entrada.get(j);
    }

}
