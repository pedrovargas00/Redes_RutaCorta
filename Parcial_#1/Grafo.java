import java.util.*;
import java.io.*;

public class Grafo{

  private Archivo datos;
  private ArrayList<Nodo> nodos;
  private ArrayList<Arista> arista;
  private Operaciones operaciones;
  private int matrizAdyacencia[][];
  private ArrayList<String> recorridos;

  public Grafo(Archivo datos){

    this.datos = datos;
    this.nodos = new ArrayList();
    this.arista = new ArrayList();
    this.recorridos = new ArrayList();
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

  public void desvisitar(ArraList<Nodo> lista){

    for(Nodo n: lista)
      n.setVisitado(false);
  }

  public void desvisitar(){

    for(Nodo n: nodos)
      n.setVisitado(false);
  }

  public ArrayList<Nodo> buscarAdyacentes(Nodo nodo){

    ArrayList<Nodo> aux = new ArrayList();
    Nodo temporal;

    for(int i = 0;  i < matrizAdyacencia[nodo.getIndex()].length; i++)
      if(matrizAdyacencia[nodo.getIndex()][i] != 0){
        temporal = buscarNodo(i);
        if(temporal.getVisitado() == false)
          aux.add(temporal);
      }

    return aux;
  }

  public void recorrido(){

    Nodo inicio = nodos.get(0), final = nodos.get(nodos.size() - 1), nodo;
    ArrayLits<Nodo> adyacentes = new ArrayList();
    //ArrayLits<Nodo> aux = new ArrayList();
    String camino = "";


    adyacentes.addAll(buscarAdyacentes(inicio));
    aux.addAll(adyacentes);

    while(aux.empty() == false){
      if(inicio.getNombre().equalsIgnoreCase(final.getNombre()))
        recorridos.add(camino);
      inicio.setVisitado(true);
      camino += (inicio.getNombre() + ", ");
      nodo = adyacentes.get(0);
      adyacentes.clear();
      adyacentes.addAll(buscarAdyacentes(inicio));
    }

  }

  public ArrayList bfs(Nodo inicio){

    ArrayList<Vertice> lista = new ArrayList();
    Queue<Vertice> cola = new LinkedList();
    boolean indicadorAdyacentes = false;

    inicio.setVisitado(true);
    cola.add(inicio);

    while(cola.isEmpty() == false){
      lista.add(cola.remove());
      indicadorAdyacentes = false;
      for(Nodo n: nodos){
        if(n.getVisitado() == false){
          if(indicadorAdyacentes == false){
            //n.setVisitado(true);
            cola.add(n);
            indicadorAdyacentes = true;
          } else
            n.setVisitado(true);
        }
      }
    }
    desvisitar();
    return b;
  }

}
