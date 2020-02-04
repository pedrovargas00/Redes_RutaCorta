import java.util.*;

public class Operaciones{

  private double paquetes;
  private double canPaquetes;

  public Operaciones(){

    this.paquetes = 0;
    this.canPaquetes = 0;
  }

  public void divisionPaquetes(Arista arista1, Arista arista2){

    if(arista1.getDatosUsuario() > arista2.getDatosUsuario())
      paquetes = Math.ceil(arista1.getDatosUsuario() / arista2.getDatosUsuario());
    paquetes = 1;
  }

  public void conversionMtaKt(Arista arista){

    arista.setDistancia((arista.getDistancia() / 1000));
  }

  public void conversionBytesaMBits(Arista arista){

    double conversion;

    conversion = (arista.getDatosControl() + arista.getDatosUsuario()) * 8;
    arista.setBits(conversion / Math.pow(1000, 2));
  }

  public double latencia(Nodo fin, Arista conexion){

    double aux;

    aux = (conexion.getDistancia() / 300000) + (conexion.getBits() / conexion.getVelocidad());
    return (aux + fin.getTiempoCola()) * paquetes;
  }

  public void cantidadPaquetes(double tamPaquetes, Arista arista){
    canPaquetes = tamPaquetes / arista.getDatosUsuario();
  }

  public double TamanoTranferencia(){
    return canPaquetes * 1.0;
  }

}
