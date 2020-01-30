import java.util.*;

public class Grafo{

  private Archivo datos;
  private ArrayList<Nodo> nodos;
  private ArrayList<Arista> arista;

  public Grafo(){

    datos = new Datos();
    nodos = new ArrayList();
    arista = new ArrayList();
  }

  public void agregarNodos(){

    for(int i = 0; i < datos.getNoNodos; i++)
      nodos.add(new Nodo(Integer.toString(datos.getNodos(i)), datos.getTC(i));
  }

  public void agregarAristas(){

    for(int i = 0; i < datos.getNoNodos; i++)
      arista.add(new Arista(65 + i, datos.getEnlaceVelocidad(i), datos.getEnlaceDistancia(i),
      datos.getEnlaceDC(i), datos.getEnlaceDu(i), datos.getNodoOrigen(), datos.getNodoDestino());
  }

  public void crearGrafo(){

    agregarNodos();
    agregarAristas();
  }

  public void recorrido(){}

}
