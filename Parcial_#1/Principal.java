import java.util.*;
import java.io.*;

public class Principal{

  public static void main(String []args)throws IOException, FileNotFoundException {

    Archivo archivo = new Archivo();
    Grafo grafo = new Grafo(archivo);

    System.out.println("");
    archivo.leer(args[0]);
    grafo.matrizAdyacencia();
    grafo.crearGrafo();
    grafo.recorrido(grafo.getInicio(), grafo.getFinal());
    grafo.mostrarRecorridos();
    grafo.caminoCorto();
  }

}
