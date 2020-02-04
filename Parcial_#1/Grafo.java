import java.util.*;
import java.io.*;

public class Grafo{

  private Archivo datos;
  private ArrayList<Nodo> nodos;
  private ArrayList<Arista> arista;
  private Operaciones operaciones;
  private int matrizAdyacencia[][];

  public Grafo(Archivo datos){

    this.datos = datos;
    this.nodos = new ArrayList();
    this.arista = new ArrayList();
    this.operaciones = new Operaciones();
  }

  public void matrizAdyacencia(){

    matrizAdyacencia = new int[datos.getNoNodos()][datos.getNoNodos()];

    for(int i = 0; i < datos.getNoNodos(); i++)
      for(int j = 0; j < datos.getNoNodos(); j++)
        matrizAdyacencia[i][j] = 0;

  }

  public void agregarNodos(){

    for(int i = 0; i < datos.getNoNodos(); i++){
      nodos.add(new Nodo(datos.getNodos(i), datos.getTC(i), i));
      System.out.println("Nombre_Nodo: " + nodos.get(i).getNombre() + " Index" + nodos.get(i).getIndex());
    }
  }

  public Nodo buscarNodo(String nombre){

    for(Nodo n: nodos)
      if(n.getNombre().equalsIgnoreCase(nombre))
        return n;
    return null;
  }

  public void agregarAristas(){

    for(int i = 0; i < datos.getNoEnlaces(); i++){
      arista.add(new Arista((65 + i), datos.getEnlaceVelocidad(i), datos.getEnlaceDistancia(i), datos.getEnlaceDC(i), datos.getEnlaceDU(i), buscarNodo(datos.getEnlaceOrigen(i)), buscarNodo(datos.getEnlaceDestino(i))));
      System.out.println("Nombre_Arista: " + arista.get(i).getNombre());
      System.out.println("Inicio: " + arista.get(i).getInicio().getNombre());
      System.out.println("Fin: " + arista.get(i).getFin().getNombre());
      matrizAdyacencia[arista.get(i).getInicio().getIndex()][arista.get(i).getFin().getIndex()] = 1;
      matrizAdyacencia[arista.get(i).getFin().getIndex()][arista.get(i).getInicio().getIndex()] = 1;
    }

  }

  public void conversiones(){

    for(Arista ar: arista){
      operaciones.conversionMtaKt(ar);
      operaciones.conversionBytesaMBits(ar);
    }

  }

  public void mostrarMatriz(){

    for(int i = 0; i < datos.getNoNodos(); i++){
      for(int j = 0; j < datos.getNoNodos(); j++)
        System.out.print(matrizAdyacencia[i][j] + " ");
      System.out.print("\n");
    }
  }

  public void crearGrafo(){

    agregarNodos();
    agregarAristas();
  }

  public void recorrido(){

    
  }

}
