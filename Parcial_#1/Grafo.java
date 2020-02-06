import java.util.*;
import java.io.*;

public class Grafo{

  private Archivo datos;
  private ArrayList<Nodo> nodos;
  private ArrayList<Arista> arista;
  private Operaciones operaciones;
  private Camino ruta;
  private int matrizAdyacencia[][];
  private ArrayList<String> recorridos;
  private ArrayList<Nodo> camino;
  private ArrayList<Camino> caminos;
  private ArrayList<Double> tiempos;

  public Grafo(Archivo datos){

    this.datos = datos;
    this.nodos = new ArrayList();
    this.arista = new ArrayList();
    this.recorridos = new ArrayList();
    this.camino = new ArrayList();
    this.caminos = new ArrayList();
    this.tiempos = new ArrayList();
    this.operaciones = new Operaciones();
  }

  public void iniciarCamino(Camino ruta){

    ruta.setTamTransferencia(operaciones.conversionGBytesaBytes(datos.getTamPaquetes()));
    ruta.setInicio(datos.getNodoOrigen());
    ruta.setFin(datos.getNodoDestino());
  }

  public void matrizAdyacencia(){

    matrizAdyacencia = new int[datos.getNoNodos()][datos.getNoNodos()];

    for(int i = 0; i < datos.getNoNodos(); i++)
      for(int j = 0; j < datos.getNoNodos(); j++)
        matrizAdyacencia[i][j] = 0;

  }

  public void agregarNodos(){

    for(int i = 0; i < datos.getNoNodos(); i++)
      nodos.add(new Nodo(datos.getNodos(i), datos.getTC(i), i));
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

    for(Nodo n: nodos)
      if(n.getNombre().equalsIgnoreCase(datos.getNodoOrigen()))
        return n;

    return null;
  }

  public Nodo getFinal(){

    for(Nodo n: nodos)
      if(n.getNombre().equalsIgnoreCase(datos.getNodoDestino()))
        return n;

    return null;
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
      guardarCaminos(camino);
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

    for(int i = 0; i < recorridos.size(); i++){
      System.out.println("Camino " + (i + 1) + ": " + recorridos.get(i));
      ruta = new Camino(this, recorridos.get(i));
      caminos.add(ruta);
      operacionesCamino(ruta);
    }
  }

  public void operacionesCamino(Camino ruta){

    iniciarCamino(ruta);
    ruta.setCamino();
    ruta.setAristas();
    for(int j = 0; j < ruta.getTamanoArista(); j++)
      operaciones.operacionesArista(ruta.getArista(j), ruta.getArista(j + 1));
    ruta.setLatenciaTotal();
    tiempos.add(ruta.getLatenciaTotal());
    ruta.setCantidadPaquetes(operaciones.cantidadPaquetes(ruta));
    ruta.setTiempoTranferencia(operaciones.tamanoTranferencia(ruta));
    System.out.println(operaciones.conversionSegAHr(ruta.getTiempoTranferencia()));
    System.out.println("");
  }

  public void caminoCorto(){

    Collections.sort(tiempos);

    for(Camino c: caminos)
      if(c.getLatenciaTotal() == tiempos.get(0))
        System.out.println("\nCamino mas optimo: " + c.getCamino() + " con latencia " + c.getLatenciaTotal() + " seg" + "\n");
  }

}
