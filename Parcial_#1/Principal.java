import java.util.*;
import java.io.*;

public class Principal{

  public static void main(String []args)throws IOException, FileNotFoundException {

    Archivo archivo = new Archivo();
    Grafo grafo = new Grafo(archivo);

    System.out.println(args[0]);
    archivo.leer(args[0]);
    System.out.println("\n");
    grafo.matrizAdyacencia();
    System.out.println("\n");
    grafo.crearGrafo();
    System.out.println("\n");
    grafo.mostrarMatriz();
    System.out.println("\n");
    //grafo.operacionesArista();
    System.out.println("\n");
    grafo.recorrido(grafo.getInicio(), grafo.getFinal());
    grafo.mostrarRecorridos();
  }

}
