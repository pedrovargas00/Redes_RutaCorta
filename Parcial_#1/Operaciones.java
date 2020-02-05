import java.util.*;

public class Operaciones{

  private double canPaquetes;

  public Operaciones(){

    this.canPaquetes = 0;
  }

  public void divisionPaquetes(Arista arista1, Arista arista2){

    if(arista2 == null)
      return;
    System.out.println("Arista Paquetes " + arista1.getNombre() + " " + arista2.getNombre());
    System.out.println("Paquetes " + arista1.getDatosUsuario() + " " + arista2.getDatosUsuario());
    if(arista1.getDatosUsuario() > arista2.getDatosUsuario())
      arista2.setPaquetes(Math.ceil(arista1.getDatosUsuario() / arista2.getDatosUsuario()));
    System.out.println("Paquetes " + arista1.getPaquetes());
    System.out.println("Paquetes " + arista2.getPaquetes());
  }

  public void conversionMtaKt(Arista arista){

    System.out.println("Arista MtaKt " + arista.getNombre());
    arista.setDistancia((arista.getDistancia() / 1000));
    System.out.println("Distancia " + arista.getDistancia());
  }

  public void conversionBytesaMBits(Arista arista){

    double conversion;

    System.out.println("Arista BaMB " + arista.getNombre());
    conversion = (arista.getDatosControl() + arista.getDatosUsuario()) * 8;
    arista.setBits(conversion / Math.pow(1000, 2));
    System.out.println("Bits " + arista.getBits());
  }

  public void latencia(Arista conexion){

    double aux;

    System.out.println("Arista Latencia " + conexion.getNombre());
    aux = (conexion.getDistancia() / 300000) + (conexion.getBits() / conexion.getVelocidad());
    System.out.println("Aux: " + aux);
    System.out.println("Latencia " + ((aux + conexion.getFin().getTiempoCola()) * conexion.getPaquetes()));
    conexion.setLatencia((aux + conexion.getFin().getTiempoCola()) * conexion.getPaquetes());
  }

  public void cantidadPaquetes(double tamPaquetes, Arista arista){
    canPaquetes = tamPaquetes / arista.getDatosUsuario();
  }

  public double TamanoTranferencia(){
    return canPaquetes * 1.0;
  }

}
