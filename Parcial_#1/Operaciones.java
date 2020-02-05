import java.util.*;

public class Operaciones{

  private double canPaquetes;

  public Operaciones(){

    this.canPaquetes = 0;
  }

  public void divisionPaquetes(Arista arista1, Arista arista2){

    double paquete = 0.0;

    if(arista1.getPaquetes() > 1)
      paquete = arista1.getPaquetes();
    if(arista2 == null){
      arista1.setPaquetes(paquete);
      System.out.println("Arista Paquetes " + arista1.getNombre());
      System.out.println("Paquetes " + arista1.getDatosUsuario());
      return;
    }
    System.out.println("Arista Paquetes " + arista1.getNombre() + " " + arista2.getNombre());
    System.out.println("Paquetes " + arista1.getDatosUsuario() + " " + arista2.getDatosUsuario());
    if((arista1.getDatosUsuario() > arista2.getDatosUsuario())){
      paquete += Math.ceil(arista1.getDatosUsuario() / arista2.getDatosUsuario());
      arista2.setPaquetes(paquete);
    }
    if(paquete > 0)
      arista2.setPaquetes(paquete);
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

  public double conversionGBytesaBytes(double giga){

    return (giga * Math.pow(1024, 3));
  }

  public double conversionSegAHr(double segundos){

    return ();
  }

  public void operacionesArista(Arista arista1, Arista arista2){

      conversionMtaKt(arista1);
      conversionBytesaMBits(arista1);
      if(arista2 != null)
        divisionPaquetes(arista1, arista2);
      else
        divisionPaquetes(arista1, null);
      latencia(arista1);

  }

  public void latencia(Arista conexion){

    double aux;

    System.out.println("Arista Latencia " + conexion.getNombre());
    aux = (conexion.getDistancia() / 300000) + (conexion.getBits() / conexion.getVelocidad());
    System.out.println("Aux: " + aux);
    System.out.println("Latencia " + ((aux + conexion.getFin().getTiempoCola()) * conexion.getPaquetes()));
    conexion.setLatencia((aux + conexion.getFin().getTiempoCola()) * conexion.getPaquetes());
  }

  public double cantidadPaquetes(Camino ruta){
    return ruta.getTamTransferencia() / ruta.getArista(0).getDatosUsuario();
  }

  public double tamanoTranferencia(Camino ruta){
    return ruta.getCantidadPaquetes() * ruta.getLatenciaTotal();
  }

}
