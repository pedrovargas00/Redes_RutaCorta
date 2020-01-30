import java.util.*;

public class Operaciones{

  private Grafo grafo;

  public Operaciones(){
    grafo = new Grafo();
  }

  public double divisionPaquetes(Arista arista1, Arista arista2){

    if(arista1.getEnlaceDU > arista2.getEnlaceDU)
      return Math.ceil(arista1.getEnlaceDU / arista2.getEnlaceDU);
    return 1;
  }

  public void conversionKmaMt(Arista arista){

    arista.setDistancia((arista.getDistancia / 1000));
  }

  public void conversionBytesaMBits(Arista arista1, Arista arista2){

    double conversion;
    conversion = (arista.getDatosControl() + arista.getDatosUsuario()) * 8;
    arista.setBits(conversion / Math.pow(1000, 2));
  }

  public double latencia(Nodo fin, Arista conexion){

    double latencia, aux;

    aux = (conexion.getDistancia() / 300000) + (conexion.getBits() / conexion.getVelocidad());
    latencia = (aux + fin.getTC()) * divisionPaquetes(arista1, arista2);
    return latencia;
  }

}
