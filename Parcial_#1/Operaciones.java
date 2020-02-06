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
      return;
    }
    if((arista1.getDatosUsuario() > arista2.getDatosUsuario())){
      paquete += Math.ceil(arista1.getDatosUsuario() / arista2.getDatosUsuario());
      arista2.setPaquetes(paquete);
    }
    if(paquete > 0)
      arista2.setPaquetes(paquete);
  }

  public void conversionMtaKt(Arista arista){

    arista.setDistancia((arista.getDistancia() / 1000));
  }

  public void conversionBytesaMBits(Arista arista){

    double conversion;

    conversion = (arista.getDatosControl() + arista.getDatosUsuario()) * 8;
    arista.setBits(conversion / Math.pow(1000, 2));
  }

  public double conversionGBytesaBytes(double giga){

    return (giga * Math.pow(1024, 3));
  }

  public String conversionSegAHr(double segundo){

    int horas, minutos, segundos;

    System.out.print("Tiempo: ");
    horas = (int)Math.floor(segundo / 3600);
    segundo -= (3600 * horas);
    minutos = (int)Math.floor(segundo / 60);
    segundo -= (60 * minutos);
    segundos = (int)Math.floor(segundo);
    return (String.valueOf(horas) + ":" + String.valueOf(minutos) + ":" + String.valueOf(segundos));
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

    aux = (conexion.getDistancia() / 300000) + (conexion.getBits() / conexion.getVelocidad());
    conexion.setLatencia((aux + conexion.getFin().getTiempoCola()) * conexion.getPaquetes());
  }

  public double cantidadPaquetes(Camino ruta){
    return ruta.getTamTransferencia() / ruta.getArista(0).getDatosUsuario();
  }

  public double tamanoTranferencia(Camino ruta){
    return ruta.getCantidadPaquetes() * ruta.getLatenciaTotal();
  }

}
