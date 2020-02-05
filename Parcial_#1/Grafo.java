import java.util.*;
import java.io.*;

public class Grafo{

  private Archivo datos;
  private ArrayList<Nodo> nodos;
  private ArrayList<Arista> arista;
  private Operaciones operaciones;
  private int matrizAdyacencia[][];
  private ArrayList<String> recorridos;
  private ArrayList<Nodo> camino;

  public Grafo(Archivo datos){

    this.datos = datos;
    this.nodos = new ArrayList();
    this.arista = new ArrayList();
    this.recorridos = new ArrayList();
    this.camino = new ArrayList();
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

  public Nodo buscarNodo(int index){

    for(Nodo n: nodos)
      if(n.getIndex() == index)
        return n;
    return null;
  }

  public void agregarAristas(){

    for(int i = 0; i < datos.getNoEnlaces(); i++){
      arista.add(new Arista((65 + i), datos.getEnlaceVelocidad(i), datos.getEnlaceDistancia(i), datos.getEnlaceDC(i), datos.getEnlaceDU(i), buscarNodo(datos.getEnlaceOrigen(i)), buscarNodo(datos.getEnlaceDestino(i))));
      matrizAdyacencia[arista.get(i).getInicio().getIndex()][arista.get(i).getFin().getIndex()] = 1;
      matrizAdyacencia[arista.get(i).getFin().getIndex()][arista.get(i).getInicio().getIndex()] = 1;
    }

  }

  public Nodo getInicio(){
    return nodos.get(0);
  }

  public Nodo getFinal(){
    return nodos.get(nodos.size() - 1);
  }

  public void operacionesArista(){

    for(int i = 0; i < arista.size(); i++){
    //for(Arista ar: arista){
      operaciones.conversionMtaKt(arista.get(i));
      operaciones.conversionBytesaMBits(arista.get(i));
      if((i + 1) != arista.size())
        operaciones.divisionPaquetes(arista.get(i), arista.get(i + 1));
      else
        operaciones.divisionPaquetes(arista.get(i), null);
      operaciones.latencia(arista.get(i));
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

  public ArrayList buscarAristas(ArrayList<Nodo> nodos){

    int i = 0;
    ArrayList<Arista> ar = new ArrayList();

    for(Arista a: arista){
      if(nodos.get(i) == null)
        return ar;
      if((a.getInicio().getNombre().equalsIgnoreCase(nodos.get(i).getNombre())) && (a.getFin().getNombre().equalsIgnoreCase(nodos.get(i + 1).getNombre()))){
        ar.add(a);
        i++;
      }
    }
    return ar;
  }

  public ArrayList buscarAdyacentes(Nodo nodo){

    ArrayList<Nodo> aux = new ArrayList();

    for(int i = 0;  i < matrizAdyacencia[nodo.getIndex()].length; i++)
      if(matrizAdyacencia[nodo.getIndex()][i] != 0)
        aux.add(nodos.get(i));

    return aux;
  }

  public void guardarCaminos(ArrayList<Nodo> cm){

    String aux = "";

    for(Nodo n: cm)
      aux += (n.getNombre() + "-");
    recorridos.add(aux);
  }

  public ArrayList recorrido(Nodo inicio, Nodo ultimo){

    ArrayList<Nodo> adyacentes = new ArrayList();

    if(inicio.getNombre().equalsIgnoreCase(ultimo.getNombre())){
      camino.add(ultimo);
      inicio.setVisitado(false);
      for(Nodo f: camino)
        System.out.println(f.getNombre());
      guardarCaminos(camino);
      System.out.println("Corr " + recorridos.get(0));
      return camino;
    }
    adyacentes.addAll(buscarAdyacentes(inicio));
    inicio.setVisitado(true);
    camino.add(inicio);
    for(Nodo n: adyacentes){
      if(!n.getVisitado()){
        recorrido(n, ultimo);
        camino.remove(camino.size() - 1);
      }
    }

    inicio.setVisitado(false);
    return camino;
  }

  public void mostrarRecorridos(){

    for(int i = 0; i < recorridos.size(); i++)
      System.out.println("Rec: " + recorridos.get(i));
  }

}
