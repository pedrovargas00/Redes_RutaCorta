import java.util.*;
import java.io.*;

public class Principal{

  public static void main(String []args)throws IOException, FileNotFoundException {

    Archivo archivo = new Archivo();
    Grafo grafo = new Grafo(archivo);

    System.out.println(args[0]);
    archivo.leer(args[0]);
    grafo.matrizAdyacencia();
    grafo.crearGrafo();
    grafo.mostrarMatriz();
  }

}
